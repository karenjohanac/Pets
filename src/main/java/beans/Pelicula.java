
package beans;

public class Pelicula {
    private int id;
    private String titulo;
    private String genero;
    private String autor;
    private int copias;
    private boolean novedad;

     
    
/** Metodo constructor para poder ainicializar los atributos **/
    public Pelicula(int id, String titulo, String genero, String autor, int copias, boolean novedad) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.autor = autor;
        this.copias = copias;
        this.novedad = novedad;
    }


    
 /** Metodo getter and setter para acceder a la información privada **/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCopias() {
        return copias;
    }

    public void setCopias(int copias) {
        this.copias = copias;
    }

    public boolean isNovedad() {
        return novedad;
    }

    public void setNovedad(boolean novedad) {
        this.novedad = novedad;
    }

     
       
/** Override permite enviar la información a otro lugar - base de datos, archivo plano **/    
    @Override
    public String toString() {
        return "Peliculas{" + "id=" + id + ", titulo=" + titulo + ", genero=" + genero + ", autor=" + autor + ", copias=" + copias + ", novedad=" + novedad + '}';
    }
            

}
