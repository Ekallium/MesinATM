import java.util.Scanner;
    public class TemplateATM {
        public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            int saldo = 4575000;
            System.out.println("---------------------------------");
            System.out.println("  SELAMAT DATANG DI BANK JALI !");
            System.out.println("---------------------------------");
        
            while (true){
                System.out.println("PILIHAN MENU");
                System.out.println("1. Cek Saldo");
                System.out.println("2. Tarik Tunai");
                System.out.println("3. Setor Tunai");
                System.out.println("4. Keluar");
                int choice = scan.nextInt();
                switch (choice){
                    case 1:
                        System.out.println("Saldo Anda Tersisa : Rp." + saldo);
                    default :
                        System.out.println("Dimohon masukkan angka yang terdapat pada pilihan");
                }
            }
        }
    }