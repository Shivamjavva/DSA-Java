package TREE;
import java.util.*;
public class binarytree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class binarytreed {
        static int idx = -1;

        public static Node buildnodes(int[] nodes) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildnodes(nodes);
            newNode.right = buildnodes(nodes);
            return newNode;
        }
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data + "");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    public static void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }

    public static void levelorder(Node root) {
        Queue<Node> g = new LinkedList<>();
        g.add(root);
        g.add(null);
        while (!g.isEmpty()) {
            Node currnode = g.remove();
            if (currnode == null) {
                System.out.println();
                if (g.isEmpty()) {
                    break;
                } else {
                    g.add(null);
                }
            } else {
                System.out.println(currnode.data + "");
                if (currnode.left == null) {
                    g.add(currnode.left);
                }
                if (currnode.right == null) {
                    g.add(currnode.right);
                }
            }
        }
    }
    public static int countofNodes(Node root){
        if(root==null){
            return 0;
        }
        int leftNodes=countofNodes(root.left);
        int rightNodes=countofNodes(root.right);
        return leftNodes+rightNodes+1;

    }
    public static int sumofNodes(Node root){
        if(root==null){
            return 0;
        }
        int leftSum=sumofNodes(root.left);
        int rightSum=sumofNodes(root.right);
         return leftSum+rightSum+root.data;
    }




    public static void main(String[] args) {
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        binarytreed t=new binarytreed();

       Node root= t.buildnodes(nodes);
        System.out.println(root.data);
        //preorder(root);
        postorder(root);
        System.out.println(sumofNodes(root));

    }
}
// preorder root left right subtree
//inorfer left root right
// post orderleft right root
// time complexity for level 0rfer transveral is O(n)