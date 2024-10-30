package capa_logica;

import entidad.Cliente;
import interfaces.InterfaceCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import util.Utilidades;

import capa_datos.MySQLConexion;
public class ClsCliente implements InterfaceCliente{

	//Declarar y crear un objeto haciendo referencia
	//a la clase Utilidade
	Utilidades objUtil=new  Utilidades();
	
	public static String sql="";
	
	
	public int RegistrarCliente(Cliente clie) {
		
		//Declarar una variable para controlar exito o fracaso
		//del registro de datos....exito 1...fracaso 0
		int salida=-1;
		//Declarar un objeto de tipo Connection
		Connection cn=null;
		//Declarar un objeto de tipo PreparedStament
		PreparedStatement pstm=null;
		try {
			//Primero  vamos a invocar la conexion de BD
			cn=MySQLConexion.miConexion();//ok
			//segundo preparar  la sentencia insert into
			sql="insert into cliente values(?,?,?,?,?,?,?,?)";
			//tercero vamos guardar la conexion y el 
			//valor de sql en pstm
			pstm=cn.prepareStatement(sql);
			//cuarto setear los datos obtenidos de la memoria
			//a cada parametro
			pstm.setInt(1, clie.getCODIGO());
			pstm.setString(2, clie.getNOMBRES());
			pstm.setString(3, clie.getAPELLIDOS());
			pstm.setDouble(4, clie.getING_MENSUAL());
			pstm.setString(5, clie.getCORREO());
			pstm.setInt(6, clie.getEDAD());
			pstm.setString(7, clie.getFECHA_NAC());
			pstm.setString(8, clie.getCOD_DIS());
			//quinto ejecutar pstm y luego enviar 
			//el  resultado a la variable salida
			salida=pstm.executeUpdate();
					
		} catch (Exception e) {
			e.getMessage();
		}
		
		finally {
			try {
				if(pstm!=null)pstm.close();
				if(cn!=null)cn.close();
			} catch (Exception e2) {

			}
		}
		
		
		return salida;
	}

	
	public int ActualizarCliente(Cliente clie) {
		int salida=-1;
		
				//Declarar un objeto de tipo Connection
				Connection cn=null;
				//Declarar un objeto de tipo PreparedStament
				PreparedStatement pstm=null;
		try {
			//Primero  vamos a invocar la conexion de BD
			cn=MySQLConexion.miConexion();//ok
			//segundo preparar  la sentencia update
			sql="update cliente set nombres=?, apellidos=?,ing_mensual=?,correo=?,edad=?,fecha_nac=?,cod_dis=? where codigo=?";
			
			//tercero vamos guardar la conexion y el 
			//valor de sql en pstm
			pstm=cn.prepareStatement(sql);
			//cuarto setear los datos obtenidos de la memoria
			//a cada parametro
			pstm.setString(1, clie.getNOMBRES());
			pstm.setString(2, clie.getAPELLIDOS());
			pstm.setDouble(3, clie.getING_MENSUAL());
			pstm.setString(4, clie.getCORREO());
			pstm.setInt(5, clie.getEDAD());
			pstm.setString(6, clie.getFECHA_NAC());
			pstm.setString(7, clie.getCOD_DIS());
			pstm.setInt(8, clie.getCODIGO());
			//quinto ejecutar pstm y luego enviar 
			//el  resultado a la variable salida
			salida=pstm.executeUpdate();
						
		} catch (Exception e) {
			System.out.println("Error..."+e.getMessage());
		}		
		
		finally {
			try {
				if(pstm!=null)pstm.close();
				if(cn!=null)cn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}

			
		}
		return salida;
	}

	
	public int EliminarCliente(Cliente clie) {
		
		int salida=-1;
		
		//Declarar un objeto de tipo Connection
		Connection cn=null;
		//Declarar un objeto de tipo PreparedStament
		PreparedStatement pstm=null;
try {
	//Primero  vamos a invocar la conexion de BD
	cn=MySQLConexion.miConexion();//ok
	//segundo preparar  la sentencia delete
	sql="delete from cliente where codigo=?";
	
	//tercero vamos guardar la conexion y el 
	//valor de sql en pstm
	pstm=cn.prepareStatement(sql);
	//cuarto setear los datos obtenidos de la memoria
	//a cada parametro
		pstm.setInt(1, clie.getCODIGO());//99999
	//quinto ejecutar pstm y luego enviar 
	//el  resultado a la variable salida
	salida=pstm.executeUpdate();
				
} catch (Exception e) {
	System.out.println("Error..."+e.getMessage());
}		

finally {
	try {
		if(pstm!=null)pstm.close();
		if(cn!=null)cn.close();
	} catch (Exception e2) {
		// TODO: handle exception
	}

	
}
return salida;
		

		
	}

	public void listadoClientes(DefaultTableModel modelo, String[] misdatos, JTextField buscame) {
	//primero declarar un objeto para la conexion
		Connection cn=null;
	//segundo declara un objeto pstm para manipular
		//la tabla
		PreparedStatement pstm=null;
		//tercero declara ub objeto para los registros
		ResultSet rs=null;
		try {
			 objUtil.limpiarModeloTabla(modelo);
			//1 invocar la conexion
			cn=MySQLConexion.miConexion();//ok
			//2 preparar select
	sql="SELECT C.CODIGO,C.NOMBRES,C.APELLIDOS,C.ING_MENSUAL,C.CORREO,C.EDAD,C.FECHA_NAC,D.NOM_DISTRITO FROM CLIENTE C INNER JOIN DISTRITO D ON C.COD_DIS=D.COD_DISTRITO where (codigo like'"+buscame.getText()+"%' "
			+ "or apellidos like'"+buscame.getText()+"%' )order by codigo";
	       //3 cargar a pstm la conexion y el sql
	      pstm=cn.prepareStatement(sql);//ok
	      //4 enviar los datos a rs
	      rs=pstm.executeQuery();
	    //5 realizar recorrido uno por uno en los registros
	        while(rs.next()){
	        	misdatos[0]=rs.getString(1);
	        	misdatos[1]=rs.getString(2);
	        	misdatos[2]=rs.getString(3);
	        	misdatos[3]=rs.getString(4);
	        	misdatos[4]=rs.getString(5);
	        	misdatos[5]=rs.getString(6);
	        	misdatos[6]=rs.getString(7);
	        	misdatos[7]=rs.getString(8);
	        	//agregando el registro uno por uno al modelo
	        	modelo.addRow(misdatos);
	        }
	
		} catch (Exception e) {
			System.out.println("Error en la sentencia.."+e.getMessage());
		}
			finally {
			try {
				if(rs!=null)rs.close();
				if(pstm!=null)pstm.close();
				if(cn!=null)cn.close();
			} catch (Exception e2) {
				System.out.println("error..."+e2.getMessage());
			}
			}
		
		
		
	}

	

	
	
	
}
