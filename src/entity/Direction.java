package entity;

public class Direction {
	
	 static int code_direction;
	private String nom_direction;
	private String Email;
	
	
	
	
	
	public Direction(String nom_direction2, String email2) {
		this.nom_direction=nom_direction2;
		this.Email=email2;
	}
	public Direction() {
		
	}
	
	public Direction(String nom) {
       this.nom_direction=nom;
    }
	public  int getCode_direction() {
		return code_direction;
	}
	public  void setCode_direction(int code_direction) {
		Direction.code_direction = code_direction;
	}
	public String getNom_direction() {
		return nom_direction;
	}
	public void setNom_direction(String nom_direction) {
		this.nom_direction = nom_direction;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	

}
