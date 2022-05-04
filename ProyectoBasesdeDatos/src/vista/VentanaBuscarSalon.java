package vista;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import controlador.Controlador;
import modelo.Salon;

public class VentanaBuscarSalon {

    /*---------------------------------------------------------------------
     * componentes de la ventana
     *--------------------------------------------------------------------*/

    private JFrame f;
    private JPanel p;

    private JLabel l1;

    private JTextField t1;

    private JButton b1;
    private JButton b2;

    // Declaration of object of JRadioButton class.
    private JRadioButton jRadioButton1;

    // Declaration of object of JRadioButton class.
    private JRadioButton jRadioButton2;

    // Declaration of object of JRadioButton class.
    private JRadioButton jRadioButton3;

    // Declaration of object of ButtonGroup class.
    private ButtonGroup G1;

    /*---------------------------------------------------------------------
     * constructor
     *--------------------------------------------------------------------*/

    public VentanaBuscarSalon() {
        // campos de información
        f = new JFrame("Busqueda de salon");
        p = new JPanel();
        p.setLayout(new GridLayout(5, 2));

        l1 = new JLabel("Criterio de Busqueda: ");

        t1 = new JTextField(20);

        // Initialization of object of "JRadioButton" class.
        jRadioButton1 = new JRadioButton();

        // Initialization of object of "JRadioButton" class.
        jRadioButton2 = new JRadioButton();

        // Initialization of object of "JRadioButton" class.
        jRadioButton3 = new JRadioButton();

        // Initialization of object of "ButtonGroup" class.
        G1 = new ButtonGroup();

        // setText(...) function is used to set text of radio button.
        // Setting text of "jRadioButton2".
        jRadioButton1.setText("IDSalon");

        // Setting text of "jRadioButton4".
        jRadioButton2.setText("Capacidad");

        jRadioButton3.setText("Tipo");

        // Setting Bounds of "jRadioButton2".
        jRadioButton1.setBounds(120, 30, 120, 50);

        // Setting Bounds of "jRadioButton4".
        jRadioButton2.setBounds(250, 30, 80, 50);

        p.add(l1);
        p.add(t1);
        p.add(jRadioButton1);
        p.add(jRadioButton2);
        p.add(jRadioButton3);
        G1.add(jRadioButton1);
        G1.add(jRadioButton2);
        G1.add(jRadioButton3);

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

        f.setVisible(true);
    }

    /*---------------------------------------------------------------------
     * clases privadas
     *--------------------------------------------------------------------*/

    private class CrearHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Buscando Salon");

            Controlador Control = new Controlador();
            String CriterioDeBusqueda = " ";

            ArrayList<Salon> listadeBusqueda = new ArrayList<>();
            String CampoDeBusqueda = t1.getText();

            if (CampoDeBusqueda != null && !CampoDeBusqueda.equals(""))

            {
                if (jRadioButton1.isSelected()) {
                    CriterioDeBusqueda = "IDSALON";
                    listadeBusqueda.add(Control.BuscarSalonID(t1.getText()));
                    JOptionPane.showMessageDialog(f, listadeBusqueda.get(0));

                } else if (jRadioButton2.isSelected()) {
                    CriterioDeBusqueda = "CAPACIDAD";
                    Integer Capacidad = Integer.parseInt(t1.getText());
                    listadeBusqueda = Control.BuscarSalonesCapacidad(Capacidad);
                    VentanaSalones ventana = new VentanaSalones(listadeBusqueda);
                    ventana.setVisible();
                    // ventana.f();
                    f.dispose();

                } else if (jRadioButton3.isSelected()) {
                    CriterioDeBusqueda = "TIPO";
                    String tipo = t1.getText();
                    listadeBusqueda = Control.BuscarSalonTIPO(tipo);
                    VentanaSalones ventana = new VentanaSalones(listadeBusqueda);
                    ventana.setVisible();
                    // ventana.f();
                    f.dispose();
                }

                // System.out.println("ERROR: el equipo no existe!");
            } else {
                JOptionPane.showMessageDialog(f, "El campo de busqueda no puede estar vacio");
            }

        }
    }

    private class CancelarHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            f.dispose();
            new VentanaPrincipal();
        }
    }
}
