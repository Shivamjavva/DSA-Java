package TREE.binarysearchtree;

import java.util.ArrayList;

public class binarytree {
 static class Node {
  int data;
  Node left;
  Node right;

  public Node(int data) {
   this.data = data;

  }
 }

  public static Node insert(Node root, int value) {
   if (root == null) {
    root = new Node(value);
    return root;
   }
   if (root.data > value) {
    root.left = insert(root.left, value);
   } else {
    root.right = insert(root.right, value);
   }
   return root;
  }

 public static void inorder(Node root){
  if(root==null){
   return ;
  }
  inorder(root.left);
  System.out.println(root.data);
  inorder(root.right);
 }
 public static boolean searchkey(Node root,int key){
  if(root==null){
   return false;
  }
  if(root.data>key){
   return searchkey(root.left,key);
  }
  else if( root.data==key){
   return true;
  }
  else {
   return searchkey(root.right,key);
  }
 }
 public static Node delete(Node root,int val){
  if(root.data>val){
   root.left=delete(root.left,val);

  }
  else if(root.data<val){
   root.right=delete(root.right,val);
  }
  else{
   // case 1 leaf node
   if(root.left==null&&root.right==null){
    return null;
   }
   //  case 2
   if(root.left==null){
    return root.right;
   } else if (root.right==null) {
    return root.left;
   }
   // case 3
   Node Is=inorderSuccesor(root.right);
   root.data=Is.data;
   root.right=delete(root.right,Is.data);
  }
  return root;
 }
 public static Node inorderSuccesor(Node root){
  while(root.left!=null){
   root=root.left;
  }
  return root;
 }
 public static void printinrange(Node root,int x,int y){
  if(root==null){
   return;
  }
  if(root.data>=x && root.data<=y){
   printinrange(root.left,x,y);
   System.out.println(root.data+"");
   printinrange(root.right,x,y);

  }
  else if(root.data>=y){
   printinrange(root.left,x,y);
  }
  else{
   printinrange(root.right,x,y);
  }
 }
 public static void printpath(ArrayList<Integer> path){
  for(int i=0;i< path.size();i++){
   System.out.println(path.get(i)+"->");
  }
 }
 public static void printroot2leaf(Node root, ArrayList<Integer> path){
  if(root==null){
   return;
  }
  if(root.left==null && root.right==null){
   printpath(path);
  }
  else{
   printroot2leaf(root.left,path);
   printroot2leaf(root.right,path);
  }
  path.add(root.data);

  path.remove(path.size()-1);
 }

 public static void main(String[] args) {
   int values[] = {5, 1, 3, 4, 2, 7};
   Node root = null;
   for (int i = 0; i < values.length; i++) {
    root = insert(root, values[i]);
   }
    inorder(root);
    System.out.println();
    if(searchkey(root,3)){
     System.out.println("found");
    }
    else{
     System.out.println("not found");
    }
   }
  }



// seraching in binary search tree O(h) h is height of tree
// h=log n
// inorder transversal of bst gives a sorted sequence
