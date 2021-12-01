/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.modelo.Color;
import com.modelo.Especificaciones;
import com.modelo.MetodosColor;
import com.modelo.MetodosEspecificaciones;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;

/**
 *
 * @author Aldo
 */

@MultipartConfig
public class EspecificacionesServlet extends HttpServlet {
  Especificaciones obj = new Especificaciones();
  MetodosEspecificaciones MSP = new MetodosEspecificaciones();
 
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
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        try{
         if(accion!=null){
             switch(accion){
                 case "Guardar":
                Guardar(request, response);
                break;
                 case "Modificar":
                    Modificar(request, response); 
                    break;
                 case "Eliminar":
                     Eliminar(request, response);
                     break;
             }
         }
         }catch(Exception ex){
             
         }
    }
    
    
     protected void Guardar(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
       
         obj.setCategoria(Integer.parseInt(request.getParameter("TxtCategoria")));
         obj.setMarca(Integer.parseInt(request.getParameter("TxtMarca")));
         obj.setModelo(request.getParameter("TxtModelos"));
         obj.setDescripcion(request.getParameter("TxtDescripcion"));
          
        if(request.getParameter("TxtMarca")!=null){
            try {
                Part part = request.getPart("Imagen");
                InputStream inputStream=part.getInputStream(); 
                obj.setFoto(inputStream);
                MSP.GuardarEspecificaciones(obj);
                 
            } catch (Exception e) {
                
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
           
        }
        
        
     }
         protected void Modificar (HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        
         obj.setRegistro(Integer.parseInt(request.getParameter("TxtRegistro")));
         obj.setCategoria(Integer.parseInt(request.getParameter("TxtCategoria")));
         obj.setMarca(Integer.parseInt(request.getParameter("TxtMarca")));
         obj.setModelo(request.getParameter("TxtModelos"));
         obj.setDescripcion(request.getParameter("TxtDescripcion"));
      
            try {
                Part part = request.getPart("Imagen");
                InputStream inputStream=part.getInputStream(); 
                 if (inputStream.available() != 0) {
                obj.setFoto(inputStream);
                MSP.ModificarEspecificaciones(obj);
                }else{
                 MSP.Modificar(obj);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
           
        }
        
         
         protected void Eliminar (HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        
         obj.setRegistro(Integer.parseInt(request.getParameter("TxtRegistro")));
         
            try {
               
               MSP.EliminarEspecificaciones(obj);
                
            } catch (Exception e) {
                
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
           
        }
        
   

           
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
        
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
