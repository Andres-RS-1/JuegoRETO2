import java.util.Random;

public class Enemigo extends Personaje {
    private int puntosAtaque;
    private boolean estaRecargando;

    public Enemigo(String nombre, int nivel) {
        // Llama al constructor de la superclase con la descripción vacía
        super(nombre, "", nivel, 50 + nivel * 10, 30 + nivel * 5, 5 + nivel);

        this.puntosAtaque = 10 + nivel; // Puntos de ataque aumentan con el nivel
        this.estaRecargando = false;
    }

    // Método específico de Enemigo para atacar al jugador
    public void atacarJugador(Jugador jugador) {
        if (!estaRecargando) {
            System.out.println(getNombre() + " ataca a " + jugador.getNombre());
            int danio = puntosAtaque; 
            jugador.setVida(-danio);
            System.out.println(jugador.getNombre() + " ha perdido " + danio + " puntos de vida.");
        } else {
            System.out.println(getNombre() + " está recargando. ¡Aprovecha para atacar!");
        }
    }

    // Método específico de Enemigo para recibir daño
    public void recibirDanio(int cantidad) {
        setVida(-cantidad/3);
        System.out.println(getNombre() + " ha recibido " + cantidad + " puntos de daño.");

        // Probabilidad de recargar después de recibir daño
        Random random = new Random();
        if (random.nextDouble() < 0.3) { // 30% de probabilidad de recargar
            recargar();
        }
    }

    private void recargar() {
        System.out.println(getNombre() + " está recargando munición.");
        estaRecargando = true;

        // Simulación de tiempo de recarga
        try {
            Thread.sleep(2000); //Recarga que toma 2 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(getNombre() + " ha recargado munición.");
        estaRecargando = false;
    }
}
