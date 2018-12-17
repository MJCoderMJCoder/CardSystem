package action.admin;

import po.Card;
import service.Service;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//注销卡
@SuppressWarnings("serial")
public class DeleteCardAction extends ActionSupport
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
		ctx.put("number", getNumber());
		return SUCCESS;
	}
}
