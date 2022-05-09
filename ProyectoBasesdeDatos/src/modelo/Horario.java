package modelo;

public class Horario {

    private Curso Cursito;
    private Integer DIASEM;
    private Integer Hora;
    private Integer Minuto;
    private Integer Duracion;
    private String Periodo;
    private Integer Semestre;
    private String IDSALON;
    public Horario (){}

    public Horario(Curso cursito, Integer dIASEM, Integer hora, Integer minuto, Integer duracion, String periodo,
            Integer semestre, String iDSALON) {
        Cursito = cursito;
        DIASEM = dIASEM;
        Hora = hora;
        Minuto = minuto;
        Duracion = duracion;
        Periodo = periodo;
        Semestre = semestre;
        IDSALON = iDSALON;
    }

    public Curso getCursito() {
        return Cursito;
    }

    public void setCursito(Curso cursito) {
        Cursito = cursito;
    }

    public Integer getDIASEM() {
        return DIASEM;
    }

    public void setDIASEM(Integer dIASEM) {
        DIASEM = dIASEM;
    }

    public Integer getHora() {
        return Hora;
    }

    public void setHora(Integer hora) {
        Hora = hora;
    }

    public Integer getMinuto() {
        return Minuto;
    }

    public void setMinuto(Integer minuto) {
        Minuto = minuto;
    }

    public Integer getDuracion() {
        return Duracion;
    }

    public void setDuracion(Integer duracion) {
        Duracion = duracion;
    }

    public String getPeriodo() {
        return Periodo;
    }

    public void setPeriodo(String periodo) {
        Periodo = periodo;
    }

    public Integer getSemestre() {
        return Semestre;
    }

    public void setSemestre(Integer semestre) {
        Semestre = semestre;
    }

    public String getIDSALON() {
        return IDSALON;
    }

    public void setIDSALON(String iDSALON) {
        IDSALON = iDSALON;
    }

    @Override
    public String toString() {
        return Cursito + " DIASEM:" + DIASEM + " HORA " + Hora + " MINUTO " + Minuto;

        //agregar los demás que restan.
    }
    
    
    
}
