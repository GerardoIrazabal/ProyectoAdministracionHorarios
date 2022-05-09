package controlador;
import java.sql.*;
import java.io.*;

public class TransactionMySQL extends ControladorConexion{

	public TransactionMySQL() throws SQLException, Exception {

		super();

		// setup the connection with the DB
		this.CrearConexion();
		System.out.println( "connected\n\n" );

		this.getConexion().setAutoCommit( false );         // inicio de la 1a transacción
		this.setSentencia(this.getConexion().createStatement());
	}

	private void dumpResultSet( ResultSet rset ) throws SQLException {

		ResultSetMetaData rsetmd = rset.getMetaData();
		int i = rsetmd.getColumnCount();

		while( rset.next() ) {

			for( int j = 1; j <= i; j++ ) {
				System.out.print( rset.getString(j) + "\t" );
			}
			System.out.println();
		}
	}

	public void ejecutarSentenciaentransaccion( String statement ) throws SQLException {
		//this.setSentencia(this.getConexion().createStatement());

		this.getSentencia().executeUpdate( statement );
		/*System.out.println( "Results:" );
		dumpResultSet( rset );

		System.out.println();
		rset.close();*/
		//this.getSentencia().close();
	}

	private void close() throws SQLException {

		this.getSentencia().close();
		this.getConexion().close();
	}

	public void FinalizarTransaccion() throws SQLException{
		this.getConexion().commit();      // fin de la transacción e inicio de la siguiente
	}

	public void DeshacerTransaccion() throws SQLException{
		this.getConexion().rollback();    // fin de la transacción e inicio de la siguiente
	}

}
