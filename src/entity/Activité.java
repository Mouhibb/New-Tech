package entity;

public class Activité {
	
	private static int code_activité;
	private Direction direction;
	private int année;
	private Theme theme;
	private String intitulé;
	private double indicateur;
	private Source_Information sourceI;
	private String etat;
	private Source_Financiére sourceF;
	private Partenaire partenaire;
	private String periode;
	
	
	
	
	
	public Activité(Direction direction, int année, Theme theme, String intitulé, double indicateur,
			Source_Information sourceI, String etat, Source_Financiére sourceF, Partenaire partenaire, String periode) {
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
	public Activité(int direction2, int année2, int theme2, String intitulé2, double indicateur2, String source_inf,
			String etat2, String source_fin, int partenaire2, String periode2) {
		Direction.code_direction = direction2;
		this.année = année2;
		Theme.code_theme = theme2;
		this.intitulé = intitulé2;
		this.indicateur = indicateur2;
		this.sourceI.sourceInf = source_inf;
		this.etat = etat2;
		this.sourceF.sourceFin = source_fin;
		Partenaire.code_partenaire = partenaire2;
		this.periode = periode2;
		
	}
	public static int getCode_activité() {
		return code_activité;
	}
	public static void setCode_activité(int code_activité) {
		Activité.code_activité = code_activité;
	}
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	public int getAnnée() {
		return année;
	}
	public void setAnnée(int année) {
		this.année = année;
	}
	public Theme getTheme() {
		return theme;
	}
	public void setTheme(Theme theme) {
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
	public Source_Financiére getSourceF() {
		return sourceF;
	}
	public void setSourceF(Source_Financiére sourceF) {
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
