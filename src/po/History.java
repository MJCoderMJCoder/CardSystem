package po;

public class History
{
	private int id;
	private String number;
	private String operation;
	private double money;
	private String date;
	
	public History()
	{
		
	}
	public History(String number, String operation, double money, String date)
	{
		this.number = number;
		this.operation = operation;
		this.money = money;
		this.date = date;
	}
	
	public String getNumber()
	{
		return number;
	}
	public void setNumber(String number)
	{
		this.number = number;
	}
	public String getOperation()
	{
		return operation;
	}
	public void setOperation(String operation)
	{
		this.operation = operation;
	}
	public double getMoney()
	{
		return money;
	}
	public void setMoney(double money)
	{
		this.money = money;
	}
	public String getDate()
	{
		return date;
	}
	public void setDate(String date)
	{
		this.date = date;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
}
