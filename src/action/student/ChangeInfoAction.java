package action.student;

import po.Card;
import service.Service;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//修改卡信息
@SuppressWarnings("serial")
public class ChangeInfoAction extends ActionSupport
{
	private Service service;
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
		String number = (String)ctx.getSession().get("number");
		Card card = new Card();
		card.setNumber(number);
		card.setName(new String(getName().getBytes("ISO8859_1"), "utf-8"));
		card.setSex(new String(getSex().getBytes("ISO8859_1"), "utf-8"));
		card.setIdentity(getIdentity());
		card.setPhone(getPhone());
		card.setCollege(new String(getCollege().getBytes("ISO8859_1"), "utf-8"));
		service.changeCardInfo(card);
		ctx.put("tip", "修改卡信息成功");
		return SUCCESS;
	}
}
