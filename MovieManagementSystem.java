import java.io.*;
import java.util.*;

// Java program to implement a Doubly Linked List for Movie Management System
public class MovieManagementSystem {
    // Head and Tail of the list
    MovieNode head, tail;

    // Doubly linked list Node representing a movie
    static class MovieNode {
        String title;
        String director;
        int year;
        double rating;
        MovieNode next, prev;

        // Constructor
        MovieNode(String title, String director, int year, double rating) {
            this.title = title;
            this.director = director;
            this.year = year;
            this.rating = rating;
            this.next = null;
            this.prev = null;
        }
    }

    // Method to add a movie at the end
    public void addMovie(String title, String director, int year, double rating) {
        MovieNode newMovie = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        }
        else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Method to remove a movie by title
    public void removeMovie(String title) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                if (temp.prev != null) {
                    temp.prev.next = temp.next;
                }
                else {
                    head = temp.next;
                }
                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                }
                else {
                    tail = temp.prev;
                }
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    // Method to search for a movie by director
    public void searchByDirector(String director) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                displayMovie(temp);
            }
            temp = temp.next;
        }
    }

    // Method to search for a movie by rating
    public void searchByRating(double rating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.rating == rating) {
                displayMovie(temp);
            }
            temp = temp.next;
        }
    }

    // Method to update a movie's rating
    public void updateRating(String title, double newRating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    // Method to display all movies in forward order
    public void displayMoviesForward() {
        MovieNode temp = head;
        while (temp != null) {
            displayMovie(temp);
            temp = temp.next;
        }
    }

    // Method to display all movies in reverse order
    public void displayMoviesReverse() {
        MovieNode temp = tail;
        while (temp != null) {
            displayMovie(temp);
            temp = temp.prev;
        }
    }

    // Helper method to display movie details
    private void displayMovie(MovieNode movie) {
        System.out.println("Title: " + movie.title + ", Director: " + movie.director + ", Year: " + movie.year + ", Rating: " + movie.rating);
    }

    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieManagementSystem movieList = new MovieManagementSystem();
        int choice;

        do {
            System.out.println("\nMovie Management System");
            System.out.println("1 -> Add Movie");
            System.out.println("2 -> Remove Movie");
            System.out.println("3 -> Search by Director");
            System.out.println("4 -> Search by Rating");
            System.out.println("5 -> Update Movie Rating");
            System.out.println("6 -> Display Movies Forward");
            System.out.println("7 -> Display Movies Reverse");
            System.out.println("8 -> Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Movie Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Director: ");
                    String director = sc.nextLine();
                    System.out.print("Enter Year of Release: ");
                    int year = sc.nextInt();
                    System.out.print("Enter Rating: ");
                    double rating = sc.nextDouble();
                    movieList.addMovie(title, director, year, rating);
                    break;
                case 2:
                    System.out.print("Enter Movie Title to Remove: ");
                    title = sc.nextLine();
                    movieList.removeMovie(title);
                    break;
                case 3:
                    System.out.print("Enter Director Name: ");
                    director = sc.nextLine();
                    movieList.searchByDirector(director);
                    break;
                case 4:
                    System.out.print("Enter Rating: ");
                    rating = sc.nextDouble();
                    movieList.searchByRating(rating);
                    break;
                case 5:
                    System.out.print("Enter Movie Title: ");
                    title = sc.nextLine();
                    System.out.print("Enter New Rating: ");
                    rating = sc.nextDouble();
                    movieList.updateRating(title, rating);
                    break;
                case 6:
                    movieList.displayMoviesForward();
                    break;
                case 7:
                    movieList.displayMoviesReverse();
                    break;
                case 8:
                    System.out.println("Exiting Movie Management System.");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
        while (choice != 8);
    }
}
