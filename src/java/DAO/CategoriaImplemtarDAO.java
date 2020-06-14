/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Factory.ConexionDB;
import Factory.FactoryConexionDB;
import Model.Categoria;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CategoriaImplemtarDAO implements CategoriaDAO{
    ConexionDB con;
    
    public CategoriaImplemtarDAO(){
        //Definir la base de datos a la que se conectara por defecto
        this.con = FactoryConexionDB.open(FactoryConexionDB.MySQL);// MySQL = 1
    }

    @Override
    public List<Categoria> Listar() {
        // Conexion a tabla a la Categorias
        this.con = FactoryConexionDB.open(FactoryConexionDB.MySQL);// MySQL = 1
        StringBuilder myQuery = new StringBuilder();
        myQuery.append("SELECT * FROM tb_categoria;");
        List<Categoria> lista = new ArrayList<Categoria>();
        try {
            ResultSet resultSetSQL = this.con.consultaSQL(myQuery.toString());
            while(resultSetSQL.next()){                
                Categoria categoria = new Categoria();
                categoria.setId_categoria(resultSetSQL.getInt("id_categoria"));
                categoria.setNom_categoria(resultSetSQL.getString("nom_categoria"));
                categoria.setEstado_categoria(resultSetSQL.getInt("estado_categoria"));
                lista.add(categoria);// guarda el obj en la lista
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            this.con.cerraConexion();
        }
        return lista;
    }

    @Override
    public List<Categoria> Listar2() {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Busca un registro en la bd y devuelve la informacion 
     * @param idCategoria Identificar del registro a buscar en la base de datos
     * @return Categotia con todos sus datos
     */
    @Override
    public Categoria editarCat(int idCategoria) {
        this.con = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        Categoria categoria = new Categoria();
        StringBuilder myQuery = new StringBuilder();
        myQuery.append("SELECT * FROM tb_categoria WHERE id_categoria = ").append(idCategoria);
        try {
            ResultSet resultSet = this.con.consultaSQL(myQuery.toString());
            while (resultSet.next()) {                
                categoria.setId_categoria(resultSet.getInt("id_categoria"));
                categoria.setNom_categoria(resultSet.getString("nom_categoria"));
                categoria.setEstado_categoria(resultSet.getInt("estado_categoria"));   
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            this.con.cerraConexion();
        }
        return categoria;
    }

    @Override
    public boolean guardarCat(Categoria categoria) {
        this.con = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        boolean guardar = false;
        try {
            if (categoria.getId_categoria() == 0) { // Significa que no existe
                StringBuilder myQuery = new StringBuilder();
                myQuery.append("INSERT INTO tb_categoria (nom_categoria,estado_categoria) VALUES('");
                myQuery.append(categoria.getNom_categoria()).append("', '");
                myQuery.append(categoria.getEstado_categoria()).append("');");
                // Invocar metodo para ejecutar la consulta
                this.con.ejecutarSQL(myQuery.toString());
            }else if(categoria.getId_categoria() > 0){ // significa que existe
                // Actualizar: id_categorias mayores a cero
                StringBuilder mySQL = new StringBuilder();
                mySQL.append("UPDATE tb_categoria SET nom_categoria = '").append(categoria.getNom_categoria());
                mySQL.append("', estado_categoria = '").append(categoria.getEstado_categoria()).append("'");
                mySQL.append("WHERE id_categoria = ").append(categoria.getId_categoria()).append(" ;");
                this.con.ejecutarSQL(mySQL.toString());
            }
            guardar = true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.con.cerraConexion();
        }
        return guardar;
    }

    @Override
    public boolean borrarCat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
