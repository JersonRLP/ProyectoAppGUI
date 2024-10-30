package MenuPrincipal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import capavista.GuiCliente;
import capavista.GuiEmpleado;
import capavista.GuiLogueo;
import capavista.GuiProducto;
import proceso.GuiVenta;
import Consultas.GuiConsProductosVendidos;
import Consultas.GuiConsVentasxCliente;
import REPORTE.ReporteStockProducto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class escritorio extends JFrame implements ActionListener {

	private JPanel escritorio;
	private JMenuBar menuBar;
	private JMenu mnSalir;
	private JMenu mnMantenimiento;
	private JMenu mnPrincipales;
	private JMenuItem mntmCliente;
	private JMenuItem mntmProducto;
	private JMenuItem mntmEmpleado;
	private JMenu menu;
	private JMenu mnConsulta;
	private JMenu mnCliente;
	private JMenu mnProducto;
	private JMenu mnProceso;
	private JMenu mnVentas;
	private JMenuItem mntmBoleta;
	private JMenu mnReporte;
	private JMenuItem mntmCerrar;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmVentasxCliente;
	private JMenuItem mntmReporteStock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					escritorio frame = new escritorio();
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
	public escritorio() {
		GuiEmpleado.Emple=null;
		GuiCliente.clie=null;
		GuiProducto.pro=null;
		GuiConsProductosVendidos.cons1=null;
		GuiVenta.venta=null;
		GuiConsVentasxCliente.cons2=null;
		ReporteStockProducto.report1=null;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 446);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnSalir = new JMenu("Salir");
		menuBar.add(mnSalir);
		
		mntmCerrar = new JMenuItem("Cerrar");
		mntmCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnSalir.add(mntmCerrar);
		
		mnProceso = new JMenu("Proceso");
		menuBar.add(mnProceso);
		
		mnVentas = new JMenu("Ventas");
		mnProceso.add(mnVentas);
		
		mntmBoleta = new JMenuItem("Boleta");
		mntmBoleta.addActionListener(this);
		mnVentas.add(mntmBoleta);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mnPrincipales = new JMenu("Principales");
		mnMantenimiento.add(mnPrincipales);
		
		mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(this);
		mnPrincipales.add(mntmCliente);
		
		mntmProducto = new JMenuItem("Producto");
		mntmProducto.addActionListener(this);
		mnPrincipales.add(mntmProducto);
		
		mntmEmpleado = new JMenuItem("Empleado");
		mntmEmpleado.addActionListener(this);
		mnPrincipales.add(mntmEmpleado);
		
		menu = new JMenu("");
		menuBar.add(menu);
		
		mnConsulta = new JMenu("Consulta");
		menuBar.add(mnConsulta);
		
		mnCliente = new JMenu("Cliente");
		mnConsulta.add(mnCliente);
		
		mntmVentasxCliente = new JMenuItem("Ventas por Cliente");
		mntmVentasxCliente.addActionListener(this);
		mnCliente.add(mntmVentasxCliente);
		
		mnProducto = new JMenu("Producto");
		mnConsulta.add(mnProducto);
		
		mntmNewMenuItem = new JMenuItem("Productos Vendidos");
		mntmNewMenuItem.addActionListener(this);
		mnProducto.add(mntmNewMenuItem);
		
		mnReporte = new JMenu("Reporte");
		menuBar.add(mnReporte);
		
		mntmReporteStock = new JMenuItem("ReporteStock");
		mntmReporteStock.addActionListener(this);
		mnReporte.add(mntmReporteStock);
		escritorio = new JPanel();
		escritorio.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(escritorio);
		escritorio.setLayout(null);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmReporteStock) {
			actionPerformedMntmReporteStock(arg0);
		}
		if (arg0.getSource() == mntmVentasxCliente) {
			actionPerformedMntmVentasxCliente(arg0);
		}
		if (arg0.getSource() == mntmBoleta) {
			actionPerformedMntmBoleta(arg0);
		}
		if (arg0.getSource() == mntmNewMenuItem) {
			actionPerformedMntmNewMenuItem(arg0);
		}
		if (arg0.getSource() == mntmEmpleado) {
			actionPerformedMntmEmpleado(arg0);
		}
		if (arg0.getSource() == mntmProducto) {
			actionPerformedMntmProducto(arg0);
		}
		if (arg0.getSource() == mntmCliente) {
			actionPerformedMntmCliente(arg0);
		}
	}
	protected void actionPerformedMntmCliente(ActionEvent arg0) {
		
String cl=GuiCliente.clie;
		
		try {
			if(cl==null){
				GuiCliente gclie=new GuiCliente();
				escritorio.add(gclie);
				gclie.setVisible(true);
			}
			else{
				mensaje("Ya esta activo la ventana");
			}
			
		} catch (Exception e) {

		}
	}
	
	
	
	void mensaje(String m){
		JOptionPane.showMessageDialog(this, m);
	}
	
	protected void actionPerformedMntmProducto(ActionEvent arg0) {
String p=GuiProducto.pro;
		
		try {
			if(p==null){
				GuiProducto gpro=new GuiProducto();
				escritorio.add(gpro);
				gpro.setVisible(true);
			}
			else{
				mensaje("Ya esta activo la ventana");
			}
			
		} catch (Exception e) {

		}
		
		
	}
	protected void actionPerformedMntmEmpleado(ActionEvent arg0) {
		
			String Emp=GuiEmpleado.Emple ;
		
		try {
			if(Emp==null){
				GuiEmpleado gEmple=new GuiEmpleado();
				escritorio.add(gEmple);
				gEmple.setVisible(true);
			}
			else{
				mensaje("Ya esta activo la ventana");
			}
			
		} catch (Exception e) {

		}
		
		
		
	}
	protected void actionPerformedMntmNewMenuItem(ActionEvent arg0) {
     String Cons1= GuiConsProductosVendidos.cons1  ;
		
		try {
			if(Cons1==null){
				GuiConsProductosVendidos gCons1=new GuiConsProductosVendidos();
				escritorio.add(gCons1);
				gCons1.setVisible(true);
			}
			else{
				mensaje("Ya esta activo la ventana");
			}
			
		} catch (Exception e) {

		}
		
		
		
	}
	protected void actionPerformedMntmBoleta(ActionEvent arg0) {
		
		 String Venta= GuiVenta.venta ;
			
			try {
				if(Venta==null){
					GuiVenta gVenta=new GuiVenta();
					escritorio.add(gVenta);
					gVenta.setVisible(true);
				}
				else{
					mensaje("Ya esta activo la ventana");
				}
				
			} catch (Exception e) {

			}
			
			
	}
	protected void actionPerformedMntmVentasxCliente(ActionEvent arg0) {
		

		 String Cons2= GuiConsVentasxCliente.cons2;
			
			try {
				if(Cons2==null){
					GuiConsVentasxCliente gCons2=new GuiConsVentasxCliente();
					escritorio.add(gCons2);
					gCons2.setVisible(true);
				}
				else{
					mensaje("Ya esta activo la ventana");
				}
				
			} catch (Exception e) {

			}
		
	}
	protected void actionPerformedMntmReporteStock(ActionEvent arg0) {
		
		 String report1= ReporteStockProducto.report1;
			
			try {
				if(report1==null){
					ReporteStockProducto greporte1=new ReporteStockProducto();
					escritorio.add(greporte1);
					greporte1.setVisible(true);
				}
				else{
					mensaje("Ya esta activo la ventana");
				}
				
			} catch (Exception e) {

			}
	}
	
}
