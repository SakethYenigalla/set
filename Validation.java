package demo;

public class Validation {
        public static boolean isValidBrackets(String s) {
            int Temp = 0;
            for (char c : s.toCharArray()) {
                if (c == '(' || c =='{' || c=='[') {
                    Temp++;
                } else if (c == ')' || c=='}' || c==']') {
                    Temp--;
                }
                if (Temp < 0) {
                    return false;
                }
            }
            return Temp == 0;
        }
        public static void main(String[] args) {
            String string1 = "([{}])";
            String string2 = "({[])";
            boolean result1 = isValidBrackets(string1);
            boolean result2 = isValidBrackets(string2);
            System.out.println("String '" + string1 + "' is valid: " + result1);
            System.out.println("String '" + string2 + "' is valid: " + result2);
        }
}
