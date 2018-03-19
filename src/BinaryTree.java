import java.util.Iterator;
/**
 * @author Marcos Gutierrez				17909
 * @author Raul Monzon					17014
 * Clase que implementa el BinaryTree
 */
public class BinaryTree<E>{
	protected E val; /*value associated with node*/
	protected BinaryTree<E> parent; /*parent of node*/
	protected BinaryTree<E> left, right; /*children of node*/
	
	/*post: constructor that generates an empty node */
	public BinaryTree() {
		val = null;
		parent = null;
		left = right = this;
	}
	
	/*post: return a tree referencing value and two empty subtrees*/
	public BinaryTree(E value) {
		val = value;
		right = left = new BinaryTree<E>();
		setLeft(left);
		setRight(right);
	}
	
	/*post: return a tree referencing value and two subtrees*/
	public BinaryTree(E value, BinaryTree<E> left, BinaryTree<E> right) {
		val = value;
		if(left == null) {left = new BinaryTree<E>();}
		setLeft(left);
		if(right == null) { right = new BinaryTree<E>(); }
		setRight(right);
	}
	
	/*post: returns reference to (possibly empty) left subtree*/
	public BinaryTree<E> left(){
		return left;
	}
	
	/*post: returns reference to parent node, or null*/
	public BinaryTree<E> parent(){
		return parent;
	}
	
	/*post: sets left subtree to newLeft*/
	/*re-parents newLeftT if not null*/
	public void setLeft(BinaryTree<E> newLeft) {
		if(isEmpty()) return;
		if(left != null && left.parent() == this) left.setParent(null);
		left = newLeft;
		newLeft.setParent(this);
	}
	
	/*post: sets left subtree to newRight*/
	/*re-parents newRight if not null*/
	public void setRight(BinaryTree<E> newRight) {
		if(isEmpty()) return;
		if(right != null && right.parent == this) right.setParent(null);
		right = newRight;
		newRight.setParent(this);
	}
	
	/*post: re-parents this node to parent reference, or null*/
	protected void setParent(BinaryTree<E> newParent) {
		if(isEmpty()) {
			parent = newParent;
		}
	}
	
	/*post: return an in-order iterator of elements*/
	public Iterator<E> iterator() { return null;}
	
	/*post: return true if this is a left child of parents*/
	public boolean isLeftChild() {
		if(parent != null) {
			BinaryTree<E> left = parent.left();
			return this == left;
		}
		return false;
	}
	
	/*post: return value associated with this node*/
	public E value() {
		return val;
	}
	
	/*post: sets te value associated with this node*/
	public void setValue(E value) {
		val = value;
	}
	
	/*post: if node is empty*/
	protected boolean isEmpty() {
		return val == null;
	}
}
