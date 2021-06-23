package top.mask.linkedlist;

/**单链表
 * ClassName SingleLinkedList
 * Create by hx
 * Date 2021/6/23 5:46 下午
 */

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "张三", "nick1");
        HeroNode hero2 = new HeroNode(2, "李四", "nick2");
        HeroNode hero3 = new HeroNode(3, "王武", "nick3");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
        //加入按照编号顺序
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);
        //singleLinkedList.addByOrder(hero2);
        System.out.println("修改前的链表：");
        singleLinkedList.showList();

        //修改节点的操作
//        HeroNode newHeroNode = new HeroNode(2, "new李四", "newNick");
//        singleLinkedList.update(newHeroNode);
//        System.out.println("修改前后的链表：");
//        singleLinkedList.showList();

        //删除链表
//        singleLinkedList.delete(1);
//        singleLinkedList.delete(2);
//        singleLinkedList.delete(3);
//        System.out.println("删除后的链表：");
//        singleLinkedList.showList();

        //求链表节点个数
        System.out.println("计算单链表有效节点个数：");
        System.out.println("有效节点个数："+SingleLinkedList.getLength(singleLinkedList.getHead()));

        //测试是否得到倒数第k个节点
        HeroNode res = SingleLinkedList.findLastIndexNode(singleLinkedList.getHead(),4);
        System.out.println("result:"+res);
    }

}

//定义SingleLinkedList 管理我们的英雄
class SingleLinkedList{

    //先初始化一个头节点，头节点不要动,不存放具体数据
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    /**
     * 添加节点到单向链表
     * 当不考虑编号顺序时，找到当前链表的最后节点，将最后这个节点的next指向新的节点
     * @param heroNode
     */
    public void add(HeroNode heroNode){

        HeroNode temp = head;
        //遍历链表，找到最后
        while (true){
            if (temp.next == null){
                break;
            }
            //没有找到将temp后移
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    //显示链表
    public void showList(){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因此需要辅助变量
        HeroNode temp = head.next;
        while (true){
            //判断是否到链表最后
            if (temp == null){
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //将next后移
            temp = temp.next;
        }
    }

    //添加节点插入到指定位置
    public void addByOrder(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){//说明temp已经在链表的最后
                break;
            }
            if (temp.next.no >  heroNode.no){
                break;
            }else if (temp.next.no == heroNode.no){//说明希望添加的heroNode的编号已然存在
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断flag的值
        if (flag){//不能添加，说明编号存在
            System.out.println("准备插入的英雄编号"+heroNode.no+"已经存在,不能加入");
        }else {
            //插入到链表中,temp后面
            heroNode.next = temp.next;
            temp.next =heroNode;

        }
    }

    //修改节点的信息，不能修改编号
    public void update(HeroNode newHeroNode){
        //判断是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点
        HeroNode temp = head.next;
        boolean flag = false; //表示是否找到该节点
        while (true){
            if (temp == null){
                break; //到链表尾部
            }
            if (temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到修改的节点
        if (flag){
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        }else {
            System.out.println("没有找到编号为"+newHeroNode.no+"的节点");
        }
    }


    //链表的删除
    public void delete(int no){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.no == no){
                //找到待删除的节点的前一个节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            //找到可以删除
            temp.next = temp.next.next;
        }else {
            System.out.println("要删除的节点"+no+"不存在");
        }
    }


    /**
     * 获取单链表节点的个数
     * @param head
     * @return
     */
    public static int getLength(HeroNode head){
        if (head.next == null){
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null){
            length ++;
            cur = cur.next; //遍历
        }
        return length;
    }

    //查找单链表中的倒数第k个节点【新浪面试题】
    /**
     * 编写一个方法接收head节点，同时接收一个index
     * index表示倒数第index节点
     * 先把链表从头到尾遍历，得到链表的总的长度 getLength
     * 得到size后，从链表的第一个开始遍历（size-index）个，即可以得到
     * 找到返回节点，没有找到返回空
     */
    public static HeroNode findLastIndexNode(HeroNode head,int index){
        //判断链表为空，返回null
        if (head.next == null){
            return null;
        }
        //第一次遍历得到链表的长度（节点个数）
        int size = getLength(head);
        //第二次遍历 size-index 位置，就是我们倒数的第k个节点
        if (index <= 0 || index > size){
            return null;
        }
        //定义辅助变量,定位到倒数index
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

}


//定义HeroNode，每个HeroNode是一个节点
class HeroNode{

    public int no;
    public String name;
    public String nickName;
    public HeroNode next; //指向下一个节点

    public HeroNode(int hNo,String hName,String hNick){
        this.no = hNo;
        this.name = hName;
        this.nickName = hNick;
    }


    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +

                '}';
    }
}
