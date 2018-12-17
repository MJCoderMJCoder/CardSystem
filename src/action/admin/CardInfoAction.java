package action.admin;

import po.Card;
import service.Service;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//查询卡信息
@SuppressWarnings("serial")
public class CardInfoAction extends ActionSupport
{
	private Service service;
	private String number;
	private Card card;
	public Card getCard()
	{
		return card;
	}
	public void setCard(Card card)
	{
		this.card = card;
	}
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
		String number = getNumber();
		if(number == null || number.equals(""))
		{
			ctx.put("tip", "卡号不能为空");
			return INPUT;
		}
		//通过卡号获得卡
		Card card = service.getCardByNumber(number);
		if(card == null)
		{
			ctx.put("tip", "该卡号不存在");
			return INPUT;
		}
		//将卡对象传递到页面
		setCard(card);
		return SUCCESS;
	}
}
