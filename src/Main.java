public class Main {

    public static void main(String[] args) {
	// write your code here
//        System.out.println("Please Enter A full line of text");
////        Scanner scanner = new Scanner(System.in);
////        String input = scanner.nextLine();
////        String[] inputs = input.split("\\s+");
//        Tree<Integer> tree = new Tree<>();
////        for (int i = 0 ; i<inputs.length ; i++)
////            tree.insertNode(inputs[i]);
////
////        System.out.println("post order\n");
////        tree.postOrdertraversal(tree.getRoot());
////        System.out.println("\npre order\n");
////        tree.preOrderTraversal(tree.getRoot());
//        tree.insertNode(555);
//        tree.insertNode(3);
//        tree.insertNode(4);
//        tree.insertNode(6);
//
//
////        System.out.println(tree.getRoot().data);
//
//        System.out.println(tree.getDepth(tree.getRoot()));


//        List<Integer> list = new List<Integer>(4);
//        list.insertfirst(11);
//        list.insertlast(7);
//        list.backwardPrint();
//        Node z = new Node();
//        list.recursivesearch(11,list.first);
//        if ( list.recursivesearchvalue != null )
//        System.out.println(list.recursivesearchvalue.getData());
//        else
//            System.out.println("Cant be Finded");
//
////        System.out.printf(" The result is %s" , z==null?false:z);
//

//        list.recursivePrintlistbackward(list.first);

        Tree<Integer> tree = new Tree<Integer>(14);
        tree.insertNode(8);
        tree.insertNode(22);
        tree.insertNode(16);
        tree.insertNode(40);
        tree.insertNode(15);
        tree.insertNode(20);
//        tree.insertNode(17);
//        tree.insertNode(4);
//        tree.insertNode(6);



//        System.out.println(tree.searchfornode(7,tree.getRoot()));


        //
//        if (tree.searchfornode(5,tree.getRoot())!= null)
//            System.out.println("Found");
//        else System.out.println("Not Found");
//        tree.searchforparent(6,tree.getRoot());
//         System.out.println( tree.pparent==null?"No Parent":tree.pparent.data );
        System.out.println("Before Delete Node ");
        tree.preOrderTraversal(tree.getRoot());
        tree.BinaryTreeDelete(16, tree.getRoot());
        System.out.printf("\nAfter Delete Node\n ");
        tree.preOrderTraversal(tree.getRoot());

    }


}
