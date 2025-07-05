package TREES;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Binarytree {
    
    static class Node{

        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    static class BT{

        static int idx = -1;
        public static Node buildTree( int nodes[] ){
            idx++;
            if( nodes[idx]==-1 )
                return null;
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        public static void preorder(Node root){
            if( root==null ){
                System.out.print(-1+" ");
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
            return;
        }
        public static void inorder(Node root){
            if( root==null ){
                System.out.print(-1+" ");
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
            return;
        }
        public static void postorder(Node root){
            if( root==null ){
                System.out.print(-1+" ");
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
            return;
        }

        public static void levelorder(Node root){

            // Queue<Node> queue = new LinkedList<>();
            // queue.add(root);
            // queue.add(null);
            // while( !queue.isEmpty() ){
            //     Node player = queue.remove();
            //     if( player==null){
            //         System.out.println();
            //         if( queue.isEmpty() ){
            //             break;
            //         }
            //         else{
            //             queue.add(null);
            //         }
            //     }
            //     else{
            //         System.out.print(player.data+" ");
            //         if( player.left!=null ){
            //             queue.add(player.left);
            //         }
            //         if( player.right!=null ){
            //             queue.add(player.right);
            //         }
            //     }
            // }
            
            if( root==null )
                return;
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            queue.add(null);
            while( !queue.isEmpty() ){
                if( queue.peek()==null){
                    System.out.println();
                    queue.remove();
                    if( queue.isEmpty() ){
                        break;
                    }
                    else{
                        queue.add(null);
                    }
                }
                else{
                    Node player = queue.remove();
                    System.out.print(player.data+" ");
                    if( player.left!=null ){
                        queue.add(player.left);
                    }
                    if( player.right!=null ){
                        queue.add(player.right);
                    }
                }
            }
        }

        
        public static int countOfNodes(Node root){
            if( root==null )
            return 0;
            int leftNodes = countOfNodes(root.left);
            int rightNodes = countOfNodes(root.right);
            return leftNodes + rightNodes +1;
        }
        
        public static int sumOfNodes(Node root){
            if( root==null )
            return 0;
            int leftNodes = sumOfNodes(root.left);
            int rightNodes = sumOfNodes(root.right);
            return leftNodes + rightNodes + root.data;
        }
        
        public static int height(Node root){
            if( root==null )
                return 0;
            int leftHight = height(root.left);
            int rightHight = height(root.right);
            return Math.max(leftHight, rightHight) + 1;
        }
        public static int diameter(Node root) {
            
            if( root==null )
                return 0;
            int diam1 = diameter(root.left);
            int diam2 = diameter(root.right);
            int diam3 = height(root.left) + height(root.right) + 1;

            return Math.max(diam3, Math.max(diam2, diam1));
        }

        static class TreeInfo{
            
            int ht;
            int diam;

            TreeInfo(int ht, int diam){
                this.ht = ht;
                this.diam = diam;
            }
        }

        public static TreeInfo nDiameter(Node root) {
            if( root==null )
                return new TreeInfo(0, 0);
            
            TreeInfo left = nDiameter(root.left);
            TreeInfo right = nDiameter(root.right);

            int myHeight = Math.max(left.ht, right.ht) + 1;

            int diam1 = left.diam;
            int diam2 = right.diam;
            int diam3 = left.ht + right.ht + 1;
            int myDiam = Math.max(diam3, Math.max(diam2, diam1));

            TreeInfo myInfo = new TreeInfo(myHeight, myDiam);

            return myInfo;
        }

    }
    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BT tree = new BT();
    
        Node root = tree.buildTree(nodes);
        // System.out.println(root.data);
        // tree.preorder(root);
        // System.out.println();
        // tree.inorder(root);
        // System.out.println();
        // tree.postorder(root);
        // tree.levelorder(root);
        // System.out.println(tree.height(root));
        // System.out.println(tree.countOfNodes(root));
        // System.out.println(tree.sumOfNodes(root));
        // System.out.println(tree.diameter(root));
        System.out.println(tree.nDiameter(root).diam);
    }
}
