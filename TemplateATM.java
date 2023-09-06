import java.util.Scanner;

public class TemplateATM {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int saldo = 4575000;
        int uang = 500000;
        System.out.println("---------------------------------");
        System.out.println("  SELAMAT DATANG DI BANK JALI !");
        System.out.println("---------------------------------");
        boolean menu = true;
        boolean transaksi = false;
        while (menu) {
            do {
                System.out.println("PILIHAN MENU");
                System.out.println("1. Cek Saldo");
                System.out.println("2. Tarik Tunai");
                System.out.println("3. Setor Tunai");
                System.out.println("4. Keluar");
                int choice = scan.nextInt();
                scan.nextLine();

                switch (choice) {
                    case 1: 
                    case 2:
                    case 3:
                    case 4:
                    default:
                        System.out.println("masukkan angka yang terdapat pada pilihan");
                        menu = true;
                        break;
                }
            } while (!transaksi);
            System.out.println("Apakah anda ingin melakukan transaksi lain Y/T");
            char exit = scan.next().charAt(0);

            if (exit == 't' || exit == 'T') {
                System.out.println("Terimakasih Telah menggunakan Bank Jali");
                System.exit(0);
            } else if (exit == 'y' || exit == 'Y') {
                menu = true;
            }
        }
    }
}
