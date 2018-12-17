package action.admin;

import service.Service;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//确认注销
@SuppressWarnings("serial")
public class DeleteConfirmAction extends ActionSupport
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
		service.deleteCard(getNumber());
		ctx.put("tip", "注销成功");
		return SUCCESS;
	}
}
