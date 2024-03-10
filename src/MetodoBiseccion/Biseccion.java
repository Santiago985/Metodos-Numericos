package MetodoBiseccion;
import java.text.DecimalFormat;

public class Biseccion {

    static int iteracciones = 0;
    static DecimalFormat  df = new DecimalFormat("#.0000");


    static void calcularValores(double rangoA, double rangoB, double ErrorAproximar, String ecua){
        iteracciones++;
        double media = ValorMedio(rangoA, rangoB);
        double error = porcentajeError(rangoA, rangoB);

        double Fa = evaluar1(rangoA, ecua);
        double Fb = evaluar1(rangoB, ecua);
        double Fm = evaluar1(media, ecua);

        //TODO: INVESTIGAR LAS CONDICIONES DE INTERACIONES Y MODIFICAR LA CONDICIONAL "if(){}" DEBAJO

        
        if(error <= ErrorAproximar)/*Si se encuentra un margen  de error menor o igual al permitido se termina*/{

            System.out.println("\n DATOS FINALES :" ); // En caso de encontrar un margen de error igual o menor se termina
            resultados(iteracciones, rangoA, rangoB, media, error, Fa, Fb, Fm);
            
            System.out.println("\n --- PROCESO TERMINADO: Se encontro un margen de error menor o igual al establecido ---\n");
        }

        else if(media == 0 || (Fa*Fb)>=0 || Fm==0)/*Si hubo un error en la iteraccion, aqui termina*/{
                
            System.out.println("\n DATOS FINALES :" );
            resultados(iteracciones, rangoA, rangoB, media, error, Fa, Fb, Fm);
        
            if( media==0 ){
                System.out.println("\n --- PROCESO TERMINADO: La media termina siendo cero. Por lo tanto no hay mas interaciones ---\n");
            } 
            
            else if( Fm==0 ){
                System.out.println("\n --- PROCESO TERMINADO: Fm termina siendo cero. Por lo tanto no hay mas interaciones ---\n");
            } 
            
            else {
                System.out.println("\n --- PROCESO TERMINADO: Los signos entre los valores (Fa y Fb) ya no son diferentes. Por lo tanto no hay mas interaciones ---\n");
            } 
        }

        else{ /* Raiz de la recursividad */
            if(signoPositivo(Fm)){  
                if(!signoPositivo(Fa)) /* cuando: - Fa y + Fm   */ {
                    resultados(iteracciones, rangoA, rangoB, media, error, Fa, Fb, Fm);
                    calcularValores(rangoA, media, ErrorAproximar, ecua);
                }
                else /* cuando: + Fm y - FB */ {
                    resultados(iteracciones, rangoA, rangoB, media, error, Fa, Fb, Fm);
                    calcularValores(media, rangoB, ErrorAproximar, ecua);
                }
            } else {
                if (signoPositivo(Fa))/* cuando: + Fa y -Fm */ {
                    resultados(iteracciones, rangoA, rangoB, media, error, Fa, Fb, Fm);
                    calcularValores(rangoA, media, ErrorAproximar, ecua);
                } else /* cuando: - Fm y + Fb*/ {
                    resultados(iteracciones, rangoA, rangoB, media, error, Fa, Fb, Fm);
                    calcularValores(media, rangoB, ErrorAproximar, ecua);
                }
            }
        }

        iteracciones = 0; 
    }

    static Double  ValorMedio(double a , double b){
        return Double.parseDouble(df.format((a+b)/2));
    }

    static Double  porcentajeError(double a , double b){
        return Math.abs(Double.parseDouble( df.format( ((b - a)/2)*100 ) ));
    }

    static double evaluar1(double x, String ecuacion ){
        // AQUI VA LA FORMULA
        double formula = Evaluar.evaluar(ecuacion, x); 
        return Double.parseDouble(df.format( formula ));
    }

    static boolean signoPositivo(double valor){
        return  (valor > 0);
    }

    static void imprimirValores(int i, double Ra, double Rb,double m, double error){
        System.out.println(
            "\n . Iteracion: "+ i +
            "\n . Rangos: ["+ Ra +" - "+ Rb + 
            "]\n . Media: "+ m +
            "\n . Error: "+ error +" %"
        );
    }

    static void imprimirResultFuncion(double Fa, double Fb, double Fm){
        System.out.println(
            "\n * F(a): "+ Fa +
            "\n * F(b): "+ Fb +
            "\n * F(m): "+ Fm +"\n"
        );

    }

    static void resultados(int i, double Ra, double Rb,double m, double error, double Fa, double Fb, double Fm){
        imprimirValores(i, Ra, Rb, m, error);
        imprimirResultFuncion(Fa, Fb, Fm);
    }

}