package no.hib.dat100;

import becker.robots.*;

public class Labyrint2 {

   public static void main(String[] args){

      // Set up the maze (row1..4)
      //    1     _ _ _ *
      //    2    |      _|
      //    3   >  | |   |
      //    4    |_|_ _|_|

      City maze = new City();

      new Wall(maze, 1, 2, Direction.SOUTH);
      new Wall(maze, 1, 3, Direction.SOUTH);
      new Wall(maze, 1, 4, Direction.SOUTH);

      new Wall(maze, 2, 2, Direction.WEST);
      new Wall(maze, 2, 5, Direction.SOUTH);
      new Wall(maze, 2, 6, Direction.WEST);

      new Wall(maze, 3, 3, Direction.WEST);
      new Wall(maze, 3, 4, Direction.WEST);
      new Wall(maze, 3, 6, Direction.WEST);

      new Wall(maze, 4, 2, Direction.WEST);
      new Wall(maze, 4, 2, Direction.SOUTH);
      new Wall(maze, 4, 3, Direction.WEST);
      new Wall(maze, 4, 3, Direction.SOUTH);
      new Wall(maze, 4, 4, Direction.SOUTH);
      new Wall(maze, 4, 5, Direction.WEST);
      new Wall(maze, 4, 5, Direction.SOUTH);
      new Wall(maze, 4, 6, Direction.WEST);

      (new Flasher(maze, 1,5)).turnOn();

      RobotSE mouse = new RobotSE(maze, 3, 1, Direction.EAST);

      //Koden inn her ...
      mouse.move();
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


