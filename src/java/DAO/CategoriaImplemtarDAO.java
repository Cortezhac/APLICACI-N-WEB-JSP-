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
        StringBuilder myQuery = new StringBuilder();
        myQuery.append("SELEC * FROM tb_categoria;");
        List<Categoria> lista = new ArrayList<Categoria>();
        try {
            ResultSet resultSetSQL = this.con.consultaSQL(myQuery.toString());
            while(resultSetSQL.next()){                
                Categoria categoria = new Categoria();
                categoria.setId_categoria(resultSetSQL.getInt("id_categoria"));
                categoria.setNom_categoria(resultSetSQL.getString("nom_categoria"));
                categoria.setEstado_categoria(resultSetSQL.getInt("estado_categoria"));
                lista.add(categoria);//guarda el obj en la lista
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

    @Override
    public Categoria editarCat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean guardarCat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borrarCat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
