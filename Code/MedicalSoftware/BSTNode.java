package MedicalSoftware;

public class BSTNode<K extends Comparable<K>,V>
{
	private K key;
	private V value;
	private BSTNode<K,V> left;
	private BSTNode<K,V> right;
	private int bf;
	private int height;
	
	public BSTNode(K key, V value)
	{
		this.key = key;
		this.value = value;
		this.height = 0;
	}
	
	public K getKey()
	{
		return key;
	}
	
	public void setKey(K key)
	{
		this.key = key;
	}
	
	public V getValue()
	{
		return value;
	}
	
	public void setValue(V value)
	{
		this.value = value;
	}
	
	public BSTNode<K,V> getLeft()
	{
		return left;
	}
	
	public void setLeft(BSTNode<K,V> left)
	{
		this.left = left;
	}
	
	public BSTNode<K,V> getRight()
	{
		return right;
	}
	
	public void setRight(BSTNode<K,V> right)
	{
		this.right = right;
	}
	
	public String toString()
	{
		return key.toString() + " ";
	}
	
	public int getBF()
	{
		return bf;
	}
	
	public void setBF(int bf)
	{
		this.bf = bf;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public void setHeight(int height)
	{
		this.height = height;
	}
}
