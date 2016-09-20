public static int halfSeach(int[] arr,int key)
	{
		//定义三个变量，分别代表着第一个元素，中间元素和最后一个元素
		int min,mid,max;
		min = 0;
		max = arr.length-1;
		mid = (max+min)/2;

		while(arr[mid]!=key)
		{
			if(key>arr[mid])
				min = mid + 1;
			else if(key<arr[mid])
				max = mid - 1;
			
			if(min>max)
				return -1;
	
			mid = (max+min)/2;
		}
		return mid;
	}
