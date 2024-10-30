package capa_logica;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import capa_datos.MySQLConexion;
import entidad.Empleado;
import interfaces.InterfaceEmpleado;
import util.Utilidades;

public class ClsEmpleado implements InterfaceEmpleado{

	Utilidades objUtil=new Utilidades();
	
	public int RegistrarEmpleado(Empleado E) {
		int salida=-1;
		//Declarar un objeto de tipo Connection
		Connection cn=null;
		//Declarar un objeto de tipo Callable
		CallableStatement cstm=null;
		try {
			//Primero  vamos a invocar la conexion de BD
			cn=MySQLConexion.miConexion();//ok
			cstm=cn.prepareCall("{call SP_REGISTRAR_EMPLEADO(?,?,?,?,?)}");
			
			// setear los datos obtenidos de la memoria
			//a cada parametro
			cstm.setString(1,E.getDNI());
			cstm.setString(2,E.getNOMEMPLE());
			cstm.setString(3,E.getAPEMPLE());
			cstm.setString(4,E.getCOD_DIS());
			cstm.setString(5,E.getCARGO());
			
			//ejecutar cstm y luego enviar 
			//el  resultado a la variable salida
			salida=cstm.executeUpdate();
					
		} catch (Exception e) {
			e.getMessage();
		}
		
		finally {
			try {
				if(cstm!=null)cstm.close();
				if(cn!=null)cn.close();
			} catch (Exception e2) {

			}
		}
		
		
		return salida;
	}

	public int ActualizarEmpleado(Empleado E) {
		int salida=-1;

		//Declarar un objeto de tipo Connection

		Connection cn=null;

		//Declarar un objeto de tipo CSTM

		CallableStatement cstm=null;

		try {

			//Primero vamos a invocar la conexion de BD

			cn=MySQLConexion.miConexion();//ok
			cstm=cn.prepareCall("{call SP_ACTUALIZAR_EMPLEADO(?,?,?,?,?)}");
			//setear los datos obtenidos de la memoria

			//a cada parametro
			cstm.setString(1, E.getDNI());
			cstm.setString(2,E.getNOMEMPLE());

			cstm.setString(3, E.getAPEMPLE());
			
			cstm.setString(4, E.getCOD_DIS());

			cstm.setString(5, E.getCARGO());

			

		

			// ejecutar cstm y luego enviar 

			//el resultado a la variable salida

			salida=cstm.executeUpdate();

					

		} catch (Exception e) {

			e.getMessage();

		}

		

		finally {

			try {

				if(cstm!=null)cstm.close();

				if(cn!=null)cn.close();

			} catch (Exception e2) {



			}

		}
		return salida;
	}

	public int EliminarEmpleado(Empleado E) {
		int salida=-1;
		
		Connection cn=null;
		
		CallableStatement cstm=null;
		try {
			
			cn=MySQLConexion.miConexion();//ok
			cstm=cn.prepareCall("{call SP_ELIMINAR_EMPLEADO(?)}");
			
			
			cstm.setString(1,E.getDNI());

			 
			
			salida=cstm.executeUpdate();
					
		} catch (Exception e) {
			e.getMessage();
		}
		
		finally {
			try {
				if(cstm!=null)cstm.close();
				if(cn!=null)cn.close();
			} catch (Exception e2) {

			}
		}
		
		
		return salida;
	}

	public void ListadoEmpleado(DefaultTableModel modelo, String[] misdatos, JTextField busca) {
		Connection cn=null;
		//Declarar un objeto para manipular el objeto procedimiento almacenado
		 CallableStatement cstm=null;
		//Declarar un objeto para los registros
		ResultSet rs=null;
		try {
			  objUtil.limpiarModeloTabla(modelo);					
			cn=MySQLConexion.miConexion();				
		    cstm=cn.prepareCall("{call SP_BUSCAR_EMPLEADO(?)}");
		    cstm.setString(1, busca.getText()+'%');
		//cuarto vamos a ejecutar pstm
		rs=cstm.executeQuery();
		//vamos a realizar el recorrido uno por uno
		while(rs.next()){
			misdatos[0]=rs.getString(1);
			misdatos[1]=rs.getString(2);
			misdatos[2]=rs.getString(3);
			misdatos[3]=rs.getString(4);
			misdatos[4]=rs.getString(5);
			
			
			
			//Agregandos los datos al modelo
			modelo.addRow(misdatos);
		}
		
		
		} catch (Exception e) {
			System.out.println("Error en la sentencia...."+e.getMessage());
		}
		
		finally {
			try {
				if(rs!=null)rs.close();
				if(cstm!=null)cstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {

			}
		}


		
	}
		
	

}
