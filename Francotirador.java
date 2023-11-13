public class Francotirador extends Jugador {
    private int precision;
    private int alcance;

    public Francotirador(String nombre, String descripcion, int nivel, int precision, int alcance) {
        super(nombre, descripcion, nivel, 80, 40, 10); 
        this.precision = precision;
        this.alcance = alcance;
    }

    public int getAlcance() {
        return alcance;
    }
    
    public void setAlcance(int nuevoAlcance) {
        this.alcance = nuevoAlcance;
    }
    
    // Métodos específicos de Francotirador
    public void disparoPreciso() {
        System.out.println(getNombre() + " realiza un disparo preciso. ¡Alcance aumentado!");
        int aumentoAlcance = 30; 
        setAlcance(getAlcance() + aumentoAlcance);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Precision=" + precision + "\n" +
                "Alcance=" + alcance + "\n";
    }
}
