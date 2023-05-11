package banque;

public class CompteCourant {

	// --------------------------Attributs de la classe
	private String nomClient;
	private int solde;
	private int decouvertAutorise;

	// --------------------------Constructeur
	public CompteCourant(String nomClient, int solde) {
		this.nomClient = nomClient;
		this.solde = solde;
		this.decouvertAutorise = -120;
	}

	// --------------------------Méthodes

	// afficher le solde du compte courant
	public void afficherSolde() {
		System.out.println("L'argent disponible sur votre compte est de " + this.solde);
	}

	// fonction pour le dépot d'argent
	public void deposerArgent(int montant) {
		System.out.println("Quel montant souhaitez-vous déposer sur votre compte ?");
		// ajoute le montant au compte
		this.solde += montant;
		System.out.println("Vous venez d'ajouter " + montant + " euros sur votre compte.");
		System.out.println("Votre solde est désormais de " + this.solde + " euros");
	}

	// fonction pour retirer de l'argent
	public void retirerArgent(int montant) {
		System.out.println("Quel montant souhaitez-vous retirer sur votre compte ?");
		// si solde supérieur au montant retiré
		if (this.solde - montant >= 0) {
			this.solde -= montant;
			System.out.println("Vous venez de retirer " + montant + " euros sur votre compte. Il vous reste "
					+ this.solde + "euros.");
		}
		// si solde inférieur au montant retiré
		else {
			if (this.solde - montant >= this.decouvertAutorise) {
				this.solde -= montant;
				System.out.println("Vous venez de retirer " + montant + " euros sur votre compte. Il vous reste "
						+ this.solde + "euros. Attention, vous êtes à découvert");
			} else {
				System.out.println("Opération impossible, vous n'avez pas assez d'argent sur votre compte");
			}
		}
	}
}// fin de la classe
