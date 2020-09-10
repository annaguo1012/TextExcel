package textExcel;

public class PercentCell extends ValueCell
{	
	public PercentCell(String strValue) 
	{
		super(strValue);
	}
	
	public double getDoubleValue()
	{
		return Double.parseDouble(strValue)*0.01;
	}

	public String abbreviatedCellText() // text for spreadsheet cell display, must be exactly length 10
	{
		/*
		String out = strValue;
		double cast = Double.parseDouble(out);
		if(cast*10%10 != 0)
		{
			String[] splitted = out.split(".");
			out = splitted[0];
		} 
		*/
		String out = "" + (int)Double.parseDouble(strValue);
		return String.format("%-10s", out+"%");
	}
	
	public String fullCellText()
	{
		return "" + getDoubleValue();
	}
}
