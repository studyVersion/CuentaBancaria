package CuentaBancaria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in); 
     //Lista para guardar los movimientos
    static  ArrayList <Movimiento> libreCuenta = new ArrayList<>();
     
     
	final String nombre = "Badre serhiri";
	final String id = "ES123456789";
	static float saldo =0;
	//static String [] destino_enviador = new String {"in","out"};
	
	public void setSalado(float saldo) {
		this.saldo = saldo;
	}
	public float getSaldo() {
		return saldo;
	}
	
	// metodo parra gastos
	
	// metodo para ingresos
	
	public static void main(String[] args) throws SQLException {
		    
		System.out.println("Bienvinida a tu APP");
        
		
		System.out.println("1 para anadir un movimiento");
		System.out.println("2 para editar la categoria del movimiento");
		System.out.println("3 para quitar movimiento");
		System.out.println("4 para consultar movimientos");
		System.out.println("5 para consultar sueldo");
		System.out.println("0 para salir");
		
		
		int option =Integer.parseInt(sc.nextLine());
		switch(option) {
		   case 1 :   Movimiento mov = agregarMovimiento();
		              insertMovimiento(mov);break;
		   case 2 :   System.out.println("Introduce el ID del movimiento: ");
 	                  int id =Integer.parseInt(sc.nextLine());
 	                  updateMovimientoCategoria(id);break;
		   case 3 :   System.out.println("Introduce el ID del movimiento");   
		              int id2 =Integer.parseInt(sc.nextLine());
		              quitarMovimiento (id2);break;
		   case 4 :   System.out.println("Introduce el ID del movimiento");   
                      int id3=Integer.parseInt(sc.nextLine()); 
                      consultarMovimientos( id3);break;
		   case 5 :   saldo = consultarSaldo ();
			          System.out.println("Tu sueldo es : "+saldo+"$");           
		   case 0 :    System.exit(0);           
                      
		}
		
		
		
		
		
	}
	
	public static Movimiento agregarMovimiento() {
		//Scanner in = new Scanner(System.in);
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
		System.out.println("la fecha del movimiento es:");
		Date fecha = new Date();
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		System.out.println(formatDate.format(fecha)+"\n");
		System.out.println("Dime la categoria ");
		for (int i=0 ; i< categorias.length; i++) {
			System.out.println(i+1 + " Parra "+ categorias[i]);
		}
		j = Integer.parseInt(sc.nextLine());
		String cat = categorias[j-1];
		Movimiento gasto = new Movimiento(cant,des,fecha,cat);
		//libreCuenta.add(gasto);
		return gasto;
		
		
	}//agregarMov
	
	    
        public static void insertMovimiento(Movimiento mov) throws SQLException { // metodo parra insertar movimientos
        	
		DecimalFormat pointToComma = (DecimalFormat)DecimalFormat.getNumberInstance(Locale.GERMAN); // change "." in decimal by ","
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy hh:mm"); // change date format 
		Connection connectdb = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "badre","c123");
		Statement myConexion = connectdb.createStatement();
		
		String query =  "insert into  movimientos (fecha_hora, destino, cantidad, categoria)"                   // insert query        
				            +"VALUES ( '"+formatDate.format(mov.getFecha_hora())+"' , '"+mov.getDestino()+
				            "' , '"+pointToComma.format(mov.getCantidad()) +"', '"+mov.getCategoria()+"')";
				           
        int myResult  = myConexion.executeUpdate(query); //execute statement
        
        if (myResult>0) { // make sure row inserted
	       
        	System.out.println( myResult+ " row was inserted.\n");
	    
        } else System.out.println("ERROR OCCURED! id is not registered\n");
        
	    myConexion.close();
      
      }//insertMovimiento
        
       
       public static void updateMovimientoCategoria(int id) throws SQLException {
    	   
    	   Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "badre","c123");
   		   Statement stmt = con.createStatement();
   		  
    	   String [] categorias = {"Vivienda","Transporte","Ocio"};
    	   
    	   System.out.println("choose what category to apply");
    	   
    	   for(int i=0;i<categorias.length; i++) {
    		   System.out.println("  > "+(i+1)+" "+categorias[i]);
    	   }
    	   int option = Integer.parseInt(sc.nextLine());
    	   String category = categorias[option-1];
    	   
    	   
   		    
   		   //Updating the table
   		   String query ="UPDATE movimientos set categoria = '"+category+"' where id = '"+id+"'";
   		   
   		   int myResult = stmt.executeUpdate(query);
   		   if (myResult>0) {
   		       
   			   System.out.println(myResult+ " row was updated.\n" );
   	    
           } else System.out.println("ERROR OCCURED! id is not registered\n");
   		
   		   con.close();
   		   
       }
       
       public static void quitarMovimiento (int id) throws SQLException { // metodo parra quitar movimientos
       	
   		Connection connectdb = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "badre","c123");
   		Statement stmt = connectdb.createStatement();
   		
   		
   		//Deleting from the table
   		
   		String query = "DELETE from movimientos  where id = "+id;
   				           
           int myResult  = stmt.executeUpdate(query); //execute statement
           
           if (myResult>0) { // make sure row deleted
   	       
           	System.out.println( myResult+ " movimiento successfully deleted.\n");
   	    
           } else System.out.println("ERROR OCCURED! id is not registered.\n");
           
           connectdb.close();
         
         }//insertMovimiento
       
       public static void consultarMovimientos(int id) throws SQLException {
    	   Connection connectdb = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "badre","c123");
      	   Statement stmt = connectdb.createStatement();
      	   
      	   //select from table
      	   String query = "SELECT * FROM movimientos WHERE id = "+id;
      	   ResultSet rs = stmt.executeQuery(query);
      	     if(rs.next()) {
      	    	//fecha_hora, destino, cantidad, categoria
        	 String fecha = rs.getString("fecha_hora");
             String destino = rs.getString("destino");
             String cantidad = rs.getString("cantidad");
             String categoria = rs.getString("categoria");
             System.out.println("Fecha: "+fecha+", Destino: "+ destino+", Cantidad: "+cantidad+", categoria: "+categoria+".");
             
       }
      	     else {
      	    	 System.out.println("User is not registered!\n");
      	     }
      	   connectdb.close();
       }
       
       public static float consultarSaldo () throws SQLException {
    	   Connection connectdb = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "badre","c123");
      	   Statement stmt = connectdb.createStatement();
      	   ResultSet rs = stmt.executeQuery("SELECT destino ,cantidad FROM movimientos");
      	   
      	 while(rs.next()) {
      		 if(rs.getString("destino").equals("In")){
      			 saldo = saldo + rs.getFloat("cantidad");
      	 }else if (rs.getString("destino").equals("Out")) {
      		saldo = saldo - rs.getFloat("cantidad");
      	 }
		
      	 
      	   
    	   
      	 }
		return saldo;}
}
