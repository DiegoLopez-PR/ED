import java.util.Scanner;

/**
 * Clase que implementa la generación de números primos utilizando la criba de Eratóstenes.
 */
class EratostenesCriba {

    private int[] vector; // Array para almacenar los números primos generados

    /**
     * Constructor de la clase. Genera números primos hasta el número máximo especificado.
     *
     * @param max El número máximo hasta el cual se generarán los primos.
     */
    public EratostenesCriba(int max) {

        if (max >= 2) {
            int dim = max + 1;
            boolean[] esPrimo = new boolean[dim];

            // Inicializar el array de primos
            for (int i = 0; i < dim; i++)
                esPrimo[i] = true;

            esPrimo[0] = esPrimo[1] = false;

            // Criba de Eratóstenes
            for (int i = 2; i < Math.sqrt(dim) + 1; i++) {
                if (esPrimo[i]) {
                    // Eliminar los múltiplos de i
                    for (int j = 2 * i; j < dim; j += i)
                        esPrimo[j] = false;
                }
            }

            // Contar los primos
            int cuenta = 0;
            for (boolean primo : esPrimo) {
                if (primo)
                    cuenta++;
            }

            // Rellenar el vector de números primos
            vector = new int[cuenta];
            for (int i = 0, j = 0; i < dim; i++) {
                if (esPrimo[i])
                    vector[j++] = i;
            }
        } else {
            vector = new int[0];
        }
    }

    /**
     * Genera y muestra los números primos en la consola.
     */
    public void generarPrimos() {
        System.out.println("\nGenerando números primos...");

        for (int i = 0, j = 0; i < vector.length; i++) {
            if (i % 10 == 0)
                System.out.println();
            System.out.print(vector[i] + "\t");
            j++;
            if (j == 10) {
                System.out.println();
                j = 0;
            }
        }

        System.out.println("\nNúmeros primos generados correctamente.");
    }

    /**
     * Muestra el vector inicial en la consola.
     */
    public void mostrarVectorInicial() {
        System.out.println("\nVector inicial hasta: " + vector.length);
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0)
                System.out.println();
            System.out.print(i + 1 + "\t");
        }
    }

    /**
     * Muestra el vector de primos en la consola.
     */
    public void mostrarVectorPrimos() {
        System.out.println("\nVector de primos hasta:" + vector.length);
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0)
                System.out.println();
            System.out.print(vector[i] + "\t");
        }
    }
}
