package numberTypeChange;

import java.util.Scanner;

/**
 * ʮ��������ת������
 * ���demoֻչʾbyte������(8λ)��-128~127����ת����
 * �����short(16λ)��int(32λ),long(64λ)ͬ��
 * @author Administrator
 *
 */
public class Ten2Two {
	static int[] arr=new int[2];
	static int m=7;//ÿ��һ������2��������arr3���飬���Լ�һ��
	static int[] arr3=new int[8];
	/*
	 * ������˼·��
	 * ������ʮ���������Զ����õ������ٳ��Զ�����������֪����Ϊ���һʱΪֹ��
	 * ÿ��������������0��1������һ�����飬
	 * ����ķ���void swap(int a)���Ƕ���һ˼·��ʵ�֡�
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("������һ��������");
		int a=sc.nextInt();
		sc.close();
	
		System.out.println(swap2(a));
	}
	
	/*
	 * ����һ�����飬�������
	 * ����2���������ͳ���2����
	 */
	public static void oct(int a){
		int n=a%2; //����
		a=a/2;     //ȡ��
		arr[0]=n;
		arr[1]=a;
	}
	
	/*
	 * ������ת��Ϊ��Ӧ�ġ������ơ�����
	 */
	public static void swap(int a){
		while(a>0){
			oct(a);
			int n=arr[0];//����
			a=arr[1];//ȡ��
			
			arr3[m]=n;
			m--;				
		}
	}
	
	/*
	 * ������,������
	 */
	public static String swap2(int a){		
		if(a==-0 || a==-0){
			return "0000";
		}	
		
		//������
		if(a>0){
			swap(a);
		}
		
		//������
		if(a<0){
			a=a*(-1);
			swap(a);
			
			//ԭ��
			arr3[0]=1;
//			System.out.println(Arrays.toString(arr3));
			
			//����
			for(int i=1;i<arr3.length;i++){
				arr3[i]+=1;
			}
			for(int i=1;i<arr3.length;i++){
				if(arr3[i]==1){
					arr3[i]=1;
				}
				if(arr3[i]==2){
					arr3[i]=0;
				}
			}
			arr3[0]=1;
//			System.out.println(Arrays.toString(arr3));
			
			//����
			int c=0;
			for(int i=arr3.length-1;i>=0;i--){
				//�ҳ�������һ��0��λ��
				if(arr3[i]==0){
					c=i;
					break;
				}
			}
			arr3[c]=1;
			for(int i=c+1;i<arr3.length;i++){
				arr3[i]=0;
			}
//			System.out.println(Arrays.toString(arr3));
		}
		
		//����ת���Ƿ�ɹ�
//		System.out.println(Arrays.toString(arr3));
		String s1=arr2str(arr3);
		return s1;
	}
	
	/*
	 * ������ת�����ַ���
	 */
	public static String arr2str(int[] arr){
		String s1=new String();	
		for(int i=0;i<arr3.length;i++){
			String s=(new Integer(arr3[i]).toString());
			s1+=s;
		}

		return s1;
	}
}
