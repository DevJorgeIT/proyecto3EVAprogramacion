/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestores;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import modelos.Usuario;

/**
 *
 * @author AluDAM
 */
public class GestorFicheros {

    FileOutputStream fichSalida = null;
    ObjectOutputStream oos = null;
    FileInputStream fichEntrada = null;
    ObjectInputStream ois = null;

    Usuario u = new Usuario("crisbar","1111","crisbar@cris.com","666888777", false);
   
    String ruta = "usuarios.txt";

    
        try {
            fichSalida = new FileOutputStream(ruta);
        oos = new ObjectOutputStream(fichSalida);
        oos.writeObject(p);
    }
    catch (IOException e

    
        ) {
            System.out.println("Se produjo un error en la apertura o escritura en el fichero");
    }

    
        finally{
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

        System.out.println("Se leyó el objeto persona con los datos: " + p.toString());

        try {
            FileInputStream fis = new FileInputStream("ruta");
            ObjectInputStream pobj = new ObjectInputStream(fis);

            Persona pe = (Persona) pobj.readObject();

            System.out.println(pe);
        } catch (Exception e) {
        }

    }
