package entidad;

public class Cliente {

	private int CODIGO ;
	private String NOMBRES;
	private String APELLIDOS;
	private double ING_MENSUAL;
	private String CORREO;
	private int EDAD;
	private String FECHA_NAC;
	private String COD_DIS;
	
	
	public Cliente() {
		super();
	}


	public Cliente(int cODIGO, String nOMBRES, String aPELLIDOS, double iNG_MENSUAL, String cORREO, int eDAD,
			String fECHA_NAC, String cOD_DIS) {
		super();
		CODIGO = cODIGO;
		NOMBRES = nOMBRES;
		APELLIDOS = aPELLIDOS;
		ING_MENSUAL = iNG_MENSUAL;
		CORREO = cORREO;
		EDAD = eDAD;
		FECHA_NAC = fECHA_NAC;
		COD_DIS = cOD_DIS;
	}


	public int getCODIGO() {
		return CODIGO;
	}


	public void setCODIGO(int cODIGO) {
		CODIGO = cODIGO;
	}


	public String getNOMBRES() {
		return NOMBRES;
	}


	public void setNOMBRES(String nOMBRES) {
		NOMBRES = nOMBRES;
	}


	public String getAPELLIDOS() {
		return APELLIDOS;
	}


	public void setAPELLIDOS(String aPELLIDOS) {
		APELLIDOS = aPELLIDOS;
	}


	public double getING_MENSUAL() {
		return ING_MENSUAL;
	}


	public void setING_MENSUAL(double iNG_MENSUAL) {
		ING_MENSUAL = iNG_MENSUAL;
	}


	public String getCORREO() {
		return CORREO;
	}


	public void setCORREO(String cORREO) {
		CORREO = cORREO;
	}


	public int getEDAD() {
		return EDAD;
	}


	public void setEDAD(int eDAD) {
		EDAD = eDAD;
	}


	public String getFECHA_NAC() {
		return FECHA_NAC;
	}


	public void setFECHA_NAC(String fECHA_NAC) {
		FECHA_NAC = fECHA_NAC;
	}


	public String getCOD_DIS() {
		return COD_DIS;
	}


	public void setCOD_DIS(String cOD_DIS) {
		COD_DIS = cOD_DIS;
	}
	
	
}
