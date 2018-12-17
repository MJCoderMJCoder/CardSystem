package po;

public class Card
{
	private int id;
	private String number;
	private String password;
	private String name;
	private String sex;
	private String identity;
	private String phone;
	private String college;
	private double money;
	private String islock;
	
	public Card()
	{
		
	}
	public Card(String number, String name, String sex, String identity, String phone, String college, double money, String islock)
	{
		this.number = number;
		this.name = name;
		this.sex = sex;
		this.identity = identity;
		this.phone = phone;
		this.college = college;
		this.money = money;
		this.islock = islock;
	}
	public String getNumber()
	{
		return number;
	}
	public void setNumber(String number)
	{
		this.number = number;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	public String getIdentity()
	{
		return identity;
	}
	public void setIdentity(String identity)
	{
		this.identity = identity;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public String getCollege()
	{
		return college;
	}
	public void setCollege(String college)
	{
		this.college = college;
	}
	public double getMoney()
	{
		return money;
	}
	public void setMoney(double money)
	{
		this.money = money;
	}
	public String getIslock()
	{
		return islock;
	}
	public void setIslock(String islock)
	{
		this.islock = islock;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
}
