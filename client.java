import java.net.*;
import java.io.*;

public class client {
	public Socket s;
	
	PrintStream ps;
	
	BufferedReader br;
	
	BufferedReader kb;

	public client() throws Exception
	{
		s = new Socket("localhost", 8081);
		ps = new PrintStream(s.getOutputStream());
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		kb = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public static void main(String arg[]) throws Exception
	{
		
		ct1 client = new ct1();
		ct2 server = new ct2();
		
		client.start();
		server.start();
		
        
		/*
		 * ps.close(); br.close(); kb.close(); s.close();
		 */
		
	}
}
	
	
	class ct1 extends Thread{
		public void run()
		{
			try {
				client c = new client();
				
				String str = c.kb.readLine();
				
				if (!str.equals("exit")) {
					c.ps.println(str);
				}
				else {
					return;
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
	
	class ct2 extends Thread{
		public void run()
		{
			try {
				client c = new client();
				
				String str1 = c.br.readLine();
				
	            if (str1 != null) {
	                System.out.println("Server: " + str1);
	            }
	            else {
	            	return;
	            }
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
