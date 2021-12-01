/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.google.gson.Gson;
import com.modelo.Cliente;
import com.modelo.MetodosCliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonathan Alvarado
 */
@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {

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
        try {
            if (accion != null) {
                switch (accion) {
                    case "GuardarCliente":
                        GuardarCliente(request, response);

                        break;
                    case "ModificarCliente":
                        ModificarCliente(request, response);

                        break;
                    case "EliminarCliente":
                        EliminarCliente(request, response);
                        break;
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }
    private Gson gson = new Gson();

    protected void GuardarCliente(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        Cliente cli = new Cliente();
        MetodosCliente mCli = new MetodosCliente();
        cli.setNombres(request.getParameter("txtNombres").toUpperCase());
        cli.setApellidos(request.getParameter("txtApellidos").toUpperCase());
        cli.setTelefono(request.getParameter("txtTelefono").toUpperCase());
        cli.setDireccion(request.getParameter("txtDireccion").toUpperCase());
        cli.setDocumento(request.getParameter("txtDocumento").toUpperCase());
        cli.setSexo(request.getParameter("txtSexo").toUpperCase());
        cli.setID_Us(Integer.parseInt(request.getParameter("UsuarioX")));
        cli.setID_Cat(Integer.parseInt(request.getParameter("txtCategoriaCli")));
        if (request.getParameter("txtNombres") != null) {
            try {
                mCli.GuardarCliente(cli);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }

    protected void ModificarCliente(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        Cliente cli = new Cliente();
        MetodosCliente mCli = new MetodosCliente();
        cli.setNombres(request.getParameter("txtNombres").toUpperCase());
        cli.setApellidos(request.getParameter("txtApellidos").toUpperCase());
        cli.setTelefono(request.getParameter("txtTelefono").toUpperCase());
        cli.setDireccion(request.getParameter("txtDireccion").toUpperCase());
        cli.setDocumento(request.getParameter("txtDocumento").toUpperCase());
        cli.setSexo(request.getParameter("txtSexo").toUpperCase());
        cli.setID_Us(Integer.parseInt(request.getParameter("UsuarioX")));
        cli.setID_Cat(Integer.parseInt(request.getParameter("txtCategoriaCli")));
        cli.setID(Integer.parseInt(request.getParameter("txtID")));
        if (request.getParameter("txtID") != null) {
            try {
                mCli.ModificarCliente(cli);
            } catch (Exception e) {
            }
        }
    }

    protected void EliminarCliente(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        Cliente cli = new Cliente();
        MetodosCliente mCli = new MetodosCliente();
        cli.setID(Integer.parseInt(request.getParameter("txtID")));
        if (request.getParameter("txtID") != null) {
            try {
                int retorno = mCli.EliminarCliente(cli);
                String respuesta = this.gson.toJson(retorno);
                PrintWriter out = response.getWriter();
                response.setContentType("application/json");
                out.print(respuesta);
            } catch (Exception e) {
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */

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
