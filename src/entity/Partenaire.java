package entity;

public class Partenaire {
	
static int code_partenaire;
private String nom_partenaire;
private String Email;




public Partenaire(String nom, String emaile) {
this.nom_partenaire=nom;
this.Email=emaile;
}
public Partenaire() {
}


public static int getCode_partenaire() {
	return code_partenaire;
}
public static void setCode_partenaire(int code_partenaire) {
	Partenaire.code_partenaire = code_partenaire;
}
public String getNom_partenaire() {
	return nom_partenaire;
}
public void setNom_partenaire(String nom_partenaire) {
	this.nom_partenaire = nom_partenaire;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}

}
