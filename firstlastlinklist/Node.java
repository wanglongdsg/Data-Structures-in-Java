/*
 * Node链接点
 */
public class Node {
	//数据域
	public long data;
	//下一个指针
	public Node next;
	
	public Node(long value) {
		this.data = value;
	}
	
	/**
	 * 显示方法
	 */
	public void display() {
		System.out.print(data + " ");
	}
}
