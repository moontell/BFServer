//璇蜂笉瑕佷慨鏀规湰鏂囦欢鍚�
package serviceImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.RemoteException;

import service.ExecuteService;
import service.UserService;

public class ExecuteServiceImpl implements ExecuteService {

	/**
	 * 璇峰疄鐜拌鏂规硶
	 */
	@Override
	public String execute(String order, String param) throws RemoteException {
		String[] orderSplit =order.split("");
		int order_i=0;
		int param_i=0;
		String result=new String();
		int[] bb =new int[200];
		int bb_i=0;
		int count1=0;
		int count2 =0;//count 用来给遇到的【/】计数
		
		do{
			switch(orderSplit[order_i]){
			case ",":{
				//  if ((param_i < 0) || (param_i >=param.length())) 
				//	  return "StringIndexOutOfBoundsException";
				bb[bb_i]=param.charAt(param_i);
				param_i++;
				order_i++;
				continue;}
			case ".":{
				result+=(char)bb[bb_i];
				order_i++;continue;}
			case "<":{
				bb_i--;
				order_i++;continue;}
			case ">":{
				bb_i++;
				order_i++;continue;}
			case "-":{
				bb[bb_i]--; //Exception in thread "AWT-EventQueue-0" java.lang.ArrayIndexOutOfBoundsException: -1
				//at serviceImpl.ExecuteServiceImpl.execute(ExecuteServiceImpl.java:44)
				order_i++;continue;}
			case "+":{
				bb[bb_i]++;
				order_i++;continue;}
			case "[":{
				if(bb[bb_i]==0){
					count1++;
					do{
						order_i++;
						if(orderSplit[order_i].equals("]"))
							count2++;
						if(orderSplit[order_i].equals("["))
							count1++;
						}while(count2!=count1);
				}else order_i++;
				continue;}
			case "]":{
				if(bb[bb_i]==0){
					order_i++;
				}else{
					count2++;
					do{
						order_i--;
						if(orderSplit[order_i].equals("]"))
							count2++;
						if(orderSplit[order_i].equals("["))
							count1++;
					}while(count2!=count1);
				}
				continue;}
			default:{order_i++;continue;}
			}
		}while(order_i<order.length());
		return result;
}

}
