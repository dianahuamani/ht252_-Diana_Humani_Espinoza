package dianahuamaniespinoza.controller;


import dianahuamaniespinoza.model.Matricula;
import dianahuamaniespinoza.model.MatriculaDAO;

import java.util.ArrayList;



public class MatriculaController {


    private MatriculaDAO matriculaDAO;



    public MatriculaController(){


        matriculaDAO = new MatriculaDAO();


    }




    // =====================================
    // LISTAR
    // =====================================


    public ArrayList<Matricula> listarMatriculas(){


        return matriculaDAO.listarMatriculas();


    }





    // =====================================
    // REGISTRAR
    // =====================================


    public boolean registrarMatricula(

            String dni,

            String nombres,

            String apellidos,

            String correo,

            String telefono,

            int idCurso,

            String turno,

            boolean beca,

            double montoPago

    ){



        Matricula matricula =
                new Matricula();



        matricula.setDni(dni);

        matricula.setNombres(nombres);

        matricula.setApellidos(apellidos);

        matricula.setCorreo(correo);

        matricula.setTelefono(telefono);

        matricula.setIdCurso(idCurso);

        matricula.setTurno(turno);

        matricula.setBeca(beca);


        // Regla de negocio:
        // Si tiene beca paga 0

        if(beca){

            matricula.setMontoPago(0);

        }else{

            matricula.setMontoPago(montoPago);

        }



        matricula.setEstado(1);



        return matriculaDAO.insertarMatricula(matricula);



    }







    // =====================================
    // ACTUALIZAR
    // =====================================


    public boolean actualizarMatricula(Matricula matricula){


        return matriculaDAO.actualizarMatricula(matricula);


    }







    // =====================================
    // ELIMINADO LOGICO
    // =====================================


    public boolean eliminarMatricula(int idMatricula){


        return matriculaDAO.eliminarMatricula(idMatricula);


    }



}