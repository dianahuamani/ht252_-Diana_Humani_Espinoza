package dianahuamaniespinoza.model;


public class Curso {


    private int idCurso;

    private String nombreCurso;

    private String descripcion;

    private String duracion;

    private int estado;



    public Curso() {

    }



    public Curso(
            int idCurso,
            String nombreCurso,
            String descripcion,
            String duracion,
            int estado
    ){

        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.estado = estado;

    }



    public int getIdCurso() {
        return idCurso;
    }



    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }



    public String getNombreCurso() {
        return nombreCurso;
    }



    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }



    public String getDescripcion() {
        return descripcion;
    }



    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



    public String getDuracion() {
        return duracion;
    }



    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }



    public int getEstado() {
        return estado;
    }



    public void setEstado(int estado) {
        this.estado = estado;
    }



    @Override
    public String toString(){

        return nombreCurso;

    }


}