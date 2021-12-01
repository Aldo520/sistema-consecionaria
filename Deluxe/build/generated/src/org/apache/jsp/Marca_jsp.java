package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.modelo.MetodosMarca;
import java.util.ArrayList;
import com.modelo.Marca;

public final class Marca_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


        ArrayList<Marca> listaM = new ArrayList<>();
        MetodosMarca obj = new MetodosMarca();

    
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/layout/header.jsp");
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
