package CuentaBancaria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConnectDB {

	public static void insertMovimiento(ArrayList <Movimiento> libreCuenta) throws SQLException {
		
		Connection connectdb = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "badre","c123");
		Statement myConexion = connectdb.createStatement(  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		String query1 =  "Dropt table movimientos cascade;" ;
		String query ="create table....";
		
		for( int i=0; i<libreCuenta.size();i++) {
			
			Movimiento  mv = libreCuenta.get(i); // grabar objecto
	    
	    	String query2 =  "INSERT INTO movimientos (fecha_hora, destino, cantidad, categoria)"
				            +"VALUES ('"+mv.getFecha_hora()+"', '"+mv.getDestino()+"', '"+mv.getCantidad()+"', '"+mv.getCategoria()+"')";
            
	    	int myResult  = myConexion.executeUpdate(query2);
	    	
	    	System.out.println("Number of rows updated in database = " + myResult);
		
	}
	}
	
}
