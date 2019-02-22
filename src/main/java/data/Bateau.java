package data;

/**
 * un super commentaire avec des éééé et des ààà
 * 辣手神探
 * @author Administrateur
 *
 */
public class Bateau {
	private String nom;

	public Bateau() {
		super();

	}

	public Bateau(String nom) {
		super();
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Bateau [nom=" + nom + "]";
	}

}
