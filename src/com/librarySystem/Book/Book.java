package com.librarySystem.Book;

import com.librarySystem.Person.Reader;

public class Book {
    private int bookId;
    private String author;
    private String name;
    private double price;
    private boolean status;
    private String edition;
    private int dateOfPurchase;
    private Reader owner;

    // Constructor
    public Book(int bookId, String author, String name, double price, boolean status, String edition, int dateOfPurchase) {
        this.bookId = bookId;
        this.author = author;
        this.name = name;
        this.price = price;
        this.status = status;
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
    }

    public int getBookId() {
        return bookId;
    }

    public boolean isStatus() {
        return status;
    }

    public int getDateOfPurchase() {
        return dateOfPurchase;
    }

    public String get_Title() {
        return name;
    }

    public String get_Author() {
        return author;
    }

    public Reader get_Owner() {
        return owner;
    }

    public void change_Owner(Reader newOwner) {
        this.owner = newOwner;
    }

    public void updateStatus(boolean newStatus) {
        this.status = newStatus;
    }

    public void display() {
        System.out.println("Kitap ID: " + bookId);
        System.out.println("İsim: " + name);
        System.out.println("Yazar: " + author);
        System.out.println("Fiyat: " + price);
        System.out.println("Durum: " + (status ? "Mevcut" : "Ödünçte/Satıldı"));
        System.out.println("Baskı: " + edition);
        System.out.println("Alım Tarihi: " + dateOfPurchase);
        System.out.println("Sahibi: " + (owner != null ? owner.getName() : "Yok"));
    }
}
