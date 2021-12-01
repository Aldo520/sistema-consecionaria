<%-- 
    Document   : navbar
    Created on : 02-oct-2021, 15:19:46
    Author     : Aldo
--%>
<%@page import="com.modelo.MetodosUsuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.modelo.Usuario"%>
<%@page session="true" %>
<%
    HttpSession sesion = request.getSession();
%>
<div id="content" class="bg-white">

    <!-- Topbar -->
    <nav class="navbar navbar-expand navbar bg-white topbar mb-4 static-top shadow">

        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
            <i class="fa fa-bars"></i>
        </button>
        <!-- Topbar Search -->
        <label><strong> Deluxe Motor Sport</strong> </label>

        <!-- Topbar Navbar -->
        <ul class="navbar-nav ml-auto">


            <div class="topbar-divider d-none d-sm-block"></div>

            <!-- Nav Item - User Information -->
            <li class="nav-item dropdown no-arrow">
                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <span class="mr-2 d-none d-lg-inline text-gray-600 small"><%=session.getAttribute("NOMBRE_USUARIO") %></span>
                    <img class="img-profile rounded-circle"
                         src="UsuarioImagen?id=<%=session.getAttribute("ID_USUARIO") %>" width="100%">
                </a>
                <!-- Dropdown - User Information -->
                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                     aria-labelledby="userDropdown">
                    <a class="dropdown-item" href="#">
                        <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                        Perfil
                    </a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/LoginServlet?accion=cerrar">
                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                        Cerrar Sesion
                    </a>
                </div>
            </li>

        </ul>
    </nav>








