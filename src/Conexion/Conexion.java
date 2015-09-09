/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xtiyo
 */
public class Conexion {

    private Connection conexion;
    private String error = null;

    public Conexion(String user, String pass, String bd, String host) {

        try {

            Class.forName("com.mysql.jdbc.Driver");

            this.conexion = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + bd, user, pass);

        } catch (ClassNotFoundException | SQLException ex) {

            this.error = ex.getMessage();

        }

    }

    public String getError() {


        return this.error;


    }

    public Connection getConexion() {

        return this.conexion;

    }

    public void Cerrar() {
        try {

            this.conexion.close();
        } catch (SQLException ex) {

            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
