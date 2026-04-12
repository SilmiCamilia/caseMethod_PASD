public class Peminjaman {
    Mahasiswa mhs; //berguna untuk memanggil objek dari kelas mahasiswa
    Buku      buku; //berguna untuk memanggil objek dari kelas buku
    int       lamaPinjam, batasPinjam = 5, terlambat, denda; //batas peminjaman buku adalah 5 hari

    //konstruktor untuk menyimpan data peminjam serta informasi peminjaman yg dilakukan
    Peminjaman(Mahasiswa mhs, Buku buku, int lamaPinjam) {
        //dapat melihat siapa aja yg melewati batas peminjaman dan 
        this.mhs        = mhs;
        this.buku       = buku;
        this.lamaPinjam = lamaPinjam;
        hitungDenda(); //dihitung denda yg harus dibayar
    }

    //method untuk mengitung denda
    void hitungDenda() {
        terlambat = lamaPinjam - batasPinjam;
        if (terlambat < 0) terlambat = 0;
        denda = terlambat * 2000;
    }

    //method untuk menampilan informasi peminjaman
    void tampilPeminjaman() {
        System.out.println(mhs.nama + " | " + buku.judul +
                " | Lama: " + lamaPinjam +
                " | Terlambat: " + terlambat +
                " | Denda: " + denda);
    }
}