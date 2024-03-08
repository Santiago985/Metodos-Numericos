package ErrorAbsoluto;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu_Error_Absoluto {

    public static void menu1() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        System.out.println("\n=== ERROR ABSOLUTO ===");

        try {
            do{
                // Menu de opciones 
                imprimir(
                    "\nOpciones disponibles: \n"+
                    "\n - 1. Calcular ingresando datos de Aproximacion y Valor Real"+
                    "\n - 2. Calcular con una cantidad determinada de casos"+
                    "\n - 3. salir \n\n"+
                    "Ingrese una opcion: "
                );

                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        imprimir("\n==== CALCULO DE ERRORES ABSOLUTOS POR DATOS ====\n");
                        Caso1(sc);
                    break;
                
                    case 2:
                        imprimir("\n==== CALCULO DE ERRORES ABSOLUTOS POR CASOS ====\n");
                        Caso2(sc);
                    break;    

                    case 3:
                    break;

                    default:
                        imprimir("\nopcion no valida. Intente de nuevo\n");
                    break;
                }

            } while (opcion != 3);    
        
        } catch (InputMismatchException e) {
            imprimir("\nError: ingrese un numero valido\n");
        }
    }


    // subclase DecimalFormat para rendondear a dos decimales 
    static DecimalFormat a = new DecimalFormat("#.00"); 
    
    static void Caso1(Scanner scn) /*CASO 1 */ {
        
        imprimir("\nValor Real (Vr): "); 
        double Va = scn.nextDouble();
        
        imprimir("Valor Aproximado (utilize la misma unidad anterior): "); 
        double Vr = scn.nextDouble();

        String result =  a.format((Math.abs(Vr - Va))); 
        imprimir("\n==== RESULTADO ====\n\n Error absoluto: "+result+"\n");
    }

    
    static void Caso2(Scanner sc) /* CASO 2 */ {
        int numeroDeCasos=0;
        double valor, sumaDeValores = 0, aproximacion;
        boolean inputValido = false;
        
        while (!inputValido) {
            // Numero de casos
            try {
                imprimir("\nIngrese la cantidad de casos: ");
                numeroDeCasos = sc.nextInt();
                inputValido = true;
            } catch (InputMismatchException e) {
                imprimir("\nError: Ingrese un número entero válido.\n");
                sc.nextLine();
            }
        }
    
        // Lista de Valores
        double[] valores = new double[numeroDeCasos];
    
        for (int i = 0; i < numeroDeCasos; i++) {
            inputValido = false;
            while (!inputValido) {
                try {
                    imprimir(" .Ingrese el valor #" + (i + 1) + ": ");
                    valor = sc.nextDouble();
                    valores[i] = valor;
                    sumaDeValores += valor;
                    inputValido = true;
                } catch (InputMismatchException e) {
                    imprimir("\nError: Ingrese un número válido\n");
                    sc.nextLine();
                }
            }
        }
    
        // Calculo de la aproximación
       aproximacion = sumaDeValores / numeroDeCasos;
       aproximacion = Double.parseDouble(a.format(aproximacion)); // Aproximación redondeado a 2 decimales 
       imprimir("\nAproximación obtenido: " + aproximacion+"\n");
    
        // Calculo de los errores absolutos
        System.out.println();
        System.out.println("==== Errores absolutos Obtenidos ====");
        for (int i = 0; i < numeroDeCasos; i++) {
            double errorAbsoluto = Math.abs(valores[i] - aproximacion);
            imprimir("\nError absoluto para el valor #" + (i + 1) + ": " + String.format("%.4f",errorAbsoluto));
        }
        imprimir("\n");
    }

    static void imprimir(String txt){
        System.out.print(txt);
    }
}