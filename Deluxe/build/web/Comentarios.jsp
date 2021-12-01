




<%@page import="javax.swing.JOptionPane"%>
<%@page import="com.modelo.Comentarios"%>
<%@page import="com.modelo.Automovil"%>

<%@page import="com.modelo.Home"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.modelo.MetodosBlog"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="layout/cabecerablog.jsp"%>

<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

    <%! int id_especificacion = 0;
        MetodosBlog obj = new MetodosBlog();
        ArrayList<Automovil> lista = new ArrayList<>();
        ArrayList<Comentarios> comentario = new ArrayList<>();
    %>

    <%        MetodosBlog obj = new MetodosBlog();

        if (request.getAttribute("especificacion") == null) {
            id_especificacion = Integer.parseInt(request.getParameter("especificacion"));
        } else {

        }


    %>

    <section class="features-icons bg-light text-center">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="mb-lg-12 text-justify">
                        <h3>Descripcion</h3>
                        <p class="text-justify "><%=obj.MostrarVehiculo(id_especificacion).getDescripcion()%></p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Icons Grid-->
    <section class="showcase">
        <div class="container-fluid p-0">
            <div class="row g-0">
                <div class="col-xl-12 col-md-12 my-auto showcase-text">
                    <div class="row justify-content-center ">
                        <div class="col-xl-6 col-md-12  ">
                            <h2 class="mt-5">Especificaciones </h2>
                            <hr class="mb-5">
                            <%
                                lista = obj.MostrarVersion(id_especificacion);
                                for (Automovil datos : lista) {
                            %>
                            <div class="row mb-5">
                                <div class=" col-md-4"><h5><%=datos.getModelo().toLowerCase()%> Version <%=datos.getVersion().toLowerCase()%> </h5></div>



                                <div class=" col-md-4">
                                    <p class="lead mb-0">Transmision<br>
                                        <% lista = obj.MostrarTransmision(datos.getVersion(), id_especificacion);
                                            for (Automovil transmision : lista) {
                                        %>
                                        *<%=transmision.getTransmision().toLowerCase()%><br>
                                        <%
                                            }
                                        %></p></div>


                                <div class="col-md-4"><p class="lead mb-0">Colores Disponibles<br>  
                                        <% lista = obj.MostrarColor(datos.getVersion(), id_especificacion);
                                            for (Automovil color : lista) {
                                        %>
                                        * <%=color.getEstado().toLowerCase()%><br>
                                        <%
                                            }
                                        %>   </p></div>
                            </div>
                            <%
                                }
                            %>
                        </div>
                        <div class="col-xl-6 col-md-12 "><center><img class="shadow" src="imagen?id=<%=id_especificacion%>" width="80%"><h5 class="mt-3">Precio Inicial $<%=obj.MostrarVehiculo(1).getPrecio()%> Dolares</h5></center></div>    
                    </div>
                </div>
            </div>

    </section>
    <section class="showcase">
        <div class="container-fluid p-0">
            <div class="row g-0">
                <div class="col-xl-12 col-md-12 my-auto showcase-text">
                    <h2 class="mt-5">Comentarios </h2>
                    <hr class="mb-5">
                    <%                        comentario = obj.MostrarComentarios(id_especificacion);
                        for (Comentarios dato : comentario) {
                    %>
                    <div class="row g-0 justify-content-center">
                        <div class="text-left col-xl col-md-1 ">
                            <img class="img-responsive rounded-circle" src="UsuarioImagen?id=<%=dato.getId_usuario()%>" width="40px"> 
                        </div>
                        <div class=" text-rigth col-xl-11 col-md-11">
                            <p><%=dato.getNombre_usuario()%></p> 
                        </div>
                        <div class="col-md-10 mb-5">
                            <p class="m-2"><%=dato.getComentario()%></p>
                        </div>
                    </div>
                    <%
                        }
                    %>
                </div>
            </div>
    </section>

    <section class="features-icons bg-light">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="mb-lg-12">
                        <h3>Dejanos tu comentario</h3>
                        <form method="post" action="ComentariosServlet?accion=Guardar"  >
                            <input name="TxtEspecificacion" class="d-none" value="<%=id_especificacion%>">
                            <input name="TxtUsuario" class="d-none" value="<%=sesion.getAttribute("ID_USUARIO")%>">

                            <textArea name="TxtComentario" class="form-control mb-3" rows="5" placeholder="Escribenos lo que piensas acerca de este modelo" ></textArea>
                                <%
                                    String var = String.valueOf(sesion.getAttribute("TIPO_USUARIO"));
                                    if (var.equals("CLIENTE")) {
                                %>                        
                             <button type="submit" class=" btn btn-large bg-success text-white">Comentar</button>
                           <%
                               }
                           %>
                             </form>
                        </div>
                    </div>
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

