package primerParcial;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class OperacionesLenguajes {

    private String[] L1;
    private String[] L2;

    public OperacionesLenguajes(String[] L1, String[] L2) {
        this.L1 = L1;
        this.L2 = L2;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
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

        new OperacionesLenguajesCalcular(L1, L2).mostrarMenu();
    }
}

class OperacionesLenguajesCalcular {

    private String[] L1;
    private String[] L2;

    public OperacionesLenguajesCalcular(String[] L1, String[] L2) {
        this.L1 = L1;
        this.L2 = L2;
    }

    public void mostrarMenu() {
        Scanner input = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú de Opciones:");
            System.out.println("1. Intersección");
            System.out.println("2. Diferencia");
            System.out.println("3. Concatenación");
            System.out.println("4. Prefijos de una palabra");
            System.out.println("5. Sufijos de una palabra");
            System.out.println("6. Salir del Sistema");
            System.out.print("\n*Seleccione una opción: ");
            opcion = input.nextInt();

            String[] resultado;
            switch (opcion) {
                case 1:
                    resultado = calcularInterseccion(L1, L2);
                    imprimirPalabras(resultado);
                    break;
                case 2:
                    resultado = calcularDiferencia(L1, L2);
                    imprimirPalabras(resultado);
                    break;
                case 3:
                    resultado = calcularConcatenacion(L1, L2);
                    imprimirPalabras(resultado);
                    break;
                case 4:
                    resultado = calcularPrefijos();
                    imprimirPalabras(resultado);
                    break;
                case 5:
                    resultado = calcularSufijos();
                    imprimirPalabras(resultado);
                    break;
                case 6:
                    System.out.println("\nSaliendo del Sistema...");
                    opcion = 6;
                    break;
                default:
                    System.out.println("\nOpción no válida. Por favor, seleccione una opción válida.");
            }
            if (opcion != 6) {
                pausarConsola();
            }
            System.out.println();
        } while (opcion != 6);
        input.close();
    }

    public String[] calcularInterseccion(String[] L1, String[] L2) {
        List<String> listaL1 = Arrays.asList(L1);
        List<String> listaL2 = Arrays.asList(L2);

        List<String> interseccion = new ArrayList<>();

        for (String palabra : listaL1) {
            if (listaL2.contains(palabra)) {
                interseccion.add(palabra);
            }
        }
        if (interseccion.isEmpty()) {
            interseccion.add("ᴓ");
        }

        String[] interseccionArray = new String[interseccion.size()];
        interseccionArray = interseccion.toArray(interseccionArray);

        return interseccionArray;
    }

    public String[] calcularDiferencia(String[] L1, String[] L2) {
        List<String> listaL1 = Arrays.asList(L1);
        List<String> listaL2 = Arrays.asList(L2);

        List<String> diferencia = new ArrayList<>();

        for (String palabra : listaL1) {
            if (!listaL2.contains(palabra)) {
                diferencia.add(palabra);
            }
        }
        if (diferencia.isEmpty()) {
            diferencia.add("ᴓ");
        }

        String[] diferenciaArray = new String[diferencia.size()];
        diferenciaArray = diferencia.toArray(diferenciaArray);

        return diferenciaArray;
    }

    public String[] calcularConcatenacion(String[] L1, String[] L2) {
        List<String> concatenacion = new ArrayList<>();

        for (String StringX : L1) {
            for (String StringY : L2) {
                concatenacion.add(StringX + StringY);
            }
        }

        String[] concatenacionArray = new String[concatenacion.size()];
        concatenacionArray = concatenacion.toArray(concatenacionArray);

        return concatenacionArray;
    }

    public String[] calcularPrefijos() {
        Scanner input = new Scanner(System.in);
        List<String> prefijo = new ArrayList<>();
        String palabra;

        System.out.print("\n-> Ingresa una palabra para mostrar los prefijos: ");
        palabra = input.next();

        for (int i = palabra.length(); i >= 1; i--) {
            prefijo.add(palabra.substring(0, i));
        }
        prefijo.add("λ");

        String[] prefijoArray = new String[prefijo.size()];
        prefijoArray = prefijo.toArray(prefijoArray);

        return prefijoArray;
    }

    public String[] calcularSufijos() {
        Scanner input = new Scanner(System.in);
        List<String> sufijos = new ArrayList<>();
        String palabra;

        System.out.print("\n-> Ingresa una palabra para mostrar los prefijos: ");
        palabra = input.next();

        for (int i = 0; i < palabra.length(); i++) {
            sufijos.add(palabra.substring(i));
        }
        sufijos.add("λ");

        String[] sufijosArray = new String[sufijos.size()];
        sufijosArray = sufijos.toArray(sufijosArray);

        return sufijosArray;
    }

    public void imprimirPalabras(String[] palabras) {
        System.out.println("\n\nPalabras formadas:");
        System.out.print("{");
        for (int i = 0; i < palabras.length; i++) {
            System.out.print(palabras[i]);
            if (i < palabras.length - 1) {
                System.out.print(",");
            }
        }
        System.out.print("}\n\n");
    }

    public void pausarConsola() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Presione Enter para continuar...");
        scanner.nextLine();
    }
}
