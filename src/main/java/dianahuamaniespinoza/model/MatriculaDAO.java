package dianahuamaniespinoza.model;


import java.sql.*;
import java.util.ArrayList;



public class MatriculaDAO {


    private Conexion conexion;


    public MatriculaDAO(){

        conexion = new Conexion();

    }



    // ==========================================
    // INSERTAR MATRICULA
    // ==========================================

    public boolean insertarMatricula(Matricula matricula){


        String sql =
                """
                INSERT INTO matricula
                (
                dni,
                nombres,
                apellidos,
                correo,
                telefono,
                idCurso,
                turno,
                beca,
                montoPago,
                estado
                )
                VALUES
                (?,?,?,?,?,?,?,?,?,1)
                """;



        try{


            Connection cn =
                    conexion.getConexion();



            PreparedStatement ps =
                    cn.prepareStatement(sql);



            ps.setString(1, matricula.getDni());

            ps.setString(2, matricula.getNombres());

            ps.setString(3, matricula.getApellidos());

            ps.setString(4, matricula.getCorreo());

            ps.setString(5, matricula.getTelefono());

            ps.setInt(6, matricula.getIdCurso());

            ps.setString(7, matricula.getTurno());

            ps.setBoolean(8, matricula.isBeca());

            ps.setDouble(9, matricula.getMontoPago());



            return ps.executeUpdate()>0;



        }catch(SQLException e){


            System.out.println("Error al insertar matricula");

            e.printStackTrace();


        }


        return false;

    }






    // ==========================================
    // LISTAR MATRICULAS ACTIVAS
    // ==========================================

    public ArrayList<Matricula> listarMatriculas(){


        ArrayList<Matricula> lista =
                new ArrayList<>();



        String sql =
                """
                SELECT
        
                m.idMatricula,
                m.dni,
                m.nombres,
                m.apellidos,
                m.correo,
                m.telefono,
                m.idCurso,
                c.nombreCurso,
                m.turno,
                m.beca,
                m.montoPago,
                m.estado,
                m.fechaRegistro
        
                FROM matricula m
        
                INNER JOIN curso c
        
                ON m.idCurso=c.idCurso
        
                WHERE m.estado=1
                """;



        try{


            Connection cn =
                    conexion.getConexion();



            PreparedStatement ps =
                    cn.prepareStatement(sql);



            ResultSet rs =
                    ps.executeQuery();



            while(rs.next()){


                Matricula m =
                        new Matricula();



                m.setIdMatricula(
                        rs.getInt("idMatricula")
                );


                m.setDni(
                        rs.getString("dni")
                );


                m.setNombres(
                        rs.getString("nombres")
                );


                m.setApellidos(
                        rs.getString("apellidos")
                );


                m.setCorreo(
                        rs.getString("correo")
                );


                m.setTelefono(
                        rs.getString("telefono")
                );


                m.setIdCurso(
                        rs.getInt("idCurso")
                );


                m.setNombreCurso(
                        rs.getString("nombreCurso")
                );


                m.setTurno(
                        rs.getString("turno")
                );


                m.setBeca(
                        rs.getBoolean("beca")
                );


                m.setMontoPago(
                        rs.getDouble("montoPago")
                );


                m.setEstado(
                        rs.getInt("estado")
                );


                m.setFechaRegistro(
                        rs.getDate("fechaRegistro")
                );



                lista.add(m);


            }



        }catch(SQLException e){


            System.out.println("Error al listar matriculas");

            e.printStackTrace();


        }



        return lista;

    }







    // ==========================================
    // ACTUALIZAR MATRICULA
    // ==========================================


    public boolean actualizarMatricula(Matricula matricula){


        String sql =
                """
                UPDATE matricula SET
        
                dni=?,
        
                nombres=?,
        
                apellidos=?,
        
                correo=?,
        
                telefono=?,
        
                idCurso=?,
        
                turno=?,
        
                beca=?,
        
                montoPago=?
        
                WHERE idMatricula=?
        
                """;



        try{


            Connection cn =
                    conexion.getConexion();



            PreparedStatement ps =
                    cn.prepareStatement(sql);



            ps.setString(1, matricula.getDni());

            ps.setString(2, matricula.getNombres());

            ps.setString(3, matricula.getApellidos());

            ps.setString(4, matricula.getCorreo());

            ps.setString(5, matricula.getTelefono());

            ps.setInt(6, matricula.getIdCurso());

            ps.setString(7, matricula.getTurno());

            ps.setBoolean(8, matricula.isBeca());

            ps.setDouble(9, matricula.getMontoPago());

            ps.setInt(10, matricula.getIdMatricula());



            return ps.executeUpdate()>0;



        }catch(SQLException e){


            System.out.println("Error al actualizar matricula");

            e.printStackTrace();


        }


        return false;


    }







    // ==========================================
    // ELIMINADO LOGICO
    // ==========================================


    public boolean eliminarMatricula(int idMatricula){


        String sql =
                """
                UPDATE matricula
        
                SET estado=0
        
                WHERE idMatricula=?
        
                """;



        try{


            Connection cn =
                    conexion.getConexion();



            PreparedStatement ps =
                    cn.prepareStatement(sql);



            ps.setInt(
                    1,
                    idMatricula
            );



            return ps.executeUpdate()>0;



        }catch(SQLException e){


            System.out.println("Error al eliminar matricula");

            e.printStackTrace();


        }



        return false;


    }



}