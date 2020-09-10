package textExcel;

//*******************************************************
// DO NOT MODIFY THIS FILE!!!
//*******************************************************

public interface Cell
{
	public String abbreviatedCellText(); // text for spreadsheet cell display, must be exactly length 10
	public String fullCellText(); // text for individual cell inspection, not truncated or padded
}

//everything has to be ten characters, string 
//A10 = "5.0" - strings
//A19 = ( 5.0 )
//formulas have parentheses, values don't require parentheses
