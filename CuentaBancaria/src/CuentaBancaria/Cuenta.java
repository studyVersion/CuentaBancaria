package CuentaBancaria;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Cuenta {
     static Scanner sc = new Scanner(System.in);      
     //Lista para guardar los movimientos
     ArrayList <Movimiento> libreCuenta = new ArrayList<>();
     
     
	final String nombre = "Badre serhiri";
	final String id = "ES123456789";
	static float saldo = 10000;
	//static String [] destino_enviador = new String {"in","out"};
	
	public void setSalado(float saldo) {
		this.saldo = saldo;
	}
	public float getSaldo() {
		return saldo;
	}
	
	// metodo parra gastos
	
	// metodo para ingresos
	
	public static void main(String[] args) {
		System.out.println("Bienvinida a tu APP");
		
		
	}
	
	public static Movimiento agregarMovimiento() {
		
		String [] categorias = {"Vivienda","Transporte","Ocio"};
		String [] destino = {"In","Out"};
		System.out.println("Dime la cantidad ");
		float cant = Float.parseFloat(sc.nextLine());
		System.out.println("Dime el distinatario ");
		for (int i=0 ; i< destino.length; i++) {
			System.out.println(i+1 + " Parra "+ destino[i]);
		}
		int j = Integer.parseInt(sc.nextLine());
		String des = destino[j-1];
		System.out.println("la fecha del movimiento es ");
		Date fecha = new Date();
		System.out.println(fecha);
		System.out.println("Dime la categoria ");
		for (int i=0 ; i< categorias.length; i++) {
			System.out.println(i+1 + " Parra "+ categorias[i]);
		}
		j = Integer.parseInt(sc.nextLine());
		String cat = categorias[j-1];
		Movimiento gasto = new Movimiento(cant,des,fecha,cat);
		return gasto;
	}//agregarMov
}
