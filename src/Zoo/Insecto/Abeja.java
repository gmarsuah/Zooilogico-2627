package Zoo.Insecto;

import java.util.Random;

public class Abeja extends Insecto {

    public Abeja () {
        super();
        this.numeroPatas = 4;
        this.color = COLORES[3];
        this.tieneAlas = true;
    }

    public Abeja (String nombre, int edad, float peso) {
        super(nombre, edad, peso,4,true,"Amarillo");
    }

    @Override
    public void moverse() {
        Random r = new Random();
        int num = r.nextInt(10);

        if (num > 8) {
            System.out.println(this.getNombre() + " viene a picarte!!!");
        } else {
            System.out.println(this.getNombre() + " se mueve volando.");
        }
    }

    @Override
    public void buscarRefugio() {
        System.out.println( getNombre() + " vuelve a la colonia.");
    }

    public void recolectarPolen() {
        System.out.println(this.getNombre() + " está recolectando polen.");
    }

    public void comunicarUbicacionAlimento() {
        Random r = new Random();
        int numeroDireccion = r.nextInt(4) + 1;

        switch (numeroDireccion) {
            case  1 -> System.out.println(this.getNombre() + " ha encontrado alimento al norte.");
            case  2 -> System.out.println(this.getNombre() + " ha encontrado alimento al este.");
            case  3 -> System.out.println(this.getNombre() + " ha encontrado alimento al sur.");
            case  4 -> System.out.println(this.getNombre() + " ha encontrado alimento al oeste.");
        }
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
                this::recolectarPolen,
                this::comunicarUbicacionAlimento
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
