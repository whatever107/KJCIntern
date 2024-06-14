////Complete this code or write your own from scratch
//import java.util.*;
//import java.io.*;
//    public class Mapping {
//        public static void main(String []argh) {
//            Scanner in = new Scanner(System.in);
//            System.out.println("Enter the number of contacts you want to add");
//            int n = in.nextInt();
//
//            HashMap<String, Integer> phonebook = new HashMap<String, Integer>();
//
//            for (int i = 0; i < n; i++) {
//                System.out.println("enter the name");
//                String name = in.next();
//                System.out.println("enter the phonenumber");
//                int phone = in.nextInt();
//                phonebook.put(name, phone);
//            }
//            while(in.hasNext())
//            {
//                System.out.println("enter the name you want to search for ");
//                String s=in.nextLine();
//                if (phonebook.containsKey(s))
//                {
//                    System.out.println(+phonebook.get(s));
//                }
//                else
//                    System.out.println("not found");
//            }
//        }
//    }
import com.sun.javaws.exceptions.ExitException;

import java.util.*;
public class Mapping {
    public static void main(String []argh) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of contacts you want to add");
        int n = in.nextInt();
        in.nextLine();  // Consume the leftover newline character

        HashMap<String, Integer> phonebook = new HashMap<String, Integer>();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the name:");
            String name = in.next();
            System.out.println("Enter the phone number:");
            int phone = in.nextInt();
            in.nextLine();  // Consume the leftover newline character
            phonebook.put(name, phone);
        }
        while (true) { // Changed to infinite loop for continuous input (until interrupted)
            System.out.println("Enter the name you want to search for:");
            String s = in.nextLine();
            if (phonebook.containsKey(s)) {
                System.out.println(s + "=" + phonebook.get(s));

            } else {
                System.out.println("Not found");
                break;
            }
        }
    }
}