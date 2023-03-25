import java.util.*;


public class BINARY_SEARCH_TREE {
        static class Tree{
            Node root;
        }


        static Tree T = new Tree();



        static class Node{
            String key;
            int value;
            Node parent;
            Node leftChild;
            Node rightChild;


            Node(String key, int value){
                this.key = key;
                this.value = value;
            }

        }



        public static void main(String[] args) {

            TREE_INSERT("houses", 5);
            TREE_INSERT("offices", 10);
            TREE_INSERT("beaches", 15);

            System.out.print("{ \n");
            INORDER_TREE_WALK(T.root);
            System.out.print("} \n");

//             SEARCH_TREE("beaches");
        }




   /*
  ====================================================================
  Logic to Insert nodes in dictionary with key/value pair parameters
  ====================================================================
  */

        public static void TREE_INSERT( String key, int value) {
            Node z = new Node(key, value);

            Node y = null;
            Node x = T.root;
            while(x != null){
                y = x;
                if(z.key.compareTo(x.key) < 0 ){
                    x = x.leftChild;

                }
                else{
                    x = x.rightChild;
                }
            }
            z.parent = y;
            if(y == null){
                T.root = z;
            }else if(z.key.compareTo(y.key) < 0){
                y.leftChild = z;
            }
            else{
                y.rightChild = z;
            }
        }


        public static void INORDER_TREE_WALK(Node x){
            if(x != null) {
                INORDER_TREE_WALK(x.leftChild);
                System.out.print(x.key + " : " + x.value +",\n");
                INORDER_TREE_WALK(x.rightChild);
            }
        }




  /*
  ====================================================================
          Logic to traverse tree using keys
  ====================================================================
  */

        public static void SEARCH_TREE(String key){
            Node temp = T.root;

            if(temp == null) System.out.print("...tree is empty");
            while(temp != null){
                if(temp.key.compareTo(key) == 0){
                    System.out.print("...node found\n");
                    System.out.print("{");
                    System.out.print( temp.key + ":" + temp.value);
                    System.out.print("}");
                    return;
                }
                if(key.compareTo(temp.key) > 0){
                    if(temp.rightChild != null){
                        temp = temp.rightChild;
                    }else{
                        System.out.print("Node does not exist in dictionary");
                        temp = null;
                    }
                }else if(key.compareTo(temp.key) < 0){
                    if(temp.leftChild != null){
                        temp = temp.leftChild;
                    }else{
                        System.out.print("Node does not exist in dictionary");
                        temp = null;
                    }
                }
            }
        }


}
