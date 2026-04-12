public class SistemPeminjaman {
    //array
    Mahasiswa[]  daftarMhs;
    Buku[]       daftarBuku;
    Peminjaman[] daftarPinjam;
    int          jumlahPinjam;

    //konstruktor untuk pemanggilan data peminjaman pada object class lain
    SistemPeminjaman(Mahasiswa[] mhs, Buku[] buku, Peminjaman[] pinjam) {
        this.daftarMhs    = mhs;
        this.daftarBuku   = buku;
        this.daftarPinjam = pinjam;
        this.jumlahPinjam = pinjam.length;
    }

    //method untuk menampilkan data mahasiswa
    void tampilSemuaMahasiswa() {
        System.out.println("\nDaftar Mahasiswa:");
        for (Mahasiswa m : daftarMhs) m.tampilMahasiswa();
    }

    //method untuk menampilkan data buku
    void tampilSemuaBuku() {
        System.out.println("\nDaftar Buku:");
        for (Buku b : daftarBuku) b.tampilBuku();
    }

    //method untuk menampilkan data peminjaman
    void tampilSemuaPeminjaman() {
        System.out.println("\nData Peminjaman:");
        for (int i = 0; i < jumlahPinjam; i++) daftarPinjam[i].tampilPeminjaman();
    }

    //insertion sorting desc (dari denda terbesar)
    void insertionSortByDenda() {
        // disalin agar array asli tidak berubah
        Peminjaman[] salinan = new Peminjaman[jumlahPinjam];
        for (int i = 0; i < jumlahPinjam; i++) salinan[i] = daftarPinjam[i];

        for (int i = 1; i < jumlahPinjam; i++) {
            Peminjaman temp = salinan[i];
            int j = i;
            while (j > 0 && salinan[j - 1].denda < temp.denda) {
                salinan[j] = salinan[j - 1];
                j--;
            }
            salinan[j] = temp;
        }

        System.out.println("\nSetelah diurutkan (Denda terbesar):");
        for (int i = 0; i < jumlahPinjam; i++) salinan[i].tampilPeminjaman();
    }

    //searching
    void cariByNIM(String nimCari) {
        // salinan dan urutan berdasarkan nim (insertion sort asc)
        Peminjaman[] sorted = new Peminjaman[jumlahPinjam];
        for (int i = 0; i < jumlahPinjam; i++) sorted[i] = daftarPinjam[i];

        for (int i = 1; i < jumlahPinjam; i++) {
            Peminjaman temp = sorted[i];
            int j = i;
            while (j > 0 && sorted[j - 1].mhs.nim.compareTo(temp.mhs.nim) > 0) {
                sorted[j] = sorted[j - 1];
                j--;
            }
            sorted[j] = temp;
        }
        
        int low  = 0;
        int high = jumlahPinjam - 1;
        int found = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = sorted[mid].mhs.nim.compareTo(nimCari);
            if (cmp == 0) {
                found = mid;
                high  = mid - 1;  // cari ke kiri untuk menemukan semua
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (found == -1) {
            System.out.println("Data peminjaman dengan NIM " + nimCari + " tidak ditemukan.");
        } else {
            System.out.println("Hasil pencarian NIM " + nimCari + ":");
            for (int i = found; i < jumlahPinjam && sorted[i].mhs.nim.equals(nimCari); i++) {
                sorted[i].tampilPeminjaman();
            }
        }
    }
}