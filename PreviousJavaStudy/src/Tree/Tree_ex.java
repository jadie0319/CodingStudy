package Tree;


/**
 * Created by choijaeyong on 2016. 3. 2..
 */
public class Tree_ex {
    public static void main(String[] args) {
        BinaryTreeNode bt1 = new BinaryTreeNode(1);//         1
        BinaryTreeNode bt2 = new BinaryTreeNode(2);//      2     3
        BinaryTreeNode bt3 = new BinaryTreeNode(3);//    4  5   6 7
        BinaryTreeNode bt4 = new BinaryTreeNode(4);
        BinaryTreeNode bt5 = new BinaryTreeNode(5);
        BinaryTreeNode bt6 = new BinaryTreeNode(6);
        BinaryTreeNode bt7 = new BinaryTreeNode(7);

        System.out.println(bt1.getData());
        //1의 left 와 right 설정해보기

        bt1.setLeft(bt2);
        bt1.setRight(bt3);

        // bt1의 left right 출력
        System.out.println("bt1 의 Left 노드 : "+bt1.getLeft().getData());
        System.out.println("bt1 의 Right 노드 : "+bt1.getRight().getData() + "\n");
        System.out.println("이진트리 Preorder 출력");
        bt2.setLeft(bt4);
        bt2.setRight(bt5);
        bt3.setLeft(bt6);
        bt3.setRight(bt7);

        // bt1 트리 전위탐색 출력!  출력결과 맞다.
        bt1.PreOrder(bt1);

        // bt1 트리 비재귀적 전위탐색 출력!
        // Binary_Stack 에서 push과정이 잘못되어서 출력이 제 값이 안나온 것임.
        // push else 구문에서 임시용 BinaryTreeNode를 만들때 new로 해서 btn.getData()를 넘기게 디면
        // 값만 넘어가고 left right 값은 넘어가지 않는다. 주의주의.
        System.out.print("\n이진트리 NonRecursive Preorder 출력!!\n");
        bt1.PreOrderNonRecursive(bt1);   // 출력결과 일치함.

        //InOrder
        System.out.println("\n\n이진트리 Inorder 출력");
        bt1.InOrder(bt1);

        // bt1 트리 비재귀적 중위탐색 출력.
            System.out.print("\n이진트리 NonRecursive Inorder 출력!!\n");
        bt1.InOrderNonRecursive(bt1);   // 출력결과 일치함.

        // PostOrder   .... 결과 맞음.
        System.out.println("\n\n이진트리 postorder 출력");
        bt1.PostOrder(bt1);

        // bt1 트리 비재귀적 후위탐색 출력.
        System.out.print("\n이진트리 NonRecursive Postorder 출력!!\n");
        bt1.PostOrderNonRecursive(bt1);   // 출력결과 일치함.



        // 무한루프에 갇히는데...????
        // 위에 탐색들을 실행하면서. 스택에서 푸쉬할때 setNext가 사용되었어서 bt들이 next값을 가지게 되었다.
        // 그래서 무한루프에 빠졌던 것. 초기화를 해주면 문제 해결 된다.
        bt1.setNext(null);
        bt2.setNext(null);
        bt3.setNext(null);
        bt4.setNext(null);
        bt5.setNext(null);
        bt6.setNext(null);
        bt7.setNext(null);

        // bt1 트리 레벨순서탐색
        System.out.print("\n이진트리 Level Order 출력!!\n");
        bt1.LevelOrder(bt1);

        // bt1 트리 최대값 구하는 알고리즘  (재귀 이용)
        // 숫자 바꿔서 실행시켜도 최대값 잘 구한다!

        System.out.print("\n이진트리 최대값 출력!!\n");
        System.out.println("최대값 : " + bt1.FindMax(bt1));

        // bt1 트리 최대값 구하기 알고리즘 (재귀를 이용하지 않고 큐를 이용함)
        System.out.print("\n이진트리 최대값 출력!!\n");
        System.out.println("최대값 : " + bt1.FindMaxUsingLevelOrder(bt1));

        // 트리에서 원하는 값 검색하기
        System.out.print("\n이진트리 재귀검색!!\n");
        System.out.println("트리안에 99 값이 있습니까? : " +  bt1.FindBinaryTreeUsingRecursion(bt1,99));
        System.out.println("트리안에 6 값이 있습니까? : " +  bt1.FindBinaryTreeUsingRecursion(bt1,6));
        System.out.println("트리안에 5 값이 있습니까? : " +  bt1.FindBinaryTreeUsingRecursion(bt1,5));

        //굉장히 비효율적인 알고리즘.
//        bt1.FindBinaryTree(bt1,4);

        //재귀 없이 이진트리 검색 알고리즘.
        System.out.print("\n이진트리 비재귀검색!!\n");
        System.out.println("트리안에 1 값이 있습니까?" + bt1.SearchUsingLevelOrder(bt1,1));
        System.out.println("트리안에 5 값이 있습니까?" + bt1.SearchUsingLevelOrder(bt1,5));
        System.out.println("트리안에 88 값이 있습니까?" + bt1.SearchUsingLevelOrder(bt1,88));

        // 트리에 새 노드 추가시키기
        BinaryTreeNode bt8 = new BinaryTreeNode(8);
        System.out.println("트리에 새 노드 추가하기 ");
        bt1.InsertInBinaryTree(bt1,bt8,8);
        System.out.println("4번 노드에 왼쪽 주소" + bt4.getLeft());
        System.out.println("새로운노드 8번 노드주소" + bt8);
        System.out.println("4번노드의 왼쪽 주소와 새로 만들어진 노드의 주소가 일치. 삽입완료\n");

        //트리의 숫자세기
        System.out.println("트리 노드 갯수는 ? " + bt1.SizeOfBinaryTree(bt1) + "\n");

        //트리 레벨순서 데이터를 역순으로 출력하는 알고리즘
        bt1.setNext(null);
        bt2.setNext(null);
        bt3.setNext(null);
        bt4.setNext(null);
        bt5.setNext(null);
        bt6.setNext(null);
        bt7.setNext(null);
        bt8.setNext(null);
        bt1.LeverOrderInverse(bt1);


        //트리의 높이 깊이 구하기
        System.out.println("\n트리 높이는 ? " + bt1.HeightOfBinaryTree(bt1) + "\n");


        bt1.setNext(null);
        bt2.setNext(null);
        bt3.setNext(null);
        bt4.setNext(null);
        bt5.setNext(null);
        bt6.setNext(null);
        bt7.setNext(null);
        bt8.setNext(null);
        //트리 높이 깊이 구하기. 비재귀방식
        System.out.println("\n비재귀 방식으로 구하는 트리 높이는 ? " + bt1.HeightOfBinaryTreeNonRecursive(bt1) + "\n");


        System.out.println(bt1.recursiveFacto(5));


    }

}
