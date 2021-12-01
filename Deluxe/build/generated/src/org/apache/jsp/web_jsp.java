package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.modelo.Home;
import java.util.ArrayList;
import com.modelo.MetodosBlog;

public final class web_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


            MetodosBlog obj = new MetodosBlog();
            ArrayList<Home> lista = new ArrayList<>();

        
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/layout/cabecerablog.jsp");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\" />\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\" />\n");
      out.write("        <meta name=\"description\" content=\"\" />\n");
      out.write("        <meta name=\"author\" content=\"\" />\n");
      out.write("        <title>Landing Page - Start Bootstrap Theme</title>\n");
      out.write("        <!-- Favicon-->\n");
      out.write("        <link rel=\"icon\" type=\"image/x-icon\" href=\"assets/favicon.ico\" />\n");
      out.write("        <!-- Bootstrap icons-->\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <!-- Google fonts-->\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <!-- Core theme CSS (includes Bootstrap)-->\n");
      out.write("        <link href=\"resources/css/styles.css\" rel=\"stylesheet\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("       ");

    HttpSession sesion = request.getSession();

      out.write("\n");
      out.write("        <!-- Navigation-->\n");
      out.write("        <nav class=\"navbar navbar-light bg-light static-top\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <a class=\"navbar-brand\" href=\"#!\"> <img src=\"Imagenes/logo_1.png\" width=\"20%\"> Deluxe Motor Sport</a>\n");
      out.write("                <a class=\"btn btn-primary btn-small\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Login.jsp\">Iniciar Sesion</a>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        <!-- Masthead-->\n");
      out.write("        <header class=\"masthead\">\n");
      out.write("            <div class=\"container position-relative\">\n");
      out.write("                <div class=\"row justify-content-center\">\n");
      out.write("                    <div class=\"col-xl-12\">\n");
      out.write("                        <div class=\"text-left text-white mt-5\">\n");
      out.write("                            <form class=\"form-subscribe\" id=\"contactForm\" data-sb-form-api-token=\"API_TOKEN\">\n");
      out.write("                                <!-- Email address input-->\n");
      out.write("                                <div class=\"row mb-5\">\n");
      out.write("                                    <h3 class=\"text-rigth\">NISSAN FRONTIER 2022</h3> \n");
      out.write("                                    <h5 class=\"text-rigth\">Adentrate en la aventura</h5> \n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"d-none\" id=\"submitSuccessMessage\">\n");
      out.write("                                    <div class=\"text-center mb-3\">\n");
      out.write("                                        <div class=\"fw-bolder\">Form submission successful!</div>\n");
      out.write("                                        <p>To activate this form, sign up at</p>\n");
      out.write("                                        <a class=\"text-white\" href=\"https://startbootstrap.com/solution/contact-forms\">https://startbootstrap.com/solution/contact-forms</a>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"d-none\" id=\"submitErrorMessage\"><div class=\"text-center text-danger mb-3\">Error sending message!</div></div>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        \n");
      out.write("        <!-- Icons Grid-->\n");
      out.write("        <section class=\"features-icons bg-light text-center\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-4\">\n");
      out.write("                        <div class=\"features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3\">\n");
      out.write("                            <div class=\"features-icons-icon d-flex\"><i class=\"bi-window m-auto text-primary\"></i></div>\n");
      out.write("                            <h3>Financiamiento</h3>\n");
      out.write("                            <p class=\"lead mb-0 text-justify\">Contamos con planes de finaciamiento para que puedas adquirir uno de nuestros nuevos vehiculos</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-4\">\n");
      out.write("                        <div class=\"features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3\">\n");
      out.write("                            <div class=\"features-icons-icon d-flex\"><i class=\"bi-layers m-auto text-primary\"></i></div>\n");
      out.write("                            <h3>Cuotas Flexibles</h3>\n");
      out.write("                            <p class=\"lead mb-0 text-justify\">Nuestras cuotas se adaptan a tu nivel socioeconomico</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-4\">\n");
      out.write("                        <div class=\"features-icons-item mx-auto mb-0 mb-lg-3\">\n");
      out.write("                            <div class=\"features-icons-icon d-flex\"><i class=\"bi-terminal m-auto text-primary\"></i></div>\n");
      out.write("                            <h3>Planes de mantenimiento</h3>\n");
      out.write("                            <p class=\"lead mb-0 text-justify\">Al adquirir una de nuestros vehiculos, automaticamente recibes un plan de mantemiento por 2 años</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("        <!-- Image Showcases-->\n");
      out.write("        <section class=\"showcase\">\n");
      out.write("            <div class=\"container-fluid p-0\">\n");
      out.write("                ");

                    lista = obj.MostrarVehiculos();
                    int contador = 0;

                    for (Home datos : lista) {
                        contador++;
                        if (contador != 2) {

                
      out.write("\n");
      out.write("                <div class=\"row g-0\">\n");
      out.write("                    <div class=\"col-xl-6 col-md-12 order-lg-2 text-white showcase-img\" style=\"background-image: url('imagen?id=");
      out.print(datos.getEspecificacion() );
      out.write("')\"></div>\n");
      out.write("                    <div class=\"col-xl-6 col-md-12 my-auto showcase-text\">\n");
      out.write("                        <div class=\"row justify-content-center\">\n");
      out.write("                            <div class=\"col-md-12\">\n");
      out.write("                                <h2>");
      out.print(datos.getCategoria() );
      out.write("</h2>\n");
      out.write("                                <p class=\"lead mb-0 text-justify\">");
      out.print(datos.getDescripcion() );
      out.write("</p>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-3 text-center\">\n");
      out.write("                                <form method=\"post\" action=\"Comentarios.jsp\" >\n");
      out.write("                                <button name=\"especificacion\" class=\"btn btn-block border-dark text-primary mt-3\" value=\"");
      out.print(datos.getEspecificacion() );
      out.write("\">Ver mas</button>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                ");

                } else if (contador == 2) {
                
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"row g-0\">\n");
      out.write("                 <div class=\"col-xl-6 col-md-12 text-white showcase-img\" style=\"background-image: url('imagen?id=");
      out.print(datos.getEspecificacion() );
      out.write("')\"></div>\n");
      out.write("                    <div class=\"col-xl-6 col-md-12 my-auto showcase-text\">\n");
      out.write("                        <div class=\"row justify-content-center\">\n");
      out.write("                            <div class=\"col-md-12\">\n");
      out.write("                                <h2>");
      out.print(datos.getCategoria());
      out.write(" </h2>\n");
      out.write("                                <p class=\"lead mb-0 text-justify\">");
      out.print(datos.getDescripcion() );
      out.write("</p>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-3 text-center\">\n");
      out.write("                               <form method=\"post\" action=\"Comentarios.jsp\" >\n");
      out.write("                                <button name=\"especificacion\" class=\"btn btn-block border-dark text-primary mt-3\" value=\"");
      out.print(datos.getEspecificacion() );
      out.write("\">Ver mas</button>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                ");

                        }
                    }
                
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("        <!-- Testimonials-->\n");
      out.write("        <section class=\"testimonials text-center bg-light\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <h2 class=\"mb-5\">Empleados destacados del mes</h2>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    ");

                        lista = obj.MostraEmpleados();
                        for (Home dato : lista) {

                    
      out.write("\n");
      out.write("                    <div class=\"col-lg-4\">\n");
      out.write("                        <div class=\"testimonial-item mx-auto mb-5 mb-lg-0\">\n");
      out.write("                            <img class=\"img-fluid rounded-circle mb-3\" src=\"UsuarioImagen?id=");
      out.print(dato.getUsuario());
      out.write("\" alt=\"...\" />\n");
      out.write("                            <h5>");
      out.print(dato.getNombreCliente());
      out.write(".</h5>\n");
      out.write("                            <p class=\"font-weight-light mb-0\">\"Es un gusto Atenderte\"</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    ");
 }
                    
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("        \n");
      out.write("        <footer class=\"footer bg-dark\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-6 h-100 text-center text-lg-start my-auto\">\n");
      out.write("                        <ul class=\"list-inline mb-2\">\n");
      out.write("                            <li class=\"list-inline-item\"><a href=\"#!\">About</a></li>\n");
      out.write("                            <li class=\"list-inline-item\">⋅</li>\n");
      out.write("                            <li class=\"list-inline-item\"><a href=\"#!\">Contact</a></li>\n");
      out.write("                            <li class=\"list-inline-item\">⋅</li>\n");
      out.write("                            <li class=\"list-inline-item\"><a href=\"#!\">Terms of Use</a></li>\n");
      out.write("                            <li class=\"list-inline-item\">⋅</li>\n");
      out.write("                            <li class=\"list-inline-item\"><a href=\"#!\">Privacy Policy</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                        <p class=\"text-muted small mb-4 mb-lg-0\">&copy; Your Website 2021. All Rights Reserved.</p>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-6 h-100 text-center text-lg-end my-auto\">\n");
      out.write("                        <ul class=\"list-inline mb-0\">\n");
      out.write("                            <li class=\"list-inline-item me-4\">\n");
      out.write("                                <a href=\"#!\"><i class=\"bi-facebook fs-3\"></i></a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"list-inline-item me-4\">\n");
      out.write("                                <a href=\"#!\"><i class=\"bi-twitter fs-3\"></i></a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"list-inline-item\">\n");
      out.write("                                <a href=\"#!\"><i class=\"bi-instagram fs-3\"></i></a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </footer>\n");
      out.write("       \n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("       \n");
      out.write("        <script src=\"js/scripts.js\"></script>\n");
      out.write("       \n");
      out.write("        \n");
      out.write("        <script src=\"https://cdn.startbootstrap.com/sb-forms-latest.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
