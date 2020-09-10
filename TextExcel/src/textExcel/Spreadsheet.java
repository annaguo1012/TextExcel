package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid {
	private Cell[][] cellGrid;

	public Spreadsheet() {
		cellGrid = new Cell[20][12];
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 12; j++) {
				cellGrid[i][j] = new EmptyCell();
			}
		}
	}

	@Override
	public String processCommand(String command)
	{
		String[] cmds = command.split(" ", 3);
		//cell inspection
		if(command.length() <= 3)
		{
			command = command.toUpperCase();
			SpreadsheetLocation a = new SpreadsheetLocation(command);
			return getCell(a).fullCellText();
		}
		//clear
		else if(command.toLowerCase().equals("clear"))
		{
			resetSpreadsheet();
			return this.getGridText();
		}
		//clear cell
		else if(cmds[0].toLowerCase().equals("clear"))
		{
			cmds[1] = cmds[1].toUpperCase();
			SpreadsheetLocation c = new SpreadsheetLocation(cmds[1]);
			cellGrid[c.getRow()][c.getCol()] = new EmptyCell();
			return this.getGridText();
		}
		//assign string values
		else if(cmds[1].equals("="))
		{
			cmds[0] = cmds[0].toUpperCase();
			SpreadsheetLocation b = new SpreadsheetLocation(cmds[0]);
			//String[] text1 = cmds[2].split(" ", 3);
			if(cmds[2].charAt(0) == '\"')
			{
				cellGrid[b.getRow()][b.getCol()] = new TextCell(cmds[2]);
			}
			else if(cmds[2].charAt(cmds[2].length()-1) == '%')
			{
				cellGrid[b.getRow()][b.getCol()] = new PercentCell(cmds[2].substring(0, cmds[2].length()-1));
			}
			else if(cmds[2].charAt(0) == '(')
			{
				cellGrid[b.getRow()][b.getCol()] = new FormulaCell(cmds[2]);
			}
			else
			{
				cellGrid[b.getRow()][b.getCol()] = new ValueCell(cmds[2]);
			}
			
			return this.getGridText();
		}
		else
		{
			return this.getGridText();
		}
	}

	@Override
	public int getRows() {
		return 20;
	}

	@Override
	public int getCols() {
		// TODO Auto-generated method stub
		return 12;
	}

	@Override
	public Cell getCell(Location loc) {
		// TODO Auto-generated method stub
		return this.cellGrid[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText() {
		String out = String.format("%-3s", " ");
		for (char i = 'A'; i <= 65 + 11; i++) {
			out += String.format("|%-10s", i);
		}
		out += "|\n";
		for (int j = 1; j <= 20; j++) {
			out += String.format("%-3s", j);
			for (char k = 'A'; k <= 65 + 11; k++) {
				SpreadsheetLocation loc = new SpreadsheetLocation("" + k + j); 
				out += "|" + getCell(loc).abbreviatedCellText(); // could use cellGrid[][]
			}
			out += "|" + "\n";
		}
		// use abbreviatedCellText
		// use nested for loops to print the rest
		return out;
	}
	
	public void resetSpreadsheet()
	{
		for(int i = 0; i < 20; i++)
		{
			for(int j = 0; j < 12; j++)					
			{
				cellGrid[i][j] = new EmptyCell();
			}
		}
	}
}
