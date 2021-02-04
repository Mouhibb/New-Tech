package entity;

public class Activit� {
	
	private static int code_activit�;
	private Direction direction;
	private int ann�e;
	private Theme theme;
	private String intitul�;
	private double indicateur;
	private Source_Information sourceI;
	private String etat;
	private Source_Financi�re sourceF;
	private Partenaire partenaire;
	private String periode;
	
	
	
	
	
	public Activit�(Direction direction, int ann�e, Theme theme, String intitul�, double indicateur,
			Source_Information sourceI, String etat, Source_Financi�re sourceF, Partenaire partenaire, String periode) {
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
	public Activit�(int direction2, int ann�e2, int theme2, String intitul�2, double indicateur2, String source_inf,
			String etat2, String source_fin, int partenaire2, String periode2) {
		Direction.code_direction = direction2;
		this.ann�e = ann�e2;
		Theme.code_theme = theme2;
		this.intitul� = intitul�2;
		this.indicateur = indicateur2;
		this.sourceI.sourceInf = source_inf;
		this.etat = etat2;
		this.sourceF.sourceFin = source_fin;
		Partenaire.code_partenaire = partenaire2;
		this.periode = periode2;
		
	}
	public static int getCode_activit�() {
		return code_activit�;
	}
	public static void setCode_activit�(int code_activit�) {
		Activit�.code_activit� = code_activit�;
	}
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	public int getAnn�e() {
		return ann�e;
	}
	public void setAnn�e(int ann�e) {
		this.ann�e = ann�e;
	}
	public Theme getTheme() {
		return theme;
	}
	public void setTheme(Theme theme) {
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
	public Source_Information getSourceI() {
		return sourceI;
	}
	public void setSourceI(Source_Information sourceI) {
		this.sourceI = sourceI;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Source_Financi�re getSourceF() {
		return sourceF;
	}
	public void setSourceF(Source_Financi�re sourceF) {
		this.sourceF = sourceF;
	}
	public Partenaire getPartenaire() {
		return partenaire;
	}
	public void setPartenaire(Partenaire partenaire) {
		this.partenaire = partenaire;
	}
	public String getPeriode() {
		return periode;
	}
	public void setPeriode(String periode) {
		this.periode = periode;
	}
	
	
	
	
	
	
	

}
