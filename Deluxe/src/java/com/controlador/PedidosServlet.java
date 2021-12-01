/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.modelo.MetodosPedido;
import com.modelo.Pedidos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Aldo
 */
public class PedidosServlet extends HttpServlet {

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
                 
             }
         }
         }catch(Exception ex){
             
             JOptionPane.showMessageDialog(null, ex);
         }
    }

    protected void Guardar(HttpServletRequest request, HttpServletResponse response) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        Pedidos obj = new Pedidos();
        MetodosPedido mp = new MetodosPedido();
        obj.setCliente(Integer.parseInt(request.getParameter("Cliente").toUpperCase()));
        obj.setEmpleado(Integer.parseInt(request.getParameter("Empleado").toUpperCase()));
        String fecha=dtf.format(LocalDateTime.now());
        obj.setFecha(fecha);
            String[] motor=request.getParameterValues("TxtMotor[]");
            String[] precio=request.getParameterValues("TxtPrecio[]");
           
        if (request.getParameter("Cliente") != null) {
            try {
             int idventa=mp.Guardar(obj);
                for(int i=0; i<motor.length;i++){
                obj.setVenta(idventa);
                obj.setMotor(motor[i]);
                obj.setTotal( Double.parseDouble(precio[i]));
                mp.GuardarDetalle(obj);
            }
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
