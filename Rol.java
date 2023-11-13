public abstract  class Rol {
    private String nombre;
    private String descripcion;
    private int nivel;

    public Rol(String nombre, String descripcion, int nivel) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nivel = nivel;
    }

    public abstract void realizarAccion(Personaje objetivo);

    
    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getNivel() {
        return nivel;
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s\nDescripción: %s\nNivel: %d", nombre, descripcion, nivel);
    }
}
