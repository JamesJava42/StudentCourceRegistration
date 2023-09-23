package Assignment_algo.DAA;

import java.util.ArrayList;
import java.util.List;





public class TreeNode<T> {

    T data;
    List<TreeNode<T>> children;

    public TreeNode(T data){
        this.data = data;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode<T>  child){
        System.out.println("Child added : "+child.data);
        children.add( child);
        
    }
    public static void main(String[] args) {

        
    }

}

