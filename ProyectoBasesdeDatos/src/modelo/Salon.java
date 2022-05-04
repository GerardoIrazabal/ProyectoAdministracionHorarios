package modelo;

public class Salon {
    private String IDSALON;
    private Integer CAPACIDAD;
    private String TIPO;

    public Salon ()
    {
        this.IDSALON = "";
        this.CAPACIDAD = 0;
        this.TIPO = "";
    }
   
    public Salon (String IDSALON, Integer CAPACIDAD, String TIPO)
    {
        this.IDSALON = IDSALON;
        this.CAPACIDAD = CAPACIDAD;
        this.TIPO = TIPO;
    }

    public void setIDSALON(String iDSALON) {
        this.IDSALON = iDSALON;
    }
    public String getIDSALON() {
        return IDSALON;
    }

    public Integer getCAPACIDAD() {
        return CAPACIDAD;
    }

    public void setCAPACIDAD(Integer cAPACIDAD) {
        CAPACIDAD = cAPACIDAD;
    }

    public String getTIPO() {
        return TIPO;
    }

    public void setTIPO(String tIPO) {
        TIPO = tIPO;
    }

    @Override
    public String toString() {
        return IDSALON + " CAPACIDAD:" + CAPACIDAD + " TIPO" + TIPO;
    }
    

}
