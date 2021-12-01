<%-- 
    Document   : Reportes
    Created on : 11-03-2021, 06:33:41 PM
    Author     : Jonathan Alvarado
--%>

<%@page import="com.modelo.MetodosCliente"%>
<%@page import="com.modelo.Cliente"%>
<%@page import="com.modelo.MetodosCategoriaCliente"%>
<%@page import="com.modelo.CategoriaCliente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.modelo.MetodosMarca"%>
<%@page import="com.modelo.Marca"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="layout/header.jsp"%>
<%@include file="layout/sidebar.jsp"%>
<%@include file="layout/navbar.jsp" %>
<link href="resources/css/estilos.css" rel="stylesheet" type="text/css">
<%!
    ArrayList<Marca> lista = new ArrayList<>();
    MetodosMarca marcas = new MetodosMarca();
    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<CategoriaCliente> listaCat = new ArrayList<>();
    MetodosCategoriaCliente catCli = new MetodosCategoriaCliente();
    MetodosCliente mCli = new MetodosCliente();
%>
    <%    
       if (sesion.getAttribute("TIPO_USUARIO") == null) {
        response.sendRedirect(request.getContextPath() + "/Login.jsp");
        }
    %>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-xl-4 col-md-6 mb-4">
            <div class="card border-left-warning shadow h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <label><strong>Autos por Marca</strong> </label>
                            <div class="h5 mb-0 font-weight-bold text-gray-800 text-center">
                                <button type="button" class="btn btn-reporte btn-sm" data-toggle="modal" data-target="#AutoMarca"> <i class="fas fa-car" aria-hidden="true"></i> Marcas</button>
                            </div>
                        </div>
                        <div class="col-auto">
                            <img src="Imagenes/coche.png" width="80%">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-4 col-md-6 mb-4">
            <div class="card border-left-warning shadow h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <label><strong>Clientes por Categorias</strong> </label>
                            <div class="h5 mb-0 font-weight-bold text-gray-800 text-center">
                                <button type="button" class="btn btn-reporte btn-sm" data-toggle="modal" data-target="#ClienteCategoria"> <i class="fas fa-users" aria-hidden="true"></i> Categorías</button>
                            </div>
                        </div>
                        <div class="col-auto">
                            <img src="Imagenes/usuario.png" width="80%">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-4 col-md-6 mb-4">
            <div class="card border-left-warning shadow h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <label><strong>Ventas por Clientes</strong> </label>
                            <div class="h5 mb-0 font-weight-bold text-gray-800 text-center">
                                <button type="button" class="btn btn-reporte btn-sm" data-toggle="modal" data-target="#VentaCliente"> <i class="fas fa-users" aria-hidden="true"></i> Clientes</button>
                            </div>
                        </div>
                        <div class="col-auto">
                            <img src="Imagenes/compras.png" width="80%">
                        </div>
                    </div>
                </div>
        </div>
    </div>
    </div>
    
     <div class="row justify-content-center">
        <div class="col-xl-4 col-md-6 mb-4">
            <div class="card border-left-warning shadow h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <label><strong>Ventas del Día</strong> </label>
                            <div class="h5 mb-0 font-weight-bold text-gray-800 text-center">
                                 <a class="btn btn-reporte btn-sm" href="${pageContext.request.contextPath}/reportes/VentasDia.jsp" target="_blank"> 
                                    Generar <i class="fas fa-download"></i></a>    
                            </div>
                        </div>
                        <div class="col-auto">
                            <img src="Imagenes/deldia.png" width="80%">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-4 col-md-6 mb-4">
            <div class="card border-left-warning shadow h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <label><strong>Ventas Totales</strong> </label>
                            <div class="h5 mb-0 font-weight-bold text-gray-800 text-center">
                                <a class="btn btn-reporte btn-sm" href="${pageContext.request.contextPath}/reportes/VentasTotales.jsp" target="_blank"> 
                                    Generar <i class="fas fa-download"></i></a>        
                            </div>
                        </div>
                        <div class="col-auto">
                            <img src="Imagenes/ventastotales.png" width="80%">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="modal fade" id="AutoMarca" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Marcas Disponibles</h5>
            </div>
            <form action="${pageContext.request.contextPath}/reportes/AutoMarca.jsp" method="POST" target="_blank">
                <div class="modal-body">
                    <div>
                        <label>Seleccionar</label>
                        <div class="input-group  shadow-sm mb-3">
                            <div class="input-group-prepend">
                                <div class="input-group-text"><i class="fas fa-car"></i></div>
                            </div>
                            <select class="form-control" name="SelectMarca" required="">
                                <option></option>
                                <%
                                    lista = marcas.MostrarRegistros();
                                    for (Marca marca : lista) {

                                %>
                                <option value="<%=marca.getRegistro()%>"><%=marca.getMarca()%></option>
                                <% }%>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary btn-sm" data-dismiss="modal"><i class="fas fa-times"></i> Cerrar</button>
                    <button type="submit" class="btn btn-reporte btn-sm" name="ReporteAutoMarca"><i class="fas fa-download"></i> Generar Reporte</button>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="modal fade" id="ClienteCategoria" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Categorías Disponibles</h5>
            </div>
            <form action="${pageContext.request.contextPath}/reportes/CategoriaCliente.jsp" method="POST" target="_blank">
                <div class="modal-body">
                    <div>
                        <label>Seleccionar</label>
                        <div class="input-group  shadow-sm mb-3">
                            <div class="input-group-prepend">
                                <div class="input-group-text"><i class="fas fa-users"></i></div>
                            </div>
                            <select class="form-control" name="SelectCatCli" required="">
                                <option></option>
                                <%
                                    listaCat = catCli.MostrarRegistros();
                                    for (CategoriaCliente cats : listaCat) {

                                %>
                                <option value="<%=cats.getCodigoCatCli()%>"><%=cats.getCatClie()%></option>
                                <% }%>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary btn-sm" data-dismiss="modal"><i class="fas fa-times"></i> Cerrar</button>
                    <button type="submit" class="btn btn-reporte btn-sm" name="ReporteClienteCategoria"><i class="fas fa-download"></i> Generar Reporte</button>
                </div>
            </form>

        </div>
    </div>
</div>
<div class="modal fade" id="VentaCliente" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Clientes Activos</h5>
            </div>
            <form action="${pageContext.request.contextPath}/reportes/VentaCliente.jsp" method="POST" target="_blank">
                <div class="modal-body">
                    <div>
                        <label>Seleccionar</label>
                        <div class="input-group  shadow-sm mb-3">
                            <div class="input-group-prepend">
                                <div class="input-group-text"><i class="fas fa-car"></i></div>
                            </div>
                            <select class="form-control" name="SelectCliente" required="">
                                <option></option>
                                <%
                                    clientes = mCli.MostrarCliente();
                                    for (Cliente listCli : clientes) {

                                %>
                                <option value="<%=listCli.getID()%>"><%=listCli.getNombres() + " " + listCli.getApellidos()%></option>
                                <% }%>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary btn-sm" data-dismiss="modal"><i class="fas fa-times"></i> Cerrar</button>
                    <button type="submit" class="btn btn-reporte btn-sm" name="ReporteVentaCliente"><i class="fas fa-download"></i> Generar Reporte</button>
                </div>
            </form>
        </div>
    </div>
</div>
</div>
<%@include file="layout/footer.jsp" %>