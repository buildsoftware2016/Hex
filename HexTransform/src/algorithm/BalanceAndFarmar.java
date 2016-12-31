package algorithm;

public class BalanceAndFarmar {

	/**
	 * 有一架天平，它有40个砝码，这40个砝码的重量分别为 1，5， 25, 125....5^19,每种重量的砝码都有两个。
	 * 只要被称的物品的重量为位于区间 [1,(5^20−1)/2] 的整数，就可以使用这架天平进行称量。
	 * 假设物品一直放在天平的左边，现在给出每个物品的重量，请打印出称量的方案。
	 * 输出格式为两组数字，第一组代表天平左边要放的砝码，第二组代表天平右边要放的砝码。
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] result = new int[2][20];
		result=solve(33);
		System.out.print("左托盘： ");
		for(int a:result[0]){
			System.out.print(a+",");
		}
		System.out.println();
		System.out.print("右托盘： ");
		for(int a:result[1]){
			System.out.print(a+",");
		}
	}
	
	/*
	 * 解决办法：
	 * 首先将物体的重量x转换为5进制数，
	 * 如果5进制数的每一位都是0,1或2，则天平左边不需要配重；
	 * 如果某一位是3或4，例如x=41  0131+2*5^1=0201,
	 * 即为做托盘41+2*5^1，右托盘2*5^2+1
	 */
	public static int[][] solve(int x) {//x为物体的重量
		int pl = 0, pr = 0;
	    int poise = 1, r;//r为x除以5的余数
	    final int LEFT = 0, RIGHT = 1;
	    int[][] result = new int[2][20];
	    
	    while(x>0){
	    	r=x%5;
	    	if(r==1){
	    		result[RIGHT][pr] = poise;
	    		pr++;
	            x = x / 5;
	    	}
	    	if(r==2){
	    		result[RIGHT][pr] = poise;
	    		result[RIGHT][pr+1] = poise;
	    		pr+=2;
	            x = x / 5;
	    	}
	    	if(r==3){
	    		result[LEFT][pl] = poise;
	    		result[LEFT][pl+1] = poise;
	    		pl+=2;
	    		x = (x+2) / 5;	    		
	    	}
	    	if(r==4){
	    		result[LEFT][pl] = poise;
	    		pl++;
	    		x = (x+1) / 5;
	    	}
	    	
	    	poise *= 5;
	    }
	    
	    return result;
	}
}
