package vista;

import java.io.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class VentanaPrincipal implements ActionListener {

    /*---------------------------------------------------------------------
     * componentes de la ventana
     *--------------------------------------------------------------------*/
    private VentanaRegistroSalon ventanaSalon;
    private VentanaSalones ventanaListaDeSalones;
    private VentanaBuscarSalon ventanaBusquedaSalon;
    //private VentanaReservacion ventanaListaDeReservaciones;

    private JFrame f;
    private JMenuBar mb;
    private JMenu m1;
    private JMenu m2;
    private JMenu m3;
    private JMenu m4;

    private JPanel p;
    private JTextArea t;
    private JScrollPane s;

    private JMenuItem ms0;
    private JMenuItem ms1;
    private JMenuItem ms2;
    private JMenuItem ms3;
    private JMenuItem mj1;
    private JMenuItem mr1;
    private JMenuItem mp1;

    /*---------------------------------------------------------------------
     * definición de la consola
     *--------------------------------------------------------------------*/

    public VentanaPrincipal() {
        ventanaSalon = new VentanaRegistroSalon();
        ventanaListaDeSalones = new VentanaSalones();
        //ventanaListaDeReservaciones = new VentanaReservaciones();
        ventanaBusquedaSalon = new VentanaBuscarSalon();
        // barra de menús
        f = new JFrame("Sistema de Administracion de Horarios UDLAP");
        mb = new JMenuBar();
        m1 = new JMenu("Administrar Salones");
        m2 = new JMenu("Administrar Cursos");
        m3 = new JMenu("Administrar Reservaciones");
        m4 = new JMenu("Administrar Periodos");
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        mb.add(m4);
        f.setJMenuBar(mb);

        // area de texto
        p = new JPanel();
        p.setBorder(new TitledBorder(new EtchedBorder(), ""));
        t = new JTextArea(20, 60);
        t.setText("Sistema de Administracion de Horarios UDLAP");
        t.setForeground(Color.white);
        t.setBackground(new Color(0, 0, 128));
        t.setEditable(false); // non-editable
        s = new JScrollPane(t);
        s.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        p.add(s);
        f.add(p);
        //System.setOut(new PrintStream(new CustomOutputStream(t)));

        // menú Simulación
        ms0 = new JMenuItem("Crear Salon");
        ms1 = new JMenuItem("Lista de Salones");
        ms2 = new JMenuItem("Buscar Salon");
        ms3 = new JMenuItem("Salir");
        ms0.addActionListener(this);
        ms1.addActionListener(this);
        ms2.addActionListener(this);
        ms3.addActionListener(this);
        m1.add(ms0);
        m1.add(ms1);
        m1.add(ms2);
        m1.addSeparator();
        m1.add(ms3);

        // menú Jugador
        mj1 = new JMenuItem("Crear Curso");
        mj1.addActionListener(this);
        m2.add(mj1);

        // menú Jugador
        mr1 = new JMenuItem("Crear Reservaciones");
        mr1.addActionListener(this);
        m3.add(mr1);

        // menú Periodos
        mp1 = new JMenuItem("Crear Periodo");
        mp1.addActionListener(this);
        m4.add(mp1);

        // frame principal
        f.addWindowListener(new CloseHandler());
        f.setLocationRelativeTo(null);
        f.pack();
        f.setResizable(false);
        f.setVisible(true);
    }

    /*---------------------------------------------------------------------
     * acciones del sistema
     *--------------------------------------------------------------------*/

    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Crear Salon")) {
            f.dispose(); // Eliminamos ventana actual
            ventanaSalon.setVisible(); // Cargamos la nueva con la lista

         }else if (e.getActionCommand().equals("Buscar Salon")) {
                f.dispose(); // Eliminamos ventana actual
                ventanaBusquedaSalon.setVisible(); // Cargamos la nueva con la lista

        } else if (e.getActionCommand().equals("Salir")) {
            System.exit(0);

        } else if (e.getActionCommand().equals("Lista de Salones")) {
            f.dispose(); // Eliminamos ventana actual
            ventanaListaDeSalones.setVisible(); // Cargamos la nueva con la lista)
        } else if (e.getActionCommand().equals("Lista de Reservaciones")) {
            f.dispose(); // Eliminamos ventana actual
            //ventanaListaDeReservaciones.setVisible(); // Cargamos la nueva con la lista)
        }
    }

    /*---------------------------------------------------------------------
     * clases utilizadas por la ventana principal
     *--------------------------------------------------------------------*/

    private class CloseHandler extends WindowAdapter {

        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    private class CustomOutputStream extends OutputStream {

        private JTextArea textArea;

        public CustomOutputStream(JTextArea textArea) {
            this.textArea = textArea;
        }

        public void write(int b) throws IOException {
            // redirects data to the text area
            textArea.append(String.valueOf((char) b));
            // scrolls the text area to the end of data
            textArea.setCaretPosition(textArea.getDocument().getLength());
        }
    }
}
