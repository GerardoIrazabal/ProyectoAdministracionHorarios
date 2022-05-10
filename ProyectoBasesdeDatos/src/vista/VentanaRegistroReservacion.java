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
import controlador.ControladorHorario;
import controlador.ControladorReservacion;
import modelo.Curso;
import modelo.Horario;
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
    private JLabel l5;

    private JComboBox t1;
    private JTextField t2;
    private JTextField t3;
    private JTextField t4;
    private JComboBox t5;

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
        l5 = new JLabel("Horario");
        Controlador control = new Controlador();
        ArrayList<Salon> Lista = control.BuscarSalonesIDReservacion();

        String listadeSalonesA[] = new String[Lista.size()];
        for (int i = 0; i < Lista.size(); i++)

        {
            Salon s1 = Lista.get(i);
            listadeSalonesA[i] = s1.getIDSALON();
        }

        // String listadeSalonesA [] = {"IA101" , "IA102" , "IA103"};
        ControladorHorario controlhorario = new ControladorHorario();
        ArrayList<Horario> ListaHorario = controlhorario.ObtenerHorarios();

        String listadeHorario[] = new String[Lista.size()];
        for (int i = 0; i < ListaHorario.size(); i++)

        {
            Horario s1 = ListaHorario.get(i);
            listadeHorario[i] = s1.getCursito().toString() + "-" + s1.getDIASEM() + "-" + s1.getHora();
        }

        t1 = new JComboBox(listadeSalonesA);
        t2 = new JTextField(20);
        t3 = new JTextField(20);
        t4 = new JTextField(20);
        t5 = new JComboBox(listadeHorario);

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

        // t1.setText("");
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

            if (t2.getText().equals("")) {
                JOptionPane.showMessageDialog(f, "El campo de busqueda Nombre no puede estar vacio");

            } else if (t3.getText().equals("")) {
                JOptionPane.showMessageDialog(f, "El campo de busqueda FechaHora no puede estar vacio");

            } else if (t4.getText().equals("")) {
                JOptionPane.showMessageDialog(f, "El campo de busqueda Duracion no puede estar vacio");
            } else {
                DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
                Date Fecha = Date.valueOf(t3.getText());
                Reservacion s1 = new Reservacion(t1.getSelectedItem().toString(), t2.getText(), Fecha,
                        Integer.parseInt(t4.getText()));

                String ClaveYSeccion = t5.getSelectedItem().toString();
                Integer Seccion = 0;
                String Clave = "";
                Integer Diasem = 0;
                Integer Hora = 0;
                String ListaClave[] = ClaveYSeccion.split("-");
                if (ListaClave.length == 5) {
                    Clave = ListaClave[0] + "-" + ListaClave[1];
                    Seccion = Integer.parseInt(ListaClave[2]);
                    Diasem = Integer.parseInt(ListaClave[3]);
                    Hora = Integer.parseInt(ListaClave[4]);
                } else if (ListaClave.length == 4) {
                    Clave = ListaClave[0];
                    Seccion = Integer.parseInt(ListaClave[1]);
                    Diasem = Integer.parseInt(ListaClave[2]);
                    Hora = Integer.parseInt(ListaClave[3]);

                } else {
                    JOptionPane.showMessageDialog(f, "Se ha generado un error al seleccionar la clave");
                }
                ControladorReservacion Control = new ControladorReservacion();
                JOptionPane.showMessageDialog(f,Control.InsertarReservacion(s1, Clave, Seccion, Diasem, Hora));
                VentanaPrincipal ventana = new VentanaPrincipal();
                // ventana.f();
                f.dispose();

            }

        }

        // System.out.println("ERROR: el equipo no existe!");

    }

    private class CancelarHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            f.dispose();
            new VentanaPrincipal();
        }
    }
}
