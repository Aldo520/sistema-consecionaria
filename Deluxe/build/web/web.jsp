<%-- 
    Document   : web
    Created on : 05-nov-2021, 16:02:15
    Author     : Aldo
--%>



<%@page import="com.modelo.Home"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.modelo.MetodosBlog"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<%@include file="layout/cabecerablog.jsp"%>
        <%!
            MetodosBlog obj = new MetodosBlog();
            ArrayList<Home> lista = new ArrayList<>();

        %>
        
        <!-- Icons Grid-->
        <section class="features-icons bg-light text-center">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4">
                        <div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
                            <div class="features-icons-icon d-flex"><i class="bi-window m-auto text-primary"></i></div>
                            <h3>Financiamiento</h3>
                            <p class="lead mb-0 text-justify">Contamos con planes de finaciamiento para que puedas adquirir uno de nuestros nuevos vehiculos</p>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
                            <div class="features-icons-icon d-flex"><i class="bi-layers m-auto text-primary"></i></div>
                            <h3>Cuotas Flexibles</h3>
                            <p class="lead mb-0 text-justify">Nuestras cuotas se adaptan a tu nivel socioeconomico</p>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="features-icons-item mx-auto mb-0 mb-lg-3">
                            <div class="features-icons-icon d-flex"><i class="bi-terminal m-auto text-primary"></i></div>
                            <h3>Planes de mantenimiento</h3>
                            <p class="lead mb-0 text-justify">Al adquirir una de nuestros vehiculos, automaticamente recibes un plan de mantemiento por 2 años</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Image Showcases-->
        <section class="showcase">
            <div class="container-fluid p-0">
                <%
                    lista = obj.MostrarVehiculos();
                    int contador = 0;

                    for (Home datos : lista) {
                        contador++;
                        if (contador != 2) {

                %>
                <div class="row g-0">
                    <div class="col-xl-6 col-md-12 order-lg-2 text-white showcase-img" style="background-image: url('imagen?id=<%=datos.getEspecificacion() %>')"></div>
                    <div class="col-xl-6 col-md-12 my-auto showcase-text">
                        <div class="row justify-content-center">
                            <div class="col-md-12">
                                <h2><%=datos.getCategoria() %></h2>
                                <p class="lead mb-0 text-justify"><%=datos.getDescripcion() %></p>
                            </div>
                            <div class="col-md-3 text-center">
                                <form method="post" action="Comentarios.jsp" >
                                <button name="especificacion" class="btn btn-block border-dark text-primary mt-3" value="<%=datos.getEspecificacion() %>">Ver mas</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <%
                } else if (contador == 2) {
                %>

                <div class="row g-0">
                 <div class="col-xl-6 col-md-12 text-white showcase-img" style="background-image: url('imagen?id=<%=datos.getEspecificacion() %>')"></div>
                    <div class="col-xl-6 col-md-12 my-auto showcase-text">
                        <div class="row justify-content-center">
                            <div class="col-md-12">
                                <h2><%=datos.getCategoria()%> </h2>
                                <p class="lead mb-0 text-justify"><%=datos.getDescripcion() %></p>
                            </div>
                            <div class="col-md-3 text-center">
                               <form method="post" action="Comentarios.jsp" >
                                <button name="especificacion" class="btn btn-block border-dark text-primary mt-3" value="<%=datos.getEspecificacion() %>">Ver mas</button>
                                </form>
                            </div>
                        </div>
                    </div>
                    

                </div>
                <%
                        }
                    }
                %>

            </div>
        </section>
        <!-- Testimonials-->
        <section class="testimonials text-center bg-light">
            <div class="container">
                <h2 class="mb-5">Empleados destacados del mes</h2>
                <div class="row">
                    <%
                        lista = obj.MostraEmpleados();
                        for (Home dato : lista) {

                    %>
                    <div class="col-lg-4">
                        <div class="testimonial-item mx-auto mb-5 mb-lg-0">
                            <img class="img-fluid rounded-circle mb-3" src="UsuarioImagen?id=<%=dato.getUsuario()%>" alt="..." />
                            <h5><%=dato.getNombreCliente()%>.</h5>
                            <p class="font-weight-light mb-0">"Es un gusto Atenderte"</p>
                        </div>
                    </div>
                    <% }
                    %>

                </div>
            </div>
        </section>
        
        <footer class="footer bg-dark">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 h-100 text-center text-lg-start my-auto">
                        <ul class="list-inline mb-2">
                            <li class="list-inline-item"><a href="#!">About</a></li>
                            <li class="list-inline-item">⋅</li>
                            <li class="list-inline-item"><a href="#!">Contact</a></li>
                            <li class="list-inline-item">⋅</li>
                            <li class="list-inline-item"><a href="#!">Terms of Use</a></li>
                            <li class="list-inline-item">⋅</li>
                            <li class="list-inline-item"><a href="#!">Privacy Policy</a></li>
                        </ul>
                        <p class="text-muted small mb-4 mb-lg-0">&copy; Your Website 2021. All Rights Reserved.</p>
                    </div>
                    <div class="col-lg-6 h-100 text-center text-lg-end my-auto">
                        <ul class="list-inline mb-0">
                            <li class="list-inline-item me-4">
                                <a href="#!"><i class="bi-facebook fs-3"></i></a>
                            </li>
                            <li class="list-inline-item me-4">
                                <a href="#!"><i class="bi-twitter fs-3"></i></a>
                            </li>
                            <li class="list-inline-item">
                                <a href="#!"><i class="bi-instagram fs-3"></i></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </footer>
       
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
       
        <script src="js/scripts.js"></script>
       
        
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    </body>
</html>

