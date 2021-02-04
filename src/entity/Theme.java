package entity;

public class Theme {
	
static int code_theme;
private String nom_theme;



public Theme (String nom) {
	this.nom_theme=nom;
}
public Theme () {
	
}

public static int getCode_theme() {
	return code_theme;
}
public static void setCode_theme(int code_theme) {
	Theme.code_theme = code_theme;
}
public String getNom_theme() {
	return nom_theme;
}
public void setNom_theme(String nom_theme) {
	this.nom_theme = nom_theme;
}

}
