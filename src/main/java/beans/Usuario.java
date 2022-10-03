
package beans;

public class Usuario {
    private String username;
    private String contrasena;
    private String primer_nombre;
    private String segundo_nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private String email;
    private String telefono;

    
    public Usuario(String username, String contrasena, String primer_nombre, String segundo_nombre, 
            String primer_apellido, String segundo_apellido,String email, String telefono) {
        this.username = username;
        this.contrasena = contrasena;
        this.primer_nombre = primer_nombre;
        this.segundo_nombre = segundo_nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.email = email;
        this.telefono = telefono;

    }
     public Usuario(String username, String primer_nombre, String segundo_nombre, 
            String primer_apellido, String segundo_apellido,String email, String telefono) {
        this.username = username;
        this.primer_nombre = primer_nombre;
        this.segundo_nombre = segundo_nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.email = email;
        this.telefono = telefono;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    public String getSegundo_nombre() {
        return segundo_nombre;
    }

    public void setSegundo_nombre(String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Usuario{" + "username=" + username + ", contrasena=" + contrasena + ", primer_nombre=" + primer_nombre +
                ", segundo_nombre=" + segundo_nombre + ", primer_apellido=" + primer_apellido + ", segundo_apellido=" + 
                segundo_apellido + ", email=" + email + ", telefono=" + telefono + '}';
    }
       
}