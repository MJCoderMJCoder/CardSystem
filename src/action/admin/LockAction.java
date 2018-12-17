package action.admin;

import po.Card;
import service.Service;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//挂失及解锁卡
@SuppressWarnings("serial")
public class LockAction extends ActionSupport
{
	private Service service;
	private String number;
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
	
	//挂失卡
	@Override
	public String execute() throws Exception
	{
		ActionContext ctx = ActionContext.getContext();
		if(getNumber() == null || getNumber().equals(""))
		{
			ctx.put("tip", "卡号不能为空");
			return INPUT;
		}
		Card card = service.getCardByNumber(getNumber());
		if(card == null)
		{
			ctx.put("tip", "该卡号不存在");
			return INPUT;
		}
		if(card.getIslock().equals("true"))
		{
			ctx.put("tip", "该卡已经挂失");
			return INPUT;
		}
		ctx.put("number", getNumber());
		//跳转到挂失确认页面
		return "lockSuccess";
	}
	
	//解锁卡
	public String unlock() throws Exception
	{
		ActionContext ctx = ActionContext.getContext();
		if(getNumber() == null || getNumber().equals(""))
		{
			ctx.put("tip", "卡号不能为空");
			return INPUT;
		}
		Card card = service.getCardByNumber(getNumber());
		if(card == null)
		{
			ctx.put("tip", "该卡号不存在");
			return INPUT;
		}
		if(card.getIslock().equals("false"))
		{
			ctx.put("tip", "该卡不需要解锁");
			return INPUT;
		}
		ctx.put("number", getNumber());
		//跳转到解锁确认页面
		return "unlockSuccess";
	}
}
