/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.modelo.Empleado;
import com.modelo.MetodosEmpleado;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonathan Alvarado
 */
public class Empleado_Servlet extends HttpServlet {

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
                 case "GuardarEmpleado":
                GuardarEmpleado(request, response);
                break;
                 case "ModificarEmpleado":
                     ModificarEmpleado(request, response);
                     break;
                 case "EliminarEmpleado":
                    EliminarEmpleado(request, response);
                     break;
             }
         }
         }catch(Exception ex){
               JOptionPane.showMessageDialog(null, ex.getMessage());
         }
        
    }
    
    protected void GuardarEmpleado(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        Empleado emp = new Empleado();
        MetodosEmpleado mEmp = new MetodosEmpleado();
        emp.setNombres(request.getParameter("txtNombres").toUpperCase());
        emp.setApellidos(request.getParameter("txtApellidos").toUpperCase());
        emp.setTelefono(request.getParameter("txtTelefono").toUpperCase());
        emp.setDireccion(request.getParameter("txtDireccion").toUpperCase());
        emp.setDocumento(request.getParameter("txtDocumento").toUpperCase());
        emp.setSexo(request.getParameter("txtSexo").toUpperCase());
        emp.setID_Us(Integer.parseInt(request.getParameter("Usuario").toUpperCase()));
        if (request.getParameter("txtNombres") != null) {
            try {
                mEmp.GuardarEmpleado(emp);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
    
    protected void ModificarEmpleado(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        Empleado emp = new Empleado();
        MetodosEmpleado mEmp = new MetodosEmpleado();
        emp.setNombres(request.getParameter("txtNombres").toUpperCase());
        emp.setApellidos(request.getParameter("txtApellidos").toUpperCase());
        emp.setTelefono(request.getParameter("txtTelefono").toUpperCase());
        emp.setDireccion(request.getParameter("txtDireccion").toUpperCase());
        emp.setDocumento(request.getParameter("txtDocumento").toUpperCase());
        emp.setSexo(request.getParameter("txtSexo").toUpperCase());
        emp.setID_Us(Integer.parseInt(request.getParameter("Usuario")));
        emp.setID(Integer.parseInt(request.getParameter("txtID")));
        if (request.getParameter("txtID") != null) {
            try {
                mEmp.ModificarEmpleado(emp);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
    
       protected void EliminarEmpleado(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        Empleado emp = new Empleado();
        MetodosEmpleado mEmp = new MetodosEmpleado();
        emp.setID(Integer.parseInt(request.getParameter("txtID")));
        if (request.getParameter("txtID") != null) {
            try {
                mEmp.EliminarEmpleado(emp);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
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
