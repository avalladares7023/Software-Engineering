import java.util.Scanner;

public class Predicate {
    public static void test (boolean x, boolean y, boolean z)
    {
        if (x && (y || z))
        {
            System.out.println ("Predicate is T");
        }
        else
        {
            System.out.println ("Predicate is F");
        }
    }

    // Records which edges are traversed
    public static void testNotCompact(boolean x, boolean y, boolean z)
    {
        // One variable at the time
        if (x == true)
        {
            System.out.println("x is true");
        }
        else
        {
            System.out.println("x is false");
        }
        if (y == true)
        {
            System.out.println("y is true");
        }
        else
        {
            System.out.println("y is false");
        }
        if (z == true)
        {
            System.out.println("z is true");
        }
        else
        {
            System.out.println("z is false");
        }

        // Checking one clause
        if (y || z == true)
        {
            System.out.println("(y || z) is true");
        }
        else
        {
            System.out.println("(y || z) is false");
        }

        // Checking complete Predicate
        if ((x && (y || z)) == true)
        {
            System.out.println("(x && (y || z)) is true");
        }
        else {
            System.out.println("(x && (y || z)) is false");
        }
    }

    public static void main(String[] args)
    {
        System.out.print("Is x true or false? ");
        Scanner first = new Scanner(System.in);
        boolean x = first.nextBoolean();
        System.out.print("Is y true or false? ");
        Scanner second = new Scanner(System.in);
        boolean y = second.nextBoolean();
        System.out.print("Is z true or false? ");
        Scanner n = new Scanner(System.in);
        boolean z = n.nextBoolean();

        test(x, y, z);
        testNotCompact(x, y, z);
    }
}
