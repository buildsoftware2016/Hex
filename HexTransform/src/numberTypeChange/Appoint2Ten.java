package numberTypeChange;

import java.util.LinkedList;
import java.util.Scanner;

public class Appoint2Ten {

	/**
	 * r进制转换为十进制整数
	 * 这个demo只展示byte型正整数(8位)的转换
	 * @param args
	 */
	
	static int r;
	//list用于储存拆分后的r进制数字
	static LinkedList<Integer> list=new LinkedList<Integer>();
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入一串数字：");
		String s=sc.nextLine();
//		System.out.println(s);
		sc.close();
		
		System.out.println(transform(s));
//		transform(s);
	}
	
	//s为待转换的一串数字
	public static Integer transform(String s){
		//将s拆分，依次存入list
		for(int i=0;i<s.length();i++){
			int n=Integer.valueOf(s.substring(i,i+1)).intValue();
			//检查输入的数字是否有误
			if(n<0 || n>=r){
				System.out.println("输入的数字有误");
				return null;
			}
			list.add(n);
		}		
//		System.out.println(list.toString());//int i=list.size()-1;i>=0;i--
		
		int a=0;
		for(int i=0;i<list.size();i++){
			a+=list.get(i) * mi(r,list.size()-1-i);
		}
//		System.out.println(a);	
		return a;
	}
	
	//m的n次方
	public static int mi(int m,int n){
		int b=1;
		for(int i=0;i<n;i++){
			b*=m;
		}
		
		return b;
	}

}
