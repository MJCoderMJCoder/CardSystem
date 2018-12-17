package util;

import java.io.ByteArrayInputStream;

import util.RandomNumUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//将图片发送到页面，将对应的数字保存在session中。
@SuppressWarnings("serial")
public class RandomAction extends ActionSupport
{
	private ByteArrayInputStream inputStream;       
	public String execute() throws Exception{       
	RandomNumUtil rdnu=RandomNumUtil.Instance();       
	this.setInputStream(rdnu.getImage());//取得带有随机字符串的图片       
	ActionContext.getContext().getSession().put("sessionCode", rdnu.getString());//取得随机字符串放入HttpSession       
	return SUCCESS;       
	}       
	public void setInputStream(ByteArrayInputStream inputStream) {       
	this.inputStream = inputStream;       
	}       
	public ByteArrayInputStream getInputStream() {       
	return inputStream;       
	}   
}
