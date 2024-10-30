package Consultas;

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

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

//import util.ClsValida;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;

import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JYearChooser;
import javax.swing.DefaultComboBoxModel;


public class GuiConsVentasxCliente extends JInternalFrame implements InternalFrameListener, ActionListener, KeyListener, MouseListener {

	Utilidades objU=new Utilidades();
	
	

	DefaultTableModel modelito;
	
	String misdatos[]=new String[6];
	
		
	public static String cons2;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblC;
	private JTable tblCliente;
	private JScrollPane scrollPane;
	private JLabel lblCodDis;
	private JButton btnConsultar;
	private JButton btnCerrar;
	private JComboBox cboCliente;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiConsVentasxCliente frame = new GuiConsVentasxCliente();
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
	public GuiConsVentasxCliente() {
		setTitle("Consulta de ventas por cliente");
		addInternalFrameListener(this);
		cons2="cons2";
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 728, 312);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Consulta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel.setBounds(10, 11, 540, 90);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblC = new JLabel("");
		lblC.setBounds(10, 289, 349, 20);
		panel.add(lblC);
		
		lblCodDis = new JLabel("");
		lblCodDis.setBounds(335, 264, 82, 14);
		panel.add(lblCodDis);
		
		JLabel lblFechaFinal = new JLabel("Seleccione cliente");
		lblFechaFinal.setBounds(10, 36, 100, 14);
		panel.add(lblFechaFinal);
		
		cboCliente = new JComboBox();
		cboCliente.setBounds(120, 33, 410, 20);
		panel.add(cboCliente);
		
		panel_1 = new JPanel();
		panel_1.setBounds(572, 22, 130, 72);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(20, 11, 89, 23);
		panel_1.add(btnConsultar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(20, 45, 89, 23);
		panel_1.add(btnCerrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 112, 692, 159);
		getContentPane().add(scrollPane);
		
		tblCliente = new JTable();
		tblCliente.addMouseListener(this);
		scrollPane.setViewportView(tblCliente);
		
		crearEncabezado();
		listarClientes();
	
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
		cons2=null;
		dispose();
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
		}
	}
	
	
	
	void consultarVentasxCliente(){
		try {
			objU.ConsVentasxCliente(modelito, misdatos, cboCliente);
		} catch (Exception e) {

		}
	}
	
	
	
	
	
	
	void mensaje(String m){
		JOptionPane.showMessageDialog(null, m);
	}
	
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
	}
	
	
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblCliente) {
			try {
				do_tblCliente_mouseClicked(arg0);
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
	protected void do_tblCliente_mouseClicked(MouseEvent arg0) throws ParseException {
		
		
  
	}
	
	
	void listarClientes(){
		try {
			cboCliente.addItem("Seleccione");
			objU.listadoClientes(cboCliente);
		} catch (Exception e) {

		}
	}
	
	
	
	void crearEncabezado(){
		modelito=new DefaultTableModel();
		modelito.addColumn("NroBoleta");
		modelito.addColumn("Fecha_Emision");
		modelito.addColumn("Tipo de pago");
		modelito.addColumn("Total");
	
		tblCliente.setModel(modelito);
	}
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		consultarVentasxCliente();	
	}
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		dispose();
	}
}
