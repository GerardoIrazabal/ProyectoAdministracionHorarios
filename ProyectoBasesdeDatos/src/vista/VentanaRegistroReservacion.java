package vista;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.*;

import controlador.Controlador;
import controlador.ControladorCurso;
import controlador.ControladorReservacion;
import modelo.Curso;
import modelo.Reservacion;
import modelo.Salon;

public class VentanaRegistroReservacion {

    /*---------------------------------------------------------------------
     * componentes de la ventana
     *--------------------------------------------------------------------*/

    private JFrame f;
    private JPanel p;

    private JLabel l1;
    private JLabel l2;
    private JLabel l3;
    private JLabel l4;

    private JComboBox t1;
    private JTextField t2;
    private JTextField t3;
    private JTextField t4;

    private JButton b1;
    private JButton b2;

    /*---------------------------------------------------------------------
     * constructor
     *--------------------------------------------------------------------*/

    public VentanaRegistroReservacion() {
        // campos de información
        f = new JFrame("Datos de la reservacion");
        p = new JPanel();
        p.setLayout(new GridLayout(5, 2));

        l1 = new JLabel("IDSALON: ");
        l2 = new JLabel("Nombre: ");
        l3 = new JLabel("FechaHora: ");
        l4 = new JLabel("Duracion: ");
        Controlador control = new Controlador();
        ArrayList <Salon> Lista = control.BuscarSalonesIDReservacion();

        String listadeSalonesA [] = new String [Lista.size()];
        for (int i = 0; i < Lista.size(); i++)
        
        {
            Salon s1 = Lista.get(i);
            listadeSalonesA [i] = s1.getIDSALON();
        }

        //String listadeSalonesA [] = {"IA101" , "IA102" , "IA103"};


        t1 = new JComboBox(listadeSalonesA);
        t2 = new JTextField(20);
        t3 = new JTextField(20);
        t4 = new JTextField(20);

        p.add(l1);
        p.add(t1);
        p.add(l2);
        p.add(t2);
        p.add(l3);
        p.add(t3);
        p.add(l4);
        p.add(t4);

        // botones de creación/cancelación
        b1 = new JButton("Crear");
        b1.addActionListener(new CrearHandler());
        p.add(b1);

        b2 = new JButton("Cancelar");
        b2.addActionListener(new CancelarHandler());
        p.add(b2);

        // frame principal
        f.add(p);
        f.pack();
        f.setResizable(false);
        f.setVisible(false);
    }

    /*---------------------------------------------------------------------
     * acciones del sistema
     *--------------------------------------------------------------------*/

    public void setVisible() {

        //t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");


        f.setVisible(true);
    }

    /*---------------------------------------------------------------------
     * clases privadas
     *--------------------------------------------------------------------*/

    private class CrearHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
            Date Fecha = Date.valueOf(t3.getText());
            Reservacion s1 = new Reservacion(t1.getSelectedItem().toString(), t2.getText(), Fecha , Integer.parseInt(t4.getText()));
            ControladorReservacion Control = new ControladorReservacion();
            System.out.println(Control.InsertarReservacion(s1));
            VentanaPrincipal ventana = new VentanaPrincipal();
            // ventana.f();
            f.dispose();

            // System.out.println("ERROR: el equipo no existe!");

        }
    }

    private class CancelarHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            f.dispose();
            new VentanaPrincipal();
        }
    }
}
