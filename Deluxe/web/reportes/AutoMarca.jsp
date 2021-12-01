<%-- 
    Document   : AutoMarca
    Created on : 11-04-2021, 09:28:29 AM
    Author     : Jonathan Alvarado
--%>

<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.util.Map"%>
<%@page import="java.io.File"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Automovil </title>
    </head>
    <body>
       <%
                if (request.getParameter("ReporteAutoMarca") != null) {
                        int codigo = Integer.parseInt(request.getParameter("SelectMarca"));
                        Conexion con = new Conexion();
             try{
                 con.Conectar();
                 Map parametro = new HashMap();
                 parametro.put("marca", codigo);
                 File file = new File(application.getRealPath("reportes/AutoMarca.jasper"));
                 byte[] bytes = JasperRunManager.runReportToPdf(file.getPath(), parametro, con.getConexion());
                 ServletOutputStream report = response.getOutputStream();
                 response.setContentType("application/pdf");
                 response.setContentLength(bytes.length);
                 report.write(bytes, 0, bytes.length);
                 report.flush();
                 report.close();
             }catch (Exception e){
                 System.out.println("Error al generar reporte: " + e.getMessage());
             }
                    }
          %>   
    </body>
</html>
