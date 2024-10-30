package capa_logica;
import java.sql.CallableStatement;
import java.sql.Connection;
import capa_datos.MySQLConexion;
import interfaces.InterfaceBoleta;
import entidad.BoletaVenta;

public class ClsVenta implements InterfaceBoleta{

	public int RegistrarBoleta(BoletaVenta bol) {
		int salida=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			
			cn=MySQLConexion.miConexion();//ok
			cstm=cn.prepareCall("{call SP_REGISTRAR_BOLETA(?,?,?,?,?,?)}");
			//seteamos los datos a cada campo
			cstm.setString(1, bol.getNroboleta());
			cstm.setString(2, bol.getFecha_emision());
			cstm.setString(3, bol.getTipo_pago());
			cstm.setInt(4, bol.getCod_clie());
			cstm.setString(5, bol.getDni_emple());
			cstm.setDouble(6, bol.getTotal());
		//quinto ejecutar el pstm atraves de la variable salida
			salida=cstm.executeUpdate();//exito o fracaso
		} catch (Exception e) {
         e.printStackTrace();
		}
		finally {
			try {
				if(cstm!=null)cstm.close();
				if(cn!=null)cn.close();
			} catch (Exception e2) {
				
			}
			
		}//final del finally
				
		return salida;
	}

	
	public int RegistrarDetalleBoleta(BoletaVenta bol) {
		int salida=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			
			cn=MySQLConexion.miConexion();//ok
			cstm=cn.prepareCall("{call SP_REGISTRAR_DETALLE_BOLETA(?,?,?,?)}");

			cstm.setString(1, bol.getNroboleta());
			cstm.setString(2, bol.getCod_prod());
			cstm.setInt(3, bol.getCantidad());
			cstm.setDouble(4, bol.getImporte());
			

			salida=cstm.executeUpdate();//exito o fracaso
		} catch (Exception e) {
         e.printStackTrace();
		}
		finally {
			try {
				if(cstm!=null)cstm.close();
				if(cn!=null)cn.close();
			} catch (Exception e2) {
				
			}
			
		}//final del finally
				
		return salida;
	}

}
