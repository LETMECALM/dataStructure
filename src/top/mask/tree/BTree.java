package top.mask.tree;

import java.util.Stack;

public class BTree {
    BTNode<Character> root; // 根结点
    private String bstr = "";
    public BTree() {
        root = null;
    }

    /**
     *
     * @param string 二叉树的字符串表示 str="A(B(D(,G),),C(E,F))"
     */

    public void createBTree(String string) {
        Stack<BTNode> st = new Stack<BTNode>(); // 用来保存所有子树的根结点
        BTNode<Character> p = null;
        int i = 0;
        boolean flag = true; // flag == true，表示处理左子树；flag==false，表示处理右子树
        while (i < string.length()) {
            char ch = string.charAt(i);

            if (ch == '(') { // 将子树的根结点进栈，同时开始处理左子树
                st.push(p);
                flag = true;

            } else if (ch == ')') { // 当前子树处理完毕
                st.pop();
            } else if (ch == ',') { // 开始处理右子树
                flag = false;
            } else {
                p = new BTNode<Character>(ch);
                if (root == null) {
                    root = p;
                } else {
                    if (!st.isEmpty()) {
                        if (flag) { // 处理的是右子树
                            st.peek().lchild = p; // 当前结点是栈顶结点的左孩子
                        } else {
                            st.peek().rchild = p; // 当前结点是栈顶结点的右孩子
                        }
                    }
                }

            }
            i++;
        }

    }

    public String toString() {
        this.changeToString(root);
        return bstr;
    }

    /**
     *
     * @param t  二叉树t
     * 	将二叉树t转换成一个字符串表示
     */
    private void changeToString(BTNode<Character> t) {
        if( t != null) {
            bstr = bstr + t.data;
            if(t.lchild != null || t.rchild != null){
                //  ( 左子树 , 右子树 )
                bstr += '(';
                this.changeToString(t.lchild);
                bstr += ',';
                this.changeToString(t.rchild);
                bstr += ')';
            }
        }
    }


    public  BTNode<Character> findNode(char x){
        return this.findNode(root, x);
    }

    /**
     *
     * @param t 	子树
     * @param x
     * @return	查找值为x的结点并返回
     */
    private BTNode<Character> findNode(BTNode<Character>t,char x){
        BTNode<Character> p ;
        if( t == null) {
            return null;
        }else  if (t.data == x) {
            return t;
        }else {
            p = this.findNode(t.lchild, x);
            if( p!=null) {
                return p;
            }else {
                return this.findNode(t.rchild, x);
            }

        }
    }

    public int height() {
        return this.height(root);
    }
    /**
     *
     * @param t
     * @return 二叉树t的高度
     */
    private int height(BTNode<Character>t) {
        if( t == null) {
            return 0;
        }else {
            return Math.max(this.height(t.lchild) ,this.height(t.rchild)) + 1;
        }
    }

    public void preOrder() {
        this.preOrder(root);
    }

    /**
     *
     * @param t
     * 	先序遍历（先根遍历） 二叉树
     */
    private void preOrder(BTNode<Character>t) {
        if(t != null) {
            System.out.print(t.data);
            this.preOrder(t.lchild);
            this.preOrder(t.rchild);
        }
    }

    public void inOrder() {
        this.inOrder(root);
    }
    /**
     *
     * @param t
     * 	中序遍历二叉树
     */
    private void inOrder(BTNode<Character> t) {
        if(t != null) {
            this.inOrder(t.lchild);
            System.out.print(t.data);
            this.inOrder(t.rchild);
        }
    }

    public void postOrder() {
        this.postOrder(root);
    }
    /**
     *
     * @param t
     * 	后序遍历二叉树
     */
    private void postOrder(BTNode<Character> t) {
        if( t != null) {
            this.postOrder(t.lchild);
            this.postOrder(t.rchild);
            System.out.print(t.data);
        }
    }

}
