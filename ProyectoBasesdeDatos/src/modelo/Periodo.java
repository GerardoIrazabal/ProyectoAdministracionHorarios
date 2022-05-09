package modelo;

import java.sql.Date;

public class Periodo {

    private String Titulo;
    private Date FechaInicio;
    private Date FechaFin;

    
    public Periodo(String titulo, Date fechaInicio, Date fechaFin) {
        Titulo = titulo;
        FechaInicio = fechaInicio;
        FechaFin = fechaFin;
    }


    public String getTitulo() {
        return Titulo;
    }


    public void setTitulo(String titulo) {
        Titulo = titulo;
    }


    public Date getFechaInicio() {
        return FechaInicio;
    }


    public void setFechaInicio(Date fechaInicio) {
        FechaInicio = fechaInicio;
    }


    public Date getFechaFin() {
        return FechaFin;
    }


    public void setFechaFin(Date fechaFin) {
        FechaFin = fechaFin;
    }

    
}
