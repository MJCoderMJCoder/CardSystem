package action.student;

import po.Card;
import service.Service;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//查看卡信息
@SuppressWarnings("serial")
public class CardInfoAction extends ActionSupport
{
	private Service service;
	private Card card;

	public Service getService()
	{
		return service;
	}
	public void setService(Service service)
	{
		this.service = service;
	}
	public Card getCard()
	{
		return card;
	}
	public void setCard(Card card)
	{
		this.card = card;
	}
	
	@Override
	public String execute() throws Exception
	{
		ActionContext ctx = ActionContext.getContext();
		String number = (String)ctx.getSession().get("number");
		Card card = service.getCardByNumber(number);
		setCard(card);
		return SUCCESS;
	}
}
