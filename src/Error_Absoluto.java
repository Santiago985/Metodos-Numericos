import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Error_Absoluto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        System.out.println("\n=== ERROR ABSOLUTO ===");

        try {
            do{
                // Menu de opciones 
                System.out.println("\nopciones disponibles: \n");
                System.out.println( "1- Calcular ingresando datos de Aproximacion y Valor Real");
                System.out.println("2- Calcular con una cantidad determinada de casos");
                System.out.println("3- Terminar");
                System.out.print("\nIngrese la opción deseada: ");
                opcion = sc.nextInt();


                switch (opcion) {
                    case 1:
                        System.out.println("\n==== CALCULO DE ERRORES ABSOLUTOS POR DATOS ====\n");
                        /* Caso1: Calcula el error absoluto entre el valor real y el valor aproximado y al final se imprime 
                         * Ea = Vr - Va 
                        */
                        Caso1(sc);
                    break;
                
                    case 2:
                        System.out.println("\n==== CALCULO DE ERRORES ABSOLUTOS POR CASOS ====\n");
                        /* Caso 2: Calcula el error absoluto  por casos, es decir, si hay una cantidad n de pruebas, 
                         * calcula la aproximidad con los datos y despues los errores absolutos de cada caso para despues mostrarlos en pantalla
                        */
                        Caso2(sc);
                    break;    
                    case 3:
                        System.out.println("\nTerminando ...");
                    break;
                    default:
                        System.out.println("opcion no valida. Intente de nuevo");
                    break;
                }


            } while (opcion != 3);    
        } 
        catch (InputMismatchException e) {
            System.out.println("Error:  Dato Ingresado no es un numero entero.");
        }
        sc.close();
    }


    // subclase NumberFormat para rendondear a dos decimales 
    static DecimalFormat a = new DecimalFormat("#.00"); 
    
    
    static void Caso1(Scanner scn) /*CASO 1 */ {
        System.out.print("Valor Real (Vr): "); 
        double Va = scn.nextDouble();
        
        System.out.print("Valor Aproximado (utilize la misma unidad anterior): "); 
        double Vr = scn.nextDouble();

        String result =  a.format((Math.abs(Vr - Va))); 
        System.out.println("\n==== RESULTADO ====\n\n Error absoluto: "+result);
    }

    
    static void Caso2(Scanner sc) /* CASO 2 */ {
        int numeroDeCasos=0;
        double valor, sumaDeValores = 0, aproximacion;
        boolean inputValido = false;
        
        while (!inputValido) {
            // Numero de casos
            try {
                System.out.print("Ingrese la cantidad de casos: ");
                numeroDeCasos = sc.nextInt();
                inputValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número entero válido.");
                sc.nextLine();
            }
        }
    
        // Lista de Valores
        double[] valores = new double[numeroDeCasos];
    
        for (int i = 0; i < numeroDeCasos; i++) {
            inputValido = false;
            while (!inputValido) {
                try {
                    System.out.print(" .Ingrese el valor #" + (i + 1) + ": ");
                    valor = sc.nextDouble();
                    valores[i] = valor;
                    sumaDeValores += valor;
                    inputValido = true;
                } catch (InputMismatchException e) {
                    System.out.println("Error: Ingrese un número válido.");
                    sc.nextLine();
                }
            }
        }
    
        // Calculo de la aproximación
       aproximacion = sumaDeValores / numeroDeCasos;
       aproximacion = Double.parseDouble(a.format(aproximacion)); // Aproximación redondeado a 2 decimales 
       System.out.println("\nAproximación obtenido: " + aproximacion);
    
        // Calculo de los errores absolutos
        System.out.println();
        System.out.println("==== Errores absolutos ====\n");
        for (int i = 0; i < numeroDeCasos; i++) {
            double errorAbsoluto = Math.abs(valores[i] - aproximacion);
            System.out.println("Error absoluto para el valor #" + (i + 1) + ": " + String.format("%.2f",errorAbsoluto));
        }
    }
    
}