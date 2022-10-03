package controller;

public interface IMascotaController {
    public String agregar(String nombre,String edad,String foto,String descripcion,String tipo_mascota_,String sexo,
            String tamanio, String color, String raza);
    //public String agregar(Mascota mascota);
    public String listar();
}
