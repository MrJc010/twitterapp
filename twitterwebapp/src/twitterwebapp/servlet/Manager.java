package twitterwebapp.servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


//****************Hoa Nguyen Code******************

/**
 * Servlet implementation class OutputFile
 */
@WebServlet("/Manager")
public class Manager extends HttpServlet implements ServletContextListener {


	public void contextInitialized(ServletContextEvent sce) {
		// start the thread
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// stop the thread
	}


	private static final long serialVersionUID = 1L;
	public static TwitterAPI twitterAPI;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("java.net.useSystemProxies", "true");
		StringBuilder result = null;
		try{
			twitterAPI = new TwitterAPI();
		}catch (Exception e){
			result.append(e.toString());
		}

		response.setStatus(HttpServletResponse.SC_FOUND);//302
		response.setHeader("Location", "http://localhost:8080/twitterwebapp/index.html");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
