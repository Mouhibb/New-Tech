package entity;

public class TestActivit� {

	
	private static int code_activit�;
	private String direction;
	private int ann�e;
	private String theme;
	private String intitul�;
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
	public int getAnn�e() {
		return ann�e;
	}
	public void setAnn�e(int ann�e) {
		this.ann�e = ann�e;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getIntitul�() {
		return intitul�;
	}
	public void setIntitul�(String intitul�) {
		this.intitul� = intitul�;
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
	public TestActivit�(String direction, int ann�e, String theme, String intitul�, double indicateur, String sourceI,
			String etat, String sourceF, int partenaire, String periode) {
		super();
		this.direction = direction;
		this.ann�e = ann�e;
		this.theme = theme;
		this.intitul� = intitul�;
		this.indicateur = indicateur;
		this.sourceI = sourceI;
		this.etat = etat;
		this.sourceF = sourceF;
		this.partenaire = partenaire;
		this.periode = periode;
	}
	public static int getCode_activit�() {
		return code_activit�;
	}
	public static void setCode_activit�(int code_activit�) {
		TestActivit�.code_activit� = code_activit�;
	}
	
	
	
}
