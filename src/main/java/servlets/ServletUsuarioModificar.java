package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.UsuarioController;

@WebServlet("/ServletUsuarioModificar")
public class ServletUsuarioModificar extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ServletUsuarioModificar() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UsuarioController usuario = new UsuarioController();
        
        String primer_nombre = request.getParameter("primer_nombre");
        String segundo_nombre = request.getParameter("segundo_nombre");
        String primer_apellido = request.getParameter("primer_apellido");
        String segundo_apellido = request.getParameter("segundo_apellido");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("correo");
        String username = request.getParameter("username");
        String contrasena = request.getParameter("contrasena");
                   
        String usuarioStr = usuario.modificar( username,  contrasena,primer_nombre,  segundo_nombre,  
                primer_apellido, segundo_apellido,email, telefono);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(usuarioStr);
        out.flush();
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

}
