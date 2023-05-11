package banque;

public class Main {

	public static void main(String[] args) {
		// afficher un message de bienvenue
		System.out.println("Bienvenue à la GBA, que souhaitez-vous faire ?");

		// créer un objet Comptecourant
		CompteCourant svin = new CompteCourant("Svin", 12000);
		svin.afficherSolde();
		svin.deposerArgent(300);
		svin.retirerArgent(12700);

	}

}