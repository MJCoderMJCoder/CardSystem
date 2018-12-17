package action.student;

import java.util.List;

import po.History;
import service.Service;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//查询交易历史，与管理员查看交易记录一样
@SuppressWarnings("serial")
public class HistoryAction extends ActionSupport
{
	private Service service;
	private String pageNumber;
	private int currentPage;
	private List<History> historyList;
	
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
		String number = (String)ctx.getSession().get("number");
		int pageCount = service.getHistoryPageCount(number);
		if(pageCount < 1)
		{
			ctx.put("tip", "该卡没有交易记录");
			return SUCCESS;
		}
		
		int pageNo;
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
		ctx.put("pageCount", pageCount);
		setCurrentPage(pageNo);
		List<History> list = service.getHistoryByPage(number, pageNo);
		setHistoryList(list);
		return SUCCESS;
	}
}
