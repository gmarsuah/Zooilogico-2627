package Zoo.Ave;

import java.util.Random;
public class Avestruz extends Ave {

    public Avestruz() {
        super();
    }

    public Avestruz(int edad, float peso, String nombre, String colorPlumaje, double envergadura, boolean ponerHuevos, boolean acicalarse) {
        super(nombre, edad, peso, false, colorPlumaje, envergadura, ponerHuevos, acicalarse);

    }

    public void correr() {
        System.out.println(getNombre() + " está corriendo por alrededor.");

    }

    public void darPatadas() {
        System.out.println(getNombre() + " está dando patadas por doquier.");

    }

    @Override
    public void volar() {
        System.out.println(getNombre() + " escondió su cabeza dentro de la tierra.");

    }

    @Override
    public void nadar() {
        System.out.println(getNombre() + " se queda observando fijamente.");

    }

    @Override
    public void verAnimal() {
        super.verAnimal();
        Random random = new Random();
        Runnable[] acciones = {
                this::correr,
                this::darPatadas,
        };

        try {
            for (int i = 0; i < 3; i++) {
                int indiceAccion = random.nextInt(acciones.length);
                acciones[indiceAccion].run();

                int tiempoEspera = random.nextInt(2000) + 1000;
                Thread.sleep(tiempoEspera);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}