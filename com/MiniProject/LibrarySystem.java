package com.MiniProject;
import java.io.*;
import java.util.*;
class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}
class InvalidReturnException extends Exception {
    public InvalidReturnException(String message) {
        super(message);
    }
}
class Book {
    private String id;
    private String title;
    private boolean isIssued;

    public Book(String id, String title) {
        this.id = id;
        this.title = title;
        this.isIssued = false;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public boolean isIssued() { return isIssued; }

    public void issueBook() { isIssued = true; }
    public void returnBook() { isIssued = false; }

    @Override
    public String toString() {
        return id + " - " + title + (isIssued ? " (Issued)" : " (Available)");
    }
}
class Member {
    private String memberId;
    private String name;
    private HashMap<String, Long> issuedBooks; // bookId -> issue time

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.issuedBooks = new HashMap<>();
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }

    public void issueBook(String bookId) {
        issuedBooks.put(bookId, System.currentTimeMillis());
    }

    public void returnBook(String bookId) {
        issuedBooks.remove(bookId);
    }

    public boolean hasBook(String bookId) {
        return issuedBooks.containsKey(bookId);
    }

    public long getIssueTime(String bookId) {
        return issuedBooks.get(bookId);
    }
}

class Library {
    private HashMap<String, Book> books;
    private HashMap<String, Member> members;
    private final String logFile = "library_log.txt";

    public Library() {
        books = new HashMap<>();
        members = new HashMap<>();
    }

    private void log(String message) {
        try (FileWriter fw = new FileWriter(logFile, true)) {
            fw.write(new Date() + ": " + message + "\n");
        } catch (IOException e) {
            System.out.println("Logging failed: " + e.getMessage());
        }
    }

    public void addBook(Book book) {
        books.put(book.getId(), book);
        log("Added Book: " + book);
    }

    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
        log("Added Member: " + member.getName());
    }

    public void issueBook(String bookId, String memberId) throws BookNotAvailableException {
        Book book = books.get(bookId);
        Member member = members.get(memberId);

        if (book == null || member == null)
            throw new BookNotAvailableException("Book or Member not found!");

        if (book.isIssued())
            throw new BookNotAvailableException("Book already issued!");

        book.issueBook();
        member.issueBook(bookId);
        log("Book issued: " + book.getTitle() + " to " + member.getName());
    }

    public void returnBook(String bookId, String memberId) throws InvalidReturnException {
        Book book = books.get(bookId);
        Member member = members.get(memberId);

        if (book == null || member == null)
            throw new InvalidReturnException("Book or Member not found!");

        if (!member.hasBook(bookId))
            throw new InvalidReturnException("This member did not issue this book!");

        long issueTime = member.getIssueTime(bookId);
        long days = (System.currentTimeMillis() - issueTime) / (1000 * 60 * 60 * 24);
        double lateFee = (days > 7) ? (days - 7) * 2.0 : 0.0;

        book.returnBook();
        member.returnBook(bookId);
        log("Book returned: " + book.getTitle() + " by " + member.getName() +
                ". Late Fee: ₹" + lateFee);
        System.out.println("Book returned successfully. Late Fee: ₹" + lateFee);
    }

    public void showAllBooks() {
        System.out.println("\n--- Book List ---");
        for (Book b : books.values()) {
            System.out.println(b);
        }
    }
}

// --- Main Class (Menu-driven) ---
public class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n==== Library Menu ====");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Show All Books");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter Book ID: ");
                        String id = sc.nextLine();
                        System.out.print("Enter Book Title: ");
                        String title = sc.nextLine();
                        library.addBook(new Book(id, title));
                        System.out.println("Book added successfully!");
                    }
                    case 2 -> {
                        System.out.print("Enter Member ID: ");
                        String memberId = sc.nextLine();
                        System.out.print("Enter Member Name: ");
                        String name = sc.nextLine();
                        library.addMember(new Member(memberId, name));
                        System.out.println("Member added successfully!");
                    }
                    case 3 -> {
                        System.out.print("Enter Book ID: ");
                        String bookId = sc.nextLine();
                        System.out.print("Enter Member ID: ");
                        String memId = sc.nextLine();
                        library.issueBook(bookId, memId);
                        System.out.println("Book issued successfully!");
                    }
                    case 4 -> {
                        System.out.print("Enter Book ID: ");
                        String bookId = sc.nextLine();
                        System.out.print("Enter Member ID: ");
                        String memId = sc.nextLine();
                        library.returnBook(bookId, memId);
                    }
                    case 5 -> library.showAllBooks();
                    case 6 -> {
                        System.out.println("Exiting... Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid choice!");
                }
            } catch (BookNotAvailableException | InvalidReturnException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
