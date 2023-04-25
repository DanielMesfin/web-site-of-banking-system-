

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogInToAccount
 */
@WebServlet("/LogInToAccount")
public class LogInToAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LogInToAccount() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accountNumber = request.getParameter("aNumber");
		String password= request.getParameter("password");
		// data base class 
		if(! accountNumber.equals("")&& !password.equals("")) {
			EthioBankDataBasee ethioBankDataBasee= new EthioBankDataBasee();
			// instantiate login class 
	    	Login logobj =new Login(accountNumber, password);
	    	// login function form the data base 
			String log=ethioBankDataBasee.logIn(logobj);
			// check the condition 
			if(log=="loged") {
				// using session forward the data from one to other  
		    	request.getSession().setAttribute("accountNumber",logobj.getAccountN());
			    request.getRequestDispatcher("/HomePage").forward(request, response);
			}else {	
				response.getWriter().append("<h1>Invalid Account Number or Password Please Check Out Both <h1>");
				}
		}else {
			response.getWriter().append("<h1> Account Number or Password Must Not Be Empty  <h1>");

		}
		
	}

}
