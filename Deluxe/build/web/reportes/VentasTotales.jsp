<%-- 
    Document   : VentasTotales.jsp
    Created on : 11-07-2021, 11:37:21 AM
    Author     : Jonathan Alvarado
--%>

<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.io.File"%>
<%@page import="java.io.File"%>
<%@page import="com.conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ventas Totales</title>
    </head>
    <body>
         <%
             Conexion con = new Conexion();
             try{
                 con.Conectar();
                 File file = new File(application.getRealPath("reportes/VentasTotales.jasper"));
                 byte[] bytes = JasperRunManager.runReportToPdf(file.getPath(), null, con.getConexion());
                 ServletOutputStream report = response.getOutputStream();
                 response.setContentType("application/pdf");
                 response.setContentLength(bytes.length);
                 report.write(bytes, 0, bytes.length);
                 report.flush();
                 report.close();
             }catch (Exception e){
                 System.out.println("Error al generar reporte: " + e.getMessage());
             }
        %>
</html>