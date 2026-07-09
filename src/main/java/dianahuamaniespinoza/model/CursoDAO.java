package dianahuamaniespinoza.model;


import java.sql.*;
import java.util.ArrayList;



public class CursoDAO {


    private Conexion conexion;


    public CursoDAO(){

        conexion = new Conexion();

    }



    // =====================================
    // LISTAR CURSOS ACTIVOS
    // =====================================

    public ArrayList<Curso> listarCursos(){


        ArrayList<Curso> lista = new ArrayList<>();


        String sql =
                "SELECT * FROM curso WHERE estado=1";



        try{


            Connection cn =
                    conexion.getConexion();



            PreparedStatement ps =
                    cn.prepareStatement(sql);



            ResultSet rs =
                    ps.executeQuery();



            while(rs.next()){


                Curso curso =
                        new Curso();



                curso.setIdCurso(
                        rs.getInt("idCurso")
                );


                curso.setNombreCurso(
                        rs.getString("nombreCurso")
                );


                curso.setDescripcion(
                        rs.getString("descripcion")
                );


                curso.setDuracion(
                        rs.getString("duracion")
                );


                curso.setEstado(
                        rs.getInt("estado")
                );



                lista.add(curso);


            }



        }catch(SQLException e){

            System.out.println(
                    "Error al listar cursos"
            );

            e.printStackTrace();

        }



        return lista;

    }






    // =====================================
    // INSERTAR CURSO
    // =====================================


    public boolean insertarCurso(Curso curso){


        String sql =
                """
                INSERT INTO curso
                (
                nombreCurso,
                descripcion,
                duracion,
                estado
                )
                VALUES
                (?,?,?,?)
                """;



        try{


            Connection cn =
                    conexion.getConexion();



            PreparedStatement ps =
                    cn.prepareStatement(sql);



            ps.setString(
                    1,
                    curso.getNombreCurso()
            );


            ps.setString(
                    2,
                    curso.getDescripcion()
            );


            ps.setString(
                    3,
                    curso.getDuracion()
            );


            ps.setInt(
                    4,
                    1
            );



            return ps.executeUpdate()>0;



        }catch(SQLException e){


            System.out.println(
                    "Error al insertar curso"
            );


            e.printStackTrace();


        }


        return false;


    }






    // =====================================
    // ACTUALIZAR CURSO
    // =====================================


    public boolean actualizarCurso(Curso curso){


        String sql =
                """
                UPDATE curso SET
        
                nombreCurso=?,
        
                descripcion=?,
        
                duracion=?
        
                WHERE idCurso=?
        
                """;



        try{


            Connection cn =
                    conexion.getConexion();



            PreparedStatement ps =
                    cn.prepareStatement(sql);



            ps.setString(
                    1,
                    curso.getNombreCurso()
            );


            ps.setString(
                    2,
                    curso.getDescripcion()
            );


            ps.setString(
                    3,
                    curso.getDuracion()
            );


            ps.setInt(
                    4,
                    curso.getIdCurso()
            );



            return ps.executeUpdate()>0;



        }catch(SQLException e){


            System.out.println(
                    "Error al actualizar curso"
            );


            e.printStackTrace();


        }


        return false;


    }






    // =====================================
    // ELIMINADO LOGICO
    // =====================================


    public boolean eliminarCurso(int idCurso){



        String sql =
                """
                UPDATE curso
        
                SET estado=0
        
                WHERE idCurso=?
        
                """;



        try{


            Connection cn =
                    conexion.getConexion();



            PreparedStatement ps =
                    cn.prepareStatement(sql);



            ps.setInt(
                    1,
                    idCurso
            );



            return ps.executeUpdate()>0;



        }catch(SQLException e){


            System.out.println(
                    "Error al eliminar curso"
            );


            e.printStackTrace();


        }


        return false;


    }


}