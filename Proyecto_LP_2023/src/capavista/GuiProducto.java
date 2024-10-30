package capavista;


import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import capa_logica.ClsProducto;
import entidad.Producto;

import java.awt.Font;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import util.Utilidades;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.InternalFrameListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.MouseEvent;

public class GuiProducto extends JInternalFrame implements ActionListener, InternalFrameListener, KeyListener, MouseListener {
	String estado="";
	ClsProducto objP=new ClsProducto();
	Utilidades objU = new Utilidades();
	DefaultTableModel tablapro;
	Date fe=new Date();
	String misdatos[]=new String[11];
	Producto p ;
	public static String pro;
	private JLabel lblCodigo;
	private JLabel lblPantalla;
	private JLabel lblCamara;
	private JLabel lblMemoriaRam;
	private JLabel lblBateria;
	private JLabel lblMemoriaInterna;
	private JLabel lblFechaLanzamiento;
	private JLabel lblPrecioVenta;
	private JLabel lblStock;
	private JLabel lblMarca;
	private JComboBox cboMarca;
	private JTextField txtPantalla;
	private JTextField txtCamara;
	private JTextField txtMemoriaRAM;
	private JTextField txtBateria;
	private JTextField txtMemoriaInterna;
	private JTextField txtPrecioVenta;
	private JTextField txtStock;
	private JDateChooser dtfecha;
	private JTextField txtCodigo;
	private JScrollPane scrollPane;
	private JTable tblproducto;
	private JButton btnNuevo;
	private JButton btnGrabar;
	private JButton btnCancelar;
	private JButton btnEliminar;
	private JButton btnCerrar;
	private JLabel lblBuscar;
	private JTextField txtbuscar;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblcodmarca;
	private JCheckBox checkEditar;
	private JLabel lblNewLabel;
	private JTextField txtnomProducto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiProducto frame = new GuiProducto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiProducto() {
		setTitle("Mantenimiento Celulares");
		
		addInternalFrameListener(this);
		pro="pro";
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 869, 633);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 370, 833, 227);
		getContentPane().add(scrollPane);
		
		tblproducto = new JTable();
		tblproducto.addMouseListener(this);
		scrollPane.setViewportView(tblproducto);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "MOVILESS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "MOV ILESS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 389, 353);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblcodmarca = new JLabel("");
		lblcodmarca.setBounds(305, 331, 46, 14);
		panel.add(lblcodmarca);
		
		checkEditar = new JCheckBox("Editar");
		checkEditar.addActionListener(this);
		checkEditar.setBounds(254, 19, 97, 23);
		panel.add(checkEditar);
		
		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(20, 331, 46, 14);
		panel.add(lblMarca);
		
		cboMarca = new JComboBox();
		cboMarca.setBounds(129, 325, 166, 20);
		panel.add(cboMarca);
		
		txtStock = new JTextField();
		txtStock.setBounds(129, 294, 166, 20);
		panel.add(txtStock);
		txtStock.setColumns(10);
		
		txtPrecioVenta = new JTextField();
		txtPrecioVenta.setBounds(129, 263, 166, 20);
		panel.add(txtPrecioVenta);
		txtPrecioVenta.setColumns(10);
		
		lblStock = new JLabel("Stock");
		lblStock.setBounds(20, 300, 46, 14);
		panel.add(lblStock);
		
		lblPrecioVenta = new JLabel("Precio Venta");
		lblPrecioVenta.setBounds(10, 266, 94, 14);
		panel.add(lblPrecioVenta);
		
		dtfecha = new JDateChooser();
		dtfecha.setDateFormatString("yyyy-MM-dd");
		dtfecha.setBounds(129, 230, 250, 20);
		panel.add(dtfecha);
		
		lblFechaLanzamiento = new JLabel("Fecha Lanzamiento");
		lblFechaLanzamiento.setBounds(10, 241, 106, 14);
		panel.add(lblFechaLanzamiento);
		
		txtMemoriaInterna = new JTextField();
		txtMemoriaInterna.setBounds(129, 199, 250, 20);
		panel.add(txtMemoriaInterna);
		txtMemoriaInterna.setColumns(10);
		
		lblMemoriaInterna = new JLabel("Memoria Interna");
		lblMemoriaInterna.setBounds(10, 202, 106, 14);
		panel.add(lblMemoriaInterna);
		
		txtBateria = new JTextField();
		txtBateria.setBounds(129, 171, 250, 20);
		panel.add(txtBateria);
		txtBateria.setColumns(10);
		
		lblBateria = new JLabel("Bateria");
		lblBateria.setBounds(10, 174, 46, 14);
		panel.add(lblBateria);
		
		txtMemoriaRAM = new JTextField();
		txtMemoriaRAM.setBounds(129, 140, 250, 20);
		panel.add(txtMemoriaRAM);
		txtMemoriaRAM.setColumns(10);
		
		lblMemoriaRam = new JLabel("Memoria ram");
		lblMemoriaRam.setBounds(10, 143, 83, 14);
		panel.add(lblMemoriaRam);
		
		txtCamara = new JTextField();
		txtCamara.setBounds(129, 113, 250, 20);
		panel.add(txtCamara);
		txtCamara.setColumns(10);
		
		txtPantalla = new JTextField();
		txtPantalla.setBounds(129, 82, 250, 20);
		panel.add(txtPantalla);
		txtPantalla.setColumns(10);
		
		lblCamara = new JLabel("Camara");
		lblCamara.setBounds(10, 116, 46, 14);
		panel.add(lblCamara);
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 23, 46, 14);
		panel.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(129, 20, 92, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		lblNewLabel = new JLabel("NombreProducto");
		lblNewLabel.setBounds(10, 51, 83, 14);
		panel.add(lblNewLabel);
		
		lblPantalla = new JLabel("Pantalla");
		lblPantalla.setBounds(10, 85, 46, 14);
		panel.add(lblPantalla);
		
		txtnomProducto = new JTextField();
		txtnomProducto.setBounds(129, 51, 250, 20);
		panel.add(txtnomProducto);
		txtnomProducto.setColumns(10);
		cboMarca.addActionListener(this);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(505, 24, 89, 23);
		getContentPane().add(btnNuevo);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(505, 54, 89, 23);
		getContentPane().add(btnGrabar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(505, 82, 89, 23);
		getContentPane().add(btnCancelar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(505, 113, 89, 23);
		getContentPane().add(btnEliminar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(505, 147, 89, 23);
		getContentPane().add(btnCerrar);
		
		panel_1 = new JPanel();
		panel_1.setBounds(472, 11, 207, 184);
		getContentPane().add(panel_1);
		
		panel_2 = new JPanel();
		panel_2.setBounds(435, 199, 270, 96);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		txtbuscar = new JTextField();
		txtbuscar.setBounds(26, 54, 219, 20);
		panel_2.add(txtbuscar);
		txtbuscar.addKeyListener(this);
		txtbuscar.setColumns(10);
		
		lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setBounds(108, 28, 63, 14);
		panel_2.add(lblBuscar);
		crearEncabezado();
		listarMarca();
		deshabilitarControles();
		listarProductos();
	}
	
	
	
	
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == checkEditar) {
			actionPerformedCheckEditar(arg0);
		}
		if (arg0.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(arg0);
		}
		if (arg0.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(arg0);
		}
		if (arg0.getSource() == cboMarca) {
			actionPerformedCboMarca(arg0);
		}
	}
	
	protected void actionPerformedCboMarca(ActionEvent arg0) {
		lblcodmarca.setText(Utilidades.buscarCodigoMARCA(cboMarca.getSelectedItem().toString()));
		
	}
		
		
	
	
	
	
	public void internalFrameActivated(InternalFrameEvent arg0) {
	}
	public void internalFrameClosed(InternalFrameEvent arg0) {
	}
	public void internalFrameClosing(InternalFrameEvent arg0) {
		if (arg0.getSource() == this) {
			internalFrameClosingThis(arg0);
		}
	}
	public void internalFrameDeactivated(InternalFrameEvent arg0) {
	}
	public void internalFrameDeiconified(InternalFrameEvent arg0) {
	}
	public void internalFrameIconified(InternalFrameEvent arg0) {
	}
	public void internalFrameOpened(InternalFrameEvent arg0) {
	}
	protected void internalFrameClosingThis(InternalFrameEvent arg0) {
		pro=null;
		dispose();
		
	}
	
	void crearEncabezado(){
		tablapro=new DefaultTableModel();
		tablapro.addColumn("Código");
		tablapro.addColumn("NomProducto");
		tablapro.addColumn("Pantalla");
		tablapro.addColumn("Camara");
		tablapro.addColumn("Memoria Ram");
		tablapro.addColumn("Bateria");
		tablapro.addColumn("Memoria Interna");
		tablapro.addColumn("Fecha Lanzamiento");
		tablapro.addColumn("PrecioVenta");
		tablapro.addColumn("Stock");
		tablapro.addColumn("Marca");
		
		tblproducto.setModel(tablapro);
	}
	
	String LeerCodigop(){
		 return txtCodigo.getText();
	}
	
	String LeerPantalla(){
		return txtPantalla.getText();
	}
	
	String LeerCamara(){
		return txtCamara.getText();
	
	}
	String LeerMemoriaRam(){
		return txtMemoriaRAM.getText();
		
	}
	String LeerBateria(){
		return txtBateria.getText();
		
	}
	String LeerMemoriaInterna(){
		return txtMemoriaInterna.getText();
		
	}
	String LeerFechaLanzamiento(){
			String fl=Utilidades.leerFecha(dtfecha);
		return fl;
	}
	double LeerPrecioV(){
		return Double.parseDouble(txtPrecioVenta.getText());
	}
	int LeerStock(){
		return Integer.parseInt(txtStock.getText());
	}
	String LeerCodMarca(){
		return lblcodmarca.getText();
	}
	String LeerNomProducto() {
		return  txtnomProducto.getText();
	}
	
	void mensaje(String m){
		JOptionPane.showMessageDialog(null, m);
	}
	void listarMarca(){
		try {
			cboMarca.addItem("Seleccione");
			objU.listadoMarca(cboMarca);
		} catch (Exception e) {

		}
	}
	protected void actionPerformedBtnNuevo(ActionEvent arg0) {
		Nuevo();
	}
	protected void actionPerformedBtnGrabar(ActionEvent arg0) {
		GrabarProducto();
	}
	
	void Nuevo(){
		estado="Grabar";
		btnGrabar.setText("Grabar");
		HabilitarControles();
		LimpiarCajas();
	}

	 void LimpiarCajas() {
		txtCodigo.setText("");
		txtnomProducto.setText("");
		txtPantalla.setText("");
		txtCamara.setText("");
		txtMemoriaRAM.setText("");
		txtBateria.setText("");
		txtMemoriaInterna.setText("");
		dtfecha.setDate(fe);
		txtPrecioVenta.setText("");
		txtStock.setText("");
		cboMarca.setSelectedIndex(0);
		txtCodigo.requestFocus();
		
	}

	 void HabilitarControles() {
		txtCodigo.setEnabled(true);
		txtnomProducto.setEnabled(true);
		txtPantalla.setEnabled(true);
		txtCamara.setEnabled(true);
		txtMemoriaRAM.setEnabled(true);
		txtBateria.setEnabled(true);
		txtMemoriaInterna.setEnabled(true);
		dtfecha.setEnabled(true);
		txtPrecioVenta.setEnabled(true);
		txtStock.setEnabled(true);
		
		
		
	}
	 void deshabilitarControles(){
		 txtCodigo.setEnabled(false);
			txtPantalla.setEnabled(false);
			txtnomProducto.setEnabled(false);
			txtCamara.setEnabled(false);
			txtMemoriaRAM.setEnabled(false);
			txtBateria.setEnabled(false);
			txtMemoriaInterna.setEnabled(false);
			dtfecha.setEnabled(false);
			txtPrecioVenta.setEnabled(false);
			txtStock.setEnabled(false);
			
	 }
	
	 void GrabarProducto(){
			try {
				int aviso;
				String codp=LeerCodigop();
				String nomP= LeerNomProducto();
				String pant = LeerPantalla();
				String cam=LeerCamara();
				String ram=LeerMemoriaRam();
				String bateria=LeerBateria();
				String memoriaint=LeerMemoriaInterna();
				String fl=LeerFechaLanzamiento();
				double prev = LeerPrecioV();
				int stock = LeerStock();
				String  codmar= LeerCodMarca();
			//validar la variable estado
				if(estado.equalsIgnoreCase("Grabar")){
		aviso=JOptionPane.showConfirmDialog(null, "Esta seguro de grabar..?",
				                         "Sistema",JOptionPane.YES_NO_OPTION,
				                         JOptionPane.INFORMATION_MESSAGE);
		//ahora validamos aviso
		 if(aviso==JOptionPane.YES_OPTION){
			//crear el objeto cl
			 //e invocar al constructor Cliente
			p = new Producto(codp,nomP, pant, cam,ram, bateria, memoriaint,fl, prev,stock,codmar);
			 //invocamos al metodo RegistrarCliente utilizando
			 //una variable de exito o  fracaso
			 int sal=objP.RegistrarProducto(p);
			 //ahora validamos sal
			 if(sal>0){
				 mensaje("Registrado correctamente");
				 listarProductos();
				 LimpiarCajas();
				 deshabilitarControles();
			 }
				 
			 else
				 mensaje("Error en el registro");
			 		 
		 }
			
				}//fin del if
				
				else if(estado.equalsIgnoreCase("Modificar")){
					
					aviso=JOptionPane.showConfirmDialog(null, "Esta seguro de modificar..?",
	                        "Sistema",JOptionPane.YES_NO_OPTION,
	                        JOptionPane.INFORMATION_MESSAGE);	
					if(aviso==JOptionPane.YES_OPTION){
					p = new Producto(codp,nomP,pant,cam,ram,bateria,memoriaint,fl,prev,stock,codmar);
					int sal=objP.ActualizarProducto(p);
					if(sal>0){
						mensaje("Actualizado correctamente");
						listarProductos();
						LimpiarCajas();
						deshabilitarControles();
						checkEditar.setSelected(false);
					}
					else{
						mensaje("No se pudo actualizar");
					}
					
					
					}
					
					
				}
				
			} catch (Exception e) {

			}
		
		}

	 void listarProductos() {
		
		try {
			objP.ListadoProductos(tablapro, misdatos,txtbuscar);;
		} catch (Exception e) {

		}
	}
	protected void actionPerformedCheckEditar(ActionEvent arg0) {
		if(checkEditar.isSelected()==true){
			estado="Modificar";
			btnGrabar.setText("Modificar");
			HabilitarControles();
			txtCodigo.setEnabled(false);
		}
		else
		{
			estado="Grabar";
			btnGrabar.setText("Grabar");
			deshabilitarControles();
		}
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getSource() == txtbuscar) {
			keyReleasedTxtbuscar(arg0);
		}
	}
	public void keyTyped(KeyEvent arg0) {
	}
	protected void keyReleasedTxtbuscar(KeyEvent arg0) {
		
		listarProductos();
		
	}
	
	void Eliminar(){
		try {
				
		String codP=LeerCodigop();
			int aviso=JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar..?",
                    "Sistema",JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE);
			
			if(aviso==JOptionPane.YES_OPTION){
				p=new Producto();
				p.setID_PRODUCTO(codP);
				int sal=objP.EliminarProducto(p);
				listarProductos();
				if(sal>0){
					mensaje("Eliminado correctamente...");
					LimpiarCajas();
					deshabilitarControles();
				}
				
				
			}
			
			
			
		} catch (Exception e) {

		}
		
		
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		Eliminar();
		
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblproducto) {
			try {
				mouseClickedTblproducto(arg0);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mouseClickedTblproducto(MouseEvent arg0) throws ParseException {
		
		//vamos captura la fila seleccionada (indice)
				int fila=tblproducto.rowAtPoint(arg0.getPoint());
				//JOptionPane.showMessageDialog(null, fila);
				txtCodigo.setText(tblproducto.getValueAt(fila, 0).toString());
				txtnomProducto.setText(tblproducto.getValueAt(fila, 1).toString());
				txtPantalla.setText(tblproducto.getValueAt(fila, 2).toString());
				txtCamara.setText(tblproducto.getValueAt(fila, 3).toString());
				txtMemoriaRAM.setText(tblproducto.getValueAt(fila, 4).toString());
				txtBateria.setText(tblproducto.getValueAt(fila, 5).toString());
				txtMemoriaInterna.setText(tblproducto.getValueAt(fila, 6).toString());
				String fl;
				fl=tblproducto.getValueAt(fila, 7).toString();
				java.util.Date sdf=new SimpleDateFormat("yyyy-MM-dd").parse(fl);
				dtfecha.setDate(sdf);
				txtPrecioVenta.setText(tblproducto.getValueAt(fila,8).toString());
				txtStock.setText(tblproducto.getValueAt(fila,9).toString());
				cboMarca.setSelectedItem(tblproducto.getValueAt(fila, 10).toString());
				
		
	}
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		dispose();
	}
}
