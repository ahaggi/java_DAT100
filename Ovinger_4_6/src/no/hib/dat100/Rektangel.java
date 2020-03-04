package no.hib.dat100;

import easyIO.*;

public class Rektangel {
	private char fyll;
	private int hogde;
	private int breidde;

 public Rektangel() {
	fyll = '*';
	hogde = 4;
	breidde = 3;

	
 }
 
 public Rektangel(char fyll) {
	this.fyll = fyll;
 }
 public Rektangel(int h, int b) {
	fyll = '*';
	hogde = h;
	breidde = b;
 }
 public Rektangel(char f, int h, int b) {
		fyll = f;
		hogde = h;
		breidde = b;
 }
 
 public int giAreal(){
	 return hogde*breidde;
 }
 
 public int giOmkrets(){
	 return (hogde+breidde)*2;
 }
 
 public void tegn(){
		Out skjerm = new Out();
		System.out.println("Rektangelen høgde er: "+ hogde);
		System.out.println("Rektangelen breidde er: "+ breidde);
		System.out.println("Fyll er: "+ fyll);
	    for (int i = 0; i < hogde; i++) {
	    	for (int j = 0; j < breidde; j++) {
	    	    skjerm.out(fyll);
			}
    	    skjerm.outln();
		}
 }

 
}


