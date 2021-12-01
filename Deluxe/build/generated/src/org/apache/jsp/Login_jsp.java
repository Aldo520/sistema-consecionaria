package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.swing.JOptionPane;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/layout/header.jsp");
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
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
      out.write("<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Quicksand&display=swap\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body id=\"page-top\">\n");
      out.write("\n");
      out.write("<title>| LOGIN | </title>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
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
      out.write("<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Quicksand&display=swap\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body id=\"page-top\">\n");
      out.write("\n");
      out.write("<link href=\"validetta/validetta.min.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("<link href=\"resources/css/estilos.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("</head>\n");
      out.write("<div class=\"portada\">\n");
      out.write("    <body class=\"fondo-login\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row justify-content-center\">\n");
      out.write("                <div class=\"col-xl-10 col-lg-12 col-md-9\">\n");
      out.write("                    <div class=\"card o-hidden border-0 my-5 box-login\">\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <!-- Nested Row within Card Body -->\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-lg-6 d-none d-lg-block mt-5\">\n");
      out.write("                                    <img src=\"Imagenes/delux2.png\"class=\"img-fluid m-auto\" ></img>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-lg-6\">\n");
      out.write("                                    <div class=\"p-5\">\n");
      out.write("                                        <div class=\"text-center\">\n");
      out.write("                                            <h1 class=\"h1 mb-4 bienvenida\">Bienvenido!</h1>\n");
      out.write("                                        </div>\n");
      out.write("                                        <form class=\"user\" action=\"LoginServlet\" method=\"POST\">\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <input type=\"text\" class=\"form-control form-control-user text-center\"placeholder=\"correo@gmail.com\" name=\"txtUser\" >\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <input type=\"password\" class=\"form-control form-control-user text-center\" placeholder=\"*********\" name=\"txtPass\"  >\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <div class=\"custom-control custom-checkbox small\">\n");
      out.write("                                                    <input type=\"checkbox\" class=\"custom-control-input\" id=\"customCheck\">\n");
      out.write("                                                    <label class=\"custom-control-label\" for=\"customCheck\">Remember\n");
      out.write("                                                        Me</label>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            <button type=\"submit\" class=\"btn btn-facebook btn-user btn-block\" name=\"btnLoginDeluxe\"><i class=\"fas fa-sign-in-alt\"></i> Inicar Sesión</button>\n");
      out.write("                                            <hr>\n");
      out.write("                                            <a href=\"\" class=\"btn btn-google btn-user btn-block\">\n");
      out.write("                                                <i class=\"fab fa-google fa-fw\"></i> Login with Google\n");
      out.write("                                            </a>\n");
      out.write("                                            <a href=\"\" class=\"btn btn-facebook btn-user btn-block\">\n");
      out.write("                                                <i class=\"fab fa-facebook-f fa-fw\"></i> Login with Facebook\n");
      out.write("                                            </a>\n");
      out.write("                                        </form>\n");
      out.write("                                        <hr>\n");
      out.write("                                        <div class=\"text-center\">\n");
      out.write("                                            <a class=\"small\" href=\"forgot-password.html\">Forgot Password?</a>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"text-center\">\n");
      out.write("                                            <a class=\"small\" href=\"\">Create an Account!</a>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("    <div class=\"foot\">\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- /.container-fluid -->\n");
      out.write("\n");
      out.write("<!-- Sticky Footer -->\n");
      out.write(" <footer class=\"sticky-footer \">\n");
      out.write("                <div class=\"container my-auto\">\n");
      out.write("                    <div class=\"copyright text-center my-auto\">\n");
      out.write("                        <span>Deluxe Motor Sports C.A DE CV+</span>\n");
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
      out.write("    </div>\n");
      out.write("</div>   \n");
      out.write("</html>\n");
      out.write("\n");

    HttpSession sesion = request.getSession();
     
    if (request.getAttribute("TIPO_USUARIO")!=null) {
        String tipoUser =String.valueOf(request.getAttribute("TIPO_USUARIO"));
        int idUser = (Integer) request.getAttribute("ID_USUARIO");
        if (tipoUser.equals("EMPLEADO") || tipoUser.equals("ADMINISTRADOR")) {
            sesion.setAttribute("NOMBRE_USUARIO", request.getAttribute("NOMBRE_USUARIO"));
            sesion.setAttribute("TIPO_USUARIO", tipoUser);
            sesion.setAttribute("ID_USUARIO", idUser);
            response.sendRedirect("Inicio.jsp");

        } else if (tipoUser.equals("CLIENTE")) {
            sesion.setAttribute("ID_USUARIO", idUser);
            sesion.setAttribute("TIPO_USUARIO", tipoUser);
            response.sendRedirect("web.jsp");
        }
    }
   if(request.getAttribute("respuesta")!=null){
        sesion.invalidate();
    }

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
