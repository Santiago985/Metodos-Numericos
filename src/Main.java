import ErrorAbsoluto.Menu_Error_Absoluto;
import MetodoBiseccion.MenuBiseccion;
import java.util.Scanner;
import java.util.InputMismatchException;;

public class Main {
    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        int op = 0;
        
        try {
            do {
                imprimir("\n METODOS NUMERICOS \n");
                
                imprimir(
                    "\nMENU PRINCIPAL DE OPCIONES\n"+
                    "\n - 1. Ir a Codigo de Error Absoluto"+
                    "\n - 2. Ir a Codigo de Metodo de Biseccion"+
                    "\n - 3. Terminar Codigo\n\n"+
                    "Ingrese una Opcion: "
                );
                op = scn.nextInt();
            
                switch (op) {
                    case 1:
                        Menu_Error_Absoluto.menu1();
                    break;
                
                    case 2:
                        MenuBiseccion.menu2();
                    break;
                
                    case 3:
                        imprimir("\nTerminando...");
                    break;
                    
                    default:
                        imprimir("Opcion invalida");
                    break;
                }
                
            } while (op!=3);
            
        } catch (InputMismatchException e) {
            imprimir("\n Error: Trate de ingresar solo numeros validos\n");
        } catch (Exception e){
            imprimir("\n Error: Trate de ingresar solo valores correspondidos\n");
        }
        
        scn.close();
    }

    public static void imprimir (String text){
        System.out.print(text);
    }
}