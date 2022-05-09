package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControladorConexion {

    BaseDeDatos BDD;

    private Statement Sentencia;
    private Connection Conexion;
    

    public ControladorConexion(BaseDeDatos BDD) {
        this.BDD = BDD;
    }

    public ControladorConexion() {
        this.BDD = new BaseDeDatos();
    }

    public void CrearConexion() throws ClassNotFoundException, SQLException {
        Class.forName(BDD.getDriverClassName());
        Conexion = DriverManager.getConnection(BDD.getURL(), BDD.getNombreUsuario(), BDD.getPassword());
    }

    //Cerrar la Conexion
    public void CerrarConexion() throws SQLException {
        Conexion.close();
    }

    //Metodos para ejecutar sentencias SQL
    public ResultSet ejecutarSentencia(String consulta) throws SQLException {
        this.Sentencia = (Statement) Conexion.createStatement();
        return this.Sentencia.executeQuery(consulta);
    }
    
    // Metodos para preparar sentencias (Sirve para agregarle valores a los inserts, gets, etc..)
    public PreparedStatement prepararSentencia(String consulta) throws SQLException {
        return Conexion.prepareStatement(consulta);
    }

    public BaseDeDatos getBDD() {
        return BDD;
    }

    public void setBDD(BaseDeDatos bDD) {
        BDD = bDD;
    }

    public Statement getSentencia() {
        return Sentencia;
    }

    public void setSentencia(Statement sentencia) {
        Sentencia = sentencia;
    }

    public Connection getConexion() {
        return Conexion;
    }

    public void setConexion(Connection conexion) {
        Conexion = conexion;
    }

    
}
