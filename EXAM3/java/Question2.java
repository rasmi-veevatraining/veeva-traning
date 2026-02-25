// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Quest2 {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
         PriorityQueue<String[]>p=new PriorityQueue<>(
            (a,b)->
            {
                double cg1 = Double.parseDouble(a[2]);
                double cg2 = Double.parseDouble(b[2]);
                if (cg1 != cg2)
                    return Double.compare(cg2, cg1);
                if(a[1].compareTo(b[1])!=0)
                return a[1].compareTo(b[1]);
                int id1 = Integer.parseInt(a[3]);
                int id2 = Integer.parseInt(b[3]);

                return Integer.compare(id1, id2);
            });
        for(int i=0;i<n;i++){
        String s=sc.nextLine().trim();
        String s1[]=s.split("\\s+");
       
        if(s1[0].equals("ENTER"))
            p.add(s1);
        else
        p.poll();
    }
    while(!p.isEmpty())
    {
        System.out.println(p.poll()[1]);
    }
    
}
}
