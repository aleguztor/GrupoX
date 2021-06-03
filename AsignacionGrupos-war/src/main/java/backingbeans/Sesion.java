package backingbeans;
import java.util.Enumeration;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
public class Sesion {

	 private static HttpSession httpSession;
	    private static Boolean sesionActiva;
	 
	    public static void iniciarSesion(FacesContext fc) {
	        httpSession = (HttpSession) fc.getExternalContext().getSession(false);
	    }
	 
	   
	    public static void setDatosSesion(String nomObjeto, Object objeto) {
	        try {
	            if (httpSession.getId() != null && !httpSession.getId().isEmpty()) {
	                sesionActiva = true;
	                httpSession.setAttribute(nomObjeto, objeto);
	                httpSession.setAttribute("sesionActiva", sesionActiva);
	            } else {
	                sesionActiva = false;
	                httpSession.setAttribute("sesionActiva", sesionActiva);
	                throw new Exception("Error en el inicio de sesión");
	            }
	        } catch (Exception e) {
	            httpSession.invalidate();
	            e.printStackTrace();
	        }
	    }
	 
	    /**
	     * Método encargado de cerrar una sesión actual.
	     *
	     * @author Adrian Francisco Becerra Arias - shogunato184@gmail.com
	     * @since 2017-06-01
	     */
	    public static void cerrarSesion() {
	        Enumeration<String> atributos = null;
	         
	        try {
	            if (httpSession != null && httpSession.getId() != null && !httpSession.getId().isEmpty()) {
	                sesionActiva = false;
	                 
	                atributos = httpSession.getAttributeNames();
	                 
	                while (atributos.hasMoreElements()) {
	                    String atributo = atributos.nextElement();
	                     
	                    httpSession.removeAttribute(atributo);
	                }
	 
	                httpSession.invalidate();
	            } else {
	                throw new Exception("Error en el cierre de sesión");
	                // TODO Agregar excepciones de sistema
	            }
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
	 
	    /**
	     * Método encargado de iniciar una sesión para el usuario que se está
	     * autenticando en el sistema.
	     *
	     * @author Adrian Francisco Becerra Arias - shogunato184@gmail.com
	     * @since 2017-06-01
	     * @return Object
	     */
	    public static Object getDatosSesion(String dato) {
	        if (httpSession != null && httpSession.getId() != null && !httpSession.getId().isEmpty()) {
	            httpSession.setAttribute("sesionActiva", sesionActiva);
	             
	            return httpSession.getAttribute(dato);
	        } else {
	            return null;
	        }
	    }
	 
	    /**
	     * Método encargado de verificar el estado de una sesión de usuario.
	     *
	     * @author Adrian Francisco Becerra Arias - shogunato184@gmail.com
	     * @since 2017-09-06
	     * @return boolean
	     */
	    public static Boolean getEstadoSesion() {
	        if (httpSession != null 
	        && httpSession.getId() != null 
	        && !httpSession.getId().isEmpty() 
	        && httpSession.getAttribute("sesionActiva") != null) {
	            return Boolean.parseBoolean(httpSession.getAttribute("sesionActiva").toString());
	        } else {
	            return false;
	        }
	    }
}
