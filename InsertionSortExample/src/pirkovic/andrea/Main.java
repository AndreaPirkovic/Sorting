package pirkovic.andrea;
/*jedan od najjednostavnijih nacina za sortiranje,  sortiranje umetanjem je efikasno za male skupove podataka
Sortiranje umetanjem je prilagodljivo po prirodi, odnosno prikladno je za skupove podataka koji su već delimično sortirani.*/
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random rand = new Random();
		int[] numbers = new int[10]; // pravljenje niza od 10 elemenata 

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = rand.nextInt(100); // punjenje niza slucajno odabranim brojevima od 1 do 100 
		}
		System.out.println("Niz pre sortiranja:");//Stampa niza pre sortiranja
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
		
		for (int i = 1; i < numbers.length; i++) {
			
			int temp = numbers[i]; // trenutni element niza na indeksu 1 se izdvaja kao privremena promenljiva
			
			int j = i - 1; // ispitivani element koji se nalazi na prethodnom indeksu 0
			while (j >= 0 && numbers[j] > temp) { //uslov da je indeks elementa veci od nule i da je element koji se poredi sa privremenom promenljivom veci od privremene promenljive
				numbers[j + 1] = numbers[j]; // ukoliko je uslov ispunjen, vrsi se pomeranje ispitivanog elementa za jedno mesto (ono koje mu je prethodilo) u nizu 
				j--; // umanjenje indeksa za 1
			}
			numbers[j + 1] = temp; // ispitivani element niza postaje promenljiva i sa njim se vrsi poredjenje narednog elementa nakon toga
		}
	

		System.out.println("Niz posle sortiranja:");// stampa niza posle sortiranja
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	
		
	
	}
}