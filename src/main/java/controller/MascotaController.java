package controller;

import beans.Mascota;
import beans.Usuario;
import com.google.gson.Gson;
import connection.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MascotaController implements IMascotaController{

    @Override
    public String agregar(String nombre,String edad,String foto,String descripcion,String tipo_mascota_,String sexo,
            String tamanio,String color, String raza) {
    //public String agregar(Mascota mascota){
        
        Gson gson = new Gson();//El gson sirve para sincronisar el back con el front
        DBConnection con = new DBConnection();

        String sql = "INSERT INTO mascota (nombre, edad, foto, descripcion, tipo_mascota_, sexo, tamanio, color, raza) \n"
                + "VALUES (?,?,?,?,?,?,?,?,?);";
        
        try {
            Statement st = con.getConnection().createStatement();     
            st.executeUpdate(sql);
              
            //Mascota masc = new Mascota();
            Mascota masc = new Mascota(nombre, edad, foto, descripcion, tipo_mascota_, sexo, tamanio, color, raza);
            
            st.close();
            return gson.toJson(masc);
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }finally {
            con.desconectar();
        }
        return "false";
    }

    @Override
    public String listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
    

