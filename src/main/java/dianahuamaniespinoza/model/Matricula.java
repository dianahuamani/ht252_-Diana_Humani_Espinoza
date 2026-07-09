package dianahuamaniespinoza.model;

import java.sql.Date;


public class Matricula {


    private int idMatricula;

    private String dni;

    private String nombres;

    private String apellidos;

    private String correo;

    private String telefono;

    private int idCurso;

    private String nombreCurso;

    private String turno;

    private boolean beca;

    private double montoPago;

    private int estado;

    private Date fechaRegistro;



    public Matricula(){

    }



    public int getIdMatricula() {
        return idMatricula;
    }


    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }



    public String getDni() {
        return dni;
    }


    public void setDni(String dni) {
        this.dni = dni;
    }



    public String getNombres() {
        return nombres;
    }


    public void setNombres(String nombres) {
        this.nombres = nombres;
    }



    public String getApellidos() {
        return apellidos;
    }


    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }



    public String getCorreo() {
        return correo;
    }


    public void setCorreo(String correo) {
        this.correo = correo;
    }



    public String getTelefono() {
        return telefono;
    }


    public void setTelefono(String telefono) {
        this.telefono = telefono;
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



    public String getTurno() {
        return turno;
    }


    public void setTurno(String turno) {
        this.turno = turno;
    }



    public boolean isBeca() {
        return beca;
    }


    public void setBeca(boolean beca) {
        this.beca = beca;
    }



    public double getMontoPago() {
        return montoPago;
    }


    public void setMontoPago(double montoPago) {
        this.montoPago = montoPago;
    }



    public int getEstado() {
        return estado;
    }


    public void setEstado(int estado) {
        this.estado = estado;
    }



    public Date getFechaRegistro() {
        return fechaRegistro;
    }


    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }


}