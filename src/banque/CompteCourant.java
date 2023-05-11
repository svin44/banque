package banque;

import java.util.Scanner;

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

	// récupérer des informations de la console
	Scanner sc = new Scanner(System.in);

	// message menu principal
	// utilisé également après chaque opération pour revenir automatiquement au menu
	// principal
	public void bienvenue() {
		System.out.println("Bienvenue à la GBA, veuillez préciser l'opération souhaitée:");
		System.out.println("1- consulter votre solde");
		System.out.println("2- Déposer de l'argent");
		System.out.println("3- Retirer de l'argent");
		int choixOp = sc.nextInt();

		switch (choixOp) {
		case 1: {
			afficherSolde();
			break;
		}
		case 2: {
			System.out.println("Quel montant souhaitez-vous déposer sur votre compte ?");
			deposerArgent(sc.nextInt());
			break;
		}
		case 3: {
			System.out.println("Quel montant souhaitez-vous retirer sur votre compte ?");
			retirerArgent(sc.nextInt());
			break;
		}
		default:
			System.out.println("Choix incorrect");
			break;
		}

	}

	// afficher le solde du compte courant
	public void afficherSolde() {
		System.out.println("L'argent disponible sur votre compte est de " + this.solde);
		bienvenue();
	}

	// fonction pour le dépot d'argent
	public void deposerArgent(int montant) {

		// ajoute le montant au compte

		this.solde += montant;
		System.out.println("Vous venez d'ajouter " + montant + " euros sur votre compte.");
		System.out.println("Votre solde est désormais de " + this.solde + " euros");
		bienvenue();
	}

	// fonction pour retirer de l'argent
	public void retirerArgent(int montant) {

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

		bienvenue();
	}

}// fin de la classe
