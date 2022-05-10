package vista;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import controlador.Controlador;
import controlador.ControladorCurso;
import controlador.ControladorHorario;
import modelo.Curso;
import modelo.Horario;
import modelo.Periodo;
import modelo.Salon;

public class VentanaSuprimirHorario {

    /*---------------------------------------------------------------------
     * componentes de la ventana
     *--------------------------------------------------------------------*/

    private JFrame f;
    private JPanel p;

    private JLabel l1;
    private JLabel l2;
    private JLabel l3;

    private JComboBox t1;
    private JComboBox t2;
    private JComboBox t3;

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

    public VentanaSuprimirHorario () {
        // campos de información
        f = new JFrame("Busqueda de horario");
        p = new JPanel();
        p.setLayout(new GridLayout(5, 2));

        l1 = new JLabel("Seleccione un Periodo: ");
        l2 = new JLabel("Seleccione un Salon: ");
        l3 = new JLabel("Seleccione un Curso: ");

        ControladorCurso control = new ControladorCurso();
        ArrayList<Curso> Lista = control.obtenerNombresCursos();

        String listadeCurso[] = new String[Lista.size()];
        for (int i = 0; i < Lista.size(); i++)

        {
            Curso s1 = Lista.get(i);
            listadeCurso[i] = s1.toString();
        }
        ArrayList<Salon> ListadeSalones = control.BuscarSalonesIDReservacion();

        String listadeSalonesA[] = new String[ListadeSalones.size()];
        for (int i = 0; i < ListadeSalones.size(); i++)

        {
            Salon s1 = ListadeSalones.get(i);
            listadeSalonesA[i] = s1.getIDSALON();
        }

        ArrayList<Periodo> ListaPeriodos = control.obtenerPeriodos();
        String ListaDePeriodos[] = new String[ListaPeriodos.size()];

        for (int i = 0; i < ListaPeriodos.size(); i++)

        {
            Periodo s1 = ListaPeriodos.get(i);
            ListaDePeriodos[i] = s1.getTitulo();
        }

        t3 = new JComboBox(listadeCurso);
        t1 = new JComboBox(ListaDePeriodos);
        t2 = new JComboBox(listadeSalonesA);

      
        p.add(l1);
        p.add(t1);
        p.add(l2);
        p.add(t2);
        p.add(l3);
        p.add(t3);

        // botones de creación/cancelación
        b1 = new JButton("Buscar");
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
            System.out.println("Buscando Horario");

            ControladorHorario Control = new ControladorHorario();
            String CriterioDeBusqueda = " ";

        
            String ClaveYSeccion = t3.getSelectedItem().toString();
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

            ArrayList<Horario> listadeBusqueda = Control.buscarHorarios(Seccion +"", Clave, t1.getSelectedItem().toString(),  t2.getSelectedItem().toString());

            Integer Tamanio = listadeBusqueda.size();

            if (Tamanio == 1){
                Integer opcion = JOptionPane.showConfirmDialog(f, "Estad ustes seguro que desea suprimir el curso del horario? (esto borrara las reservaciones si es que existen");
                if (opcion == 0){
                    JOptionPane.showMessageDialog(f,Control.SuprimirHorario(listadeBusqueda.get(0)));
                }
                
            }else  JOptionPane.showMessageDialog(f, "No se ha encontrado el horario o se han encontrado más de 1");

        }
    }

    private class CancelarHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            f.dispose();
            new VentanaPrincipal();
        }
    }

}
