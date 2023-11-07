import java.util.*;
import java.io.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        System.out.println("enter , code");
        Scanner sc= new Scanner(System.in);
        String code= sc.nextLine();
        lzw obj =new lzw() ;
        obj.compresion(code);
    }
}