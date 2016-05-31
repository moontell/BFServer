package serviceImpl;

import java.io.*;
import java.rmi.RemoteException;

import service.UserService;

public class UserServiceImpl implements UserService{

	@Override
	public boolean login(String username, String password) {
		boolean isTrue=false;
		File userList =new File("usersList.txt");
		while(!userList.exists())
			try {
				userList.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		try{
			BufferedReader br =new BufferedReader(new FileReader(userList));
			String temp=new String();
					temp=br.readLine();
			while(!temp.equals(null)){
				if(temp.contains(username+" "+password)){
					isTrue =true;
					break;
				}else temp=br.readLine();
			}
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return isTrue;
	}

	@Override
	public boolean logout(String username) throws RemoteException {
		
		return true;
	}

}
