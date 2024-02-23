package primerParcial;

import java.util.Scanner;

public class OperacionesLenguajes {

    private String[] L1;
    private String[] L2;

    public OperacionesLenguajes(String[] L1, String[] L2) {
        this.L1 = L1;
        this.L2 = L2;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numPalabras;
        String[] L1;
        String[] L2;

        // Ingresar palabras lenguaje 1 ----------------------------------------
        System.out.println("¿Cuántas palabras contiene el lenguaje 1?");
        System.out.print("No: ");
        L1 = new String[input.nextInt()];
        System.out.println("");

        System.out.println("Ingresa las " + L1.length + " palabras de lenguaje:");
        for (int i = 0; i < L1.length; i++) {
            System.out.print(i + 1 + ": ");
            L1[i] = input.next();
        }
        System.out.println("");

        // Ingresar palabras lenguaje 2 ----------------------------------------
        System.out.println("¿Cuántas palabras contiene el lenguaje 2?");
        System.out.print("No: ");
        L2 = new String[input.nextInt()];
        System.out.println("");

        System.out.println("Ingresa las " + L2.length + " palabras de lenguaje:");
        for (int i = 0; i < L2.length; i++) {
            System.out.print(i + 1 + ": ");
            L2[i] = input.next();
        }
        System.out.println("");

        
        System.out.println("L1 --------------");
        for (String string : L1) {
            System.out.println(string);
        }

        System.out.println("L2 --------------");
        for (String string : L2) {
            System.out.println(string);
        }
    }
}
