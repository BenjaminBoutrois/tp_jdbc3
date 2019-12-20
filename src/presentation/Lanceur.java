package presentation;
import java.util.ArrayList;
import java.util.List;

import metier.*;
import service.*;

public class Lanceur {

	public static void main(String[] args) {
		
		Etudiant etudiant1 = new Etudiant("4", "Morgan", "Franca");
		Etudiant etudiant2 = new Etudiant("5", "Loik", "Breton");
		
		Ecole ecole = new Ecole("ENSUP", "1 bis Avenue du 8 mai 1945");
		
		// Ajout étudiants
		GestionEtudiants.ajouterEtudiant(etudiant1);
		GestionEtudiants.ajouterEtudiant(etudiant2);
		
		// Affichage étudiants
		System.out.println(GestionEtudiants.trouverEtudiant(etudiant1.getNumEtudiant()));
		System.out.println(GestionEtudiants.trouverEtudiant(etudiant2.getNumEtudiant()));
		
		// Modification étudiants (inversion)
		GestionEtudiants.modifierEtudiant("4", etudiant2);
		GestionEtudiants.modifierEtudiant("5", etudiant1);

		// Devraient être inversés
		System.out.println(GestionEtudiants.trouverEtudiant(etudiant1.getNumEtudiant()));
		System.out.println(GestionEtudiants.trouverEtudiant(etudiant2.getNumEtudiant()));
		
		// Ajout école
		GestionEcoles.ajouterEcole(ecole);
		
		// Inscription étudiants dans une école
		GestionInscriptions.inscrireEtudiant(etudiant1, ecole);
		GestionInscriptions.inscrireEtudiant(etudiant2, ecole);
		
		// Vérification bien inscrits
		GestionInscriptions.afficherEtudiants(ecole.getNomEcole());
		
		// Désinscription école
		GestionInscriptions.desinscrireEtudiant(etudiant1, ecole);
		GestionInscriptions.desinscrireEtudiant(etudiant2, ecole);
		
		// Suppression école
		GestionEcoles.supprimerEcole(ecole.getNomEcole());
		
		// Suppression étudiants
		GestionEtudiants.supprimerEtudiant(etudiant1.getNom());
		GestionEtudiants.supprimerEtudiant(etudiant2.getNom());
	}

}
