package MetodoBiseccion;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuBiseccion {
    
    public static void menu2() {
        
        @SuppressWarnings("resource")
        Scanner scn1 = new Scanner(System.in);
        
        int op = 0; String ecuacion, rango; double err;

        
        imprimir(
            "\n Antes de empezar unos puntos: \n\n"+
            " - para valores trigonometricas escriba: Sen(x), Cos(x), Tan(x) ... etc\n"+
            " - para varias ecuaciones utilize corchetes: [...] operador [...]\n"+
            " - Operadores como: +, -, *, /,^, (). Son validos\n"+
            " - Para las incognitas utilice solo 'x', ejemplo: 3*x. No: 3x o 3y o 3*z... etc\n\n"
            );
            
        try{
            imprimir("\n=== METODO BISECCION ===\n");
            do {
                imprimir(
                    "\n opciones disponibles: \n\n"+
                    " - 1. Calcular Nueva Funcion \n"+
                    " - 2. Salir\n\n"+
                    " Ingrese una Opcion: "
                );

                op = scn1.nextInt();

                switch (op) {
                    case 1:

                        imprimir("\n Ingrese su ecuacion: ");ecuacion = scn1.next();
                        imprimir(" Ingrese rangos (Ejemplo: 'a, b' ): ");rango = scn1.next();
                        imprimir(" Ingrese porcentaje de error: ");err = scn1.nextDouble(); 

                        String[] rangos = rango.split(","); // Divide la cadena de texto de rango en 2 partes, separadas por las comas

                        imprimir("\n DATOS OBTENIDOS \n: ");


                        Biseccion.calcularValores(
                            Double.parseDouble(rangos[0]), 
                            Double.parseDouble(rangos[1]), 
                            err, 
                            ecuacion
                        ); 

                        ecuacion = rango = "";
                        err = 0;

                    break;

                    case 2:
                    break;
                
                    default:
                        imprimir("Opcion invalida, intente de nuevo");
                    break;

                }

            } while (op != 2);
        } catch (InputMismatchException e){
            imprimir("\n Error: Ingrese un número válido\n");
        }
    }

    static void imprimir(String text){
        System.out.print(text);
    }
}
