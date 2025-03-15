package bcc.battleship;

public class Grid {
    
    Location[][] grid = new Location[Constants.NUM_ROWS][Constants.NUM_COLS];
    Location test;
    
    // Create a new Grid and initialize each Location.
    public Grid()
    {
        grid = new Location[Constants.NUM_ROWS][Constants.NUM_COLS];
        for(int a = 0; a < grid.length; a++)
        {
            for(int b = 0; b < grid[0].length; b++)
            {
                grid[a][b] = new Location();
            }
        }
    }
    
    // Mark a hit in the specified location.
    public void markHit(int arow, int acol) 
    {
       grid[arow][acol].markHit();
    }
    
    // Mark a miss in the specified location.
    public void markMiss(int brow, int bcol) 
    {
        grid[brow][bcol].markMiss();
    }
    
    // Set the status of the Location at (row, col).
    public void setStatus(int crow, int ccol, int status) 
    {
        grid[crow][ccol].setStatus(status);
    }
    
    // Get the status of the Location at (row, col).
    public int getStatus(int drow, int dcol) 
    {
        return grid[drow][dcol].getStatus();
    }
    
    // Return whether this Location has already been guessed.
    public boolean alreadyGuessed(int erow, int ecol) 
    {
        if (grid[erow][ecol].isUnguessed() == true)
        {
            return false;
        }
        return true;
    }
    
    // Set whether there is a ship at this location.
    public void setShip(int frow, int fcol, boolean val) 
    {
        test = grid[frow][fcol];
        test.setShip(val);
    }
    
    // Return whether there is a ship at this location.
    public boolean hasShip(int grow, int gcol) 
    {
        if (grid[grow][gcol].hasShip() == true)
        {
            return true;
        }
        return false;
    }
    
    // Get the Location object at this row and column.
    public Location get(int hrow, int hcol) 
    {
        return grid[hrow][hcol];
    }
    
    // Return the number of rows.
    public int numRows() 
    {
        return grid.length;
    }
    
    // Return the number of columns.
    public int numCols() 
    {
        return grid[0].length;
    }
    

    //maybe convert to boolean?
    public boolean addShip(Ship s) 
    {

        int endOfShipCol = s.getCol() + s.getLength();
        if (s.getDirection() == Constants.HORIZONTAL)
        {
            
            if (endOfShipCol > grid.length)
            {
                return false;
            }
        }
        
        int endOfShipRow = s.getRow() + s.getLength();
        if (s.getDirection() == Constants.VERTICAL)
        {
            if (endOfShipRow > grid[0].length)
            {
                return false;
            }
        }

        
        
        if (s.getDirection() == Constants.HORIZONTAL)
        {
            for (int q = s.getCol(); q < (s.getCol() + s.getLength()); q ++)
            {
                if (grid[s.getRow()][q].hasShip() == true )
                {
                    return false;
                }
                else
                {
                    grid[s.getRow()][q].setShip(true);
                }
            }
        }
        if (s.getDirection() == Constants.VERTICAL)
        {
            for (int q = s.getRow(); q < (s.getRow() + s.getLength()); q ++)
            {
                if (grid[q][s.getCol()].hasShip() == true )
                {
                    return false;
                }
                else
                {
                    grid[q][s.getCol()].setShip(true);
                }
            }
        }



        return true;
    }

    public boolean allShipsSank()
    {
        for (int irow = 0; irow < grid.length; irow++)
        {
            for (int icol = 0; icol < grid[0].length; icol++)
            {
                if ((grid[irow][icol].hasShip() == true) && (grid[irow][icol].checkHit() == false))
                {
                    return false;
                }
            }
        }
            return true;
    }
}
