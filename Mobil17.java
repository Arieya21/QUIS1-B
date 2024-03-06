class Mobil17 {
    String nama;
    int cc;
    int hargaBeli;
    int thnProduksi;

    Mobil17(String nama, int cc, int hargaBeli, int thnProduksi) {
        nama = nama;
        cc = cc;
        hargaBeli = hargaBeli;
        thnProduksi = thnProduksi;
    }

    double hitungPajak() {
        if (cc > 1500) {
            return 0.1 * hargaBeli;
        } else {
            return 0.75 * hargaBeli;
        }
    }

    double hitungBiayaPerawatan() {
        if (thnProduksi < 2010) {
            return 0.08 * hargaBeli;
        } else {
            return 0.05 * hargaBeli;
        }
    }

    double hitungBiayaTotal() {
        return hitungPajak() + hitungBiayaPerawatan();
    }

    void printData() {
        System.out.println("Nama: " + nama);
        System.out.println("CC: " + cc);
        System.out.println("Harga Beli: " + hargaBeli);
        System.out.println("Tahun Produksi: " + thnProduksi);
        System.out.println("Biaya Pajak: " + hitungPajak());
        System.out.println("Biaya Perawatan: " + hitungBiayaPerawatan());
        System.out.println("Biaya Total: " + hitungBiayaTotal());
        System.out.println();
    }

    public static void main(String[] args) {
        Mobil17[] mobilData = {
            new Mobil17("Mobil1", 1600, 30000, 2012),
            new Mobil17("Mobil2", 1400, 25000, 2008),
            new Mobil17("Mobil3", 1800, 35000, 2015)
        };

        int countMobil2010 = 0;
        double totalBiayaPerawatan = 0;

        for (Mobil17 mobil : mobilData) {
            if (mobil.thnProduksi > 2010) {
                totalBiayaPerawatan += mobil.hitungBiayaPerawatan();
                countMobil2010++;
            }
        }

        if (countMobil2010 > 0) {
            double rataRataBiayaPerawatan = totalBiayaPerawatan / countMobil2010;
            System.out.println("Rata-rata Biaya Perawatan Mobil > 2010: " + rataRataBiayaPerawatan);
        } else {
            System.out.println("Tidak ada mobil dengan tahun produksi > 2010.");
        }

        double maxBiayaTotal = 0;
        Mobil17 mobilTerbesar = null;

        for (Mobil17 mobil : mobilData) {
            if (mobil.cc > 1500 && mobil.thnProduksi < 2010) {
                double biayaTotal = mobil.hitungBiayaTotal();
                if (biayaTotal > maxBiayaTotal) {
                    maxBiayaTotal = biayaTotal;
                    mobilTerbesar = mobil;
                }
            }
        }

        if (mobilTerbesar != null) {
            System.out.println("Mobil dengan Biaya Total Terbesar:");
            mobilTerbesar.printData();
        } else {
            System.out.println("Tidak ada mobil dengan cc > 1500 dan tahun produksi < 2010.");
        }
    }
}
