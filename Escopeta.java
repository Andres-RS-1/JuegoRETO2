import java.util.Random;

class Escopeta implements Arma {
    private int dispersion;
    private int capacidadCartucho;
    private int cartucho;
    private boolean dobleCañon;

    // Nuevo atributo para accesorio
    private boolean miraRefleja;

    @Override
    public void definirAtributosDeArma() {
        // Lógica para definir atributos específicos de la Escopeta
        dispersion = 30;
        capacidadCartucho = 6; 
        cartucho = capacidadCartucho; 
        dobleCañon = false; 

        // Atributo de accesorio
        miraRefleja = false;
    }

    @Override
    public void disparar(Personaje objetivo) {
        // Lógica de disparo específica de la Escopeta
        System.out.println("¡Boom! Escopeta disparando a " + objetivo.getNombre());

        Random random = new Random();
        int probabilidadAcertar = random.nextInt(100) + 1;

        if (cartucho > 0) {
            for (int i = 0; i < (dobleCañon ? 2 : 1); i++) { 
                if (probabilidadAcertar <= calcularPrecision()) {
                    int daño = 20; 
                    objetivo.setVida(-daño);
                    System.out.println("¡Impacto! Causando " + daño + " puntos de daño.");
                } else {
                    System.out.println("¡Falló el disparo!");
                }
                cartucho--;
            }
        } else {
            System.out.println("¡Recarga necesaria! Cartucho vacío.");
        }
    }

    public void recargar() {
        // Lógica para recargar la escopeta
        System.out.println("Recargando la escopeta...");
        cartucho = capacidadCartucho;
        System.out.println("¡Escopeta recargada con " + capacidadCartucho + " cartuchos!");
    }

    public void cambiarModoCañon() {
        // Cambiar entre modo de un solo cañón y doble cañón
        dobleCañon = !dobleCañon;
        System.out.println("Modo de cañón " + (dobleCañon ? "doble" : "único"));
    }

    public void agregarMiraRefleja() {
        // Agregar accesorio: mira reflectante
        miraRefleja = true;
        System.out.println("Mira reflectante agregada a la escopeta.");
    }

    private int calcularPrecision() {
        // Calcular la precisión teniendo en cuenta los accesorios
        int precisionFinal = 100 - dispersion;

        if (miraRefleja) {
            precisionFinal += 10; // Mira reflectante mejora la precisión
        }

        return Math.max(precisionFinal, 0); // La precisión no puede ser negativa
    }
}
