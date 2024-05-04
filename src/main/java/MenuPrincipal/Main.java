/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MenuPrincipal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

        Usuario u = new Usuario("Jorge", "1234", "ejemplo@gmail.com", "456789451", true);

        String ruta = "persona.obj";

        try {
            File n = new File("datosUsuarios.txt");
            fichSalida = new FileOutputStream(n);
            oos = new ObjectOutputStream(fichSalida);
            oos.writeObject(u);
        } catch (IOException e) {
            System.out.println("Se produjo un error en la apertura o escritura en el fichero");
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                if (fichSalida != null) {
                    fichSalida.close();
                }
            } catch (IOException e) {
                System.out.println("No consiguio cerrar el fichero correctamente");
            }

            System.out.println("Se leyó el objeto persona con los datos: " + u.toString());

            try {
                FileInputStream fis = new FileInputStream("datosUsuarios.txt");
                ObjectInputStream uobj = new ObjectInputStream(fis);

                Usuario user = (Usuario) uobj.readObject();

                System.out.println(user);
            } catch (FileNotFoundException ex) {
                System.out.println("Archivo no encontrado");
            } catch (IOException ex) {
                System.out.println("Ha habido un problema con el archivo");
            } catch (ClassNotFoundException ex){
                System.out.println("La clase no ha sido encontrada");
            }
        }
        
    }
}
