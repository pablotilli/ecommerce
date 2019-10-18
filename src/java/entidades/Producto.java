package entidades;

public class Producto {
    private int _id;
    private String _nombre;
    //private Temporada _temporada;
    private Categoria _categoria;
    private float _precio;

    public Categoria getCategoria() {
        return _categoria;
    }

    public void setCategoria(Categoria _categoria) {
        this._categoria = _categoria;
    }
    private String _imagen;

    public String getImagen() {
        return _imagen;
    }

    public void setImagen(String _imagen) {
        this._imagen = _imagen;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public float getPrecio() {
        return _precio;
    }

    public void setPrecio(float _precio) {
        this._precio = _precio;
    }
    
    
}
