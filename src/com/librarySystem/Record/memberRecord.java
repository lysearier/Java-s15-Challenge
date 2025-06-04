package com.librarySystem.Record;

public class memberRecord {
    private int member_id;
    private String type;
    private String date_of_membership;
    private int books_issued;
    private int max_book_limit;
    private String name;
    private String address;
    private String phone_no;
    private double fineAmount = 0.0;

    public memberRecord(int member_id, String type, String date_of_membership, int books_issued, String name, String address, String phone_no) {
        this.member_id = member_id;
        this.type = type;
        this.date_of_membership = date_of_membership;
        this.books_issued = books_issued;
        this.max_book_limit = 5;
        this.name = name;
        this.address = address;
        this.phone_no = phone_no;
    }

    public String getName() {
        return name;
    }

    public int get_Member() {
        return member_id;
    }

    public int getBooks_issued() {
        return books_issued;
    }

    public int getMax_book_limit() {
        return max_book_limit;
    }

    public void inc_Book_Issued() {
        books_issued++;
    }
    public void dec_Book_Issued() {
        if(books_issued > 0) {
            books_issued--;
        }
    }
    public double getFine() {
        return fineAmount;
    }

    public void setFineAmount(double fineAmount) {
        this.fineAmount = fineAmount;
    }

    public void pay_bill() {
        if (fineAmount > 0) {
            System.out.println("Fine of $" + fineAmount + " has been paid.");
            fineAmount = 0.0;
        } else {
            System.out.println("No fine to pay.");
        }
    }
}
