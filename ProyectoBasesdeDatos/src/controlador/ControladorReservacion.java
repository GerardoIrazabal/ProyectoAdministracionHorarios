package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Reservacion;

public class ControladorReservacion extends Controlador {

    public ControladorReservacion(){
        super();
    }

    public ArrayList <Reservacion> ObtenerReservaciones() {

        ArrayList<Reservacion> Lista = new ArrayList<>();
        try {
            this.getControlador().CrearConexion();
            String query = "select * FROM Reservaciones";
            ResultSet Resultado = this.getControlador().ejecutarSentencia(query);
            while (Resultado.next()) {
                Reservacion s1 = new Reservacion(Resultado.getString(1), Resultado.getString(2),
                        Resultado.getDate(3), Resultado.getInt(4));
                Lista.add(s1);
            }
            this.getControlador().CerrarConexion();
        } catch (ClassNotFoundException | SQLException error) {
            error.printStackTrace();
        }
        return Lista;
        
    }

     //metodo para insertar salones
    public String InsertarReservacion(Reservacion s1) {
        String mensaje = "Aun no se ha creado la reservacion";
        String query = "call CrearReservacion (?, ?, ?, ?)";
        try {
            this.getControlador().CrearConexion();
            PreparedStatement Preparandoquery = this.getControlador().prepararSentencia(query);
            Preparandoquery.setString(1, s1.getIDSalon());
            Preparandoquery.setString(2, s1.getNombre());
            Preparandoquery.setDate(3, s1.getFechaHora());
            Preparandoquery.setInt(4, s1.getDuracion());
            Preparandoquery.executeUpdate();
            Preparandoquery.close();
            this.getControlador().CerrarConexion();
            mensaje = "Se ha creado la Reservacion";
        } catch (ClassNotFoundException | SQLException error) {
            error.printStackTrace();
        }
        return mensaje;

    }
    
    
}
