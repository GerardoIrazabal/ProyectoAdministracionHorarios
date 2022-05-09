package modelo;

public class Curso {

    private String Clave;
    private Integer Secc;
    private String Titulo;
    private String Prof;

    
    public Curso(String clave, Integer secc, String titulo, String prof) {
        Clave = clave;
        Secc = secc;
        Titulo = titulo;
        Prof = prof;
    }


    public String getClave() {
        return Clave;
    }


    public void setClave(String clave) {
        Clave = clave;
    }


    public Integer getSecc() {
        return Secc;
    }


    public void setSecc(Integer secc) {
        Secc = secc;
    }


    public String getTitulo() {
        return Titulo;
    }


    public void setTitulo(String titulo) {
        Titulo = titulo;
    }


    public String getProf() {
        return Prof;
    }


    public void setProf(String prof) {
        Prof = prof;
    }

    @Override
    public String toString() {
        return Clave + "-" + Secc;
    }

    
}