public class Soldado extends Jugador {
    private int resistencia;
    private int fuerzaBruta;

    public Soldado(String nombre, String descripcion, int nivel, int resistencia, int fuerzaBruta) {
        super(nombre, descripcion, nivel, 120, 80, 40); 
        this.resistencia = resistencia;
        this.fuerzaBruta = fuerzaBruta;
    }

    // Métodos específicos de Soldado
    public void cargar() {
        System.out.println(getNombre() + " realiza una carga. ¡Aumento temporal de fuerza!");
        int aumentoFuerza = 20; 
        setFuerza(getFuerza() + aumentoFuerza);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Resistencia=" + resistencia + "\n" +
                "Fuerza Bruta=" + fuerzaBruta + "\n";
    }
}
