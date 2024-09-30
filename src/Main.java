import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int iloscKostek;
        iloscKostek = wprowadzIloscKostek();

        int[] tab = losujliczby(iloscKostek);
        for(int i = 0; i < iloscKostek; i++){
            System.out.println("Kostka "+i+" "+tab[i]);
        }

    }
    public static int wprowadzIloscKostek(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ile kostek chcesz rzucić (3 - 10)");
        int ilosc = 0;
        while(ilosc < 3 || ilosc > 10) {
            try {
                ilosc = scan.nextInt();
                if(ilosc < 3 || ilosc > 10){
                    System.out.println("Liczba musi być z zakresu 3-10");
                }
            } catch (InputMismatchException e) {
                System.out.println("Musisz podać liczbę całkowitą");
                scan.nextLine();
            }
        }
        return ilosc;
    }
    public static int[] losujliczby(int i){
        Random rand = new Random();
        int[] tab = new int[i];
        for(int j = 0; j < i; j++){
            tab[j] = rand.nextInt(6) + 1;
        }
        return tab;
    }
    public static int obliczPunkty(int[] tab){
        int sum = 0;
        for(int i = 0; i < tab.length; i++){
            for(int j = 1; j < tab.length-1; j++){
                if(tab[i] == tab[i]){
                    sum += tab[i];
                    break;
                }
            }
        }
    }
}