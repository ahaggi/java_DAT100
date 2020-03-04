package Eks3FraBok;
import easyIO.*;

public class Person {
	private String navn;
	private String adresse;
	private String telefonnr;
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelefonnr() {
		return telefonnr;
	}
	public void setTelefonnr(String telefonnr) {
		this.telefonnr = telefonnr;
	}
	
	void lesData(){
		In tastatur = new In();
		System.out.print("oppgi navn : ");
		navn = tastatur.inLine();
		System.out.print("oppgi adresse : ");
		adresse = tastatur.inLine();
		System.out.print("oppgi telefonnummer : ");
		telefonnr = tastatur.inLine();		
	}
	
	void skrivData(){
		System.out.println("Navn               : " + navn);
		System.out.println("Adresse            : " + adresse);
		System.out.println("Telefonnummer      : " + telefonnr);				
	}	

}//class
