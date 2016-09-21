/*
 * 双向链表
 */
public class DoubleLinkList {
	//头结点
	private Node first;
	//尾结点
	private Node last;
	
	public DoubleLinkList() {
		first = null;
		last =null;
	}
	
	/**
	 * 插入一个结点，在头结点后进行插入
	 * 原理：要对链表进行判断，如果为空则设置尾结点为新添加的结点。
	 * 如果不为空，还需要设置头结点的前一个结点为新添加的结点。
	 */
	public void insertFirst(long value) {
		Node node = new Node(value);
		if(first==null){
			last=node;
		}else{
			first.previous=node;
		}
		node.next = first;
		first = node;
	}
	/**
	 * 从尾部进行插入数据
	 * 原理：如果链表为空，则设置头结点为新添加的结点。
	 * 否则设置尾结点的后一个结点为新添加的结点。
	 * 同时设置新添加结点的前一个结点为尾结点
	 */
	public void insertLast(long value){
		Node node = new Node(value);
		if(first==null){
			first=node;
		}else{
			last.next=node;
		}
		node.previous=last;
		last =node;
	}
	
	/**
	 * 删除一个结点，在头结点后进行删除
	 * 原理：
	 * 判断头部是否有下一个结点，如果没有则设置last为null
	 * 否则设置头结点的下一个结点的previous为null
	 */
	public Node deleteFirst() {
		Node tmp = first;
		if(first.next==null){
			last=null;
		}else{
			first.next.previous=null;
		}
		first = tmp.next;
		return tmp;
		}
	/**
	 * 从尾部开始删除数据
	 * 原理：如果头结点后没有其他的结点，则设置头结点为null，
	 * 否则设置尾结点前一个结点的next为null，设置尾结点为前一个结点
	 */
	public Node deleteLast(){
		if(first.next==null){
			last=null;
		}else{
			last.previous.next=null;
		}
		last=last.previous;
		return last;
	}
	
	/**
	 * 显示方法
	 */
	public void display() {
		Node current = first;
		while(current != null) {
			current.display();
			current = current.next;
		}
		System.out.println();
	}
	
	/**
	 * 查找方法
	 */
	public Node find(long value) {
		Node current = first;
		while(current.data != value) {
			if(current.next == null) {
				return null;
			}
			current = current.next;
		}
		return current;
	}
	
	/**
	 * 删除方法，根据数据域来进行删除
	 */
	public Node delete(long value) {
		Node current = first;
		Node previous = first;
		while(current.data != value) {
			if(current.next == null) {
				return null;
			}
			previous = current;
			current = current.next;
		}
		
		if(current == first) {
			first = first.next;
		} else {
			previous.next = current.next;
		}
		return current;
		
	}
	/**
	 * 判断链表是否为空
	 */
	public boolean isEmpty(){
		return first==null;
	}
}
