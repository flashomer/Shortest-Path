/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg303hw4;

/**
 *
 * @author flashomer
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class Main {


    public static void main(String a[]) {
        Node A = new Node("A", null);
        Node B = new Node("B", null);
        Node C = new Node("C", null);
        Node D = new Node("D", null);
        Node E = new Node("E", null);
        Node F = new Node("F", null);
        Node G = new Node("G", null);
        Node H = new Node("H", null);


        A.adjList = new Node[]{B, C};
        B.adjList = new Node[]{A};
        C.adjList = new Node[]{A, D};
        D.adjList = new Node[]{E, F};
        E.adjList = new Node[]{D};
        F.adjList = new Node[]{D, G};
        G.adjList = new Node[]{F};
        H.adjList = new Node[]{};


        System.out.println(Node.shortestPath(B, G));
    }
}


class Node {


    String nodeName;
    Node[] adjList;


    public Node(String nodeName, Node[] adjList) {
        this.nodeName = nodeName;
        this.adjList = adjList;
    }

       public static String shortestPath(Node start, Node end) {
        
        Queue<Node> ourqueue = new LinkedList<>();
        HashSet<Node> visitedNode = new HashSet<>();
        HashMap<Node, Node> ourPath = new HashMap<>();
        
        ourqueue.add(start);
        Node ourCurrentNode;
        boolean bol = true;
        visitedNode.add(start);

        while (!ourqueue.isEmpty()) {

            ourCurrentNode = ourqueue.remove();
            if (ourCurrentNode.nodeName.equals(end.nodeName)) {
                bol = false;
                break;
            }

            for (Node nod : ourCurrentNode.adjList) {
                if (!visitedNode.contains(nod)) {
                    visitedNode.add(nod);
                    ourPath.put(ourCurrentNode, nod);
                    ourqueue.add(nod);


                }
            }
        }


        if (bol) {
            return "The Node " + start.nodeName + " is not reachable from start Node " + end.nodeName + ".";
        }


        ourCurrentNode = start;
        String ourString = ourCurrentNode.nodeName;
        while (!ourCurrentNode.nodeName.equals(end.nodeName)) {
            ourCurrentNode = ourPath.get(ourCurrentNode);
            // The output must be in the format of: a->b->c->d where the start node is a, and the end node is d.
            ourString = ourString + "->" + ourCurrentNode.nodeName;

        }
        return ourString;
    }
}

