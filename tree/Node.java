/**
 * 树的结点
 * @author wanglong
 * 2016-9-24 下午9:23:33
 */
public class Node {
	/**
	 * 结点携带的数据：
	 * idData:代表编号
	 * nameData:代表姓名数据
	 */
	public int idData;
	public String nameData;
	
	//左右子树
	public Node leftNode;
	public Node rightNode;
	
	public Node(int idData , String nameData) {
		this.idData = idData;
		this.nameData = nameData;
	}
}
