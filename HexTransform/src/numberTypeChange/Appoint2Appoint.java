package numberTypeChange;

public class Appoint2Appoint {

	/**
	 * ��ĳ�ֽ��Ƶ�һ������ת��Ϊָ������
	 * @param args
	 */
	public static void main(String[] args) {
		String s="11001";
		int radixSrc=2;
		int radixTgt=3;
		
		System.out.println(transform(s,radixSrc,radixTgt));
	}
	
	/*
	 * ��radixSrc���Ƶ�����s��ת��ΪradixTgt����
	 */
	public static String transform(String s, int radixSrc, int radixTgt){
		if(radixSrc==radixTgt){
			return s;
		}
		
		//��radixSrc���Ƶ�����ת��Ϊʮ����
		Appoint2Ten.r=radixSrc;
		int a=Appoint2Ten.transform(s);
		
		//��ʮ���Ƶ�����ת��ΪradixTgt����
		Ten2Appoint.r=radixTgt;
		String s1=Ten2Appoint.transform(a);
		
		return s1;
	}
}
