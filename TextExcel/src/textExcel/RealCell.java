package textExcel;

public abstract class RealCell implements Cell{

	protected String strValue; //prints what expect when inspect
	
	public RealCell(String strValue) 
	{
		this.strValue = strValue;
	}
	
	public  String abbreviatedCellText() // can be abstract
	{
		String cutValue = strValue;
		if(strValue.length() > 11)
		{
			cutValue = strValue.substring(0, 10);
			return cutValue;
		}
		return String.format("%-10s", strValue);
	}
	
	public String fullCellText() 
	{
		return strValue;
	}
	
	public double getDoubleValue(String input)
	{
		return Double.parseDouble(input);
	}
	
	//if make everything abstract, need getValue() method
/*	public String getValue()
	{
		return strValue;
	}*/
}
