package Assignment_algo.DAA;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.List;

public class Cource {
    int courceId;
    Date date;
    LocalTime time;
    List<Integer> enrolledStudents;

    Cource(){}


    Cource(int courceId, Date date, LocalTime time ,List<Integer> enrolledStudents) throws ParseException {

        this.courceId = courceId;
        this.date = date;
        this.time = time;
        this.enrolledStudents = enrolledStudents;
    }
}

class Node {
    Cource key;
    int height;
    Node left, right;

    Node(Cource key) {
        this.key = key;
        this.height = 1;
    }
}

class AVLTree {
    Node root;

    AVLTree() {
    }

    // Get the height of a node
    int height(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    // Get the balance factor of a node
    int getBalance(Node node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    // Right rotate a subtree rooted with y
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // Left rotate a subtree rooted with x
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Insert a key into the AVL tree
    Node insert(Node root, Cource key) {
        if (root == null)
            return new Node(key);

        if (key.courceId < root.key.courceId)
            root.left = insert(root.left, key);
        else if (key.courceId > root.key.courceId)
            root.right = insert(root.right, key);
        else // Duplicate keys are not allowed
            return root;

        // Update height of this ancestor node
        root.height = 1 + Math.max(height(root.left), height(root.right));

        // Get the balance factor
        int balance = getBalance(root);

        // Perform rotations if necessary
        if (balance > 1 && key.courceId < root.left.key.courceId)
            return rightRotate(root);

        if (balance < -1 && key.courceId > root.right.key.courceId)
            return leftRotate(root);

        if (balance > 1 && key.courceId > root.left.key.courceId) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (balance < -1 && key.courceId < root.right.key.courceId) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    Timing getTiming(int courceId, Node node){
        if(node == null) return null;

       if(node.key.courceId == courceId){
             Timing obj = new Timing();
             obj.date = node.key.date;
             obj.time = node.key.time;
             return obj;
       }  // if the cource id is > root id we search the right tree 
       else if(node.key.courceId > courceId){
        return getTiming(courceId,node.left);

       }
       else{
        return getTiming(courceId, node.right);
       }
        
    }

    // Print the AVL tree in-order
    void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.key.courceId + " ");
            inOrderTraversal(node.right);
        }
    }

    boolean isExists(Node node, int courceId,int studentid) {
        if(node == null) return false;

       if(node.key.courceId == courceId){
             System.out.println("Exists");

             

            // node.key.enrolledStudents.add(studentid, null);
             return true;
       }  // if the cource id is > root id we search the right tree 
       else if(node.key.courceId > courceId){
        return isExists(node.left, courceId,studentid);

       }
       else{
        return isExists(node.right, courceId,studentid);
       }
    }

    public static void main(String[] args) throws ParseException {
         AVLTree tree = new AVLTree();

        // Insert some keys into the tree
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        Date d = date.parse("2023-09-28");
        LocalTime time = LocalTime.of(7, 30, 0);
        System.out.println(time);
        tree.root = tree.insert(tree.root, new Cource(100, d,time, null));
        tree.root = tree.insert(tree.root, new Cource(102, d,time, null));
        tree.root = tree.insert(tree.root, new Cource(103, d,time, null));
        tree.root = tree.insert(tree.root, new Cource(105, d,time, null));


        // Print the tree in-order
        tree.inOrderTraversal(tree.root);
        // res = false;
        // boolean res1 =  tree.isCource(courceId);
        // boolean res = tree.isExists(tree.root, 104, );
        // System.out.println(res);
    }

    public  boolean isCource(int courceId,int studentid){
        AVLTree obj = new AVLTree();
        boolean  result =  obj.isExists(obj.root, courceId,studentid);
        return result;
        
    }

    Timing isTiming(int courceId){
        AVLTree obj = new AVLTree();
        Timing data = obj.getTiming(courceId, obj.root);
        return data;
    }
}
