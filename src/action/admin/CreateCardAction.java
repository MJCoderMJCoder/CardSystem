package action.admin;

import po.Card;
import service.Service;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//创建卡
@SuppressWarnings("serial")
public class CreateCardAction extends ActionSupport
{
	private Service service;
	private String number;
	private String name;
	private String sex;
	private String identity;
	private String phone;
	private String college;
	public Service getService()
	{
		return service;
	}
	public void setService(Service service)
	{
		this.service = service;
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
	
	@Override
	public String execute() throws Exception
	{
		ActionContext ctx = ActionContext.getContext();
		if(getNumber() == null || getNumber().equals(""))
		{
			ctx.put("tip", "请输入卡号");
			return INPUT;
		}
		if(getName() == null || getName().equals(""))
		{
			ctx.put("tip", "请输入姓名");
			return INPUT;
		}
		if(getSex() == null || getSex().equals(""))
		{
			ctx.put("tip", "请输入性别");
			return INPUT;
		}
		
		Card c = service.getCardByNumber(getNumber());
		if(c != null)
		{
			ctx.put("tip", "该卡号已存在");
			return INPUT;
		}
		Card card = new Card();
		card.setNumber(getNumber());
		//将编码格式转为UTF-8
		card.setName(new String(getName().getBytes("ISO8859_1"), "utf-8"));
		card.setSex(new String(getSex().getBytes("ISO8859_1"), "utf-8"));
		card.setIdentity(getIdentity());
		card.setPhone(getPhone());
		card.setCollege(new String(getCollege().getBytes("ISO8859_1"), "utf-8"));
		service.createCard(card);
		ctx.put("tip", "创建成功");
		return INPUT;
	}
}
