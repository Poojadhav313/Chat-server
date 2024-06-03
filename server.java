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
		ss = new ServerSocket(8081);
		s = ss.accept();
		
		System.out.println("Connection established");
		
		ps = new PrintStream(s.getOutputStream());
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		kb = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public static void main(String arg[]) throws Exception
	{
		
		st1 client = new st1();
		st2 server = new st2();
		
		client.start();
		server.start();
		
		
			/*
			 * ps.close(); br.close(); kb.close(); ss.close(); s.close(); System.exit(0);
			 */
		
	}
}


class st1 extends Thread{
	public void run(){
		try {
			server s = new server();
			String str = s.br.readLine();
			
            if (!(str == null)) {
            	System.out.println("Client: " + str);
            }
            else{
            	return;
            }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}

class st2 extends Thread{
	public void run(){
		try {
			server s =new server();
			System.out.print("Server: ");
			
            String str1 = s.kb.readLine();
            
            if (!str1.equals("exit")) {
            	s.ps.println(str1);
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