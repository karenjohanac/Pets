
package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import beans.Usuario;
import connection.DBConnection;
import com.google.gson.Gson;

public class UsuarioController implements IUsuarioController{
    
    @Override
    public String login(String username, String contrasena){
        Gson gson = new Gson();                  //El gson sirve para sincronisar el back con el front
        DBConnection con = new DBConnection();

        String sql = "SELECT * FROM usuario WHERE username = '" + username
                + "'  and contrasena = '" + contrasena + "'";

        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                
                String primer_nombre = rs.getString("primer_nombre");
                String segundo_nombre = rs.getString("segundo_nombre");
                String primer_apellido = rs.getString("primer_apellido");
                String segundo_apellido = rs.getString("segundo_apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
            
                Usuario usuario = new Usuario(username, contrasena, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, email, telefono);
                return gson.toJson(usuario);

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }finally {
            con.desconectar();
        }
        return "false";
    }

    @Override
    public String register(String username, String contrasena, String primer_nombre, String segundo_nombre,
            String primer_apellido, String segundo_apellido, String email, String telefono) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Insert into usuario values('" +username+ "','" + contrasena + "','" + primer_nombre
                + "','" +segundo_nombre+ "','" +primer_apellido+ "','" +segundo_apellido+ "','" +email 
                + "','" +telefono+"')";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            Usuario usuario = new Usuario(username, contrasena, primer_nombre, segundo_nombre, 
                    primer_apellido, segundo_apellido, email, telefono);

            st.close();

            return gson.toJson(usuario);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            con.desconectar();
        }

        return "false";

    }
    
    //Metodo para traer las peliculas (pedir)
    @Override
    public String pedir(String username) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Select * from usuario where username = '" + username + "'";

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String contrasena = rs.getString("contrasena");
                String primer_nombre = rs.getString("primer_nombre");
                String segundo_nombre = rs.getString("segundo_nombre");
                String primer_apellido = rs.getString("primer_apellido");
                String segundo_apellido = rs.getString("segundo_apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
            
                Usuario usuario = new Usuario(username, contrasena, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, email, telefono);
                return gson.toJson(usuario);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return "false";
    }

}

