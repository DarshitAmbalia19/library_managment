
import java.util.InputMismatchException;
import java.util.Scanner;

public class books {

    book theBooks[] = new book[50];
    public static int count;

    Scanner input = new Scanner(System.in);
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    // Method 1
    // To compare books
    public int compareBookObjects(book b1, book b2)
    {

        // If book name matches
        if (b1.bookName.equalsIgnoreCase(b2.bookName)) {

            // Printing book exists
            System.out.println(RED+"!!! Sorry , Book of this Name Already Exists !!!"+RESET);
            return 0;
        }

        // if book serial matches
        if (b1.sNo == b2.sNo) {

            // Print book exists
            System.out.println(RED+"!!! Sorry , Book of this Serial No Already Exists !!!"+RESET);

            return 0;
        }
        return 1;
    }

    // Method 2
    // To add book
    public void addBook(book b)
    {

        for (int i = 0; i < count; i++) {

            if (this.compareBookObjects(b, this.theBooks[i])
                    == 0)
                return;
        }

        if (count < 50) {

            theBooks[count] = b;
            count++;
        }
        else {

            System.out.println(
                    RED+"No Space to Add More Books."+RESET);
        }
    }

// Method 3
// To search book by serial number
public void searchBySno() {
    // Display message
    System.out.println("\t\t\t\tSEARCH BY SERIAL NUMBER\n");

    try {
        // Class data members
        int sNo;
        System.out.print("Enter Serial No of Book :- ");
        sNo = input.nextInt();

        int flag = 0;
        System.out.println("");

        for (int i = 0; i < count; i++) {
            if (sNo == theBooks[i].sNo) {
                System.out.println("S.No" + " :- " +
                        theBooks[i].sNo + "\t\n" + "Name" + " :- " +
                        theBooks[i].bookName + "\t\n" + "Author Name" + " :- " +
                        theBooks[i].authorName + "\t\n" + "Available Qty" + " :- " +
                        theBooks[i].bookQtyCopy + "\t\n" + "Total Qty" + " :- " +
                        theBooks[i].bookQty);
                flag++;
                return;
            }
        }
        if (flag == 0)
            System.out.println(RED+"Sorry!! , No Book for Serial No "
                    + sNo + " Found."+RESET);
    } catch (InputMismatchException e) {
        System.out.println(RED+"Invalid input. Please enter a valid serial number."+RESET);
    }
}


// Method 4
// To search author by name
public void searchByAuthorName() {
    try {
        // Display message
        System.out.println("\t\t\t\tSEARCH BY AUTHOR'S NAME");

        System.out.print("Enter Author Name :- ");
        String authorName = input.nextLine();

        int flag = 0;

        System.out.println("");

        for (int i = 0; i < count; i++) {
            // if author matches any of its book
            if (authorName.equalsIgnoreCase(theBooks[i].authorName)) {
                // Print below corresponding credentials
                System.out.println("S.No" + " :- " + theBooks[i].sNo + "\t\n" + "Name" + " :- " +
                        theBooks[i].bookName + "\t\n" + "Author Name" + " :- " +
                        theBooks[i].authorName + "\t\n" + "Available Qty" + " :- " +
                        theBooks[i].bookQtyCopy + "\t\n" + "Total Qty" + " :- " +
                        theBooks[i].bookQty);
                flag++;
            }
        }

        // Else no book matches for author
        if (flag == 0)
            System.out.println("No Books of " + authorName + " Found.");
    } catch (Exception e) {
        System.out.println(RED+"An error occurred: " + e.getMessage()+RESET);
        e.printStackTrace();
    }
}

    // Method 5
    // To display all books
    public void showAllBooks()
    {

        System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");

        for (int i = 0; i < count; i++) {

            System.out.println("S.No" + " :- " +
                    theBooks[i].sNo + "\t\n" + "Name" + " :- " +
                            theBooks[i].bookName + "\t\n" + "Author name " + " :- " +
                            theBooks[i].authorName + "\t\n" + "Available Qty" + " :- " +
                            theBooks[i].bookQtyCopy + "\t\n" + "Total Qty" + " :- " + 
                            theBooks[i].bookQty+"\n\n");
        }
    }

    // Method 6
    // To edit the book
    public void upgradeBookQty()
    {

        System.out.println(
                "\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");
        System.out.println("Enter Serial No of Book");

        int sNo = input.nextInt();

        for (int i = 0; i < count; i++) {

            if (sNo == theBooks[i].sNo) {

                // Display message
                System.out.println(
                        "Enter No of Books to be Added:");

                int addingQty = input.nextInt();
                theBooks[i].bookQty += addingQty;
                theBooks[i].bookQtyCopy += addingQty;

                return;
            }
        }
    }

    // Method 7
    // To create menu
    public void dispMenu()
    {

        // Displaying menu
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
        System.out.println("Press 0 to Exit Application.");
        System.out.println("Press 1 to Add new Book.");
        System.out.println(
                "Press 2 to Upgrade Quantity of a Book.");
        System.out.println("Press 3 to Search a Book.");
        System.out.println("Press 4 to Show All Books.");
        System.out.println("Press 5 to Register Student.");
        System.out.println(
                "Press 6 to Show All Registered Students.");
        System.out.println("Press 7 to Check Out Book. ");
        System.out.println("Press 8 to Check In Book");
        System.out.println(
                "-------------------------------------------------------------------------------------------------------");
    }

    // Method 8
    // To search the library
    public int isAvailable(int sNo)
    {

        for (int i = 0; i < count; i++) {
            if (sNo == theBooks[i].sNo) {
                if (theBooks[i].bookQtyCopy > 0) {

                    System.out.println(
                            "Book is Available.");
                    return i;
                }
                System.out.println(RED+"Book is Unavailable"+RESET);
                return -1;
            }
        }

        System.out.println(RED+"No Book of Serial Number "
                + " Available in Library."+RESET);
        return -1;
    }

    // Method 9
    // To remove the book from the library
    public book checkOutBook()
    {

        System.out.println(
                "Enter Serial No of Book to be Checked Out.");
        int sNo = input.nextInt();

        int bookIndex = isAvailable(sNo);

        if (bookIndex != -1) {
            theBooks[bookIndex].bookQtyCopy--;
            return theBooks[bookIndex];
        }
        return null;
    }

    // Method 10
    // To add the Book to the Library
    public void checkInBook(book b)
    {
        for (int i = 0; i < count; i++) {
            if (b.equals(theBooks[i])) {
                theBooks[i].bookQtyCopy++;
                return;
            }
        }
    }
}
