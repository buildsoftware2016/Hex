package numberTypeChange;

import java.util.LinkedList;
import java.util.Scanner;

public class Ten2Appoint {

	/**
	 * ʮ��������ת��Ϊr����
	 * ���demoֻչʾbyte��������(8λ)��-128~127����ת��
	 * @param args
	 */
	static int r;
	//����a����r����
	static int m;
	//����a����r������,��LinkedList<Integer>����ʽ���棬�����������
	static LinkedList<Integer> list=new LinkedList<Integer>();
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("������һ��������");
		int a=sc.nextInt();
		sc.close();
		
		System.out.println(transform(a));
	}
	
	/*
	 * ��10��������aת����r����
	 * 
	 */
	public static String transform(int a){
		swap(a);
		//��LinkedList<Integer>תΪString
		String s1=new String();	
		for(int i=0;i<list.size();i++){
			s1+=new Integer(list.get(i)).toString();
		}
		return s1;
	}
	
	//a����r
	public static void oct(int a){
		int n=a%r; //����
		a=a/r;     //ȡ��
		m=a;
//		list.add(new Integer(n));
		list.addFirst(new Integer(n));
	}
	
	/*
	 * ������ת��Ϊ��Ӧ�ġ�r���ơ�����
	 */
	public static void swap(int a){
		while(a>0){
			oct(a);
			a=m;//ȡ��				
		}
	}
	
}
