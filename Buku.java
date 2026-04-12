public class Buku {
    String kodeBuku, judul;
    int tahunTerbit;

    //konstruktor untuk menerima kode, judul dan tahun terbit buku yg dipinjam
    Buku(String kode, String judul, int tahun) {
        this.kodeBuku    = kode;
        this.judul       = judul;
        this.tahunTerbit = tahun;
    }

    //method untuk menampilkan informasi buku yg dipinjam
    void tampilBuku() {
        System.out.println("Kode: " + kodeBuku + " | Judul: " + judul + " | Tahun: " + tahunTerbit);
    }
}