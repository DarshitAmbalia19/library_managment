// Java Program to Illustrate students Class
// To Do all the Operations related to students:
// add Students,check-in books,check out books,ValidStudent

// Importing required classes
import java.util.Scanner;

// Class
public class students {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    // Creating objects of Scanner and students class
    Scanner input = new Scanner(System.in);
    student theStudents[] = new student[50];

    public static int count = 0;

    // Method 1
    // To add books
    public void addStudent(student s)
    {
        for (int i = 0; i < count; i++) {

            if (s.regNum.equalsIgnoreCase(
                    theStudents[i].regNum)) {

                // Print statement
                System.out.println(RED+
                        "Student of Reg Num " + s.regNum
                                + " is Already Registered."+RESET);

                return;
            }
        }

        if (count <= 50) {
            theStudents[count] = s;
            count++;
        }
    }

    // Method 2
    // Displaying all students
    public void showAllStudents()
    {
        System.out.println("\t\t\t\tSHOWING ALL REGISTERED STUDENTS\n");
        // Printing student name and
        // corresponding registered number
        System.out.println("Student Name\t\t\t\tReg Number");
        for (int i = 0; i < count; i++) {

            System.out.println(theStudents[i].studentName
                    + "\t\t\t\t\t"
                    + theStudents[i].regNum);
        }
    }

    // Method 3
    // To check the Student
    public int isStudent()
    {
        // Display message only
        System.out.println("Enter Reg Number:");

        String regNum = input.nextLine();

        for (int i = 0; i < count; i++) {

            if (theStudents[i].regNum.equalsIgnoreCase(
                    regNum)) {
                return i;
            }
        }

        // Print statements
        System.out.println(RED+"Student is not Registered."+RESET);
        System.out.println(RED+"Get Registered First."+RESET);

        return -1;
    }

    // Method 4
    // To remove the book
    public void checkOutBook(books book)
    {
        int studentIndex = this.isStudent();

        if (studentIndex != -1) {
            System.out.println("checking out");

            book.showAllBooks();
            book b = book.checkOutBook();

            System.out.println("checking out");
            if (b != null) {

                if (theStudents[studentIndex].booksCount
                        <= 3) {

                    System.out.println("adding book");
                    theStudents[studentIndex].borrowedBooks
                            [theStudents[studentIndex]
                            .booksCount]
                            = b;
                    theStudents[studentIndex].booksCount++;

                    return;
                }
                else {

                    System.out.println(RED+
                            "Student Can not Borrow more than 3 Books."+RESET);
                    return;
                }
            }
            System.out.println(RED+"Book is not Available."+RESET);
        }
    }

    // Method 5
    // To add the book
    public void checkInBook(books book)
    {
        int studentIndex = this.isStudent();
        if (studentIndex != -1) {

            // Printing credentials corresponding to student
            System.out.println(
                    "S.No\t\t\tBook Name\t\t\tAuthor Name");

            student s = theStudents[studentIndex];

            for (int i = 0; i < s.booksCount; i++) {

                System.out.println(
                        s.borrowedBooks[i].sNo + "\t\t\t"
                                + s.borrowedBooks[i].bookName + "\t\t\t"
                                + s.borrowedBooks[i].authorName);
            }

            // Display message only
            System.out.println(
                    "Enter Serial Number of Book to be Checked In:");

            int sNo = input.nextInt();

            for (int i = 0; i < s.booksCount; i++) {
                if (sNo == s.borrowedBooks[i].sNo) {
                    book.checkInBook(s.borrowedBooks[i]);
                    s.borrowedBooks[i] = null;

                    return;
                }
            }

            System.out.println(RED+"Book of Serial No " + sNo
                    + "not Found"+RESET);
        }
    }
}
