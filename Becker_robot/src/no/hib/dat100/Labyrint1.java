
package no.hib.dat100;

import becker.robots.*;

public class Labyrint1 {

    public static void main(String[] args){
        
        // Set up the maze (row1..3)
        //    1     _ _
        //    2   >  |  *
        //    3    |_ _|
        
        City maze = new City();
        
        new Wall(maze, 1, 2, Direction.SOUTH);
        new Wall(maze, 1, 3, Direction.SOUTH);
        
        new Wall(maze, 2, 3, Direction.WEST);
        
        new Wall(maze, 3, 2, Direction.WEST);
        new Wall(maze, 3, 2, Direction.SOUTH);
        new Wall(maze, 3, 3, Direction.SOUTH);
        new Wall(maze, 3, 4, Direction.WEST);
        
        (new Flasher(maze, 2,4)).turnOn();
        
        RobotSE mouse = new RobotSE(maze, 2, 1, Direction.EAST);
        
        //Koden inn her ...
        mouse.move();
        mouse.turnRight();
        mouse.move();
        mouse.turnLeft();
        mouse.move();
        mouse.turnLeft();
        mouse.move();
        mouse.turnRight();
        mouse.move();
        mouse.pickThing();
        
        
    }
}
