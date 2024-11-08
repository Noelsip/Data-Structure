package BSTree;

class BSTNode {
    int data;
    BSTNode left;
    BSTNode right;

    public BSTNode() {
        left = null;
        right = null;
        data = 0;
    }

    public BSTNode(int n) {
        data = n;
        left = null;
        right = null;
    }

    public void setLeft(BSTNode n) {
        this.left = n;
    }

    public void setRight(BSTNode n) {
        this.right = n;
    }

    public void setData(int d) {
        data = d;
    }

    public BSTNode getLeft() {
        return left;
    }

    public BSTNode getRight() {
        return right;
    }

    public int getData() {
        return data;
    }
}

class BST {
    private BSTNode root;

    public BST() {
        root = null;
    }

    public Boolean isEmpty() {
        return root == null;
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private BSTNode insert(BSTNode node, int data) {
        if (node == null) {
            node = new BSTNode(data);
        } else {
            if (data <= node.getData()) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
        }
        return node;
    }

    public int findMin(){
        if (root == null) {
            throw new IllegalStateException("Tree is Empty");
        }
        BSTNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.getData();
    }

    public int findMax(){
        if (root == null) {
            throw new IllegalStateException("Tree is Empty");
        }
        BSTNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.getData();
    }

    public int getHeight(){
        return getHeight(root);
    }

    private int getHeight(BSTNode node){
        if (node == null) {
            return -1;
        }
        else{
            int leftHeight = getHeight(node.getLeft());
            int rightHeight = getHeight(node.getRight());
            return Math.max(leftHeight, rightHeight) +1;
        }
    }

    public int getSize(){
        return getSize(root);
    }

    private int getSize(BSTNode node){
        if (node == null) {
            return 0;
        }
        else{
            return 1 + getSize(node.getLeft()) + getSize(node.getRight());
        }
    }

    public void delete(int k) {
        if (isEmpty()) {
            System.out.println("Tree Empty");
        } else if (!search(k)) {
            System.out.println("Sorry, " + k + " is not present in the tree");
        } else {
            root = delete(root, k);
            System.out.println(k + " deleted from tree");
        }
    }

    private BSTNode delete(BSTNode root, int k) {
        if (root == null) {
            return null;
        }

        BSTNode p, p2, n;

        if (root.getData() == k) {
            BSTNode left = root.getLeft();
            BSTNode right = root.getRight();

            if (left == null && right == null) {
                return null;
            } else if (left == null) {
                p = right;
            } else if (right == null) {
                p = left;
            } else {
                p2 = right;
                p = right;
                while (p.getLeft() != null) {
                    p = p.getLeft();
                }
                p.setLeft(left);
                return p2;
            }
        }
        if (k < root.getData()) {
            n = delete(root.getLeft(), k);
            root.setLeft(n);
        } else {
            n = delete(root.getRight(), k);
            root.setRight(n);
        }
        return root;
    }

    public boolean search(int val) {
        BSTNode current = root;
        while (current != null) {
            if (val < current.getData()) {
                current = current.getLeft();
            } else if (val > current.getData()) {
                current = current.getRight();
            } else {
                System.out.println(val + " found in the tree.");
                return true;
            }
        }
        System.out.println(val + " not found in the tree.");
        return false;
    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(BSTNode root) {
        if (root != null) {
            inorder(root.getLeft());
            System.out.print(root.getData() + " ");
            inorder(root.getRight());
        }
    }

    public void preorder() {
        preorder(root);
    }

    private void preorder(BSTNode root) {
        if (root != null) {
            System.out.print(root.getData() + " ");
            preorder(root.getLeft());
            preorder(root.getRight());
        }
    }

    public void postorder() {
        postorder(root);
    }

    private void postorder(BSTNode root) {
        if (root != null) {
            postorder(root.getLeft());
            postorder(root.getRight());
            System.out.print(root.getData() + " ");
        }
    }

    public void printTree(){
        printTree(root,0);
    }

    private void printTree(BSTNode node, int level){
        if (node != null) {
            printTree(node.getRight(), level+1);
            System.out.printf("%" +(level*4 +2) + "s%n" , node.getData());
            printTree(node.getLeft(), level+1);
        }
    }
}

public class BinarySearchTree {
    public static void main(String[] args) {
        BST bst = new BST();

        System.out.println();
        System.out.println("Inserting Value into BST");
        int[] values = {55, 10, 54, 22, 44, 23, 78, 8, 9, 10};
        for (int value : values) {
            System.out.print(value + " ");
            bst.insert(value);
        }
        System.out.println();

        System.out.println();
        System.out.println("Binary Search Tree Structure");
        bst.printTree();
        System.out.println();

        System.out.println("\nMinimum Value in the tree: " + bst.findMin());
        System.out.println("Maximum Value in the tree: " + bst.findMax());
        System.out.println("Height of the Tree: " + bst.getHeight());
        System.out.println("Size of the Tree: " + bst.getSize());

        System.out.println();
        System.out.println("\nInorder traversal:");
        bst.inorder();
        System.out.println("\nPre-order traversal: ");
        bst.preorder();
        System.out.println("\nPost-order traversal: ");
        bst.postorder();
        System.out.println();

        // search and delete
        int searchValue = 10;
        int deleteValue = 22;

        System.out.println("\nSearching for " + searchValue + ":");
        bst.search(searchValue);
        System.out.println("\nDeleting " + deleteValue + ":");
        bst.delete(deleteValue);

        // traversal after delete
        System.out.println("\nInorder traversal after delete:");
        bst.inorder();
        System.out.println("\nPre-order traversal after deletion");
        bst.preorder();
        System.out.println("\nPost-order traversal after deletion");
        bst.postorder();
        System.out.println();

    }
}
