package oppgave3;

public class Sang{
	
public enum Sjanger {POP , ROCK , ANNENT}

private String navn;
private Sjanger sjanger;  

public Sang(String s, Sjanger sjn){
	navn=s;
	sjanger=sjn;
}


public String getNavn() {
	return navn;
}


public void setNavn(String navn) {
	this.navn = navn;
}


public void setSjanger(Sjanger sjanger) {
	this.sjanger = sjanger;
}


public Sjanger getSjanger(){
	return sjanger;
}

public void skrivUt(){
	System.out.println("Navn: "+navn+" , Sjanger: "+sjanger);
}
}
