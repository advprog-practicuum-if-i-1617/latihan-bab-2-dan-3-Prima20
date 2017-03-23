/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package overloading;

import java.util.Scanner;



public class Overloading {

public static String ubah(int angka){
    String[] bil = {"","satu","dua","tiga","empat","lima","enam","tujuh","delapan",
        "sembilan","sepuluh","sebelas"};
    String temp = "";
    if(angka<12){
        temp = "" + bil[angka];
    }
    else if(angka<20){
        temp = ubah(angka-10) + " belas ";
    }
    else if(angka<100){
        temp = ubah(angka/10) + " puluh " + ubah(angka%10);
    }
    else if(angka<200){
        temp = "seratus " + ubah(angka-100);
    }
    else if(angka<1000){
        temp = ubah(angka/100) + " ratus " + ubah(angka%100);
    }
    else if(angka<2000){
        temp = "seribu " + ubah(angka-1000);
    }
    else{
        System.out.println("range tidak sampai");
    }
    return temp;
}
 public static String ubah(String huruf){
     String[] bil = {"","satu","dua","tiga","empat","lima","enam","tujuh","delapan",
        "sembilan","sepuluh","sebelas"};
     String[] angka = {"0","1","2","3","4","5","6","7","8","9","10","11"};
     int spasi = 0;
     String temp = "";
     String temp1 = huruf;
     if(huruf.equals("seribu")){
             temp = "1000";
         }
     else if(huruf.length() <= 8){
        for(int j=0; j<12; j++){
          if(huruf.equals(bil[j])){
              temp = angka[j];
          }
      }
     } 
     else if(huruf.contains("belas") && !huruf.contains("seratus")){
            temp = "1" + ubah(huruf.substring(0,huruf.length()-6));
        }
     else if(huruf.contains("puluh") && !huruf.contains("seratus")){
         int i = 0;
         while(huruf.charAt(i) != ' '){
             i++;
         }
         if(huruf.length() == i+6){
             String a = huruf.substring(0,i);
             temp = ubah(a) + "0";
         }
         else{
         String a = huruf.substring(0,i);
         String b = huruf.substring(i+7);
         temp = ubah(a) + ubah(b);
         }
     }
     else if(huruf.contains("seratus") && !huruf.contains("ratus")){
         int i = huruf.length()-1;
         int count = 0;
         while(huruf.charAt(i) != ' '){
             count++;
             i--;
         }
         if(huruf.equals("seratus")){
             temp = "100";
         }
         else if(huruf.equals("seratus sebelas")){
             temp = "111";
         }
         else if(huruf.equals("seratus dua belas")){
             temp = "112";
         }
         else if(huruf.length() <= 15){
             temp = "10" + ubah(huruf.substring(8));
         }
         else{
            temp ="1" + ubah(huruf.substring(8));
         }
     }
     else if(huruf.contains("ratus") && !huruf.contains("seratus")){
         int i = 0;
         while(huruf.charAt(i) != ' '){
             i++;
         }
         if(huruf.length() == i+6){
             temp = ubah(huruf.substring(0,i)) + "00";
         }
         else if(huruf.length() <= i+14){
             temp = ubah(huruf.substring(0,i)) + "0" + ubah(huruf.substring(i+7));
         }
         else{
             temp = ubah(huruf.substring(0,i)) + huruf.substring(i+7);
         
         }
     }
     return temp;
    }
public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    boolean t = true;
    while(t){
    System.out.println("range 1 - 1000");
    System.out.println("1. Konversi angka ke huruf");
    System.out.println("2. Konversi huruf ke angka");
    System.out.println("3. keluar");
    System.out.println("Masukan pilihan : ");
    int x = scan.nextInt();
    switch(x){
        case 1:
            System.out.println("Masukan angka : ");
            int y = scan.nextInt();
            System.out.println("" + ubah(y) );
            break;
        case 2:
            System.out.println("Masukan huruf : ");
            scan.nextLine();
            String h = scan.nextLine();
            System.out.println("" + ubah(h));
            break;
        case 3:
            t = false;
            
    }
    }
    

}
    
}
