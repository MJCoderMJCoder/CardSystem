package action.admin;

import java.util.List;

import po.Card;
import po.History;
import service.Service;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//查询交易记录
@SuppressWarnings("serial")
public class AdminHistoryAction extends ActionSupport
{
	private String number;
	private Service service;
	private String pageNumber;
	private int currentPage;
	private List<History> historyList;
	
	public String getNumber()
	{
		return number;
	}
	public void setNumber(String number)
	{
		this.number = number;
	}
	public Service getService()
	{
		return service;
	}
	public void setService(Service service)
	{
		this.service = service;
	}
	public String getPageNumber()
	{
		return pageNumber;
	}
	public void setPageNumber(String pageNumber)
	{
		this.pageNumber = pageNumber;
	}
	public int getCurrentPage()
	{
		return currentPage;
	}
	public void setCurrentPage(int currentPage)
	{
		this.currentPage = currentPage;
	}
	public List<History> getHistoryList()
	{
		return historyList;
	}
	public void setHistoryList(List<History> historyList)
	{
		this.historyList = historyList;
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
		int pageCount = service.getHistoryPageCount(getNumber());
		if(pageCount < 1)
		{
			ctx.put("tip", "该卡没有交易记录");
			return SUCCESS;
		}
		
		int pageNo;
		//第一次查看，显示第一页
		if(getPageNumber() == null || getPageNumber().equals(""))
		{
			pageNo = 1;
		}
		else
		{
			pageNo = Integer.parseInt(getPageNumber().trim());
		}
		if(pageNo < 1)
		{
			pageNo = 1;
		}
		if(pageNo > pageCount)
		{
			pageNo = pageCount;
		}
		//总页数信息
		ctx.put("pageCount", pageCount);
		//当前查看的页号
		setCurrentPage(pageNo);
		List<History> list = service.getHistoryByPage(getNumber(), pageNo);
		setHistoryList(list);
		return SUCCESS;
	}
}
