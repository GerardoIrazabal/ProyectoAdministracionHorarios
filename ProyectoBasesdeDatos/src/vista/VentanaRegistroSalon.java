package vista;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import controlador.Controlador;
import modelo.Salon;

public class VentanaRegistroSalon {

    /*---------------------------------------------------------------------
     * componentes de la ventana
     *--------------------------------------------------------------------*/

    private JFrame f;
    private JPanel p;

    private JLabel l1;
    private JLabel l2;
    private JLabel l3;

    private JTextField t1;
    private JTextField t2;
    private JComboBox t3;

    private JButton b1;
    private JButton b2;

    /*---------------------------------------------------------------------
     * constructor
     *--------------------------------------------------------------------*/

    public VentanaRegistroSalon() {

        String listadeSalonesT [] = {"SC", "C"};
        
        // campos de información
        f = new JFrame("Datos del Salon");
        p = new JPanel();
        p.setLayout(new GridLayout(5, 2));

        l1 = new JLabel("IDSalon: ");
        l2 = new JLabel("Capacidad: ");
        l3 = new JLabel("Tipo: ");

        t1 = new JTextField(20);
        t2 = new JTextField(20);
        t3 = new JComboBox(listadeSalonesT);

        p.add(l1);
        p.add(t1);
        p.add(l2);
        p.add(t2);
        p.add(l3);
        p.add(t3);

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

        f.setVisible(true);
    }

    /*---------------------------------------------------------------------
     * clases privadas
     *--------------------------------------------------------------------*/

    private class CrearHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if (t1.getText().equals("")){
                JOptionPane.showMessageDialog(f, "El campo de busqueda IDSALON no puede estar vacio");  
                
            }else if (t2.getText().equals("")){
                    JOptionPane.showMessageDialog(f, "El campo de busqueda capacidad no puede estar vacio");
                    
                    }else {

            Salon s1 = new Salon(t1.getText(), Integer.parseInt(t2.getText()), t3.getSelectedItem().toString());
            Controlador Control = new Controlador();
            JOptionPane.showMessageDialog(f, Control.InsertarSalon(s1));
            VentanaSalones ventana = new VentanaSalones();
             ventana.setVisible();
            f.dispose();
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
