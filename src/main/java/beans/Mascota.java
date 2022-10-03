package beans;

public class Mascota {
    String nombre;
    String edad;
    String foto;//almacena la ruta de la foto
    String descripcion;
    String tipo_mascota_;
    String sexo;
    String tamanio;
    String color;
    String raza;
    
    public Mascota() {
    }

    public Mascota(String nombre, String edad, String foto, String descripcion, String tipo_mascota_, String sexo, 
            String tamanio, String color, String raza) {
        this.nombre = nombre;
        this.edad = edad;
        this.foto = foto;
        this.descripcion = descripcion;
        this.tipo_mascota_ = tipo_mascota_;
        this.sexo = sexo;
        this.tamanio = tamanio;
        this.color = color;
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo_mascota_() {
        return tipo_mascota_;
    }

    public void setTipo_mascota_(String tipo_mascota_) {
        this.tipo_mascota_ = tipo_mascota_;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public String toString() {
        return "Mascota{" + "nombre=" + nombre + ", edad=" + edad + ", foto=" + foto + ", descripcion=" + descripcion + ", tipo_mascota_=" + tipo_mascota_ + ", sexo=" + sexo + ", tamanio=" + tamanio + ", color=" + color + ", raza=" + raza + '}';
    }

    
}
