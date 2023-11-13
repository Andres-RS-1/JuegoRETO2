import java.util.Random;

class Rifle implements Arma {
    private int alcance;
    private int precisionBase;
    private int capacidadCargador;
    private int municion;
    private boolean modoRafaga;
    private int rafagaBalas;

    // Nuevos atributos para accesorios
    private boolean miraTelescopica;
    private boolean compensador;

    @Override
    public void definirAtributosDeArma() {
        // Lógica para definir atributos específicos del Rifle
        alcance = 800;  
        precisionBase = 90; 
        capacidadCargador = 10; 
        municion = capacidadCargador; 
        modoRafaga = false; 
        rafagaBalas = 3; 

        // Atributos de accesorios
        miraTelescopica = false;
        compensador = false;
    }

    @Override
    public void disparar(Personaje objetivo) {
        System.out.println("¡Pum! Rifle disparando a " + objetivo.getNombre());

        Random random = new Random();
        int probabilidadAcertar = random.nextInt(100) + 1;

        if (municion > 0) {
            for (int i = 0; i < (modoRafaga ? rafagaBalas : 1); i++) {
                if (probabilidadAcertar <= calcularPrecision()) {
                    int distancia = random.nextInt(alcance);
                    int daño = distancia / 10; 
                    objetivo.setVida(-daño);
                    System.out.println("¡Impacto! Causando " + daño + " puntos de daño.");
                } else {
                    System.out.println("¡Falló el disparo!");
                }
                municion--;
            }
        } else {
            System.out.println("¡Recarga necesaria! Cargador vacío.");
        }
    }

    private void realizarDisparo(int probabilidadAcertar, Personaje objetivo) {
    Random random = new Random();
    if (probabilidadAcertar <= calcularPrecision()) {
        int distancia = random.nextInt(alcance);
        int daño = distancia / 30; 
        objetivo.setVida(-daño);
        System.out.println("¡Impacto! Causando " + daño + " puntos de daño.");
    } else {
        System.out.println("¡Falló el disparo!");
    }
}

    
    public void recargar() {
        // Lógica para recargar el rifle
        System.out.println("Recargando el rifle...");
        municion = capacidadCargador;
        System.out.println("¡Rifle recargado con " + capacidadCargador + " balas!");
    }

    public void cambiarModoRafaga() {
        modoRafaga = !modoRafaga;
        System.out.println("Modo ráfaga " + (modoRafaga ? "activado" : "desactivado"));
    }

    public void agregarMiraTelescopica() {
        // Agregar accesorio: mira telescópica
        miraTelescopica = true;
        System.out.println("Mira telescópica agregada al rifle.");
    }

    public void agregarCompensador() {
        compensador = true;
        System.out.println("Compensador agregado al rifle.");
    }

    private int calcularPrecision() {
        // Calcular la precisión teniendo en cuenta los accesorios
        int precisionFinal = precisionBase;

        if (miraTelescopica) {
            precisionFinal += 10; // Mira telescópica mejora la precisión
        }

        if (compensador) {
            precisionFinal += 5; // Compensador mejora ligeramente la precisión
        }

        return Math.min(precisionFinal, 100); // La precisión no puede superar el 100%
    }
}

