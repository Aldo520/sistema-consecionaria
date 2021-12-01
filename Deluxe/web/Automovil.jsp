<%-- 
    Document   : Automovil
    Created on : 11-oct-2021, 17:07:40
    Author     : Aldo
--%>

<%@page import="com.modelo.MetodosEspecificaciones"%>
<%@page import="com.modelo.MetodosColor"%>
<%@page import="com.modelo.MetodosAutomoviles"%>
<%@page import="com.modelo.Automovil"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<link href="validetta/validetta.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/estilos.css" rel="stylesheet" type="text/css">
<!DOCTYPE html>
<%
    HttpSession sesionB = request.getSession();
%>
<%
    if (sesionB.getAttribute("TIPO_USUARIO") != null) {
%>
<div class="container-fluid">

    <%!
        ArrayList<Automovil> listaV = new ArrayList<>();
        MetodosAutomoviles MV = new MetodosAutomoviles();
        MetodosColor MC = new MetodosColor();
        MetodosEspecificaciones ME = new MetodosEspecificaciones();

    %>

    <div class="row">
        <div class="col-md-9">
            <h1 class="text-danger mr-2"> Automoviles <i class="fas fa-car" style="color: #0672A9;"></i></h1>
        </div>
        <div class="col-md-3">
            <button type="button" class="btn btn-block btn-agregar btn-sm "   data-toggle="modal" data-target="#automovil" id="btnNuevo" onclick="ocultarB()">
                <i class="fa fa-car" aria-hidden="true"></i> Agregar
            </button>
        </div>
    </div>

    <div class="card shadow mt-3 mb-3 ">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-dark">Registros de Automoviles</h6>
        </div>
        <div class="card-body" >
            <div class="table-responsive">
                <table class="table table-bordered example" width="100%" cellspacing="0">
                    <thead class="btn-dark text-white text-center">
                    <th>Motor</th>
                    <th>Auto</th>
                    <th>Color</th>
                    <th>Transmision</th>
                    <th>Version</th>
                    <th>Precio</th>
                    <th>Opciones</th>
                    </thead>
                    <tbody class="text-center">
                        <%
                            listaV = MV.MostrarRegistros();
                            for (Automovil Da : listaV) {
                        %>
                        <tr>
                            <td class="codigo"><%=Da.getCodigo_Motor()%></td>
                            <td class="modelo"><%= ME.MostrarEspecificacion(Da.getEspecificacion()).getModelo()%></td>
                            <td class="color"><%= MC.MostrarColor(Da.getColor()).getColor()%></td>
                            <td class="transmision"><%= Da.getTransmision()%></td>
                            <td class="version"><%= Da.getVersion()%></td>
                            <td class="precio"><%= Da.getPrecio()%></td>
                            <td>
                                <button type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#automovil" id="btnEditarAutomovil">
                                    <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                </button>
                                <button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#automovil" id="btnEliminarAutomovil">
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