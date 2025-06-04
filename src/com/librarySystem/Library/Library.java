package com.librarySystem.Library;

import com.librarySystem.Book.Book;
import com.librarySystem.Record.memberRecord;

import java.util.*;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<memberRecord> readers = new ArrayList<>();

    public List<Book> get_Books() {
        return books;
    }

    public List<memberRecord> get_Reader() {
        return readers;
    }

    public void new_Book(int id, String author, String name, double price, boolean status, String edition, int dateOfPurchase) {
        Book book = new Book(id, author, name, price, status, edition, dateOfPurchase);
        books.add(book);
    }

    public void lend_Book(Book book) {
        book.updateStatus(false);
    }

    public void take_Back_Book(Book book) {
        book.updateStatus(true);
    }
    public void show_book(int id) {
        for(Book book : books) {
            if(book.getBookId() == id) {
                book.display();
                return;
            }
        }
        System.out.println("Bu ID'ye sahip kitap bulunamadı.");
    }

}
