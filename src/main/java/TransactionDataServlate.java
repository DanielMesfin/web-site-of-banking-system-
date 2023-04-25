
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TransactionDataServlate
 */
@WebServlet("/TransactionDataServlate")
public class TransactionDataServlate extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public TransactionDataServlate() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     	PrintWriter out=response.getWriter();
	        String  account = (String)request.getSession().getAttribute("accountNumber");
		    String  tType = request.getParameter("tType");
	    	Double amount = Double.parseDouble(request.getParameter("amountOfMoney"));
	    	if(! tType.equals("") && !amount.isNaN()) {
            Transacton transacton= new Transacton(account, tType, amount);
         // data base class 
    		EthioBankDataBasee ethioBankDataBasee= new EthioBankDataBasee();
    	// create deposit for the level way for them 
    		
    		if(tType.equals("Deposit")) {
    			boolean depositeState=ethioBankDataBasee.saveData(account);
    			String trans="";
    			if(depositeState) {
    			// for depositing money
        			trans=ethioBankDataBasee.transactionCredit(transacton);
    			}else {
    			trans=	ethioBankDataBasee.transactionDeposit(transacton);
    			}
    	    	
    		    response.setContentType("text/html");
    		    Double totalBalance=ethioBankDataBasee.balanceChack();
    		    String userN=ethioBankDataBasee.userName(account);
    	    	if(trans.equals("Excuted")){
    		    	out.println("<html lang=\"en\">");
    		    	out.println("<head>");
    		    	out.println("</head>");
    		    	out.println("<body bgcolor=pink>");
    		    	out.println("<center>");
    		    	out.println("<h1> Ethio Bank</h1>");
    		    	out.println("<center>");
    		    	out.println("<h3> Your Transaction is Cometid By The Following Inforamtion<h3>");
    		    	out.println("<table><tr><td><h3>Account User :</td><td></h3><h3>"+userN+"</h3></td></tr>");
    		    	out.println("<tr><td><h3>Account Number :</td><td></h3><h3>"+account+"</h3></td></tr>");
    		    	out.println("<tr><td><h3>Transaction Type :</td><td></h3><h3>"+tType+"</h3></td></tr>");
    		    	out.println("<tr><td><h3> Amount Credited:</td><td></h3><h3>"+amount+" ETB</h3></td></tr>");
    		    	out.println("<tr><td><h3> Balance :</td><td></h3><h3>"+totalBalance+"ETB</h3></td></tr></table>");
    		    	out.println(" <p>We are glad for your choose Thank you</p>");
    		    	out.println("<button  class=\"cancel\" type=\"reset\">Print</button>\r\n");
    		    	out.println("</body>");
    		    	out.println("</html >");
    	           }else {
    	    		response.getWriter().append(trans);
    	    	}	    	
    		}
    		
    		if(tType.equals("Withdrawal")) {
    			// for with withdrawal
    			String withdrawal =	ethioBankDataBasee.transactionWithdrawal(transacton);
    			Double balanceSenn=ethioBankDataBasee.balanceChack();
    			String  user=ethioBankDataBasee.userName(account);
    	    //	PrintWriter out=response.getWriter();
    		    response.setContentType("text/html");
    		    //System.out.print(withdrawal);
    	    	if(withdrawal.equals("yes")){
    		    	out.println("<html lang=\"en\">");
    		    	out.println("<head>");
    		    	out.println("</head>");
    		    	out.println("<body bgcolor=pink>");
    		    	out.println("<center>");
    		    	out.println("<h1> Ethio Bank</h1>");
    		    	out.println("<center>");
    		    	out.println("<h3> Your Transaction is Cometid By The Following Inforamtion<h3>");
    		    	out.println("<table><tr><td><h3>Account User :</td><td></h3><h3>"+user+"</h3></td></tr>");
    		    	out.println("<tr><td><h3>Account Number :</td><td></h3><h3>"+account+"</h3></td></tr>");
    		    	out.println("<tr><td><h3>Transaction Type :</td><td></h3><h3>"+tType+"</h3></td></tr>");
    		    	out.println("<tr><td><h3> Amount Debited :</td><td></h3><h3>"+amount+"ETB</h3></td></tr>");
    		    	out.println("<tr><td><h3>Total Balance :</td><td></h3><h3>"+balanceSenn+"ETB</h3></td></tr></table>");
    		    	out.println(" <p>We are glad for your choose Thank you</p>");
    		    	out.println("<button  class=\"cancel\" type=\"reset\">Print</button>\r\n");
    		    	out.println("</body>");
    		    	out.println("</html >");
    	           }else {
    	    		    	out.println("<html lang=\"en\">");
    	    		    	out.println("<head>");
    	    		    	out.println("</head>");
    	    		    	out.println("<body bgcolor=pink>");
    	    		    	out.println("<center>");
    	    		    	out.println("<h1> Ethio Bank</h1>");
    	    		    	out.println("<center>");
    	    		    	out.println("<h3  style='color:red'> Your Transaction is Not Cometid By The Following Inforamtion<h3>");
    	    		    	out.println("<table><tr><td><h3>Account User :</td><td></h3><h3>"+user+"</h3></td></tr>");
    	    		    	out.println("<tr><td><h3>Account Number :</td><td></h3><h3>"+account+"</h3></td></tr>");
    	    		    	out.println("<tr><td><h3>Transaction Type :</td><td></h3><h3>"+tType+"</h3></td></tr>");
    	    		    	out.println("<tr><td><h3 style='color:red'> Amount Debited :</td><td></h3><h3>"+amount+"ETB</h3></td></tr>");
    	    		    	out.println("<tr><td><h3>Total Balance :</td><td></h3><h3>"+balanceSenn+"ETB</h3></td></tr>");
    	    		    	out.println("<tr><td><h3  style='color:red'> Total Balance :</td><td></h3><h3>"+balanceSenn+"ETB is less than current request "+amount+"ETB</h3></td></tr></table> " );
    	    		    	out.println(" <p>We are glad for your choose Thank you</p>");
    	    		    	out.println("<button  class=\"cancel\" type=\"reset\">Print</button>\r\n");
    	    		    	out.println("</body>");
    	    		    	out.println("</html >");
    	    	}	    	
    		}
    		if(tType.equals("Transfare")) {
    			String transfare =	ethioBankDataBasee.transactionDeposit(transacton);
    	    	//PrintWriter out=response.getWriter();
    		       String  accountlog = (String)request.getSession().getAttribute("accountNumber");

//    			 response.sendRedirect("Transaction.jsp");
  		    response.setContentType("text/html");
 	    	if(transfare.equals("Excuted")){
    		    	out.println("<html lang=\"en\">");
    		    	out.println("<head>");
    		    	out.println("</head>");
    		    	out.println("<body bgcolor=pink>");
    		    	out.println("<center>");
    		    	out.println("<h1> Ethio Bank<h1>");
    		    	out.println("<center>");
    		    	out.println("<h3> Your Transaction is Cometid By The Following Inforamtion<h3>");
    		    	out.println("<table><tr><td><h3>Account Number :</td><td></h3><h3>"+account+"</h3></td></tr>");
    		    	out.println("<tr><td><h3>Transaction Type : </td><td></h3><h3>"+tType+"</h3></td></tr>");
    		    	out.println("<tr><td><h3>Amount : </td><td></h3><h3>"+amount+"</h3></td></tr>");
    		    	out.print("<tr><td><h3>Account Number :</td><td></h3><h3><form action='TransationDataServlate.java' method='post'><input type='number' placeholder='Enter Your Account Number To Transfare  :' name ='aNumber'></h3></td></tr>");
    		    	out.println("<tr><td><h3>Balance :ETB</td><td></h3><h3></h3></td></tr></table>");
    		    	out.println("<button  class='cancel' type='reset'>Transfare</button></form>");
    		    	out.println(" <p>We are glad for your choose Thank you</p>");
    		    	out.println("</body>");
    		    	out.println("</html >");
    		    	
    	           }else {
    	    		response.getWriter().append(transfare);
    	    	}	    	
    		}
    	}
else {	out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("</head>");
            out.println("<body bgcolor=pink>");
            out.println("<center>");
            out.println("<h1> Ethio Bank</h1>");
            out.println("<center>");
             out.println("<h3> Please Fill All The Information Correctly<h3>");
             out.println(" <p>We are glad for your choose Thank you</p>");
            out.println("</body>");
           out.println("</html >");
}
}
}
