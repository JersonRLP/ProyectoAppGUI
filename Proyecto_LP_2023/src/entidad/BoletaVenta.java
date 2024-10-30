package entidad;

public class BoletaVenta {

	
//Atributos de boleta de venta
private String	nroboleta;
private String fecha_emision;
private String 	tipo_pago;
private int cod_clie;
private String dni_emple;
private double total;



//Atributos de Detalle Boleta
private String	cod_prod;
private int cantidad;
private double 	importe;




public BoletaVenta(String nroboleta, String fecha_emision, String tipo_pago, int cod_clie, String dni_emple, double total) {
	super();
	this.nroboleta = nroboleta;
	this.fecha_emision = fecha_emision;
	this.tipo_pago = tipo_pago;
	this.cod_clie = cod_clie;
	this.dni_emple = dni_emple;
	this.total = total;
}




public BoletaVenta(String nroboleta, String cod_prod, int cantidad, double importe) {
	super();
	this.nroboleta = nroboleta;
	this.cod_prod = cod_prod;
	this.cantidad = cantidad;
	this.importe = importe;
}




public String getNroboleta() {
	return nroboleta;
}




public void setNroboleta(String nroboleta) {
	this.nroboleta = nroboleta;
}




public String getFecha_emision() {
	return fecha_emision;
}




public void setFecha_emision(String fecha_emision) {
	this.fecha_emision = fecha_emision;
}




public String getTipo_pago() {
	return tipo_pago;
}




public void setTipo_pago(String tipo_pago) {
	this.tipo_pago = tipo_pago;
}




public int getCod_clie() {
	return cod_clie;
}




public void setCod_clie(int cod_clie) {
	this.cod_clie = cod_clie;
}




public String getDni_emple() {
	return dni_emple;
}




public void setDni_emple(String dni_emple) {
	this.dni_emple = dni_emple;
}




public double getTotal() {
	return total;
}




public void setTotal(double total) {
	this.total = total;
}




public String getCod_prod() {
	return cod_prod;
}




public void setCod_prod(String cod_prod) {
	this.cod_prod = cod_prod;
}




public int getCantidad() {
	return cantidad;
}




public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}




public double getImporte() {
	return importe;
}




public void setImporte(double importe) {
	this.importe = importe;
}




public BoletaVenta() {
}







	
	
}
