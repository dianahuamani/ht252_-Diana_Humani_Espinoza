package dianahuamaniespinoza.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    // Endpoint de AWS RDS
    private static final String URL = "jdbc:mysql://dbproyecto.cpy8hvhiurt7.us-east-1.rds.amazonaws.com:3306/Sistema_estudio?useSSL=false&serverTimezone=UTC";

    // Usuario de la base de datos
    private static final String USER = "admin";

    // Contraseña de la base de datos
    private static final String PASSWORD = "huamaniespinoza";

    private Connection conexion;

    public Connection getConexion() {

        try {

            if (conexion == null || conexion.isClosed()) {

                Class.forName("com.mysql.cj.jdbc.Driver");

                conexion = DriverManager.getConnection(URL, USER, PASSWORD);

                System.out.println("Conexión exitosa con AWS RDS.");

            }

        } catch (ClassNotFoundException e) {

            System.out.println("No se encontró el Driver de MySQL.");
            e.printStackTrace();

        } catch (SQLException e) {

            System.out.println("Error al conectar con AWS RDS.");
            e.printStackTrace();

        }

        return conexion;
    }

    public void cerrarConexion() {

        try {

            if (conexion != null && !conexion.isClosed()) {

                conexion.close();

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

}