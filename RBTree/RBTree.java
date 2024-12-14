class RBTNode{
    char key;
    RBTNode right;
    RBTNode left;
    RBTNode parent;
    public Boolean isRed;
  
    public RBTNode(char key){
      this.key = key;
      this.isRed = true;
    }
    public void setLeft(RBTNode left) {
      this.left = left;
    }
    public void setRight(RBTNode right) {
      this.right = right;
    }
    public void setParent(RBTNode parent) {
      this.parent = parent;
    }
    public void setRed(Boolean isRed){
      this.isRed = isRed;
    }
  
    public RBTNode getRight() {
      return right;
    }
    public RBTNode getLeft() {
      return left;
    }
    public RBTNode getParent() {
      return parent;
    }
    public Boolean isRED(){
      return isRed;
    }
  
    public char getKey() {
        return key;
    }
  }
  
  class RBT{
    public RBTNode root;
  
    private RBTNode rotateLeft(RBTNode node){
      RBTNode temp = node.getRight();
      node.right = temp.left;
  
      if (temp.left != null) {
        temp.left.parent = node;
      }
      temp.parent = node.parent;
  
      if (node.parent == null) {
        root = temp;
      }
      else if (node == node.parent.left) {
        node.parent.left = temp;
      }
      else {
        node.parent.right = temp;
      }
      temp.left = node;
      node.parent = temp;
      return temp;
    }
  
    private RBTNode rotateRight(RBTNode node){
      RBTNode temp = node.getLeft();
      node.left = temp.right;
  
      if (temp.right != null) {
        temp.right.parent = node;
      }
      temp.parent = node.parent;
  
      if (node.parent == null) {
        root = temp;
      }
      else if (node == node.parent.right) {
        node.parent.right = temp;
      }
      else {
        node.parent.left = temp;
      }
      temp.right = node;
      node.parent = temp;
      return temp;
    }
  
    public void insert (char key){
      RBTNode newNode = new RBTNode(key);
      root = insertRec(root, newNode);
      fixUpInsert(newNode);
    }
  
    private RBTNode insertRec(RBTNode root, RBTNode node){
      if (root == null) {
        return node;
      }
      if (node.key < root.key) {
        root.left = insertRec(root.left, node);
        root.left.parent = root;
      }
      else if (node.key > root.key) {
        root.right = insertRec(root.right, node);
        root.right.parent = root;
      }
      return root;
    }
  
    private void fixUpInsert(RBTNode node){
      while (node != root && node.parent != null && node.parent.isRed!= null && node.parent.isRed){
        RBTNode parent = node.parent;
        RBTNode grandParent = parent.parent;
  
        if (grandParent == null)break;
  
        if (parent == grandParent.left) {
          RBTNode uncle = grandParent.right;
  
          if (uncle != null && uncle.isRed) {
            grandParent.isRed = true;
            parent.isRed = false;
            uncle.isRed = false;
            node = grandParent;
          }
          else {
            if (node == parent.right) {
              node = parent;
              rotateLeft(node);
            }
            parent.isRed = false;
            grandParent.isRed = true;
            rotateRight(grandParent);
          }
        }
        else{
          RBTNode uncle = grandParent.left;
  
          if (uncle != null && uncle.isRed) {
            grandParent.isRed = true;
            parent.isRed = false;
            uncle.isRed = false;
            node = grandParent;
          }
          else {
            if (node == parent.left) {
              node = parent;
              rotateRight(node);
            }
            parent.isRed = false;
            grandParent.isRed = true;
            rotateLeft(grandParent);
          }
        }
      }
      root.isRed = false;
    }
  
    public RBTNode search(char key){
      return searchRec(root, key);
    }
  
    private RBTNode searchRec(RBTNode node, char key){
      if (node == null || node.key == key) {
        return node;
      }
  
      if (key < node.key) {
        return searchRec(node.left, key);
      }
      else{
        return searchRec(node.right, key);
      }
    }
    
    public void inOrder(RBTNode node){
      if (node != null){
        inOrder(node.left);
        System.out.print(node.key + " ");
        inOrder(node.right);
      }
    }
  
    public void preorder(RBTNode node){
      if (node != null){
        System.out.print(node.key + " ");
        preorder(node.left);
        preorder(node.right);
      }
    }
  
    public void postorder (RBTNode node){
      if (node != null){
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.key + " ");
      }
    }
  
    public void printTree(){
      printTree(root,0);
    }
  
  private void printTree(RBTNode node, int level){
    if (node != null) {
        printTree(node.getRight(), level+1);
  
        String color = node.isRed ? "[R]" : "[B]";
        System.out.printf("%" +(level*4 +2) + "s%n" , node.getKey() + color);
        printTree(node.getLeft(), level+1);
      }
    }
  }
  
  public class RBTree {
    public static void main(String[] args) {
      RBT rbt = new RBT();
      char[] keys = {'1', '2', '5', '8', '9', '7', '0', '2', '6', '4'};
    
      System.out.println();
      System.out.println("Inserting Values To Red-Black-Tree");
      for (char key : keys) {
        System.out.print(key +" ");
        rbt.insert(key);
      }
      System.out.println();
    
      System.out.println("\nRed Black Tree Structure: ");
      rbt.printTree();
      System.out.println();
  
      System.out.println();
      System.out.println("\nPre-order Traversal: ");
      rbt.preorder(rbt.root);
      System.out.println("\nIn-Order Traversal: ");
      rbt.inOrder(rbt.root);
      System.out.println("\nPost-Order Traversal: ");
      rbt.postorder(rbt.root);
  
      
  
    }
  }