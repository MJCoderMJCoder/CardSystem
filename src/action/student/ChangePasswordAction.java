package action.student;

import service.Service;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//修改密码
@SuppressWarnings("serial")
public class ChangePasswordAction extends ActionSupport
{
	private Service service;
	private String password;
	private String confirm;
	public Service getService()
	{
		return service;
	}
	public void setService(Service service)
	{
		this.service = service;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getConfirm()
	{
		return confirm;
	}
	public void setConfirm(String confirm)
	{
		this.confirm = confirm;
	}
	
	@Override
	public String execute() throws Exception
	{
		ActionContext ctx = ActionContext.getContext();
		if(getPassword() == null || getPassword().equals(""))
		{
			ctx.put("tip", "密码不能为空");
			return INPUT;
		}
		if(!getPassword().equals(getConfirm()))
		{
			ctx.put("tip", "两次输入密码不一致");
			return INPUT;
		}
		String number = (String) ctx.getSession().get("number");
		service.changePassword(number,getPassword());
		ctx.put("tip", "修改密码成功");
		return INPUT;
	}
}
