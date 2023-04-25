

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateAccount
 */
@WebServlet("/CreateAccount")
public class CreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CreateAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fullName =request.getParameter("fullName");
		String accountNumber=request.getParameter("accountNumber");
		Double intialDeposit = Double.parseDouble(request.getParameter("deposit"));
		String phoneNumber = request.getParameter("phoneNumber");
		String password =request.getParameter("password");
		String cpassword=request.getParameter("cPassword");
		
			if(! fullName.isEmpty()&& !accountNumber.isEmpty()&&! intialDeposit.isNaN()&&! phoneNumber.isEmpty()) {
				if(password.equals(cpassword)) {
				// call the constractor  of user information to provide user information;
				UserInformation information = new UserInformation( fullName, accountNumber,  phoneNumber,intialDeposit,password,cpassword); 		
				EthioBankDataBasee ebdb=new EthioBankDataBasee();
				String result=ebdb.insert(information);
				// to display the result to the browers 
				
				PrintWriter out=response.getWriter();
		    	out.println("<html lang=\"en\">");
		    	out.println("<head>");
		    	out.println("</head>");
		    	out.println("<body bgcolor=pink>");
		    	out.println("<center>");
		    	out.println("<h1> Ethio Bank</h1>");
		    	response.getWriter().println("<h1>"+result+"<h1>");	
		    	out.println("<center>");
		    	out.println("<table><tr><td><h3>Full Name:</td><td></h3><h3>"+information.getFullName()+"</h3></td></tr>");
		    	out.println("<tr><td><h3>Account Number :</td><td></h3><h3>"+information.getAccountNumber()+"</h3></td></tr>");
		    	out.println("<tr><td><h3> Phone Number :</td><td></h3><h3>"+information.getPhoneNumber()+"</h3></td></tr>");
		    	out.println("<tr><td><h3> Capital  :</td><td></h3><h3>"+information.getIntialDeposit()+"</h3></td></tr></table>");
		    	out.println(" <p>We are glad for your choose Thank you</p>");
		    	out.println("<button  class='cancel' type='reset'>Back</button>");
		    	out.println("</body>");
		    	out.println("</html >");
				//response.getWriter().append("Full Name :"+information.getFullName()+"<br/> Your Account :"+information.getAccountNumber()+"</br> Your Phone Number "+information.getPhoneNumber());
			}else {
		    	response.getWriter().println("<h1>Your Password Is Not Confrmed Please Check Your Password <h1>");		
			}
			}else {
		    	response.getWriter().println("<h1> Please  Fill The Form All Properly <h1>");		

		}
	}

}
