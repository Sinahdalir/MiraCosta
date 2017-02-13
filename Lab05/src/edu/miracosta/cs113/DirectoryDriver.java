package edu.miracosta.cs113;
import java.util.ArrayList;

public class DirectoryDriver {

	public static void main(String[] args) {
		TheDirectory list = new TheDirectory();
		list.addOrChangeEntry("Sina", "1234567");
		list.addOrChangeEntry("Tina", "9876543");
		
		list.addOrChangeEntry("Sina", "11112222");
		list.removeEntry("Tina");
		
		for(int i = 0 ; i < list.getDirectory().size() ; i++)
		{
			System.out.println(list.getDirectory());
		}
		

	}

}
