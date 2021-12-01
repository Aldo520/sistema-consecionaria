<%-- 
    Document   : Empleado
    Created on : 10-23-2021, 03:03:12 PM
    Author     : Jonathan Alvarado
--%>

<%@page import="com.modelo.MetodosUsuario"%>
<%@page import="com.modelo.Usuario"%>
<%@page import="com.modelo.Empleado"%>
<%@page import="com.modelo.MetodosEmpleado"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<title>| EMPLEADOS | </title>
<%@include file="layout/header.jsp"%>
<%@include file="layout/sidebar.jsp"%>
<%@include file="layout/navbar.jsp"%>
<link href="validetta/validetta.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/estilos.css" rel="stylesheet" type="text/css">
<%    ArrayList<Empleado> listaU = new ArrayList<>();
    ArrayList<Usuario> Lista = new ArrayList<>();
    MetodosEmpleado emp = new MetodosEmpleado();
    MetodosUsuario mu = new MetodosUsuario();
%>
<%
    if (sesion.getAttribute("TIPO_USUARIO") == null) {
        response.sendRedirect(request.getContextPath() + "/Login.jsp");
    }
%>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-9">
            <h1 class="text-danger mr-2"> Empleados <i class="fas fa-user-tag" style="color: #0672A9;"></i></h1>
        </div>
        <%
           String var = String.valueOf(sesion.getAttribute("TIPO_USUARIO"));
            if (var.equals("ADMINISTRADOR")) {
        %>
        <div class="col-md-3">
            <button type="button" class="btn btn-block btn-agregar btn-sm"   data-toggle="modal" data-target="#ModalEmpleado" onclick="ocultarOpciones()">
                <i class="fas fa-user-tag" aria-hidden="true"></i> Nuevo Empleado
            </button>
        </div>
        <%
        } else if (var.equals("EMPLEADO")) {
        %>
        <div class="col-md-3">
            <button type="button" class="btn btn-block btn-agregar btn-sm"   data-toggle="modal" data-target="#ModalEmpleado" onclick="ocultarOpciones()" disabled="" title="No tienes permiso para realizar esta acción">
                <i class="fas fa-user-tag" aria-hidden="true"></i> Nuevo Empleado
            </button>
        </div>
        <%
            }
        %>
    </div>
    <div class="card shadow mt-3 mb-3 ">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-dark">Registros de Empleados</h6>
        </div>
        <div class="card-body" >
            <div class="table-responsive">
                <table class="table table-bordered example" width="100%" >
                    <thead class="btn-dark text-white text-center">
                    <th>ID</th>
                    <th>Nombres</th>
                    <th>Apellidos</th>
                    <th>Teléfono</th>
                    <th>Dirección</th>
                    <th>Documento</th>
                    <th>Sexo</th>
                    <th>Usuario</th>
                    <th>Opciones</th>
                    </thead>
                    <%
                        listaU = emp.MostrarEmpleado();
                        for (Empleado datos : listaU) {
                    %>
                    <tbody class="text-center">
                    <td class="id"><%=datos.getID()%></td>
                    <td class="nombre"><%=datos.getNombres()%></td>
                    <td class="apellido"><%=datos.getApellidos()%></td>
                    <td class="telefono"><%=datos.getTelefono()%></td>
                    <td class="direccion"><%=datos.getDireccion()%></td>
                    <td class="documento"><%=datos.getDocumento()%></td>
                    <td class="sexo"><%=datos.getSexo()%></td>
                    <td class="username"><%=datos.getNombre_usuario()%></td>
                    <td>
                        <%
                            if (var.equals("ADMINISTRADOR")) {
                        %>
                                <button type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#ModalEmpleado" id="btnEditar">
                                    <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                </button>
                                <button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#ModalEmpleado" id="btnEliminar">
                                    <i class="fa fa-trash" aria-hidden="true"></i>
                                </button>
                        <%
                        } else if (var.equals("EMPLEADO")) {
                        %>
                                <button type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#ModalEmpleado" id="btnEditar">
                                    <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                </button>
                                <button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#ModalEmpleado" id="btnEliminar" disabled=""  title="No tienes permiso para realizar esta acción">
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

<div class="modal fade" id="ModalEmpleado" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Cliente</h5>
            </div>
            <form method="POST" id="FormularioEmpleado">
                <div class="modal-body">
                    <div id="ID_Empleado">
                        <label>ID</label>       
                        <div class="input-group  shadow-sm mb-3">
                            <div class="input-group-prepend">
                                <div class="input-group-text "><i class="fas fa-id-badge"></i></div>
                            </div>
                            <input type="number" name="txtID"  class="form-control">
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
                    <label>Usuarios Disponibles</label>
                    <div class="input-group  shadow-sm mb-3">
                        <div class="input-group-prepend">
                            <div class="input-group-text"><i class="fas fa-users-cog"></i></div>
                        </div>
                        <select class="form-control" name="Usuario" id="Usuario">
                            <%
                                String dato = "ESTADO_USUARIO ='NO ASIGNADO' AND TIPO_USUARIO = 'EMPLEADO' OR 'ADMINISTRADOR'";
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
                            String datos = "ESTADO_USUARIO ='ASIGNADO'";
                            listaU = mu.MostrarUsuarios(datos);
                            for (Empleado users : listaU) {
                        %>
                        <option value="<%=users.getID_Us()%>"><%=users.getNombre_usuario()%></option>
                        <% }%>
                    </select>

                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-success btn-sm" name="btnEditarEmp"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Editar</button>
                    <button type="submit"  class="btn btn-primary btn-sm" name="btnAgregarEmp" onclick="agregarEmpleado()"><i class="fa fa-user-plus" aria-hidden="true"></i> Agregar</button>
                    <button type="submit" class="btn btn-danger btn-sm" name="btnEliminarEmp"><i class="fa fa-trash" aria-hidden="true"></i> Eliminar</button>
                    <button type="button" class="btn btn-warning text-white btn-sm" data-dismiss="modal"><i class="fas fa-times"></i> Close</button>
                </div>
            </form>

        </div>
    </div>
</div>   
</div>
<%@include file="layout/footer.jsp"%>
<script src="resources/js/Empleado.js"></script>