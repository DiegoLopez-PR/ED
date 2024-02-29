import java.util.Scanner;
//

public class Criba {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Eratóstenes:");
        int dato = teclado.nextInt();

        EratostenesCriba criba = new EratostenesCriba(dato);
        criba.mostrarVectorInicial();
        criba.generarPrimos();
        criba.mostrarVectorPrimos();
    }
}