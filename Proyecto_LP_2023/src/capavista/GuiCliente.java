package capavista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

import capa_logica.ClsCliente;
import entidad.Cliente;
import util.Utilidades;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;


import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class GuiCliente extends JInternalFrame implements InternalFrameListener, ActionListener, KeyListener, MouseListener {

	Utilidades objU=new Utilidades();
	
	String estado="";
	//Declarando y creando un objeto en base a la clase ClsCliente
	
	ClsCliente objC=new ClsCliente();
	
	//Declarando un objeto para la entidad Cliente
	
	Cliente cl;
	
	Date fe=new Date();
	
	DefaultTableModel modelito;
	
	//Declarar y crear un arreglo de tipo String
	String datos[]=new String[8];
	
	public static String clie;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnNuevo;
	private JButton btnGrabar;
	private JLabel lblCodigo;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblEdad;
	private JLabel lblIngresoMensual;
	private JLabel lblCorreo;
	private JLabel lblFechaNac;
	private JTextField txtCodigo;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtEdad;
	private JTextField txtIngresoM;
	private JTextField txtCorreo;
	private JDateChooser dtFecha;
	private JTextField txtBuscar;
	private JTable tblCliente;
	private JCheckBox chkEditar;
	private JButton btnCancelar;
	private JButton btnEliminar;
	private JLabel lblDistrito;
	private JComboBox cboDistrito;
	private JLabel lblCodDis;
	private JButton btnCerrar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiCliente frame = new GuiCliente();
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
	public GuiCliente() {
		setTitle("Mantenimiento de Cliente");
		addInternalFrameListener(this);
		clie="clie";
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 688, 498);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel.setBounds(10, 11, 468, 310);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 28, 46, 14);
		panel.add(lblCodigo);
		
		lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(10, 61, 73, 14);
		panel.add(lblNombres);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(10, 96, 73, 14);
		panel.add(lblApellidos);
		
		lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, 132, 46, 14);
		panel.add(lblEdad);
		
		lblIngresoMensual = new JLabel("Ingreso Mensual");
		lblIngresoMensual.setBounds(10, 165, 100, 14);
		panel.add(lblIngresoMensual);
		
		lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(10, 198, 73, 14);
		panel.add(lblCorreo);
		
		lblFechaNac = new JLabel("Fecha Nac.");
		lblFechaNac.setBounds(10, 232, 85, 14);
		panel.add(lblFechaNac);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(105, 25, 119, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(105, 58, 254, 20);
		panel.add(txtNombres);
		txtNombres.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(105, 93, 254, 20);
		panel.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(105, 129, 86, 20);
		panel.add(txtEdad);
		txtEdad.setColumns(10);
		
		txtIngresoM = new JTextField();
		txtIngresoM.setBounds(105, 162, 86, 20);
		panel.add(txtIngresoM);
		txtIngresoM.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(105, 195, 254, 20);
		panel.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		dtFecha = new JDateChooser();
		dtFecha.setDateFormatString("yyyy-MM-dd");
		dtFecha.setBounds(104, 226, 255, 20);
		panel.add(dtFecha);
		
		JLabel lblC = new JLabel("");
		lblC.setBounds(10, 285, 423, 14);
		panel.add(lblC);
		
		chkEditar = new JCheckBox("Editar");
		chkEditar.addActionListener(this);
		chkEditar.setBounds(365, 24, 73, 23);
		panel.add(chkEditar);
		
		lblDistrito = new JLabel("Distrito");
		lblDistrito.setBounds(10, 271, 73, 14);
		panel.add(lblDistrito);
		
		cboDistrito = new JComboBox();
		cboDistrito.addActionListener(this);
		cboDistrito.setBounds(105, 268, 254, 20);
		panel.add(cboDistrito);
		
		lblCodDis = new JLabel("");
		lblCodDis.setBounds(365, 271, 82, 14);
		panel.add(lblCodDis);
		
		panel_1 = new JPanel();
		panel_1.setBounds(488, 11, 139, 195);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(20, 11, 89, 23);
		panel_1.add(btnNuevo);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(20, 39, 89, 23);
		panel_1.add(btnGrabar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(20, 69, 89, 23);
		panel_1.add(btnCancelar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(20, 98, 89, 23);
		panel_1.add(btnEliminar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(20, 126, 89, 23);
		panel_1.add(btnCerrar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(488, 217, 147, 104);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BUSCAR");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(35, 11, 69, 14);
		panel_2.add(lblNewLabel);
		
		txtBuscar = new JTextField();
		txtBuscar.addKeyListener(this);
		txtBuscar.setBounds(10, 36, 127, 20);
		panel_2.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 332, 640, 110);
		getContentPane().add(scrollPane);
		
		tblCliente = new JTable();
		tblCliente.addMouseListener(this);
		scrollPane.setViewportView(tblCliente);

		crearEncabezado();
		listarClientes();
		deshabilitarControles();
		listarDistritos();
		
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
		clie=null;
		dispose();
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
		if (arg0.getSource() == cboDistrito) {
			actionPerformedCboDistrito(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
		}
		if (arg0.getSource() == chkEditar) {
			actionPerformedChkEditar(arg0);
		}
		if (arg0.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(arg0);
		}
		if (arg0.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(arg0);
		}
	}
	
	
	protected void actionPerformedBtnGrabar(ActionEvent arg0) {
		txtvalidar();
		
	}
	
	
	protected void actionPerformedBtnNuevo(ActionEvent arg0) {
	
		Nuevo();	
	
	}
	
	
	
	
	void LimpiarCajas(){
		txtCodigo.setText("");
		txtApellidos.setText("");
		txtNombres.setText("");
		txtCorreo.setText("");
		txtEdad.setText("");
		txtIngresoM.setText("");
		dtFecha.setDate(fe);
		cboDistrito.setSelectedIndex(0);
		txtCodigo.requestFocus();
	}
	
	
	//Metodos para la entrada de datos
	int leerCodigo(){
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	
	
	int leerEdad(){
		return Integer.parseInt(txtEdad.getText().trim());
	}
	
	
	String leerNombres(){
		return txtNombres.getText().trim();
	}
	
	String leerApellidos(){
		return txtApellidos.getText().trim();
	}
	
	
	
	double leerIngresoMensual(){
		return Double.parseDouble(txtIngresoM.getText().trim());
	}
	
	String leerCorreo(){
		return txtCorreo.getText().trim();
	}
	
	
	String leerFechaNac(){
		String fn=Utilidades.leerFecha(dtFecha);
		return fn;
	}
	
	
	
	void mensaje(String m){
		JOptionPane.showMessageDialog(null, m);
	}
	void mensajeValidar(String s ,JTextField txt){
		JOptionPane.showMessageDialog(this, s);
		txt.setText("");
		txt.requestFocus();
	}
	
	void mensajeValidarFecha(String s ,JDateChooser fecha){
		JOptionPane.showMessageDialog(this, s);
		
		
	}
	void mensajeValidarLbl(String s,JLabel lbl){
		JOptionPane.showMessageDialog(this, s);
	}
	
	void Nuevo(){
		estado="Grabar";
		btnGrabar.setText("Grabar");
		HabilitarControles();
		LimpiarCajas();
	}
	
	
	void Cancelar(){
		LimpiarCajas();
		deshabilitarControles();
	}
	
	
	void Eliminar(){
		try {
				
		int codC=leerCodigo();
			int aviso=JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar..?",
                    "Sistema",JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE);
			
			if(aviso==JOptionPane.YES_OPTION){
				cl=new Cliente();
				cl.setCODIGO(codC);
				int sal=objC.EliminarCliente(cl);
				listarClientes();
				if(sal>0){
					mensaje("Eliminado correctamente...");
					LimpiarCajas();
					deshabilitarControles();
				}
				
				
			}
			
			
			
		} catch (Exception e) {

		}
		
		
	}
	
	
	void deshabilitarControles(){
		txtCodigo.setEnabled(false);
		txtNombres.setEnabled(false);
		txtApellidos.setEnabled(false);
		txtEdad.setEnabled(false);
		txtIngresoM.setEnabled(false);
		txtCorreo.setEnabled(false);
		dtFecha.setEnabled(false);
	}
	
	
	
	void HabilitarControles(){
		txtCodigo.setEnabled(true);
		txtNombres.setEnabled(true);
		txtApellidos.setEnabled(true);
		txtEdad.setEnabled(true);
		txtIngresoM.setEnabled(true);
		txtCorreo.setEnabled(true);
		dtFecha.setEnabled(true);
	}
	
	
	
	
	
	
	
	
	
	void GrabarCliente(){
		try {
			int aviso;
			int codC=leerCodigo();
			String nomC=leerNombres();
			String apeC=leerApellidos();
			double ingmens=leerIngresoMensual();
			String correoC=leerCorreo();
			int edC=leerEdad();
			String fnC=leerFechaNac();
			String codigodis=lblCodDis.getText();
		//validar la variable estado
			if(estado.equalsIgnoreCase("Grabar")){
	aviso=JOptionPane.showConfirmDialog(null, "Esta seguro de grabar..?",
			                         "Sistema",JOptionPane.YES_NO_OPTION,
			                         JOptionPane.INFORMATION_MESSAGE);
	//ahora validamos aviso
	 if(aviso==JOptionPane.YES_OPTION){
		//crear el objeto cl
		 //e invocar al constructor Cliente
		 cl=new Cliente(codC, nomC, apeC, ingmens, correoC, edC, fnC,codigodis);
		 //invocamos al metodo RegistrarCliente utilizando
		 //una variable de exito o  fracaso
		 int sal=objC.RegistrarCliente(cl);
		 //ahora validamos sal
		 if(sal>0){
			 mensaje("Registrado correctamente");
			 listarClientes();
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
				cl=new Cliente(codC, nomC, apeC, ingmens, correoC, edC, fnC,codigodis);
				int sal=objC.ActualizarCliente(cl);
				if(sal>0){
					mensaje("Actualizado correctamente");
					listarClientes();
					LimpiarCajas();
					deshabilitarControles();
					
					chkEditar.setSelected(false);
				}
				else{
					mensaje("No se pudo actualizar");
				}
				
				
				}
				
				
			}
			
		} catch (Exception e) {
			
		}
	
	}
	
	
	void crearEncabezado(){
		modelito=new DefaultTableModel();
		modelito.addColumn("Código");
		modelito.addColumn("Nombres");
		modelito.addColumn("Apellidos");
		modelito.addColumn("Ing. mensual");
		modelito.addColumn("Correo");
		modelito.addColumn("Edad");
		modelito.addColumn("FechaNac");
		modelito.addColumn("Distrito");
		tblCliente.setModel(modelito);
	}

	//metodo para listar los clientes
	void listarClientes(){
		try {
			objC.listadoClientes(modelito, datos, txtBuscar);
		} catch (Exception e) {

		}
	}
	
	
	void listarDistritos(){
		try {
			cboDistrito.addItem("Seleccione");
			objU.listadoDistritos(cboDistrito);
		} catch (Exception e) {

		}
	}
	
	
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtBuscar) {
			keyReleasedTxtBuscar(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	
	protected void keyReleasedTxtBuscar(KeyEvent e) {
	
		listarClientes();
		
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblCliente) {
			try {
				mouseClickedTblCliente(arg0);
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
	protected void mouseClickedTblCliente(MouseEvent arg0) throws ParseException {
		//vamos captura la fila seleccionada (indice)
		int fila=tblCliente.rowAtPoint(arg0.getPoint());
		//JOptionPane.showMessageDialog(null, fila);
		txtCodigo.setText(tblCliente.getValueAt(fila, 0).toString());
		txtNombres.setText(tblCliente.getValueAt(fila, 1).toString());
		txtApellidos.setText(tblCliente.getValueAt(fila, 2).toString());
		txtIngresoM.setText(tblCliente.getValueAt(fila, 3).toString());
		txtCorreo.setText(tblCliente.getValueAt(fila, 4).toString());
		txtEdad.setText(tblCliente.getValueAt(fila, 5).toString());
		String fecnac;
		fecnac=tblCliente.getValueAt(fila, 6).toString();
		Date sdf=new SimpleDateFormat("yyyy-MM-dd").parse(fecnac);
		dtFecha.setDate(sdf);
		cboDistrito.setSelectedItem(tblCliente.getValueAt(fila, 7).toString());
		
		
	}
	protected void actionPerformedChkEditar(ActionEvent arg0) {
		
		if(chkEditar.isSelected()==true){
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
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		Cancelar();
		
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
	
 Eliminar();		
	}
	
	
	protected void actionPerformedCboDistrito(ActionEvent arg0) {
		
		lblCodDis.setText(""+objU.buscarCodigoDistrito(cboDistrito.getSelectedItem().toString()));
		
	}
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		dispose();
	}
	
	
	void txtvalidar(){
		try {
			int codC=leerCodigo();
			String nomC=leerNombres();
			if(nomC.length()>0){
				String apeC=leerApellidos();
				if(apeC.length()>0){
					try {
						int edC=leerEdad();
						try {
							double ingmens=leerIngresoMensual();
							String correoC=leerCorreo();
							
							if(correoC.length()>0){
								
								if(dtFecha.getDate()!=null){
									
									
									
									if(fe.equals(dtFecha.getDate())){
										
											mensajeValidarFecha("Ingrese Fecha Correctamente", dtFecha);
									}
									
									else if(dtFecha.getDate().before(fe)){
										String codigodis=lblCodDis.getText();
										int cod = cboDistrito.getSelectedIndex();
										if(cod==0){
											mensajeValidarLbl("ingrese un distrito", lblCodDis);
											
										}
										else{
											String fnC=leerFechaNac();
											int aviso=0;
											//validar la variable estado
											if(estado.equalsIgnoreCase("Grabar")){
									aviso=JOptionPane.showConfirmDialog(null, "Esta seguro de grabar..?",
											                         "Sistema",JOptionPane.YES_NO_OPTION,
											                         JOptionPane.INFORMATION_MESSAGE);
											if(aviso==JOptionPane.YES_OPTION){
												//crear el objeto cl
												 //e invocar al constructor Cliente
												 cl=new Cliente(codC, nomC, apeC, ingmens, correoC, edC, fnC,codigodis);
												 //invocamos al metodo RegistrarCliente utilizando
												 //una variable de exito o  fracaso
												 int sal=objC.RegistrarCliente(cl);
												 //ahora validamos sal
												 if(sal>0){
													 mensaje("Registrado correctamente");
													 listarClientes();
													 LimpiarCajas();
													 deshabilitarControles();
												 }
													 
												 else
													 mensaje("Error en el registro");
												 		 
											 	}
											 }
											else if(estado.equalsIgnoreCase("Modificar")){
												
												aviso=JOptionPane.showConfirmDialog(null, "Esta seguro de modificar..?",
								                        "Sistema",JOptionPane.YES_NO_OPTION,
								                        JOptionPane.INFORMATION_MESSAGE);	
												if(aviso==JOptionPane.YES_OPTION){
												cl=new Cliente(codC, nomC, apeC, ingmens, correoC, edC, fnC,codigodis);
												int sal=objC.ActualizarCliente(cl);
												if(sal>0){
													mensaje("Actualizado correctamente");
													listarClientes();
													LimpiarCajas();
													deshabilitarControles();
													
													chkEditar.setSelected(false);
												}
												else{
													mensaje("No se pudo actualizar");
												}
												
												
												}
												
												
											}
											
										}
										
										
									}else {
										mensajeValidarFecha("Ingrese Fecha Correctamente", dtFecha);
									}
										
								}
								else{
									mensajeValidarFecha("Ingrese Fecha Correctamente", dtFecha);
								}
							}
							else{
								mensajeValidar("Ingrese Correo Correctamente", txtCorreo);
							}
						} catch (Exception e) {
							mensajeValidar("Ingrese Ingreso Mensual correctamente", txtIngresoM);
						}
						
						
					} catch (Exception e) {
						mensajeValidar("Ingrese Edad Correctamente", txtEdad);
					}
				}
				else{
					mensajeValidar("Ingrese Apellidos Correctamente", txtApellidos);
				}
			}
			else{
				mensajeValidar("Ingrese Nombre Correctamente",txtNombres);
			}
		} catch (Exception e) {
			mensajeValidar("Ingrese codigo Correctamente", txtCodigo);
		}
			
	
	}
	
	

	
	
	
	
	
}
