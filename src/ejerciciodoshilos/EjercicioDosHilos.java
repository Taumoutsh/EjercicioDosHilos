/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciodoshilos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Tomoutch
 */
public class EjercicioDosHilos {

    //Utilisation Collections synchronizedList parce que ArrayList ne supporte pas changement simultanés
    private static List<Integer> lista = Collections.synchronizedList(new ArrayList<Integer>());
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

        
        Thread tInsert = new Thread(new Runnable() {
                 
            @Override
            public void run(){
                
                while(true){
                    lista.add(5);
                    System.out.println("Añadido 5 - "+lista);
                }
                
            }
                          
        });
        
        tInsert.start();
        
        Thread tRemove = new Thread(new Runnable() {
                 
            @Override
            public void run(){
                
                while(true){
                    
                   if(!lista.isEmpty())
                    lista.remove(0);
                    System.out.println("Eliminado - "+lista); 
                }
                
            }
                          
        });
                
        tRemove.start();
        
    }
    
}
