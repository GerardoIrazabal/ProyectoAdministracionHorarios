package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Curso;
import modelo.Salon;

public class Controlador {

    private BaseDeDatos DB;
    private ControladorConexion Controlador;

    public Controlador() {
        DB = new BaseDeDatos();
        Controlador = new ControladorConexion(DB);

    }

    // método de bases de datos "get" para obtener Salones
    public ArrayList<Salon> ObtenerSalones() {
        ArrayList<Salon> Lista = new ArrayList<>();
        try {
            Controlador.CrearConexion();
            String query = "select * FROM Salones";
            ResultSet Resultado = Controlador.ejecutarSentencia(query);
            while (Resultado.next()) {
                Salon s1 = new Salon(Resultado.getString(1), Resultado.getInt(2),
                        Resultado.getString(3));
                Lista.add(s1);
            }
            Controlador.CerrarConexion();
        } catch (ClassNotFoundException | SQLException error) {
            error.printStackTrace();
        }
        return Lista;
    }

    // método de bases de datos "search" para buscar Salones por el ID
    public Salon BuscarSalonID(String ID) {
        Salon nSalon = new Salon();
        try {
            Controlador.CrearConexion();
            String query = "select * FROM Salones where IDSALON = '" + ID + "' limit 1";
            ResultSet Resultado = Controlador.ejecutarSentencia(query);
            if (Resultado.next()) {
                Salon s1 = new Salon(Resultado.getString(1), Resultado.getInt(2),
                        Resultado.getString(3));
                nSalon = s1;
            }
            Controlador.CerrarConexion();
        } catch (ClassNotFoundException | SQLException error) {
            error.printStackTrace();
        }
        return nSalon;
  
    }
     // método de bases de datos "search" para buscar Salones por la CAPACIDAD
    public ArrayList<Salon> BuscarSalonesCapacidad(Integer CAPACIDAD) {
        ArrayList<Salon> Lista = new ArrayList<>();
        try {
            Controlador.CrearConexion();
            String query = "select * FROM Salones where CAPACIDAD = '" + CAPACIDAD + "' ";
            ResultSet Resultado = Controlador.ejecutarSentencia(query);
            while (Resultado.next()) {
                Salon s1 = new Salon(Resultado.getString(1), Resultado.getInt(2),
                        Resultado.getString(3));
                Lista.add(s1);
            }
            Controlador.CerrarConexion();
        } catch (ClassNotFoundException | SQLException error) {
            error.printStackTrace();
        }
        return Lista;
    }

    // método de bases de datos "search" para buscar Salones por el tipo
    public ArrayList<Salon> BuscarSalonTIPO(String TIPO) {
        ArrayList<Salon> Lista = new ArrayList<>();
        try {
            Controlador.CrearConexion();
            String query = "select * FROM Salones where TIPO = '" + TIPO + "' ";
            ResultSet Resultado = Controlador.ejecutarSentencia(query);
            while (Resultado.next()) {
                Salon s1 = new Salon(Resultado.getString(1), Resultado.getInt(2),
                        Resultado.getString(3));
                Lista.add(s1);
            }
            Controlador.CerrarConexion();
        } catch (ClassNotFoundException | SQLException error) {
            error.printStackTrace();
        }
        return Lista;
    }

    // metodo para insertar salones
    public String InsertarSalon(Salon s1) {
        String mensaje = "Aun no se ha creado el salon";
        String query = "insert into Salones values (?, ?, ?)";
        try {
            Controlador.CrearConexion();
            PreparedStatement Preparandoquery = Controlador.prepararSentencia(query);
            Preparandoquery.setString(1, s1.getIDSALON());
            Preparandoquery.setInt(2, s1.getCAPACIDAD());
            Preparandoquery.setString(3, s1.getTIPO());
            Preparandoquery.executeUpdate();
            Preparandoquery.close();
            Controlador.CerrarConexion();
            mensaje = "Se ha creado el salon";
        } catch (ClassNotFoundException | SQLException error) {
            error.printStackTrace();
        }
        return mensaje;

    }

    // método de bases de datos "get" para Cursos
    public ArrayList<Curso> ObtenerCurso() {
        ArrayList<Curso> Lista = new ArrayList<>();
        try {
            Controlador.CrearConexion();
            String query = "select * FROM Cursos";
            ResultSet Resultado = Controlador.ejecutarSentencia(query);
            while (Resultado.next()) {
                // Curso s1 = new Curso(Resultado.getString (1), Resultado.getInt (2),
                // Resultado.getString (3));
                // Lista.add(s1);
            }
            Controlador.CerrarConexion();
        } catch (ClassNotFoundException | SQLException error) {
            error.printStackTrace();
        }
        return Lista;
    }

}
