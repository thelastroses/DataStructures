import java.util.Stack;
import java.lang.Character;

public class ShuntingYardAlgorithm {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Problem: (4-2)*(3+9)/(6-1)");
        String algo1 = algorithm("(4-2)*(3+9)/(6-1)");
        System.out.println("Broken Down: " + algo1);
        System.out.println("Answer: " + math(algo1));
        System.out.println();

        System.out.println();
        System.out.println("Problem: (1+1)^2/(7-5)");
        String algo2 = algorithm("(1+1)^2/(7-5)");
        System.out.println("Broken Down: " + algo2);
        System.out.println("Answer: " + math(algo2));
        System.out.println();

        System.out.println();
        System.out.println("Problem: (2-1)*(1+3)^2/(9-5)");
        String algo3 = algorithm("(2-1)*(1+3)^2/(9-5)");
        System.out.println("Broken Down: " + algo3);
        System.out.println("Answer: " + math(algo3));
    }


    public static int place(char e)
    {
        if(e == '+' || e == '-')
        {
            return 1;
        }
        else if(e == '*' || e == '/')
        {
            return 2;   
        }
        else if(e == '^')
        {
            return 3;
        }

        return -1;
    }

    public static boolean left(char e)
    {
        if(e == '+' || e == '-' || e == '*' || e == '/')
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static String algorithm(String s)
    {
        Stack<Character> stack = new Stack<>();
        String f = "";

        for(int i = 0; i < s.length(); i++)
        {
            char e = s.charAt(i);

            if(Character.isLetterOrDigit(e))
            {
                f += e;
            }
            else if(e == '(')
            {
                stack.push(e);
            }
            else if (e == ')')
            {
                while(!stack.isEmpty() && stack.peek() != '(' )
                {
                    f += stack.pop();
                }
                stack.pop();
            }
            else
            {
                while(!stack.isEmpty() && place(e) <= place(stack.peek()) && left(e))
                {
                    f += stack.pop();
                }
                stack.push(e);
            }
        }

        while(!stack.isEmpty())
        {
            if(stack.peek() == '(')
            {
                return "too many parentheses";
            }
            f += stack.pop();
        }

        return f;
    }



    public static float math(String s)
    {
        Stack<Float> stack = new Stack<>();
        float f = 0;
        
        for(int i = 0; i < s.length(); i++)
        {
            char e = s.charAt(i);

            if(Character.isDigit(e))
            {
                stack.push((float)(e - '0'));
            }
            else
            {
                float rNum = stack.pop();
                float lNum = stack.pop();

                if(e == '+')
                {
                    f = lNum + rNum;
                }
                else if(e == '-')
                {
                    f = lNum - rNum;
                }
                else if(e == '*')
                {
                    f = lNum * rNum;
                }
                else if(e == '/')
                {
                    f = lNum / rNum;
                }
                else if(e == '^')
                {
                    f = (float) Math.pow(lNum, rNum);
                }
                stack.push(f);
            }
        }

        return stack.pop();
    }
}