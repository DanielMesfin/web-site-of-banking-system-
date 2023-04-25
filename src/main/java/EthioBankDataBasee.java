import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.mysql.cj.QueryReturnType;

public class EthioBankDataBasee {
	
		  final String DB_URL = "jdbc:mysql://localhost:3306/EBDB";
		  final String USERNAME = "root";
	      final String PASSWORD = "";
	      final String DRIVER="com.mysql.cj.jdbc.Driver";
	      double balanceCheck=0.0;
	      String userName="";
	      // 1, for loading driver
	      public void loadDriver(String driver){
	    	 try { Class.forName(driver);}catch (ClassNotFoundException e) {
			}
	      }
	      //2, function for connection 
	       public  Connection getConnection() {
	    	 //  loadDriver(DRIVER);
	    	Connection conn=null;
	    	try {
				conn=DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	    	return conn;
	      }
	      //3 function for creating new  user
	       public String insert(UserInformation user) {
	    	   loadDriver(DRIVER);
	    	   String result="Your Account is Created With The Following information";
	    	   Connection conn= getConnection();
		       String sql = "INSERT INTO usersInformation (FullName, Account, PhoneNumber, IntialDeposite, password) " + "VALUES (?, ?, ?, ?, ?)";
		         try {
		        	 PreparedStatement preparedStatement = conn.prepareStatement(sql);
			          preparedStatement.setString(1, user.getFullName());
			          preparedStatement.setString(2, user.getAccountNumber());
			          preparedStatement.setString(3, user.getPhoneNumber());
			          preparedStatement.setDouble(4, user.getIntialDeposit());
			          preparedStatement.setString(5, user.getPassword());
			          int addedRows = preparedStatement.executeUpdate();
				} catch (Exception e) {
					// TODO: handle exception
					result="Your Account is Not Created";
				}
	    	   return result;
	       }
	       //3 for chacking user authontication;
	    public String logIn(Login logobj){	    	
	    	String accountId=logobj.getAccountN();
	    	String passwordId=logobj.getPasswordN();
	    	String logInTo = null;
	    	try {
		    	String sqli ="SELECT  Account,password FROM usersinformation WHERE Account='"+accountId+"' and password ='"+passwordId+"'";
				loadDriver(DRIVER);
		    	Connection conn= getConnection();	
				Statement statement =conn.createStatement();
				ResultSet resultSet =statement.executeQuery(sqli);
				if(resultSet.next()){			
					logInTo="loged";
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
			return logInTo;
	    }
	      // 4, function for new transaction  user
	       public String transactionDeposit(Transacton transacton) {
	    	   loadDriver(DRIVER);
	    	   String result="Excuted";
	    	   Connection conn= getConnection();
		       String sql = "INSERT INTO transacton (tId, Account,tType,Balance, Date) " + "VALUES (?, ?, ?, ?, ?)";
		         try {
		        	 DateTimeFormatter  date = DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss");
		        	 LocalDateTime  now =LocalDateTime.now();
		        	 String  dateCurrent =date.format(now);
		        	 PreparedStatement preparedStatement = conn.prepareStatement(sql);
			         preparedStatement.setString(1, null);
			          preparedStatement.setString(2, transacton.getAccount());
			          preparedStatement.setString(3, transacton.gettType());
			          preparedStatement.setDouble(4, transacton.getAmount());
			         preparedStatement.setString(5, dateCurrent);
			          int addedRows = preparedStatement.executeUpdate();
			          balanceCheck=transacton.getAmount();
			          result="Excuted";
				} catch (Exception e) {
					// TODO: handle exception
					result="Not Excuted"+e.getMessage();
				}
	    	   return result;
	       }	    
	    // 5, for deposit the amount 
	    public String transactionWithdrawal(Transacton transacton) {
	    	// variable 
		     String result="no";
		     DateTimeFormatter  date = DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss");
        	 LocalDateTime  now =LocalDateTime.now();
        	 String  dateCurrent =date.format(now);
		     // function calling 
	    	 loadDriver(DRIVER);
	    	 Connection conn= getConnection();
		    	try {
			    	String sqli ="SELECT  Balance FROM  transacton WHERE Account='"+transacton.getAccount()+"'";
					Statement statement =conn.createStatement();
					ResultSet resultSet =statement.executeQuery(sqli);
					if(resultSet.next()) {
						balanceCheck=(double)resultSet.getDouble("Balance");		
						}				
				}catch (Exception e) {
					// TODO: handle exception
					result="Your Account Transaction Is Not Completed  at 1"+e.getMessage();
				}
		    	if(balanceCheck>=transacton.getAmount()) {
		    		 try {
		    			 Double newBalance=transacton.getAmount();
		    			 balanceCheck=balanceCheck-newBalance;
					     String sql1= "Update  transacton set tType='"+transacton.gettType()+"',Balance="+balanceCheck+", Date='"+dateCurrent+"' where Account='"+transacton.getAccount()+"'";
			        	Statement statement=conn.createStatement();
			        	statement.executeUpdate(sql1);
				      result="yes";
					} catch (Exception e) {
						// TODO: handle exception
						result="Your Account Transaction Is Not Completed at 2 "+e.getMessage();
					}	
		    	}
	    	return result;
	    }
	    //6, Transfare fomr one to the other account
	    public String transactionTransfared(String account ,Double amount) {
	
	    	try {
	    		loadDriver(DRIVER);
		    	Connection conn= getConnection();			
			} catch (Exception e) {
				// TODO: handle exception
			}
	    	return null;
	    }
	    public Double balanceChack() {
	    	return balanceCheck;
	    }
	    //3 for chacking user authontication;
	    public String userName(String account){	    	
	    	String logInTo = null;
	    	try {
		    	String sqli ="SELECT FullName FROM usersinformation WHERE Account='"+account+"'";
				loadDriver(DRIVER);
		    	Connection conn= getConnection();	
				Statement statement =conn.createStatement();
				ResultSet resultSet =statement.executeQuery(sqli);
				if(resultSet.next()){
					logInTo=resultSet.getString(1);
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
			return logInTo;
	    }
	    // if the account aready have the balance then update the balance and store it ;
	    public String transactionCredit(Transacton transacton) {
	    	// variable 
		     String result="Excuted";
		     DateTimeFormatter  date = DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss");
        	 LocalDateTime  now =LocalDateTime.now();
        	 String  dateCurrent =date.format(now);
		     // function calling 
	    	 loadDriver(DRIVER);
	    	 Connection conn= getConnection();
		    	try {
			    	String sqli ="SELECT  Balance FROM  transacton WHERE Account='"+transacton.getAccount()+"'";
					Statement statement =conn.createStatement();
					ResultSet resultSet =statement.executeQuery(sqli);
					if(resultSet.next()) {
						balanceCheck=(double)resultSet.getDouble("Balance");		
						}
				}catch (Exception e) {
					// TODO: handle exception
					result="Your Account Transaction Is Not Completed  at 1"+e.getMessage();
				}
		    // to update the raw of table 
		    		 try {
		    			 Double newBalance=transacton.getAmount();
		    			 balanceCheck=balanceCheck+newBalance;
					     String sql1= "Update  transacton set tType='"+transacton.gettType()+"',Balance="+balanceCheck+", Date='"+dateCurrent+"' where Account='"+transacton.getAccount()+"'";
			        	Statement statement=conn.createStatement();
			        	statement.executeUpdate(sql1);
				      result="Excuted";
					} catch (Exception e) {
						// TODO: handle exception
						result="Not Excuted "+e.getMessage();
					}	
	    	return result;
	    }
	   public boolean  saveData(String account) {
		   boolean saved=false;
		   loadDriver(DRIVER);
	    	 Connection conn= getConnection();
		    	try {
			    	String sqli ="SELECT  Account FROM  transacton WHERE Account='"+account+"'";
					Statement statement =conn.createStatement();
					ResultSet resultSet =statement.executeQuery(sqli);
					if(resultSet.next()) {
						saved=true;
						}
				}catch (Exception e) {
					// TODO: handle exception
					saved=false;
				}
		   return saved;
	   }
}


