package com.librarySystem.Person;

import com.librarySystem.Record.memberRecord;

public class Faculty extends memberRecord {

    public Faculty(int member_id, String type, String date_of_membership, int no_books_issued, String name, String address, String phone_no) {
        super(member_id, type, date_of_membership, no_books_issued, name, address, phone_no);
    }
}
