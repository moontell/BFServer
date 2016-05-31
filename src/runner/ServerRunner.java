package runner;

import java.io.*;

import rmi.RemoteHelper;

public class ServerRunner {
	static String versionBasePath="D:/大作业BF/versions";
	static String usersBasePath="D:/大作业BF/users";
	
	public ServerRunner() {
		new RemoteHelper();
	}
	
	public static void main(String[] args) {
		new ServerRunner();
		File usersList = new File(usersBasePath +"/usersList.txt");
		try {
		while(!usersList.exists()){
				usersList.createNewFile();
			
		}
		FileWriter writer =new FileWriter(usersList,true);
		BufferedWriter bw =new BufferedWriter(writer);
		bw.write("admin 123456");
		bw.newLine();
		bw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
