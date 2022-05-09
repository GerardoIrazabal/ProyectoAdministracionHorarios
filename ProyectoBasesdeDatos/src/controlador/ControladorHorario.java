package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Curso;
import modelo.Horario;

/**
 * ControladorHorario
 */

public class ControladorHorario extends Controlador {

    public ControladorHorario(){
        super();
    }

    public ArrayList <Horario> ObtenerHorarios() {

        ArrayList<Horario> Lista = new ArrayList<>();
        try {
            this.getControlador().CrearConexion();
            String query = "select * FROM Horarios";
            ResultSet Resultado = this.getControlador().ejecutarSentencia(query);
            while (Resultado.next()) {
                Horario s1 = new Horario();

                s1.setCursito(new Curso(Resultado.getString(1), Resultado.getInt(2), "", ""));
                s1.setDIASEM(Resultado.getInt(3));
                s1.setHora(Resultado.getInt(4));
                s1.setMinuto(Resultado.getInt(5));
                s1.setDuracion(Resultado.getInt(6));
                s1.setPeriodo(Resultado.getString(7));
                s1.setSemestre(Resultado.getInt(8));
                s1.setIDSALON(Resultado.getString(9));

                Lista.add(s1);
            }
            this.getControlador().CerrarConexion();
        } catch (ClassNotFoundException | SQLException error) {
            error.printStackTrace();
        }
        return Lista;
        
    }

     //metodo para insertar salones
    public String InsertarHorario(Horario s1) {
        String mensaje = "Aun no se ha creado el Horario";
        String query = "call CrearHorario (?, ?, ?, ?)";
        try {
            this.getControlador().CrearConexion();
            PreparedStatement Preparandoquery = this.getControlador().prepararSentencia(query);
            //Preparandoquery.setString(1, s1.getIDSalon());
            //Preparandoquery.setString(2, s1.getNombre());
            //Preparandoquery.setDate(3, s1.getFechaHora());
            //Preparandoquery.setInt(4, s1.getDuracion());
            Preparandoquery.executeUpdate();
            Preparandoquery.close();
            this.getControlador().CerrarConexion();
            mensaje = "Se ha creado el Horario";
        } catch (ClassNotFoundException | SQLException error) {
            error.printStackTrace();
        }
        return mensaje;

    }
    
    
}