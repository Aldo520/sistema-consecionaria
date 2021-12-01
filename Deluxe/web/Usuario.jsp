<%-- 
    Document   : Usuario
    Created on : 10-20-2021, 07:02:22 PM
    Author     : Jonathan Alvarado
--%>

<%@page import="com.modelo.MetodosUsuario"%>
<%@page import="com.modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<title> | USUARIO | </title>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="layout/header.jsp"%>
<%@include file="layout/sidebar.jsp"%>
<%@include file="layout/navbar.jsp"%>
<link href="validetta/validetta.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/estilos.css" rel="stylesheet" type="text/css">

<%    ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    MetodosUsuario user = new MetodosUsuario();
%>
<%
    if (sesion.getAttribute("TIPO_USUARIO") == null) {
        response.sendRedirect(request.getContextPath() + "/Login.jsp");
    }
%>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-9">
            <h1 class="text-danger mr-2"> Usuarios <i class="fas fa-users-cog" style="color: #0672A9;"></i></h1>
        </div>
        <%
           String var = String.valueOf(sesion.getAttribute("TIPO_USUARIO"));
            if (var.equals("ADMINISTRADOR")) {
        %>
        <div class="col-md-3">
            <button type="button" class="btn btn-block btn-agregar btn-sm"   data-toggle="modal" data-target="#ModalUsuario" id="btnNuevo" onclick="Agregar()">
                <i class="fas fa-users-cog" aria-hidden="true"></i> Nuevo Usuario
            </button>
        </div>
        <%
        } else if (var.equals("EMPLEADO")) {
        %>
        <div class="col-md-3" style="">
            <button type="button" class="btn btn-block btn-agregar btn-sm"   data-toggle="modal" data-target="#ModalUsuario" id="btnNuevo" onclick="Agregar()" disabled="" title="No tienes permiso para realizar esta acción">
                <i class="fas fa-users-cog" aria-hidden="true"></i> Nuevo Usuario
            </button>
        </div>
        <%
            }
        %>

    </div>
    <div class="card shadow mt-3 mb-3 ">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-dark">Registros de Usuarios</h6>
        </div>
        <div class="card-body" >
            <div class="table-responsive">
                <table class="table table-bordered example" width="100%" >
                    <thead class="btn-dark text-white text-center">
                    <th>ID</th>
                    <th>Usuario</th>
                    <th>Correo Electronico</th>
                    <th>Tipo de Usuario</th>
                    <th>Foto</th>
                    <th>Estado</th>
                    <th>Opciones</th>
                    </thead>
                    <tbody class="text-center">
                        <%
                            listaUsuarios = user.MostrarUsuario();
                            for (Usuario datos : listaUsuarios) {
                        %>
                        <tr>
                            <td class="id"><%=datos.getId()%></td>
                            <td class="username"><%=datos.getNombre_usuario()%></td>
                            <td class="correo"><%=datos.getCorreo()%></td>
                            <td class="tipo"><%=datos.getTipo_usuario()%></td>
                            <td class=""><a href="UsuarioImagen?id=<%=datos.getId()%>" target="_blank"><img src="Imagenes/perfil.png" title="imagen" width="40%" /></td>
                            <td class="usuario_estado"><%=datos.getEstado_usuario()%></td>
                            <td>
                                <%
                                    if (var.equals("ADMINISTRADOR")) {
                                %>
                                    <button type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#ModalUsuario" id="btnEditar" onclick="mostrar()">
                                        <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                    </button>
                                    <button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#ModalUsuario" id="btnEliminar" onclick="mostrar()">
                                        <i class="fa fa-trash" aria-hidden="true"></i>
                                    </button>
                                <%
                                } else if (var.equals("EMPLEADO")) {
                                %>
                                <button type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#ModalUsuario" id="btnEditar" onclick="mostrar()" disabled=""  title="No tienes permiso para realizar esta acción">
                                        <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                    </button>
                                <button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#ModalUsuario" id="btnEliminar" onclick="mostrar()" disabled="" title="No tienes permiso para realizar esta acción">
                                        <i class="fa fa-trash" aria-hidden="true"></i>
                                    </button>
                                <%
                                    }
                                %>
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

</div>
<%@include file="layout/footer.jsp"%>


<div class="modal fade" id="ModalUsuario" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Usuario</h5>
            </div>
            <form method="POST" id="FormularioUsuario" enctype="multipart/form-data">
                <div class="modal-body">
                    <div class="row ">
                        <div class=" col-md-12 mt-4 text-center">
                            <img  id="imagenPrevisualizacion" src="" class="rounded">
                        </div> 
                        <div class="col-md-12 mb-4 mt-4">
                            <input type="file" id="seleccionArchivos" accept="image/*" name="Imagen"  class="rounded">
                        </div>
                    </div>
                    <div id="ID">
                        <label>ID</label>       
                        <div class="input-group  shadow-sm mb-3">
                            <div class="input-group-prepend">
                                <div class="input-group-text "><i class="fas fa-id-badge"></i></div>
                            </div>
                            <input type="number" name="txtID" id="ID" class="form-control">
                        </div>
                    </div>
                    <label>Nombre de Usuario</label>
                    <div class="input-group  shadow-sm mb-3">
                        <div class="input-group-prepend">
                            <div class="input-group-text "><i class="fas fa-user"></i></div>
                        </div>
                        <input type="text" name="txtUserName" class="form-control" placeholder="Nombre de Usuario..." data-validetta="required">
                    </div>
                    <label>Correo Electronico</label>
                    <div class="input-group  shadow-sm mb-3">
                        <div class="input-group-prepend">
                            <div class="input-group-text "><i class="fas fa-at"></i></div>
                        </div>
                        <input type="mail" name="txtCorreo" class="form-control" placeholder="example@gmail.com" data-validetta="required">
                    </div>
                    <div id="contra">
                        <label>Contraseña</label>
                        <div class="input-group  shadow-sm mb-3">
                            <div class="input-group-prepend">
                                <div class="input-group-text "><i class="fas fa-key"></i></div>
                            </div>
                            <input type="password" name="txtContrasenia" class="form-control" placeholder="++++++++++++">
                        </div>
                    </div>
                    <label>Tipo Usuario</label>
                    <div class="input-group  shadow-sm mb-3">
                        <div class="input-group-prepend">
                            <div class="input-group-text"><i class="fas fa-users-cog"></i></div>
                        </div>
                        <select name="tipousuario" class="form-control" data-validetta="required">
                            <option></option>
                            <option values="ADMINISTRADOR">ADMINISTRADOR</option>
                            <option values="EMPLEADO">EMPLEADO</option>
                            <option values="CLIENTE">CLIENTE</option>
                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-success btn-sm" name="btnEditarUser"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Editar</button>
                    <button type="submit"  class="btn btn-primary btn-sm" name="btnAgregarUser" onclick="agregarUser()"><i class="fa fa-user-plus" aria-hidden="true"></i> Agregar</button>
                    <button type="submit" class="btn btn-danger btn-sm" name="btnEliminarUser"><i class="fa fa-trash" aria-hidden="true"></i> Eliminar</button>
                    <button type="button" class="btn btn-warning text-white btn-sm" data-dismiss="modal"><i class="fas fa-times"></i> Close</button>
                </div>
            </form>

        </div>
    </div>
</div>     
<script src="resources/js/Usuario.js"></script>