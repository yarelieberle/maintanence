package maintanence;

import java.util.*;

public class Main {

	static int mode; // mode is reused multiple times to navigate through UI
	int ID;

	public static void main(String[] args) {
		HashTable ht = new HashTable();
		ht.put("Dan H", "Help please god help");
		ht.put("Tay B", "This broke");
		ht.put("Parker L", "That broke");
		ht.put("Zach H", "Colorful critters in the vents");
		ht.put("Eli I", "Mold everywhere");

		Scanner sc = new Scanner(System.in);

		boolean end = false;

		while (true) {
			if (end == true) {
				break; // ends the program if a user picks to "quit"
			}
			System.out.print(
					"Maitanence Request Viewer / Editor \n----(Enter 3 to close program)----\n\nPress 1 for student view, 2 for Worker view.");
			mode = sc.nextInt();

			if (mode == 1) { //STUDENT VIEW

				System.out.println("\nStudent View: View & Add support tickets. ");
				System.out.println("-------(Enter 3 to close program)-------");
				

				while(true) {
					System.out.println("Do you want to add a new request (1) or view current requests (2)?");
					mode = sc.nextInt();
					
					if(mode == 1) {
						System.out.println("Please enter your name: ");
						String name = sc.next();
						System.out.println("Please enter your request: ");
						String request = sc.next();
						ht.put(name, request); //initializes request, gets hash code, adds to map, and finally returns its generated ID. 
						System.out.print(" is your generated ticket ID.");
					}
					if(mode == 2) {
						System.out.println("Active request tickets: ");
						ht.toString(); // prints all active requests
					}
					if(mode ==3) {
						System.out.println("Goodbye");
						end = true;
						break;
					}
					if(mode != 1 && mode != 2 && mode != 3) { //error code
						System.out.println("Invalid option, please try again."); 
					}
				}

			} 
			else if (mode == 2) { //MAINTENANCE VIEW
				while (true && end == false) {
					System.out.println("\nEnter maintenance password (enter 3 to return to main menu): ");
					int pass = sc.nextInt();

					// password is just 123, this exists as a hypothetical security check.

						break; // in case of misinput, allows to go back to pick student view.
					} else if (pass == 123) {
						System.out.println("Maintenance View: View & Edit active support tickets.");
						System.out.println("------------(Enter 3 to close program)------------");

						while (true) {
							System.out.println("Active request tickets: ");
							ht.toString(); // prints all active requests

							System.out.println("Enter ticket ID to search for / edit: ");
							int ID = sc.nextInt();
							
							if(ID == 3) { //checks if user is trying to exit before searching
								System.out.println("Goodbye");
								end = true;
								break;
							}
							
							ht.toString(); //overloads display to search for entry matching ticket ID
							if (ht.toString() != "no results, please try again.") { //if the entry IS found
								System.out.println("Do you want to edit this request? (1 for Y | 2 for N)");
								mode = sc.nextInt();
								
								if (mode == 1) {
									System.out.println("Has the request been Resolved? 1 for Y | 2 for N");
									mode = sc.nextInt(); //if 1, the request is filed as Resolved, 2 it stays Unresolved.
									if(mode == 1) {
										boolean Status = true;
										System.out.println("What is the final result?"); //different language for clarity to maintenance staff
										String Progress = sc.next();
										HashTable.editRequest(ID, Status ,Progress); 
									}
									if(mode != 1) {
										boolean Status = false;
										System.out.println("What progress has been made?"); //different language for clarity to maintenance staff
										String Progress = sc.next();
										//HashTable.editRequest(ID, Status, Progress); 
									}
								}
							} //doesn't read if mode != 2, returns to menu if its anything but 1.
							System.out.println("Request not found or denied, returning to list of requests.\n");
						}
					}

					else { 
						//self explanatory
						System.out.println("Incorrect password, please try again.");
					}
				}
			}
			
			if(mode ==3) {
				System.out.println("\nGoodbye");
				end = true;
				break;
			}
			else {
				// self explanatory error code
				System.out.println("\nInvalid input, please try again.\n");
			}
		}

	}

}
