import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    static boolean isAnagrams(String a, String b) {
        // Step 1: Convert the strings to lowercase
        String Alowercase = a.toLowerCase();
        String Blowercase = b.toLowerCase();

        // Step 2: Check the length of both strings
        if (Alowercase.length() != Blowercase.length()) {
            return false;
        }

        // Step 3: Convert the strings to char arrays
        char[] strchar1 = Alowercase.toCharArray();
        char[] strchar2 = Blowercase.toCharArray();

        // Step 4: Sort the char arrays using bubble sort
        bubbleSort(strchar1);
        bubbleSort(strchar2);

        // Step 5: Compare the sorted char arrays
        return Arrays.equals(strchar1, strchar2);
    }

    private static void bubbleSort(char[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j + 1]
                    char temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped in the inner loop, the array is sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();

        boolean ret = isAnagrams(a, b); // Corrected method name usage
        System.out.println(ret ? "Anagrams" : "Not Anagrams");
    }
}

























LOGIN 
    import java.util.Scanner;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
public class clgReg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to College Admission System");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                logreg.register();
                break;
            case 2:
                System.out.print("Enter Student Email: ");
                String email = scanner.next();
                System.out.print("Enter Student Password: ");
                String password = scanner.next();
                if (logreg.login(email,password)) {
                    System.out.println("Login successful.");
                } else {
                    System.out.println("Invalid email or password. Login failed.");
                }
                break;
            default:
                System.out.println("Invalid choice. Please select 1 or 2.");
        }
    }
}
class logreg{
       public static MongoCollection<Document>studentCollection;
       static {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("College");
        studentCollection = database.getCollection("clgreg");}

       public static void register(){
           Scanner scanner = new Scanner(System.in);
           System.out.println("Enter your Roll No");
           String rn= scanner.nextLine();
           System.out.println("Enter your email");
           String email=scanner.nextLine() ;
           System.out.println("Enter your password");
           String password =scanner.nextLine();
           if (!validateEmail(email)) {
               System.out.println("Invalid email format. Registration failed.");
           }
           Document studentreg = new Document("Roll No", rn)
                   .append("email", email)
                   .append("password", password);
           studentCollection.insertOne(studentreg);
           System.out.println("Registration successful.");
       }
    public static boolean validateEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }
    public static boolean login(String e,String p){
           String email=e;
           String password=p;
        Document student = studentCollection.find(new Document("email", email)).first();
        if (student != null) {
            String storedPassword = student.getString("password");
            return storedPassword.equals(password);
        }
        return false;
    }
}


