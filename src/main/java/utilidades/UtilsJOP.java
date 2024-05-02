/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import javax.swing.JOptionPane;
import excepciones.MyException;

/**
 *
 * @author herra
 */
public class UtilsJOP {
    /**
     *  Se utiliza para perdir un caracter(char)
     * @param mensaje --> Especificar el mensaje que muestra al usuario
     * @return --> Devuelve el caracter(char) si pasa las comprobacfiones internas del metodo
     * @throws MyException --> Si el caracter esta vacio o es un espacio o contiene caracteres especiales
     */
    public static char orderChar(String mensaje) throws MyException {
        String r = JOptionPane.showInputDialog(mensaje);
        String regEX = "^[a-zA-Z]{1}"; // Se puede modificar si lo quieres en mayusculas o no o que letras quieres que sean F V etc
        
        if (r.isBlank()) {
            throw new MyException("La cadena de texto no puede estar vacia o tener solo un espacio");
        }
        if (r.length() > 1) {
            throw new MyException("Has insertado mas de un caracter, solo se permite uno");
        }
        Boolean matches = r.matches(regEX);
        if (!matches) {
            throw new MyException("Error_Detectado_Caracteres_Especiales:\n"
                    +"1.  La cadena de texto que has insertado contiene caracteres especiales y otros caracteres no validos,\n"
                    +"    solo se permiten caracteres alfanumericos es decir letras minusculas, mayusculas, del 0 al 9 y barra baja\n");
        }
        char result = r.charAt(0);
        return result;
    }
    
    
    /**
     *  Se utiliza para perdir una cadena de texto(string)
     * @param mensaje  --> Especificar el mensaje que muestra al usuario
     * @return --> Devuelve el String si pasa las comprobacfiones internas del metodo
     * @throws MyException  --> Si la cadena es vacia o espacio o contiene caracteres especiales
     */
    public static String orderString(String mensaje) throws MyException {
        System.out.println(mensaje);
        String result = JOptionPane.showInputDialog(mensaje);
        int num = result.length();

        String regEX = "^[\\w]" + "{" + num + "}";
        if (result.isBlank()) {
            throw new MyException("La cadena de texto no puede estar vacia o tener solo un espacio");
        }
        Boolean matches = result.matches(regEX);
        if (!matches) {
            throw new MyException("Error_Detectado_Caracteres_Especiales:\n"
                    +"1.  La cadena de texto que has insertado contiene caracteres especiales y otros caracteres no validos,\n"
                    +"    solo se permiten caracteres alfanumericos es decir letras minusculas, mayusculas, del 0 al 9 y barra baja _\n");
        }
        return result;
    }
    /**
     * Se utiliza este metodo para pedir float y double para permitir caracter especial  punto | . | :
     *      1. orderFloat()
     *      2. orderDouble()
     * @param mensaje --> Expecificar el mensaje que se le muestra al cliente
     * @return --> Devuelve una cadena de texto 
     * @throws MyException  --> Si la cadena esta vacia o contiene un espacio o tiene caracteres especiales que no sean el punto
     *    
     */
    public static String orderStringConPunto(String mensaje) throws MyException {
        System.out.println(mensaje);
        String result = JOptionPane.showInputDialog(mensaje);
        int num = result.length();

        String regEX = "^[\\w.]" + "{" + num + "}";
        if (result.isBlank()) {
            throw new MyException("La cadena de texto no puede estar vacia o tener solo un espacio");
        }
        Boolean matches = result.matches(regEX);
        if (!matches) {
            throw new MyException("Error_Detectado_Caracteres_Especiales:\n"
                    +"1.  La cadena de texto que has insertado contiene caracteres especiales a parte del punto .  por ello caracteres no validos,\n"
                    +"    solo se permiten caracteres alfanumericos es decir letras minusculas, mayusculas, del 0 al 9 y barra baja _ y el punto\n");
        }
        return result;
    }
    
    
    /**
     * Se encarga de pedir una cadena de texto y Integer.ParseInt para que sea un numero y devuelva un Int
     * @return --> Devuelve un Int
     * @throws MyException --> Si da error en el formato del numero, por ello si hay caracteres no permitidos, solo numeros Ejemplo: 7898798  7 147
     */
    public static int orderInt() throws MyException {
        //DECLARO E INICIALIZO LAS VARIABLES LOCALES
        String num = orderString("Inserta un numero: ");
        int result;
        // CONDICIONES Y LANZAMIENTO "MyExcepcion"
        try {
            result = Integer.parseInt(num);
        } catch (NumberFormatException ex) {
            throw new MyException("El formato del numero no es correcto.");
        }
        return result;
    }
    /**
     * orderFloat() sirve para pedir una cadena de texto y devolver un numero decimal(float)
     * @return --> Devuelve un numero decimal(float)
     * @throws MyException --> Si el formato del decimal no es correcto o hay caracteres no validos a la hora de Float.parseFloat()
     */
    public static float orderFloat() throws MyException {
         //DECLARO E INICIALIZO LAS VARIABLES LOCALES
        String f = orderStringConPunto("Inserta un numero decimal(float): ");
        float result;
        // CONDICIONES Y LANZAMIENTO "MyExcepcion"
        try {
            result = Float.parseFloat(f);
        } catch (NumberFormatException ex) {
            throw new MyException("El formato del decimal(float) no es correcto.");
        }
        return result;
    }
    /**
     *  orderDouble() sirve para pedir una cadena de texto y devolver un numero decimal largo(double)
     * @return --> Devuelve un numero decimal largo(double)
     * @throws MyException --> Si el formato del decimal largo no es correcto o hay caracteres no validos a la hora de Double.parseDouble()
     */
    public static double orderDouble() throws MyException {
         //DECLARO E INICIALIZO LAS VARIABLES LOCALES
        String d = orderStringConPunto("Inserta un numero decimal largo(double): ");
        double result;
        // CONDICIONES Y LANZAMIENTO "MyExcepcion"
        try {
            result = Double.parseDouble(d);
        } catch (NumberFormatException ex) {
            throw new MyException("El formato del numero decimal largo(double) no es correcto.");
        }
        return result;
    }

    /**
     * 
     * @return 
     *          DEVUELVE TRUE O FALSE 
     *              --> Input(String "true" "false")
     *              --> Output(Boolean | true | false | ) 
     * @throws MyException --> Excepciones del metodo utilitiesScanner.orderString() || EXCEPCIONES METODO orderStringBoolean() --> 
     *         
     *             1. if(w.equals("True") || w.equals("False")){
     *                   throw new MyException("Revisa por favor las mayusculas,
     *                             solo aceptamos true o false  en minusculas");
     *                }   |  
     *             2. Si no coincide w(Input String) con las opciones anteriores
     *                se lanza una excepcion indicandole que no ha insertado 
     *                ninguna de las opciones booleanas, true o false.
     *      
     */
    public static boolean orderStringBoolean() throws MyException {
        // DECLARO E INICIALIZO LAS VARIABLES LOCALES
        String w = orderString("Inserta true o false(Cadena de texto)");
        boolean result = false;
        // CONDICIONES Y LANZAMIENTO "MyExcepcion"
        if (w.equals("true")) {
            result = true;
        }else if(w.equals("false")){
            result = false;
        }else if(w.equals("True") || w.equals("False")){
           throw new MyException("Revisa por favor las mayusculas, solo aceptamos true o false  en minusculas");
        }else{
            throw new MyException("No has insertado ninguna de las opciones booleanas, true o false");
        }
        return result;
    }
}
