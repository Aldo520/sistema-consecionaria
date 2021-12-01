<%-- 
    Document   : Cliente
    Created on : 10-22-2021, 10:57:53 PM
    Author     : Jonathan Alvarado
--%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="com.modelo.MetodosCliente"%>
<%@page import="com.modelo.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Cliente> listaCliente = new ArrayList<>();
    MetodosCliente mCli = new MetodosCliente();
%>
<%
    HttpSession sesionR = request.getSession();
%>
<%
   if (sesionR.getAttribute("TIPO_USUARIO")!=null) {     
%>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-9">
            <h1 class="text-danger mr-2"> Clientes <i class="fas fa-users" style="color: #0672A9;"></i></h1>
        </div>
        <div class="col-md-3">
            <button type="button" class="btn btn-block btn-agregar btn-sm"   data-toggle="modal" data-target="#ModalCliente" onclick="ocultarOpcion()">
                <i class="fa fa-user-plus" aria-hidden="true"></i> Nuevo Cliente
            </button>
        </div>
    </div>
    <div class="card shadow mt-3 mb-3 ">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-dark">Registros de Clientes</h6>
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
                    <th>Categoría</th>
                    <th>Opciones</th>
                    </thead>
                    <tbody class="text-center">
                        <%
                            listaCliente = mCli.MostrarCliente();
                            for (Cliente datos : listaCliente) {
                        %>
                        <tr>
                            <td class="id"><%=datos.getID()%></td>
                            <td class="nombre"><%=datos.getNombres()%></td>
                            <td class="apellido"><%=datos.getApellidos()%></td>
                            <td class="telefono"><%=datos.getTelefono()%></td>
                            <td class="direccion"><%=datos.getDireccion()%></td>
                            <td class="documento"><%=datos.getDocumento()%></td>
                            <td class="sexo"><%=datos.getSexo()%></td>
                            <td class="ds"><%=datos.getNombre_usuario()%></td>
                            <td class="categoria"><%=datos.getCat_cliente() %></td>
                            <td>
                                <button type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#ModalCliente" id="btnEditar">
                                    <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                </button>
                                <button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#ModalCliente" id="btnEliminar">
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
