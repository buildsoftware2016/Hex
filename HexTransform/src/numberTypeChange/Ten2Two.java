package numberTypeChange;

import java.util.Scanner;

/**
 * 十进制整数转二进制
 * 这个demo只展示byte型整数(8位)（-128~127）的转换，
 * 其余的short(16位)，int(32位),long(64位)同理
 * @author Administrator
 *
 */
public class Ten2Two {
	static int[] arr=new int[2];
	static int m=7;//每存一个整除2的余数到arr3数组，则自减一次
	static int[] arr3=new int[8];
	/*
	 * 整体解决思路：
	 * 将正的十进制数除以二，得到的商再除以二，依次类推知道商为零或一时为止，
	 * 每次相除后的余数（0或1）存入一个数组，
	 * 下面的方法void swap(int a)就是对这一思路的实现。
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入一个整数：");
		int a=sc.nextInt();
		sc.close();
	
		System.out.println(swap2(a));
	}
	
	/*
	 * 返回一个数组，储存的是
	 * 整除2的余数，和除以2的商
	 */
	public static void oct(int a){
		int n=a%2; //余数
		a=a/2;     //取整
		arr[0]=n;
		arr[1]=a;
	}
	
	/*
	 * 正整数转化为对应的“二进制”数组
	 */
	public static void swap(int a){
		while(a>0){
			oct(a);
			int n=arr[0];//余数
			a=arr[1];//取整
			
			arr3[m]=n;
			m--;				
		}
	}
	
	/*
	 * 正整数,负整数
	 */
	public static String swap2(int a){		
		if(a==-0 || a==-0){
			return "0000";
		}	
		
		//正整数
		if(a>0){
			swap(a);
		}
		
		//负整数
		if(a<0){
			a=a*(-1);
			swap(a);
			
			//原码
			arr3[0]=1;
//			System.out.println(Arrays.toString(arr3));
			
			//反码
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
			
			//补码
			int c=0;
			for(int i=arr3.length-1;i>=0;i--){
				//找出倒数第一个0的位置
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
		
		//测试转换是否成功
//		System.out.println(Arrays.toString(arr3));
		String s1=arr2str(arr3);
		return s1;
	}
	
	/*
	 * 将数组转换成字符串
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
