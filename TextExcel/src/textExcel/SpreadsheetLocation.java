package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
    private int row;
    private int column;
    
    public SpreadsheetLocation(String cellName)
    {
    	this.row = Integer.parseInt(cellName.substring(1))-1;
    	this.column = cellName.charAt(0)-65;
//    			Character.toUpperCase(cellName.charAt(1)) - 'A';
//    			
    }

    @Override
    public int getRow()
    {
        // TODO Auto-generated method stub
        return row;
    }

    @Override
    public int getCol()
    {
        // TODO Auto-generated method stub
        return column;
    }

}
