import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jugador extends Personaje {
    private List<Arma> inventarioArmas;

    public Jugador(String nombre, String descripcion, int nivel, int vidaPredeterminada, int fuerzaPredeterminada, int defensaPredeterminada) {
        super(nombre, descripcion, nivel, vidaPredeterminada, fuerzaPredeterminada, defensaPredeterminada);
        inventarioArmas = new ArrayList<>();
    }

    // Método para buscar armas
    public void buscarArmas() {
        System.out.println("Buscando armas...");

        // Lógica específica de búsqueda de armas
        Random random = new Random();
        int probabilidadEncontrarArma = random.nextInt(100);

        if (probabilidadEncontrarArma < 50) {
            // El jugador encuentra un arma
            Arma nuevaArma = generarArmaAleatoria();
            agregarArma(nuevaArma);
            System.out.println("¡Has encontrado un arma: " + nuevaArma.getClass().getSimpleName() + "!");
        } else {
            System.out.println("No encontraste ninguna arma esta vez.");
        }
    }
    
    public boolean tieneArmas() {
    return !inventarioArmas.isEmpty();
    }
    // Método para descansar y aumentar la vida
    public void descansar() {
        System.out.println("Descansando...");
        // Aumentar la vida (puedes ajustar la cantidad)
        setVida(getVida() + 20);
        System.out.println("¡Vida aumentada!");
    }

    // Método para explorar el entorno
    public void explorarEntorno() {
        System.out.println("Explorando el entorno...");
    }

    // Método para agregar un arma al inventario
    public void agregarArma(Arma arma) {
        inventarioArmas.add(arma);
    }

    private Arma generarArmaAleatoria() {
        Random random = new Random();
        int tipoArma = random.nextInt(3); // Se generan números aleatorios entre 0 y 2

        switch (tipoArma) {
            case 0:
                return new Rifle();
            case 1:
                return new Pistola();
            case 2:
                return new Escopeta();
            default:
                throw new IllegalStateException("Unexpected value: " + tipoArma);
        }
    }

    public void realizarAccion(Personaje objetivo) {
        System.out.println("Realizando acción genérica contra " + objetivo.getNombre());
        if (objetivo instanceof Enemigo) {
            atacarEnemigo((Enemigo) objetivo);
        } else {
            System.out.println("Error: El objetivo no es de tipo Enemigo.");
        }
    }

    public void atacarEnemigo(Enemigo enemigo) {
        int danio = calcularDanio();
        enemigo.recibirDanio(danio);
    }

    protected int calcularDanio() {
        // Lógica para calcular el daño del personaje
        return getFuerza() * getNivel();
    }
    
    @Override
    public String toString() {
        StringBuilder estadisticas = new StringBuilder("Hola soy " + getNombre() + ", un " + getClass().getSimpleName() + " y tengo los siguientes atributos\n");
        estadisticas.append("Vida=").append(getVida()).append("\n");
        estadisticas.append("Fuerza=").append(getFuerza()).append("\n");
        estadisticas.append("Defensa=").append(getDefensa()).append("\n");

        // Agregar información del inventario de armas
        estadisticas.append("Inventario de Armas:\n");
        for (Arma arma : inventarioArmas) {
            estadisticas.append("- ").append(arma.getClass().getSimpleName()).append("\n");
        }

        return estadisticas.toString();
    }
}
