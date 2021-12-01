<%-- 
    Document   : sidebar
    Created on : 02-oct-2021, 16:00:30
    Author     : Aldo
    --%>
   <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav  sidebar sidebar-dark accordion" id="accordionSidebar" style="background:#0672A9">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-rigth" href="${pageContext.request.contextPath}/Inicio.jsp">
                <div class="mt-5 "> <img src="${pageContext.request.contextPath}/Imagenes/delux.png" width="80%"></div>
            </a>

            <!-- Divider -->
          

            <!-- Nav Item - Dashboard -->
            <li class="nav-item mt-3">
                <a class="nav-link" href="${pageContext.request.contextPath}/Inicio.jsp">
                   <i class="fas fa-home"></i>
                    <span>Home</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                REGISTROS
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                    aria-expanded="true" aria-controls="collapseTwo">
                    <i class="fas fa-users"></i>
                    <span>Personal</span>
                </a>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Datos personales:</h6>
                        <a class="collapse-item" href="${pageContext.request.contextPath}/Usuario.jsp">Usuarios</a>
                        <a class="collapse-item" href="${pageContext.request.contextPath}/Empleado.jsp">Empleados</a>
                        <a class="collapse-item" href="${pageContext.request.contextPath}/Usuarios_Clientes.jsp">Clientes</a>
                    </div>
                </div>
            </li>

            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-dolly-flatbed"></i>
                    <span>Inventario</span>
                </a>
                <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Custom Utilities:</h6>
                        <a class="collapse-item" href="${pageContext.request.contextPath}/DatosGenerales.jsp">Datos generales</a>
                       <a class="collapse-item" href="${pageContext.request.contextPath}/Inventario.jsp">Especificaciones</a>
                    </div>
                </div>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Addons
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages"
                    aria-expanded="true" aria-controls="collapsePages">
                   <i class="fas fa-cart-arrow-down"></i>
                    <span>Ventas</span>
                </a>
                <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Pedidos</h6>
                        <a class="collapse-item" href="${pageContext.request.contextPath}/Prueba.jsp">Registro de pedidos</a>
                        <a class="collapse-item" href="${pageContext.request.contextPath}/Misventas.jsp">Ventas Realizadas</a>
                </div>
            </li>

             <li class="nav-item mt-3">
                <a class="nav-link" href="${pageContext.request.contextPath}/Reportes.jsp">
                   <i class="fas fa-file-pdf"></i>
                    <span>Reportes</span></a>
            </li>

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">







