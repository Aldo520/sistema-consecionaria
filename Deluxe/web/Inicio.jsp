
<%@page import="com.modelo.Home"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.modelo.MetodosHome"%>
<%-- 
    Document   : Inicio
    Created on : 02-nov-2021, 12:43:32
    Author     : Aldo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="layout/header.jsp"%>
<%@include file="layout/sidebar.jsp"%>
<%@include file="layout/navbar.jsp" %>
<title> | INICIO | </title>
<link href="resources/css/estilos.css" rel="stylesheet" type="text/css">
<div class="container-fluid">
    <%!
        MetodosHome obj = new MetodosHome();
        ArrayList<Home> lista = new ArrayList<>();
    %>
    <%       if (sesion.getAttribute("TIPO_USUARIO") == null) {
             response.sendRedirect("Login.jsp");
             
        }
    %>
    <div class="row justify-content-center">
        <div class="col-xl-4 col-md-4 mb-4">
            <div class="card border-left-warning shadow h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                Clientes Registrados</div>
                            <div class="h5 mb-0 font-weight-bold text-gray-800 "><%=obj.MostraClientes().getCliente()%>  En Total </div>
                        </div>
                        <div class="col-auto">
                            <img src="Imagenes/usuario.png" width="80%">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-4 col-md-4 mb-4">
            <div class="card border-left-warning shadow h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                Empleados  </div>
                            <div class="h5 mb-0 font-weight-bold text-gray-800 "><%=obj.MostraEmpleados().getEmpleados()%> En Total </div>
                        </div>
                        <div class="col-auto">
                            <img src="Imagenes/perfil.png" width="80%">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-4 col-md-4 mb-4">
            <div class="card border-left-warning shadow h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                Unidades Disponibles </div>
                            <div class="h5 mb-0 font-weight-bold text-gray-800 "><%=obj.MostraAutomovil().getAutomovil()%> En Total </div>
                        </div>
                        <div class="col-auto">
                            <img src="Imagenes/coche.png" width="80%"> 
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-6 col-md-12 mb-4">
            <div class="card mb-4">
                <div class="card-header bg-dark text-white">
                    El auto del mes
                </div>
                <div class="card-body">
                    <%=obj.AutomovildelMes().getDescripcion()%>
                </div>
            </div>
            <div class="card mb-4 py-3 border-bottom-success">
                <div class="card-body font-weight-bold">
                    Total de unidades vendidas <%=obj.AutomovildelMes().getVentas()%>
                </div>
            </div>
        </div>
        <div class="col-xl-6 col-md-12 mb-4">
            <img class="shadow" src="imagen?id=<%=obj.AutomovildelMes().getEspecificacion()%>" width="80%" style="display: block; margin: auto;" >
        </div>
        <%
            lista = obj.MostraCategorias();
            for (Home dato : lista) {
        %>
        <div class="col-md-3 mt-2 text-center">
            <div class="row">
                <div class="col-md-3"> <img class=" shadow rounded-circle" src="Imagenes/<%=dato.getCategoria()%>.png"></div>
                <div class="col-md-8 text-uppercase mt-3" ><h5><%=dato.getCategoria()%><h5></div>             
                            </div>
                            </div>


                            <%
                                }
                            %>
                            </div> 
                            </div>
                            </div>
                            <%@include file="layout/footer.jsp" %>
                            