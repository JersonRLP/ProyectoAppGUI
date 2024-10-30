package interfaces;
import entidad.Producto;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public interface InterfaceProducto {
	
	public int RegistrarProducto(Producto pro);
	public int ActualizarProducto(Producto pro);
	public int EliminarProducto(Producto pro);
	public void ListadoProductos(DefaultTableModel modelo, String[]misdatos,JTextField busca);
	
	
}

