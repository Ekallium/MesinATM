import java.util.Scanner;
    public class TemplateATM {
        public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            int saldo = 4575000 ;
            int uang = 500000;
            System.out.println("---------------------------------");
            System.out.println("  SELAMAT DATANG DI BANK JALI !");
            System.out.println("---------------------------------");
            boolean exit = false;
        
            while (!exit){
                System.out.println("PILIHAN MENU");
                System.out.println("1. Cek Saldo");
                System.out.println("2. Tarik Tunai");
                System.out.println("3. Setor Tunai");
                System.out.println("4. Keluar");
                int choice = scan.nextInt();
                scan.nextLine();
                switch (choice){
                    case 1:
                    case 2:            
                    case 3:
                    case 4:
                    default :
                        System.out.println("Dimohon masukkan angka yang terdapat pada pilihan diatas");
                }   
                System.out.println("Apakah anda ingin melakukan transaksi lain Y/T"); 
                    char transaksi = scan.next().charAt(0);
                    if (!exit){
                    if (transaksi =='t' || transaksi == 'T' ){
                    System.out.println("Terimakasih Telah menggunakan Bank Jali");
                    exit = true;
                    }  
                    else if (transaksi =='y' || transaksi == 'Y'){

                        exit = false;
                    }
                }
            }

            }
        }
