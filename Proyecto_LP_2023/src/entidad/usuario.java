package entidad;

public class usuario {
private String NOMUSUARIO;
private String CONTRASE�A;
private String COD_EMPLEADO;

public usuario() {
	super();
}

public usuario(String nOMUSUARIO, String cONTRASE�A) {
	super();
	NOMUSUARIO = nOMUSUARIO;
	CONTRASE�A = cONTRASE�A;
}

public String getNOMUSUARIO() {
	return NOMUSUARIO;
}

public void setNOMUSUARIO(String nOMUSUARIO) {
	NOMUSUARIO = nOMUSUARIO;
}

public String getCONTRASE�A() {
	return CONTRASE�A;
}

public void setCONTRASE�A(String cONTRASE�A) {
	CONTRASE�A = cONTRASE�A;
}

public String getCOD_EMPLEADO() {
	return COD_EMPLEADO;
}

public void setCOD_EMPLEADO(String cOD_EMPLEADO) {
	COD_EMPLEADO = cOD_EMPLEADO;
}


}
