package com.librarySystem.Person;

import com.librarySystem.Book.Book;

import java.util.*;

public class Author extends Person{
    private List<Book> writtenBooks;
    public Author(String name) {
        super(name);
        this.writtenBooks = new ArrayList<>();
    }

    public Book new_Book(int id, String name, double price, boolean status, String edition, int dateOfPurchase) {
        Book book = new Book(id, this.getName(), name, price, status, edition, dateOfPurchase);
        writtenBooks.add(book);
        return book;
    }
    public void show_Book(int bookId) {
        for (Book book : writtenBooks) {
            if (book.getBookId() == bookId) {
                book.display();
                return;
            }
        }
        System.out.println("Bu ID'ye sahip bir kitap bulunamadı.");
    }

    @Override
    public void whoyouare() {
        System.out.println("Ben bir yazarım.");
    }
}
