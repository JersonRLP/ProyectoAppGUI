package capa_datos;

//importando librerias necesarias para la conección a  MySQL

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;	

public class MySQLConexion {
	//Método de tipo static para obtener la conexión de la BD
	
	public static Connection miConexion(){
		//Creando una variable para la clase conexión
		Connection cn=null;
		try {
			//primero debemos reconocer el driver de mysql
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			//Obtener la cadena de conexion
			String cadena="jdbc:mysql://localhost/MOVILEXPRESS?useTimezone=true&serverTimezone=UTC";
			//identificando el usuario
			String usuario="root";
			//Identificando el password
			String pwd="";	
			//Asignar a la variable cone la cadena de conexion
			cn=DriverManager.getConnection(cadena,usuario,pwd);
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error del Driver...no adicionado");
		}catch (SQLException e) {
			System.out.println("Error de conexion a la BD");
	
		}catch (Exception e) {
			System.out.println("Error..."+e.getMessage());
		}
		
		return cn;
	}//fin del método
}
