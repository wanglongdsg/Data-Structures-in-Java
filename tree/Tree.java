/**
 * 实现二叉树的结点的插入，遍历和删除
 * 
 * @author wanglong 2016-9-24 下午9:28:34
 */
public class Tree {
	// 根结点
	public Node root;

	/**
	 * 实现二叉树插入结点功能。
	 * 
	 * @param value 插入的id值
	 * @param nameData 插入的姓名数据
	 */
	public void insertNode(int value, String nameData) {
		// 封装结点
		Node newNode = new Node(value, nameData);
		// 声明父结点
		Node parent;
		// 当前结点
		Node current = root;

		if (root == null) {
			root = newNode;
		} else {
			while (true) {
				parent = current;
				if (current.idData > value) {
					current = current.leftNode;
					if (current == null) {
						parent.leftNode = newNode;
						return;
					}
				} else {
					current = current.rightNode;
					if (current == null) {
						parent.rightNode = newNode;
						return;
					}
				}
			}
		}
	}
	/**
	 * 查找结点
	 * @param value
	 * @return
	 */
	public Node find(int value){
		//将当前的结点作为跟结点
		Node current = root;
		while(current.idData != value){
			if(current.idData>value){
				current = current.leftNode;
			}else{
				current = current.rightNode;
			}
			if(current == null){
				return null;
			}
		}
		return current;
	}
	/**
	 * 删除结点
	 * 分三种情况
	 * 1.该结点是叶子结点，
	 * 没有子节点。要删除该结点，只需要改变该节点的父节点的引用值，将指向该节点的引用设置为null
	 * 2.该节点有一个子节点
	 * 改变父节点的引用，将其直接指向要删除的节点的子节点
	 * 3.该节点有两个子节点
	 * 要删除有两个子节点的结点，就需要使用它的中序后继来代替该结点（中序后继：就是先右边，然后一直左边，）
	 * @param value
	 * @return
	 */
	public boolean delete(int value){
		//将根结点作为当前结点
		Node current = root;
		//将根节点作为父结点
		Node parent = root;
		//判断是不是左结点
		boolean isLeftNode = false;
		while(current.idData != value){
			//当前结点的父节点
			parent = current;
			if(current.idData > value){
				current = current.leftNode;
				isLeftNode = true;
			}else{
				current = current.rightNode;
				isLeftNode = false;
			}
			if(current == null){
				return false;
			}
		}
		 //分为三种情况删除结点
		if(current.leftNode == null && current.rightNode == null){
			if(current == root){
				root = null;
			}else if(isLeftNode){
				parent.leftNode = null;
			}else{
				parent.rightNode = null;
			}
		}else if(current.leftNode == null){
			if(current == root){
				root = root.rightNode;
			}else if(isLeftNode){
				parent.leftNode = current.rightNode;
			}else {
				parent.rightNode = current.rightNode;
			}
		}else if(current.rightNode == null){
			if(current == root){
				root = root.leftNode;
			}else if(isLeftNode){
				parent.leftNode = current.leftNode;
			}else{
				parent.rightNode= current.leftNode;
			}
		}else{
			Node successor = getSuccessor(current);
			if(current == root){
				root = successor;
			}else if(isLeftNode){
				parent.leftNode = successor;
			}else {
				parent.rightNode = successor;
			}
			successor.leftNode = current.leftNode;
		}
		
		return true;
	}
	/**
	 * 找出替换delNode这个结点的结点（运用中序后继）
	 * @param delNode
	 * @return
	 */
	public Node getSuccessor(Node delNode){
		//替换的结点
		Node successor = delNode;
		//替换结点的父结点
		Node successorParent =delNode;
		//当前结点
		Node current = delNode.rightNode;
		while(current != null){
			successorParent = successor;
			successor = current;
			current = current.leftNode;
		}
		if(successor != delNode.rightNode){
			successorParent.leftNode = null;
			successor.rightNode = delNode.rightNode;
		}
		return successor;
	}
	/**
	 * 前序遍历
	 * 原理：
	 * 1.访问根结点
	 * 2.前序遍历左子树
	 * 3.前序比遍历右子树
	 * @param localNode 二叉树的根结点
	 */
	public void frontOrder(Node localNode){
		if(localNode!=null){
			//1.访问根结点
			System.out.println(localNode.idData+" "+localNode.nameData);
			//2.前序遍历左子树
			frontOrder(localNode.leftNode);
			//3.3.前序比遍历右子树
			frontOrder(localNode.rightNode);
		}
	}
	/**
	 * 中序遍历
	 *  原理：
	 *  1.中序遍历左子树
	 *  2.访问根结点
	 *  3.中序比遍历右子树
	 * @param localNode
	 */
	public void inOrder(Node localNode){
		if(localNode!=null){
			// 1.中序遍历左子树
			inOrder(localNode.leftNode);
			//2.访问根结点
			System.out.println(localNode.idData+" "+localNode.nameData);
			// 3.中序比遍历右子树
			inOrder(localNode.rightNode);
		}
	}
	/**
	 * 后序遍历
	 * 原理：
	 * 1.后序遍历左子树
	 * 2.后序遍历右子树
	 * 3.访问根结点
	 * @param localNode
	 */
	public void afterOrder(Node localNode){
		if(localNode != null){
			//1.后序遍历左子树
			afterOrder(localNode.leftNode);
			//2.后序遍历右子树
			afterOrder(localNode.rightNode);
			// 3.访问根结点
			System.out.println(localNode.idData+" "+localNode.nameData);
		}
	}
}
