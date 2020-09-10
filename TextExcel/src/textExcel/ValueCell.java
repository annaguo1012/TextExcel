package textExcel;

public class ValueCell extends RealCell
{		
	public ValueCell(String strValue) 
	{
		super(strValue);
	}
	
	public String abbreviatedCellText() // can be abstract
	{
		String out = "" + Double.parseDouble(strValue);
		/* if(Double.parseDouble(strValue)%0.1 == 0)
		{
			strValue = "" + Integer.parseInt(strValue);
		} */
		if(out.length() > 10)
		{
			return out.substring(0, 10);
		}
		return String.format("%-10s", out);
	}
	
}
