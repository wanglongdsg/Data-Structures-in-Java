/*
 * Node链接点
 * 增加部分，增加指向上一个结点的指针
 */
public class Node {
	//数据域
	public long data;
	//下一个指针
	public Node next;
	//上一个指针
	public Node previous;
	
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
