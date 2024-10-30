package entidad;

public class Usuario1 {
	
	//Creando atributos en la clase Usuario
	private String usuario, clave;
	
	//Constructor con parámetros
	public Usuario1(String usuario, String clave) {
		this.usuario = usuario;
		this.clave = clave;
	}

	//Generando métodos getters y setters
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	
	
}
