package demo;

import java.util.HashMap;
import java.util.Stack;
class Brackets {
   public static boolean isvalid(String s){
        HashMap<Character,Character> hm= new HashMap<>();
        hm.put(')','(');
        hm.put('}','{');
        hm.put(']','[');
        Stack<Character> stack= new Stack<>();

        for(char c:s.toCharArray()){
            if(hm.containsKey(c)) {
                char top = stack.isEmpty() ? '#' : stack.pop();
                System.out.println(top);
                if (top != hm.get(c)) {
                    return false;
                }
            }else {
                    stack.push(c);
                    System.out.println("p"+c);
                }
            }
        return  stack.isEmpty();
    }

    public static void main(String[] args) {
        String string1 = "([{}])";
        String string2 = "({[])";
        String string3 = "({[}])";
        boolean result1 = isvalid(string1);
        boolean result2 = isvalid(string2);
        boolean result3 = isvalid(string3);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
