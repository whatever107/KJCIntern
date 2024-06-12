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



