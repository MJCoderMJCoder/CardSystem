package action.machine;

import po.Card;
import service.Service;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//消费处理
@SuppressWarnings("serial")
public class ConsumeAction extends ActionSupport
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
		Card card = service.getCardByNumber(getNumber());
		if(card.getIslock().equals("true"))
		{
			ctx.put("tip", "该卡已挂失，消费失败");
			return INPUT;
		}
		if(card.getMoney() < Double.parseDouble(getMoney()))
		{
			ctx.put("tip", "余额不足");
			return INPUT;
		}
		//消费
		service.consume(getNumber(), Double.parseDouble(getMoney()));
		ctx.put("tip", "消费成功");
		return INPUT;
	}
}
