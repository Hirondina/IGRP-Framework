package nosi.core.webapp;

import nosi.core.servlet.IgrpServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import nosi.core.dao.IgrpDb;

/**
 * @author Marcel Iekiny
 * Apr 14, 2017
 */
public class Igrp {
	
	private static Igrp app;
	
	private IgrpServlet servlet; // Refer to HttpServlet
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private Controller controller; // Representa instancia de um controller da qual foi feito request ...
	
	private String currentAppName;
	private String currentPageName;
	private String currentActionName;
	
	// Others Web Application Components
	// Db component
	private IgrpDb igrpDb;

	/**/
	
	private Igrp(){
	}
	
	public static Igrp getInstance(){ // Permite definir a classe Igrp como um Singleton
		if(Igrp.app == null){
			Igrp.app = new Igrp();
		}
	return Igrp.app;
	}
	
	// Inicializa os componentes da web app
	public Igrp init(IgrpServlet servlet, HttpServletRequest request, HttpServletResponse response){
			this.servlet = servlet;
			this.request = request;
			this.response = response;
			// init of others configuration
			//this.igrpDb = new IgrpDb("igrp", "root", "").newConnection("");
		return this;
	}
	
	public void run() throws IOException{ // run the web app 
		this.resolveRoute(); // (1)
		//this.runAction(); // (2)
		//this.exit(); // (3)
	}
	
	private void exit(){ // Destroy todos os componentes da applica��o
		
	}
	
	private void resolveRoute() throws IOException{
		String r = this.request.getParameter("r");// Captura sempre o primeiro "r" parameter no query string
		if(r != null && r.matches("[a-z]{2,255}/[a-z]{2,255}/[a-z]{2,255}")){
			String []aux = r.split("/");
			this.currentAppName = aux[0];
			this.currentPageName = aux[1];
			this.currentActionName = aux[2];
			
			if(this.validateAppName() && this.validatePageName() && this.validateActionName()){
				
			}
		}else{
			// Lan�ar excepcao do tipo 404
		}
	}
	
	private boolean validateAppName(){
		return true;
	}
	
	private boolean validatePageName(){
		return true;
	}
	
	private boolean validateActionName(){
		return true;
	}
	
	private void runAction(){ // run a action in the specific controller
		String auxControllerName = this.currentPageName.substring(0, 1).toUpperCase() + this.currentPageName.substring(1) + "Controller";
		String auxActionName = "action" + this.currentActionName.substring(0, 1).toUpperCase() + this.currentActionName.substring(1);
		String controllerPath = "nosi.webapps." + this.currentAppName + ".pages." + this.currentPageName + "." + auxControllerName;
		try {
			Class c = Class.forName(controllerPath);
			Object controller = c.newInstance();
			Method action = c.getMethod(auxActionName, null);
			action.invoke(controller, null);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public IgrpDb getDao(){
		return this.igrpDb;
	}
	
	public static void main(String []args){
		//Igrp.getInstance().runAction();
	}
	
}