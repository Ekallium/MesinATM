import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] id = { "Admin", "Ekal", "Alya", "Ervin" };
        int[] pin = { 0, 332005, 123456, 123456 };
        int[] saldo = { 999999999, 1000000, 1000000, 1000000 };
        int[] uang = { 999999999, 1000000, 1000000, 1000000 };
        boolean login = true;
        System.out.println("---------------------------------");
        System.out.println("  SELAMAT DATANG DI BANK JALI !");
        System.out.println("---------------------------------");
        while (login) {

        }

        while (!login) {
            System.out.println("\nPILIHAN MENU");
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
            }

            System.out.print("\nApakah Anda ingin melakukan transaksi lain (Y/T): ");

        }
    }
}
