package entidad;

public class Empleado {
	 private String DNI;
	 private String NOMEMPLE;
	 private String APEMPLE;
	 private String COD_DIS;
	 private String CARGO;
	public Empleado(String dNI, String nOMEMPLE, String aPEMPLE, String cOD_DIS, String cARGO) {
		super();
		DNI = dNI;
		NOMEMPLE = nOMEMPLE;
		APEMPLE = aPEMPLE;
		COD_DIS = cOD_DIS;
		CARGO = cARGO;
	}
	
	
	public Empleado() {
		super();
	}


	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getNOMEMPLE() {
		return NOMEMPLE;
	}
	public void setNOMEMPLE(String nOMEMPLE) {
		NOMEMPLE = nOMEMPLE;
	}
	public String getAPEMPLE() {
		return APEMPLE;
	}
	public void setAPEMPLE(String aPEMPLE) {
		APEMPLE = aPEMPLE;
	}
	public String getCOD_DIS() {
		return COD_DIS;
	}
	public void setCOD_DIS(String cOD_DIS) {
		COD_DIS = cOD_DIS;
	}
	public String getCARGO() {
		return CARGO;
	}
	public void setCARGO(String cARGO) {
		CARGO = cARGO;
	}
	 
	
	
	
}
