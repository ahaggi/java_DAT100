package no.hib.dat100;

import becker.robots.*;

public class Labyrint3 {

   public static void main(String[] args){

      MazeCity maze = new MazeCity(11,10);

      Flasher cheese = new Flasher(maze, 9,9);

      RobotSE mouse = new RobotSE(maze, 0, 0, Direction.EAST);

      // Her settes inn en algoritme for å få musen gjennom
      // labyrinten og finne og spise osten.
     // mouse.move();
      while(!mouse.canPickThing()) {
          mouse.turnRight();
          while(!mouse.frontIsClear()) {
              mouse.turnLeft();
          }
          mouse.move();
      }
      mouse.pickThing();

   }
}


