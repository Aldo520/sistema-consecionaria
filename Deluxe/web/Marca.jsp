<%-- 
    Document   : Marca
    Created on : 08-oct-2021, 20:09:49
    Author     : Aldo
--%>

<%@page import="com.modelo.MetodosMarca"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.modelo.Marca"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="layout/header.jsp"%>
<link href="validetta/validetta.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/estilos.css" rel="stylesheet" type="text/css">
<!DOCTYPE html>
<%
    HttpSession sesionM = request.getSession();
%>
<%
    if (sesionM.getAttribute("TIPO_USUARIO") != null) {
%>

<div class="container-fluid">

    <%!
        ArrayList<Marca> listaM = new ArrayList<>();
        MetodosMarca obj = new MetodosMarca();

    %>


    <div class="row">
        <div class="col-md-9">
            <h1 class="text-danger mr-2"> Marcas <i class="fas fa-car" style="color: #0672A9;"></i></h1>
        </div>
        <div class="col-md-3">
            <button type="button" class="btn btn-block btn-agregar btn-sm"   data-toggle="modal" data-target="#marca" id="btnNuevo" onclick="ocultarB()">
                <i class="fas fa-car" aria-hidden="true"></i> Agregar
            </button>
        </div>
    </div>

    <div class="card shadow mt-3 mb-3 ">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-dark">Registros de Marcas</h6>
        </div>
        <div class="card-body" >
            <div class="table-responsive">
                <table class="table table-bordered example" width="100%" cellspacing="0">
                    <thead class="btn-dark text-white text-center">
                    <th>Registro</th>
                    <th>Marca</th>
                    <th>Opcion</th>
                    </thead>
                    <tbody class="text-center">
                        <%
                            listaM = obj.MostrarRegistros();
                            for (Marca marca : listaM) {
                        %>
                        <tr>
                            <td class="registro"><%=marca.getRegistro()%></td>
                            <td class="marca"><%=marca.getMarca()%></td>
                            <td>
                                <button type="button" class="btn btn-success btn-sm " data-toggle="modal" data-target="#marca" id="btnEditar" onclick="mostrar()">
                                    <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                </button>
                                <button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#marca" id="btnEliminar" onclick="mostrar()">
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



