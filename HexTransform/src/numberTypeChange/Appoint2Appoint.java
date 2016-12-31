package numberTypeChange;

public class Appoint2Appoint {

	/**
	 * 将某种进制的一串数字转换为指定进制
	 * @param args
	 */
	public static void main(String[] args) {
		String s="11001";
		int radixSrc=2;
		int radixTgt=3;
		
		System.out.println(transform(s,radixSrc,radixTgt));
	}
	
	/*
	 * 将radixSrc进制的数字s，转换为radixTgt进制
	 */
	public static String transform(String s, int radixSrc, int radixTgt){
		if(radixSrc==radixTgt){
			return s;
		}
		
		//将radixSrc进制的数字转换为十进制
		Appoint2Ten.r=radixSrc;
		int a=Appoint2Ten.transform(s);
		
		//将十进制的数字转换为radixTgt进制
		Ten2Appoint.r=radixTgt;
		String s1=Ten2Appoint.transform(a);
		
		return s1;
	}
}
