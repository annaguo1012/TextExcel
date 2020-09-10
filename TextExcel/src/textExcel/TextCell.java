package textExcel;

public class TextCell implements Cell
{
	private String value;
	
	public TextCell(String value) 
	{
		this.value = value.substring(1, value.length()-1);
		// TODO Auto-generated constructor stub
	}

	public String abbreviatedCellText() // text for spreadsheet cell display, must be exactly length 10
	{
		String cutValue = value;
		if(value.length() > 10)
		{
			cutValue = value.substring(0, 10);
			return cutValue;
		}
		return String.format("%-10s", value);
	}
	public String fullCellText() // text for individual cell inspection, not truncated or padded
	{
		return "\"" + value + "\"";
	}
}
