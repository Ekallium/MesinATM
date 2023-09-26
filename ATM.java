import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int saldo = 800000000;
        String id = "Ekal";
        int pin = 332005;
        int uang = 500000;
        System.out.println("---------------------------------");
        System.out.println("  SELAMAT DATANG DI BANK JALI !");
        System.out.println("---------------------------------");
        System.out.print("Masukkan ID Anda : ");
        String inputId = scan.next();
        System.out.print("\nMasukkan PIN Anda : ");
        int inputPin = scan.nextInt();
        if (inputId.equals(id) && inputPin == pin) {
            System.out.println("\t\tLogin Berhasil !");
            System.out.println("||==================||");
            System.out.println("||   PILIHAN MENU   ||");
            System.out.println("||__________________||");
            System.out.println("||  1. Cek Saldo    ||");
            System.out.println("||  2. Tarik Tunai  ||");
            System.out.println("||  3. Setor Tunai  ||");
            System.out.println("||  4. Keluar       ||");
            System.out.println("||==================||");
            int pilihan = scan.nextInt();
            switch (pilihan) {
                case 1:
                    System.out.println("Saldo Anda: Rp" + saldo);
                    break;
                case 2:
                    System.out.println("Jumlah Uang Yang Ingin Anda Tarik\nRp");
                    int tarik = scan.nextInt();
                    if (tarik > saldo - 49999) {
                        System.out.println("Saldo Anda Tidak Mencukupi");
                    } else if (tarik % 50000 != 0) {
                        System.out.println("Penarikan tunai harus kelipatan Rp50.000");
                    } else {
                        saldo -= tarik;
                        uang += tarik;
                        System.out.println("Penarikan Tunai Berhasil\nSisa saldo Anda : Rp" + saldo +
                                "\nSisa uang anda : Rp" + uang);
                    }
                    break;
                case 3:
                    System.out.println("Jumlah uang yang ingin Anda setorkan\nRp");
                    int setor = scan.nextInt();
                    if (setor > uang) {
                        System.out.println("Uang Anda tidak mencukupi untuk melakukan transaksi ini");
                    } else if (setor % 50000 != 0) {
                        System.out.println("Penyetoran tunai harus kelipatan Rp50.000");
                    } else {
                        saldo += setor;
                        uang -= setor;
                        System.out.println("Penyetoran Tunai Berhasil\nSisa saldo Anda : Rp" + saldo +
                                "\nSisa uang anda : Rp" + uang);
                    }
                    break;
                case 4:
                    System.out.println("Terimakasih Telah Menggunakan Bank Jali");
                    break;
                default:
                    System.out.println("Harap Masukkan Menu Yang Valid !");
            }
            scan.close();
        } else {
            System.out.println("  Login Gagal !\nID atau PIN Salah");
        }
    }
}
