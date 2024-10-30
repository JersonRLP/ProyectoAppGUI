package capa_logica;



import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import entidad.Producto;
import interfaces.InterfaceProducto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import capa_datos.MySQLConexion;
import util.Utilidades;


public class ClsProducto implements InterfaceProducto  {
	Utilidades objUtil=new Utilidades();
	
	public int RegistrarProducto(Producto pro) {
		int salida=-1;
		//Declarar un objeto de tipo Connection
		Connection cn=null;
		//Declarar un objeto de tipo Callable
		CallableStatement cstm=null;
		try {
			//Primero  vamos a invocar la conexion de BD
			cn=MySQLConexion.miConexion();//ok
			cstm=cn.prepareCall("{call SP_REGISTRAR_PRODUCTO(?,?,?,?,?,?,?,?,?,?,?)}");
			
			// setear los datos obtenidos de la memoria
			//a cada parametro
			cstm.setString(1,pro.getID_PRODUCTO());
			cstm.setString(2,pro.getNOMPRODUCTO());
			cstm.setString(3, pro.getPANTALLA());
			cstm.setString(4, pro.getCAMARA());
			cstm.setString(5, pro.getMEMORIA_RAM());
			cstm.setString(6, pro.getBATERIACEL());
			cstm.setString(7, pro.getMEMORIA_INTERNA());
			cstm.setString(8, pro.getFECHA_LANZAMIENTO());
			cstm.setDouble(9, pro.getPRECIO_VENTA());
			cstm.setInt(10,pro.getSTOCK_ACTUAL());
			cstm.setString(11,pro.getCOD_MARCA());
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

	public int ActualizarProducto(Producto pro) {
		int salida=-1;

		//Declarar un objeto de tipo Connection

		Connection cn=null;

		//Declarar un objeto de tipo CSTM

		CallableStatement cstm=null;

		try {

			//Primero vamos a invocar la conexion de BD

			cn=MySQLConexion.miConexion();//ok

			cstm=cn.prepareCall("{call SP_ACTUALIZAR_PRODUCTO(?,?,?,?,?,?,?,?,?,?,?)}");
			//setear los datos obtenidos de la memoria

			//a cada parametro

			cstm.setString(1,pro.getID_PRODUCTO());
			cstm.setString(2, pro.getNOMPRODUCTO());
			cstm.setString(3, pro.getPANTALLA());
			cstm.setString(4, pro.getCAMARA());
			cstm.setString(5, pro.getMEMORIA_RAM());
			cstm.setString(6, pro.getBATERIACEL());
			cstm.setString(7, pro.getMEMORIA_INTERNA());
			cstm.setString(8, pro.getFECHA_LANZAMIENTO());
			cstm.setDouble(9, pro.getPRECIO_VENTA());
			cstm.setInt(10,pro.getSTOCK_ACTUAL());
			cstm.setString(11,pro.getCOD_MARCA());			

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

	public int EliminarProducto(Producto pro) {
		int salida=-1;
		//Declarar un objeto de tipo Connection
		Connection cn=null;
		//Declarar un objeto de tipo Callable
		CallableStatement cstm=null;
		try {
			//Primero  vamos a invocar la conexion de BD
			cn=MySQLConexion.miConexion();//ok
			cstm=cn.prepareCall("{call SP_ELIMINAR_PRODUCTO(?)}");
			
			// setear los datos obtenidos de la memoria
			//a cada parametro
			cstm.setString(1,pro.getID_PRODUCTO());

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

	public void ListadoProductos(DefaultTableModel modelo, String[] misdatos, JTextField busca) {
		//Declarar un objeto para la conexion
		Connection cn=null;
		//Declarar un objeto para manipular el objeto procedimiento almacenado
		 CallableStatement cstm=null;
		//Declarar un objeto para los registros
		ResultSet rs=null;
		try {
			  objUtil.limpiarModeloTabla(modelo);					
			cn=MySQLConexion.miConexion();				
		    cstm=cn.prepareCall("{call SP_BUSCAR_PRODUCTO(?)}");
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
			misdatos[5]=rs.getString(6);
			misdatos[6]=rs.getString(7);
			misdatos[7]=rs.getString(8);
			misdatos[8]=rs.getString(9);
			misdatos[9]=rs.getString(10);
			misdatos[10]=rs.getString(11);
			
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
