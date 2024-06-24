
import java.util.Scanner;
import java.util.InputMismatchException;

// Class
public class Library {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";

    // Main driver method
    public static void main(String[] args)
    {
        // Creating object of Scanner class
        // to take input from user

        Scanner input = new Scanner(System.in);

        // Displaying menu
        System.out.println(
                "**********************************************************************");
        System.out.println(
                "				  Select From The Following Options:			         ");
        System.out.println(
                "**********************************************************************");

        // Creating object of book class
        books ob = new books();
        // Creating object of students class
        students obStudent = new students();
        int choice = -1;
        int searchChoice;

        // Creating menu
        // using do-while loop
        do {
            try {
                ob.dispMenu();
                System.out.print("Enter your choice :- ");
                choice = input.nextInt();

                // Switch case
                switch (choice) {

                    // Case
                    case 1:
                        book b = new book();
                        ob.addBook(b);
                        break;

                    // Case
                    case 2:
                        ob.upgradeBookQty();
                        break;

                    // Case
                    case 3:
                        System.out.println("Press 1 to Search with Book Serial No.");
                        System.out.println("Press 2 to Search with Book's Author Name.");
                        searchChoice = input.nextInt();

                        // Nested switch
                        switch (searchChoice) {
                            // Case1
                            
                            case 1:
                                ob.searchBySno();
                                break;

                            // Case
                            case 2:
                                ob.searchByAuthorName();
                                break;

                            default:
                                System.out.println(RED+"Invalid search choice. Please enter 1 or 2."+RESET);
                        }
                        break;

                    // Case
                    case 4:
                        ob.showAllBooks();
                        break;

                    // Case
                    case 5:
                        student s = new student();
                        obStudent.addStudent(s);
                        break;

                    // Case
                    case 6:
                        obStudent.showAllStudents();
                        break;

                    // Case
                    case 7:
                        obStudent.checkOutBook(ob);
                        break;

                    // Case
                    case 8:
                        obStudent.checkInBook(ob);
                        break;

                    // Default case that will execute for sure
                    // if above cases do not match
                    default:
                        System.out.println("ENTER BETWEEN 0 TO 8.");
                }

            } catch (InputMismatchException e) {
                System.out.println(RED+"Invalid input. Please enter a number."+RESET);
                input.nextLine(); // Clear the buffer
            } catch (NullPointerException e) {
                System.out.println(RED+"Encountered a null value. Please check the input."+RESET);
            } catch (NumberFormatException e) {
                System.out.println(RED+"Number format error. Please enter valid numbers."+RESET);
            } catch (Exception e) {
                System.out.println(RED+"An unexpected error occurred: " + e.getMessage()+RESET);
            }
        } while (choice != 0);
    }
}
