/**
 * auther ： roywnag
 */
public class FirstLastLinkList {
	// 头结点
	private Node first;
	// 尾结点
	private Node last;
	
	public FirstLastLinkList() {
		first = null;
		last =null;
	}
	
	/**
	 * 插入一个结点，在头结点后进行插入
	 * 原理：首先要对链表进行判断，如果为空则设置尾结点为新添加的结点。
	 */
	public void insertFirst(long value) {
		Node node = new Node(value);
		if(first==null){
			last=node;
		}
		node.next = first;
		first = node;
	}
	/**
	 * 从尾部进行插入数据
	 * 原理：如果链表为空，则设置头节点为新添加的结点，否则就设置尾结点后一个结点为新
	 * 添加的结点。
	 */
	public void insertLast(long value){
		Node node = new Node(value);
		if(first==null){
			first=node;
		}else{
			last.next=node;
		}
		last =node;
	}
	
	/**
	 * 删除一个结点，在头结点后进行删除
	 * 原理：
	 * 如果判断头结点是否有下一个节点，如果没有设置，则返回null；
	 * 错误情况：
	 * 	但是这种方法不能比避免当头结点为null的时候，会出现空指针异常
	 *	修改：
	 *	首先判断链表是否为空，若为空返回null
	 */
	public Node deleteFirst() {
		if(!isEmpty()){
			Node tmp = first;
			if(first.next==null){
				last=null;
			}
			first = tmp.next;
			return tmp;
			}else{
				return null;
			}
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
