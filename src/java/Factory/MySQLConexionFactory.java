/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public final class MySQLConexionFactory extends ConexionDB{
    /**
     * Constructor de la Conexion con la BD
     * @param parametros Nombre de la tabla, Ususario, Clave
     */
    public MySQLConexionFactory(String[] parametros){
        this.parametros = parametros;
        this.open(); // llamar a la funcion abrirconexion
    }
    
    @Override
    Connection open() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //                                              direccion bd                     tabla                  user                 pass
            this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + this.parametros[0], this.parametros[1],this.parametros[2]);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return this.conexion;
    }
    
}
