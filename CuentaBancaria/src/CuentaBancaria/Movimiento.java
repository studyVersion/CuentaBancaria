package CuentaBancaria;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Movimiento {

	
	Date fecha_hora; // Date fecha = new Date( ); SimpleDateFormat format =   new SimpleDateFormat ("'Fecha:' yyyy.MM.dd 'a la Hora:' hh:mm:ss");
     // System.out.println("Current Date: " + format.format(fecha));
	String destino;
	float cantidad;
	String categoria;
	
	public Movimiento(String destino, float cantidad, String categoria) {
		this.destino = destino;
		this.cantidad = cantidad;
		this.categoria = categoria;
		this.fecha_hora= new Date();
		
	}
	

	public Movimiento(float cant, String des, Date fecha, String cat) {
		this.destino = des;
		this.cantidad = cant;
		this.categoria = cat;
		this.fecha_hora= fecha;
	}


	public Date getFecha_hora() {
		return fecha_hora;
	}

	public void setFecha_hora(Date fecha_hora) {
		this.fecha_hora = fecha_hora;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
}

