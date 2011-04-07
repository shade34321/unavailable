package MedicalSoftware;
/*
 * @author Nathanial Heard
 * 
 */

import java.io.*;
import java.net.*;
import java.util.ArrayList;

class Server {

	static final int PORT = 5900;
	static final String HOST = "cs2340.dyndns-server.com";
	
	public void save(AVL<String, Info> inform) {
		try {
			Socket skt2 = new Socket(HOST, PORT);
			String str = "";
			try {
				BSTNode<String, Info> name;
				while (inform.getRoot() != null) {
						name = inform.getRoot();
						str += (name.getValue().getName() + "-1");
						str += (name.getValue().getPassword()+ "-1");
						str += (name.getValue().getUserName() + "-1");
						str += (name.getValue().getEmail() + "-1");
						str += (name.getValue().getAddress() + "-1");
						str += (name.getValue().getState() + "-1");
						str += (name.getValue().getCountry() + "-1");
						str += (Integer.toString(name.getValue().getSSN()) + "-1");
						str += (Integer.toString(name.getValue().getZip()) + "-1");
						str += (Integer.toString(name.getValue().getBirthday()) + "-1");
						str += (Integer.toString(name.getValue().getType()) + "-1");
						if (name.getValue().getSusp() == true) {
							str += "1-1";
						} else {
							str += "0-1";
						}
						inform.remove(inform.getRoot().getKey());
					}
				PrintStream output = new PrintStream(skt2.getOutputStream());
				output.print(str);
				output.close();
				skt2.close();
				
			}
			catch (FileNotFoundException e) {
				System.out.println("Error no such file found!");
			}
			
			

		} catch (Exception e) {
			System.out.print("Error! It didn't work! " + e + "\n");
		}
	}
	
	public AVL<String, Info> load() {
		ArrayList<String> array = new ArrayList<String>();
		AVL<String, Info> information = new AVL<String, Info>();
		try {
		Socket skt = new Socket(HOST, PORT);
		BufferedReader br;
		String str, temp;
		char tempArr[] = new char[100];
		int j = 0;
		
		br = new BufferedReader(new InputStreamReader(skt.getInputStream()));
		str = br.readLine();
		char arr[] = str.toCharArray();
			for (int i = 0; i < arr.length; i++) {
					if (arr[i] == '-' && arr[i + 1] == '1') {
						temp = new String(tempArr);
						array.add(temp);
						tempArr = new char[100];
						j = 0;
						i += 2;
					}
					if (i < arr.length) {
						tempArr[j] = arr[i];
					}
					j++;
			}
		
		br.close();
		skt.close();
		
		Info info;
		// Loads SystemAdmin information into tree
			for (int i = 0; i < array.size(); i += 12) {
				boolean status = false;
				if ((int)Double.parseDouble(array.get(i + 11)) == 1) {
					status = true;
				}
				info = new Info(array.get(i), array.get(i + 1), array.get(i + 2), array.get(i + 3), array.get(i + 4), array.get(i + 5), array.get(i + 6), (int)Double.parseDouble(array.get(i + 7)), (int)Double.parseDouble(array.get(i + 8)), (int)Double.parseDouble(array.get(i + 9)), (int)Double.parseDouble(array.get(i + 10)), status);
				information.insert(array.get(i + 2), info);
			}

	} catch (Exception e) {
		System.out.print("Error! It didn't work! " + e + "\n");
	}
		return information;
	}
}