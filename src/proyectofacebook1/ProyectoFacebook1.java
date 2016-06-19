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
                + " Ver usuario conectado \n 2. Publicar un estado \n 3.Buscar un tema\n"
                + "4. Comentar una publicacion\n 5. Darle me gusta a una publicacion\n 6.Imprimir los comentarios"
                + "de una publicacion\n 6. Postear una foto"));

        switch (opcion) {
            case 1:
                metodosFace.user();
                break;
            case 2:
                metodosFace.publicar();
                break;
            case 3:
                metodosFace.buscarTema();
                break;
            case 4:
                metodosFace.comentarEstado();
                break;
            case 5:
                metodosFace.likePost();
                break;
            case 6:
                metodosFace.comentariosPost();
                break;
            case 7:
                metodosFace.subirFoto();
                break;
            case 8:
                System.exit(0);

        }

    }
}
