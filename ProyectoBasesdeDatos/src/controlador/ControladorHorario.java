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

    public ControladorHorario() {
        super();
    }

    public ArrayList<Horario> ObtenerHorarios() {

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

    public ArrayList<Horario> BuscarHorariosCurso(String Clave, String Seccion ) {

        ArrayList<Horario> Lista = new ArrayList<>();
        try {
            this.getControlador().CrearConexion();
            String query = "select Horarios.CLAVE, HORARIOS.SECC, DIASEM, HORA, MINUTO, DURACION, PERIODO, SEMESTRE, IDSALON, TITULO FROM Horarios  inner join Cursos on Horarios.CLAVE = Cursos.CLAVE where Horarios.CLAVE = '" + Clave + "' and Horarios.SECC = '" + Seccion
            + "'";
            ResultSet Resultado = this.getControlador().ejecutarSentencia(query);
            while (Resultado.next()) {
                Horario s1 = new Horario();

                s1.setCursito(new Curso(Resultado.getString(1), Resultado.getInt(2), Resultado.getString(10), ""));
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

    public ArrayList<Horario> BuscarHorariosPeriodo(String Titulo ) {

        ArrayList<Horario> Lista = new ArrayList<>();
        try {
            this.getControlador().CrearConexion();
            String query = "select Horarios.CLAVE, HORARIOS.SECC, DIASEM, HORA, MINUTO, DURACION, PERIODO, SEMESTRE, IDSALON, TITULO FROM Horarios  inner join Cursos on Horarios.CLAVE = Cursos.CLAVE where Periodo = '" + Titulo + "'";
            ResultSet Resultado = this.getControlador().ejecutarSentencia(query);
            while (Resultado.next()) {
                Horario s1 = new Horario();

                s1.setCursito(new Curso(Resultado.getString(1), Resultado.getInt(2), Resultado.getString(10), ""));
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

    public ArrayList<Horario> BuscarHorariosSalon(String IDSALON ) {

        ArrayList<Horario> Lista = new ArrayList<>();
        try {
            this.getControlador().CrearConexion();
            String query = "select Horarios.CLAVE, HORARIOS.SECC, DIASEM, HORA, MINUTO, DURACION, PERIODO, SEMESTRE, IDSALON, TITULO FROM Horarios  inner join Cursos on Horarios.CLAVE = Cursos.CLAVE where IDSALON = '" + IDSALON + "'";
            ResultSet Resultado = this.getControlador().ejecutarSentencia(query);
            while (Resultado.next()) {
                Horario s1 = new Horario();

                s1.setCursito(new Curso(Resultado.getString(1), Resultado.getInt(2), Resultado.getString(10), ""));
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

    public ArrayList<Horario> buscarHorarios(String Seccion, String Clave, String Periodo, String IDsalon) {

        ArrayList<Horario> Lista = new ArrayList<>();
        try {
            this.getControlador().CrearConexion();
            String query = "select * FROM Horarios where CLAVE = '" + Clave + "' and SECC = '" + Seccion
                    + "' and PERIODO = '" + Periodo + "' and IDSALON = '" + IDsalon + "'";
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

    // metodo para insertar salones
    public String InsertarHorario(Horario s1) {
        String mensaje = "Aun no se ha creado el Horario";
        String query = "insert into Horarios values (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        

        try {
            if (HorarioDisponible(s1)){
            TransactionMySQL transaccion = new TransactionMySQL();
            PreparedStatement Preparandoquery = transaccion.prepararSentencia(query);

            Preparandoquery.setString(1, s1.getCursito().getClave());
            Preparandoquery.setInt(2, s1.getCursito().getSecc());
            Preparandoquery.setInt(3, s1.getDIASEM());
            Preparandoquery.setInt(4, s1.getHora());
            Preparandoquery.setInt(5, s1.getMinuto());
            Preparandoquery.setInt(6, s1.getDuracion());
            Preparandoquery.setString(7, s1.getPeriodo());
            Preparandoquery.setInt(8, s1.getSemestre());
            Preparandoquery.setString(9, s1.getIDSALON());

            // transaccion.ejecutarSentenciaentransaccion();
            Preparandoquery.executeUpdate();

            transaccion.FinalizarTransaccion();
            mensaje = "Se ha creado el horario";

            }
            else mensaje = "No se pudo crear ya que se sobrepone el curso con los horarios";
        } catch (Exception e) {

            mensaje = e.getLocalizedMessage();
        }
        return mensaje;

    }
    // UPDATE DE LOS HORARIOS

    public String actualizarHorario(Horario s1) {
        String mensaje = "Aun no se ha actualizado el Horario";
        String query = "update Horarios  set HORA = ?, DIASEM = ?, MINUTO = ?, PERIODO = ?, IDSALON = ? where CLAVE = ? and SECC = ?";

        try {
            if (HorarioDisponible(s1)) {
                TransactionMySQL transaccion = new TransactionMySQL();

                PreparedStatement Preparandoquery = transaccion.prepararSentencia(query);

                Preparandoquery.setInt(1, s1.getHora());
                Preparandoquery.setInt(2, s1.getDIASEM());
                Preparandoquery.setInt(3, s1.getMinuto());
                Preparandoquery.setString(4, s1.getPeriodo());
                Preparandoquery.setString(5, s1.getIDSALON());
                Preparandoquery.setString(6, s1.getCursito().getClave());
                Preparandoquery.setInt(7, s1.getCursito().getSecc());

                Preparandoquery.executeUpdate();

                transaccion.FinalizarTransaccion();

                mensaje = "Se ha actualizado el horario";

            } else {
                mensaje = "Hay sobreposición, No se ha podido registrar ya que existe un horario";
            }

        } catch (Exception e) {

            mensaje = e.getLocalizedMessage();
        }
        return mensaje;

    }

    private boolean HorarioDisponible(Horario s1) {

        try {
            this.getControlador().CrearConexion();
            // checando la sobreposicion de cursos
            Integer HoraInicial = s1.getHora();
            Integer Horas = s1.getDuracion() / 60;
            if (Horas % 60 != 0) {
                Horas++;
            }
            String ValidacionHoras = "";
            for (int index = 1; index <= Horas; index++) {
                ValidacionHoras += " or HORA = '" + (HoraInicial + index) + "'";

            }
            String queryDeBusqueda = "Select count(*) FROM Horarios where IDSALON = '" + s1.getIDSALON()
                    + "' and PERIODO = '" + s1.getPeriodo() + "' and DIASEM = '" + s1.getDIASEM() + "' and (HORA = '"
                    + s1.getHora() + "' " + ValidacionHoras + ")";
            System.out.println(queryDeBusqueda);
            ResultSet Resultado = this.getControlador().ejecutarSentencia(queryDeBusqueda);
            Integer Cantidad = -1;
            if (Resultado.next()) {
                Cantidad = Resultado.getInt(1);
                System.out.println(Cantidad);
                if (Cantidad == 0) {
                    return true;
                }
            }
            this.getControlador().CerrarConexion();
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return false;

    }

    // metodo para insertar salones

    public String SuprimirHorario(Horario s1) {
        String mensaje = "Aun no se ha creado el Horario";
        //Suprimir cursos del horario, lo que se conecta si hay una reservacion, tambien se suprime.
        String query = "delete from Horarios where CLAVE = ? and SECC = ? and DIASEM = ? and HORA = ?";
        

        try {
            
            TransactionMySQL transaccion = new TransactionMySQL();
            PreparedStatement Preparandoquery = transaccion.prepararSentencia(query);

            Preparandoquery.setString(1, s1.getCursito().getClave());
            Preparandoquery.setInt(2, s1.getCursito().getSecc());
            Preparandoquery.setInt(3, s1.getDIASEM());
            Preparandoquery.setInt(4, s1.getHora());

            // transaccion.ejecutarSentenciaentransaccion();
            Preparandoquery.executeUpdate();

            transaccion.FinalizarTransaccion();
            mensaje = "Se ha suprimido el horario";

            
        } catch (Exception e) {

            mensaje = e.getLocalizedMessage();
        }
        return mensaje;

    }

}