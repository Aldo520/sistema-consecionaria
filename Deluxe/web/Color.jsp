<%-- 
    Document   : Color
    Created on : 11-oct-2021, 12:27:13
    Author     : Aldo
--%>

<%@page import="com.modelo.MetodosColor"%>
<%@page import="com.modelo.Color"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    HttpSession sesionC = request.getSession();
%>
<%
    if (sesionC.getAttribute("TIPO_USUARIO") != null) {
%>

<div class="container-fluid">

    <%!
        ArrayList<Color> listacolores = new ArrayList<>();
        MetodosColor objColor = new MetodosColor();
    %>

    <div class="row">
        <div class="col-md-9">
            <h1 class="text-danger mr-2"> Colores <i class="fas fa-car" style="color: #0672A9;"></i></h1>
        </div>
        <div class="col-md-3">
            <button type="button" class="btn btn-block btn-agregar btn-sm"   data-toggle="modal" data-target="#Color" id="btnNuevo" onclick="ocultarB1()">
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
                    <th>Registro</th>
                    <th>Color</th>
                    <th>Opciones</th>
                    </thead>
                    <tbody class="text-center">
                        <%
                            listacolores = objColor.MostrarRegistros();
                            for (Color color : listacolores) {

                        %>
                        <tr>
                            <td class="registroX"><%=color.getRegistro()%></td>
                            <td class="colorX"><%=color.getColor()%></td>
                            <td>
                                <button type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#Color" id="btnEditarColor" onclick="mostrar1()">
                                    <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                </button>
                                <button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#Color" id="btnEliminarColor" onclick="mostrar1()">
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
