package vista;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import controlador.Controlador;
import controlador.ControladorCurso;
import modelo.Curso;
import modelo.Salon;

public class VentanaRegistroCurso {

    /*---------------------------------------------------------------------
     * componentes de la ventana
     *--------------------------------------------------------------------*/

    private JFrame f;
    private JPanel p;

    private JLabel l1;
    private JLabel l2;
    private JLabel l3;
    private JLabel l4;

    private JTextField t1;
    private JTextField t2;
    private JTextField t3;
    private JTextField t4;

    private JButton b1;
    private JButton b2;

    /*---------------------------------------------------------------------
     * constructor
     *--------------------------------------------------------------------*/

    public VentanaRegistroCurso() {
        // campos de información
        f = new JFrame("Datos del Curso");
        p = new JPanel();
        p.setLayout(new GridLayout(5, 2));

        l1 = new JLabel("Clave: ");
        l2 = new JLabel("Seccion: ");
        l3 = new JLabel("Titulo: ");
        l4 = new JLabel("Prof: ");

        t1 = new JTextField(20);
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

        t1.setText("");
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
            Curso s1 = new Curso(t1.getText(), Integer.parseInt(t2.getText()), t3.getText(), t4.getText());
            ControladorCurso Control = new ControladorCurso();
            System.out.println(Control.InsertarCurso(s1));
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
