package interfaces;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entidad.Empleado;

public interface InterfaceEmpleado {
	public int RegistrarEmpleado(Empleado E);
	public int ActualizarEmpleado(Empleado E);
	public int EliminarEmpleado(Empleado E);
	public void ListadoEmpleado(DefaultTableModel modelo, String[]misdatos,JTextField busca);
	
}
