package CuentaBancaria;

import java.util.Scanner;

public class Cuenta {
     static Scanner sc = new Scanner();      
     //Lista para guardar los movimientos
     ArrayList <Movimiento> libreCuenta = new ArrayList<>();
     
     
	final String nombre = "Badre serhiri";
	final String id = "ES123456789";
	static float saldo = 10000.00;
	static String [] destino_enviador = new String {"in","out"};
	
	public void setSalado(float saldo) {
		this.saldo = saldo;
	}
	public String getSaldo() {
		return saldo;
	}
	
	// metodo parra gastos
	public float gastos() {
		System.out.println("Name ");
		Movimiento gasto = new Movimiento();
	}
	
	// metodo para ingresos
	
	public static void main(String[] args) {
		System.out.println("Bienvinida a tu APP");
		
		
	}
	
	public static void agregarMovimiento() {
		Movimiento gasto = new Movimiento();
		static String [] categorias = new String {"Vivienda","Transporte","Ocio"};
		static String [] destino = new String {"In","Out"};
		System.out.println("Dime la cantidad ");
		float cant = Float.parseFloat(sc.nextLine());
		System.out.println("Dime el distinatario ");
		for (int i=0 ; i< destino.length; i++) {
			System.out.println(i+1 + " Parra "+ destino[i]);
		}
		System.out.println("Dime la fecha ");
		System.out.println("Dime la categoria ");
		for (int i=0 ; i< categoria.length; i++) {
			System.out.println(i+1 + " Parra "+ categorias[i]);
		}
	}//agregarMov
}
