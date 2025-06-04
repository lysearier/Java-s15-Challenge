package com.librarySystem.Library;

import com.librarySystem.Book.Book;
import com.librarySystem.Person.Reader;
import com.librarySystem.Record.memberRecord;

public class Librarian {
    private Library library;
    private String name;
    private String password;

    public Librarian(Library library) {
        this.name = "Eren";
        this.password = "Eren5757";
        this.library = library;
    }

    public Book search_book(String title) {
        for (Book book : library.get_Books()) {
            if (book.get_Title().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
    public boolean verify_Member(String name, int memberId) {
        for (memberRecord member : library.get_Reader()) {
            if (member.get_Member() == memberId && member.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
    public void issue_Book(Book book, memberRecord member) {
        if (!book.isStatus()) {
            System.out.println("Kitap şu anda ödünçte.");
            return;
        }
        if (member.getBooks_issued() < member.getMax_book_limit()) {
            member.inc_Book_Issued();
            book.updateStatus(false);
            book.change_Owner(new Reader(member.getName()));
            System.out.println("Kitap ödünç verildi.");
        } else {
            System.out.println("Üye kitap limitine ulaştı.");
        }
    }

    public double calculate_Fine(Book book) {
        double days = book.getDateOfPurchase();
        if (days > 5) {
            return (days - 5) * 0.25;
        }
        return 0;
    }
    public void create_Bill(memberRecord member, Book book) {
        double fine = calculate_Fine(book);
        member.setFineAmount(fine);
    }
    public void return_Book(Book book, memberRecord member) {
        book.updateStatus(true);
        member.dec_Book_Issued();
        book.change_Owner(null);
    }

}
