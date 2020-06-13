/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public abstract class ConexionDB {
    protected String[] parametros;// Array con parametros de conexion
    protected Connection conexion;
    /**
     * Devuelve un objeto conexion
     * @return Connection
     */
    abstract Connection open();
    /**
     * Retorna un conjunto de datos con la consulta introducida
     * @param sqlQuery 
     * @return ResulSet
     */
    public ResultSet consultaSQL(String sqlQuery){
        Statement statement; // Ejecuta la consulta
        ResultSet resultSet = null;
        try {
            statement = conexion.createStatement();
            resultSet = statement.executeQuery(sqlQuery);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultSet;
    }
    
}
