package entidad;

public class usuario {
private String NOMUSUARIO;
private String CONTRASEÑA;
private String COD_EMPLEADO;

public usuario() {
	super();
}

public usuario(String nOMUSUARIO, String cONTRASEÑA) {
	super();
	NOMUSUARIO = nOMUSUARIO;
	CONTRASEÑA = cONTRASEÑA;
}

public String getNOMUSUARIO() {
	return NOMUSUARIO;
}

public void setNOMUSUARIO(String nOMUSUARIO) {
	NOMUSUARIO = nOMUSUARIO;
}

public String getCONTRASEÑA() {
	return CONTRASEÑA;
}

public void setCONTRASEÑA(String cONTRASEÑA) {
	CONTRASEÑA = cONTRASEÑA;
}

public String getCOD_EMPLEADO() {
	return COD_EMPLEADO;
}

public void setCOD_EMPLEADO(String cOD_EMPLEADO) {
	COD_EMPLEADO = cOD_EMPLEADO;
}


}
