package web;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class CountServlet
 *
 */
@WebListener
public class CountServlet implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public CountServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	HttpSession session = se.getSession();
    	ServletContext sc = session.getServletContext();
    	Integer count = (Integer)sc.getAttribute("count");
    	if(count == null){
    		count = 1;
    	}else{
    		count ++;
    	}
    	sc.setAttribute("count", count);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	HttpSession session = se.getSession();
    	ServletContext sc = session.getServletContext();
    	Integer count = (Integer)sc.getAttribute("count");
    	if(count == null){
    		count = 0;
    	}else{
    		count --;
    	}
    	sc.setAttribute("count", count);
    }
	
}
