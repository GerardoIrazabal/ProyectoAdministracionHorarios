package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Curso;
import modelo.Reservacion;

public class ControladorCurso extends Controlador {

    public ControladorCurso (){
        super();
    }

    public ArrayList <Curso> obtenerNombresCursos() {

        ArrayList<Curso> Lista = new ArrayList<>();
        try {
            this.getControlador().CrearConexion();
            String query = " Select CLAVE, SECC FROM CURSOS";
            ResultSet Resultado = this.getControlador().ejecutarSentencia(query);
            while (Resultado.next()) {
                Curso s1 = new Curso(Resultado.getString(1), Resultado.getInt(2),
                    "", "");
                Lista.add(s1);
            }
            this.getControlador().CerrarConexion();
        } catch (ClassNotFoundException | SQLException error) {
            error.printStackTrace();
        }
        return Lista;
        
    }

    public ArrayList <Curso> ObtenerCursos() {

        ArrayList<Curso> Lista = new ArrayList<>();
        try {
            this.getControlador().CrearConexion();
            String query = "select * FROM Cursos";
            ResultSet Resultado = this.getControlador().ejecutarSentencia(query);
            while (Resultado.next()) {
                Curso s1 = new Curso(Resultado.getString(1), Resultado.getInt(2),
                        Resultado.getString(3), Resultado.getString(4));
                Lista.add(s1);
            }
            this.getControlador().CerrarConexion();
        } catch (ClassNotFoundException | SQLException error) {
            error.printStackTrace();
        }
        return Lista;
        
    }

      // metodo para insertar curso
      public String InsertarCurso(Curso s1) {
        String mensaje = "Aun no se ha creado el curso";
        String query = "insert into Cursos values (?, ?, ? ,?)";
        try {
            this.getControlador().CrearConexion();
            PreparedStatement Preparandoquery = this.getControlador().prepararSentencia(query);
            Preparandoquery.setString(1, s1.getClave());
            Preparandoquery.setInt(2, s1.getSecc());
            Preparandoquery.setString(3, s1.getTitulo());
            Preparandoquery.setString(4, s1.getProf());
            Preparandoquery.executeUpdate();
            Preparandoquery.close();
            this.getControlador().CerrarConexion();
            mensaje = "Se ha creado el curso";
        } catch (ClassNotFoundException | SQLException error) {
            error.printStackTrace();
        }
        return mensaje;

    }
    
}
