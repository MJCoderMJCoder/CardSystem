package action.admin;

import service.Service;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//确认挂失
@SuppressWarnings("serial")
public class LockConfirmAction extends ActionSupport
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
		//挂失卡
		service.lock(getNumber());
		ctx.put("tip", "挂失成功");
		return SUCCESS;
	}
}
