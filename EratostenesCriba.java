import java.util.Scanner;

class EratostenesCriba {
    private int[] vector;

    public EratostenesCriba(int max) {
        if (max >= 2) {
            int dim = max + 1;
            boolean[] esPrimo = new boolean[dim];

            for (int i = 0; i < dim; i++)
                esPrimo[i] = true;

            esPrimo[0] = esPrimo[1] = false;

            for (int i = 2; i < Math.sqrt(dim) + 1; i++) {
                if (esPrimo[i]) {
                    for (int j = 2 * i; j < dim; j += i)
                        esPrimo[j] = false;
                }
            }

            int cuenta = 0;
            for (boolean primo : esPrimo) {
                if (primo)
                    cuenta++;
            }

            vector = new int[cuenta];
            for (int i = 0, j = 0; i < dim; i++) {
                if (esPrimo[i])
                    vector[j++] = i;
            }
        } else {
            vector = new int[0];
        }
    }

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

    public void mostrarVectorInicial() {
        System.out.println("\nVector inicial hasta: " + vector.length);
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0)
                System.out.println();
            System.out.print(i + 1 + "\t");
        }
    }

    public void mostrarVectorPrimos() {
        System.out.println("\nVector de primos hasta:" + vector.length);
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0)
                System.out.println();
            System.out.print(vector[i] + "\t");
        }
    }
}
