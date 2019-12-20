package metier;

public class Etudiant extends Personne implements Travail {
	private String numEtudiant;
	
	// Constructeur
	public Etudiant(String numEtudiant, String prenom, String nom) {
		super(prenom, nom);
		this.numEtudiant = numEtudiant;
	}
	
	public String faireExamen() {
		return prenom + " " + nom + " a fait l'examen.";
	}

	public String getNumEtudiant() {
		return numEtudiant;
	}

	public void setNumEtudiant(String numEtudiant) {
		this.numEtudiant = numEtudiant;
	}

	@Override
	public String toString() {
		return "Etudiant [numEtudiant=" + numEtudiant + ", prenom=" + prenom + ", nom=" + nom + "]";
	}

	@Override
	public void faireLesDevoirs() {
		System.out.println(prenom + " " + nom + " a fait ses devoirs.");
		
	}
}
