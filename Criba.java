import java.util.Scanner;

/**
 * Clase principal que implementa la generación de números primos utilizando la criba de Eratóstenes.
 */
public class Criba {

    /**
     * Genera números primos hasta el número máximo especificado.
     *
     * @param max El número máximo hasta el cual se generarán los primos.
     * @return Un array de enteros que contiene los números primos generados.
     */
    public static int[] generarPrimos(int max) {
        int i, j;
        if (max >= 2) {
            // Declaraciones
            int dim = max + 1; // Tamaño del array
            boolean[] esPrimo = new boolean[dim];
            // Inicializar el array
            for (i = 0; i < dim; i++)
                esPrimo[i] = true;
            // Eliminar el 0 y el 1, que no son primos
            esPrimo[0] = esPrimo[1] = false;
            // Criba
            for (i = 2; i < Math.sqrt(dim) + 1; i++) {
                if (esPrimo[i]) {
                    // Eliminar los múltiplos de i
                    for (j = 2 * i; j < dim; j += i)
                        esPrimo[j] = false;
                }
            }
            // ¿Cuántos primos hay?
            int cuenta = 0;
            for (i = 0; i < dim; i++) {
                if (esPrimo[i])
                    cuenta++;
            }

            // Rellenar el vector de números primos
            int[] primos = new int[cuenta];
            for (i = 0, j = 0; i < dim; i++) {
                if (esPrimo[i])
                    primos[j++] = i;
            }
            return primos;
        } else { // max < 2
            return new int[0]; // Vector vacío
        }
    }

    /**
     * Método principal que solicita al usuario un número y muestra los números primos hasta ese número.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Eratóstenes:");
        int dato = teclado.nextInt();

        // Genera y muestra los números primos hasta el número proporcionado por el usuario
        int[] vector = generarPrimos(dato);
        EratostenesCriba criba = new EratostenesCriba(dato);
        criba.mostrarVectorInicial();
        criba.generarPrimos();
        criba.mostrarVectorPrimos();
    }
}
