/**
 * 快速排序
 * 基本思想：快速排序就是通过将一个数组分为两个子数组，
 * 然后通过递归调用自身为每一个字数组进行快速排序实现
 * 
 * 通常划分关键字（基准元素）的标准：
 * 第一个元素或者最后一个元素
 * 
 * @author wanglong
 * 2016-9-24 下午2:18:29
 */
public class QuickSort {
	/**
	 *划分数组:
	 *arr:需要排序的数组
	 *left:数组的第一个元素，
	 *rigth:数组的最后一个元素
	 *point:基准元素。
	 */
	public static int parttion(int[] arr , int left , int right , int point){
		//创建两个指针Pointer，将最后一个元素作为基准元素
		int leftPtr = left-1;
		int rightPtr=right;
		while(true){
			//循环，将比基准元素小的元素留在右边
			while(leftPtr<rightPtr && arr[++leftPtr]<point);
			//循环，将比基准元素大的元素留在左边
			while(leftPtr<rightPtr && arr[--rightPtr]>point);
			if(leftPtr>=rightPtr){
				break;
			}else{
				int temp = arr[leftPtr];
				arr[leftPtr] = arr[rightPtr];
				arr[rightPtr] = temp;
			}
		}
		int temp = arr[leftPtr];
		arr[leftPtr] = arr[right];
		arr[right] = temp;
		//返回基准元素所在的位置
		return leftPtr;
	}
	/**
	 * 快速排序
	 */
	public static void quickSort(int[] arr , int left ,int right){
		if(left>=right){
			return;
		}else{
			//设置关键字
			int point = arr[right];
			//获得切入点，对数组进行划分
			int parttion = parttion(arr, left, right, point);
			//对左边的数组进行快速排序
			quickSort(arr,left,parttion-1);
			//对右边的数组进行快速排序
			quickSort(arr,parttion+1,right);
			
		}
	}
	
}
