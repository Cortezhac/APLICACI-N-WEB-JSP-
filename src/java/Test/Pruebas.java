/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import DAO.CategoriaDAO;
import DAO.CategoriaImplemtarDAO;
import Model.Categoria;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Pruebas {
    public static void main(String[] args) {
        Pruebas evaluar = new Pruebas();
        evaluar.guardar();
        evaluar.listar();
        //evaluar.editar();
    }
    
    public void listar(){
        CategoriaDAO categotia = new CategoriaImplemtarDAO();
        List<Categoria> list = categotia.Listar();
        for (Categoria categoria : list) {
            System.out.println("ID " + categoria.getId_categoria());
            System.out.print(" NOMBRE " + categoria.getNom_categoria());
            System.out.print(" ESTADO " + categoria.getEstado_categoria() + "\n");
        }
    }
    
    public void editar(){
        CategoriaDAO categotia = new CategoriaImplemtarDAO();
        Categoria editar = categotia.editarCat(1);
            System.out.println("ID " + editar.getId_categoria());
            System.out.print(" NOMBRE " + editar.getNom_categoria());
            System.out.print(" ESTADO " + editar.getEstado_categoria() + "\n");
    }
    
    public void guardar(){
        CategoriaDAO categoria = new CategoriaImplemtarDAO();
        Categoria guardar = new Categoria();
        guardar.setNom_categoria("Bebidas");
        guardar.setEstado_categoria(1);
        categoria.guardarCat(guardar);
    }
}
