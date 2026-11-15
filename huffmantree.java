
import java.util.*;

class Node {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}

public class huffmantree {

    // Method to print Huffman codes
    static void printCodes(Node root, String code) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " : " + code);
            return;
        }

        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    // Method to print Huffman tree
    static void printTree(Node root, int level) {

        if (root == null) {
            return;
        }

        // Print right subtree first
        printTree(root.right, level + 1);

        // Add spaces according to tree level
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }

        // Print character for leaf node,
        // otherwise print -
        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " (" + root.freq + ")");
        } else {
            System.out.println("- (" + root.freq + ")");
        }

        // Print left subtree
        printTree(root.left, level + 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> a.freq - b.freq
        );

        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.print("Enter character: ");
            char ch = sc.next().charAt(0);

            System.out.print("Enter frequency: ");
            int freq = sc.nextInt();

            pq.add(new Node(ch, freq));
        }

        // Build Huffman Tree
        while (pq.size() > 1) {

            Node left = pq.poll();
            Node right = pq.poll();

            Node parent = new Node(
                '-', left.freq + right.freq
            );

            parent.left = left;
            parent.right = right;

            pq.add(parent);
        }

        Node root = pq.poll();

        // Display Huffman Tree
        System.out.println("\nHuffman Tree:");
        printTree(root, 0);

        // Display Huffman Codes
        System.out.println("\nHuffman Codes:");
        printCodes(root, "");

        sc.close();
    }
}
