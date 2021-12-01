<%-- 
    Document   : Misventas
    Created on : 31-oct-2021, 19:08:29
    Author     : Aldo
--%>

<%@page import="com.modelo.Mispedidos"%>
<%@page import="com.modelo.Pedidos"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.modelo.MetodosMisPedidos"%>
<%@include file="layout/header.jsp"%>
<%@include file="layout/sidebar.jsp"%>
<%@include file="layout/navbar.jsp"%>
<link href="validetta/validetta.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/estilos.css" rel="stylesheet" type="text/css">

<div class="container-fluid">

    <%   if (sesion.getAttribute("TIPO_USUARIO") == null) {
            response.sendRedirect(request.getContextPath() + "/Login.jsp");
        } else if (sesion.getAttribute("TIPO_USUARIO") != null) {
    %>
    <%!
        MetodosMisPedidos obj = new MetodosMisPedidos();
        ArrayList<Mispedidos> lista = new ArrayList<>();
    %>
    <div class="card shadow mt-3 mb-3 ">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-dark">Mis ventas del dia</h6>
            <%
                int id_emp = 0;
                id_emp = (Integer) session.getAttribute("ID_USUARIO");
            %>
        </div>
        <div class="card-body" >
            <div class="table-responsive">
                <table class="table table-bordered example" width="100%" >
                    <thead class="btn-dark text-white text-center">
                    <th>Registro</th>
                    <th>Venta</th>
                    <th>Modelo</th>
                    <th>Codigo Motor</th>
                    <th>Precio</th>
                    <th>Fecha</th>
                    <th>Cliente</th>
                    <th>Opciones</th>
                    </thead>
                    <tbody class="text-center">
                        <%
                            int codigo = (Integer) sesion.getAttribute("ID_USUARIO");
                            lista = obj.MostrarRegistros(codigo);
                            for (Mispedidos dato : lista) {
                        %>

                        <tr>
                            <td class="detalle"><%=dato.getDetalle()%></td>
                            <td><%=dato.getVenta()%></td>
                            <td><%=dato.getModelo()%></td>
                            <td><%=dato.getMotor()%></td>
                            <td><%=dato.getTotal()%></td>
                            <td><%=dato.getFecha()%></td>
                            <td><%=dato.getNombrecliente()%></td>

                            <td>

                                <button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#ModalUsuario" id="btnEliminar" onclick="mostrar()">
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

    <%
        }
    %>

</div>

</div>
<%@include file="layout/footer.jsp"%>
<script src="resources/js/mispedidos.js"></script> 

