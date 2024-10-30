package capa_logica;

import java.util.ArrayList;
import entidad.Usuario1;
import java.io.BufferedReader;
import java.io.FileReader;

public class ClsUsuario {
	
	//Declarar un objeto Arraylist de tipo privado
	private ArrayList<Usuario1>u;

	public ClsUsuario() {
		//Creando el objeto ArrayList u
		u = new ArrayList<Usuario1>();
		listarUsuarios();
	}
	
	public int tamanio(){
		return u.size();
	}
	
	public Usuario1 obtener(int i){
		return u.get(i);
	}
	
	//MÉTODO PARA LISTAR LOS DATOS DEL ARCHIVO DE TEXTO USUARIO.TXT
	public void listarUsuarios(){
		try {
			BufferedReader br;
	         String usu,cla;
	         String linea;
	         String datos[];
	         br=new BufferedReader(new FileReader("usuario.txt"));
	         while((linea=br.readLine())!=null){
	        	 datos=linea.split(";");
	        	 usu=datos[0];
	        	 cla=datos[1];
	        	 u.add(new Usuario1(usu, cla));
	         }
	         
	         br.close();
		} catch (Exception e) {
			
		}
	}
	
	
}
