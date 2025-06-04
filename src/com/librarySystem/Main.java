package com.librarySystem;

import com.librarySystem.Book.Book;
import com.librarySystem.Library.Librarian;
import com.librarySystem.Library.Library;
import com.librarySystem.Record.memberRecord;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Library library = new Library();
        Librarian librarian = new Librarian(library);

        // Örnek kitap ve üye
        library.new_Book(1, "Orhan Pamuk", "Kırmızı Saçlı Kadın", 75.0, true, "1. Baskı", 2);
        library.new_Book(2, "Sabahattin Ali", "Kürk Mantolu Madonna", 90.0, true, "3. Baskı", 4);
        memberRecord member1 = new memberRecord(1001, "Öğrenci", "01.01.2024", 0, "Ahmet", "İstanbul", "05001234567");
        library.get_Reader().add(member1);

        while (true) {
            printMenu();
            int choice = readInt("Seçiminiz: ");

            switch (choice) {
                case 1 -> searchBook(librarian);
                case 2 -> issueBook(librarian, library, member1);
                case 3 -> returnBook(librarian, library, member1);
                case 4 -> verifyMember(librarian);
                case 5 -> showBookDetails(library);
                case 6 -> createAndPayFine(librarian, library, member1);
                case 7 -> {
                    System.out.println("Çıkış yapılıyor...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Geçersiz seçim.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n=== KÜTÜPHANE SİSTEMİ ===");
        System.out.println("1. Kitap Ara");
        System.out.println("2. Kitap Ödünç Ver");
        System.out.println("3. Kitap İade Al");
        System.out.println("4. Üye Doğrula");
        System.out.println("5. Kitap Bilgisi Göster");
        System.out.println("6. Fatura Oluştur");
        System.out.println("7. Çıkış");
    }

    private static void searchBook(Librarian librarian) {
        System.out.print("Kitap adı girin: ");
        String title = scanner.nextLine();
        Book found = librarian.search_book(title);
        if (found != null) {
            found.display();
        } else {
            System.out.println("Kitap bulunamadı.");
        }
    }

    private static void issueBook(Librarian librarian, Library library, memberRecord member) {
        int bookId = readInt("Kitap ID: ");
        String memberName = readLine("Üye Adı: ");
        int memberId = readInt("Üye ID: ");

        if (!librarian.verify_Member(memberName, memberId)) {
            System.out.println("Üye doğrulanamadı.");
            return;
        }

        Book book = library.get_Books().stream()
                .filter(b -> b.getBookId() == bookId)
                .findFirst()
                .orElse(null);

        if (book != null) {
            librarian.issue_Book(book, member);
        } else {
            System.out.println("Kitap bulunamadı.");
        }
    }

    private static void returnBook(Librarian librarian, Library library, memberRecord member) {
        int bookId = readInt("İade edilecek kitap ID: ");
        for (Book book : library.get_Books()) {
            if (book.getBookId() == bookId) {
                librarian.return_Book(book, member);
                System.out.println("Kitap iade alındı.");
                return;
            }
        }
        System.out.println("Kitap bulunamadı.");
    }

    private static void verifyMember(Librarian librarian) {
        String name = readLine("Üye Adı: ");
        int id = readInt("Üye ID: ");
        boolean verified = librarian.verify_Member(name, id);
        System.out.println(verified ? "Üye doğrulandı." : "Üye bulunamadı.");
    }

    private static void showBookDetails(Library library) {
        int id = readInt("Kitap ID girin: ");
        library.show_book(id);
    }

    private static void createAndPayFine(Librarian librarian, Library library, memberRecord member) {
        int id = readInt("Kitap ID (geciken): ");
        for (Book book : library.get_Books()) {
            if (book.getBookId() == id) {
                librarian.create_Bill(member, book);
                System.out.println("Ceza miktarı: $" + member.getFine());
                member.pay_bill();
                return;
            }
        }
        System.out.println("Kitap bulunamadı.");
    }

    private static int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Lütfen bir sayı girin: ");
        }
        return scanner.nextInt();
    }

    private static String readLine(String prompt) {
        System.out.print(prompt);
        scanner.nextLine();
        return scanner.nextLine();
    }
}
