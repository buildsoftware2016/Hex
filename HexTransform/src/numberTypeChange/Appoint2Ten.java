package numberTypeChange;

import java.util.LinkedList;
import java.util.Scanner;

public class Appoint2Ten {

	/**
	 * r����ת��Ϊʮ��������
	 * ���demoֻչʾbyte��������(8λ)��ת��
	 * @param args
	 */
	
	static int r;
	//list���ڴ����ֺ��r��������
	static LinkedList<Integer> list=new LinkedList<Integer>();
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("������һ�����֣�");
		String s=sc.nextLine();
//		System.out.println(s);
		sc.close();
		
		System.out.println(transform(s));
//		transform(s);
	}
	
	//sΪ��ת����һ������
	public static Integer transform(String s){
		//��s��֣����δ���list
		for(int i=0;i<s.length();i++){
			int n=Integer.valueOf(s.substring(i,i+1)).intValue();
			//�������������Ƿ�����
			if(n<0 || n>=r){
				System.out.println("�������������");
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
	
	//m��n�η�
	public static int mi(int m,int n){
		int b=1;
		for(int i=0;i<n;i++){
			b*=m;
		}
		
		return b;
	}

}
