package pirkovic.andrea;

import java.util.Random;
/*MergeSort  prvo deli ceo niz iterativno na jednake polovine, i nastavlja da deli svaki od tih nizova na pola sve dok se ne postignu atomicne vrednosti, odnosno dok ne dodje do pojedinacnih vrednosti koje se dalje ne mogu deliti na dva.
Nakon što je niz podeljen na najmanje jedinice, počinje ponovo spajanje elemenata na osnovu međusobnog poređenja veličine elemenata. Prvo se upoređuju elementi za svaku listu, a zatim ih kombinujemo u novu listu na sortiran način.
Pogodan je za large datasets i brz je i odrzava poredak elemenata niza i sa duplikatima*/

public class Main {
  public static void main(String[] args) {

    Random rand = new Random();
    int[] numbers = new int[10]; // kreiranje niza od 10 slucajno odabranih celih brojeva

    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = rand.nextInt(10); /// brojevi od 1 do 10 slucajno odabrani
    }

    System.out.println("Before:"); // stampa pocetnog niza
    printArray(numbers);

    mergeSort(numbers); // pozivanje metode za mergeSort

    System.out.println("\nAfter:"); // stampa niza posle sortiranja
    printArray(numbers);
  }

/* metoda za mergeSort nad inicijalnim nizom*/
  private static void mergeSort(int[] inputArray) { 


    int inputLength = inputArray.length;
    
    if (inputLength < 2) { // ako je pocetni niz manji od 2 elementa prekinuti izvrsavanje
      return;
    }
    
    int midIndex = inputLength / 2; // podela inicijalnog niza na 2 polovine i određivanje veličine dva podniza koja će se naknadno spojiti
    int[] leftHalf = new int[midIndex];  
    int[] rightHalf = new int[inputLength - midIndex];
    
    for (int i = 0; i < midIndex; i++) {
      leftHalf[i] = inputArray[i]; // punjenje podataka u dva privremena niza
    }
    for (int i = midIndex; i < inputLength; i++) {
      rightHalf[i - midIndex] = inputArray[i];
    }
    
    mergeSort(leftHalf); // pozivanje metode mergeSort na d levim i desnim nizom rekurzivno, sto ce podeliti oba niza do poslednjeg nedeljivog elementa
    mergeSort(rightHalf);
    
    merge(inputArray, leftHalf, rightHalf); // spajanje elemenata oba podeljena niza pomocu metode Merge u novi niz koji je sortiran 
  }
/* metoda Merge za spajanje podeljenih nizova*/
  private static void merge (int[] inputArray, int[] leftHalf, int[] rightHalf) { 
    int leftSize = leftHalf.length;
    int rightSize = rightHalf.length;

    // Početni indeksi prvog i drugog podniza
    int i = 0, j = 0, k = 0;
    
    while (i < leftSize && j < rightSize) { // poredjenje elemenata levog i desnog niza i spajanje elemenata u novi niz sa indeksom k
      if (leftHalf[i] <= rightHalf[j]) {
        inputArray[k] = leftHalf[i]; // ako je element levog niza veci od elementa desnog niza on se dodaje u novi niz, i prelazi se na poredjenje sledeceg elementa
        i++;
      }
      else {
        inputArray[k] = rightHalf[j]; // obrnuto, ako je element desnog niza veci od elementa levog niza on se dodaje u novi niz i prelazi se na poredjenje sledeceg elementa niza
        j++;
      }
      k++;
    }
    
    while (i < leftSize) { // kopiranje preostalih elemenata levog niza u novi niz ako je bio neparan broj elemenata u levom i desnom nizu
      inputArray[k] = leftHalf[i];
      i++;
      k++;
    }
    
    while (j < rightSize) {// kopiranje preostalih elemenata desnog niza u novi niz ako je bio neparan broj elemenata u levom i desnom nizu
      inputArray[k] = rightHalf[j];
      j++;
      k++;
    }
    
  }
/* metoda za stampanje elemenata niza*/
  private static void printArray(int[] numbers) {
    for (int i = 0; i < numbers.length; i++) {
      System.out.println(numbers[i]); 
    }
  }
}