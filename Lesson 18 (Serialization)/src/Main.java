import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import by.zti.SerializationManager;;

public class Main {
	
	private static ArrayList<Profile> profiles = new ArrayList<Profile>();
	
	@SuppressWarnings("unchecked")
	public static void main(String args[]){
		//profiles = (ArrayList<Profile>) deserData("profiles");
		profiles = (ArrayList<Profile>) SerializationManager.deSerializeData("profiles", "ser", "");
		System.out.println(profiles.size());
		Profile profile = new Profile();
		profile.setName(JOptionPane.showInputDialog(null, "������� ���� ���"));
		profile.setSurname(JOptionPane.showInputDialog(null, "������� ���� �������"));
		profiles.add(profile);
		for (Profile p : profiles){
			System.out.println(p.getName()+" "+p.getSurname());
		}
		System.out.println(profiles.size());
		//SerData("profiles", profiles);
		 SerializationManager.serializeData(profiles, "profiles", "ser", "");
	}

	/*private static Object deserData(String file_name) {
		Object retObject = null;
		try {
			FileInputStream fileIn = new FileInputStream(file_name + ".ser"); //����� ��� ������ ������
			ObjectInputStream in = new ObjectInputStream(fileIn);
			retObject = in.readObject();
			fileIn.close();
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("���� �� ������");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("������ �����/������");
			System.exit(2);
		} catch (ClassNotFoundException e){
			System.out.println("����� �� ������");
			System.exit(3);
		}
		return retObject;
		
	}

	private static void SerData(String file_name, Object obj) {
		try {
			FileOutputStream fileOut = new FileOutputStream(file_name + ".ser"); //����� ��� ������ ������
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(obj);
			fileOut.close();
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("���� �� ������");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("������ �����/������");
			System.exit(2);
		}
		
		
	}*/
}
