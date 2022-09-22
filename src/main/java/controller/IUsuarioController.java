package controller;

import java.util.Map;

public interface IUsuarioController {

    public String login(String username, String contrasena);

    public String register(String username, String contrasena,
            String primer_nombre, String segundo_nombre, String primer_apellido,String segundo_apellido,
            String email,String telefono);
    
    public String pedir (String username);
}
