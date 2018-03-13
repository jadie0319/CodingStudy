package Tree;


import javax.swing.text.Position;

/**
 * Created by choijaeyong on 2016. 3. 2..
 */
public class BinaryTreeNode {

    private int data;
    private BinaryTreeNode left;
    private BinaryTreeNode right;
    private BinaryTreeNode next;

    public BinaryTreeNode(int data) {
        this.data = data;
    }

    public void setData(int data) {
        this.data = data;
    }
    public int getData() {
        return data;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }
    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }
    public BinaryTreeNode getLeft() {
        return this.left;
    }
    public BinaryTreeNode getRight() {
        return this.right;
    }

    public void setNext(BinaryTreeNode next) {
        this.next=next;
    }
    public BinaryTreeNode getNext() {
        return this.next;
    }

    // 프리오더. 전위탐색. D L R
    public void PreOrder(BinaryTreeNode root) {
        if(root!=null) {
            System.out.print(root.getData() + "  ");
            PreOrder(root.getLeft());
            PreOrder(root.getRight());

        }
    }

    public void PreOrderNonRecursive (BinaryTreeNode root) {
        if(root == null) {
            return;
        }

        Binary_Stack s = new Binary_Stack(123);
        s.tree_pop();
        while(true) {
            while(root != null) {
                System.out.print(root.getData() + "  ");
                s.tree_push(root);
                root= root.getLeft();
            }
            if(s.tree_isEmpty()) {
                break;
            }
            root = s.tree_pop();
            root= root.getRight();
        }
    }

    //인오더. 중위탐색. L D R
    public void InOrder(BinaryTreeNode root) {
        if(root != null) {
            InOrder(root.getLeft());
            System.out.print(root.getData() + "  ");
            InOrder(root.getRight());
        }
    }

    public void InOrderNonRecursive(BinaryTreeNode root) {
        if(root == null) return;
        Binary_Stack bs = new Binary_Stack(1);
        bs.tree_pop();
        while(true) {
            while(root != null) {
                bs.tree_push(root);
                root=root.getLeft();
            }
            if(bs.tree_isEmpty()) {
                break;
            }
            root=bs.tree_pop();
            System.out.print(root.getData() + "  ");
            root=root.getRight();
        }
    }

    // 후위탐색.
    public void PostOrder(BinaryTreeNode root) {
        if(root != null) {
            PostOrder(root.getLeft());
            PostOrder(root.getRight());
            System.out.print(root.getData() + "  ");
        }
    }

    public void PostOrderNonRecursive(BinaryTreeNode root) {
        if(root == null) return;

        Binary_Stack bs = new Binary_Stack(123);
        bs.tree_pop();
        BinaryTreeNode cur = root;
        BinaryTreeNode cur_left = root.getLeft();
        BinaryTreeNode cur_right = root.getRight();
        BinaryTreeNode temp;

        while(true) {
            if(root != null) {
                bs.tree_push(root);
                root = root.getLeft();
            } else {
                if(bs.tree_isEmpty()) {
                    System.out.println("Stack is Empty");
                    return;
                }
            }

            if(bs.tree_top().getRight() == null) {
                    root=bs.tree_pop();
                    System.out.print(root.getData() + "  ");

                //제일 중요한부분. root 와 스택 peek의 오른쪽이 일치한지를 비교하고
                //일치하면 스택의 peek를 출력한다. 이때 스택의 peek는 LRD, D를 가리킨다.
                if(root == bs.tree_top().getRight()) {
                    //보통은 여기서 출력하고
                        System.out.print(bs.tree_top().getData() + "  ");
                        temp=bs.tree_pop();

                        //level-0 을 출력할때만 이 부분을 이용하고 while문 탈출한다.
                        //약간 야매 같지만 일단은 해결.
                        if(bs.tree_top() == cur && cur_right==temp) {
                            System.out.print(bs.tree_top().getData() + "  ");
                            break;
                        }
                    }

                if(bs.tree_isEmpty()==false) {
                    root=bs.tree_top().getRight();
                }else {
                    break;
                }

                }

        }
    }

    //레벨탐색. 위에서부터 순서대로.

    public void LevelOrder(BinaryTreeNode root) {
        BinaryTreeNode temp;
        Binary_Queue bq = new Binary_Queue();

        if(root == null) {
            return;
        }
        bq.EnQueue(root);
        while(!bq.Queue_IsEmpty()) {
            temp=bq.DeQueue();
            System.out.print(temp.getData() + "  ");
            if(temp.getLeft() != null) {
                bq.EnQueue(temp.getLeft());
            }
            if(temp.getRight() != null) {
                bq.EnQueue(temp.getRight());
            }

        }
    }

    //최대값을 찾는 알고리즘

    public int FindMax(BinaryTreeNode root) {
        int root_val=0, left=0, right=0, max=0;
        if(root != null) {
            root_val = root.getData();
            left=FindMax(root.getLeft());
            right=FindMax(root.getRight());

            if(left > right)
                max=left;
            else max = right;
            if(root_val > max) {
                max=root_val;
            }

        }
        return max;
    }

    //최대값 구하는 알고리즘. 재귀함수 이용하지 않고 큐를 이용

    public int FindMaxUsingLevelOrder(BinaryTreeNode root) {
        int max=0;
        BinaryTreeNode temp;
        Binary_Queue bq = new Binary_Queue();
        bq.createQueue();
        bq.EnQueue(root);
        while(!bq.Queue_IsEmpty()) {
            temp=bq.DeQueue();
            if(max < temp.getData()) {
                max = temp.getData();
            }

            if(temp.getLeft() != null) {
                bq.EnQueue(temp.getLeft());
            }

            if(temp.getRight() != null) {
                bq.EnQueue(temp.getRight());
            }

        }

        return max;
    }

    // 재귀를 이용해서 트리에 있는 data를 검색하는 함수
    // 재귀용법과 반복의 차이를 느꼈던 예제
    // 각 return문 앞에 프린트문을 넣어보자.
    // for문으로 반복을 시키면 이프문내에서 횟수만큼 반복해서 출력
    // 재귀는 함수 맨위에서 아래까지 반복한다.
    public boolean FindBinaryTreeUsingRecursion(BinaryTreeNode root,int data) {
        boolean temp;
        if(root == null) {  //루트가 맨 아래로 내려가면 결국 루트값은 null을 가리키게 된다. 결국 답은 false;;;;
            return false;
        } else {
            if( data == root.getData()) {
//                System.out.println("있다.");
                return true;
            } else  {

                temp = FindBinaryTreeUsingRecursion(root.getLeft(),data);


                if(!temp) {
//                    System.out.println("없다");
                    if(root.getRight() != null) {
//                        System.out.println("오른쪽검사했다");
                        temp = FindBinaryTreeUsingRecursion(root.getRight(),data);
                    }

                }
            }
        }
        return temp;
    }

    // 굉장히 비효율적인 알고리즘이다.
    // data가 없다고 출력할 수 없다
    public void FindBinaryTree(BinaryTreeNode root, int data) {
        if(root.getData() == data) {
            System.out.println("있다");
            return;
        }else if(root.getLeft() != null || root.getRight() != null) {
                FindBinaryTree(root.getLeft(),data);
                FindBinaryTree(root.getRight(),data);
        }

    }

    public boolean SearchUsingLevelOrder(BinaryTreeNode root, int data) {
        BinaryTreeNode temp;
        Binary_Queue bq = new Binary_Queue();
        bq.createQueue();
        if(root == null) {
            return false;
        }
        bq.EnQueue(root);
        while(!bq.Queue_IsEmpty()) {
            temp=bq.DeQueue();
            if(data==temp.getData()) {
                return true;
            }
            if(temp.getLeft() != null) {
                bq.EnQueue(temp.getLeft());
            }
            if(temp.getRight() != null) {
                bq.EnQueue(temp.getRight());
            }
        }
        return false;
    }


    // 이진트리에 노드 추가하는 알고리즘

    public void InsertInBinaryTree ( BinaryTreeNode root, BinaryTreeNode newNode,int data) {

        if(newNode == null) {
            System.out.println("Memory Error");
            return;
        }
        BinaryTreeNode temp;
        Binary_Queue bq = new Binary_Queue();
        if(root ==null) {
            System.out.println("비어있는 트리");
            root=newNode;
            return;
        }

        bq.EnQueue(root);
        while(!bq.Queue_IsEmpty()) {
            temp = bq.DeQueue();
            if(temp.getLeft() != null) {
                bq.EnQueue(temp.getLeft());
            } else {
                temp.setLeft(newNode);
                System.out.println("삽입");
                //실행 클래스에서
                return;
            }

            if(temp.getRight() != null) {
                bq.EnQueue(temp.getRight());
            } else {
                temp.setRight(newNode);
                System.out.println("삽입");
                return;
            }
        }
    }

    //트리의 노드 갯수를 세는 알고리즘
    public int SizeOfBinaryTree(BinaryTreeNode root) {
        if(root==null) {
            return 0;
        }else {
            return (SizeOfBinaryTree(root.getLeft()) + 1 + SizeOfBinaryTree(root.getRight()));
        }

    }

    //레벨탐색을 이용한 트리 사이즈 구하기. 비재귀
    public int SizeOfBinaryTreeNonRecursive(BinaryTreeNode root) {
        BinaryTreeNode temp;
        Binary_Queue bq = new Binary_Queue();
        int count =0;
        if(root == null) {
            return 0;
        }
        bq.EnQueue(root);
        while(!bq.Queue_IsEmpty()) {
            temp=bq.DeQueue();
            count++;
            if(temp.getLeft() != null) {
                bq.EnQueue(temp.getLeft());
            }
            if(temp.getRight() != null) {
                bq.EnQueue(temp.getRight());
            }
        }
        return count;
    }


    // 삭제
    public void DeleteBinaryTrees(BinaryTreeNode root) {
        if(root==null) return;

        DeleteBinaryTrees(root.getLeft());
        DeleteBinaryTrees(root.getRight());
        root=null;
    }

    // 레벨 탐색 역순으로 출력하기.
    public void LeverOrderInverse(BinaryTreeNode root) {
        Binary_Stack bs = new Binary_Stack(123);
        bs.tree_pop();

        Binary_Queue bq = new Binary_Queue();
        bq.createQueue();
        BinaryTreeNode temp;

        if(root == null) return;
        bq.EnQueue(root);
        while(!bq.Queue_IsEmpty()) {
            temp = bq.DeQueue();
            if(temp.getLeft() != null) {
                bq.EnQueue(temp.getLeft());
            }
            if(temp.getRight() != null) {
                bq.EnQueue(temp.getRight());
            }
            // 큐와 스택이 둘다 리스트로 이루어졌기 때문에 처음에 1,2 넣을때 getNext,setNext를 잘 보면
            // 서로를 가리키게 된다. 즉 무한루프 발생.  그것을 끊어주기 위해
            // 강제로 setNext(null) 해주어 연결을 끊고 아무 연결상태가 아닌 채로 푸쉬 해주면 해결.
            temp.setNext(null);
            bs.tree_push(temp);
        }
        System.out.println("Level Order 역순 출력");
        while(!bs.tree_isEmpty()) {
            System.out.print(bs.tree_pop().getData());
        }

    }

    //이진 트리의 높이(혹은 깊이)를 구하는 알고리즘을 구하여라.
    public int HeightOfBinaryTree(BinaryTreeNode root) {
        int leftheight=0;
        int rightheight=0;
        if(root == null) {
            return 0;
        } else {
            leftheight = HeightOfBinaryTree(root.getLeft());
            rightheight = HeightOfBinaryTree(root.getRight());
            if(leftheight > rightheight) {
                return ( leftheight +1);
            } else
                return (rightheight +1);
        }

    }

    // 이진 트리 높이 구하는 알고리즘. (비재귀)

    public int HeightOfBinaryTreeNonRecursive(BinaryTreeNode root) {
        int level=1;
        Binary_Queue bq = new Binary_Queue();
        bq.createQueue();
        BinaryTreeNode point = new BinaryTreeNode(999);
        if(root==null) {
            return 0;
        }
        bq.EnQueue(root);
        bq.EnQueue(point);
        while(!bq.Queue_IsEmpty()) {
            root=bq.DeQueue();
            if(root==point) {
                if (!bq.Queue_IsEmpty()) {
                    // 큐에 null값을 넣게 되면 내가 생가한대로 작동이 되지 않는다. 따라서 level을 나누는
                    // point 라는 노드를 하나 만들어서 인큐 해주었다.
                    // 처음에 인큐를 하는 과정에서 setNext로 2를 가리키고
                    // point->2->3->point->2->3 무한루프 발생
                    // 그래서 point 를 인큐할때마다 초기화 시켜주어야 한다.
                    point.setNext(null);
                    bq.EnQueue(point);
                    level++;
                }
            } else {
                    if(root.getLeft() != null) {
                        bq.EnQueue(root.getLeft());
                    }
                    if(root.getRight() != null) {
                        bq.EnQueue(root.getRight());
                    }
                }
            }
        return level;
    }


    public int recursiveFacto(int n) {

        if(n <=1 ) {
            return n;
        }
        else {
            return n * recursiveFacto(n-1);
        }
    }

}
