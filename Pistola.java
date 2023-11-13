import java.util.Random;

class Pistola implements Arma {
    private int precisionBase;
    private int capacidadCargador;
    private int municion;
    private boolean automatica;

    // Nuevos atributos para accesorios
    private boolean silenciador;

    @Override
    public void definirAtributosDeArma() {
        // Lógica para definir atributos específicos de la Pistola
        precisionBase = 80; 
        capacidadCargador = 12; 
        municion = capacidadCargador; 
        automatica = false; 

        // Atributos de accesorios
        silenciador = false;
    }

    @Override
    public void disparar(Personaje objetivo) {
        // Lógica de disparo específica de la Pistola
        System.out.println("¡Bang! Pistola disparando a " + objetivo.getNombre());

        Random random = new Random();
        int probabilidadAcertar = random.nextInt(100) + 1;

        if (municion > 0) {
            if (automatica) {
                for (int i = 0; i < 3; i++) { // Disparar ráfaga de tres balas en modo automático
                    realizarDisparo(probabilidadAcertar, objetivo);
                    municion--;
                }
            } else {
                realizarDisparo(probabilidadAcertar, objetivo);
                municion--;
            }
        } else {
            System.out.println("¡Recarga necesaria! Cargador vacío.");
        }
    }

    public void recargar() {
        // Lógica para recargar la pistola
        System.out.println("Recargando la pistola...");
        municion = capacidadCargador;
        System.out.println("¡Pistola recargada con " + capacidadCargador + " balas!");
    }

    public void cambiarModoDisparo() {
        // Cambiar entre modo semiautomático y automático
        automatica = !automatica;
        System.out.println("Modo de disparo " + (automatica ? "automático" : "semiautomático"));
    }

    public void agregarSilenciador() {
        // Agregar accesorio: silenciador
        silenciador = true;
        System.out.println("Silenciador agregado a la pistola.");
    }

    private void realizarDisparo(int probabilidadAcertar, Personaje objetivo) {
        // Método privado para la lógica de disparo común a ambos modos de disparo
        if (probabilidadAcertar <= calcularPrecision()) {
            int daño = 15; 
            objetivo.setVida(-daño);
            System.out.println("¡Impacto! Causando " + daño + " puntos de daño.");
        } else {
            System.out.println("¡Falló el disparo!");
        }
    }

    private int calcularPrecision() {
        // Calcular la precisión teniendo en cuenta los accesorios
        int precisionFinal = precisionBase;

        if (silenciador) {
            precisionFinal += 15; // Silenciador mejora significativamente la precisión
        }

        return Math.min(precisionFinal, 100); // La precisión no puede superar el 100%
    }
}

