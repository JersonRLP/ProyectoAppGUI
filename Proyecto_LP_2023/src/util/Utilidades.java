package util;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.sql.CallableStatement;
import com.toedter.calendar.JDateChooser;
import capa_datos.MySQLConexion;
import entidad.Producto;

public class Utilidades {
	public static String miSQL="";

	public static String leerFecha(JDateChooser fe){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(fe.getDate());
	}
	
	public void limpiarModeloTabla(DefaultTableModel modelo){
		while(modelo.getRowCount()>0)
			modelo.removeRow(0);
	}
	
	
	//Metodo para listar los distritos
	public void listadoDistritos(JComboBox<String>lista){
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySQLConexion.miConexion();
			miSQL="Select * from distrito";
			pstm=cn.prepareStatement(miSQL);
			rs=pstm.executeQuery();
			while(rs.next()){
				lista.addItem(rs.getString("NOM_DISTRITO"));
			}
			
		} catch (Exception e) {
          e.printStackTrace();
		}
		
	}
	
	//Metodo para mostrar codigo de distrito en base al nombre
	//seleccionado en el combo
	public static String buscarCodigoDistrito(String nomdis){
		String coddis="";
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySQLConexion.miConexion();
			miSQL="select * from distrito where nom_distrito='"+nomdis+"'";
			pstm=cn.prepareStatement(miSQL);
			rs=pstm.executeQuery();
			while(rs.next()){
				coddis=rs.getString("cod_distrito");
			}
			return coddis; 
			
		} catch (Exception e) {
			return "";
		}
	}
	
	public void listadoMarca(JComboBox<String>lista){
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MySQLConexion.miConexion();
			cstm= cn.prepareCall("{call SP_LISTAR_MARCACEL()}");
			
			rs=cstm.executeQuery();
			while(rs.next()){
				lista.addItem(rs.getString("NOM_CATEG"));
			}
			
		} catch (Exception e) {
          e.printStackTrace();
		}
		
	}
	
	//METODO PÁRA OBTENER EL CODIGO DE CATEGORIA 
	//EN BASE AL NOMBRE SELECCIONADO
	public static String buscarCodigoMARCA(String nonmarca){
		String codcate="";
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MySQLConexion.miConexion();
			cstm= cn.prepareCall("{call SP_MOSTRAR_CODIGO_MARCACEL(?)}");
			cstm.setString(1,nonmarca);
			rs=cstm.executeQuery();
			while(rs.next()){
				codcate=rs.getString("COD_MARCACEL");
			}
			return codcate; 
			
		} catch (Exception e) {
			return "";
		}
	}
	
	public void listadoAutor(JComboBox<String>lista){
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MySQLConexion.miConexion();
			cstm= cn.prepareCall("{call SP_LISTAR_AUTOR()}");
			
			rs=cstm.executeQuery();
			while(rs.next()){
				lista.addItem(rs.getString("NOMAUTOR"));
			}
			
		} catch (Exception e) {
          e.printStackTrace();
		}
		
	}
	public void listadoGenero(JComboBox<String>lista){
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MySQLConexion.miConexion();
			cstm= cn.prepareCall("{call SP_LISTAR_GENERO()}");
			
			rs=cstm.executeQuery();
			while(rs.next()){
				lista.addItem(rs.getString("NOMBREGENERO"));
			}
			
		} catch (Exception e) {
          e.printStackTrace();
		}
	}
	
	public static String buscarCodigoAutor(String nomautor){
		String codautor="";
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MySQLConexion.miConexion();
			cstm= cn.prepareCall("{call SP_MOSTRAR_CODIGO_AUTOR(?)}");
			cstm.setString(1,nomautor);
			rs=cstm.executeQuery();
			while(rs.next()){
				codautor=rs.getString("CODAUTOR");
			}
			return codautor; 
			
		} catch (Exception e) {
			return "";
		}
	}
	
	public static String buscarCodigoGenero(String nomgenero){
		String codg="";
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MySQLConexion.miConexion();
			cstm= cn.prepareCall("{call SP_MOSTRAR_CODIGO_GENERO(?)}");
			cstm.setString(1,nomgenero);
			rs=cstm.executeQuery();
			while(rs.next()){
				codg=rs.getString("CODGENERO");
			}
			return codg; 
			
		} catch (Exception e) {
			return "";
		}
	}
	
	//metodos para listar los datos de los clientes en la ventana 
	//Boleto de Venta
	public void ListadoDatosClientes(DefaultTableModel modelo, String[] misdatos, JTextField busca) {
		//Declarar un objeto para la conexion
		Connection cn=null;
		//Declarar un objeto para manipular el PA
		 CallableStatement cstm=null;
		//Declarar un objeto para los registros
		ResultSet rs=null;
		try {
			  limpiarModeloTabla(modelo);					
			cn=MySQLConexion.miConexion();				
		    cstm=cn.prepareCall("{call SP_CONSULTAR_CLIENTE_CODIGO_APE(?)}");
		    cstm.setString(1, busca.getText()+'%');
		//cuarto vamos a ejecutar pstm
		rs=cstm.executeQuery();
		//vamos a realizar el recorrido uno por uno
		while(rs.next()){
			misdatos[0]=rs.getString(1);
			misdatos[1]=rs.getString(2);
			misdatos[2]=rs.getString(3);
			misdatos[3]=rs.getString(4);
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
	
	//Metodo para listar los productos en base a la categoria y descripcion



	public void ListadoDatosProductos(DefaultTableModel modelo, String[] misdatos, JComboBox<String> cate, JTextField busca) {

		//Declarar un objeto para la conexion

			Connection cn=null;

			//Declarar un objeto para manipular el PA

			 CallableStatement cstm=null;

			//Declarar un objeto para los registros

			ResultSet rs=null;

			try {

				 limpiarModeloTabla(modelo);					

				cn=MySQLConexion.miConexion();				

			  cstm=cn.prepareCall("{call SP_CONSULTAR_PRODUCTO_MARCA_NOMBRE(?,?)}");

			  cstm.setString(1, cate.getSelectedItem().toString());

			  cstm.setString(2, busca.getText()+'%');

			//cuarto vamos a ejecutar pstm

			rs=cstm.executeQuery();

			//vamos a realizar el recorrido uno por uno

			while(rs.next()){

				misdatos[0]=rs.getString(1);

				misdatos[1]=rs.getString(2);

				misdatos[2]=rs.getString(3);

				misdatos[3]=rs.getString(4);

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
	public static String FechaActual(){

		Date fecha=new Date();

		SimpleDateFormat sdf=new SimpleDateFormat("YYYY/MM/dd");

		return sdf.format(fecha);

		}
	
	//codigo para generar numero de boleta

	public ResultSet GenerarNumeroBoleta()throws Exception{

		Connection cn=null;

		CallableStatement cstm=null;

		cn=MySQLConexion.miConexion();

		cstm=cn.prepareCall("{call SP_GENERAR_NUMEROBOLETA()}");

		ResultSet rs=cstm.executeQuery();

		return rs;

	}
	
	public void ConsProductosVendidos(DefaultTableModel modelo, String[] misdatos, JComboBox pro) {

		//Declarar un objeto para la conexion

			Connection cn=null;

			//Declarar un objeto para manipular el PA

			 CallableStatement cstm=null;

			//Declarar un objeto para los registros

			ResultSet rs=null;

			try {

				 limpiarModeloTabla(modelo);					

				cn=MySQLConexion.miConexion();				

			  cstm=cn.prepareCall("{call SP_CANTIDAD_VECES_VENDIDOS(?)}");

			  cstm.setString(1, pro.getSelectedItem().toString());

			

			//cuarto vamos a ejecutar pstm

			rs=cstm.executeQuery();

			//vamos a realizar el recorrido uno por uno

			while(rs.next()){

				misdatos[0]=rs.getString(1);

				misdatos[1]=rs.getString(2);

				misdatos[2]=rs.getString(3);		

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
	
	public void listadoProductosxnombre(JComboBox<String>lis){

		Connection cn=null;

		CallableStatement cstm=null;

		ResultSet rs=null;

		try {

			cn=MySQLConexion.miConexion();

		  cstm=cn.prepareCall("{CALL SP_LISTAR_PRODUCTOSXNOMBRE()}");

			rs=cstm.executeQuery();

			while(rs.next()){

				lis.addItem(rs.getString("NOMPRODUCTO"));

			}

			

		} catch (Exception e) {

	e.printStackTrace();

		}

	}
	public void ConsVentasxCliente(DefaultTableModel modelo, String[] misdatos, JComboBox cl) {

		//Declarar un objeto para la conexion

			Connection cn=null;

			//Declarar un objeto para manipular el PA

			 CallableStatement cstm=null;

			//Declarar un objeto para los registros

			ResultSet rs=null;

			try {

				 limpiarModeloTabla(modelo);					

				cn=MySQLConexion.miConexion();				

			  cstm=cn.prepareCall("{call SP_VENTAS_x_Cliente(?)}");

			  cstm.setString(1, cl.getSelectedItem().toString());

			

			//cuarto vamos a ejecutar pstm

			rs=cstm.executeQuery();

			//vamos a realizar el recorrido uno por uno

			while(rs.next()){

				misdatos[0]=rs.getString(1);

				misdatos[1]=rs.getString(2);

				misdatos[2]=rs.getString(3);

				misdatos[3]=rs.getString(4);		

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
	

	public void listadoClientes(JComboBox<String>lis){

		Connection cn=null;

		CallableStatement cstm=null;

		ResultSet rs=null;

		try {

			cn=MySQLConexion.miConexion();

		  cstm=cn.prepareCall("{CALL SP_LISTAR_CLIENTES()}");

			rs=cstm.executeQuery();

			while(rs.next()){

				lis.addItem(rs.getString("APELLIDOS"));

			}

		} catch (Exception e) {

	e.printStackTrace();

		}

	}
	
	
	
	public void listadoProductosStock(DefaultTableModel modelo, String[] misdatos){

		Connection cn=null;

		//Declarar un objeto para manipular el PA

		 CallableStatement cstm=null;

		//Declarar un objeto para los registros

		ResultSet rs=null;

		try {

			 limpiarModeloTabla(modelo);					

			cn=MySQLConexion.miConexion();				

			 cstm=cn.prepareCall("{CALL SP_LISTAR_STOCK_P()}");

				rs=cstm.executeQuery();

		

	

		//vamos a realizar el recorrido uno por uno

		while(rs.next()){

			misdatos[0]=rs.getString(1);

			misdatos[1]=rs.getString(2);	

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
	
	
	
	public void ActualizarStock(JTable tabla){
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		
		try {				
			 cn=MySQLConexion.miConexion();				
			 cstm=cn.prepareCall("{call SP_ACTUALIZAR_STOCK(?,?)}");

			for(int i=0;i<tabla.getRowCount();i++) {
				cstm.setString(1, tabla.getValueAt(i, 0).toString());
				cstm.setInt(2, Integer.parseInt(tabla.getValueAt(i, 3).toString()));
				rs=cstm.executeQuery();
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
