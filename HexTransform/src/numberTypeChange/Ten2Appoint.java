package numberTypeChange;

import java.util.LinkedList;
import java.util.Scanner;

public class Ten2Appoint {

	/**
	 * 十进制整数转换为r进制
	 * 这个demo只展示byte型正整数(8位)（-128~127）的转换
	 * @param args
	 */
	static int r;
	//储存a整除r的商
	static int m;
	//储存a整除r的余数,以LinkedList<Integer>的形式储存，方便后续操作
	static LinkedList<Integer> list=new LinkedList<Integer>();
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入一个整数：");
		int a=sc.nextInt();
		sc.close();
		
		System.out.println(transform(a));
	}
	
	/*
	 * 将10进制整数a转换成r进制
	 * 
	 */
	public static String transform(int a){
		swap(a);
		//将LinkedList<Integer>转为String
		String s1=new String();	
		for(int i=0;i<list.size();i++){
			s1+=new Integer(list.get(i)).toString();
		}
		return s1;
	}
	
	//a整除r
	public static void oct(int a){
		int n=a%r; //余数
		a=a/r;     //取整
		m=a;
//		list.add(new Integer(n));
		list.addFirst(new Integer(n));
	}
	
	/*
	 * 正整数转化为对应的“r进制”数组
	 */
	public static void swap(int a){
		while(a>0){
			oct(a);
			a=m;//取整				
		}
	}
	
}
