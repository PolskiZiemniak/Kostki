import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String wybor;
        int iloscKostek;
        iloscKostek = wprowadzIloscKostek();
        while(true) {
            int[] tab = losujliczby(iloscKostek);
            for (int i = 0; i < iloscKostek; i++) {
                int a = i+1;
                System.out.println("Kostka " + a + ": " + tab[i]);
            }
            System.out.println("Liczba uzyskanych punktów: "+obliczPunkty(tab));
            System.out.println("Czy chcesz powtórzyć? (t/n)");
            wybor = scan.nextLine();
            if(wybor.equals("n")){
                break;
            }
        }

    }

    /*************************************************************
     * nazwa:                  wprowadzIloscKostek
     * opis:                   prosi użytkownika o ilość kostek z zakresu 3-10
     * parametry:              brak
     * zwracany typ i opis:    int - zwraca ilość wpisanych kostek
     * autor:                  85926928513
    **************************************************************/
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

    /*************************************************************
     * nazwa:                  losujLiczby
     * opis:                   losuje wybraną ilość liczb z zakresu 1-6
     * parametry:              int i - ilość losowanych kostek
     * zwracany typ i opis:    int[] - zawiera każdą wylosowaną liczbę
     * autor:                  85926928513
     ************************************************************/
    public static int[] losujliczby(int i){
        Random rand = new Random();
        int[] tab = new int[i];
        for(int j = 0; j < i; j++){
            tab[j] = rand.nextInt(6) + 1;
        }
        return tab;
    }

    /*************************************************************
     * nazwa:                  obliczPunkty
     * opis:                   sumuje razem wszystkie powtarzające się liczby
     * parametry:              int[] tab - przyjmuje tablice z wylosowanymi liczbami
     * zwracany typ i opis:    int - zawiera sumę powtarzających się liczb
     * autor:                  85926928513
     ************************************************************/
    public static int obliczPunkty(int[] tab){
        int sum = 0;
        boolean[] counted = new boolean[tab.length];
        for(int i = 0; i < tab.length; i++){
            if(!counted[i]) {
                int count = 0;
                for (int j = 0; j < tab.length; j++) {
                    if (tab[i] == tab[j]) {
                        count++;
                        counted[j] = true;
                    }
                }
                if (count > 1) {
                    sum += tab[i] * count;
                }
            }
        }
        return sum;
    }
}