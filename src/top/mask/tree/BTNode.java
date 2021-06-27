package top.mask.tree;

/**
 * ClassName BTNode
 * Create by hx
 * Date 2021/6/27 1:04 下午
 */

public class BTNode<E> {
    E data;
    BTNode lchild;  //指向左孩子节点
    BTNode rchild;  //指向右孩子节点

    public BTNode(){
        lchild = rchild = null;
    }

    public BTNode(E d){
        data = d;
        lchild = rchild = null;
    }
}
