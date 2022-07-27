# Shortest-Path
 DESING AND ANALYSIS OF ALGORITHME

# _Code_
<sub>

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
        
</sub>

# _Result_
B->A->C->D->F->G
