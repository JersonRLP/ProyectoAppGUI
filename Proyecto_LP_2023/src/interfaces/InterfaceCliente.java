package interfaces;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entidad.Cliente;

public interface InterfaceCliente {
//para que sirve...
	//implementar metodos, sin cuerpo
	//Metodo para registrar un cliente
		public int RegistrarCliente(Cliente clie);
		//Metodo para actualizar los datos del cliente
		public int ActualizarCliente(Cliente clie);
		//Metodo para eliminar un cliente
		public int EliminarCliente(Cliente clie);
		
		//Metodo para listar los datos de los clientes
		public void listadoClientes(DefaultTableModel modelo, String []misdatos, JTextField buscame);
		

}
