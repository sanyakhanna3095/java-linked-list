import java.io.*;
import java.util.Scanner;

// Java program to implement a Singly Linked List for Student Records
public class StudentLinkedList {
    // Head of list
    Node head;

    // Linked list Node
    static class Node {
        int rollNumber;
        String name;
        int age;
        char grade;
        Node next;

        // Constructor
        Node(int rollNumber, String name, int age, char grade) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.age = age;
            this.grade = grade;
            this.next = null;
        }
    }

    // Method to insert a new student at the end
    public static StudentLinkedList insert(StudentLinkedList list, int rollNumber, String name, int age, char grade) {
        // Create a new node
        Node new_node = new Node(rollNumber, name, age, grade);

        // If the Linked List is empty, then make the new node as head
        if (list.head == null) {
            list.head = new_node;
        }
        else {
            // Traverse till the last node and insert the new node there
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            // Insert the new_node at last node
            last.next = new_node;
        }
        return list;
    }

    // Method to delete a student by Roll Number
    public static StudentLinkedList deleteByRollNumber(StudentLinkedList list, int rollNumber) {
        Node temp = list.head, prev = null;

        // If head node itself holds the rollNumber to be deleted
        if (temp != null && temp.rollNumber == rollNumber) {
            // Change head
            list.head = temp.next;
            System.out.println("Student with Roll Number " + rollNumber + " deleted.");
            return list;
        }

        // Search for the student and keep track of the previous node
        while (temp != null && temp.rollNumber != rollNumber) {
            prev = temp;
            temp = temp.next;
        }

        // If student was not found
        if (temp == null) {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
            return list;
        }

        // Unlink the node
        prev.next = temp.next;
        System.out.println("Student with Roll Number " + rollNumber + " deleted.");
        return list;
    }

    // Method to search for a student by Roll Number
    public static void searchByRollNumber(StudentLinkedList list, int rollNumber) {
        Node currNode = list.head;

        while (currNode != null) {
            if (currNode.rollNumber == rollNumber) {
                System.out.println("Student Found -> Roll No: " + currNode.rollNumber + ", Name: " + currNode.name + ", Age: " + currNode.age + ", Grade: " + currNode.grade);
                return;
            }
            currNode = currNode.next;
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found.");
    }

    // Method to update a student's grade by Roll Number
    public static void updateGrade(StudentLinkedList list, int rollNumber, char newGrade) {
        Node currNode = list.head;

        while (currNode != null) {
            if (currNode.rollNumber == rollNumber) {
                currNode.grade = newGrade;
                System.out.println("Grade updated for Roll Number " + rollNumber);
                return;
            }
            currNode = currNode.next;
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found.");
    }

    // Method to print the student records
    public static void printList(StudentLinkedList list) {
        Node currNode = list.head;

        System.out.println("\nStudent Records:");

        // Traverse through the LinkedList
        while (currNode != null) {
            System.out.println("Roll No: " + currNode.rollNumber + ", Name: " + currNode.name + ", Age: " + currNode.age + ", Grade: " + currNode.grade);
            currNode = currNode.next;
        }
    }

    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentLinkedList list = new StudentLinkedList();
        int choice;

        do {
            System.out.println("\nStudent Record Management System");
            System.out.println("1 -> Add Student");
            System.out.println("2 -> Delete Student by Roll Number");
            System.out.println("3 -> Search Student by Roll Number");
            System.out.println("4 -> Update Student Grade");
            System.out.println("5 -> Display All Students");
            System.out.println("6 -> Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll Number: ");
                    int rollNumber = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    System.out.print("Enter Grade: ");
                    char grade = sc.next().charAt(0);
                    list = insert(list, rollNumber, name, age, grade);
                    break;

                case 2:
                    System.out.print("Enter Roll Number to Delete: ");
                    int deleteRoll = sc.nextInt();
                    list = deleteByRollNumber(list, deleteRoll);
                    break;

                case 3:
                    System.out.print("Enter Roll Number to Search: ");
                    int searchRoll = sc.nextInt();
                    searchByRollNumber(list, searchRoll);
                    break;

                case 4:
                    System.out.print("Enter Roll Number to Update Grade: ");
                    int updateRoll = sc.nextInt();
                    System.out.print("Enter New Grade: ");
                    char newGrade = sc.next().charAt(0);
                    updateGrade(list, updateRoll, newGrade);
                    break;

                case 5:
                    printList(list);
                    break;

                case 6:
                    System.out.println("Exiting Student Record Management System.");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
        while (choice != 6);


    }
}


/*
Student Record Management System
1 -> Add Student
2 -> Delete Student by Roll Number
3 -> Search Student by Roll Number
4 -> Update Student Grade
5 -> Display All Students
6 -> Exit
Enter your choice: 1
Enter Roll Number: 1234567
Enter Name: Sanya Khanna
Enter Age: 21
Enter Grade: 7

Student Record Management System
1 -> Add Student
2 -> Delete Student by Roll Number
3 -> Search Student by Roll Number
4 -> Update Student Grade
5 -> Display All Students
6 -> Exit
Enter your choice: 1
Enter Roll Number: 1235651
Enter Name: Mehak Sharma
Enter Age: 22
Enter Grade: 8

Student Record Management System
1 -> Add Student
2 -> Delete Student by Roll Number
3 -> Search Student by Roll Number
4 -> Update Student Grade
5 -> Display All Students
6 -> Exit
Enter your choice: 2
Enter Roll Number to Delete: 1234567
Student with Roll Number 1234567 deleted.

Student Record Management System
1 -> Add Student
2 -> Delete Student by Roll Number
3 -> Search Student by Roll Number
4 -> Update Student Grade
5 -> Display All Students
6 -> Exit
Enter your choice: 4
Enter Roll Number to Update Grade: 1235651
Enter New Grade: 9
Grade updated for Roll Number 1235651

Student Record Management System
1 -> Add Student
2 -> Delete Student by Roll Number
3 -> Search Student by Roll Number
4 -> Update Student Grade
5 -> Display All Students
6 -> Exit
Enter your choice: 5

Student Records:
Roll No: 1235651, Name: Mehak Sharma, Age: 22, Grade: 9

Student Record Management System
1 -> Add Student
2 -> Delete Student by Roll Number
3 -> Search Student by Roll Number
4 -> Update Student Grade
5 -> Display All Students
6 -> Exit
Enter your choice: 6
Exiting Student Record Management System.

 */