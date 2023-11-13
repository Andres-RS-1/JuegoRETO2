public class Personaje {
    private String nombre;
    private int vida;
    private int fuerza;
    private int defensa;
    private int nivel;
    private String descripcion;

    public Personaje(String nombre, String descripcion, int nivel, int vida, int fuerza, int defensa) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nivel = nivel;
        this.vida = vida;
        this.fuerza = fuerza;
        this.defensa = defensa;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getFuerza() {
        return fuerza;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getNivel() {
        return nivel;
    }

    public void setVida(int cantidad) {
        vida += cantidad;
        if (vida < 0) {
            vida = 0;
        }
    }

    public void setFuerza(int nuevaFuerza) {
        this.fuerza = nuevaFuerza;
    }

    public void atacar(Personaje objetivo) {
        System.out.println(getNombre() + " ataca a " + objetivo.getNombre());
        int danio = calcularDanio();
        objetivo.recibirDanio(danio);
    }

    public void recibirDanio(int cantidad) {
        setVida(-cantidad);
        System.out.println(getNombre() + " ha recibido " + cantidad + " puntos de daño.");
    }

    protected int calcularDanio() {
        // Lógica para calcular el daño del personaje
        return getFuerza() * getNivel();
    }

    public void explorarEntorno() {
        System.out.println(getNombre() + " está explorando el entorno.");
    }

    public void buscarArmas() {
        System.out.println(getNombre() + " está buscando armas.");
    }

    public void descansar() {
        System.out.println(getNombre() + " está descansando.");
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s\nDescripción: %s\nVida: %d\nFuerza: %d\nDefensa: %d\nNivel: %d",
                             nombre, descripcion, vida, fuerza, defensa, nivel);
    }
}
