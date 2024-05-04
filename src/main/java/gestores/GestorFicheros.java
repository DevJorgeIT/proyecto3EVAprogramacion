/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestores;



import excepciones.MyException;
import java.io.FileInputStream;
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
public class GestorFicheros {
        FileOutputStream fichSalida = null;
        ObjectOutputStream oos = null;
        FileInputStream fichEntrada = null;
        ObjectInputStream ois= null;
        
        Usuario u = new Usuario("Jorge","1234","ejemplo@gmail.com","456789451", true);
        
        String ruta = "persona.obj";
        
}
