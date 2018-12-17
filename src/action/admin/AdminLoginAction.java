package action.admin;

import service.Service;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//管理员登陆
@SuppressWarnings("serial")
public class AdminLoginAction extends ActionSupport
{
	private Service service;
	private String username;
	private String password;
	private String code;      
	public String getCode() {      
	    return code;      
	}      
	public void setCode(String code) {      
	this.code = code;      
	}
	public Service getService()
	{
		return service;
	}
	public void setService(Service service)
	{
		this.service = service;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	@Override
	public String execute() throws Exception
	{
		ActionContext ctx = ActionContext.getContext();
		//用户名为空
		if(getUsername() == null || getUsername().equals(""))
		{
			ctx.put("tip", "请输入用户名");
			return INPUT;
		}
		//密码为空
		if(getPassword() == null || getPassword().equals(""))
		{
			ctx.put("tip", "请输入密码");
			return INPUT;
		}
		
		String sessionCode=(String)(ActionContext.getContext().getSession().get("sessionCode")); 
		//验证码不正确
		if(!sessionCode.equals(this.getCode())) 
		{
			ctx.put("tip", "验证码不正确");
			return INPUT;      
		}
		//用户名或密码不对
		if(!(getUsername().equals("admin") && getPassword().equals("123456")))
		{
			ctx.put("tip", "用户名或密码错误");
		}
		return SUCCESS;
	}
}
