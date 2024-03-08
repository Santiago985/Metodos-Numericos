package MetodoBiseccion;
class Evaluar{

    /*Metodo que convierte y resuelve la cadena de texto de la ecuacion a un resultado entero */

    static double evaluar(String cadena, double x) {
        double resultado = 0;
        try {
            String[] tokens; 

            if (cadena.contains("x")) {
                    
                cadena = cadena.replace("x", String.valueOf(x));
            }

            if (Es_numero(cadena)) { 
                resultado = Double.parseDouble(cadena); 

            } else {
                if (cadena.contains("[") || cadena.contains("]")) {  
                    
                    int parentIni = cadena.indexOf("[");
                    int parentFin = cadena.lastIndexOf("]");
                    
                    if (parentIni != -1 && parentFin != -1) {
                        String valor = cadena.substring(parentIni + 1, parentFin);
                        
                        resultado = evaluar(valor, x);
                        
                        cadena = cadena.substring(0, parentIni) + resultado + cadena.substring(parentFin + 1);
                    }
                }

                if (cadena.contains("Sen(") || cadena.contains("sen(")) {  
                    
                    int parentIni = cadena.indexOf("(");
                    int parentFin = cadena.lastIndexOf(")");
                    
                    if (parentIni != -1 && parentFin != -1) {
                        String valor = cadena.substring(parentIni + 1, parentFin);
                        
                        resultado = Math.sin(evaluar(valor, x));
                        
                        cadena = cadena.substring(0, parentIni) + resultado + cadena.substring(parentFin + 1);
                    }
                }

                if (cadena.contains("Cos(") || cadena.contains("cos(")) {  
                    
                    int parentIni = cadena.indexOf("(");
                    int parentFin = cadena.lastIndexOf(")");
                    
                    if (parentIni != -1 && parentFin != -1) {
                        String valor = cadena.substring(parentIni + 1, parentFin);
                        
                        resultado = Math.cos(evaluar(valor, x));
                        
                        cadena = cadena.substring(0, parentIni) + resultado + cadena.substring(parentFin + 1);
                    }
                }

                if (cadena.contains("Tan(") || cadena.contains("tan(")) {  
                    
                    int parentIni = cadena.indexOf("(");
                    int parentFin = cadena.lastIndexOf(")");
                    
                    if (parentIni != -1 && parentFin != -1) {
                        String valor = cadena.substring(parentIni + 1, parentFin);
                        
                        resultado = Math.tan(evaluar(valor, x));
                        
                        cadena = cadena.substring(0, parentIni) + resultado + cadena.substring(parentFin + 1);
                    }
                }


                if (cadena.contains("^")) {
                    tokens = cadena.split("\\^"); 
                    resultado = Math.pow(evaluar(tokens[0], x), evaluar(tokens[1], x));

                } else if (cadena.contains("*")) {
                    tokens = cadena.split("\\*"); 
                    resultado = evaluar(tokens[0], x) * evaluar(tokens[1], x);

                } else if (cadena.contains("/")) {
                    tokens = cadena.split("\\/"); 
                    resultado = evaluar(tokens[0], x) / evaluar(tokens[1], x);

                } else if (cadena.contains("+")) {
                    tokens = cadena.split("\\+"); 
                    resultado = evaluar(tokens[0], x) + evaluar(tokens[1], x);

                } else if (cadena.contains("-")) {
                    tokens = cadena.split("-");
                    resultado = evaluar(tokens[0], x) - evaluar(tokens[1], x);
                }
                
                
            }
        } catch (Exception e) {
            System.out.println("Error en la expresión.");
        }
        return resultado;
    }

    static boolean Es_numero(String n)/* verifica si una cadena String puede pasar a un Double */ {
        try {
            Double.parseDouble(n);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}