package capavista;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MenuPrincipal.escritorio;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import capa_logica.ClsUsuario;
import capa_datos.MySQLConexion;

//Importar clase ClsUsuario
//import operaciones.ClsUsuario; //1


public class GuiLogueo extends JFrame implements ActionListener {

	//Creando objeto en base a la clase ClsUsuario
	//ClsUsuario objS=new ClsUsuario();//2
	ClsUsuario objUsua=new ClsUsuario();
	
	//Declarar variables user. pwd de tipo privado static
	//private static String user, pwd;//3
	private static String user, pwd;

	

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JTextField txtUsuario;
	private JButton btnCerrar;
	private JPasswordField txtClave;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
//aqui pegar el codigo de JTattoo
		try {
            //here you can put the selected theme class name in JTattoo
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
 
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GuiLogueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiLogueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiLogueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiLogueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiLogueo frame = new GuiLogueo();
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
	public GuiLogueo() {
		setTitle("Accediendo al Sistema");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 243);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(GuiLogueo.class.getResource("/imagenes/acceso2.jpg")));
		lblNewLabel.setBounds(10, 21, 177, 177);
		contentPane.add(lblNewLabel);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuario.setBounds(197, 21, 55, 14);
		contentPane.add(lblUsuario);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContrasea.setBounds(197, 59, 73, 14);
		contentPane.add(lblContrasea);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(270, 18, 123, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(304, 165, 89, 23);
		contentPane.add(btnCerrar);
		
		txtClave = new JPasswordField();
		txtClave.setBounds(270, 56, 123, 20);
		contentPane.add(txtClave);
		
		btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(194, 165, 89, 23);
		contentPane.add(btnNewButton);
	
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(arg0);
		}
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
	}
	
	void accediendoAlSistema(){
		String usuario, clave;
		String mensaje;
		
		try {
			user = txtUsuario.getText();
			pwd = txtClave.getText();
			
			//realizar un recorrido
			for(int x=0; x<objUsua.tamanio(); x++){
				usuario = objUsua.obtener(x).getUsuario();
				clave = objUsua.obtener(x).getClave();
				if(usuario.equalsIgnoreCase(user) && clave.equalsIgnoreCase(pwd)){
					mensaje="Bienvenido......."+user;
					JOptionPane.showMessageDialog(null, mensaje, "Inicio de sesión",
							JOptionPane.INFORMATION_MESSAGE);
					escritorio me=new escritorio();
					me.setExtendedState(MAXIMIZED_BOTH);
					me.setVisible(true);
					this.dispose();
				}
				
			}
			
				
		} catch (Exception e) {
			
				JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto");	
			
		}
		
	}
	
		public void UsuarioBD(){
			String mensaje;
			String contraseña =String.valueOf(txtClave.getPassword());
			String usuario =txtUsuario.getText();
			String SQL= "select* from usuario where NOMUSUARIO='"+usuario+"' and CONTRASEÑA='"+contraseña+"' " ;
			//Declarar un objeto de tipo Connection

			//primero declarar un objeto para la conexion
					Connection cn=null;
				//segundo declara un objeto pstm para manipular
					//la tabla
					PreparedStatement pstm=null;
					//tercero declara ub objeto para los registros
					ResultSet rs=null;
			try {
				//Primero  vamos a invocar la conexion de BD
				cn=MySQLConexion.miConexion();//ok
				//3 cargar a pstm la conexion y el sql
			      pstm=cn.prepareStatement(SQL);//ok
			      //4 enviar los datos a rs
			      rs=pstm.executeQuery();
			      
			      if(rs.next()){
			    		  mensaje="Bienvenido......."+usuario;
							JOptionPane.showMessageDialog(null, mensaje, "Inicio de sesión",
									JOptionPane.INFORMATION_MESSAGE);
							escritorio me=new escritorio();
							me.setExtendedState(MAXIMIZED_BOTH);
							me.setVisible(true);
							this.dispose();
			      }else{
			    	  JOptionPane.showMessageDialog(null,"Error de Acceso , Usuario o Contraseña Incorrecto");
	  					
			  			txtUsuario.setText("");
			  			txtClave.setText("");
			  			txtUsuario.requestFocus();
			      }
			      
			      
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Error de Acceso" + e.getMessage());
	  		  
			}
			finally {
				try {
					if(rs!=null)rs.close();
					if(pstm!=null)pstm.close();
					if(cn!=null)cn.close();  
					
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			
			
		}
	
		public void UsuarioBD2(){
			
			String mensaje;
			String contraseña =String.valueOf(txtClave.getPassword());
			String usuario =txtUsuario.getText();
			String SQL= "select* from usuario where NOMUSUARIO='"+usuario+"' and CONTRASEÑA='"+contraseña+"' " ;
			//Declarar un objeto de tipo Connection

			if(contraseña.isEmpty() || usuario.isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Ambos Campos Son Obligatorios ");
			}
			else {
				//primero declarar un objeto para la conexion
				Connection cn=null;
			//segundo declara un objeto pstm para manipular
				//la tabla
				PreparedStatement pstm=null;
				//tercero declara ub objeto para los registros					
				ResultSet rs=null;
		try {
			//Primero  vamos a invocar la conexion de BD
			cn=MySQLConexion.miConexion();//ok
			//3 cargar a pstm la conexion y el sql
		      pstm=cn.prepareStatement(SQL);//ok
		      //4 enviar los datos a rs
		      rs=pstm.executeQuery();
		      
		      if(rs.next()){
		    	  int resultado=rs.getRow();
		    	  if(resultado==1){
		    		  mensaje="Bienvenido......."+usuario;
						JOptionPane.showMessageDialog(null, mensaje, "Inicio de sesión",
								JOptionPane.INFORMATION_MESSAGE);
						escritorio me=new escritorio();
						me.setExtendedState(MAXIMIZED_BOTH);
						me.setVisible(true);
						this.dispose();
		    	  }
		      }
		      
		      else{
		    	  JOptionPane.showMessageDialog(null,"Error de Acceso , Usuario o Contraseña Incorrecto");
		    	  	txtUsuario.setText("");
		  			txtClave.setText("");
		  			txtUsuario.requestFocus();
		      }
		      
		      
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Error de Acceso" + e.getMessage());
  		  
			}
			
			finally {
				try {
					if(rs!=null)rs.close();
					if(pstm!=null)pstm.close();
					if(cn!=null)cn.close();  
					
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
			}		
				
	
	
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		dispose();
	}
	protected void actionPerformedBtnNewButton(ActionEvent arg0) {
		
		UsuarioBD2();
	}
}
