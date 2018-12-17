package util;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import exception.MyException;

import po.Card;
import service.Service;

public class Test {
	public static void main(String[] args) throws MyException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Service service = ctx.getBean("service", Service.class);
		List<Card> list = service.getCardByPage(1);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("lzf：" + list.get(i).getNumber());
			System.out.println("lzf：" + list.get(i).getName());
			System.out.println("lzf：" + list.get(i).getPassword());
		}
	}
}
