
package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import beans.Usuario;
import connection.DBConnection;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

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
            
                Usuario usuario = new Usuario(username, contrasena, primer_nombre, segundo_nombre, 
                        primer_apellido, segundo_apellido, email, telefono);
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
    
    //Metodo para traer los usuarios (pedir)
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

                Usuario usuario = new Usuario(username, contrasena, primer_nombre, segundo_nombre, primer_apellido, 
                        segundo_apellido, email, telefono);

                return gson.toJson(usuario);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }
    
    
    /**
     * metodo para listar la informacion de un usuario
     * @param String username
     * @return json(usuario)
     */
    @Override
    public String listar(String userna) {
        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "SELECT U.primer_nombre,U.segundo_nombre,U.primer_apellido,U.segundo_apellido,U.email,U.telefono,"
                + "U.username FROM usuario U WHERE U.username = '" + userna + "'";
        
        //List<String> usuarios = new ArrayList<String>();

        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                while (rs.next()) {
                    //String contrasena = rs.getString("contrasena");
                    String username = rs.getString("username");
                    String primer_nombre = rs.getString("primer_nombre");
                    String segundo_nombre = rs.getString("segundo_nombre");
                    String primer_apellido = rs.getString("primer_apellido");
                    String segundo_apellido = rs.getString("segundo_apellido");
                    String email = rs.getString("email");
                    String telefono = rs.getString("telefono");

                    Usuario usuario = new Usuario(username, primer_nombre, segundo_nombre, primer_apellido, 
                        segundo_apellido, email, telefono);
                    //usuarios.add(gson.toJson(usuario));
                    return gson.toJson(usuario);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        //return gson.toJson(usuarios);
        return "false";
    }

    @Override
    public String modificar(String username, String N_contrasena, String N_primer_nombre, String N_segundo_nombre, 
            String N_primer_apellido, String N_segundo_apellido, String N_email, String N_telefono) { 

        DBConnection con = new DBConnection();

        String sql = "Update usuario set contrasena = '" + N_contrasena
                + "', primer_nombre = '" + N_primer_nombre + "', "
                + "', segundo_nombre = '" + N_segundo_nombre + "', "
                + "', primer_apellido = '" + N_primer_apellido + "', "
                + "', segundo_apellido = '" + N_segundo_apellido + "', "
                + "', email = '" + N_email + "', "
                + "', telefono = '" + N_telefono + "', ";

        sql += " where username = '" + username + "'";

        try {

            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }
    
     @Override
    public String eliminar(String username) {

        DBConnection con = new DBConnection();

        String sql = "Delete from usuario where username = '" + username + "'";
    
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }
}

