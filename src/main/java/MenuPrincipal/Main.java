/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MenuPrincipal;

import excepciones.MyException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Usuario;

/**
 *
 * @author AluDAM
 */
public class Main {

    public static void main(String[] args) {
        FileOutputStream fichSalida = null;
        ObjectOutputStream oos = null;
        FileInputStream fichEntrada = null;
        ObjectInputStream ois = null;
        
        String ruta = "persona.obj";
        Usuario u1 = null;
        Usuario u2 = null;
        Usuario u3 = null;
        Usuario user = null;
        int cont = 0;
        

        try {
            u1 = new Usuario("crisbar", "1111", "crisbar@cris.com", "666888777", false);
            u2 = new Usuario("juan", "2222", "juan@correo.com", "777444888", true);
            u3 = new Usuario("eva", "3333", "eva@correo.com", "754874547", true);
             
            File n = new File("datosUsuarios.txt");
            fichSalida = new FileOutputStream(n);
            oos = new ObjectOutputStream(fichSalida);
            oos.writeObject(u1);
            oos.writeObject(u2);
            oos.writeObject(u3);
            
        } catch (IOException e) {
            System.out.println("Se produjo un error en la apertura o escritura en el fichero");
        }catch (MyException ex){
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                    System.out.println("oos se ha cerrado satisfactoriamente");
                }
                if (fichSalida != null) {
                    fichSalida.close();
                }
            } catch (IOException e) {
                System.out.println("No consiguio cerrar el fichero correctamente");
            }

            //System.out.println("Se leyó el objeto persona con los datos: " + u1.toString());

            try {
                File n = new File("datosUsuarios.txt");
                if (n.exists()) {
                    if (n.isDirectory()) {
                        System.out.println("El archivo existe y es un directorio");
                    }
                    if (n.isFile()) {
                        System.out.println("El archivo existe y es un fichero");
                    }
                }
                
                FileInputStream fis = new FileInputStream(n);
                
                ois = new ObjectInputStream(fis);
                while (ois != null) { 
                   user = (Usuario) ois.readObject();
                   System.out.println(user + "\n");
                   cont++;
                }

            } catch (FileNotFoundException ex) {
                System.out.println("Archivo no encontrado");
            } catch (IOException ex) {
                 if (cont > 0) {
                    System.out.println("Se han leido los usuarios y datos de cada usuario del archivo de forma satisfactoria, ya no hay mas usuarios por leer");
                }else{
                     System.out.println("Ha habido un problema con el archivo");
                 }
                
            } catch (ClassNotFoundException ex){
                System.out.println("La clase no ha sido encontrada");
            }finally{
                try {
                    if (ois != null) {
                        ois.close();
                    }
                    if (fichEntrada != null) {
                        fichEntrada.close();
                    }
                } catch (IOException eX) {
                    System.out.println("No se consiguio cerrar el fichero de entrada correctamente");
                }
            }
        }
        
   }
}
