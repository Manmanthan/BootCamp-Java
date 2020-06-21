package DataStructures;

import com.sun.jdi.connect.Connector;

import java.util.*;
import java.util.LinkedList;

public class Graph {
    class Vertex {
        String name;
        HashMap<Vertex, Integer> nbrs;

        Vertex(String name) {
            this.name = name;
            this.nbrs = new HashMap<>();
        }

        public void display() {
            String str = this.name + "=>";
            Set<Vertex> nbrs = this.nbrs.keySet();
            for (Vertex nbr : nbrs) {
                str = str + nbr.name + "(" + this.nbrs.get(nbr) + ")";
            }
            str = str + "END";
            System.out.println(str);
        }
    }

    HashMap<String, Vertex> vtces;

    Graph() {
        this.vtces = new HashMap<>();
    }

    public int numVtces() {
        return this.vtces.size();
    }

    public void addVertex(String name) {
        if (this.vtces.containsKey(name)) {
            return;
        }

        Vertex vtx = new Vertex(name);
        this.vtces.put(name, vtx);
    }

    public void removeVertex(String name) {
        if (!this.vtces.containsKey(name)) {
            return;
        }

        Vertex vtx = this.vtces.get(name);
        Set<Vertex> nbrs = vtx.nbrs.keySet();
        for (Vertex nbr : nbrs) {
            nbr.nbrs.remove(vtx);
        }
        this.vtces.remove(name);
    }

    public int numEdges() {
        Collection<Vertex> vtces = this.vtces.values();
        int sum = 0;
        for (Vertex vtx : vtces) {
            sum = sum + vtx.nbrs.size();
        }
        sum = sum / 2;
        return sum;
    }

    public void addEdge(String name1, String name2, int cost) {
        Vertex vtx1 = this.vtces.get(name1);
        Vertex vtx2 = this.vtces.get(name2);

        if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vtx2)) {
            return;
        }

        vtx1.nbrs.put(vtx2, cost);
        vtx2.nbrs.put(vtx1, cost);
    }

    public void removeEdge(String name1, String name2) {
        Vertex vtx1 = this.vtces.get(name1);
        Vertex vtx2 = this.vtces.get(name2);

        if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vtx2)) {
            return;
        }

        vtx1.nbrs.remove(vtx2);
        vtx2.nbrs.remove(vtx1);
    }

    public void display() {
        Collection<Vertex> vtces = this.vtces.values();

        for (Vertex vtx : vtces) {
            vtx.display();
        }
        System.out.println("**************************");
    }

    public boolean hasPath(String name1, String name2) {
        Vertex vtx1 = this.vtces.get(name1);
        Vertex vtx2 = this.vtces.get(name2);

        if (vtx1 == null || vtx2 == null) {
            return false;
        }

        HashMap<Vertex, Boolean> visited = new HashMap<>();
        return this.hasPathBFS(vtx1, vtx2, visited);
    }

    private boolean hasPath(Vertex vtx1, Vertex vtx2, HashMap<Vertex, Boolean> visited) {
        if (visited.containsKey(vtx1)) {
            return false;
        } else {
            visited.put(vtx1, true);
        }

        if (vtx1.nbrs.containsKey(vtx2)) {
            return true;
        }

        Set<Vertex> nbrs = vtx1.nbrs.keySet();

        for (Vertex nbr : nbrs) {
            if (this.hasPath(nbr, vtx2, visited)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasPathBFS(Vertex vt1, Vertex vtx2, HashMap<Vertex, Boolean> visited) {
        Queue<Vertex> q = new LinkedList<>();
        q.add(vt1);

        while (!q.isEmpty()) {

            Vertex rvtx = q.remove();

            if (!visited.containsKey(rvtx)) {
                visited.put(rvtx, true);
                if (rvtx.nbrs.containsKey(vtx2)) {
                    return true;
                }
                Set<Vertex> nbrs = rvtx.nbrs.keySet();
                for (Vertex nbr : nbrs) {
                    if (!visited.containsKey(nbr)) {
                        q.add(nbr);
                    }
                }
            }
        }
        return false;
    }

    public void dft(){
        Queue<Vertex> q = new LinkedList<>();
        HashMap<Vertex, Boolean> visited = new HashMap<>();
        Collection<Vertex> vtces = this.vtces.values();

        for (Vertex vtx : vtces) {
            if (!visited.containsKey(vtx)){
                q.add(vtx);
            }

            while (!q.isEmpty()) {

                Vertex rvtx = q.remove();

                if (!visited.containsKey(rvtx)) {
                    visited.put(rvtx, true);
                    System.out.println(rvtx.name+" ");
                    Set<Vertex> nbrs = rvtx.nbrs.keySet();
                    for (Vertex nbr : nbrs) {
                        if (!visited.containsKey(nbr)) {
                            q.add(nbr);
                        }
                    }
                }
            }

        }
    }
}
