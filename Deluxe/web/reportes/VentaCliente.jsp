<%-- 
    Document   : VentaCliente
    Created on : 11-04-2021, 07:35:18 PM
    Author     : Jonathan Alvarado
--%>


<%@page import="java.util.Map"%>
<%@page import="java.io.File"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Ventas por Cliente </title>
    </head>
    <body>
       <%
                if (request.getParameter("ReporteVentaCliente") != null) {
                        int codigo = Integer.parseInt(request.getParameter("SelectCliente"));
                        Conexion con = new Conexion();
             try{
                 con.Conectar();
                 Map parametro = new HashMap();
                 parametro.put("cliente", codigo);
                 File file = new File(application.getRealPath("reportes/VentaCliente.jasper"));
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
