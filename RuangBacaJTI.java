import java.util.Scanner;
public class RuangBacaJTI {

    public static void main(String[] args) {
        // data mahasiswa
        Mahasiswa[] mahasiswas = {
            new Mahasiswa("22001", "Andi",  "Teknik Informatika"),
            new Mahasiswa("22002", "Budi",  "Teknik Informatika"),
            new Mahasiswa("22003", "Citra", "Sistem Informasi Bisnis")
        };

        // data buku
        Buku[] bukus = {
            new Buku("B001", "Algoritma",   2020),
            new Buku("B002", "Basis Data",  2019),
            new Buku("B003", "Pemrograman", 2021),
            new Buku("B004", "Fisika",      2024)
        };

        // data peminjaman 
        Peminjaman[] pinjamans = {
            new Peminjaman(mahasiswas[0], bukus[0], 7),   // Andi meminjam buku algoritma selama 7 hari
            new Peminjaman(mahasiswas[1], bukus[1], 3),   // Budi meminjam buku basis data selama 3 hari
            new Peminjaman(mahasiswas[2], bukus[2], 10),  // Citra meminjam buku emrograman selama 10 hari
            new Peminjaman(mahasiswas[2], bukus[3], 6),   // Citra meminjam buku fisika selama 6 hari
            new Peminjaman(mahasiswas[0], bukus[1], 4)    // Andi meminjam buku basis data selama 4 hari
        };

        SistemPeminjaman sistem = new SistemPeminjaman(mahasiswas, bukus, pinjamans); //pembuatan object
        Scanner liberari = new Scanner(System.in);

        //menu
        int pilihan;
        do {
            System.out.println("\n=== SISTEM PEMINJAMAN RUANG BACA JTI ===");
            System.out.println("1. Tampilkan Mahasiswa");
            System.out.println("2. Tampilkan Buku");
            System.out.println("3. Tampilkan Peminjaman");
            System.out.println("4. Urutkan Berdasarkan Denda");
            System.out.println("5. Cari Berdasarkan NIM");
            System.out.println("6. Buku Paling Sering Dipinjam");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = liberari.nextInt();
            liberari.nextLine();

            switch (pilihan) {
                case 1:
                    sistem.tampilSemuaMahasiswa();
                    break;
                case 2:
                    sistem.tampilSemuaBuku();
                    break;
                case 3:
                    sistem.tampilSemuaPeminjaman();
                    break;
                case 4:
                    sistem.insertionSortByDenda();
                    break;
                case 5:
                    System.out.print("Masukkan NIM: ");
                    String nim = liberari.nextLine();
                    sistem.cariByNIM(nim);
                    break;
                     case 6:
                    sistem.tampilBukuSeringDipinjam();
                    break;
                case 0:
                    System.out.println("Program selesai");
                    break;
                default:
                    System.out.println("Pilihan tidak ditemukan");
            }
        } while (pilihan != 0);
    }
}

