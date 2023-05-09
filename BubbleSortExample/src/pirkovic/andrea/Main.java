package pirkovic.andrea;

import java.util.Random;
/*Bubble sort je najjednostavniji algoritam za sortiranje, koji upoređuje dva susedna elementa i 
zamenjuje im mesta dok ne budu u predviđenom redosledu. 
Isti proces se nastavlja za preostale iteracije.Nakon svake iteracije, najveći element 
među nesortiranim elementima se stavlja na kraj. 
Niz se sortira kada se svi nesortirani elementi postave na svoje ispravne pozicije.
Spor je i ne koristi se za large data sets*/

public class Main {
  public static void main(String[] args) {

    Random rand = new Random();
    int[] numbers = new int[10]; // Sortiranje niza od 10 slucajno odabranih brojeva
    
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = rand.nextInt(100); //Slucajno odabrani brojevi od 1 do 100
    }
    /* Stampa niza pre sortiranja*/
    System.out.println("Before:");
    for (int i = 0; i < numbers.length; i++) {
        System.out.println(numbers[i]);}
    
    /* postupak za sortiranje niza */
    boolean ispravnoUredjeni =true; // pretpostavka da su susedni elementi vec ispravno uredjeni
    
    while (ispravnoUredjeni) {
    	ispravnoUredjeni = false; // ako susedni elementi nisu ispravno uredjeni onda izvrsi zamenu mesta
       for (int i = 0; i < numbers.length - 1; i++) {
        if (numbers[i] > numbers[i + 1]) { // ako je prethodni broj veci od narednog zameni im mesta
        	ispravnoUredjeni = true;
          int temp = numbers[i]; // pomocna promenljiva temp koja se uvodi za zamenu mesta elemenata u nizu
          numbers[i] = numbers[i + 1];
          numbers[i + 1] = temp;
        }
      }
    }

    /* Stampa niza posle sortiranja*/
    System.out.println("\nAfter:");
    for (int i = 0; i < numbers.length; i++) {
      System.out.println(numbers[i]);
    }
   
  }
  }

  