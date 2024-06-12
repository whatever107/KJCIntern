public class palindrome {

    public static void main(String[] args) {
        String str = "yunus";
        char[] charArray = str.toCharArray();
        reverse(charArray);
        // String reversedStr = new String(charArray);
        System.out.println("the original string is yunus");
        System.out.println(charArray);
    }
    static void reverse(char[] charArray) {
        int start = 0;
        int end = charArray.length - 1;
        while (start < end) {
            swap(charArray, start, end);
            start++;
            end--;
        }
    }
    public static void swap(char[] charArray, int first, int second) {
        char temp = charArray[first];
        charArray[first] = charArray[second];
        charArray[second] = temp;
    }
}

