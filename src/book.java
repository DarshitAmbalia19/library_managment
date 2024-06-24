// Java Program to Illustrate book Class that
// takes Input from the books and related information


// Importing required classes
import java.util.InputMismatchException;
import java.util.Scanner;

// Class
public class book {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    // Class data members
    public int sNo;
    public String bookName;
    public String authorName;
    public int bookQty;
    public int bookQtyCopy;

    // Creating object of Scanner class to
    // read input from users
    Scanner input = new Scanner(System.in);

    // Method
    // To add book details
    public book() {
        try {
            // Display message for taking input
            System.out.println("Enter Serial No of Book:");
            this.sNo = input.nextInt();
            input.nextLine(); // Clear the buffer

            System.out.println("Enter Book Name:");
            this.bookName = input.nextLine();

            System.out.println("Enter Author Name:");
            this.authorName = input.nextLine();

            System.out.println("Enter Quantity of Books:");
            this.bookQty = input.nextInt();
            bookQtyCopy = this.bookQty;

        } catch (InputMismatchException e) {
            System.out.println(RED+"Invalid input. Please enter the correct type of data."+RESET);
            input.nextLine(); // Clear the buffer for invalid input
        } catch (Exception e) {
            System.out.println(RED+"An error occurred: " + e.getMessage()+RESET);
        }
    }
}
