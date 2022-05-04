package modelo;

import controlador.Controlador;
import vista.VentanaCalendario;
import vista.VentanaPrincipal;

import java.util.ArrayList;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        /*
        System.out.println("Hola Mundo");
        Controlador Control = new Controlador();
        Salon s1 = new Salon("IA108", 40, "SC");
        System.out.println(Control.InsertarSalon(s1));
        ArrayList <Salon> Lista = Control.ObtenerSalones();
        System.out.println (Lista.size());
        System.out.println (Lista);
        Salon s2 = Control.BuscarSalonID("IA106");
        System.out.println (s2);
        ArrayList <Salon> Lista2 = Control.BuscarSalonesCapacidad(50);
        System.out.println (Lista2);
        */
        new VentanaPrincipal(); 
        //new VentanaCalendario();
    } 
}
