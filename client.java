import java.net.*;
import java.io.*;

public class client {
	public Socket s;
	
	PrintStream ps;
	
	BufferedReader br;
	
	BufferedReader kb;

	public client() throws Exception
	{
		s = new Socket("localhost", 8089);
		ps = new PrintStream(s.getOutputStream());
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		kb = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public static void main(String arg[]) throws Exception
	{
		client c = new client();		

		ct1 client = new ct1(c);
		ct2 server = new ct2(c);
		
		client.start();
		server.start();

		client.join();
		server.join();

System.out.println("ending client");

		
        
		/*
		 * ps.close(); br.close(); kb.close(); s.close();
		 */
		
	}
	public void cleanup() throws Exception
	{
		ps.close(); br.close(); kb.close(); s.close();
	}
}
	
	
	class ct1 extends Thread{
		client c;

		public ct1(client c)
		{
			this.c = c;
		}
		public void run()
		{
			while(true)
		{
			try {
				/////////////System.out.print("Client: ");
				String str = c.kb.readLine();
				
				if (!str.equals("exit")) {
					c.ps.println(str);
				}
				else {
					c.ps.println(str);
					System.exit(0);
					c.cleanup();
					
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		}
	}
	
	class ct2 extends Thread{

		client c;

		public ct2(client c)
		{
			this.c = c;
		}
		public void run()
		{
			while(true)
		{
			try {
				
				String str1 = c.br.readLine();
				
	            //if (str1 != null) {
	                System.out.println("Server: " + str1);
	            //}
	            //else {
	            //return;
	            //}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
	}
