// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Countries_Captials {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        Scanner sc=new Scanner(System.in);
        HashMap<String,HashMap<String,String>> h=new HashMap<>();
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
                    String p=sc.next();
                    if(h.containsKey(s))
                    {
                        h.get(s).put(s1,p);
                    }
                    else{
                    HashMap<String,String>h1=new HashMap<>();
                    h1.put(s1,p);
                    h.put(s,h1);
                    }
                    break;
                case 2:
                    
                    System.out.println("1.	Print all countries, no of capitals in each country and corresponding capitals along with season also. ");
                    System.out.println("2.	Given a country name, print capitals of that country along with season and no of capitals for that country.");
                    System.out.println("3.	Print all the countries having 2 capitals.");
                    System.out.println("4.	Print all the countries having 3 capitals.");
                    System.out.println("5.	Find countries that doesnt contain summer capital.");
                    System.out.println("6.	Find and return the capitals of the countries which start with vowels.");
                    System.out.println("7.	Print summer capitals of the country that starts with vowel.");
                    int n1=sc.nextInt();
                    switch(n1)
                    {
                        case 1:
                            for(String x:h.keySet())
                            {
                                System.out.println(x+" "+h.get(x).size());
                                for(String x1:h.get(x).keySet())
                                {
                                    System.out.print(x1+" "+h.get(x).get(x1)+" ");
                                }
                            }
                            break;
                        case 2:
                            String s4=sc.next();
                            if(h.containsKey(s4))
                            {
                                 HashMap<String,String>h1=h.get(s4);
                                 for(String s5:h1.keySet())
                                 {
                                     System.out.println(s5+" "+h1.get(s5));
                                     
                                 }
                                 System.out.println(h1.size());
                            }
                            else
                            System.out.println("This store does not exists");
                            break;
                        case 3:
                            for(String x:h.keySet())
                            {
                                if(h.get(x).size()==2)
                                System.out.println(x);
                            }
                            break;
                        case 4:
                            for(String x:h.keySet())
                            {
                                if(h.get(x).size()==3)
                                System.out.println(x);
                            }
                            break;
                        case 5:
                            for(String x:h.keySet())
                            {
                                Set<String>o=h.get(x).keySet();
                                if(!o.contains("summer"))
                                System.out.println(x);
                            }
                            break;
                        case 6:
                            for(String x:h.keySet())
                            {
				char c=x.toLowerCase().charAt(0);
				if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
				                System.out.print(x+" ");
                                for(String x1:h.get(x).keySet())
                                {
                                    System.out.print(h.get(x).get(x1)+"  ");
                                }
                                System.out.println();}
                            }
                            break; 
                        case 7:
                            for(String x:h.keySet())
                            {
				char c=x.toLowerCase().charAt(0);
				if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
				                System.out.print(x+" ");
                                for(String x1:h.get(x).keySet())
                                {
                                    if(x1.equals("summer")){
                                    System.out.println(h.get(x).get(x1));}
                                }
                                System.out.println();}
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

