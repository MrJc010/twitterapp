package twitterwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//****************Viet Nguyen Code******************

/**
 * Servlet implementation class OutputFile
 */
@WebServlet("/GetTweet")
public class GetTweet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetTweet() {
		super();
		// TODO Auto-generated constructor stub
	}

	//****************Viet Nguyen, Minh Ngo Code******************
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();

		StringBuilder result = new StringBuilder();
		result.append(Manager.twitterAPI.getUserName());

		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\">");
		out.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.println("<title>CMPE172</title>");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
		out.println("<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.1.0/css/all.css\" integrity=\"sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt\" crossorigin=\"anonymous\">");
		out.println("<style type=\"text/css\">");
		out.println(".custom {width: 78px !important; margin-top:20px; }");
		out.println(".panel.blue { background-color: blue }");
		out.println(".panel.green { background-color: green }");
		out.println(".server-action-menu {background-color: transparent;background-image: linear-gradient(to bottom, rgba(30, 87, 153, 0.2) 0%, rgba(125, 185, 232, 0) 100%);background-repeat: repeat;border-radius:10px;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("<div class=\"jumbotron\">");
		out.println("<h1 style=\"color:rgb(29, 161, 242)\"><i class=\"fab fa-twitter\"></i>Twitter App for 172</h1>");
		out.println("<form>");
		out.println("<p style=\"color:rgb(29, 161, 242)\"><output form=\"numform\" type=\"body\" name=\"x\" for=\"a b\">Account Name</output></p>");
		out.println("<input type=\"button\" class=\"btn btn-info btn-xs\" style=\"background-color:rgb(29, 161, 242)\" value=\"Get Account Name\" onclick=\"window.location.href='http://localhost:8080/twitterwebapp/GetUserName'\" />");
		out.println("</form>");
		out.println("</div>");
		out.println("<div class=\"container-fluid\">");
		out.println("<h4 align=\"center\" style=\"color:rgb(29, 161, 242)\"> <strong>Get your Tweet, Followers and Trend</strong></h4>");
		out.println("<div class=\"row server-action-menu\">");
		out.println("<form>");
		out.println("<div class=\"col-xs-1\">");
		out.println("<input type=\"button\" class=\"btn btn-info btn-xs custom\" value=\"Get Tweet\" onclick=\"window.location.href='http://localhost:8080/twitterwebapp/GetTweet'\" />");
		out.println("</div>	");
		out.println("<div class=\"col-xs-2\" style=\"border-width: 20px\">");
		out.println("<br>");
		out.println(Manager.twitterAPI.getTweet());
		out.println("</div>");
		out.println("</form>");
		out.println("<div class=\"col-xs-1\">");
		out.println("</div>");
		out.println("<form>");
		out.println("<div class=\"col-xs-1\">	");
		out.println("<input type=\"button\" class=\"btn btn-info btn-xs custom\" value=\"Get Follower\" onclick=\"window.location.href='http://localhost:8080/twitterwebapp/GetFollower'\" />");
		out.println("</div>	");
		out.println("<div class=\"col-xs-2\">");
		out.println("<br>");
		out.println("<output  type=\"body\">Get Followers</output>");
		out.println("</div>");
		out.println("</form>");
		out.println("<div class=\"col-xs-1\">");
		out.println("</div>");
		out.println("<form>");
		out.println("<div class=\"col-xs-1\">");
		out.println("<input type=\"button\" class=\"btn btn-info btn-xs custom\" value=\"Get Trend\" onclick=\"window.location.href='http://localhost:8080/twitterwebapp/GetTrends'\" />");
		out.println("</div>	");
		out.println("<div class=\"col-xs-2\">");
		out.println("<br>");
		out.println("<output type=\"body\">Get Trend</output>");
		out.println("</div>");
		out.println("</form>");
		out.println("</div>");
		out.println("<br>");
		out.println("<br>");
		out.println("<h4 align=\"center\" style=\"color:rgb(29, 161, 242)\"> <strong>Get a Tweet and Find a Tweet</strong></h4>");
		out.println("<div class=\"row server-action-menu\">");
		out.println("<form method=\"POST\" action=\"PostTweet\">");
		out.println("<div class=\"col-xs-3\">");
		out.println("<textarea class=\"form-control\" rows=\"3\" placeholder=\"Post a tweet...\" name=\"PostT\"></textarea>");
		out.println("<br>");
		out.println("<input class=\"btn btn-info btn-xs custom\" value=\"Post\" type=\"submit\">");
		out.println("</div>");
		out.println("<div class=\"col-xs-3\">");
		out.println("<output type=\"body\">Nothing post yet</output>");
		out.println("</div>");
		out.println("</form>");
		out.println("<form method=\"POST\" action=\"FindTweet\">");
		out.println("<div class=\"col-xs-3\">");
		out.println("<textarea class=\"form-control\" rows=\"3\" placeholder=\"Find a tweet...\" name=\"FindT\"></textarea>");
		out.println("<br>");
		out.println("<input class=\"btn btn-info btn-xs custom\" type=\"submit\" value=\"Find\">");
		out.println("</div>");
		out.println("<div class=\"col-xs-3\">");
		out.println("<output type=\"body\">Nothing found yet</output>");
		out.println("</div>	");
		out.println("</form>	");
		out.println("</div>");
		out.println("<br>");
		out.println("<br>");
		out.println("<h4 align=\"center\" style=\"color:rgb(29, 161, 242)\"> <strong>Send a message and login to different account</strong></h4>");
		out.println("<div class=\"row server-action-menu\">");
		out.println("<form method=\"POST\" action=\"Message\">");
		out.println("<div class=\"col-xs-3\">");
		out.println("<textarea class=\"form-control\" rows=\"1\" cols=\"10\" placeholder=\"User name\" name=\"SendU\"></textarea>");
		out.println("<br>");
		out.println("<textarea class=\"form-control\" rows=\"3\" placeholder=\"Message Body..\" name=\"SendM\"></textarea>");
		out.println("<br>");
		out.println("<input class=\"btn btn-info btn-xs custom\" value=\"Send\" type=\"submit\">");
		out.println("</div>");
		out.println("</form>");
		out.println("<div class=\"col-xs-3\">	");
		out.println("<output type=\"body\">Nothing send yet!</output>	");
		out.println("</div>");
		out.println("<form method=\"post\" action=\"SetKey\">");
		out.println("<div class=\"row server-action-menu\">");
		out.println("<div class=\"col-xs-6\">");
		out.println("<div class=\"form-group\">");
		out.println("<input type=\"password\" class=\"form-control\" rows=\"2\" cols=\"3\" placeholder=\"API Key\" name=\"apiKeyT\"></textarea>");
		out.println("<br>");
		out.println("<input type=\"password\" class=\"form-control\" id=\"apiSecretKey\" rows=\"2\" placeholder=\"API Secret Key\" name=\"out.println(\"apiKeySeT\"></textarea>");
		out.println("<br>");
		out.println("<input type=\"password\" class=\"form-control\" id=\"accessToken\" rows=\"3\" placeholder=\"Access Token\" name=\"accessT\"></textarea>");
		out.println("<br>");
		out.println("<input type=\"password\" class=\"form-control\" id=\"accessTokenScecret\" rows=\"2\" placeholder=\"Access Token Secret\" name=\"accessSeT\"></textarea>");
		out.println("<br>");
		out.println("<input class=\"btn btn-info btn-xs\" type=\"submit\" value=\"Set Twitter Key\"/>");
		out.println("</div>");
		out.println("</div>");
		out.println("</div>");
		out.println("</form>	");
		out.println("</div>");
		out.println("<br>");
		out.println("</div>	");
		out.println("</div>");
		out.println("</div>");
		out.println("<script src=\"js/jquery.min.js\"></script>");
		out.println("<script src=\"js/bootstrap.min.js\"></script>");
		out.println("<script src=\"js/scripts.js\"></script>");
		out.println("</body>");
		out.println("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
