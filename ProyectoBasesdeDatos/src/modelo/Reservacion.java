package modelo;

import java.sql.Date;

public class Reservacion {

    private String IDSalon;
    private String Nombre;
    private Date FechaHora;
    private int Duracion;

    
    public Reservacion(String iDSalon, String nombre, Date fechaHora, int duracion) {
        IDSalon = iDSalon;
        Nombre = nombre;
        FechaHora = fechaHora;
        Duracion = duracion;
    }


    public String getIDSalon() {
        return IDSalon;
    }


    public void setIDSalon(String iDSalon) {
        IDSalon = iDSalon;
    }


    public String getNombre() {
        return Nombre;
    }


    public void setNombre(String nombre) {
        Nombre = nombre;
    }


    public Date getFechaHora() {
        return FechaHora;
    }


    public void setFechaHora(Date fechaHora) {
        FechaHora = fechaHora;
    }


    public int getDuracion() {
        return Duracion;
    }


    public void setDuracion(int duracion) {
        Duracion = duracion;
    }

    @Override
    public String toString() {
        return IDSalon + " NOMBRE:" + Nombre + " FechaHora" + FechaHora + " Duracion" + Duracion;
    }
    
}
