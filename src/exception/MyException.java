package exception;

@SuppressWarnings("serial")
public class MyException extends Exception
{
	public MyException(String output)
	{
		System.out.println(output);
	}
}