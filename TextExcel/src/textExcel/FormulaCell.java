package textExcel;

import java.util.Arrays;

public class FormulaCell extends RealCell{
	
	public FormulaCell(String strVal) 
	{
		super(strVal);
	}

	public double getDoubleValue()
	{
		String[] inputs = strValue.split(" ");
		//System.out.println(strValue);
		//System.out.println(Arrays.toString(inputs));
		int index = 1;
		double out = Double.parseDouble(inputs[1]);
		while(index < inputs.length-2)
		{
			if(inputs[index+1].equals("+"))
			{
				out += Double.parseDouble(inputs[index+2]);
			}
			else if(inputs[index+1].equals("-"))
			{
				out -= Double.parseDouble(inputs[index+2]);
			}
			else if(inputs[index+1].equals("*"))
			{
				out *= Double.parseDouble(inputs[index+2]);
			}
			else //operation: /
			{
				out /= Double.parseDouble(inputs[index+2]);
			}
			
			index+=2;
		}
		return out;
	}
	
	public String abbreviatedCellText() // can be abstract
	{
		String cutValue = getDoubleValue() + "";
		if(cutValue.length() > 10)
		{
			cutValue = cutValue.substring(0, 10);
			return cutValue;
		}
		return String.format("%-10s", cutValue);
	}
}
