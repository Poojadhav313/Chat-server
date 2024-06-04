import java.net.*;
import java.io.*;

public class server {
	public Socket s;
	ServerSocket ss;
	
	PrintStream ps;
	
	BufferedReader br;
	
	BufferedReader kb;
	
	public server() throws Exception
	{
		ss = new ServerSocket(8089);
		s = ss.accept();
		
		System.out.println("Connection established");
		
		ps = new PrintStream(s.getOutputStream());
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		kb = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public static void main(String arg[]) throws Exception
	{
		server s = new server();
		st1 client = new st1(s);
		st2 server = new st2(s);
		
		client.start();
		server.start();

		client.join();
		server.join();

		System.out.println("ending server");
		
		
		
			/*
			 * ps.close(); br.close(); kb.close(); ss.close(); s.close(); System.exit(0);
			 */
		
	}
	public void cleanup() throws Exception
	{
		ps.close(); br.close(); kb.close(); s.close(); ss.close();
	}
}


class st1 extends Thread{
	server s;

		public st1(server s)
		{
			this.s = s;
		}
	public void run(){
		while(true)
		{
		try {
			String str = s.br.readLine();
			
            if (!(str.equals("exit"))) {
            	System.out.println("Client: " + str);
            }
            else{
		
		System.exit(0);
		s.cleanup();

            }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	}
}

class st2 extends Thread{

		server s;

		public st2(server s)
		{
			this.s = s;
		}
		public void run(){
		while(true)
		{
		try {
			
			
            String str1 = s.kb.readLine();
            
            //if (!str1.equals("exit")) {
		//////////////System.out.print("Server: ");
            	s.ps.println(str1);
            //}
            //else {
            //return;
          // }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	}
}