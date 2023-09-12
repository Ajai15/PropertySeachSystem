package com.amdocs.property;
import java.util.*;
public class Main {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			try {
				System.out.println("1. Add new property.");
				System.out.println("2. Update property.");
				System.out.println("3. Delete property ");
				System.out.println("4. Find by city");
				System.out.println("5. View all properties.");
				System.out.println("6. Find by cost.");
				System.out.println("7. Find by number of rooms and city.");
				System.out.println("8. Exit");
				System.out.println("Enter your choice");
				int ch = Integer.parseInt(sc.nextLine());
				switch (ch) {
				case 1:
					App.addProperty();
					break;
				case 2:
					App.updatePropertyCost();
					break;
				case 3:
					App.deleteProperty();
					break;
				case 4:
					App.searchByCity();
					break;
				case 5:
					App.showAllProperty();
					break;
				case 6:
					App.searchByCost();
					break;
				case 7:
					App.searchByNoOfRoomsAndCity();
					break;
				case 8:
					System.exit(0);
				default:
					System.out.println("Entered the wrong choice! Try again!!");
					break;
				}
			}
	        catch (NumberFormatException e) {
			    System.out.println("Please enter a Number , Input should be in Number Format Try again!!");
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
		}
		} 
	}
}
	
