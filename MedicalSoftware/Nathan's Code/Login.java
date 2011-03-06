package MedicalSoftware;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Login {
	private Info info;
	private AVL<String, Info> information;
	
	Login() {
		information = new AVL<String, Info>();
	}
	
	public void run() throws IOException {
		setup();
	}
	
	private void setup() throws IOException {
		String name;
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Nathanial\\Documents\\CS-2340\\Info.txt"));
			while((name = br.readLine()) != null)
			{
				info = new Info(name, br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), false);
				information.insert(name, info);	
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Error no such file found!");
		}
	}
}
