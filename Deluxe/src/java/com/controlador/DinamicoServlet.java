

import com.conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.modelo.Automovil;
import com.modelo.Especificaciones;
import com.modelo.MetodosEspecificaciones;
import com.modelo.MetodosPedido;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;


/**
 * Servlet implementation class AjaxController
 */
@WebServlet("/AjaxController")
public class DinamicoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
    }
    private Gson gson = new Gson();

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        
       String Codigo=request.getParameter("Codigo");
       MetodosPedido obj = new MetodosPedido();
       
       List<Automovil>datos = obj.MostrarRegistros(Codigo);
        
       
       String employeeJsonString = this.gson.toJson(datos); 
        PrintWriter out=response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(employeeJsonString);
       
       
        
        
        
       
        
    }

}