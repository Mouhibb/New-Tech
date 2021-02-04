package entity;

public class Utilisateur {

	private static int code_utilisateur;
	private String login;
	private String password;
	private String type;
	
	
	
	
	
	
	public Utilisateur(String nom, String login2, String type2) {
this.login=nom;
this.password=login2;
this.type=type2;
}
	public Utilisateur() {
		
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public static int getCode_utilisateur() {
		return code_utilisateur;
	}
	public static void setCode_utilisateur(int code_utilisateur) {
		Utilisateur.code_utilisateur = code_utilisateur;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
