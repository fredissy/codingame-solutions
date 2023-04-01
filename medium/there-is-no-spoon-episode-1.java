import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Don't let the machines win. You are humanity's last hope...
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        int height = in.nextInt(); // the number of cells on the Y axis

        Set<Node> nodes = new HashSet<>();

        if(in.hasNext()) {
            in.nextLine();
        }

        // in grid : 1 if node, 0 if empty
        int[][] grid = new int[height][width];
        System.err.println("width = " + width + ", height = " + height);

        for (int i = 0; i < height; i++) {
            String line = in.nextLine(); // width characters, each either 0 or .
            System.err.println("["+line + "]");
            int col = 0;
            for(char c : line.toCharArray()) {
                grid[i][col] = c =='0'? 1 : 0;
                if(c == '0') {
                    nodes.add(new Node(col, i));
                }
                col++;
            }
        }

        for (Node node : nodes) {
            Node right = findNeighbourRight(node, grid, width);
            Node down = findNeighbourDown(node, grid, height);
            System.out.println(node.toString() + " " + right.toString() +  " " + down.toString());
        }
    }

private static Node findNeighbourRight(Node source, int[][] grid, int width) {
        for(int i = source.w+1; i < width; i++) {
            if(grid[source.h][i] == 1) {
                return new Node(i, source.h);
            }
        }
        return new Node(-1, -1);
    }

    private static Node findNeighbourDown(Node source, int[][] grid, int height) {
        for(int i = source.h+1; i < height; i++) {
            if(grid[i][source.w] == 1) {
                return new Node(source.w, i);
            }
        }
        return new Node(-1, -1);
    }

    public static class Node {
        public int w;
        public int h;

        public Node(int w, int h) {
            this.w = w;
            this.h = h;
        }

        public String toString() {
            return "" + w + " " + h;
        }
    }
}