/** Acciones que se van a realizar dentro del aplicativo web **/
package test;

import beans.Usuario;
import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;


public class OperacionesBD {
    
    public static void main(String[] args) {
        listarUsuaio("admin");

    }

    public static void actualizarPelicula(int id, String genero) {
        DBConnection con = new DBConnection();

        String sql = "UPDATE pelicula SET genero = ' " + genero + " ' WHERE id = " + id;
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            /**
             * Quiere decir que cuando desconecte termine el proceso *
             */
            con.desconectar();
        }
    }
    
    
    /**
     * Lista la informacion del usuario
     * @param username 
     */
       public static void listarUsuaio(String username) {
        DBConnection con = new DBConnection();//para conectarnos a la base de datos
        String sql = "SELECT U.primer_nombre,U.segundo_nombre,U.primer_apellido,U.segundo_apellido,U.email,U.telefono,"
                + "U.username FROM usuario U WHERE U.username = '" + username + "'";

        //String sql = "SELECT * FROM usuario WHERE username = '" + username + "'";
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);//Ejecuta la sentencia sql
            
            while (rs.next()) {//next es un metodo que va a recorrer usuario por usuario *
                //String contrasena = rs.getString("contrasena");
                String primer_nombre = rs.getString("primer_nombre");
                String segundo_nombre = rs.getString("segundo_nombre");
                String primer_apellido = rs.getString("primer_apellido");
                String segundo_apellido = rs.getString("segundo_apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");

                Usuario usuario = new Usuario(username, primer_nombre, segundo_nombre, primer_apellido, 
                        segundo_apellido, email, telefono);
                System.out.println(usuario.toString());
            }
            st.executeQuery(sql);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
    }

}
