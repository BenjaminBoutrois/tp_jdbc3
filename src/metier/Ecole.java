package metier;

import java.util.List;

public class Ecole {
	private String nomEcole;
	private String adresseEcole;
	
	// Constructeur
	public Ecole(String nomEcole, String adresse) {
		super();
		this.nomEcole = nomEcole;
		this.adresseEcole = adresse;
	}

	public String getNomEcole() {
		return nomEcole;
	}

	public void setNomEcole(String nomEcole) {
		this.nomEcole = nomEcole;
	}

	public String getAdresse() {
		return adresseEcole;
	}

	public void setAdresse(String adresse) {
		this.adresseEcole = adresse;
	}
	
	public void afficherEtudiants(List<Etudiant> listeEtudiants)
	{
		System.out.println("Liste des étudiants :");
		
		for(Etudiant etudiant : listeEtudiants)
		{
			System.out.println(etudiant);
		}
	}

	@Override
	public String toString() {
		return "Ecole [nomEcole=" + nomEcole + ", adresse=" + adresseEcole + "]";
	}
}
