import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    private Jugador jugador;
    private Personaje objetivo;
    private Enemigo enemigo;
    private boolean tienePersonajeVivo;

    public Main() {
        jugador = null;
        objetivo = null;
        enemigo = new Enemigo("Enemigo", 1);
        tienePersonajeVivo = false;

        iniciarJuego();
    }

    private void iniciarJuego() {
        while (true) {
            mostrarMenu();
        }
    }

    private void mostrarMenu() {
        System.out.println("Bienvenido al juego shooter");

        if (!tienePersonajeVivo) {
            System.out.println("Presione 1 para crear un personaje");
        }

        System.out.println("Presione 2 para enfrentarse a un enemigo");
        System.out.println("Presione 3 para salir");

        Scanner scanner = new Scanner(System.in);

        try {
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    if (!tienePersonajeVivo) {
                        crearPersonaje();
                        tienePersonajeVivo = true;
                    } else {
                        System.out.println("Ya tienes un personaje vivo. No puedes crear otro hasta que muera.");
                    }
                    break;
                case 2:
                    if (tienePersonajeVivo) {
                        seleccionarObjetivo();
                        if (objetivo != null) {
                            enfrentarEnemigo();
                        }
                    } else {
                        System.out.println("Crea un personaje antes de enfrentarte a un enemigo.");
                    }
                    break;
                case 3:
                    System.out.println("Cerrando el programa correctamente");
                    System.exit(0);
                default:
                    System.out.println("Seleccione una opción válida");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingresa un número válido.");
            scanner.nextLine(); // Limpiar el búfer del escáner
        }
    }

    private void crearPersonaje() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre de tu personaje: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese una descripción para tu personaje (información adicional que desees agregar): ");
        String descripcion = scanner.nextLine();

        System.out.print("Ingrese el nivel para tu personaje (entre 1 y 100): ");
        int nivel = scanner.nextInt();

        // Validar que el nivel esté en el rango deseado (por ejemplo, 1 a 100)
        if (nivel < 1 || nivel > 100) {
            System.out.println("Error: El nivel debe estar entre 1 y 100. Volviendo al menú principal.");
            return;
        }

        System.out.println("Seleccione una clase para tu personaje:");
        System.out.println("1. Asesino");
        System.out.println("2. Soldado");
        System.out.println("3. Francotirador");

        int opcionClase = scanner.nextInt();

        switch (opcionClase) {
            case 1:
                jugador = new Asesino(nombre, descripcion, nivel, 70, 80);
                break;
            case 2:
                jugador = new Soldado(nombre, descripcion, nivel, 60, 70);
                break;
            case 3:
                jugador = new Francotirador(nombre, descripcion, nivel, 80, 60);
                break;
            default:
                System.out.println("Opción de clase no válida. Volviendo al menú principal.");
                return;
        }
        
        System.out.println("¡Personaje creado!");
        System.out.println(jugador);
        
        buscarArmas();
        System.out.println("Estado del jugador después de buscar armas:");
        System.out.println(jugador);
    }

    private void buscarArmas() {
        // Verificar si el jugador ya tiene armas
        if (jugador.tieneArmas()) {
            System.out.println("Ya tienes armas. No es necesario buscar más.");
            return;
        }

        System.out.println("Inventario de Armas: no tienes armas, debes buscar armas.");
        jugador.buscarArmas();
      
        // Generar un número aleatorio (1, 2 o 3) para representar las tres clases de armas
        int randomWeapon = (int) (Math.random() * 3) + 1;

        // Agregar el arma correspondiente al inventario del jugador
        switch (randomWeapon) {
            case 1:
                jugador.agregarArma(new Pistola());
                System.out.println("¡Has encontrado una Pistola!");
                break;
            case 2:
                jugador.agregarArma(new Escopeta());
                System.out.println("¡Has encontrado una Escopeta!");
                break;
            case 3:
                jugador.agregarArma(new Rifle());
                System.out.println("¡Has encontrado un Rifle!");
                break;
        }

        System.out.println("Estado del jugador después de buscar armas:");
        System.out.println(jugador);
    }

    private void seleccionarObjetivo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione un objetivo para enfrentar:");
        System.out.println("1. Enemigo");
        System.out.println("2. Otro jugador (en implementaciones futuras)");

        int opcionObjetivo = scanner.nextInt();

        switch (opcionObjetivo) {
            case 1:
                objetivo = enemigo;
                System.out.println("Has seleccionado al Enemigo como objetivo.");
                break;
            case 2:
                //Lógica para seleccionar a otro jugador en futuras iteraciones del juego
                break;
            default:
                System.out.println("Opción de objetivo no válida. Se enfrentará al Enemigo por defecto.");
                objetivo = enemigo;
                break;
        }
    }

    private void enfrentarEnemigo() {
    Scanner scanner = new Scanner(System.in);

    // Bucle hasta que el jugador o el enemigo sean derrotados
    while (jugador.getVida() > 0 && objetivo.getVida() > 0) {
        // Turno del jugador
        System.out.println("Turno del jugador:");
        System.out.println("1. Atacar");
        System.out.println("2. Cambiar de arma");
        System.out.println("3. Recargar");
        int opcionJugador = scanner.nextInt();

        switch (opcionJugador) {
            case 1:
                jugador.realizarAccion(objetivo);
                break;
            case 2:
                // Lógica para cambiar de arma
                System.out.println("Función no implementada. Se elige atacar por defecto.");
                jugador.realizarAccion(objetivo);
                break;
            case 3:
                // Lógica para recargar
                System.out.println("Función no implementada. Se elige atacar por defecto.");
                jugador.realizarAccion(objetivo);
                break;
            default:
                System.out.println("Opción no válida. Se elige atacar por defecto.");
                jugador.realizarAccion(objetivo);
                break;
        }

        // Verificar si el objetivo sigue vivo después del turno del jugador
        if (objetivo.getVida() <= 0) {
            System.out.println("¡Objetivo derrotado!");
            break; // Sale del bucle si el objetivo ha sido derrotado
        }

        // Turno del enemigo
        System.out.println("Turno del enemigo:");
        objetivo.atacar(jugador);

        // Verificar si el jugador sigue vivo después del ataque del enemigo
        if (jugador.getVida() <= 0) {
            System.out.println("¡El jugador ha sido derrotado!");
            System.exit(0);
        }
    }

    // Mostrar el estado del jugador después del enfrentamiento
    System.out.println("Estado del jugador después del enfrentamiento:");
    System.out.println(jugador);

    // Volver al menú para realizar más acciones
    mostrarMenu();
}
    public static void main(String[] args) {
        new Main();
    }
}
