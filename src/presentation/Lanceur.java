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
		
		// Ajout �tudiants
		GestionEtudiants.ajouterEtudiant(etudiant1);
		GestionEtudiants.ajouterEtudiant(etudiant2);
		
		// Affichage �tudiants
		System.out.println(GestionEtudiants.trouverEtudiant(etudiant1.getNumEtudiant()));
		System.out.println(GestionEtudiants.trouverEtudiant(etudiant2.getNumEtudiant()));
		
		// Modification �tudiants (inversion)
		GestionEtudiants.modifierEtudiant("4", etudiant2);
		GestionEtudiants.modifierEtudiant("5", etudiant1);

		// Devraient �tre invers�s
		System.out.println(GestionEtudiants.trouverEtudiant(etudiant1.getNumEtudiant()));
		System.out.println(GestionEtudiants.trouverEtudiant(etudiant2.getNumEtudiant()));
		
		// Ajout �cole
		GestionEcoles.ajouterEcole(ecole);
		
		// Inscription �tudiants dans une �cole
		GestionInscriptions.inscrireEtudiant(etudiant1, ecole);
		GestionInscriptions.inscrireEtudiant(etudiant2, ecole);
		
		// V�rification bien inscrits
		GestionInscriptions.afficherEtudiants(ecole.getNomEcole());
		
		// D�sinscription �cole
		GestionInscriptions.desinscrireEtudiant(etudiant1, ecole);
		GestionInscriptions.desinscrireEtudiant(etudiant2, ecole);
		
		// Suppression �cole
		GestionEcoles.supprimerEcole(ecole.getNomEcole());
		
		// Suppression �tudiants
		GestionEtudiants.supprimerEtudiant(etudiant1.getNom());
		GestionEtudiants.supprimerEtudiant(etudiant2.getNom());
	}

}
