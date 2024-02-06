import java.net.*;
import java.io.*;
import java.util.*;

public class client {
	public static void main(String arg[]) throws Exception
	{
		Socket s = new Socket("localhost", 8082);
		//DataOutputStream dos = new DataOutputStream(s.getOutputStream());
    PrintStream ps = new PrintStream(s.getOutputStream());
		
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
		
		String str, str1;
		while(!(str = kb.readLine()).equals("exit"))
		{
			//dos.writeBytes(str + "\n");
			ps.println(str);
      str1 = br.readLine();
			System.out.println(str1);
		}
		
		//dos.close();
		ps.close();
    br.close();
		kb.close();
		s.close();
		
	}
}
