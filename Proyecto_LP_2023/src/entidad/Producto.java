package entidad;

public class Producto {
	
	private String ID_PRODUCTO;
	private String NOMPRODUCTO;
	private String PANTALLA;
	private String CAMARA;
	private String MEMORIA_RAM;
	private String BATERIACEL;
	private String MEMORIA_INTERNA;
	private String FECHA_LANZAMIENTO;
	private double PRECIO_VENTA;
	private int STOCK_ACTUAL;
	private String COD_MARCA;
	
	
	public Producto() {
		super();
	}


	public Producto(String iD_PRODUCTO, String nOMPRODUCTO, String pANTALLA, String cAMARA, String mEMORIA_RAM,
			String bATERIACEL, String mEMORIA_INTERNA, String fECHA_LANZAMIENTO, double pRECIO_VENTA, int sTOCK_ACTUAL,
			String cOD_MARCA) {
		super();
		ID_PRODUCTO = iD_PRODUCTO;
		NOMPRODUCTO = nOMPRODUCTO;
		PANTALLA = pANTALLA;
		CAMARA = cAMARA;
		MEMORIA_RAM = mEMORIA_RAM;
		BATERIACEL = bATERIACEL;
		MEMORIA_INTERNA = mEMORIA_INTERNA;
		FECHA_LANZAMIENTO = fECHA_LANZAMIENTO;
		PRECIO_VENTA = pRECIO_VENTA;
		STOCK_ACTUAL = sTOCK_ACTUAL;
		COD_MARCA = cOD_MARCA;
	}


	public String getID_PRODUCTO() {
		return ID_PRODUCTO;
	}


	public void setID_PRODUCTO(String iD_PRODUCTO) {
		ID_PRODUCTO = iD_PRODUCTO;
	}


	public String getNOMPRODUCTO() {
		return NOMPRODUCTO;
	}


	public void setNOMPRODUCTO(String nOMPRODUCTO) {
		NOMPRODUCTO = nOMPRODUCTO;
	}


	public String getPANTALLA() {
		return PANTALLA;
	}


	public void setPANTALLA(String pANTALLA) {
		PANTALLA = pANTALLA;
	}


	public String getCAMARA() {
		return CAMARA;
	}


	public void setCAMARA(String cAMARA) {
		CAMARA = cAMARA;
	}


	public String getMEMORIA_RAM() {
		return MEMORIA_RAM;
	}


	public void setMEMORIA_RAM(String mEMORIA_RAM) {
		MEMORIA_RAM = mEMORIA_RAM;
	}


	public String getBATERIACEL() {
		return BATERIACEL;
	}


	public void setBATERIACEL(String bATERIACEL) {
		BATERIACEL = bATERIACEL;
	}


	public String getMEMORIA_INTERNA() {
		return MEMORIA_INTERNA;
	}


	public void setMEMORIA_INTERNA(String mEMORIA_INTERNA) {
		MEMORIA_INTERNA = mEMORIA_INTERNA;
	}


	public String getFECHA_LANZAMIENTO() {
		return FECHA_LANZAMIENTO;
	}


	public void setFECHA_LANZAMIENTO(String fECHA_LANZAMIENTO) {
		FECHA_LANZAMIENTO = fECHA_LANZAMIENTO;
	}


	public double getPRECIO_VENTA() {
		return PRECIO_VENTA;
	}


	public void setPRECIO_VENTA(double pRECIO_VENTA) {
		PRECIO_VENTA = pRECIO_VENTA;
	}


	public int getSTOCK_ACTUAL() {
		return STOCK_ACTUAL;
	}


	public void setSTOCK_ACTUAL(int sTOCK_ACTUAL) {
		STOCK_ACTUAL = sTOCK_ACTUAL;
	}


	public String getCOD_MARCA() {
		return COD_MARCA;
	}


	public void setCOD_MARCA(String cOD_MARCA) {
		COD_MARCA = cOD_MARCA;
	}




	
	
}
