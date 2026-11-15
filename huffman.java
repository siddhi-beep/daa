import java.util.*;
class Node{
        char ch;
        int freq;
        Node left,right;
        Node(char ch,int freq)
        {
            this.ch=ch;
            this.freq=freq;
    }
    
}
public class huffman{
    static void printcodes(Node root,String code){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            System.out.println(root.ch +":"+code);
            return;
        }
        printcodes(root.left, code +"0");
        printcodes(root.right, code+"1");
    }
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a,b) -> a.freq - b.freq  ); 
        System.out.println("Enternumber of characters:");
        int n =sc.nextInt();

        for(int i=0;i<n;i++){
            System.out.println("Enter character:");
            char ch= sc.next().charAt(0);

            System.out.print("Enter frequency:");
            int freq = sc.nextInt();
            pq.add(new Node(ch,freq));
        }

        //building tree
        while(pq.size()>1){
            Node left = pq.poll();
            Node right = pq.poll();
            Node parent = new Node('-', left.freq+right.freq);
            parent.left=left;
            parent.right=right;
            pq.add(parent);
        }

        Node root = pq.poll();
        System.out.print("Huffman Codes:");
        printcodes(root,"");
        sc.close();
        

    }
}


/*
Approach: Greedy Algorithm

Time Complexity: O(n log n)
Space Complexity: O(n)
Why?
- A Priority Queue stores n characters.
- Inserting and removing an element takes O(log n).
- We remove two minimum-frequency nodes and insert
  one new node repeatedly, approximately n times.
- Therefore, total time complexity is O(n log n).
- The priority queue and Huffman tree require O(n) space.

Where:
n = Number of unique characters.

Explanation:
- Uses a Priority Queue to select two nodes with minimum frequency.
- Combines these nodes to create a new parent node.
- Repeats until a single Huffman tree is formed.
- Assigns 0 to the left edge and 1 to the right edge.
- Frequently occurring characters get shorter codes.

Application:
Used in lossless data compression.
*/
