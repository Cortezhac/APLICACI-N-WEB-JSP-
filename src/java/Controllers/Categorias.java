/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.CategoriaDAO;
import DAO.CategoriaImplemtarDAO;
import Model.Categoria;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "Categorias", urlPatterns = {"/Categorias"})
public class Categorias extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void listaCategorias(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //Crear instancia a CategoriasDAO
        CategoriaDAO categoria = new CategoriaImplemtarDAO();
        HttpSession session = request.getSession(true);
        session.setAttribute("lista", categoria.Listar());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/VistasCategorias/listarCategorias.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcion = request.getParameter("opcion");
        System.out.println("opcion " + opcion);
        if(opcion.equalsIgnoreCase("crear")){
            String direcion = "/VistasCategorias/crearCategorias.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(direcion);
            dispatcher.forward(request, response);
        }else if(opcion.equalsIgnoreCase("listar")){
            this.listaCategorias(request, response);
        }
    //processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Categoria categoria = new Categoria();
        
        categoria.setId_categoria(Integer.parseInt(request.getParameter("Id_categoria")));
        categoria.setNom_categoria(request.getParameter("txtNombreCat"));
        categoria.setEstado_categoria(Integer.parseInt(request.getParameter("txtEstadoCat")));
        
        //Objeto de acceso a los datos
        CategoriaDAO guardarCategoria = new CategoriaImplemtarDAO();
        guardarCategoria.guardarCat(categoria);
        this.listaCategorias(request, response);
        //processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
