package REPORTE;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import util.Utilidades;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ReporteStockProducto extends JInternalFrame implements ActionListener {
	
Utilidades objU=new Utilidades();
	
	

	DefaultTableModel modelito;
	
	String misdatos[]=new String[2];
	
	public static String report1;
	private JLabel lblProducto;
	private JScrollPane scrollPane;
	private JTable tblProductoStock;
	private JButton btnListar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporteStockProducto frame = new ReporteStockProducto();
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
	public ReporteStockProducto() {
		
		report1 ="report1";
		setTitle("Listar Stock Producto");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 366, 441);
		getContentPane().setLayout(null);
		
		lblProducto = new JLabel("LISTA DE PRODUCTOS STOCK");
		lblProducto.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 16));
		lblProducto.setBounds(68, 11, 206, 49);
		getContentPane().add(lblProducto);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 94, 335, 306);
		getContentPane().add(scrollPane);
		
		tblProductoStock = new JTable();
		scrollPane.setViewportView(tblProductoStock);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setBounds(104, 49, 105, 34);
		getContentPane().add(btnListar);
		crearEncabezado();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnListar) {
			actionPerformedBtnListar(arg0);
		}
	}
	
	
	
	void crearEncabezado(){
		modelito=new DefaultTableModel();
		modelito.addColumn("NombreProducto");
		modelito.addColumn("Stock");
	
	
		tblProductoStock.setModel(modelito);
	}
	
	void listarProductoStock() {
		objU.listadoProductosStock(modelito, misdatos);
	}
	protected void actionPerformedBtnListar(ActionEvent arg0) {
		listarProductoStock();
	}
}
