
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HomePage")
public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public HomePage() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	       String  account = (String)request.getSession().getAttribute("accountNumber");
	       Double accounnt=(Double)request.getSession().getAttribute("amount");
		// sendRedarect for home page to collect data form user 
        response.sendRedirect("/EthioBank/Componet/home.html");
	}

}
