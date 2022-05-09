package vista;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;

import controlador.Controlador;
import controlador.ControladorCurso;
import controlador.ControladorHorario;
import modelo.Curso;
import modelo.Horario;
import modelo.Periodo;
import modelo.Salon;

public class VentanaRegistroHorario {

    /*---------------------------------------------------------------------
     * componentes de la ventana
     *--------------------------------------------------------------------*/

    private JFrame f;
    private JPanel p;

    private JLabel l1;
    private JLabel l2;
    private JLabel l3;
    private JLabel l4;
    private JLabel l5;
    private JLabel l6;
    private JLabel l7;
    private JLabel l8;

    private JComboBox t1;
    private JComboBox t2;
    private JTextField t3;
    private JTextField t4;
    private JTextField t5;
    private JComboBox t6;
    private JTextField t7;
    private JComboBox t8;

    private JButton b1;
    private JButton b2;

    /*---------------------------------------------------------------------
     * constructor
     *--------------------------------------------------------------------*/

    public VentanaRegistroHorario() {
        // campos de información
        f = new JFrame("Datos del Horario");
        p = new JPanel();
        p.setLayout(new GridLayout(5, 2));

        ControladorCurso control = new ControladorCurso();
        ArrayList <Curso> Lista = control.obtenerNombresCursos();

        String listadeCurso [] = new String [Lista.size()];
        for (int i = 0; i < Lista.size(); i++)
        
        {
            Curso s1 = Lista.get(i);
            listadeCurso[i] = s1.toString();
        }
        ArrayList <Salon> ListadeSalones = control.BuscarSalonesIDReservacion();

        String listadeSalonesA [] = new String [ListadeSalones.size()];
        for (int i = 0; i < ListadeSalones.size(); i++)
        
        {
            Salon s1 = ListadeSalones.get(i);
            listadeSalonesA [i] = s1.getIDSALON();
        }
        
        String listadeDias [] = {"Lunes", "Martes", "Miercoles", "Jueves" ,"Viernes", "Sabado"};

        Date FechaActual = new Date();

        ArrayList<Periodo> ListaPeriodos =control.ObtenerYCrearPeriodos(FechaActual); 
        String ListaDePeriodos [] = new String [ListaPeriodos.size()];

        for (int i = 0; i < ListaPeriodos.size(); i++)
        
        {
            Periodo s1 = ListaPeriodos.get(i);
            ListaDePeriodos [i] = s1.getTitulo();
        }

        l1 = new JLabel("Clave y seccion: ");
        l2 = new JLabel("Diasem: ");
        l3 = new JLabel("Hora: ");
        l4 = new JLabel("Minuto: ");
        l5 = new JLabel("Duracion: ");
        l6 = new JLabel ("Periodo: ");
        l7 = new JLabel ("Semestre ");
        l8 = new JLabel ("IDSALON ");

        t1 = new JComboBox(listadeCurso);
        t2 = new JComboBox(listadeDias);
        t3 = new JTextField(20);
        t4 = new JTextField(20);
        t5 = new JTextField(20);
        t6 = new JComboBox(ListaDePeriodos);
        t7 = new JTextField(20);
        t8 = new JComboBox(listadeSalonesA);

        p.add(l1);
        p.add(t1);
        p.add(l2);
        p.add(t2);
        p.add(l3);
        p.add(t3);
        p.add(l4);
        p.add(t4);
        p.add(l5);
        p.add(t5);
        p.add(l6);
        p.add(t6);
        p.add(l7);
        p.add(t7);
        p.add(l8);
        p.add(t8);

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

        t3.setText("");
        t4.setText("");


        f.setVisible(true);
    }

    /*---------------------------------------------------------------------
     * clases privadas
     *--------------------------------------------------------------------*/

    private class CrearHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //Curso s1 = new Curso(t1.getSelectedItem().toString(), Integer.parseInt(t2.getText()), t3.getText(), t4.getText());
            ControladorCurso Control = new ControladorCurso();
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
