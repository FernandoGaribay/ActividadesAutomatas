package primerParcial;

import java.util.Scanner;

public class CerraduraKleene {

    private String[] palabras;
    private int nivelCerradura;

    public CerraduraKleene(String[] palabras, int nivelCerradura) {
        this.palabras = palabras;
        this.nivelCerradura = nivelCerradura;
    }

    public String[] calcularPalabras() {
        String[] palabrasCalculadas;
        String[] tempPalabras;

        // Si el nivel de cerradura es 0 regresa vacio
        if (nivelCerradura == 0) {
            palabrasCalculadas = new String[1];
            palabrasCalculadas[0] = "λ";
            return palabrasCalculadas;
        }

        // Si el nivel de cerradura es 1 regresa el conjunto
        if (nivelCerradura == 1) {
            return palabras;
        }

        // Inicializas el arreglo resultado con la cantidad de 2 elevado a nivelCerradura y copio el conjunto
        palabrasCalculadas = new String[(int) Math.pow(palabras.length, nivelCerradura)];
        System.arraycopy(palabras, 0, palabrasCalculadas, 0, palabras.length);

        for (int i = 0; i < nivelCerradura - 1; i++) {
            // Se inicializa tempPalabras y se copia las palabras calculadas
            tempPalabras = new String[(int) Math.pow(palabras.length, i + 1)];
            System.arraycopy(palabrasCalculadas, 0, tempPalabras, 0, tempPalabras.length);

            // Se guarda en palabrasCalculadas la convinacion de tempPalabras con el conjunto (abecedario)
            int index = 0;
            for (String palabra_i : tempPalabras) {
                for (String palabra_j : palabras) {
                    palabrasCalculadas[index] = palabra_i + palabra_j;
                    index++;
                }
            }
        }

        return palabrasCalculadas;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] palabras;
        int nivelCerradura;

        System.out.println("¿Cuántas palabras contiene el lenguaje?");
        System.out.print("No: ");
        palabras = new String[input.nextInt()];
        System.out.println("");

        System.out.println("Ingresa las " + palabras.length + " palabras de lenguaje:");
        for (int i = 0; i < palabras.length; i++) {
            System.out.print(i + 1 + ": ");
            palabras[i] = input.next();
        }
        System.out.println("");

        System.out.println("¿Qué nivel de cerradura de Kleene deseas conocer?");
        System.out.print("Nivel: ");
        nivelCerradura = input.nextInt();
        System.out.println("");

        CerraduraKleene calc = new CerraduraKleene(palabras, nivelCerradura);
        String[] resultado = calc.calcularPalabras();

        System.out.println("Palabras formadas:");
        for (int i = 0; i < resultado.length; i++) {
            System.out.print(resultado[i]);
            if (i < resultado.length - 1) {
                System.out.print("-");
            }
        }
        System.out.println("");
    }

}
