package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTable;

import controlador.ControladorReservacion;
import modelo.Reservacion;

/**
 *
 * @author Chavo
 */
public class VentanaCalendario extends JFrame implements ActionListener {

    private javax.swing.JButton botonConsultar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JLabel labelTitulo, labelSeleccionar, labelFecha;
    private javax.swing.JPanel miPanelPrincipal, panelTitulo, contenedor;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private JTable Tabla;

    public VentanaCalendario() {
        initComponents();
        setTitle("Calendario de cursos");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        miPanelPrincipal = new javax.swing.JPanel();
        panelTitulo = new javax.swing.JPanel();
        contenedor = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();

        labelSeleccionar = new javax.swing.JLabel();
        botonConsultar = new javax.swing.JButton();
        botonRegresar = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        miPanelPrincipal.setBackground(Color.lightGray);
        miPanelPrincipal.setLayout(null);

        panelTitulo.setBackground(Color.black);
        panelTitulo.setLayout(null);

        labelTitulo.setFont(new java.awt.Font("Arial", 0, 48));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText(" *Cartelera*");
        labelTitulo.setForeground(Color.white);
        panelTitulo.add(labelTitulo);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int w = screenSize.width;
        labelTitulo.setBounds(5, 5, w, 60);

        labelSeleccionar.setFont(new java.awt.Font("Arial", 0, 27));
        labelSeleccionar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSeleccionar.setText(" Selecciona una Fecha: ");
        labelSeleccionar.setForeground(Color.black);
        contenedor.add(labelSeleccionar);

        Calendar c2 = new GregorianCalendar();
        jDateChooser1.setCalendar(c2);
        jDateChooser1.setLocale(new Locale("es"));
        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        jDateChooser1.getJCalendar().setMinSelectableDate(new Date());
        jDateChooser1.setBounds(5, 5, 600, 60);
        contenedor.add(jDateChooser1);
        contenedor.setBounds((w / 3 - 200), 200, (w / 2) + 200, 400);
        miPanelPrincipal.add(contenedor);

        botonConsultar.setFont(new java.awt.Font("Tahoma", 0, 24));
        botonConsultar.setText("CONSULTAR");
        botonConsultar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        contenedor.add(botonConsultar);
        botonConsultar.addActionListener(this);

        botonRegresar.setFont(new java.awt.Font("Tahoma", 0, 24));
        botonRegresar.setText("REGRESAR");
        botonRegresar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miPanelPrincipal.add(botonRegresar);
        botonRegresar.setBounds(20, 80, 190, 60);
        botonRegresar.addActionListener(this);

        miPanelPrincipal.setBounds(0, 0, 670, 350);
        panelTitulo.setBounds(0, 0, 1500, 70);

        // Column Names
        String[] columnNames = { "IDSALON", "Nombre", "FechaHora", "Duracion" };
 
        // Initializing the JTable
         //String[][] data = {
            //{ "Kundan Kumar Jha", "4031", "CSE", "Hola Reservacion" },
            //{ "Anand Jha", "6014", "IT", "Gerardo Reservacion" }
        //};

        ArrayList<Reservacion> Lista = new ControladorReservacion().ObtenerReservaciones();

        String[][] data = new String [Lista.size()][4];

        for (int i = 0; i < Lista.size(); i++)
        
        {
            Reservacion s1 = Lista.get(i);
            data[i][0] = s1.getIDSalon();
            data[i][1] = s1.getNombre();
            data[i][2] = s1.getFechaHora().toString();
            data[i][3] = s1.getDuracion()+"";
        }

        Tabla = new JTable(data, columnNames);
        Tabla.setBounds(30, 40, 200, 300);

        miPanelPrincipal.add(Tabla);
        miPanelPrincipal.add(panelTitulo);
        getContentPane().add(miPanelPrincipal);
        pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*
        if (e.getSource() == botonRegresar) {
            VentanaPrincipal admin = new VentanaPrincipal();
            admin.setVisible(true);
            this.dispose();
        }

        if (e.getSource() == botonConsultar) {
            VentanaCartelera2 admin = new VentanaCartelera2(jDateChooser1.getDate());
            admin.setVisible(true);
            this.dispose();

        }
        */
    }
}
