package MedicalSoftware;

public class AVL<K extends Comparable<K>, V> {
	private BSTNode<K, V> root;

	public AVL() {
		root = null;
	}

	@SuppressWarnings({ "unchecked" })
	public AVL(K key, V value) {
		root = new BSTNode(key, value);
	}

	public void setRoot(BSTNode<K, V> root) {
		this.root = root;
	}

	public BSTNode<K, V> getRoot() {
		return root;
	}

	/**
	 * preorder transverses the tree in descending order starting from the root.
	 * 
	 * @return returns a string of every key in the tree.
	 */
	public String preorder() {
		return preorder(root, "");
	}

	/**
	 * preorder is a helper method of another method of the same name, this
	 * method actually doing the transversing.
	 * 
	 * @param t
	 *            is the node passed to start the transversal.
	 * @param s
	 *            is the collective string of keys.
	 * @return returns the string of every key in the tree in preorder.
	 */
	private String preorder(BSTNode<K, V> t, String s) {
		if (t != null) {
			s = s + t.toString();
			s = preorder(t.getLeft(), s);
			s = preorder(t.getRight(), s);
		}

		return s;
	}

	/**
	 * postorder transverses the tree in ascending order
	 * 
	 * @return returns the string of every key in the tree in postorder
	 */
	public String postorder() {
		return postorder(root, "");
	}

	/**
	 * postorder is a helper method of another mehtod of the same name, this
	 * method actually doing the transversing.
	 * 
	 * @param t
	 *            is the node passed to start the transversal.
	 * @param s
	 *            is the collective string of keys.
	 * @return returns the string of every key in the tree in postorder.
	 */
	private String postorder(BSTNode<K, V> t, String s) {
		if (t != null) {
			s = postorder(t.getLeft(), s);
			s = postorder(t.getRight(), s);
			s = s + t.toString();
		}

		return s;
	}

	/**
	 * inorder transverses the tree in a left node then root then right.
	 * 
	 * @return returns the string of every key in the tree in inorder
	 */
	public String inorder() {
		return inorder(root, "");
	}

	/**
	 * inorder is a helper method of another mehtod of the same name, this
	 * method actually doing the transversing.
	 * 
	 * @param t
	 *            is the node passed to start the transversal.
	 * @param s
	 *            is the collective string of keys.
	 * @return returns the string of every key in the tree in inorder.
	 */
	private String inorder(BSTNode<K, V> t, String s) {
		if (t != null) {
			s = inorder(t.getLeft(), s);
			s = s + t.toString();
			s = inorder(t.getRight(), s);
		}

		return s;
	}

	/**
	 * insert creates a new node and places it in the tree to a specified
	 * location determined by the key.
	 * 
	 * @param key
	 *            is the key value of the node that will be created.
	 * @param value
	 *            is the data stored in the newly created node.
	 */
	public void insert(K key, V value) {
		root = insert(root, key, value);
	}

	/**
	 * insert is the helper method for another method of the same name that
	 * actually creates and places the node in the tree recursively
	 * 
	 * @param t
	 *            is the root of the tree
	 * @param key
	 *            is the key value of the node that will be created.
	 * @param value
	 *            is the data stored in the newly created node.
	 */
	private BSTNode<K, V> insert(BSTNode<K, V> t, K key, V value) {
		if (t == null)
			t = new BSTNode<K, V>(key, value);
		else if (t.getKey().compareTo(key) > 0)
			t.setLeft(insert(t.getLeft(), key, value));
		else
			t.setRight(insert(t.getRight(), key, value));

		calcHeightAndBF(t);
		t = avlRotate(t);
		calcHeightAndBF(t);
		return t;
	}

	/**
	 * remove finds a node in the tree that has the same key and then removes
	 * it.
	 * 
	 * @param key
	 *            is the key value of the node that is to be removed
	 */
	public void remove(K key) {
		root = remove(root, key);
	}

	/**
	 * remove is the helper method for another method of the same name that
	 * actually does the removing.
	 * 
	 * @param t
	 *            is the node that is to start the searching from
	 * @param key
	 *            is the key value of the node being removed
	 * @return returns the new tree that is lacking the removed node
	 */
	private BSTNode<K, V> remove(BSTNode<K, V> t, K key) {
		if (t == null)
			return null;
		else if (t.getKey().compareTo(key) > 0)
			t.setLeft(remove(t.getLeft(), key));
		else if (t.getKey().compareTo(key) < 0)
			t.setRight(remove(t.getRight(), key));
		else {
			if (t.getRight() != null) {
				if (t.getLeft() != null) {
					BSTNode<K, V> succ = getSucc(t);

					K tempk = t.getKey();
					V tempv = t.getValue();

					t.setKey(succ.getKey());
					t.setValue(succ.getValue());

					succ.setKey(tempk);
					succ.setValue(tempv);

					t.setRight(remove(t.getRight(), key));
				} else
					t = t.getRight();
			} else
				t = t.getLeft();
		}

		calcHeightAndBF(t);
		t = avlRotate(t);
		calcHeightAndBF(t);
		return t;
	}

	/**
	 * getSucc accepts a node and then finds the next largest node
	 * 
	 * @param t
	 *            is the node passed in to determine what is the next greatest
	 *            node
	 * @return returns the successor of the node passed
	 */
	public BSTNode<K, V> getSucc(BSTNode<K, V> t) {
		t = t.getRight();

		while (t.getLeft() != null)
			t = t.getLeft();

		return t;
	}

	/**
	 * calcHeightAndBF determines the height and the balance factor of the node
	 * passed into the function
	 * 
	 * @param t
	 *            is the node that the height and balance factor are determined
	 */
	public void calcHeightAndBF(BSTNode<K, V> t) {
		// TO DO
		int BF = 0, height = 0;
		if (t == null) {
			return;
		}
		if (t.getLeft() != null) {
			calcHeightAndBF(t.getLeft());
			height = t.getLeft().getHeight() + 1;
			BF = BF + height;
		}
		if (t.getRight() != null) {
			calcHeightAndBF(t.getRight());
			if ((t.getRight().getHeight() + 1) >= height) {
				height = t.getRight().getHeight() + 1;
			}
			BF = BF - (t.getRight().getHeight() + 1);
		}
		t.setBF(BF);
		t.setHeight(height);
		return;
	}

	/**
	 * avlRotate determines if the node passed in needs to be rotated either to
	 * the left, or to the right, or twice to the left, or twice to the right.
	 * 
	 * @param t
	 *            is the node passed in to be determined if it needs to be
	 *            rotated
	 * @return returns the new node which was rotated
	 */
	public BSTNode<K, V> avlRotate(BSTNode<K, V> t) {
		// TO DO
		if (t == null) {
			return t;
		}
		if (t.getBF() == 2 && t.getLeft().getBF() > 0) {
			t = leftleft(t);
		}
		if (t.getBF() == 2 && t.getLeft().getBF() < 0) {
			t = leftright(t);
		}
		if (t.getBF() == -2 && t.getRight().getBF() < 0) {
			t = rightright(t);
		}
		if (t.getBF() == -2 && t.getRight().getBF() > 0) {
			t = rightleft(t);
		}
		return t;
	}

	/**
	 * leftleft performs a single left rotation
	 * 
	 * @param t
	 *            is the node passed in to be rotated
	 * @return returns the new node that was rotated into the position
	 */
	public BSTNode<K, V> leftleft(BSTNode<K, V> t) {
		// TO DO
		BSTNode<K, V> temp = t;
		t = t.getLeft();
		if (t.getRight() != null) {
			temp.setLeft(t.getRight());
		} else {
			temp.setLeft(null);
		}
		t.setRight(temp);
		calcHeightAndBF(t);
		return t;
	}

	/**
	 * rightright performs a single right rotation
	 * 
	 * @param t
	 *            is the node passed in to be rotated
	 * @return returns the new node that was rotated into the position
	 */
	public BSTNode<K, V> rightright(BSTNode<K, V> t) {
		// TO DO
		BSTNode<K, V> temp = t;
		t = t.getRight();
		if (t.getLeft() != null) {
			temp.setRight(t.getLeft());
		} else {
			temp.setRight(null);
		}
		t.setLeft(temp);
		calcHeightAndBF(t);
		return t;
	}

	/**
	 * leftright performs a double left rotation
	 * 
	 * @param t
	 *            is the node passed in to be rotated
	 * @return returns the new node that was rotated into the position
	 */
	public BSTNode<K, V> leftright(BSTNode<K, V> t) {
		// TO DO
		t.setLeft(rightright(t.getLeft()));
		return leftleft(t);

	}

	/**
	 * rightleft performs a double right rotation
	 * 
	 * @param t
	 *            is the node passed in to be rotated
	 * @return returns the new node that was rotated into the position
	 */
	public BSTNode<K, V> rightleft(BSTNode<K, V> t) {
		// TO DO
		t.setRight(leftleft(t.getRight()));
		return rightright(t);
	}

	/**
	 * find searches the tree for a specified node and then returns it
	 * 
	 * @param t
	 *            is the node that is being searched for in the tree
	 * @return returns the specified node
	 */
	public V find(K key) {
		return find(root, key);
	}

	/**
	 * find is the helper method for another method of the same name that
	 * actually searches the tree for the specified node recursively
	 * 
	 * @param key
	 *            is the key value being searched for in the tree
	 * @return returns the specified node
	 */
	private V find(BSTNode<K, V> t, K key) {
		if (t == null)
			return null;
		else if (t.getKey().compareTo(key) > 0)
			return find(t.getLeft(), key);
		else if (t.getKey().compareTo(key) < 0)
			return find(t.getRight(), key);
		else
			return t.getValue();
	}
}
