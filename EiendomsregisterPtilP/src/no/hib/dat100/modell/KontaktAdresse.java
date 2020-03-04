package no.hib.dat100.modell;

/**
 * Kontaktadresse for eiere.
 * @version 1.0
 * @author Lars Michael Kristensen
 *
 */
public class KontaktAdresse {

	private String vei;
	private int nummer;

	private int postnummer;

	private String by;
	private String land;

	/**
	 * Konstruerer kontaktadresse objekt.
	 * @param vei vei for kontaktadressen
	 * @param nummer nummer p� veien
	 * @param postnummer postnummer p� by
	 * @param by by for adressen
	 * @param land land for addressen
	 */
	public KontaktAdresse(String vei, int nummer, int postnummer, String by,
			String land) {
		this.vei = vei;
		this.nummer = nummer;
		this.postnummer = postnummer;
		this.by = by;
		this.land = land;
	}

	/**
	 * Formaterer kontakt adresse som streng.
	 * @return formatert adresse
	 */
	public String formaterAdresse() {
		return
		vei + " " + nummer + "\n" +
		postnummer + " " + by + "\n" +
		land + "\n";
	}
}
