// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Employee>e=new ArrayList<>();
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
                    String j=sc.next();
                    String d=sc.next();
                    int sal=sc.nextInt();
                    Employee e1=new Employee(s,j,sal,d);
                    e.add(e1);
                    break;
                case 2:
                    
                    System.out.println("1. Sort by sal in ascending order ");
                    System.out.println("2. Sort by sal in descending order ");
                    System.out.println("3. Sort by date in ascending order");
                    System.out.println("4. Sort by date in descending order");
                    int n1=sc.nextInt();
                    switch(n1)
                    {
                        case 1:
                            Collections.sort(e,(a,b)->a.sal-b.sal);
                            for(Employee e2:e)
                            {
                                System.out.println(e2.s+" "+e2.sal);
                            }
                            break;
                        case 2:
                            Collections.sort(e,(a,b)->b.sal-a.sal);
                            for(Employee e2:e)
                            {
                                System.out.println(e2.s+" "+e2.sal);
                            }
                            break;
                        case 3:
                            Collections.sort(e,(a,b)->a.d.compareTo(b.d));
                            for(Employee e2:e)
                            {
                                System.out.println(e2.s+" "+e2.sal+" "+e2.d);
                            }
                            break;
                        case 4:
                            Collections.sort(e,(a,b)->b.d.compareTo(a.d));
                            for(Employee e2:e)
                            {
                                System.out.println(e2.s+" "+e2.sal+" "+e2.d);
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
class Employee
{
    String s,j,d;
    int sal;
    public Employee(String s,String j,int sal,String d)
    {
        this.s=s;
        this.j=j;
        this.sal=sal;
        this.d=d;
    }
}
