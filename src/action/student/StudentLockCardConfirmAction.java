package action.student;

import po.Card;
import service.Service;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//挂失卡确认
@SuppressWarnings("serial")
public class StudentLockCardConfirmAction extends ActionSupport
{
	private Service service;

	public Service getService()
	{
		return service;
	}

	public void setService(Service service)
	{
		this.service = service;
	}
	
	@Override
	public String execute() throws Exception
	{
		ActionContext ctx = ActionContext.getContext();
		String number = (String)ctx.getSession().get("number");
		Card card = service.getCardByNumber(number);
		if(card.getIslock().equals("true"))
		{
			ctx.put("tip", "该卡已经为挂失状态");
			return SUCCESS;
		}
		service.lock(number);
		ctx.put("tip", "挂失成功");
		return SUCCESS;
	}
}
