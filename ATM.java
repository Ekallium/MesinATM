import java.util.Scanner;

public class ATM {

    static Scanner scan = new Scanner(System.in);
    static String[][] infoAkun = {
            { "Ekal", "Moch. Haikal Putra Muhajir" },
            { "Alya", "Alya Ajeng Ayu" },
            { "Erfin", "Erfin Jauhari Dwi Brian" }
    };
    static int[][] nominal = {
            { 332005, 1000000, 23417601 },
            { 181104, 1000000, 23417602 },
            { 170405, 1000000, 23417603 }
    };
    static String[][] history = new String[3][100];
    static boolean menu = false;
    static boolean online = true;
    static int user = -1;
    static int jumlahTransaksi = 0;

    public static void main(String[] args) {
        while (online) {
            System.out.println("---------------------------------");
            System.out.println("  SELAMAT DATANG DI BANK JALI !");
            System.out.println("---------------------------------");
            while (!menu) {
                Login();
            }
            while (menu) {
                Menu();
            }
        }
    }

    static void Menu() {
        System.out.println("====================================");
        System.out.println("     ||======================||");
        System.out.println("     ||     PILIHAN MENU     ||");
        System.out.println("     ||______________________||");
        System.out.println("     ||  1. Info Akun        ||");
        System.out.println("     ||  2. Tarik Tunai      ||");
        System.out.println("     ||  3. Setor Tunai      ||");
        System.out.println("     ||  4. Transfer Dana    ||");
        System.out.println("     ||  5. Pembayaran Lain  ||");
        System.out.println("     ||  6. Mutasi Rekening  ||");
        System.out.println("     ||  7. Ganti PIN        ||");
        System.out.println("     ||  8. Keluar           ||");
        System.out.println("     ||======================||");
        System.out.println("====================================");
        System.out.print("Masukkan Input : ");
        int pilihan = scan.nextInt();
        scan.nextLine();
        switch (pilihan) {
            case 1:
                infoAkun();
                break;
            case 2:
                tariktunai();
                break;
            case 3:
                SetorTunai();
                break;
            case 4:
            case 5:
            case 6:
                MutasiRekening();
                break;
            case 7:
            case 8:
            default:
        }
    }

    static void Login() {
        System.out.print("Masukkan ID Anda  : ");
        String inputId = scan.next();
        System.out.print("Masukkan PIN Anda : ");
        int inputPin = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < infoAkun.length; i++) {
            if (inputId.equals(infoAkun[i][0]) && inputPin == nominal[i][0]) {
                user = i;
                System.out.println("------------------------------");
                System.out.println("\tLogin Berhasil !");
                System.out.println("------------------------------");
                menu = true;
            }
        }
        if (!menu) {
            System.out.println("------------------------------");
            System.out.println("\tLogin Gagal !");
            System.out.println("------------------------------");
        }
    }

    static void infoAkun() {
        System.out.println("====================================");
        System.out.println("Nama     : " + infoAkun[user][1]);
        System.out.println("Rekening : " + nominal[user][2]);
        System.out.println("Saldo    : Rp" + nominal[user][1]);
        System.out.println("====================================");
    }

    static void tariktunai() {
        System.out.println("---------------------------------------------");
        System.out.print("Jumlah Uang Yang Ingin Anda Tarik : ");
        int tarik = scan.nextInt();
        scan.nextLine();
        if (tarik <= nominal[user][1] - 50000) {
            if (tarik % 50000 == 0 && tarik > 0) {
                nominal[user][1] -= tarik;
                System.out.println("---------------------------------------------");
                System.out.println("            STRUK ATM BANK JALI          ");
                System.out.println("---------------------------------------------");
                System.out.println("Nama        : " + infoAkun[user][1]);
                System.out.println("No Rekening : " + nominal[user][2]);
                System.out.println("Nominal     : Rp" + tarik);
                System.out.println("Keterangaan : Tarik Tunai");
                String catatanTransaksi = "Keterangan : Tarik Tunai" +
                        "\nNominal    : Rp" + tarik;
                history[user][jumlahTransaksi] = catatanTransaksi;
                jumlahTransaksi++;
            } else {
                System.out.println("---------------------------------------");
                System.out.println("Penarikan harus kelipatan Rp50.000");
            }
        } else {
            System.out.println("---------------------------------------------");
            System.out.println("Saldo Anda Tidak Mencukupi");
        }
    }

    static void SetorTunai() {
        System.out.println("-----------------------------------------------------");
        System.out.print("Jumlah uang yang ingin Anda setorkan : Rp");
        int setor = scan.nextInt();
        scan.nextLine();
        if (setor % 50000 == 0) {
            if (setor > 0) {
                nominal[user][1] += setor;
                System.out.println("------------------------------------------------");
                System.out.println("            STRUK ATM BANK JALI");
                System.out.println("------------------------------------------------");
                System.out.println("Nama         : " + infoAkun[user][1]);
                System.out.println("No Rekening  : " + nominal[user][2]);
                System.out.println("Nominal      : Rp" + setor);
                System.out.println("Keterangan   : Setor Tunai");
                System.out.println("------------------------------------------------");
                String catatanTransaksi = "Keterangan : Setor Tunai" +
                        "\nNominal    : Rp" + setor;
                history[user][jumlahTransaksi] = catatanTransaksi;
                jumlahTransaksi++;
            } else {
                System.out.println("-----------------------------------------------------");
                System.out.println("Harap masukkan nominal yang valid !");
            }
        } else {
            System.out.println("-----------------------------------------------------");
            System.out.println("Penyetoran tunai harus kelipatan Rp50.000");
        }
    }

    static void MutasiRekening() {
        System.out.println("====================================");
        System.out.println("          HISTORY TRANSAKSI");
        System.out.println("------------------------------------");
        // For Each Loop Untuk Output Semua Isi Array History
        for (String transaksi : history[user]) {
            // Pemilihan Dengan Kondisi Jika Isi Array Bukan Null
            if (transaksi != null) {
                // Print Isi Data Array
                System.out.println(transaksi);
                System.out.println("====================================");
            }
        }
    }
}