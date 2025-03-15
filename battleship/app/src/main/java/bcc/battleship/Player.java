package bcc.battleship;
import bcc.battleship.Constants;

public class Player {
  
    // Constructor: Initialize the grids and the ships.
    Ship[] shipArray = new Ship[5];
    Ship two = new Ship(2);
    Ship three = new Ship(3);
    Ship three2 = new Ship(3);
    Ship four = new Ship(4);
    Ship five = new Ship(5);
    

    Grid playerGrid = new Grid();
    Grid opponentGrid = new Grid();


    public Player() 
    {
    
        shipArray[0] = two;
        shipArray[1] = three;
        shipArray[2] = three2;
        shipArray[3] = four;
        shipArray[4] = five;



    }
    
    /**
     * This method is used for testing to set a ship's location.
     * It sets the ship's row, column, and direction, then adds it to the player's grid.
     *
     */
    
    public boolean chooseShipLocation(int index, int row, int col, int direction) {
        
        shipArray[index].setDirection(direction);
        shipArray[index].setLocation(row, col);

        if (playerGrid.addShip(shipArray[index]) == true)
        {
            
            return true;
        }
        else
        {
            return false;
        }
    }
   
    /**
     * Record a guess from the opponent.
     * This method checks the player's grid at (row, col). If there is a ship,
     * it marks a hit and returns true; otherwise, it marks a miss and returns false.
     *
     */
    public boolean recordOpponentGuess(int row, int col) {
    
        if (playerGrid.hasShip(row, col) == true)
        {
            playerGrid.markHit(row, col);
            return true;
        }
        playerGrid.markMiss(row, col);
        return false;
    }
    
    
    public Grid getMyGrid() {
        return playerGrid;
    }
    
    public Grid getOpponentGrid() {
        return opponentGrid;
    }
}
