package capavista;


import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import capa_logica.ClsEmpleado;
import entidad.Cliente;
import entidad.Empleado;
import util.Utilidades;
import javax.swing.event.InternalFrameListener;
import javax.swing.event.InternalFrameEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GuiEmpleado extends JInternalFrame implements ActionListener, InternalFrameListener, KeyListener, MouseListener {
	
	String estado="";
	
	DefaultTableModel tabla;
	
	String datos[]=new String[5];
	
	Empleado E;
	
	Utilidades objU = new Utilidades();
	
	ClsEmpleado objE = new ClsEmpleado();
	
	
	public static String Emple;
	
	private JLabel lblDNI;
	private JLabel lblNombreEmpleado;
	private JLabel lblNewLabel;
	private JLabel lblDistrito;
	private JLabel lblCargo;
	private JTextField txtDNI;
	private JTextField txtNOMBRES;
	private JTextField txtAPELLIDOS;
	private JComboBox cboDistrito;
	private JComboBox cboCargo;
	private JTable tblEmpleado;
	private JButton btnNUEVO;
	private JButton btnGRABAR;
	private JButton btnCANCELAR;
	private JButton btnELIMINAR;
	private JButton btnCERRAR;
	private JTextField txtBUSCAR;
	private JLabel lblBUSCAR;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JCheckBox checkEditar;
	private JLabel lblcoddis;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiEmpleado frame = new GuiEmpleado();
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
	public GuiEmpleado() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		addInternalFrameListener(this);
		
		Emple = "Emple";
		setTitle("Mantenimiento Empleado");
		setBounds(100, 100, 607, 525);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 305, 571, 179);
		getContentPane().add(scrollPane);
		
		tblEmpleado = new JTable();
		tblEmpleado.addMouseListener(this);
		scrollPane.setViewportView(tblEmpleado);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Empleado", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel.setBounds(10, 32, 315, 226);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblDNI = new JLabel("DNI");
		lblDNI.setBounds(10, 41, 46, 14);
		panel.add(lblDNI);
		
		lblNombreEmpleado = new JLabel("NOMBRES");
		lblNombreEmpleado.setBounds(10, 76, 67, 14);
		panel.add(lblNombreEmpleado);
		
		lblNewLabel = new JLabel("APELLIDOS");
		lblNewLabel.setBounds(10, 101, 67, 14);
		panel.add(lblNewLabel);
		
		lblDistrito = new JLabel("DISTRITO");
		lblDistrito.setBounds(10, 134, 67, 14);
		panel.add(lblDistrito);
		
		lblCargo = new JLabel("CARGO");
		lblCargo.setBounds(10, 163, 67, 14);
		panel.add(lblCargo);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(74, 38, 143, 20);
		panel.add(txtDNI);
		txtDNI.setColumns(10);
		
		txtNOMBRES = new JTextField();
		txtNOMBRES.setBounds(74, 73, 143, 20);
		panel.add(txtNOMBRES);
		txtNOMBRES.setColumns(10);
		
		txtAPELLIDOS = new JTextField();
		txtAPELLIDOS.setBounds(74, 101, 143, 20);
		panel.add(txtAPELLIDOS);
		txtAPELLIDOS.setColumns(10);
		
		cboDistrito = new JComboBox();
		cboDistrito.addActionListener(this);
		cboDistrito.setBounds(74, 130, 143, 22);
		panel.add(cboDistrito);
		
		cboCargo = new JComboBox();
		cboCargo.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "Jefe Almacen", "Transportista", "Cargador Almacen", "\t"}));
		cboCargo.setBounds(74, 159, 143, 22);
		panel.add(cboCargo);
		
		checkEditar = new JCheckBox("Editar");
		checkEditar.addActionListener(this);
		checkEditar.setBounds(227, 37, 73, 23);
		panel.add(checkEditar);
		
		lblcoddis = new JLabel("New label");
		lblcoddis.setBounds(227, 134, 46, 14);
		panel.add(lblcoddis);
		
		panel_1 = new JPanel();
		panel_1.setBounds(370, 43, 190, 179);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		btnNUEVO = new JButton("NUEVO");
		btnNUEVO.addActionListener(this);
		btnNUEVO.setBounds(47, 11, 110, 23);
		panel_1.add(btnNUEVO);
		
		btnGRABAR = new JButton("GRABAR");
		btnGRABAR.addActionListener(this);
		btnGRABAR.setBounds(47, 46, 110, 23);
		panel_1.add(btnGRABAR);
		
		btnCANCELAR = new JButton("CANCELAR");
		btnCANCELAR.addActionListener(this);
		btnCANCELAR.setBounds(47, 80, 110, 23);
		panel_1.add(btnCANCELAR);
		
		btnELIMINAR = new JButton("ELIMINAR");
		btnELIMINAR.addActionListener(this);
		btnELIMINAR.setBounds(47, 114, 110, 23);
		panel_1.add(btnELIMINAR);
		
		btnCERRAR = new JButton("CERRAR");
		btnCERRAR.addActionListener(this);
		btnCERRAR.setBounds(47, 148, 110, 23);
		panel_1.add(btnCERRAR);
		
		panel_2 = new JPanel();
		panel_2.setBounds(335, 233, 246, 59);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		txtBUSCAR = new JTextField();
		txtBUSCAR.addKeyListener(this);
		txtBUSCAR.setBounds(31, 25, 192, 20);
		panel_2.add(txtBUSCAR);
		txtBUSCAR.setColumns(10);
		
		lblBUSCAR = new JLabel("BUSCAR");
		lblBUSCAR.setBounds(108, 11, 46, 14);
		panel_2.add(lblBUSCAR);

		crearEncabezado();
		DesabilitarControles();
		listarDistritos();
		listarEmpleados();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == checkEditar) {
			actionPerformedCheckEditar(arg0);
		}
		if (arg0.getSource() == btnCERRAR) {
			actionPerformedBtnCERRAR(arg0);
		}
		if (arg0.getSource() == btnELIMINAR) {
			actionPerformedBtnELIMINAR(arg0);
		}
		if (arg0.getSource() == btnCANCELAR) {
			actionPerformedBtnCANCELAR(arg0);
		}
		if (arg0.getSource() == cboDistrito) {
			actionPerformedCboDistrito(arg0);
		}
		if (arg0.getSource() == btnGRABAR) {
			actionPerformedBtnGRABAR(arg0);
		}
		if (arg0.getSource() == btnNUEVO) {
			actionPerformedBtnNUEVO(arg0);
		}
	}
	protected void actionPerformedBtnNUEVO(ActionEvent arg0) {
		Nuevo();
	}
	void Nuevo(){
		estado="Grabar";
		btnGRABAR.setText("Grabar");
		HabilitarControles();
		LimpiarCajas();
	}

	private void LimpiarCajas() {
		txtDNI.setText("");
		txtNOMBRES.setText("");
		txtAPELLIDOS.setText("");
		cboDistrito.setSelectedIndex(0);
		cboCargo.setSelectedIndex(0);
		txtDNI.requestFocus();
	}

	private void HabilitarControles() {
		txtDNI.setEnabled(true);
		txtNOMBRES.setEnabled(true);
		txtAPELLIDOS.setEnabled(true);
		
	}
	private void DesabilitarControles() {
		txtDNI.setEnabled(false);
		txtNOMBRES.setEnabled(false);
		txtAPELLIDOS.setEnabled(false);
		
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
		Emple = null;
		dispose();
		
	}
	 
	void listarDistritos(){
		try {
			cboDistrito.addItem("Seleccione");
			objU.listadoDistritos(cboDistrito);
		} catch (Exception e) {

		}
	}
	
	void crearEncabezado(){
		tabla=new DefaultTableModel();
		tabla.addColumn("DNI");
		tabla.addColumn("Nombres");
		tabla.addColumn("Apellidos");
		tabla.addColumn("Distrito");
		tabla.addColumn("Cargo");
		
		tblEmpleado.setModel(tabla);
	}
	protected void actionPerformedBtnGRABAR(ActionEvent arg0) {
		GrabarEmpleado();
		
	}
	String LeerDNI() {
		return txtDNI.getText();
	}
	String LeerNombres() {
		return txtNOMBRES.getText();
	}
	
	String LeerApellidos() {
		return txtAPELLIDOS.getText();
	}
	
	String LeerCod_dis() {
		return lblcoddis.getText();
	}
	String LeerCargo() {
		return cboCargo.getSelectedItem().toString();
	}
	
	void GrabarEmpleado(){
		try {
			int aviso;
			String codC=LeerDNI();
			String nomE=LeerNombres();
			String apeE=LeerApellidos();
			String codigodis=LeerCod_dis();
			String CargoE = LeerCargo();
			
			
		//validar la variable estado
			if(estado.equalsIgnoreCase("Grabar")){
	aviso=JOptionPane.showConfirmDialog(null, "Esta seguro de grabar..?",
			                         "Sistema",JOptionPane.YES_NO_OPTION,
			                         JOptionPane.INFORMATION_MESSAGE);
	//ahora validamos aviso
	 if(aviso==JOptionPane.YES_OPTION){
		//crear el objeto cl
		 //e invocar al constructor Cliente
		 E = new Empleado(codC, nomE, apeE, codigodis, CargoE);
		 //invocamos al metodo RegistrarCliente utilizando
		 //una variable de exito o  fracaso
		 int sal=objE.RegistrarEmpleado(E);
		 //ahora validamos sal
		 if(sal>0){
			 mensaje("Registrado correctamente");
			 listarEmpleados();
			 LimpiarCajas();
			 DesabilitarControles();
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
					E = new Empleado(codC, nomE, apeE, codigodis, CargoE);
				int sal=objE.ActualizarEmpleado(E);
				if(sal>0){
					mensaje("Actualizado correctamente");
					listarEmpleados();
					LimpiarCajas();
					DesabilitarControles();
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
	
	
	private void listarEmpleados() {
		try {
			objE.ListadoEmpleado(tabla, datos, txtBUSCAR);
		} catch (Exception e) {
			// TODO: handle exception
		}
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
	
	void mensaje(String m){
		JOptionPane.showMessageDialog(null, m);
	}
	
	protected void actionPerformedCboDistrito(ActionEvent arg0) {
		lblcoddis.setText(""+objU.buscarCodigoDistrito(cboDistrito.getSelectedItem().toString()));
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getSource() == txtBUSCAR) {
			keyReleasedTxtBUSCAR(arg0);
		}
	}
	public void keyTyped(KeyEvent arg0) {
	}
	protected void keyReleasedTxtBUSCAR(KeyEvent arg0) {
		
		listarEmpleados();
	}
	protected void actionPerformedBtnCANCELAR(ActionEvent arg0) {
		Cancelar();
		
		
	}
	
	void Cancelar(){
		LimpiarCajas();
		DesabilitarControles();
	}
	protected void actionPerformedBtnELIMINAR(ActionEvent arg0) {
		Eliminar();
		
		
	}
	
	
	void Eliminar(){
		try {
				
		String codE=LeerDNI();
			int aviso=JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar..?",
                    "Sistema",JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE);
			
			if(aviso==JOptionPane.YES_OPTION){
				E=new Empleado();
				E.setDNI(codE);
				int sal=objE.EliminarEmpleado(E);
				listarEmpleados();
				if(sal>0){
					mensaje("Eliminado correctamente...");
					LimpiarCajas();
					DesabilitarControles();
				}
				
				
			}
			
			
			
		} catch (Exception e) {

		}
		
		
	}
	protected void actionPerformedBtnCERRAR(ActionEvent arg0) {
		dispose();
	}
	protected void actionPerformedCheckEditar(ActionEvent arg0) {
		
		if(checkEditar.isSelected()==true){
			estado="Modificar";
			btnGRABAR.setText("MODIFICAR");
			HabilitarControles();
			txtDNI.setEnabled(false);
		}
		else
		{
			estado="Grabar";
			btnGRABAR.setText("GRABAR");
			DesabilitarControles();
		}
		
	}
	
	void grabarEmpleadoValidar(){
		
		String codC=LeerDNI();
		if(codC.length()>0){
			String nomE=LeerNombres();
			if(nomE.length()>0){
				String apeE=LeerApellidos();
				if(apeE.length()>0){
					String codigodis=LeerCod_dis();
					int cod = cboDistrito.getSelectedIndex();
					if(cod!=0){
						String CargoE = LeerCargo();
						
						if(CargoE.length()>0){
							int aviso=0;
							//validar la variable estado
							if(estado.equalsIgnoreCase("Grabar")){
					aviso=JOptionPane.showConfirmDialog(null, "Esta seguro de grabar..?",
							                         "Sistema",JOptionPane.YES_NO_OPTION,
							                         JOptionPane.INFORMATION_MESSAGE);
							
							//ahora validamos aviso
								 if(aviso==JOptionPane.YES_OPTION){
									//crear el objeto cl
									 //e invocar al constructor Cliente
									 E = new Empleado(codC, nomE, apeE, codigodis, CargoE);
									 //invocamos al metodo RegistrarCliente utilizando
									 //una variable de exito o  fracaso
									 int sal=objE.RegistrarEmpleado(E);
									 //ahora validamos sal
									 if(sal>0){
										 mensaje("Registrado correctamente");
										 listarEmpleados();
										 LimpiarCajas();
										 DesabilitarControles();
									 }
										 
									 else
										 mensaje("Error en el registro");		 
								 
								 }
							 }//fin del if Cargo
							 else if(estado.equalsIgnoreCase("Modificar")){
									
									aviso=JOptionPane.showConfirmDialog(null, "Esta seguro de modificar..?",
					                        "Sistema",JOptionPane.YES_NO_OPTION,
					                        JOptionPane.INFORMATION_MESSAGE);	
									if(aviso==JOptionPane.YES_OPTION){
										E = new Empleado(codC, nomE, apeE, codigodis, CargoE);
									int sal=objE.ActualizarEmpleado(E);
									if(sal>0){
										mensaje("Actualizado correctamente");
										listarEmpleados();
										LimpiarCajas();
										DesabilitarControles();
										checkEditar.setSelected(false);
									}
									else{
										mensaje("No se pudo actualizar");
									}
									
									
									}
									
									
								}
						
						}
						
						else{
						 mensaje("Ingrese Cargo correctamente");	
						}
					}
					else{
						mensaje("Ingrese un distrito ga");
					}
				}
				else{
					mensajeValidar("Ingrese Correctamente Apellidos", txtAPELLIDOS);
				}
			}
			else{
				mensajeValidar("Ingrese Nombres Correctamente", txtNOMBRES);
			}
		}
		else{
			mensajeValidar("Ingrese DNI Correctamente", txtDNI);
		}
	
	}

	public void mouseClicked(MouseEvent arg0){
		if (arg0.getSource() == tblEmpleado) {
			mouseClickedTblCliente(arg0);
		}
	}

	private void mouseClickedTblCliente(MouseEvent arg0) {
		//vamos captura la fila seleccionada (indice)
				int fila=tblEmpleado.rowAtPoint(arg0.getPoint());
				//JOptionPane.showMessageDialog(null, fila);
				txtDNI.setText(tblEmpleado.getValueAt(fila, 0).toString());
				txtNOMBRES.setText(tblEmpleado.getValueAt(fila, 1).toString());
				txtAPELLIDOS.setText(tblEmpleado.getValueAt(fila, 2).toString());
				
				cboDistrito.setSelectedItem(tblEmpleado.getValueAt(fila, 3).toString());
				cboCargo.setSelectedItem(tblEmpleado.getValueAt(fila, 4).toString());
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	}
	
