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
    static String history[][] = new String[3][200];
    static boolean menu = false;
    static boolean online = true;
    static boolean exitMenu = false;
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
                while (exitMenu) {
                    Exit();
                }
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
                exitMenu = true;
                break;
            case 2:
                tariktunai();
                exitMenu = true;
                break;
            case 3:
                SetorTunai();
                exitMenu = true;
                break;
            case 4:
                TransferDana();
                exitMenu = true;
                break;
            case 5:
                Pembayaran();
                exitMenu = true;
                break;
            case 6:
                MutasiRekening();
                exitMenu = true;
                break;
            case 7:
                GantiPin();
                exitMenu = true;
                break;
            case 8:
                exitMenu = true;
                break;
            default:
                System.out.println("====================================");
                System.out.println("Harap Masukkan Menu Yang Valid !");
                System.out.println("====================================");
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

    static void TransferDana() {
        System.out.println("---------------------------------------------");
        System.out.print("Masukkan rekening tujuan : ");
        int rekening = scan.nextInt();
        scan.nextLine();
        for (int tujuan = 0; tujuan < infoAkun.length; tujuan++) {
            if (rekening == nominal[tujuan][2] && rekening != nominal[user][2]) {
                System.out.println("---------------------------------------------");
                System.out.print("Jumlah Uang Yang Ingin Anda Transfer : ");
                int transfer = scan.nextInt();
                scan.nextLine();
                if (transfer < nominal[user][1] && transfer > 0) {
                    System.out.println("---------------------------------------------");
                    System.out.println("           STRUK ATM BANK JALI        ");
                    System.out.println("---------------------------------------------");
                    System.out.println("Nama          : " + infoAkun[user][1]);
                    System.out.println("No Rekening   : " + nominal[user][2]);
                    System.out.println("Keterangan    : Transfer Dana");
                    System.out.println("---------------------------------------------");
                    System.out.println("Nama          : " + infoAkun[tujuan][1]);
                    System.out.println("No Rekening   : " + nominal[tujuan][2]);
                    System.out.println("Keterangan    : " + transfer);
                    System.out.println("---------------------------------------------");
                    nominal[user][1] -= transfer;
                    nominal[tujuan][1] += transfer;

                    String catatanTransaksi = "Keterangan : Transfer Dana" +
                            "\nNama       : " + infoAkun[tujuan][1] +
                            "\nRekening   : " + nominal[tujuan][2] +
                            "\nNominal    : Rp" + transfer;
                    String catatanTransaksiMasuk = "Keterangan : Dana Masuk" +
                            "\nNama       : " + infoAkun[user][1] +
                            "\nRekening   : " + nominal[user][2] +
                            "\nNominal    : Rp" + transfer;
                    history[user][jumlahTransaksi] = catatanTransaksi;
                    history[tujuan][jumlahTransaksi] = catatanTransaksiMasuk;
                    jumlahTransaksi++;
                    break;
                } else {
                    System.out.println("---------------------------------------------");
                    System.out.println("Saldo Anda Tidak Mencukupi");
                    break;
                }
            }
        }
    }

    static void Pembayaran() {
        System.out.println("\t||=================||");
        System.out.println("\t|| MENU PEMBAYARAN ||");
        System.out.println("\t|| 1. Listrik      ||");
        System.out.println("\t|| 2. PDAM         ||");
        System.out.println("\t||=================||");
        System.out.print("Masukan Input : ");
        int menuPembayaran = scan.nextInt();
        scan.nextLine();
        if (menuPembayaran == 1) {
            System.out.println("------------------------------------");
            System.out.println("\tPembayaran Listrik");
            System.out.println("------------------------------------");
            System.out.print("Masukkan ID Pelanggan       : ");
            int tokenListrik = scan.nextInt();
            System.out.print("Masukkan nominal Pembayaran : Rp");
            int nomPembayaranL = scan.nextInt();
            scan.nextLine();
            if (nomPembayaranL <= nominal[user][1] - 50000 && nomPembayaranL > 0) {
                nominal[user][1] -= nomPembayaranL;
                System.out.println("------------------------------------------------");
                System.out.println("            STRUK ATM BANK JALI");
                System.out.println("------------------------------------------------");
                System.out.println("Nama        : " + infoAkun[user][1]);
                System.out.println("No Rekening : " + nominal[user][2]);
                System.out.println("Nominal     : Rp" + nomPembayaranL);
                System.out.println("Keterangan  : Pembayaran Listrik");
                System.out.println("------------------------------------------------");
                System.out.println("Nomor Meter : " + tokenListrik);
                System.out.println("Sisa saldo  : Rp" + nominal[user][1]);
                System.out.printf("Token       :");
                int min = 1000;
                int max = 9999;
                for (int x = 0; x < 5; x++) {
                    int random = (int) (Math.random() * (max - min + 1) + min);
                    System.out.print("-");
                    System.out.print(random);
                }
                System.out.println();
                String catatanTransaksi = "Keterangan : Pembayaran Listrik" +
                        "\nNomor Meter: " + tokenListrik +
                        "\nNominal    : Rp" + nomPembayaranL;
                history[user][jumlahTransaksi] = catatanTransaksi;
                jumlahTransaksi++;
            } else {
                System.out.println("------------------------------------------------");
                System.out.println("Saldo Anda tidak mencukupi untuk pembayaran ini.");
            }
        } else if (menuPembayaran == 2) {
            System.out.println("------------------------------------");
            System.out.println("\tPembayaran PDAM");
            System.out.println("------------------------------------");
            System.out.print("Masukkan No PDAM Anda       : ");
            int noPDAM = scan.nextInt();
            System.out.print("Masukkan Nominal Pembayaran : Rp");
            int nomPembayaranP = scan.nextInt();
            scan.nextLine();
            if (nomPembayaranP < nominal[user][1] - 50000 && nomPembayaranP > 0) {
                nominal[user][1] -= nomPembayaranP;
                System.out.println("------------------------------------------------");
                System.out.println("            STRUK ATM BANK JALI");
                System.out.println("------------------------------------------------");
                System.out.println("Nama         : " + infoAkun[user][1]);
                System.out.println("No Rekening  : " + nominal[user][2]);
                System.out.println("Nominal      : Rp" + nomPembayaranP);
                System.out.println("Keterangan   : Pembayaran PDAM");
                System.out.println("------------------------------------------------");
                System.out.println("No.Pelanggan : " + noPDAM);
                System.out.println("Sisa saldo   : Rp" + nominal[user][1]);
                String catatanTransaksi = "Keterangan : Pembayaran PDAM" +
                        "\nNomor Meter: " + noPDAM +
                        "\nNominal    : Rp" + nomPembayaranP;
                history[user][jumlahTransaksi] = catatanTransaksi;
                jumlahTransaksi++;
            } else {
                System.out.println("------------------------------------------------");
                System.out.println("Saldo Anda tidak mencukupi untuk pembayaran ini.");
            }
        } else {
            System.out.println("------------------------------------------------");
            System.out.println("Input tidak valid");
        }
    }

    static void MutasiRekening() {
        System.out.println("====================================");
        System.out.println("          HISTORY TRANSAKSI");
        System.out.println("------------------------------------");
        for (String transaksi : history[user]) {
            if (transaksi != null) {
                System.out.println(transaksi);
                System.out.println("====================================");
            }
        }
    }

    static void GantiPin() {
        System.out.println("\n---------------------------------");
        System.out.print("Masukkan PIN ATM baru: ");
        int pinBaru = scan.nextInt();
        scan.nextLine();
        if (pinBaru > 999999 || pinBaru < 100000) {
            System.out.println("PIN baru harus 6 digit");
        } else if (pinBaru == nominal[user][0]) {
            System.out.println("PIN lama dan PIN baru tidak boleh sama");
        } else {
            System.out.println("========================================");
            System.out.println("PENGGANTIAN PIN BERHASIL !");
            System.out.println("PIN ATM berhasil diganti menjadi " + pinBaru);
            System.out.println("========================================");
            nominal[user][0] = pinBaru;
        }
    }
    static void Exit() {
        System.out.println("-----------------------------------------------------");
        System.out.print("Apakah anda ingin melakukan transaksi lain (Y/T) ? : ");
        char exit = scan.nextLine().charAt(0);
        System.out.println("-----------------------------------------------------");
        if (exit == 'y' || exit == 'Y') {
            menu = false;
            exitMenu = false;
        } else if (exit == 't' || exit == 'T') {
            System.out.println("--------------------------------------------");
            System.out.println("  TERIMAKASIH TELAH MENGGUNAKAN BANK JALI");
            System.out.println("--------------------------------------------");
            online = false;
            menu = false;
            exitMenu = false;
        } else {
            System.out.println("---------------------------------");
            System.out.println("Masukkan input yang valid (Y/T) !");
            System.out.println("---------------------------------");
        }
    }
}