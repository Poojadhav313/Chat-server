
import java.net.*;
import java.io.*;
import java.util.*;

public class server {
	public static void main(String arg[]) throws Exception
	{
		ServerSocket ss = new ServerSocket(8082);
		Socket s = ss.accept();
		System.out.println("connection established");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
		
		PrintStream ps = new PrintStream(s.getOutputStream());
		
		while(true)
		{
			String str, str1;
			
			while((str = br.readLine()) != null)
			{
				System.out.println(str);
				str1 = kb.readLine();
				ps.println(str1);
			}
			
			ps.close();
			br.close();
			kb.close();
			ss.close();
			s.close();
			System.exit(0);
		}
	}
}
