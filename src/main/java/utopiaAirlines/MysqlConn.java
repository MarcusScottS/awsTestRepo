package utopiaAirlines;

import java.sql.*;
import java.util.Scanner;

public class MysqlConn {

	public static void main(String[] args) {
//      System.out.println("Hello World");
  	final String URL = "jdbc:mysql://localhost:3306/utopia";
  	final String USER = "root";
  	final String PASSWORD = "";
  	
  	int userMenuChoice = 0;

      try {
//          Class.forName("com.mysql.jdbc.Driver");
//          Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
//          Statement statement1 = con.createStatement();
//          ResultSet travelerQuerySelectAll = statement1.executeQuery("select * from tbl_traveler");
//          
//          Statement statement2 = con.createStatement();
//          ResultSet airportQuerySelectAll = statement2.executeQuery("select * from tbl_airport");
//          
//          Statement statement3 = con.createStatement();
//          ResultSet flightQuerySelectAll = statement3.executeQuery("select * from tbl_flight");
          
//          Statement statement4 = con.createStatement();
//          ResultSet seatQuerySelectAll = statement4.executeQuery("select * from tbl_flight");
//          
//          Statement statement5 = con.createStatement();
//          ResultSet bookingQuerySelectAll = statement5.executeQuery("select * from tbl_booking");
//          
//          Statement statement6 = con.createStatement();
//          ResultSet employeeQuerySelectAll = statement6.executeQuery("select * from tbl_users WHERE userRole = 2");
//          
//          Statement statement7 = con.createStatement();
//          ResultSet cancellationsQuerySelectAll = statement7.executeQuery("select * from tbl_booking WHERE isActive = 0");
          
//          ResultSet seatQuerySelectAll = statement.executeQuery("select * from tbl_airport");
          
//          ResultSet ticketQuerySelectAll = statement.executeQuery("select * from tbl_airport");
          
//          ResultSet airportQuerySelectAll = statement.executeQuery("select * from tbl_airport");
          
          
//          ResultSet employeeQuerySelectAll = statement.executeQuery("select * from tbl_users");
//          ResultSet airportQuerySelectAll = statement.executeQuery("select * from tbl_airport"); 
//          while(employeeQuerySelectAll.next())
//              System.out.println(employeeQuerySelectAll.getInt(1) +" " + employeeQuerySelectAll.getString(2)+" "+ employeeQuerySelectAll.getString(3) + " " + employeeQuerySelectAll.getString(4) + " " + employeeQuerySelectAll.getString(5) + " " + employeeQuerySelectAll.getInt(6) + " " + employeeQuerySelectAll.getInt(7) + " " + employeeQuerySelectAll.getInt(8));
          
      
      while(userMenuChoice != -1) {
      
	      MAIN : {
	    	  System.out.println("Welcome to the Utopia Airlines Management System. Which category of user are you?");
	          System.out.println("1 - Employee/Agent	2 - Administrator	3 - Traveler");
	          Scanner userInput = new Scanner(System.in);
	          userMenuChoice = userInput.nextInt();
	         
	          
	          EMP1: {
	        	  if(userMenuChoice == 1) {
	        		  boolean emp1Quit = false;
	        		  while(emp1Quit == false) {
//	        		  while(emp1Quit == false) {
		        		  // EMP1:												 // to MAIN MENU		
		            	  System.out.println("1 Enter Flights You Manage   |   2 Quit to previous menu");
		            	  userMenuChoice = userInput.nextInt();
//		            	  boolean emp1Quit = false;
		            	  if(userMenuChoice == 2) {
		            		  System.out.println("breaking EMP1");
		            		  userMenuChoice = 0;
		            		  emp1Quit = true;
		            		  break EMP1;
		            	  } else {
		            		  boolean emp2Quit = false;
		            		  while( emp2Quit == false) {
//		            		  while(userMenuChoice != 11) {
		            			  System.out.println("EMP2 WHILE LOOP");
		            			  EMP2: {
			                    	  if(userMenuChoice == 1) {
			                    		  //EMP2: Will list all flights, should have a minimum of 10 options here, and a quit to previous line
			                        	  System.out.println("1  flight details, flight details | 11 Quit to previous menu");
			                        	  userMenuChoice = userInput.nextInt();
			                        	  
			                        	  if(userMenuChoice == 11) {
			                        		  System.out.println("breaking EMP2");
			                        		  userMenuChoice = 1;
			                        		  emp2Quit = true;
			                        		  break EMP2;
			                        	  }
			                        	  boolean emp3Quit = false;
			                        	  while( emp3Quit == false) {
//			                        	  while( userMenuChoice != 4) {
			                        		  System.out.println("EMP3 WHILE LOOP");
			                        		  EMP3: {
				                            	  if(userMenuChoice == 1) {
				                            		//EMP3:																												  					EMP2
				                                      System.out.println("1 View more details about the flight   |   2 Update the details of the flight   |   3 Add Seats to Flight   |   4 Quit to previous menu");
				                                      userMenuChoice = userInput.nextInt();
				                                	  if(userMenuChoice == 1) {
				                                		  System.out.println("You have chosen to view the Flight with Flight Id: X and Departure Airport: A and Arrival Airport: B");
				                                		  System.out.println("Departure Airport: A | Arrival Airport: B");
				                                		  System.out.println("Departure Date: C | Departure Time: D");
				                                		  System.out.println("Departure Date: E | Departure Time: F");
				                                		  System.out.println("Available Seats by Class:  First -->  X   Business -->  Y  Economy -->  Z  ");
				                                		  
				                                		  
				                                		  
				                                	  } else if(userMenuChoice == 2) {
				                                		  System.out.println("You hae chosen to update the Flight with Flight Id: X and a Flight Origin: A and Flight Destination: B.");
				                                		  System.out.println("Enter 'quit' at any prompt to cancel operation.");
				                                		  System.out.println("Please enter new Origin Airport and City or enter N/A for no change: ");
				                                		  // take input 
				                                		  
				                                		  System.out.println("Please enter new Destination Airport and City or enter N/A for no change: ");
				                                		  // take input
				                                		  
				                                		  System.out.println("Please enter new Departure Date or enter N/A for no change: ");
				                                		  // take input
				                                		  
				                                		  System.out.println("Please enter new Departure Time or enter N/A for no change: ");
				                                		  // take input
				                                		  
				                                		  System.out.println("Please enter new Arrival Date or enter N/A for no change: ");
				                                		  // take input
				                                		  
				                                		  System.out.println("Please enter new Arrival Time or enter N/A for no change: ");
				                                		  // take input
				                                		  
				                                	  } else if(userMenuChoice == 3) {
				                                		  System.out.println("Add Seats to flight");
				                                		  System.out.println("1 First  |  2 Business  |  3 Economoy  |  4 Quit to cancel operation");
				                                		  // take input
				                                		  
				                                		  System.out.println("Existing number of seats: N"); // if none show zero
				                                		  System.out.println("Enter new number of seats: ");
				                                		  // take input
				                                		  
				                                		  
				                                	  } else {
				                                		  System.out.println("breaking EMP3");
				                                		  userMenuChoice = 1;
				                                		  emp3Quit = true;
				                                		  break EMP3;
				                                	  }
				                                	   
				                                  }
				                              } // end of emp3
			                        	  }
			                        	
			                          }
			                      } // end of emp2  
		            		  }
		            		  
		            	  } // end of else
		            	  
		            	  
		              }
		        	  
		        	  
		        	  
		          } // end of EMP1
	        	} // EMP1 while loop

	          
	          TRAV1: {
	        	  if(userMenuChoice == 3) {
	        		  System.out.println("Please enter your Membership Number: ");
	        		  //take input
	        		  // if travelerID does not exists in tbl_travelers, kick back to main menu
	        		  
	        		  System.out.println("1 Book a ticket   |   2 Cancel an upcoming trip  |  3 Quit to previous menu");
	        		  userMenuChoice = userInput.nextInt();
	        		  if(userMenuChoice == 1) {
	        			  System.out.println("Book a Ticket");
	        			  
	        			  
	        			  System.out.println("Pick the Flight you want to book a ticket for :");
	        			  // flight ...
	        			  // flight ...
	        			  // flight ...
	        			  // 5) Quit to previous (TRAV1) 
	        			  
	        			  // make sure you only show seats that have at least one available in Seat Class in the flight picked
	        			  System.out.println("Pick the Seat you want to book a ticker for : ");
	        			  
	        			  System.out.println("1 View Flight Details  | 2 First  |  3 Business  |  4 Economoy  |  5 Quit to cancel operation");
	        			  

	        			  
	        			  
	        			  
	        		  } else if(userMenuChoice == 2) {
	        			  // reload this menu after trip has been canceled.
	        			  System.out.println("Pick the Flight you want to cancel a ticker for : ");
	        			  // flight ...
	        			  // flight ...
	        			  // flight ...
	        			  // 5) Quit to previous (TRAV1)
	        			  
	        			  
	        			  
	        		  } else {
	        			  System.out.println("breaking TRAV1");
	            		  break TRAV1;
	            	  }
	        		  
	        	  }
	        	  
	          } // end of TRAV1
	          
	          
	          ADMIN1: {
	        	  if(userMenuChoice == 2) {
	        		  boolean admin1Quit = false;
	        		  while(admin1Quit == false) {
		        		  System.out.println("1 Flights   |   2 Seats  |  3 Tickets and Passengers  |  4 Airports  |  5 Travelers  |  6 Employees  |  7 Trip Cancellations  |  8 Quit to Main menu");
		        		  userMenuChoice = userInput.nextInt();
		            	  if(userMenuChoice == 8) {
		            		  System.out.println("breaking ADMIN1");
		            		  userMenuChoice = 0;
		            		  admin1Quit = true;
		            		  break ADMIN1;
		            	  } else {
		            		  flights: {
		            			  if(userMenuChoice == 1) {
//		            				  Statement statement3 = con.createStatement();
//		            		          ResultSet flightQuerySelectAll = statement3.executeQuery("select * from tbl_flight");
		            				  System.out.println("1 Add flight  |  2 Edit flight  |  3 Delete flight  |  4 Show flights  |  5 Quit to previous menu");
		            				  userMenuChoice = userInput.nextInt();
		            				  if(userMenuChoice == 1) {
			            				  System.out.println("Add flight");
			            				  
			            			  } else if (userMenuChoice == 2) {
			            				  System.out.println("Edit flight");
			            				  
			            			  } else if (userMenuChoice == 3) {
			            				  System.out.println("Delete flight");
			            			  
			            			  } else if (userMenuChoice == 4) {
			            				  System.out.println("Showing all flights");
//			            				  System.out.println("flightId  |  departTime  |  seatsAvailable  |  price  |  arrivalTime  |  flightNumber");
//			            				  while(flightQuerySelectAll.next())
//			            		              System.out.println("flightId: " + flightQuerySelectAll.getInt(1) +"  |  departTime: " + flightQuerySelectAll.getDate(2) + flightQuerySelectAll.getTime(2) + "  |  seatsAvailable: " + flightQuerySelectAll.getInt(3) + "  |  price: " + flightQuerySelectAll.getDouble(4) + "  |  arrivalTime: " + flightQuerySelectAll.getDate(5) + flightQuerySelectAll.getTime(5)  +"  |  flightNumber: " + flightQuerySelectAll.getString(6) );
			            				  System.out.println();
			            				  
			            				  
			            			  } else {
			            				  System.out.println("Breaking flights");
			            				  userMenuChoice = 2;
			            				  break flights;
			            			  }
		            			  }
		            			 
		            		  }
		            		  
		            		  seats: {
		            			  if(userMenuChoice == 2) {
		            				  System.out.println("1 Add seat  |  2 Edit seat  |  3 Delete seat  |  4 Show flight seats  |  5 Quit to previous menu");
		            				  userMenuChoice = userInput.nextInt();
		            				  if(userMenuChoice == 1) {
			            				  System.out.println("Add seat");
			            				  
			            			  } else if (userMenuChoice == 2) {
			            				  System.out.println("Edit seat");
			            				  
			            			  } else if (userMenuChoice == 3) {
			            				  System.out.println("Delete seat");
			            			  
			            			  } else if (userMenuChoice == 4) {
			            				  System.out.println("Showing all seats");
//			            				  System.out.println("flightId  |  seatsAvailable  |  flightNumber");
//			            				  while(seatQuerySelectAll.next())
//			            		              System.out.println("flightId: " + seatQuerySelectAll.getInt(1) +"  |  seatsAvailable: " + seatQuerySelectAll.getInt(3) + "  |  flightNumber: " + seatQuerySelectAll.getString(6));
			            				  System.out.println();
			            				  
			            				  
			            				  
			            			  } else {
			            				  System.out.println("Breaking seats");
			            				  userMenuChoice = 2;
			            				  break seats;
			            			  }
		            			  }
		            		  }
		            			  
		            		  }
		            		  
		            		  tickets: {
		            			  if(userMenuChoice == 3) {
		            				  System.out.println("1 Add ticket  |  2 Edit ticket  |  3 Delete ticket  |  4 Show flight tickets  |  5 Quit to previous menu");
		            				  userMenuChoice = userInput.nextInt();
		            				  if(userMenuChoice == 1) {
			            				  System.out.println("Add ticket");
			            				  
			            			  } else if (userMenuChoice == 2) {
			            				  System.out.println("Edit ticket");
			            				  
			            			  } else if (userMenuChoice == 3) {
			            				  System.out.println("Delete ticket");
			            			  
			            			  } else if (userMenuChoice == 4) {
			            				  System.out.println("Showing all tickets");
//			            				  System.out.println("bookingId  |  isActive  |  stripeId  |  bookerId");
//			            				  while(bookingQuerySelectAll.next())
//			            		              System.out.println("bookingId: " + bookingQuerySelectAll.getInt(1) +"  |  isActive: " + bookingQuerySelectAll.getInt(2)+"  |  stripeId: "+ bookingQuerySelectAll.getString(3) + "  |  bookerId: " + bookingQuerySelectAll.getInt(4));
			            		          System.out.println();
			            				  
			            				  
			            			  } else {
			            				  System.out.println("Breaking tickets");
			            				  userMenuChoice = 2;
			            				  break tickets;
			            			  }
		            			  }
		            			  
		            		  }
		            		  
		            		  airports: {
		            			  if(userMenuChoice == 4) {
		            				  System.out.println("1 Add airport  |  2 Edit airport  |  3 Delete airport  |  4 Show airports  |  5 Quit to previous menu");
		            				  userMenuChoice = userInput.nextInt();
		            				  if(userMenuChoice == 1) {
			            				  System.out.println("Add airport");
			            				  
			            			  } else if (userMenuChoice == 2) {
			            				  System.out.println("Edit airport");
			            				  
			            			  } else if (userMenuChoice == 3) {
			            				  System.out.println("Delete airport");
			            			  
			            			  } else if (userMenuChoice == 4) {
			            				  System.out.println("Showing all airports");
//			            				  System.out.println("iataIdent  |  city  |  name  |  airportId");
//			            				  while(airportQuerySelectAll.next())
//			            		              System.out.println("iataIdent: " + airportQuerySelectAll.getString(1) +"  |  city: " + airportQuerySelectAll.getString(2)+"  |  name: "+ airportQuerySelectAll.getString(3) + "  |  airportId: " + airportQuerySelectAll.getInt(4));
			            		          System.out.println();
			            				  
			            			  } else {
			            				  System.out.println("Breaking airports");
			            				  userMenuChoice = 2;
			            				  break airports;
			            			  }
		            			  }
		            		
		            		  }
		            		  
		            		  travelers: {
		            			  if(userMenuChoice == 5) {
		            				  System.out.println("1 Add traveler  |  2 Edit traveler  |  3 Delete traveler  |  4 Show travelers  |  5 Quit to previous menu");
		            				  userMenuChoice = userInput.nextInt();
		            				  if(userMenuChoice == 1) {
			            				  System.out.println("Add traveler");
			            				  
			            				  
			            			  } else if (userMenuChoice == 2) {
			            				  System.out.println("Edit traveler");
			            				  
			            				  
			            			  } else if (userMenuChoice == 3) {
			            				  System.out.println("Delete traveler");
			            			  
			            				  
			            			  } else if (userMenuChoice == 4) {
			            				  System.out.println("Showing all travelers");
//			            				  System.out.println("travelerId  |  name  |  address  |  phone  |  email  |  dob");
//			            				  while(travelerQuerySelectAll.next())
//			            		              System.out.println("travelerId: " +travelerQuerySelectAll.getInt(1) +"  |  name: " + travelerQuerySelectAll.getString(2)+"  |  address: "+ travelerQuerySelectAll.getString(3) + "  |  phone: " + travelerQuerySelectAll.getString(4) + "  |  email: " + travelerQuerySelectAll.getString(5) + "  |  dob: " + travelerQuerySelectAll.getDate(6)  + travelerQuerySelectAll.getTime(6));
			            				  System.out.println();
			            			  } else {
			            				  System.out.println("Breaking travelers");
			            				  userMenuChoice = 2;
			            				  break travelers;
			            			  }
		            			  }
		            		  }
		            		  
		            		  employees: {
		            			  if(userMenuChoice == 6) {
		            				  System.out.println("1 Add employee  |  2 Edit employee  |  3 Delete employee  |  4 Show employees  |  5 Quit to previous menu");
		            				  userMenuChoice = userInput.nextInt();
		            				  if(userMenuChoice == 1) {
			            				  System.out.println("Add employee");
			            				  
			            			  } else if (userMenuChoice == 2) {
			            				  System.out.println("Edit employee");
			            				  
			            			  } else if (userMenuChoice == 3) {
			            				  System.out.println("Delete employee");
			            			  
			            			  } else if (userMenuChoice == 4) {
			            				  System.out.println("Show employees");
//			            				  while(employeeQuerySelectAll.next())
//			            		              System.out.println("userId: " + employeeQuerySelectAll.getInt(1) + "  |  password: " +employeeQuerySelectAll.getString(2) + "  |  email: " +employeeQuerySelectAll.getString(3) + "  |  firstName: "+ employeeQuerySelectAll.getString(4) + "  |  lastName: " + employeeQuerySelectAll.getString(5) + "  |  enabled: " + employeeQuerySelectAll.getInt(6) + "  |  locked: " + employeeQuerySelectAll.getInt(7)  + "  |  userRole" +employeeQuerySelectAll.getInt(8));
			            				  System.out.println();
			            				  
			            			  } else {
			            				  System.out.println("Breaking flights");
			            				  userMenuChoice = 2;
			            				  break employees;
			            			  }
		            			  }
		            		  }
		            		  
		            		  cancellations: {
		            			  if(userMenuChoice == 7) {
		            				  System.out.println("1 Edit cancellation  | 2 Show cancellations  |  3 Quit to previous menu");
		            				  userMenuChoice = userInput.nextInt();
		            				  if(userMenuChoice == 1) {
			            				  System.out.println("Edit cancellation");
			            				  System.out.println("Which cancellation would you like to Edit?");
//			            				  while(cancellationsQuerySelectAll.next())
//			            					  System.out.println("bookingId: " + bookingQuerySelectAll.getInt(1) +"  |  isActive: " + bookingQuerySelectAll.getInt(2)+"  |  stripeId: "+ bookingQuerySelectAll.getString(3) + "  |  bookerId: " + bookingQuerySelectAll.getInt(4));
			            				  System.out.println();
			            				  
			            				  
			            			  } else {
			            				  System.out.println("Breaking cancellations");
			            				  userMenuChoice = 2;
			            				  break cancellations;
			            			  }
		            			  }
		            		  }
		            			  

		            	  }
	            	  
	        	  } // end while loop
	          } // end of ADMIN
	          
	      	} // end of main
      } // end of while loop
         
//      	con.close();
      } catch(Exception e){
          System.out.println(e);
      }
      
   
	}

}
