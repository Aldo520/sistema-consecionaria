<%-- 
    Document   : Login
    Created on : 01-nov-2021, 18:37:48
    Author     : Aldo
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="layout/header.jsp"%>
<title>| LOGIN | </title>
<!DOCTYPE html>
<%@include file="layout/header.jsp"%>
<link href="validetta/validetta.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/estilos.css" rel="stylesheet" type="text/css">
</head>
<div class="portada">
    <body class="fondo-login">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-xl-10 col-lg-12 col-md-9">
                    <div class="card o-hidden border-0 my-5 box-login">
                        <div class="card-body">
                            <!-- Nested Row within Card Body -->
                            <div class="row">
                                <div class="col-lg-6 d-none d-lg-block mt-5">
                                    <img src="Imagenes/delux2.png"class="img-fluid m-auto" ></img>
                                </div>
                                <div class="col-lg-6">
                                    <div class="p-5">
                                        <div class="text-center">
                                            <h1 class="h1 mb-4 bienvenida">Bienvenido!</h1>
                                        </div>
                                        <form class="user" action="LoginServlet" method="POST">
                                            <div class="form-group">
                                                <input type="text" class="form-control form-control-user text-center"placeholder="correo@gmail.com" name="txtUser" >
                                            </div>
                                            <div class="form-group">
                                                <input type="password" class="form-control form-control-user text-center" placeholder="*********" name="txtPass"  >
                                            </div>
                                            <div class="form-group">
                                                <div class="custom-control custom-checkbox small">
                                                    <input type="checkbox" class="custom-control-input" id="customCheck">
                                                    <label class="custom-control-label" for="customCheck">Remember
                                                        Me</label>
                                                </div>
                                            </div>
                                            <button type="submit" class="btn btn-facebook btn-user btn-block" name="btnLoginDeluxe"><i class="fas fa-sign-in-alt"></i> Inicar Sesión</button>
                                            <hr>
                                            <a href="" class="btn btn-google btn-user btn-block">
                                                <i class="fab fa-google fa-fw"></i> Login with Google
                                            </a>
                                            <a href="" class="btn btn-facebook btn-user btn-block">
                                                <i class="fab fa-facebook-f fa-fw"></i> Login with Facebook
                                            </a>
                                        </form>
                                        <hr>
                                        <div class="text-center">
                                            <a class="small" href="forgot-password.html">Forgot Password?</a>
                                        </div>
                                        <div class="text-center">
                                            <a class="small" href="">Create an Account!</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <div class="foot">
        <%@include file="layout/footer.jsp"%>
    </div>
</div>   
</html>

<%
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
   if(request.getAttribute("accion")!=null){
        sesion.invalidate();
    }
%>