/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofacebook1;

import facebook4j.*;
import facebook4j.Comment;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.ResponseList;
import facebook4j.User;
import facebook4j.auth.AccessToken;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.standard.Media;
import javax.swing.JOptionPane;

/**
 *
 * @author nuria
 */
public class metodos {

    private static String appId = "536452219858978";
    private static String appSecret = "8d8b771f4782383d651989a2227fb255";
    private static String accessToken = "EAAHn5oQA8CIBALQTNGHyGeoZAxGNwoLAqBe6rVt6r2dvxk5H0s0tp6zDvRo3pfz9lFUY2aRq9OUOwOKzCRch73X65MSLjzTM1basszDQ5PmxeZC6CAGx63GQbLNCZCuqsnHBaxAjD9eATcLTu2Tj90JBWMrejhHwthMLDQtgAZDZD";

    /**
     * se instancia un objeto de tipo Facebook
     */
    Facebook facebook = new FacebookFactory().getInstance();

    public void conectar() {
        /**
         * @param appId id de nuestra aplicacion
         * @param appSecret id secreto de nuestra aplicación
         * @param accesToken accesToken de nuestra aplicacion
         *
         */
        facebook.setOAuthAppId(appId, appSecret);
        facebook.setOAuthAccessToken(
                new AccessToken(accessToken, null));
    }

    /**
     * Este método nos permite saber con que usuario estamos conectados
     */
    public void user() {
        try {
            User user = facebook.getMe();
            JOptionPane.showMessageDialog(null, "estas conectado con el user " + user.getName());
        } catch (FacebookException ex) {
            Logger.getLogger(ProyectoFacebook1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * publicar un POST
     *
     */
    public void publicar() {
        /**
         * @param estado
         */
        String estado = JOptionPane.showInputDialog("¿Que estás pensando?");
        try {
            facebook.postStatusMessage(estado);
        } catch (FacebookException ex) {
            Logger.getLogger(metodos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void buscarTema() {
        /**
         * @param resultado guarda los nombres que se han buscado
         * @param tema nombre que deseas buscar
         *
         */
        try {
            String resultado = "";
            String tema = JOptionPane.showInputDialog("Introduce el nombre de la persona a buscar");
            User userB = null;
            ResponseList<User> results = facebook.searchUsers(tema);
            for (int i = 0; i < results.size(); i++) {
                userB = results.get(i);
                System.out.println(userB.getName());
                resultado = resultado + (results.get(i).getName());
            }
        } catch (FacebookException ex) {
            Logger.getLogger(metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * comentar un POST
     */
    public void comentarEstado() {
        /**
         * @param IdPost id del post que se quiere comentar
         * @param comentario compentario que se quiere publicar
         */
        try {
            String IdPost = JOptionPane.showInputDialog("Introduce el ID del post");
            String comentario = JOptionPane.showInputDialog("Introduce el comentario");
            facebook.commentPost(IdPost, comentario);
            JOptionPane.showMessageDialog(null, "Has comentado el estado");
        } catch (FacebookException ex) {
            Logger.getLogger(metodos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Darle un LIKE a un POST
     */
    public void likePost() {
        /**
         * @param postid Id del post al que se quiere dar me gusta
         */
        try {
            String postid = JOptionPane.showInputDialog("Introduce el ID del post");
            facebook.likePost(postid);

        } catch (FacebookException ex) {
            Logger.getLogger(metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * imprime los comentarios que tenga un Post
     */
    public void comentariosPost() {
        String idPost = JOptionPane.showInputDialog("Introduce el ID del post");
        ResponseList<Comment> comments = Facebook.getPostComments(idPost);;
        for (int i = 0; i < comments.size(); i++) {
            Comment mensaje = comments.get(i);
            System.out.println(mensaje.getMessage());
        }
    }
    /**
     * Postear una imagen
     */
    public void subirFoto() {
        try {
            String url = JOptionPane.showInputDialog("Introduce la URL de la imagen a postear");
            facebook.postLink(new URL(url));
        } catch (MalformedURLException ex) {
            Logger.getLogger(metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
