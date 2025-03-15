package bcc.battleship;

public class Location {
    // Instance variables
    boolean shipHere = false;
    int status;
    // Constructor. Initializes with no ship and status UNGUESSED.
    public Location()
    {
        shipHere = false;
        status = 0;
    }

    // Was this Location a hit?
    public boolean checkHit() {
        if (status == 1)
        {
            return true;
        }
        return false;
    }

    // Was this location a miss?
    public boolean checkMiss() {
        if (status == 2)
        {
            return true;
        }
        return false;
    }

    // Was this location unguessed?
    public boolean isUnguessed() {
        if (status == 0)
        {
            return true;
        }
        return false;
    }

    // Mark this location as a hit.
    public void markHit() {
        status = 1;
    }

    // Mark this location as a miss.
    public void markMiss() 
    {
        status = 2;
    }

    // Return whether or not this location has a ship.
    public boolean hasShip() {
        return shipHere;
    }

    // Set whether this location has a ship.
    public void setShip(boolean val) 
    {
        shipHere = val;
    }

    // Set the status of this Location.
    public void setStatus(int status) {
        this.status = status;
    }

    // Get the status of this Location.
    public int getStatus() {
        return status;
    }
}
