import java.util.*;
class item{
    int weight,profit;
    double ratio;

    item(int weight, int profit){
        this.weight= weight;
        this.profit = profit;
        ratio = (double)profit/weight;
    }
}
public class fractionalKnapsack {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter number of items:");
        int n = sc.nextInt();
        item items[]= new item[n];
        //weight n profit
        for(int i=0;i<n;i++){
            System.out.println("Enter weight:");
            int w= sc.nextInt();

            System.out.println("Enter profit:");
            int p= sc.nextInt();

            items[i]=new item(w,p);

        }
        System.out.print("Enter knapsack capacity:");
        int capacity= sc.nextInt();

        //sort items by profit n weight ratio
        Arrays.sort(items, (a,b)-> Double.compare(b.ratio,a.ratio));
        double totalprofit=0;
        //greedy loop
        for(int i=0; i<n; i++){
            if(capacity == 0){
                break;
            }
            if(items[i].weight <= capacity){
                totalprofit += items[i].profit;
                capacity -= items[i].weight;
            }
            else{
                double fraction = 
                (double) capacity/ items[i].weight;
                totalprofit += items[i].profit * fraction;
                capacity=0;
            }
        }
        System.out.println("Maximum profit:" + totalprofit);
        sc.close();

    }
    
}
