package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.mindrot.jbcrypt.BCrypt;

public class Test2 {
	public static void main(String[] args) {
		
		
		String pw1 = BCrypt.hashpw("00012345", BCrypt.gensalt(5));
		System.out.println(pw1);
		String pw2 = BCrypt.hashpw("가", BCrypt.gensalt(5));
		System.out.println(pw2);
		
		System.out.println(BCrypt.checkpw("00012345", pw1));
		System.out.println(BCrypt.checkpw("가", pw2));
		
		Random random = new Random();
		int result =random.nextInt(100000000);
		System.out.println(result);
		
		// LPAD 
	}
}
