package Zoo.Insecto;
import Zoo.Animal;

import java.util.Random;

public class Insecto extends Animal {
    final String [] COLORES = { "Rojo", "Verde", "Amarillo", "Marrón" };
    int numeroPatas;
    boolean tieneAlas;
    String color;

    public void moverAntenas() {
        System.out.println( getNombre() + " mueve las antenas.");
    }

    public void buscarRefugio() {
        System.out.println( getNombre() + " busca refugio.");
    }

    public void detectarVibraciones() {
        System.out.println( getNombre() + " detecta vibraciones.");
    }

    public Insecto () {
        super();
        Random r = new Random();
        this.numeroPatas = r.nextInt(6) + 1;
        this.color = COLORES[r.nextInt( COLORES.length - 1 )];
        this.tieneAlas = r.nextBoolean();
    }

    public Insecto (String nombre, int edad, float peso, int numeroPatas,  boolean tieneAlas, String color) {
        super(nombre, edad, peso);
        this.numeroPatas = numeroPatas;
        this.tieneAlas = tieneAlas;
        this.color = color;
    }


    //VER ANIMAL
    @Override
    public void verAnimal() {
        Random random = new Random();
        // Lista de acciones posibles
        Runnable[] acciones = {
                this::moverAntenas,
                this::buscarRefugio,
                this::detectarVibraciones,
                this::comer,
                this::dormir,
                this::moverse,
        };

        try {
            for (int i = 0; i < 3; i++) { // Ejecuta 3 acciones aleatorias
                int indiceAccion = random.nextInt(acciones.length);
                acciones[indiceAccion].run(); // Ejecuta la acción seleccionada

                int tiempoEspera = random.nextInt(2000) + 1000; // Espera entre 1 y 2 segundos
                Thread.sleep(tiempoEspera);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
