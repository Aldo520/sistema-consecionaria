<%-- 
    Document   : Cliente_Categoria
    Created on : 11-04-2021, 10:18:40 AM
    Author     : Jonathan Alvarado
--%>
<%@page import="com.modelo.MetodosCategoriaCliente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.modelo.CategoriaCliente"%>
<%!
    ArrayList<CategoriaCliente> listaCatCli = new ArrayList<>();
    MetodosCategoriaCliente mCatCli = new MetodosCategoriaCliente();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-9">
            <h1 class="text-danger mr-2"> Categorías <i class="fas fa-users-cog" style="color: #0672A9;"></i></h1>
        </div>
        <div class="col-md-3">
            <button type="button" class="btn btn-block btn-agregar btn-sm"   data-toggle="modal" data-target="#CategoriaCliente" id="btnNuevo" onclick="ocultarOpcionesCat()">
                <i class="fa fa-user-plus" aria-hidden="true"></i> Nueva Categoría
            </button>
        </div>
    </div>

    <div class="card shadow mt-3 mb-3 ">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-dark">Registros de Categotías</h6>
        </div>
        <div class="card-body" >
            <div class="table-responsive">
                <table class="table table-bordered example" width="100%" cellspacing="0">
                    <thead class="btn-dark text-white text-center">
                    <th>Registro</th>
                    <th>Categoría</th>
                    <th>Opciones</th>
                    </thead>
                    <tbody class="text-center">
                        <%
                            listaCatCli = mCatCli.MostrarRegistros();
                            for (CategoriaCliente cat : listaCatCli) {

                        %>
                        <tr>
                            <td class="IDCatCli"><%= cat.getCodigoCatCli()%></td>
                            <td class="CatCli"><%= cat.getCatClie()%></td>
                            <td>
                                        <button type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#CategoriaCliente" id="btnEditarCatCli" onclick="">
                                            <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                        </button>
                                        <button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#CategoriaCliente" id="btnEliminarCatCli" onclick="">
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
