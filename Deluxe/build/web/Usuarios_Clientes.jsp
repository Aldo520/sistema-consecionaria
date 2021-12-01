<%-- 
    Document   : Usuarios_Clientes
    Created on : 11-04-2021, 10:41:17 AM
    Author     : Jonathan Alvarado
--%>

<%@page import="com.modelo.MetodosUsuario"%>
<%@page import="com.modelo.MetodosEmpleado"%>
<%@page import="com.modelo.Usuario"%>
<%@page import="com.modelo.Usuario"%>
<%@page import="com.modelo.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<title> | CLIENTES | </title>
<%@include file="layout/header.jsp"%>
<%@include file="layout/sidebar.jsp"%>
<%@include file="layout/navbar.jsp"%>
<link href="validetta/validetta.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/estilos.css" rel="stylesheet" type="text/css">
<%
    if (sesion.getAttribute("TIPO_USUARIO") == null) {
        response.sendRedirect(request.getContextPath() + "/Login.jsp");
    }
%>
<div class="container-fluid">
    <ul class="nav nav-tabs nav-justified md-tabs indigo" id="myTabJust" role="tablist">
        <li class="nav-item">
            <a class="nav-link active" id="home-tab-just" data-toggle="tab" href="#home-just" role="tab" aria-controls="home-just"
               aria-selected="true">Clientes</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" id="profile-tab-just" data-toggle="tab" href="#categoria-cliente" role="tab" aria-controls="profile-just"
               aria-selected="false">Categorías</a>
        </li>
    </ul>

    <div class="tab-content card pt-5" id="myTabContentJust">
        <div class="tab-pane fade show active" id="home-just" role="tabpanel" aria-labelledby="home-tab-just">
            <%@include file="Clientes.jsp"%>
        </div>
        <div class="tab-pane fade" id="categoria-cliente" role="tabpanel" aria-labelledby="profile-tab-just">
            <%@include file="Cliente_Categoria.jsp"%>
        </div>
    </div>  
</div>
<%@include file="layout/footer.jsp"%>


<%    ArrayList<Empleado> listaU = new ArrayList<>();
    ArrayList<CategoriaCliente> listaCat = new ArrayList<>();
    ArrayList<Usuario> Lista = new ArrayList<>();
    MetodosEmpleado emp = new MetodosEmpleado();
    MetodosUsuario mu = new MetodosUsuario();
    MetodosCategoriaCliente mCatCli = new MetodosCategoriaCliente();
%>

<div class="modal fade cliente" id="ModalCliente" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Cliente</h5>
            </div>
            <form method="POST" id="FormularioCliente">
                <div class="modal-body">
                    <div id="ID_Cliente">
                        <label>ID</label>       
                        <div class="input-group  shadow-sm mb-3">
                            <div class="input-group-prepend">
                                <div class="input-group-text "><i class="fas fa-id-badge"></i></div>
                            </div>
                            <input type="number" name="txtID" id="ID_Cliente" class="form-control">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <label>Nombres</label>
                            <div class="input-group  shadow-sm mb-3">
                                <div class="input-group-prepend">
                                    <div class="input-group-text "><i class="fas fa-user"></i></div>
                                </div>
                                <input type="text" name="txtNombres" class="form-control" placeholder="1er nombre 2do nombre" data-validetta="required">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <label>Apellidos</label>
                            <div class="input-group  shadow-sm mb-3">
                                <div class="input-group-prepend">
                                    <div class="input-group-text bor"><i class="fas fa-user"></i></div>
                                </div>
                                <input type="text" name="txtApellidos" class="form-control" placeholder="1er apellido 2do apellido" data-validetta="required">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <label>Teléfono</label>
                            <div class="input-group  shadow-sm mb-3">
                                <div class="input-group-prepend">
                                    <div class="input-group-text "><i class="fas fa-phone"></i></div>
                                </div>
                                <input type="text" name="txtTelefono" class="form-control" placeholder="(+503) ####-####" data-validetta="required">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <label>Dirección</label>
                            <div class="input-group  shadow-sm mb-3">
                                <div class="input-group-prepend">
                                    <div class="input-group-text "><i class="fas fa-map-marker-alt"></i></div>
                                </div>
                                <input type="text" name="txtDireccion" class="form-control" placeholder="Ubicación..." data-validetta="required">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <label>Documento</label>
                            <div class="input-group  shadow-sm mb-3">
                                <div class="input-group-prepend">
                                    <div class="input-group-text "><i class="fas fa-id-card-alt"></i></div>
                                </div>
                                <input type="text" name="txtDocumento" class="form-control" placeholder="########-#" data-validetta="required">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <label>Genero</label>
                            <div class="input-group  shadow-sm mb-3">
                                <div class="input-group-prepend">
                                    <div class="input-group-text"><i class="fas fa-venus-mars"></i></div>
                                </div>
                                <select name="txtSexo" class="form-control" data-validetta="required">
                                    <option></option>
                                    <option values="MASCULINO">MASCULINO</option>
                                    <option values="FEMENINO">FEMENINO</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <label>Categoría de Cliente</label>
                    <div class="input-group  shadow-sm mb-3">
                        <div class="input-group-prepend">
                            <div class="input-group-text"><i class="fas fa-users-cog"></i></div>
                        </div>
                        <select  class="form-control" name="txtCategoriaCli" id="categoria">
                            <option value="0"></option>
                            <%
                                listaCat = mCatCli.MostrarRegistros();
                                for (CategoriaCliente cats : listaCat) {
                            %>
                            <option value="<%=cats.getCodigoCatCli()%>"><%=cats.getCatClie()%></option>
                            <% }%>
                        </select>
                    </div>
                        <label>Usuarios Disponibles</label>
                    <div class="input-group  shadow-sm mb-3">
                        <div class="input-group-prepend">
                            <div class="input-group-text"><i class="fas fa-users-cog"></i></div>
                        </div>
                        <select class="form-control" name="UsuarioX" id="UsuarioX">
                            <%
                                String dato = "ESTADO_USUARIO ='NO ASIGNADO' AND TIPO_USUARIO='CLIENTE'";
                                listaU = mu.MostrarUsuarios(dato);
                                for (Empleado users : listaU) {
                            %>
                            <option value="<%=users.getID_Us()%>"><%=users.getNombre_usuario()%></option>
                            <% }%>
                        </select>
                    </div>
                    <select class="form-control" name="Ugenerales" id="Ugenerales">
                        <option></option>
                        <%
                            String datos = "ESTADO_USUARIO ='ASIGNADO' AND TIPO_USUARIO='CLIENTE'";
                            listaU = mu.MostrarUsuarios(datos);
                            for (Empleado users : listaU) {
                        %>
                        <option value="<%=users.getID_Us()%>"><%=users.getNombre_usuario()%></option>
                        <% }%>
                    </select>
                        
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-success btn-sm" name="btnEditarCliente"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Editar</button>
                    <button type="submit"  class="btn btn-primary btn-sm" name="btnAgregarCliente" onclick="agregarCliente()"><i class="fa fa-user-plus" aria-hidden="true"></i> Agregar</button>
                    <button type="submit" class="btn btn-danger btn-sm" name="btnEliminarCliente"><i class="fa fa-trash" aria-hidden="true"></i> Eliminar</button>
                    <button type="button" class="btn btn-warning text-white btn-sm" data-dismiss="modal"><i class="fas fa-times"></i> Close</button>
                </div>
            </form>

        </div>
    </div>
</div> 

<div class="modal fade" id="CategoriaCliente" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Categorías</h5>
            </div>
            <form  method="POST" id="FormularioCatCli">
                <div class="modal-body">
                    <div id="txtIDCategoria">
                        <label>Codigo</label>
                        <div class="input-group  shadow-sm mb-3">
                            <div class="input-group-prepend">
                                <div class="input-group-text "><i class="fas fa-bookmark"></i></div>
                            </div>
                            <input type="text" name="txtIDCatCli" class="form-control" placeholder="Registro" >
                        </div>
                    </div>
                    <label>Categoria</label>
                    <div class="input-group  shadow-sm mb-3">
                        <div class="input-group-prepend">
                            <div class="input-group-text"><i class="fas fa-car"></i></div>
                        </div>
                        <input type="text" name="txtCategoriaCliente" class="form-control" placeholder="Nueva Categoría" data-validetta="required">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit"  class="btn btn-primary btn-sm" name="btnAgregarCatCli" onclick="agregarCategoriaCliente()"><i class="fa fa-car" aria-hidden="true"></i> Agregar</button>
                    <button type="submit" class="btn btn-success btn-sm" name="btnEditarCatCli"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Editar</button>
                    <button type="submit" class="btn btn-danger btn-sm" name="btnEliminarCatCli"><i class="fa fa-trash" aria-hidden="true"></i> Eliminar</button>
                    <button type="button" class="btn btn-warning text-white btn-sm" data-dismiss="modal"><i class="fas fa-times"></i> Close</button>
                </div>
            </form>

        </div>
    </div>
</div>
<script src="resources/js/CategoriaCliente.js"></script>
<script src="resources/js/Cliente.js"></script>