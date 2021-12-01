<%-- 
    Document   : Inventario
    Created on : 11-oct-2021, 17:03:08
    Author     : Aldo
--%>

<%@page import="com.modelo.Color"%>
<%@page import="com.modelo.Categoria"%>
<%@page import="com.modelo.Marca"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@include file="layout/header.jsp"%>
<%@include file="layout/sidebar.jsp"%>
<%@include file="layout/navbar.jsp"%>
<link href="validetta/validetta.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/estilos.css" rel="stylesheet" type="text/css">
<div class="container-fluid">
    <%!
        ArrayList<Marca> lista = new ArrayList<>();
        ArrayList<Categoria> ListaCategoria = new ArrayList<>();
        ArrayList<Especificaciones> ListaEspecificaciones = new ArrayList<>();
        ArrayList<Color> ListaColor = new ArrayList<>();
        MetodosMarca marcas = new MetodosMarca();
        MetodosCategoria categorias = new MetodosCategoria();
        MetodosEspecificaciones MES = new MetodosEspecificaciones();
        MetodosColor color = new MetodosColor();
    %>
    <%    
       if (sesion.getAttribute("TIPO_USUARIO") == null) {
        response.sendRedirect(request.getContextPath() + "/Login.jsp");
        }
    %>
    <ul class="nav nav-tabs nav-justified md-tabs indigo" id="myTabJust" role="tablist">
        <li class="nav-item">
            <a class="nav-link active" id="home-tab-just" data-toggle="tab" href="#home-just" role="tab" aria-controls="home-just"
               aria-selected="true">Especificaciones</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" id="profile-tab-just" data-toggle="tab" href="#profile-just" role="tab" aria-controls="profile-just"
               aria-selected="false">Automovil</a>
        </li>
    </ul>

    <div class="tab-content card pt-5" id="myTabContentJust">
        <div class="tab-pane fade show active" id="home-just" role="tabpanel" aria-labelledby="home-tab-just">

            <%@include file="Especificacion.jsp"%>
        </div>
        <div class="tab-pane fade" id="profile-just" role="tabpanel" aria-labelledby="profile-tab-just">
            <%@include file="Automovil.jsp"%>
        </div>


    </div>  
</div>
</div>

<%@include file="layout/footer.jsp"%>





<div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true" id="Especificacion">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Especificaciones de Vehiculos</h5>
            </div>
            <form   method="POST" id="FormularioEspecificaciones" enctype="multipart/form-data">
                <div class="modal-body">
                    <div class="row">
                        <div class="col-md-6">
                            <div id="Cespecificaciones">
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
                                <select class="form-control" name="TxtMarca" data-validetta="required">
                                    <option></option>
                                    <% 
                                        lista = marcas.MostrarRegistros();
                                        for (Marca marca : lista) {

                                    %>
                                    <option value="<%=marca.getRegistro()%>"><%=marca.getMarca()%></option>
                                    <% }%>
                                </select>
                            </div>

                            <label>Modelo</label>
                            <div class="input-group  shadow-sm mb-3">
                                <div class="input-group-prepend">
                                    <div class="input-group-text"><i class="fas fa-car"></i></div>
                                </div>
                                <input type="text" name="TxtModelos" class="form-control" placeholder="Modelo del vehiculo" data-validetta="required">
                            </div>

                            <label>Categoria</label>
                            <div class="input-group  shadow-sm mb-3">
                                <div class="input-group-prepend">
                                    <div class="input-group-text"><i class="fas fa-car"></i></div>
                                </div>
                                <select class="form-control" name="TxtCategoria" data-validetta="required">
                                    <option value=""></option>
                                    <%
                                        ListaCategoria = categorias.MostrarRegistros();
                                        for (Categoria categoria : ListaCategoria) {
                                    %>
                                    <option value="<%= categoria.getRegistro()%>"><%=categoria.getCategoria()%></option>
                                    <%
                                        }
                                    %>
                                </select>
                            </div>

                        </div>

                        <div class="col-md-6 text-center ">
                            <div class="row">
                                <div class=" col-md-12 mt-4 ">
                                    <img id="imagenPrevisualizacion" src="">
                                </div> 
                                <div class="col-md-12 mt-4 mb-4">
                                    <input type="file" id="seleccionArchivos" accept="image/*" name="Imagen"  >
                                </div>
                            </div>
                        </div>
                           <div class="col-md-12">
                               <textarea class="form-control" placeholder="Descripcion del vehiculo" name="TxtDescripcion" id="Descripcion"></textarea>
                            </div>     
                    </div>

                    <div class="modal-footer">
                        <button type="submit"  class="btn btn-success btn-sm" name="btnAgregar" onclick="Agregar()"><i class="fa fa-car" aria-hidden="true"></i> Agregar</button>
                        <button type="submit" class="btn btn-success btn-sm" name="btnEditar"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Editar</button>
                        <button type="submit" class="btn btn-success btn-sm" name="btnEliminar"><i class="fa fa-trash" aria-hidden="true"></i> Eliminar</button>
                        <button type="button" class="btn btn-warning text-white btn-sm" data-dismiss="modal"><i class="fas fa-times"></i> Close</button>
                    </div>
            </form>
        </div>
    </div>
</div>
</div>

<div class="modal fade" id="automovil" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Automovil</h5>
            </div>
            <form  method="POST" id="FormularioAutomovil">
                <div class="modal-body">
                    <label>Codigo Motor</label>
                    <div class="input-group  shadow-sm mb-3">
                        <div class="input-group-prepend">
                            <div class="input-group-text "><i class="fas fa-bookmark"></i></div>
                        </div>
                        <input type="text" name="TxtMotor" class="form-control" placeholder="Motor" data-validetta="required">
                    </div>
                    <label>Modelo</label>
                    <div class="input-group  shadow-sm mb-3">
                        <div class="input-group-prepend">
                            <div class="input-group-text"><i class="fas fa-car"></i></div>
                        </div>
                        <select name="TxtEspecificacion" class="form-control" data-validetta="required">
                            <option></option>
                            <%
                                ListaEspecificaciones = MES.MarcaModelo();
                                for (Especificaciones dato : ListaEspecificaciones) {

                            %>
                            <option value="<%=dato.getRegistro()%>"><%=dato.getModelo()%></option>

                            <%
                                }
                            %>
                        </select>
                    </div>
                    <label>Color</label>
                    <div class="input-group  shadow-sm mb-3">
                        <div class="input-group-prepend">
                            <div class="input-group-text"><i class="fas fa-car"></i></div>
                        </div>
                        <select name="TxtColor" class="form-control" data-validetta="required">
                            <option></option>
                            <%
                                ListaColor = color.MostrarRegistros();
                                for (Color datocolor : ListaColor) {

                            %>
                            <option value="<%=datocolor.getRegistro()%>"><%=datocolor.getColor()%></option>

                            <%
                                }
                            %>
                        </select>
                    </div>

                    <label>Transmision</label>
                    <div class="input-group  shadow-sm mb-3">
                        <div class="input-group-prepend">
                            <div class="input-group-text"><i class="fas fa-car"></i></div>
                        </div>
                        <select name="TxtTransimision" class="form-control" data-validetta="required">
                            <option></option>

                            <option values="MANUAL">MANUAL</option>
                            <option values="AUTOMATICA">AUTOMATICA</option>
                        </select>
                    </div>

                    <label>Version</label>
                    <div class="input-group  shadow-sm mb-3">
                        <div class="input-group-prepend">
                            <div class="input-group-text"><i class="fas fa-car"></i></div>
                        </div>
                        <select name="TxtVersion" class="form-control" data-validetta="required">
                            <option></option>

                            <option value="BASICA">BASICA</option>
                            <option value="DEPORTIVA">DEPORTIVA</option>
                            <option value="EQUIPADA">EQUIPADA</option>

                        </select>
                    </div>

                    <label>Precio</label>
                    <div class="input-group  shadow-sm mb-3">
                        <div class="input-group-prepend">
                            <div class="input-group-text "><i class="fas fa-bookmark"></i></div>
                        </div>
                        <input type="text" name="TxtPrecio" class="form-control" placeholder="Precio del Vehiculo" data-validetta="required">
                    </div>


                </div>
                <div class="modal-footer">
                    <button type="submit"  class="btn btn-success btn-sm" name="btnAgregarAutomovil" onclick="agregarAutomovil()"><i class="fa fa-car" aria-hidden="true"></i> Agregar</button>
                    <button type="submit" class="btn btn-success btn-sm" name="btnEditarAutomovil"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Editar</button>
                    <button type="submit" class="btn btn-success btn-sm" name="btnEliminarAutomovil"><i class="fa fa-trash" aria-hidden="true"></i> Eliminar</button>
                    <button type="button" class="btn btn-warning text-white btn-sm" data-dismiss="modal"><i class="fas fa-times"></i> Close</button>
                </div>
            </form>

        </div>
    </div>
</div>                                 

<script src="resources/js/Especificaciones.js"></script>
<script src="resources/js/Automovil.js"></script>
<!-- Large modal -->


