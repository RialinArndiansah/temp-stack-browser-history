package com.github.affandes.kuliah.pm;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        browserHistory browser = new browserHistory();
        int pilihan = 0;

        do {
            System.out.println("\n=== BROWSsER HISTORY MENU ===");
            System.out.println("1. View History");
            System.out.println("2. Browse Website");
            System.out.println("3. Back");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");

            try {
                pilihan = scanner.nextInt();
                scanner.nextLine(); // Membersihkan buffer

                switch (pilihan) {
                    case 1:
                        browser.view();
                        break;

                    case 2:
                        System.out.print("Masukkan URL website: ");
                        String url = scanner.nextLine();
                        browser.browse(url);
                        break;

                    case 3:
                        browser.back();
                        break;

                    case 4:
                        System.out.println("Terima kasih telah menggunakan program!");
                        break;

                    default:
                        System.out.println("Pilihan tidak valid. Silakan pilih 1-4.");
                }
            } catch (Exception e) {
                System.out.println("Input tidak valid. Masukkan angka 1-4.");
                scanner.nextLine(); // Membersihkan input yang tidak valid
                pilihan = 0;
            }

        } while (pilihan != 4);

        scanner.close();
    }
}

class browserHistory {
    private Stack<String> history;

    public browserHistory() {
        history = new Stack<>();
    }

    public void view() {
        System.out.println("\nRiwayat Browser:");
        if (history.isEmpty()) {
            System.out.println("Tidak ada history");
            return;
        }

        System.out.println("\nUrutan dari yang terbaru:");
        String[] tempHistory = history.toArray(new String[0]);
        for (int i = tempHistory.length - 1; i >= 0; i--) {
            System.out.println((tempHistory.length - i) + ". " + tempHistory[i]);
        }
    }

    public void browse(String url) {
        history.push(url);
        System.out.println("\nMengakses website: " + url);
        System.out.println("Website berhasil ditambahkan ke history");
    }

    public String back() {
        if (history.isEmpty()) {
            System.out.println("\nTidak bisa kembali - History kosong");
            return null;
        }

        String lastWebsite = history.pop();
        System.out.println("\nKembali dari: " + lastWebsite);

        if (!history.isEmpty()) {
            String currentWebsite = history.peek();
            System.out.println("Sekarang di: " + currentWebsite);
            return currentWebsite;
        } else {
            System.out.println("Tidak ada website sebelumnya");
            return null;
        }
    }
}
