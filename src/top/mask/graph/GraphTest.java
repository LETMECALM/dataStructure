package top.mask.graph;

/**
 * ClassName GraphTest
 * Create by hx
 * Date 2021/6/27 3:38 下午
 */

public class GraphTest {

    public static void main(String[] args) {

//		Graph<Character> graph = new UnderetedMatrixGrpah<>(10); //邻接矩阵的测试
        Graph<Character> graph = new UndiretedListGraph<>(10); //邻接表的测试

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');

        graph.addEdge('A', 'B');
        graph.addEdge('A', 'D');
        graph.addEdge('B', 'C');
        graph.addEdge('B', 'E');
        graph.addEdge('C', 'D');
        graph.addEdge('C', 'F');
        graph.addEdge('D', 'F');
        graph.addEdge('E', 'F');

        graph.displayGraph();
//		graph.removeVertex('B');
//		graph.displayGraph();

        System.out.println("顶点C的度：" + graph.degree('C'));

        graph.dfs();
        graph.bfs();

    }

}
