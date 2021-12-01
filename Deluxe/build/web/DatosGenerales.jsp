<%-- 
    Document   : Automovil
    Created on : 08-oct-2021, 11:53:50
    Author     : Aldo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<title> | DATOS GENERALES | </title>
<%@include file="layout/header.jsp"%>
<%@include file="layout/sidebar.jsp"%>
<%@include file="layout/navbar.jsp"%>
<link href="validetta/validetta.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/estilos.css" rel="stylesheet" type="text/css">
<div class="container-fluid">
    <%    
       if (sesion.getAttribute("TIPO_USUARIO") == null) {
        response.sendRedirect(request.getContextPath() + "/Login.jsp");
        }
    %>

    <ul class="nav nav-tabs nav-justified md-tabs indigo" id="myTabJust" role="tablist">
        <li class="nav-item">
            <a class="nav-link active" id="home-tab-just" data-toggle="tab" href="#home-just" role="tab" aria-controls="home-just"
               aria-selected="true">Marcas</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" id="profile-tab-just" data-toggle="tab" href="#profile-just" role="tab" aria-controls="profile-just"
               aria-selected="false">Categorias</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" id="contact-tab-just" data-toggle="tab" href="#contact-just" role="tab" aria-controls="contact-just"
               aria-selected="false">Colores</a>
        </li>
    </ul>

    <div class="tab-content card pt-5" id="myTabContentJust">
        <div class="tab-pane fade show active" id="home-just" role="tabpanel" aria-labelledby="home-tab-just">

            <%@include file="Marca.jsp"%>

        </div>
        <div class="tab-pane fade" id="profile-just" role="tabpanel" aria-labelledby="profile-tab-just">
            <%@include file="Categoria.jsp"%>
        </div>

        <div class="tab-pane fade" id="contact-just" role="tabpanel" aria-labelledby="contact-tab-just">
            <%@include file="Color.jsp"%>
        </div>
    </div>  
</div>
</div>
<%@include file="layout/footer.jsp"%>

<!-- Large modal -->


<div class="modal fade" id="Color" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Colores</h5>
            </div>
            <form  method="POST" id="FormularioColor">
                <div class="modal-body">
                    <div id="Ccolores">
                        <label>Codigo</label>
                        <div class="input-group  shadow-sm mb-3">
                            <div class="input-group-prepend">
                                <div class="input-group-text "><i class="fas fa-bookmark"></i></div>
                            </div>
                            <input type="text" name="TxtRegistro" class="form-control" placeholder="Registro" >
                        </div>
                    </div>
                    <label>Categoria</label>
                    <div class="input-group  shadow-sm mb-3">
                        <div class="input-group-prepend">
                            <div class="input-group-text"><i class="fas fa-car"></i></div>
                        </div>
                        <input type="text" name="TxtColor" class="form-control" placeholder="Nombre de la Color" data-validetta="required">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit"  class="btn btn-primary btn-sm" name="btnAgregarColores" onclick="agregarColor()"><i class="fa fa-car" aria-hidden="true"></i> Agregar</button>
                    <button type="submit" class="btn btn-success btn-sm" name="btnEditarColores"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Editar</button>
                    <button type="submit" class="btn btn-danger btn-sm" name="btnEliminarColores"><i class="fa fa-trash" aria-hidden="true"></i> Eliminar</button>
                    <button type="button" class="btn btn-warning text-white btn-sm" data-dismiss="modal"><i class="fas fa-times"></i> Close</button>
                </div>
            </form>

        </div>
    </div>
</div>


<div class="modal fade" id="marca" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Marca</h5>
            </div>
            <form  method="POST" id="Formulario">
                <div class="modal-body">
                    <div id="delta">
                        <label>Codigo</label>
                        <div class="input-group  shadow-sm mb-3">
                            <div class="input-group-prepend">
                                <div class="input-group-text "><i class="fas fa-bookmark"></i></div>
                            </div>
                            <input type="text" name="TxtRegistro" class="form-control" placeholder="Registro">
                        </div>
                    </div>
                    <label>Marca</label>
                    <div class="input-group  shadow-sm mb-3">
                        <div class="input-group-prepend">
                            <div class="input-group-text"><i class="fas fa-car"></i></div>
                        </div>
                        <input type="text" name="TxtMarca" class="form-control" placeholder="Nombre de la Marca" data-validetta="required">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit"  class="btn btn-primary btn-sm" name="btnAgregar" onclick="agregar()"><i class="fa fa-car" aria-hidden="true"></i> Agregar</button>
                    <button type="submit" class="btn btn-success btn-sm" name="btnEditar"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Editar</button>
                    <button type="submit" class="btn btn-danger btn-sm" name="btnEliminar"><i class="fa fa-trash" aria-hidden="true"></i> Eliminar</button>
                    <button type="button" class="btn btn-warning text-white btn-sm" data-dismiss="modal"><i class="fas fa-times"></i> Close</button>
                </div>
            </form>

        </div>
    </div>
</div>
<div class="modal fade" id="categoria" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Categoria</h5>
            </div>
            <form  method="POST" id="FormularioCategoria">
                <div class="modal-body">
                    <div class="row">
                    <div class="col-md-12">
                        <div id="Ccategoria">
                            <label>Codigo</label>
                            <div class="input-group  shadow-sm mb-3">
                                <div class="input-group-prepend">
                                    <div class="input-group-text "><i class="fas fa-bookmark"></i></div>
                                </div>
                                <input type="text" name="TxtRegistro" class="form-control" placeholder="Registro">
                            </div>
                        </div>
                        <label>Categoria</label>
                        <div class="input-group  shadow-sm mb-3">
                            <div class="input-group-prepend">
                                <div class="input-group-text"><i class="fas fa-car"></i></div>
                            </div>
                            <input type="text" name="TxtCategoria" class="form-control" placeholder="Nombre de la Categoria" data-validetta="required">
                        </div>
                    </div>
                    
                      </div> 
                <div class="modal-footer">
                    <button type="submit"  class="btn btn-primary btn-sm" name="btnAgregarC" onclick="agregarCategoria()"><i class="fa fa-car" aria-hidden="true"></i> Agregar</button>
                    <button type="submit" class="btn btn-success btn-sm" name="btnEditarC"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Editar</button>
                    <button type="submit" class="btn btn-danger btn-sm" name="btnEliminarC"><i class="fa fa-trash" aria-hidden="true"></i> Eliminar</button>
                    <button type="button" class="btn btn-warning text-white btn-sm" data-dismiss="modal"><i class="fas fa-times"></i> Close</button>
                </div>
            </form>

        </div>
    </div>
</div>
<script src="resources/js/Color.js"></script>
<script src="resources/js/Categoria.js"></script>
<script src="resources/js/Marca.js"></script>