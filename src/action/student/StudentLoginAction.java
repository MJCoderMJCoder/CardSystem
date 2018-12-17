package action.student;

import po.Card;
import service.Service;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//学生登陆
@SuppressWarnings("serial")
public class StudentLoginAction extends ActionSupport
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
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
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
	
	@Override
	public String execute() throws Exception
	{
		ActionContext ctx = ActionContext.getContext();
		if(getUsername() == null || getUsername().equals(""))
		{
			ctx.put("tip", "请输入用户名");
			return INPUT;
		}
		if(getPassword() == null || getPassword().equals(""))
		{
			ctx.put("tip", "密码不能为空");
			return INPUT;
		}
		Card card = service.getCardByNumber(getUsername());
		if(card == null)
		{
			ctx.put("tip", "该卡号不存在");
			return INPUT;
		}
		if(!card.getPassword().equals(getPassword()))
		{
			ctx.put("tip", "密码错误");
			return INPUT;
		}
		String sessionCode=(String)(ActionContext.getContext().getSession().get("sessionCode"));       
		if(!sessionCode.equals(this.getCode())) 
		{
			ctx.put("tip", "验证码不正确");
			return INPUT;      
		}
		ctx.getSession().put("number", getUsername());
		return SUCCESS;
	}
}
