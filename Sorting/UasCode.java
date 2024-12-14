import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Book {
    String title;
    long isbn;
    String author;
    Date publicationDate;

    public Book(String title, long isbn, String author, Date publicationDate) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.publicationDate = publicationDate;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setISBN(long isbn){
        this.isbn = isbn;
    }

    public void setAuthor(String author){
        this.author = author;
    }
    public void setPublicationDate(Date publicationDate){
        this.publicationDate = publicationDate;
    }
    public String getTitle(){
        return this.title;
    }
    public long getISBN(){
        return this.isbn;
    }
    public String getAuthor(){
        return this.author;
    }
    public Date getPublicationDate(){
        return this.publicationDate;
    }

    // Return the string interpretation of the book
    @Override
    public String toString() {
      return "ISBN: " + this.isbn + ", Title: " + this.title + ", Author: " + this.author + "Date: " + this.publicationDate;
    }
  }
  
  class Node {
    Book book;
    Node next;
  
    public Node(Book book) {
      this.book = book;
    }
  }
  
  class LinkedList {
    private Node head;

    public LinkedList(){
      this.head = null;
    }
  
    public void insertBook(Book newBook) {
      Node newNode = new Node(newBook);
        if (head == null || head.book.isbn > newBook.isbn) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.book.isbn < newBook.isbn) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }
    public void removeBook(long isbn) {
      if (head == null) {
        System.out.println("The catalog is empty.");
        return;
      }
      if (head.book.isbn == isbn) {
        head = head.next;
        System.out.println("Book with ISBN " + isbn + " removed.");
        return;
      }

      Node current = head;
      while (current.next != null && current.next.book.isbn != isbn) {
        current = current.next;
      }

    if (current.next == null) {
        System.out.println("Book with ISBN " + isbn + " not found.");
    } else {
        current.next = current.next.next;
        System.out.println("Book with ISBN " + isbn + " removed.");
    }
  }
  
    public Book findBook(long isbn) {
      Node current = head;
        while (current != null) {
            if (current.book.isbn == isbn) {
                return current.book;
            }
            current = current.next;
        }
        return null;
    }
  
    public void displayCatalog() {
      if (head == null) {
        System.out.println("The catalog is empty.");
        return;
      }
      Node current = head;
      while (current != null) {
        System.out.println(current.book.toString());
        current = current.next;
      }
    }
  
    public int countBooks() {
      int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
  }
  
  public class UasCode {
  
    public static void main(String[] args) throws ParseException {

      LinkedList catalog = new LinkedList();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");

        // Menambahkan data buku
        catalog.insertBook(new Book("A Brief History of Time", 9780553109535L, "Stephen Hawking", dateFormat.parse("1988")));
        catalog.insertBook(new Book("The Selfish Gene", 19857519, "Richard Dawkins", dateFormat.parse("1976")));
        catalog.insertBook(new Book("Sophie's World", 9781857992915L, "Jostein Gaarder", dateFormat.parse("1991")));
        catalog.insertBook(new Book("Outliers", 9780316017923L, "Malcolm Gladwell", dateFormat.parse("2008")));
        catalog.insertBook(new Book("Sapiens: A Brief History of Humankind", 9780062316097L, "Yuval Noah Harari", dateFormat.parse("2011")));
        catalog.insertBook(new Book("Thus Spoke Zarathustra: A Book for Everyone and Nobody", 9780199537099L, "Friedrich Nietzsche", dateFormat.parse("2009")));

        // Menampilkan katalog buku
        System.out.println("Catalog Buku:");
        catalog.displayCatalog();
    }
  }
  