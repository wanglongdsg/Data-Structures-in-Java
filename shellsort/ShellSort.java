/**
 * 希尔排序：
 * 基本思想：算法先将要排序的一组数按某个增量d（n/2,n为要排序数的个数）分成若干组，
 * 每组中记录的下标相差d.对每组中全部元素进行直接插入排序，然后再用一个较小的增量（d/2）对它进行分组，
 * 在每组中再进行直接插入排序。当增量减到1时，进行直接插入排序后，排序完成。
 * @author Administrator
 *
 */
public class ShellSort {
	public static void shellSort(int[] arr){
		double d1 =arr.length;
		int temp =0;
		while(true){
			//找出增量（注意这个地方）
			d1 = Math.ceil(d1/2);
			//将d转换为int类型的
			int d =(int)d1;
			for(int x=0; x<d ;x++){
				for(int i=x+d; i<arr.length; i+=d){
					temp =arr[i];
					int j=i-d;
					while(j>0&&arr[j]>temp){
						arr[j+d]=arr[j];
						j-=d;
					}
					arr[j+d]=temp;
				}
			}
			if(d==1){
				break;
			}
		}
	}
}
