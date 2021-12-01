<%-- 
    Document   : Especificacion
    Created on : 11-oct-2021, 17:07:29
    Author     : Aldo
--%>

<%@page import="com.modelo.MetodosMarca"%>
<%@page import="com.modelo.MetodosCategoria"%>
<%@page import="com.modelo.Especificaciones"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.modelo.MetodosEspecificaciones"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<title> | ESPECIFICACIONES | </title>
<%@include file="layout/header.jsp"%>
<link href="validetta/validetta.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/estilos.css" rel="stylesheet" type="text/css">
<!DOCTYPE html>
<%
    HttpSession sesionD = request.getSession();
%>
<%
    if (sesionD.getAttribute("TIPO_USUARIO") != null) {
%>
<div class="container-fluid">

    <%!
        ArrayList<Especificaciones> listacolores = new ArrayList<>();
        MetodosEspecificaciones especificaciones = new MetodosEspecificaciones();
        MetodosCategoria categoria = new MetodosCategoria();
        MetodosMarca marca = new MetodosMarca();

    %>

    <div class="row">
        <div class="col-md-9">
            <h1 class="text-danger mr-2"> Especificaciones <i class="fas fa-car" style="color: #0672A9;"></i></h1>
        </div>
        <div class="col-md-3">
            <button type="button" class="btn btn-block btn-agregar btn-sm"   data-toggle="modal" data-target="#Especificacion" id="btnNuevo" onclick="ocultar()">
                <i class="fa fa-car" aria-hidden="true"></i> Agregar
            </button>
        </div>
    </div>

    <div class="card shadow mt-3 mb-3 ">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-dark">Registros de Especificaciones</h6>
        </div>
        <div class="card-body" >
            <div class="table-responsive">
                <table class="table table-bordered example" width="100%" >
                    <thead class="btn-dark text-white text-center">
                    <th>Cod</th>
                    <th>Categoria</th>
                    <th>Marca</th>
                    <th>Modelo</th>
                    <th>Foto</th>
                    <th>Stock</th>
                    <th class="d-none ">Descipcion</th>
                    <th>Opciones</th>
                    </thead>
                    <tbody class="text-center">
                        <%
                            listacolores = especificaciones.MostrarRegistros();
                            for (Especificaciones datos : listacolores) {

                        %>
                        <tr>
                            <td class="registro"><%=datos.getRegistro()%></td>
                            <td class="categoria"><%=categoria.MostrarCategoria(datos.getCategoria()).getCategoria()%></td>
                            <td class="marca"><%=marca.MostrarMarca(datos.getMarca()).getMarca()%></td>
                            <td class="modelos"><%=datos.getModelo()%></td>
                            <td class="foto">
                                <a href="imagen?id=<%=datos.getRegistro()%>" target="_blank"><img src="Imagenes/coche.png" title="imagen" width="40%" />
                                    <td><%=especificaciones.MostrarCantidad(datos.getRegistro()).getCantidad()%></td>
                                    <td class="d-none descrip"><%=datos.getDescripcion()%></td>
                                    <td>
                                        <button type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#Especificacion" id="btnEditar" onclick="mostrar()">
                                            <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                        </button>
                                        <button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#Especificacion" id="btnEliminar" onclick="mostrar()">
                                            <i class="fa fa-trash" aria-hidden="true"></i>
                                        </button>
                                    </td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<%
    }
%>