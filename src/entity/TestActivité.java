package entity;

public class TestActivité {

	
	private static int code_activité;
	private String direction;
	private int année;
	private String theme;
	private String intitulé;
	private double indicateur;
	private String sourceI;
	private String etat;
	private String sourceF;
	private int partenaire;
	private String periode;
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public int getAnnée() {
		return année;
	}
	public void setAnnée(int année) {
		this.année = année;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getIntitulé() {
		return intitulé;
	}
	public void setIntitulé(String intitulé) {
		this.intitulé = intitulé;
	}
	public double getIndicateur() {
		return indicateur;
	}
	public void setIndicateur(double indicateur) {
		this.indicateur = indicateur;
	}
	public String getSourceI() {
		return sourceI;
	}
	public void setSourceI(String sourceI) {
		this.sourceI = sourceI;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getSourceF() {
		return sourceF;
	}
	public void setSourceF(String sourceF) {
		this.sourceF = sourceF;
	}
	public int getPartenaire() {
		return partenaire;
	}
	public void setPartenaire(int partenaire) {
		this.partenaire = partenaire;
	}
	public String getPeriode() {
		return periode;
	}
	public void setPeriode(String periode) {
		this.periode = periode;
	}
	public TestActivité(String direction, int année, String theme, String intitulé, double indicateur, String sourceI,
			String etat, String sourceF, int partenaire, String periode) {
		super();
		this.direction = direction;
		this.année = année;
		this.theme = theme;
		this.intitulé = intitulé;
		this.indicateur = indicateur;
		this.sourceI = sourceI;
		this.etat = etat;
		this.sourceF = sourceF;
		this.partenaire = partenaire;
		this.periode = periode;
	}
	public static int getCode_activité() {
		return code_activité;
	}
	public static void setCode_activité(int code_activité) {
		TestActivité.code_activité = code_activité;
	}
	
	
	
}
