package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.modelo.MetodosMarca;
import java.util.ArrayList;
import com.modelo.Marca;
import java.util.ArrayList;
import com.modelo.Categoria;
import com.modelo.MetodosCategoria;

public final class Control_005fInventario_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


        ArrayList<Marca> listaM = new ArrayList<>();
        MetodosMarca obj = new MetodosMarca();

    

        ArrayList<Categoria> listaC = new ArrayList<>();
        MetodosCategoria MC = new MetodosCategoria();

    
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(6);
    _jspx_dependants.add("/layout/header.jsp");
    _jspx_dependants.add("/layout/sidebar.jsp");
    _jspx_dependants.add("/layout/navbar.jsp");
    _jspx_dependants.add("/Marca.jsp");
    _jspx_dependants.add("/Categoria.jsp");
    _jspx_dependants.add("/layout/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("  <meta name=\"description\" content=\"\">\n");
      out.write("  <meta name=\"author\" content=\"\">\n");
      out.write("  <!-- Custom fonts for this template-->\n");
      out.write("  \n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css\" integrity=\"sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l\" crossorigin=\"anonymous\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.1.7/sweetalert2.min.css\" integrity=\"sha512-cyIcYOviYhF0bHIhzXWJQ/7xnaBuIIOecYoPZBgJHQKFPo+TOBA+BY1EnTpmM8yKDU4ZdI3UGccNGCEUdfbBqw==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/startbootstrap-sb-admin-2/4.1.4/css/sb-admin-2.min.css\" integrity=\"sha512-Mk4n0eeNdGiUHlWvZRybiowkcu+Fo2t4XwsJyyDghASMeFGH6yUXcdDI3CKq12an5J8fq4EFzRVRdbjerO3RmQ==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/datatables.net-bs4/1.11.3/dataTables.bootstrap4.min.css\" integrity=\"sha512-+RecGjm1x5bWxA/jwm9sqcn5EV0tNej3Xxq5HtIOLM9YM9VgI2LbhEDn099Xhxg6HuvrmsXR0J6JQxL7tLHFHw==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.1.1/css/all.min.css\">\n");
      out.write("<link rel=\"validetta/validetta.min.css\">\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Quicksand&display=swap\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body id=\"page-top\">\n");
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("   <div id=\"wrapper\">\n");
      out.write("\n");
      out.write("        <!-- Sidebar -->\n");
      out.write("        <ul class=\"navbar-nav  sidebar sidebar-dark accordion\" id=\"accordionSidebar\" style=\"background:#0672A9\">\n");
      out.write("\n");
      out.write("            <!-- Sidebar - Brand -->\n");
      out.write("            <a class=\"sidebar-brand d-flex align-items-center justify-content-rigth\" href=\"index.html\">\n");
      out.write("                <div class=\"mt-5 \"> <img src=\"Imagenes/delux.png\" width=\"100%\"></div>\n");
      out.write("            </a>\n");
      out.write("\n");
      out.write("            <!-- Divider -->\n");
      out.write("          \n");
      out.write("\n");
      out.write("            <!-- Nav Item - Dashboard -->\n");
      out.write("            <li class=\"nav-item mt-3\">\n");
      out.write("                <a class=\"nav-link\" href=\"index.html\">\n");
      out.write("                   <i class=\"fas fa-home\"></i>\n");
      out.write("                    <span>Home</span></a>\n");
      out.write("            </li>\n");
      out.write("\n");
      out.write("            <!-- Divider -->\n");
      out.write("            <hr class=\"sidebar-divider\">\n");
      out.write("\n");
      out.write("            <!-- Heading -->\n");
      out.write("            <div class=\"sidebar-heading\">\n");
      out.write("                Datos personales\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- Nav Item - Pages Collapse Menu -->\n");
      out.write("            <li class=\"nav-item\">\n");
      out.write("                <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#collapseTwo\"\n");
      out.write("                    aria-expanded=\"true\" aria-controls=\"collapseTwo\">\n");
      out.write("                    <i class=\"fas fa-users\"></i>\n");
      out.write("                    <span>Personal</span>\n");
      out.write("                </a>\n");
      out.write("                <div id=\"collapseTwo\" class=\"collapse\" aria-labelledby=\"headingTwo\" data-parent=\"#accordionSidebar\">\n");
      out.write("                    <div class=\"bg-white py-2 collapse-inner rounded\">\n");
      out.write("                        <h6 class=\"collapse-header\">Datos personales:</h6>\n");
      out.write("                        <a class=\"collapse-item\" href=\"buttons.html\">Usuarios</a>\n");
      out.write("                        <a class=\"collapse-item\" href=\"cards.html\">Empleados</a>\n");
      out.write("                        <a class=\"collapse-item\" href=\"cards.html\">Clientes</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </li>\n");
      out.write("\n");
      out.write("            <!-- Nav Item - Utilities Collapse Menu -->\n");
      out.write("            <li class=\"nav-item\">\n");
      out.write("                <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#collapseUtilities\"\n");
      out.write("                    aria-expanded=\"true\" aria-controls=\"collapseUtilities\">\n");
      out.write("                    <i class=\"fas fa-dolly-flatbed\"></i>\n");
      out.write("                    <span>Inventario</span>\n");
      out.write("                </a>\n");
      out.write("                <div id=\"collapseUtilities\" class=\"collapse\" aria-labelledby=\"headingUtilities\"\n");
      out.write("                    data-parent=\"#accordionSidebar\">\n");
      out.write("                    <div class=\"bg-white py-2 collapse-inner rounded\">\n");
      out.write("                        <h6 class=\"collapse-header\">Custom Utilities:</h6>\n");
      out.write("                        <a class=\"collapse-item\" href=\"utilities-color.html\">Datos generales</a>\n");
      out.write("                       \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </li>\n");
      out.write("\n");
      out.write("            <!-- Divider -->\n");
      out.write("            <hr class=\"sidebar-divider\">\n");
      out.write("\n");
      out.write("            <!-- Heading -->\n");
      out.write("            <div class=\"sidebar-heading\">\n");
      out.write("                Addons\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- Nav Item - Pages Collapse Menu -->\n");
      out.write("            <li class=\"nav-item\">\n");
      out.write("                <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#collapsePages\"\n");
      out.write("                    aria-expanded=\"true\" aria-controls=\"collapsePages\">\n");
      out.write("                   <i class=\"fas fa-cart-arrow-down\"></i>\n");
      out.write("                    <span>Ventas</span>\n");
      out.write("                </a>\n");
      out.write("                <div id=\"collapsePages\" class=\"collapse\" aria-labelledby=\"headingPages\" data-parent=\"#accordionSidebar\">\n");
      out.write("                    <div class=\"bg-white py-2 collapse-inner rounded\">\n");
      out.write("                        <h6 class=\"collapse-header\">Pedidos</h6>\n");
      out.write("                        <a class=\"collapse-item\" href=\"login.html\">Registro de pedidos</a>\n");
      out.write("                        <a class=\"collapse-item\" href=\"register.html\">Ventas Realizadas</a>\n");
      out.write("                </div>\n");
      out.write("            </li>\n");
      out.write("\n");
      out.write("            <li class=\"nav-item\">\n");
      out.write("                <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#collapseReportes\"\n");
      out.write("                    aria-expanded=\"true\" aria-controls=\"collapseReportes\">\n");
      out.write("                    <i class=\"fas fa-fw fa-folder\"></i>\n");
      out.write("                    <span>Reportes</span>\n");
      out.write("                </a>\n");
      out.write("                <div id=\"collapseReportes\" class=\"collapse\" aria-labelledby=\"headingPages\" data-parent=\"#accordionSidebar\">\n");
      out.write("                    <div class=\"bg-white py-2 collapse-inner rounded\">\n");
      out.write("                        <h6 class=\"collapse-header\">Pedidos</h6>\n");
      out.write("                        <a class=\"collapse-item\" href=\"login.html\">Registro de pedidos</a>\n");
      out.write("                        <a class=\"collapse-item\" href=\"register.html\">Ventas Realizadas</a>\n");
      out.write("                </div>\n");
      out.write("            </li>\n");
      out.write("            \n");
      out.write("\n");
      out.write("            <!-- Divider -->\n");
      out.write("            <hr class=\"sidebar-divider d-none d-md-block\">\n");
      out.write("\n");
      out.write("            <!-- Sidebar Toggler (Sidebar) -->\n");
      out.write("            <div class=\"text-center d-none d-md-inline\">\n");
      out.write("                <button class=\"rounded-circle border-0\" id=\"sidebarToggle\"></button>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </ul>\n");
      out.write("        <!-- End of Sidebar -->\n");
      out.write("\n");
      out.write("        <!-- Content Wrapper -->\n");
      out.write("        <div id=\"content-wrapper\" class=\"d-flex flex-column\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div id=\"content\" class=\"bg-white\">\n");
      out.write("\n");
      out.write("                <!-- Topbar -->\n");
      out.write("                <nav class=\"navbar navbar-expand navbar bg-white topbar mb-4 static-top shadow\">\n");
      out.write("\n");
      out.write("                    <button id=\"sidebarToggleTop\" class=\"btn btn-link d-md-none rounded-circle mr-3\">\n");
      out.write("                        <i class=\"fa fa-bars\"></i>\n");
      out.write("                    </button>\n");
      out.write("\n");
      out.write("                    <!-- Topbar Search -->\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <!-- Topbar Navbar -->\n");
      out.write("                    <ul class=\"navbar-nav ml-auto\">\n");
      out.write("\n");
      out.write("                      \n");
      out.write("                        <div class=\"topbar-divider d-none d-sm-block\"></div>\n");
      out.write("\n");
      out.write("                        <!-- Nav Item - User Information -->\n");
      out.write("                        <li class=\"nav-item dropdown no-arrow\">\n");
      out.write("                            <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"userDropdown\" role=\"button\"\n");
      out.write("                                data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                                <span class=\"mr-2 d-none d-lg-inline text-gray-600 small\">Douglas McGee</span>\n");
      out.write("                                <img class=\"img-profile rounded-circle\"\n");
      out.write("                                    src=\"img/undraw_profile.svg\">\n");
      out.write("                            </a>\n");
      out.write("                            <!-- Dropdown - User Information -->\n");
      out.write("                            <div class=\"dropdown-menu dropdown-menu-right shadow animated--grow-in\"\n");
      out.write("                                aria-labelledby=\"userDropdown\">\n");
      out.write("                                <a class=\"dropdown-item\" href=\"#\">\n");
      out.write("                                    <i class=\"fas fa-user fa-sm fa-fw mr-2 text-gray-400\"></i>\n");
      out.write("                                    Profile\n");
      out.write("                                </a>\n");
      out.write("                                <a class=\"dropdown-item\" href=\"#\">\n");
      out.write("                                    <i class=\"fas fa-cogs fa-sm fa-fw mr-2 text-gray-400\"></i>\n");
      out.write("                                    Settings\n");
      out.write("                                </a>\n");
      out.write("                                <a class=\"dropdown-item\" href=\"#\">\n");
      out.write("                                    <i class=\"fas fa-list fa-sm fa-fw mr-2 text-gray-400\"></i>\n");
      out.write("                                    Activity Log\n");
      out.write("                                </a>\n");
      out.write("                                <div class=\"dropdown-divider\"></div>\n");
      out.write("                                <a class=\"dropdown-item\" href=\"#\" data-toggle=\"modal\" data-target=\"#logoutModal\">\n");
      out.write("                                    <i class=\"fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400\"></i>\n");
      out.write("                                    Logout\n");
      out.write("                                </a>\n");
      out.write("                            </div>\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("                </nav>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                \n");
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("<link href=\"resources/css/estilos.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("<div class=\"container-fluid\">\n");
      out.write("\n");
      out.write("\n");
      out.write("    <ul class=\"nav nav-tabs nav-justified md-tabs indigo\" id=\"myTabJust\" role=\"tablist\">\n");
      out.write("        <li class=\"nav-item\">\n");
      out.write("            <a class=\"nav-link active\" id=\"home-tab-just\" data-toggle=\"tab\" href=\"#home-just\" role=\"tab\" aria-controls=\"home-just\"\n");
      out.write("               aria-selected=\"true\">Marcas</a>\n");
      out.write("        </li>\n");
      out.write("        <li class=\"nav-item\">\n");
      out.write("            <a class=\"nav-link\" id=\"profile-tab-just\" data-toggle=\"tab\" href=\"#profile-just\" role=\"tab\" aria-controls=\"profile-just\"\n");
      out.write("               aria-selected=\"false\">Categorias</a>\n");
      out.write("        </li>\n");
      out.write("    </ul>\n");
      out.write("\n");
      out.write("    <div class=\"tab-content card pt-5\" id=\"myTabContentJust\">\n");
      out.write("        <div class=\"tab-pane fade show active\" id=\"home-just\" role=\"tabpanel\" aria-labelledby=\"home-tab-just\">\n");
      out.write("            \n");
      out.write("                        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("  <meta name=\"description\" content=\"\">\n");
      out.write("  <meta name=\"author\" content=\"\">\n");
      out.write("  <!-- Custom fonts for this template-->\n");
      out.write("  \n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css\" integrity=\"sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l\" crossorigin=\"anonymous\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.1.7/sweetalert2.min.css\" integrity=\"sha512-cyIcYOviYhF0bHIhzXWJQ/7xnaBuIIOecYoPZBgJHQKFPo+TOBA+BY1EnTpmM8yKDU4ZdI3UGccNGCEUdfbBqw==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/startbootstrap-sb-admin-2/4.1.4/css/sb-admin-2.min.css\" integrity=\"sha512-Mk4n0eeNdGiUHlWvZRybiowkcu+Fo2t4XwsJyyDghASMeFGH6yUXcdDI3CKq12an5J8fq4EFzRVRdbjerO3RmQ==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/datatables.net-bs4/1.11.3/dataTables.bootstrap4.min.css\" integrity=\"sha512-+RecGjm1x5bWxA/jwm9sqcn5EV0tNej3Xxq5HtIOLM9YM9VgI2LbhEDn099Xhxg6HuvrmsXR0J6JQxL7tLHFHw==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.1.1/css/all.min.css\">\n");
      out.write("<link rel=\"validetta/validetta.min.css\">\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Quicksand&display=swap\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body id=\"page-top\">\n");
      out.write("\n");
      out.write("<link href=\"resources/css/estilos.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<div class=\"container-fluid\">\n");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <div class=\"row\">\n");
      out.write("        <div class=\"col-md-9\">\n");
      out.write("            <h1 class=\"text-danger mr-2\"> Marcas <i class=\"fas fa-car\" style=\"color: #0672A9;\"></i></h1>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-md-3\">\n");
      out.write("            <button type=\"button\" class=\"btn btn-block btn-agregar \"   data-toggle=\"modal\" data-target=\"#marca\" id=\"btnNuevo\" onclick=\"ocultarB()\">\n");
      out.write("                <i class=\"fa fa-user-plus\" aria-hidden=\"true\"></i> Agregar\n");
      out.write("            </button>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"card shadow mt-3 mb-3 \">\n");
      out.write("        <div class=\"card-header py-3\">\n");
      out.write("            <h6 class=\"m-0 font-weight-bold text-dark\">Registros de Marcas</h6>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"card-body\" >\n");
      out.write("            <div class=\"table-responsive\">\n");
      out.write("                <table class=\"table table-bordered example\" width=\"100%\" cellspacing=\"0\">\n");
      out.write("                    <thead class=\"btn-dark text-white text-center\">\n");
      out.write("                    <th>Registro</th>\n");
      out.write("                    <th>Marca</th>\n");
      out.write("                    <th>Opcion</th>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody class=\"text-center\">\n");
      out.write("                        ");

                            listaM = obj.MostrarRegistros();
                            for (Marca marca : listaM) {
                        
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td class=\"registro\">");
      out.print(marca.getRegistro());
      out.write("</td>\n");
      out.write("                            <td class=\"marca\">");
      out.print(marca.getMarca());
      out.write("</td>\n");
      out.write("                            <td>\n");
      out.write("                                <button type=\"button\" class=\"btn btn-success \" data-toggle=\"modal\" data-target=\"#marca\" id=\"btnEditar\" onclick=\"mostrar()\">\n");
      out.write("                                    <i class=\"fa fa-pencil-square-o\" aria-hidden=\"true\"></i>\n");
      out.write("                                </button>\n");
      out.write("                                <button type=\"button\" class=\"btn btn-danger \" data-toggle=\"modal\" data-target=\"#marca\" id=\"btnEliminar\" onclick=\"mostrar()\">\n");
      out.write("                                    <i class=\"fa fa-trash\" aria-hidden=\"true\"></i>\n");
      out.write("                                </button>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");

                            }
                        
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div class=\"tab-pane fade\" id=\"profile-just\" role=\"tabpanel\" aria-labelledby=\"profile-tab-just\">\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("  <meta name=\"description\" content=\"\">\n");
      out.write("  <meta name=\"author\" content=\"\">\n");
      out.write("  <!-- Custom fonts for this template-->\n");
      out.write("  \n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css\" integrity=\"sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l\" crossorigin=\"anonymous\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.1.7/sweetalert2.min.css\" integrity=\"sha512-cyIcYOviYhF0bHIhzXWJQ/7xnaBuIIOecYoPZBgJHQKFPo+TOBA+BY1EnTpmM8yKDU4ZdI3UGccNGCEUdfbBqw==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/startbootstrap-sb-admin-2/4.1.4/css/sb-admin-2.min.css\" integrity=\"sha512-Mk4n0eeNdGiUHlWvZRybiowkcu+Fo2t4XwsJyyDghASMeFGH6yUXcdDI3CKq12an5J8fq4EFzRVRdbjerO3RmQ==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/datatables.net-bs4/1.11.3/dataTables.bootstrap4.min.css\" integrity=\"sha512-+RecGjm1x5bWxA/jwm9sqcn5EV0tNej3Xxq5HtIOLM9YM9VgI2LbhEDn099Xhxg6HuvrmsXR0J6JQxL7tLHFHw==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.1.1/css/all.min.css\">\n");
      out.write("<link rel=\"validetta/validetta.min.css\">\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Quicksand&display=swap\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body id=\"page-top\">\n");
      out.write("\n");
      out.write("<link href=\"resources/css/estilos.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<div class=\"container-fluid\">\n");
      out.write("    ");
      out.write("\n");
      out.write("    <div class=\"row\">\n");
      out.write("        <div class=\"col-md-9\">\n");
      out.write("            <h1 class=\"text-danger mr-2\"> Categorias <i class=\"fas fa-car\" style=\"color: #0672A9;\"></i></h1>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-md-3\">\n");
      out.write("            <button type=\"button\" class=\"btn btn-block btn-agregar \"   data-toggle=\"modal\" data-target=\"#categoria\" id=\"btnNuevo\" onclick=\"ocultarC()\">\n");
      out.write("                <i class=\"fa fa-user-plus\" aria-hidden=\"true\"></i> Agregar\n");
      out.write("            </button>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"card shadow mt-3 mb-3 \">\n");
      out.write("        <div class=\"card-header py-3\">\n");
      out.write("            <h6 class=\"m-0 font-weight-bold text-dark\">Registros de Categoria</h6>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"card-body\" >\n");
      out.write("            <div class=\"table-responsive\">\n");
      out.write("                <table class=\"table table-bordered example\" width=\"100%\" cellspacing=\"0\">\n");
      out.write("                    <thead class=\"btn-dark text-white text-center\">\n");
      out.write("                    <th>Registro</th>\n");
      out.write("                    <th>Categoria</th>\n");
      out.write("                    <th>Opcion</th>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody class=\"text-center\">\n");
      out.write("                        ");

                            listaC = MC.MostrarRegistros();
                            for (Categoria categoria : listaC) {
                        
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td class=\"registro\" >");
      out.print(categoria.getRegistro());
      out.write("</td>\n");
      out.write("                            <td class=\"categorias\">");
      out.print(categoria.getCategoria());
      out.write("</td>\n");
      out.write("                            <td>\n");
      out.write("                                <button type=\"button\" class=\"btn btn-success \" data-toggle=\"modal\" data-target=\"#categoria\" id=\"btnEditarC\" onclick=\"mostrarC()\">\n");
      out.write("                                    <i class=\"fa fa-pencil-square-o\" aria-hidden=\"true\"></i>\n");
      out.write("                                </button>\n");
      out.write("                                <button type=\"button\" class=\"btn btn-danger \" data-toggle=\"modal\" data-target=\"#categoria\" id=\"btnEliminarC\" onclick=\"mostrarC()\">\n");
      out.write("                                    <i class=\"fa fa-trash\" aria-hidden=\"true\"></i>\n");
      out.write("                                </button>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");
 }
                        
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>");
      out.write("\n");
      out.write("        </div>\n");
      out.write("  \n");
      out.write("</div>  \n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- /.container-fluid -->\n");
      out.write("\n");
      out.write("<!-- Sticky Footer -->\n");
      out.write(" <footer class=\"sticky-footer \">\n");
      out.write("                <div class=\"container my-auto\">\n");
      out.write("                    <div class=\"copyright text-center my-auto\">\n");
      out.write("                        <span>Copyright &copy; Your Website 2020</span>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </footer>\n");
      out.write("            <!-- End of Footer -->\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <!-- End of Content Wrapper -->\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.6.0.js\" integrity=\"sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=\"  crossorigin=\"anonymous\"></script>\n");
      out.write("\n");
      out.write("<script src=\"https://use.fontawesome.com/24378325b5.js\"> </script>\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns\" crossorigin=\"anonymous\"></script>\n");
      out.write("\n");
      out.write("<script src=\"validetta/validetta.min.js\"></script>\n");
      out.write("<script src=\"validetta/validettaLang-es-ES.js\"></script>\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.1.7/sweetalert2.min.js\" integrity=\"sha512-7YvQulGlfsi8ex5zsjMHDqwEj7jNLCcVD9sXbgwp1wScakmCR+Pj66HjDJoaZ7/yZ/f9pIvX293Ac6S3HE47nA==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\"></script>\n");
      out.write("\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js\" integrity=\"sha512-0QbL0ph8Tc8g5bLhfVzSqxe9GERORsKhIn1IrpxDAgUsbBGz/V7iSav2zzW325XGd1OMLdL4UiqRJj702IeqnQ==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\"></script>\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/startbootstrap-sb-admin-2/4.1.4/js/sb-admin-2.min.js\" integrity=\"sha512-+QnjQxxaOpoJ+AAeNgvVatHiUWEDbvHja9l46BHhmzvP0blLTXC4LsvwDVeNhGgqqGQYBQLFhdKFyjzPX6HGmw==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\"></script>\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.21/js/jquery.dataTables.min.js\" integrity=\"sha512-BkpSL20WETFylMrcirBahHfSnY++H2O1W+UnEEO4yNIl+jI2+zowyoGJpbtk6bx97fBXf++WJHSSK2MV4ghPcg==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\"></script>\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/datatables.net-bs4/1.11.3/dataTables.bootstrap4.min.js\" integrity=\"sha512-9o2JT4zBJghTU0EEIgPvzzHOulNvo0jq2spTfo6mMmZ6S3jK+gljrfo0mKDAxoMnrkZa6ml2ZgByBQ5ga8noDQ==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\"></script>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("$(document).ready(function() {\n");
      out.write("    $('.example').DataTable( {\n");
      out.write("        autoFill: true\n");
      out.write("    } );\n");
      out.write("} );  \n");
      out.write("       \n");
      out.write("</script>\n");
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- Large modal -->\n");
      out.write("\n");
      out.write("\n");
      out.write(" <div class=\"modal fade\" id=\"Color\" tabindex=\"-1\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("        <div class=\"modal-dialog\">\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <h5 class=\"modal-title\">Colores</h5>\n");
      out.write("                </div>\n");
      out.write("                <form  method=\"POST\" id=\"FormularioColor\">\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        <div id=\"Ccolores\">\n");
      out.write("                            <label>Codigo</label>\n");
      out.write("                            <div class=\"input-group  shadow-sm mb-3\">\n");
      out.write("                                <div class=\"input-group-prepend\">\n");
      out.write("                                    <div class=\"input-group-text \"><i class=\"fas fa-bookmark\"></i></div>\n");
      out.write("                                </div>\n");
      out.write("                                <input type=\"text\" name=\"TxtRegistro\" class=\"form-control\" placeholder=\"Registro\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <label>Categoria</label>\n");
      out.write("                        <div class=\"input-group  shadow-sm mb-3\">\n");
      out.write("                            <div class=\"input-group-prepend\">\n");
      out.write("                                <div class=\"input-group-text\"><i class=\"fas fa-car\"></i></div>\n");
      out.write("                            </div>\n");
      out.write("                            <input type=\"text\" name=\"TxtColor\" class=\"form-control\" placeholder=\"Nombre de la Color\" data-validetta=\"required\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button type=\"submit\"  class=\"btn btn-success\" name=\"btnAgregarColores\" onclick=\"agregarColor()\">Agregar</button>\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-success\" name=\"btnEditarColores\">Editar</button>\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-success\" name=\"btnEliminarColores\">Eliminar</button>\n");
      out.write("                        <button type=\"button\" class=\"btn btn-warning text-white\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}