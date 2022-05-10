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

public class VentanaActualizarHorario {

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

    public VentanaActualizarHorario(Horario h1) {
        // campos de información
        f = new JFrame("Datos del Horario");
        p = new JPanel();
        p.setLayout(new GridLayout(5, 2));

        ControladorCurso control = new ControladorCurso();
        ArrayList<Curso> Lista = control.obtenerNombresCursos();

        String listadeCurso[] = new String[1];
        listadeCurso[0] = h1.getCursito().toString();

        ArrayList<Salon> ListadeSalones = control.BuscarSalonesIDReservacion();

        String listadeSalonesA[] = new String[ListadeSalones.size()+1];
        listadeSalonesA[0] = h1.getIDSALON();
        for (int i = 1; i <= ListadeSalones.size(); i++)

        {
            Salon s1 = ListadeSalones.get(i-1);
            listadeSalonesA[i] = s1.getIDSALON();
        }

        String listadeDias[] = { "","Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado" };
        String DIA = "";

        switch (h1.getDIASEM()) {
            case 1:
                DIA = "Lunes";
                break;

            case 2:
                DIA = "Martes";
                break;

            case 3:
                DIA = "Miercoles";
                break;

            case 4:
                DIA = "Jueves";
                break;

            case 5:
                DIA = "Viernes";
                break;

            case 6:
                DIA = "Sabado";
                break;

            default:
                DIA = "";
                break;
        }
        listadeDias[0] = DIA;


        Date FechaActual = new Date();

        ArrayList<Periodo> ListaPeriodos = control.ObtenerYCrearPeriodos(FechaActual);
        String ListaDePeriodos[] = new String[ListaPeriodos.size()+1];
        ListaDePeriodos[0] = h1.getPeriodo();


        for (int i = 1; i <= ListaPeriodos.size(); i++)

        {
            Periodo s1 = ListaPeriodos.get(i-1);
            ListaDePeriodos[i] = s1.getTitulo();
        }

        l1 = new JLabel("Clave y seccion: ");
        l2 = new JLabel("Diasem: ");
        l3 = new JLabel("Hora: ");
        l4 = new JLabel("Minuto: ");
        l5 = new JLabel("Duracion: ");
        l6 = new JLabel("Periodo: ");
        l7 = new JLabel("Semestre ");
        l8 = new JLabel("IDSALON ");

        t1 = new JComboBox(listadeCurso);
        t2 = new JComboBox(listadeDias);
        t3 = new JTextField(20);
        t3.setText(h1.getHora()+ "");
        t4 = new JTextField(20);
        t4.setText(h1.getMinuto()+ "");
        t5 = new JTextField(20);
        t5.setText(h1.getDuracion()+ "");
        t6 = new JComboBox(ListaDePeriodos);
        t7 = new JTextField(20);
        t7.setText(h1.getSemestre()+ "");
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
        b1 = new JButton("Actualizar");
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

        f.setVisible(true);
    }

    /*---------------------------------------------------------------------
     * clases privadas
     *--------------------------------------------------------------------*/

    private class CrearHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Curso s1 = new Curso(t1.getSelectedItem().toString(),
            // Integer.parseInt(t2.getText()), t3.getText(), t4.getText());
            Horario h1 = new Horario();
            String ClaveYSeccion = t1.getSelectedItem().toString();
            Integer Seccion = 0;
            String Clave = "";
            String ListaClave[] = ClaveYSeccion.split("-");
            if (ListaClave.length == 3) {
                Clave = ListaClave[0] + "-" + ListaClave[1];
                Seccion = Integer.parseInt(ListaClave[2]);
            } else if (ListaClave.length == 2) {
                Clave = ListaClave[0];
                Seccion = Integer.parseInt(ListaClave[1]);

            } else {
                JOptionPane.showMessageDialog(f, "Se ha generado un error al seleccionar la clave");
            }

            String DIASEM = t2.getSelectedItem().toString();
            Integer DIA = 0;

            switch (DIASEM) {
                case "Lunes":
                    DIA = 1;
                    break;

                case "Martes":
                    DIA = 2;
                    break;

                case "Miercoles":
                    DIA = 3;
                    break;

                case "Jueves":
                    DIA = 4;
                    break;

                case "Viernes":
                    DIA = 5;
                    break;

                case "Sabado":
                    DIA = 6;
                    break;

                default:
                    DIA = 0;
                    break;
            }

            h1.setCursito(new Curso(Clave, Seccion, "", ""));
            h1.setDIASEM(DIA);
            h1.setHora(Integer.parseInt(t3.getText()));
            h1.setMinuto(Integer.parseInt(t4.getText()));
            h1.setDuracion(Integer.parseInt(t5.getText()));
            h1.setPeriodo(t6.getSelectedItem().toString());
            h1.setSemestre(Integer.parseInt(t7.getText()));
            h1.setIDSALON(t8.getSelectedItem().toString());

            ControladorHorario Control = new ControladorHorario();
            JOptionPane.showMessageDialog(f, Control.actualizarHorario(h1));
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
