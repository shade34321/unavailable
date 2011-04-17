package MedicalSoftware;

/*
 * @author Nathanial Heard
 * 
 */

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.logging.Level;

class Server {

	private static final int PORT = 5900;

	private static final String HOST = "cs2340.dyndns-server.com";

	private static final int PORT2 = 5901;

	private static final int PORT3 = 5902;

	private static final int PORT4 = 5903;

	private static final int PORT5 = 5904;

	private static final int PORT6 = 5905;

	private static final int PORT7 = 5906;

	private static final int PORT8 = 5907;

	private static final int PORT9 = 5908;

	private static final int PORT10 = 5909;

	public void save(AVL<String, Info> inform) {
		try {
			Socket skt2 = new Socket(HOST, PORT2);
			String str = "";
			try {
				BSTNode<String, Info> name;
				while (inform.getRoot() != null) {
					name = inform.getRoot();
					str += (name.getValue().getName() + "-1");
					str += (name.getValue().getPassword() + "-1");
					str += (name.getValue().getUserName() + "-1");
					str += (name.getValue().getEmail() + "-1");
					str += (name.getValue().getAddress() + "-1");
					str += (name.getValue().getState() + "-1");
					str += (name.getValue().getCountry() + "-1");
					str += (Integer.toString(name.getValue().getSSN()) + "-1");
					str += (Integer.toString(name.getValue().getZip()) + "-1");
					str += (Integer.toString(name.getValue().getBirthday()) + "-1");
					str += (Integer.toString(name.getValue().getType()) + "-1");
					if (name.getValue().isSusp() == true) {
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

			} catch (FileNotFoundException e) {
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
					array.add(temp.trim());
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
				if ((int) Double.parseDouble(array.get(i + 11)) == 1) {
					status = true;
				}
				info = new Info(array.get(i), array.get(i + 1), array
						.get(i + 2), array.get(i + 3), array.get(i + 4), array
						.get(i + 5), array.get(i + 6), (int) Double
						.parseDouble(array.get(i + 7)), (int) Double
						.parseDouble(array.get(i + 8)), (int) Double
						.parseDouble(array.get(i + 9)), (int) Double
						.parseDouble(array.get(i + 10)), status);
				information.insert(array.get(i + 2), info);
			}

		} catch (Exception e) {
			System.out.print("Error! It didn't work! " + e + "\n");
		}
		return information;
	}

	public AVL<String, Info> loadAppt(AVL<String, Info> tree) {
		ArrayList<String> array = new ArrayList<String>();

		try {
			Socket skt3 = new Socket(HOST, PORT3);
			BufferedReader br;
			String str, temp;
			char tempArr[] = new char[300];
			int j = 0;

			br = new BufferedReader(
					new InputStreamReader(skt3.getInputStream()));
			str = br.readLine();
			char arr[] = str.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == '-' && arr[i + 1] == '1') {
					temp = new String(tempArr);
					array.add(temp.trim());
					tempArr = new char[300];
					j = 0;
					i += 2;
				}
				if (i < arr.length) {
					tempArr[j] = arr[i];
				}
				j++;
			}

			br.close();
			skt3.close();

			// Loads SystemAdmin information into tree
			for (int i = 0; i < array.size(); i += 5) {
				if (tree.find(array.get(i + 2)) != null) {
					if (tree.find(array.get(i + 2)).getAppt() != null) {
						tree.find(array.get(i + 2)).getAppt().create(
								Integer.parseInt(array.get(i)),
								Integer.parseInt(array.get(i + 1)),
								array.get(i + 2), array.get(i + 3),
								array.get(i + 4));
					} else {
						tree.find(array.get(i + 2)).setAppt(
								new Appointment(Integer.parseInt(array.get(i)),
										Integer.parseInt(array.get(i + 1)),
										array.get(i + 2), array.get(i + 3),
										array.get(i + 4)));

					}
				}
			}

		} catch (Exception e) {
			System.out.print("Error! It didn't work! " + e + "\n");
		}
		return tree;
	}

	public void saveAppt(AVL<String, Info> inform) {
		try {
			Socket skt4 = new Socket(HOST, PORT4);
			String str = "";
			try {
				str = createStringAppt(inform.getRoot(), str);
				PrintStream output = new PrintStream(skt4.getOutputStream());
				output.print(str);
				output.close();
				skt4.close();

			} catch (FileNotFoundException e) {
				System.out.println("Error no such file found!");
			}

		} catch (Exception e) {
			System.out.print("Error! It didn't work! " + e + "\n");
		}
	}

	private String createStringAppt(BSTNode<String, Info> tree, String str) {
		if (tree != null) {
			str = createStringAppt(tree.getLeft(), str);
			if (tree.getValue().getAppt() != null) {
				for (int i = 0; i < tree.getValue().getAppt().getAppt().size(); i++) {
					str += (Integer.toString(tree.getValue().getAppt()
							.getAppt().get(i).getDate()) + "-1");
					str += (Integer.toString(tree.getValue().getAppt()
							.getAppt().get(i).getTime()) + "-1");
					str += (tree.getValue().getAppt().getAppt().get(i)
							.getName() + "-1");
					str += (tree.getValue().getAppt().getAppt().get(i)
							.getDoctor() + "-1");
					str += (tree.getValue().getAppt().getAppt().get(i)
							.getReason() + "-1");
				}
			}
			str = createStringAppt(tree.getRight(), str);
		}
		return str;
	}

	public AVL<String, Info> loadTreatment(AVL<String, Info> tree) {
		ArrayList<String> array = new ArrayList<String>();

		try {
			Socket skt5 = new Socket(HOST, PORT5);
			BufferedReader br;
			String str, temp;
			char tempArr[] = new char[300];
			int j = 0;

			br = new BufferedReader(
					new InputStreamReader(skt5.getInputStream()));
			str = br.readLine();
			char arr[] = str.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == '-' && arr[i + 1] == '1') {
					temp = new String(tempArr);
					array.add(temp.trim());
					tempArr = new char[300];
					j = 0;
					i += 2;
				}
				if (i < arr.length) {
					tempArr[j] = arr[i];
				}
				j++;
			}

			br.close();
			skt5.close();

			// Loads SystemAdmin information into tree
			for (int i = 0; i < array.size(); i += 10) {
				if (tree.find(array.get(i)) != null) {
					if (tree.find(array.get(i)).getRecord() != null) {
						tree.find(array.get(i)).getRecord().create(
								array.get(i), array.get(i + 1),
								Integer.parseInt(array.get(i + 2)),
								Integer.parseInt(array.get(i + 3)),
								array.get(i + 4),
								Integer.parseInt(array.get(i + 5)),
								Integer.parseInt(array.get(i + 6)),
								Integer.parseInt(array.get(i + 7)),
								Integer.parseInt(array.get(i + 8)),
								Integer.parseInt(array.get(i + 9)));
					} else {
						tree.find(array.get(i)).setRecord(
								new TreatmentRecords(array.get(i), array
										.get(i + 1), Integer.parseInt(array
										.get(i + 2)), Integer.parseInt(array
										.get(i + 3)), array.get(i + 4), Integer
										.parseInt(array.get(i + 5)), Integer
										.parseInt(array.get(i + 6)), Integer
										.parseInt(array.get(i + 7)), Integer
										.parseInt(array.get(i + 8)), Integer
										.parseInt(array.get(i + 9))));

					}
				}
			}

		} catch (Exception e) {
			System.out.print("Error! It didn't work! " + e + "\n");
		}
		return tree;
	}

	public void saveTreatment(AVL<String, Info> inform) {
		try {
			Socket skt6 = new Socket(HOST, PORT6);
			String str = "";
			try {
				str = createStringTreatment(inform.getRoot(), str);
				PrintStream output = new PrintStream(skt6.getOutputStream());
				output.print(str);
				output.close();
				skt6.close();

			} catch (FileNotFoundException e) {
				System.out.println("Error no such file found!");
			}

		} catch (Exception e) {
			System.out.print("Error! It didn't work! " + e + "\n");
		}
	}

	private String createStringTreatment(BSTNode<String, Info> tree, String str) {
		if (tree != null) {
			str = createStringTreatment(tree.getLeft(), str);
			if (tree.getValue().getRecord() != null) {
				for (int i = 0; i < tree.getValue().getRecord().getRecords()
						.size(); i++) {
					str += (tree.getValue().getRecord().getRecords().get(i)
							.getName() + "-1");
					str += (tree.getValue().getRecord().getRecords().get(i)
							.getDoctor() + "-1");
					str += (Integer.toString(tree.getValue().getRecord()
							.getRecords().get(i).getDate()) + "-1");
					str += (Integer.toString(tree.getValue().getRecord()
							.getRecords().get(i).getTime()) + "-1");
					str += (tree.getValue().getRecord().getRecords().get(i)
							.getSymptoms() + "-1");
					str += (Integer.toString(tree.getValue().getRecord()
							.getRecords().get(i).getBloodPressure()) + "-1");
					str += (Integer.toString(tree.getValue().getRecord()
							.getRecords().get(i).getPulse()) + "-1");
					str += (Integer.toString(tree.getValue().getRecord()
							.getRecords().get(i).getTemperature()) + "-1");
					str += (Integer.toString(tree.getValue().getRecord()
							.getRecords().get(i).getHeight()) + "-1");
					str += (Integer.toString(tree.getValue().getRecord()
							.getRecords().get(i).getWeight()) + "-1");
				}
			}
			str = createStringTreatment(tree.getRight(), str);
		}
		return str;
	}

	public AVL<String, Info> loadOrders(AVL<String, Info> tree) {
		ArrayList<String> array = new ArrayList<String>();

		try {
			Socket skt5 = new Socket(HOST, PORT7);
			BufferedReader br;
			String str, temp;
			char tempArr[] = new char[300];
			int j = 0;

			br = new BufferedReader(
					new InputStreamReader(skt5.getInputStream()));
			str = br.readLine();
			char arr[] = str.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == '-' && arr[i + 1] == '1') {
					temp = new String(tempArr);
					array.add(temp.trim());
					tempArr = new char[300];
					j = 0;
					i += 2;
				}
				if (i < arr.length) {
					tempArr[j] = arr[i];
				}
				j++;
			}

			br.close();
			skt5.close();

			// Loads SystemAdmin information into tree
			for (int i = 0; i < array.size(); i += 7) {
				if (tree.find(array.get(i)) != null) {
					if (tree.find(array.get(i)).getOrders() != null) {
						tree.find(array.get(i)).getOrders().create(
								array.get(i),
								Integer.parseInt(array.get(i + 1)),
								Integer.parseInt(array.get(i + 2)),
								array.get(i + 3), array.get(i + 4),
								array.get(i + 5), array.get(i + 6));
					} else {
						tree.find(array.get(i)).setOrders(
								new DoctorsOrders(array.get(i), Integer
										.parseInt(array.get(i + 1)), Integer
										.parseInt(array.get(i + 2)), array
										.get(i + 3), array.get(i + 4), array
										.get(i + 5), array.get(i + 6)));

					}
				}
			}

		} catch (Exception e) {
			System.out.print("Error! It didn't work! " + e + "\n");
		}
		return tree;
	}

	public void saveOrders(AVL<String, Info> inform) {
		try {
			Socket skt6 = new Socket(HOST, PORT8);
			String str = "";
			try {
				str = createStringOrders(inform.getRoot(), str);
				PrintStream output = new PrintStream(skt6.getOutputStream());
				output.print(str);
				output.close();
				skt6.close();

			} catch (FileNotFoundException e) {
				System.out.println("Error no such file found!");
			}

		} catch (Exception e) {
			System.out.print("Error! It didn't work! " + e + "\n");
		}
	}

	private String createStringOrders(BSTNode<String, Info> tree, String str) {
		if (tree != null) {
			str = createStringOrders(tree.getLeft(), str);
			if (tree.getValue().getOrders() != null) {
				for (int i = 0; i < tree.getValue().getOrders().getOrders()
						.size(); i++) {
					str += (tree.getValue().getOrders().getOrders().get(i)
							.getName() + "-1");
					str += (Integer.toString(tree.getValue().getOrders()
							.getOrders().get(i).getDate()) + "-1");
					str += (Integer.toString(tree.getValue().getOrders()
							.getOrders().get(i).getTime()) + "-1");
					str += (tree.getValue().getOrders().getOrders().get(i)
							.getPrescription() + "-1");
					str += (tree.getValue().getOrders().getOrders().get(i)
							.getLabWork() + "-1");
					str += (tree.getValue().getOrders().getOrders().get(i)
							.getFollowUpIns() + "-1");
					str += (tree.getValue().getOrders().getOrders().get(i)
							.getOtherIns() + "-1");

				}
			}
			str = createStringOrders(tree.getRight(), str);
		}
		return str;
	}

	public AVL<String, Info> loadInvoice(AVL<String, Info> tree) {
		ArrayList<String> array = new ArrayList<String>();
		try {
			Socket skt5 = new Socket(HOST, PORT9);
			BufferedReader br;
			String str, temp;
			char tempArr[] = new char[300];
			int j = 0;

			br = new BufferedReader(
					new InputStreamReader(skt5.getInputStream()));
			str = br.readLine();
			char arr[] = str.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == '-' && arr[i + 1] == '1') {
					temp = new String(tempArr);
					array.add(temp.trim());
					tempArr = new char[300];
					j = 0;
					i += 2;
				}
				if (i < arr.length) {
					tempArr[j] = arr[i];
				}
				j++;
			}

			br.close();
			skt5.close();

			// Loads SystemAdmin information into tree
			for (int i = 0; i < array.size(); i += 5) {
				if (tree.find(array.get(i)) != null) {
					if (tree.find(array.get(i)).getInvoice() != null) {
						tree.find(array.get(i)).getInvoice().create(
								array.get(i), array.get(i + 1),
								Integer.parseInt(array.get(i + 2)),
								Integer.parseInt(array.get(i + 3)),
								array.get(i + 4));
					} else {
						tree.find(array.get(i)).setInvoice(
								new PatientInvoice(array.get(i), array
										.get(i + 1), Integer.parseInt(array
										.get(i + 2)), Integer.parseInt(array
										.get(i + 3)), array.get(i + 4)));

					}
				}
			}

		} catch (Exception e) {
			System.out.print("Error! It didn't work! " + e + "\n");
		}
		return tree;
	}

	public void saveInvoice(AVL<String, Info> inform) {
		try {
			Socket skt6 = new Socket(HOST, PORT10);
			String str = "";
			try {
				str = createStringInvoice(inform.getRoot(), str);
				PrintStream output = new PrintStream(skt6.getOutputStream());
				output.print(str);
				output.close();
				skt6.close();

			} catch (FileNotFoundException e) {
				System.out.println("Error no such file found!");
			}

		} catch (Exception e) {
			System.out.print("Error! It didn't work! " + e + "\n");
		}
	}

	private String createStringInvoice(BSTNode<String, Info> tree, String str) {
		if (tree != null) {
			str = createStringInvoice(tree.getLeft(), str);
			if (tree.getValue().getInvoice() != null) {
				for (int i = 0; i < tree.getValue().getInvoice().getInvoice()
						.size(); i++) {
					str += (tree.getValue().getInvoice().getInvoice().get(i)
							.getName() + "-1");
					str += (tree.getValue().getInvoice().getInvoice().get(i)
							.getDoctor() + "-1");
					str += (Integer.toString(tree.getValue().getInvoice()
							.getInvoice().get(i).getTotal()) + "-1");
					str += (Integer.toString(tree.getValue().getInvoice()
							.getInvoice().get(i).getDueDate()) + "-1");
					str += (tree.getValue().getInvoice().getInvoice().get(i)
							.isPaid() + "-1");
				}
			}
			str = createStringInvoice(tree.getRight(), str);
		}
		return str;
	}
}