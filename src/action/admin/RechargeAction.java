package action.admin;

import po.Card;
import service.Service;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//充值
@SuppressWarnings("serial")
public class RechargeAction extends ActionSupport
{
	private Service service;
	private String number;
	private String money;
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
	public String getMoney()
	{
		return money;
	}
	public void setMoney(String money)
	{
		this.money = money;
	}
	
	@Override
	public String execute() throws Exception
	{
		ActionContext ctx = ActionContext.getContext();
		if(getNumber() == null || getNumber().equals(""))
		{
			ctx.put("tip", "卡号不能为空");
			return INPUT;
		}
		if(getMoney() == null || getMoney().equals(""))
		{
			ctx.put("tip", "金额不能为空");
			return INPUT;
		}
		Card c = service.getCardByNumber(getNumber());
		if(c == null)
		{
			ctx.put("tip", "该卡号不存在");
			return INPUT;
		}
		if(c.getIslock().equals("true"))
		{
			ctx.put("tip", "该卡已挂失，充值失败");
			return INPUT;
		}
		//充值
		service.recharge(c.getNumber(), Double.parseDouble(getMoney()));
		ctx.put("tip", "充值成功");
		return INPUT;
	}
}
