package modelo;

import controlador.Controlador;
import controlador.ControladorHorario;
import controlador.TransactionMySQL;
import vista.VentanaCalendario;
import vista.VentanaPrincipal;

import java.util.ArrayList;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {

        new VentanaPrincipal(); 
        //new VentanaCalendario();

        /*try {
            TransactionMySQL transaccion = new TransactionMySQL();

            transaccion.ejecutarSentenciaentransaccion("insert into Salones values ('IA114', 50, 'C');");
            transaccion.ejecutarSentenciaentransaccion("insert into Salones values ('IA113', 22, 'SC');");

            transaccion.FinalizarTransaccion();
        } catch (Exception e) {
            
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    */
    /*ControladorHorario Controlador = new ControladorHorario();
    ArrayList<Horario> Lista = Controlador.ObtenerHorarios();
    for (int index = 0; index < Lista.size(); index++) {
        System.out.println(Lista.get(index));
    } 
    System.out.println(Controlador.ObtenerHorarios());
    */

} 
}
