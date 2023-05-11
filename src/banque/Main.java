package banque;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// créer un objet Compte courant
		CompteCourant svin = new CompteCourant("Svin", 12000);

		// récupérer des informations de la console
		Scanner scanner = new Scanner(System.in);

		svin.bienvenue();
	}

}// fin de la classe Main