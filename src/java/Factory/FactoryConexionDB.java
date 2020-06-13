/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

/**
 *
 * @author Admin
 */
public class FactoryConexionDB {
    public static final int MySQL = 1; // para conectar a MySQL
    public static String[] configMySQL = {"bd_inventario", "root", ""};
    
    public static ConexionDB open(int tipoBD){
        switch(tipoBD){
            case FactoryConexionDB.MySQL:
                return new MySQLConexionFactory(configMySQL);
            default:
                return null;
        }
    }
}
