
import java.util.*;
class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HashMap<String,HashMap<String,Integer>>h=new HashMap<>();
        while(true)
        {
            System.out.println("1. Insert Data");
            System.out.println("2. retrive data");
            System.out.println("3. exit");
            int n=sc.nextInt();
            switch(n)
            {
                case 1:
                    String s=sc.next();
                    String s1=sc.next();
                    int p=sc.nextInt();
                    if(h.containsKey(s))
                    {
                        h.get(s).put(s1,p);
                    }
                    else{
                    HashMap<String,Integer>h1=new HashMap<>();
                    h1.put(s1,p);
                    h.put(s,h1);
                    }
                    break;
                case 2:
                    
                    System.out.println("1. Based on storedId print all products their prices ");
                    System.out.println("2.  If storeid is given find the product which has highest price");
                    System.out.println("3. the product name is given find and display all the stores which contains the product");
                    int n1=sc.nextInt();
                    switch(n1)
                    {
                        case 1:
                            String s2=sc.next();
                            if(h.containsKey(s2))
                            {
                                 HashMap<String,Integer>h1=h.get(s2);
                                 for(String s3:h1.keySet())
                                 {
                                     System.out.println(s3+" "+h1.get(s3));
                                 }
                            }
                            else
                            System.out.println("This store does not exists");
                            break;
                        case 2:
                            String s4=sc.next();
                            if(h.containsKey(s4))
                            {
                                int t=0;
                                String y="";
                                 HashMap<String,Integer>h1=h.get(s4);
                                 for(String s5:h1.keySet())
                                 {
                                     if(t<h1.get(s5))
                                     {
                                         t=h1.get(s5);
                                         y=s5;
                                     }
                                     
                                 }
                                 System.out.println(y+" "+t);
                            }
                            else
                            System.out.println("This store does not exists");
                            break;
                        case 3:
                            String s6=sc.next();
                            for(String s7:h.keySet())
                            {
                                HashMap<String,Integer>h1=h.get(s7);
                                if(h1.containsKey(s6))
                                System.out.println(s7);
                            }
                            break;
                        default:
                            System.out.println("Invalid input");
                            break;
                    }
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }
    }
}
