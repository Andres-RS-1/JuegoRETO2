import java.util.Random;

public class Asesino extends Jugador {
    private int sigilo;
    private int velocidad;

    public Asesino(String nombre, String descripcion, int nivel, int sigilo, int velocidad) {
        super(nombre, descripcion, nivel, 100, 60, 20);
        this.sigilo = sigilo;
        this.velocidad = velocidad;
    }

    // Métodos específicos de Asesino
    public void ataqueSigiloso() {
        System.out.println(getNombre() + " realiza un ataque sigiloso. ¡Daño aumentado!");
        int danio = calcularDanio() * 2; // Daño duplicado
    }

    @Override
    protected int calcularDanio() {
        return super.calcularDanio() * 2;
    }
    
    @Override
    public String toString() {
        return super.toString() +
                "Sigilo=" + sigilo + "\n" +
                "Velocidad=" + velocidad + "\n";
    }
}
