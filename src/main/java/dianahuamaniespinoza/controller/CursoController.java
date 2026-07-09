package dianahuamaniespinoza.controller;

import dianahuamaniespinoza.model.Curso;
import dianahuamaniespinoza.model.CursoDAO;

import java.util.ArrayList;


public class CursoController {


    private CursoDAO cursoDAO;


    public CursoController(){

        cursoDAO = new CursoDAO();

    }



    public ArrayList<Curso> listarCursos(){

        return cursoDAO.listarCursos();

    }



    public boolean registrarCurso(
            String nombre,
            String descripcion,
            String duracion
    ){

        Curso curso = new Curso();


        curso.setNombreCurso(nombre);

        curso.setDescripcion(descripcion);

        curso.setDuracion(duracion);

        curso.setEstado(1);



        return cursoDAO.insertarCurso(curso);

    }




    public boolean actualizarCurso(
            int idCurso,
            String nombre,
            String descripcion,
            String duracion
    ){


        Curso curso = new Curso();


        curso.setIdCurso(idCurso);

        curso.setNombreCurso(nombre);

        curso.setDescripcion(descripcion);

        curso.setDuracion(duracion);



        return cursoDAO.actualizarCurso(curso);

    }




    public boolean eliminarCurso(int idCurso){


        return cursoDAO.eliminarCurso(idCurso);


    }


}