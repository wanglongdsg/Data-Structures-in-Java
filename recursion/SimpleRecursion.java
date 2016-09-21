/**
 * 递归的那些事
 * 主要有三角函数递归和斐波纳契递归
 * @author Administrator
 *
 */
public class SimpleRecursion {
	public static void main(String[] args) {
		System.out.println(triangle(4)); //10
		System.out.println(fibonacci(4)); //2
	}
	/**
	 * 三角数字，第n项的值是由第n-1项的值加上n
	 */
	public static int triangle(int n){
		if(n==1){
			return 1;
		}else{
			return triangle(n-1)+n;
		}
	}
	/**
	 * 斐波纳契函数，第n项值等于第n-1项的值加上第n-2项的值，
	 */
	public static int fibonacci(int n){
		if(n==1){
			return 0;
		}else if(n==2){
			return 1;
		}else{
			return fibonacci(n-1)+fibonacci(n-2);
		}
		
	}
}
