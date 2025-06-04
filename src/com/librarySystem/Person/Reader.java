package com.librarySystem.Person;

import com.librarySystem.Book.Book;
import java.util.*;

public class Reader extends Person {
    private List<Book> borrowedBooks;

    public Reader(String name) {
        super(name);
        this.borrowedBooks = new ArrayList<>();
    }

    public void purchaseBook(int bookId, Map<Integer, Book> bookMap) {
        Book book = bookMap.remove(bookId);
        if (book != null) {
            book.updateStatus(false);
            book.change_Owner(this);
            borrowedBooks.add(book);
            System.out.println("Kitap satın alındı: " + book.get_Title());
        } else {
            System.out.println("Kitap bulunamadı.");
        }
    }

    public void borrowBook(int bookId, Map<Integer, Book> bookMap) {
        Book book = bookMap.get(bookId);
        if (book != null && book.isStatus() && borrowedBooks.size() <= 5) {
            book.updateStatus(false);
            book.change_Owner(this);
            borrowedBooks.add(book);
            System.out.println("Kitap ödünç alındı: " + book.get_Title());
        } else {
            System.out.println("Kitap ödünç alınamaz.");
        }
    }
    public void return_Book(int bookId) {
        for (Book book : borrowedBooks) {
            if (book.getBookId() == bookId) {
                book.display();
                return;
            }
        }
        System.out.println("Bu ID'ye ait bir kitap bulunamadı.");
    }

    @Override
    public void whoyouare() {
        System.out.println("Ben bir okuyucuyum: " + getName());
    }
}
