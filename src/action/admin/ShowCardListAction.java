package action.admin;

import java.util.List;

import po.Card;
import service.Service;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ShowCardListAction extends ActionSupport
{
	private Service service;
	private String pageNumber;
	private int currentPage;
	private List<Card> cardList;

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
	public List<Card> getCardList()
	{
		return cardList;
	}
	public void setCardList(List<Card> cardList)
	{
		this.cardList = cardList;
	}

	@Override
	public String execute() throws Exception
	{
		ActionContext ctx = ActionContext.getContext();
		int pageCount = service.getCardPageCount();
		if(pageCount < 1)
		{
			ctx.put("tip", "没有卡信息");
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
		List<Card> list = service.getCardByPage(pageNo);
		setCardList(list);
		return SUCCESS;
	}
	
}
