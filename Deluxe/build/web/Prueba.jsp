<%-- 
    Document   : Prueba
    Created on : 19-oct-2021, 12:07:02
    Author     : Aldo
--%>


<%@page import="com.modelo.MetodosCliente"%>
<%@page import="com.modelo.Cliente"%>
<%@page import="com.modelo.Usuario"%>
<%@page import="com.modelo.MetodosUsuario"%>
<%@page import="com.modelo.MetodosColor"%>
<%@page import="com.modelo.MetodosEspecificaciones"%>
<%@page import="com.modelo.MetodosAutomoviles"%>
<%@page import="com.modelo.Automovil"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="layout/header.jsp"%>
<%@include file="layout/sidebar.jsp"%>
<%@include file="layout/navbar.jsp"%>
<link href="validetta/validetta.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/estilos.css" rel="stylesheet" type="text/css">

<div class="container-fluid">
    <%    
       if (sesion.getAttribute("TIPO_USUARIO") == null) {
        response.sendRedirect(request.getContextPath() + "/Login.jsp");
        }
    %>
    <%!
        MetodosEspecificaciones ME = new MetodosEspecificaciones();
        ArrayList<Automovil> listaV = new ArrayList<>();
        ArrayList<Cliente> listaU = new ArrayList<>();
        MetodosAutomoviles MV = new MetodosAutomoviles();
        MetodosColor MC = new MetodosColor();
        MetodosCliente mu = new MetodosCliente();
    %>
    
    <div class="card shadow mt-3">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-dark">Ingresa tu pedido</h6>
        </div>
        <div class="card-body">
            <div class="row">
                <div class="col-md-3 mt-2">
                    <input type="text" class="form-control" name="TxtMotor" placeholder="Codigo de motor"  id="TxtMotor" requerid>
                </div>
                <div class="col-md-3 mt-2">
                    <input type="text" class="form-control" name="TxtPrecio" placeholder="Precio del auto" id="TxtPrecio" requerid>
                </div>
                <div class="col-md-3 mt-2">

                    <select class="form-control" id="TxtCliente">
                        <option value="">---Clientes-----</option>
                        <%
                            listaU = mu.MostrarCliente();
                            for (Cliente dato : listaU) {

                        %>
                        <option value="<%=dato.getID()%>"><%=dato.getNombres()%></option>
                        <%
                            }
                        %>
                    </select>
                </div>
                <div class="col-md-3 mt-2">
                    <button class="btn btn-dark btn-block"id="btnAdd" data-toggle="modal" data-target="#AutoDisponible">
                        <i class="fa fa-user-plus" aria-hidden="true"></i> Añadir
                    </button>
                </div>
            </div>
        </div>
    </div>


    <form  method="POST" id="FormularioPedido">   
        <div class="row"> 

            <div class="col-md-12 mt-4">
                <h3 class="text-dark">MI PEDIDO <i class="fas fa-shopping-cart"></i> </h3>
            </div>
            <div class="col-md-12">
                <div class="table-responsive">     

                    <table class="table" id="tblInfo" width="100%" cellspacing="0">
                        <thead class="bg-success text-center text-white">
                        <th>Modelo</th>
                        <th>Codigo Motor</th>
                        <th>Transmision</th>
                        <th>Version</th>
                        <th>Precio</th>
                        <th>Fotografia</th>
                        <th>Opciones</th>
                        </thead>
                        <hr>
                        <tbody class="text-center">
                            <tr>

                            </tr> 
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="mt-3 col-md-6 mb-3">
                <div class="card shadow">
                    <div class="card-header bg-dark ">
                        <h6 class="mt-1 mb-1 font-weight-bold text-white text-center">Calculo de la compra</h6>
                    </div>
                    <div class="card-body">
                        <div class="row">

                            <div class="col-4 text-center">
                                <label>Venta Realizada por</label>
                            </div>
                            <div class="col-7 text-center">
                                <div class="text-center">
                                    <input type="text" class="border-0" value="<%=session.getAttribute("NOMBRE_USUARIO") %>">
                                </div>
                            </div>

                            <div class="col-4 text-center">
                                <label>Iva</label>
                            </div>

                            <div class="col-7 text-center">
                                <div class="text-center">
                                    <input type="text" class="border-0"id="Iva" value="0.0">
                                </div>
                            </div>

                            <div class="col-4 text-center">
                                <label>Total Neto</label>
                            </div>
                            <div class="col-7 text-center">

                                <input type="text" class="border-0"id="Total" value="0.0">
                                <hr>

                            </div>

                            <div class="col-4 text-center">
                                <label>Total a pagar</label>
                            </div>
                            <div class="col-7 text-center">
                                <div class="text-center">
                                    <input type="text" class="border-0"id="TotalFinal" value="0.0">
                                </div>
                            </div>
                            <input class="border-0" type="text" name="Cliente" value="" id="Cliente">
                            <input  class="border-0"type="text" name="Empleado" value="<%=session.getAttribute("ID_USUARIO") %>" id="Empleado">
                        </div>
                    </div>
                </div>
                <div class="row justify-content-md-center">
                    <div class="col-md-6 mt-2">

                        <button class="btn btn-danger btn-block "id="btnNuevo" onclick="agregarpedido()">
                            <i class="fa fa-user-plus" aria-hidden="true"></i> Agregar
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </form>               
</div>
</div>
<%@include file="layout/footer.jsp"%>
<script src="resources/js/prueba.js"></script> 


