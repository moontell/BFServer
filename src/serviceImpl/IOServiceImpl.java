package serviceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JMenuItem;

import service.IOService;

public class IOServiceImpl implements IOService{
	
	@Override
	public boolean writeFile(String file, String userId, String fileName) {
		
		File f = new File(userId);//通用
		try {
		while(!f.exists()){
			f.mkdirs();
		}
		File txt =new File(f.getAbsolutePath()+fileName);
		while(!txt.exists()){
			txt.createNewFile();
		}
		FileWriter writer =new FileWriter(txt);
		BufferedWriter br=new BufferedWriter(writer);
		
			br.write(file);
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public String readFile(String userId, String fileName) {
		String result=new String();
		File userDir =new File(userId);
		File file =new File(userDir.getAbsolutePath()+"/"+fileName);
		try {
			FileReader reader=new FileReader(file);
			BufferedReader br =new BufferedReader(reader);
			while(!br.readLine().equals(null)){
				result+=br.readLine()+" ";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "查无此txt文件";
		}
		
		return result;
	}
	
	
	public String read_File( String fileName){
		File file =new File(fileName);
		String str=new String();
		try {
			BufferedReader reader =new BufferedReader(new FileReader(file));
			str =reader.readLine();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
		
	}
	
	@Override
	public String readFileList(String userId) {
		// TODO Auto-generated method stub
		String str =new String();
		File f = new File(userId);//通用
		if(!f.exists()){
			f.mkdirs();
		}
		File[] fDir =f.listFiles();
		for(int i=0;i<fDir.length;i++){
			str+=" "+fDir[i].getName();
		}
		return str;
	}
	public boolean createNewProject(String userId,String projectName){
		File userFile =new File(userId);
		if(!userFile.exists()){
			userFile.mkdirs();
		}
		File project =new File(userFile.getAbsolutePath()+"/"+projectName);//每一个程序的代码都保存在这个txt文件里：xxyyzz (code)的格式
		while(!project.exists()){
			project.mkdirs();
		}
		
		return true;
	}
}
