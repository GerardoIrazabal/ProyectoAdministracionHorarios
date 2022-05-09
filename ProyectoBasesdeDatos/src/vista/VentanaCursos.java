package vista;

import java.io.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import controlador.Controlador;
import modelo.Curso;


/**
 * VentanaSalones
 */
public class VentanaCursos implements ActionListener { 

    /*---------------------------------------------------------------------
     * componentes de la ventana
     *--------------------------------------------------------------------*/
    private VentanaRegistroCurso ventanaCurso;
    private JTable Tabla;

    private JFrame f;
    private JMenuBar mb;
    private JMenu m1;
    private JMenu m2;
    private JMenu m3;

    private JPanel p;
    private JTextArea t;
    private JScrollPane s;

    private JMenuItem ms0;
    private JMenuItem ms1;
    private JMenuItem ms2;
    private JMenuItem ms3;
    private JMenuItem mj1;
    private JMenuItem mr1;
    private ArrayList<Curso> Lista;
    private Controlador Control;


    /*---------------------------------------------------------------------
     * definición de la consola
     *--------------------------------------------------------------------*/

    public VentanaCursos(ArrayList<Curso> listadeCursos) {
        Lista = listadeCursos;

        Control = new Controlador();
        ventanaCurso = new VentanaRegistroCurso();

        String[][] data = new String [Lista.size()][4];

        for (int i = 0; i < Lista.size(); i++)
        
        {
            Curso s1 = Lista.get(i);
            data[i][0] = s1.getClave();
            data[i][1] = s1.getSecc()+"";
            data[i][2] = s1.getTitulo();
            data[i][3] = s1.getProf();
        }

       /* String[][] data = {
            { "Kundan Kumar Jha", "4031", "CSE" },
            { "Anand Jha", "6014", "IT" }
        };
         */
 
        // Column Names
        String[] columnNames = { "Clave", "Secc", "Titulo", "Prof" };
 
        // Initializing the JTable
        Tabla = new JTable(data, columnNames);
        Tabla.setBounds(30, 40, 200, 300);
 
        // adding it to JScrollPane
        //JScrollPane sp = new JScrollPane(Tabla);
        f = new JFrame("Sistema de Administracion de Horarios UDLAP");
        //f.add(sp);


        // barra de menús
        f = new JFrame("Sistema de Administracion de Horarios UDLAP");
        mb = new JMenuBar();
        m1 = new JMenu("Administrar Salones");
        m2 = new JMenu("Administrar Cursos");
        m3 = new JMenu("Administrar Reservaciones");
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        f.setJMenuBar(mb);

        // area de texto
        p = new JPanel();
        p.setBorder(new TitledBorder(new EtchedBorder(), ""));
        s = new JScrollPane(Tabla);
        s.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        p.add(s);
        f.add(p);

        // menú Simulación
        ms0 = new JMenuItem("Crear Salon");
        ms1 = new JMenuItem("Lista de Salones");
        ms2 = new JMenuItem("Lista de Reservaciones");
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
        mj1 = new JMenuItem("Alta Jugador");
        mj1.addActionListener(this);
        m2.add(mj1);

        // menú Jugador
        mr1 = new JMenuItem("Reporte General");
        mr1.addActionListener(this);
        m3.add(mr1);

        // frame principal
        f.addWindowListener(new CloseHandler());
        f.setLocationRelativeTo(null);
        f.pack();
        f.setResizable(false);
        f.setVisible(false);
    }
    public void setVisible() {

        f.setVisible(true);
    }

    public VentanaCursos() {
        this(new Controlador().ObtenerCurso());

    }
    /*---------------------------------------------------------------------
     * acciones del sistema
     *--------------------------------------------------------------------*/

    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Crear Curso")) {
            f.dispose(); // Eliminamos ventana actual
            ventanaCurso.setVisible(); // Cargamos la nueva con la lista

        } else if (e.getActionCommand().equals("Salir")) {
            System.exit(0);
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
