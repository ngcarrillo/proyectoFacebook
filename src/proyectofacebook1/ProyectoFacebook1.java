/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofacebook1;

import javax.swing.JOptionPane;

/**
 *
 * @author nuria
 */
public class ProyectoFacebook1 {

   
    public static void main(String[] args) {
    metodos metodosFace = new metodos();
    metodosFace.conectar();
    int opcion = Integer.parseInt(JOptionPane.showInputDialog("Elija que hacer:\n 1."
            + " Ver usuario conectado \n 2. Publicar un estado \n 3.Buscar una persona\n"
            + "4. Comentar una publicacion\n 5. Darle me gusta a una publicacion"));

    switch (opcion) {
                case 1:
                    metodosFace.user();
                    break;
                case 2:
                    metodosFace.publicar();
                    break;
                case 3:
                    metodosFace.buscarPersonas();
                    break;
                case 4:
                    metodosFace.comentarEstado();
                    break;
                case 5:
                    metodosFace.likePost();
                    break;
                case 6:
                    System.exit(0);
              
                    
                            }
    
    
    }
    
}
