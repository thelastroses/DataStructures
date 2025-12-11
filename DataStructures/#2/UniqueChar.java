import java.util.HashSet;

public class UniqueChar {
    public static void main(String[] args) {

        System.out.println(unique("stack"));
        System.out.println(unique("queue"));


        System.out.println(Occurrence("In the beginning God created the heavens and the earth", "the"));
        System.out.println(Occurrence("In the beginning God created the heavens and the earth", "begin"));
        System.out.println(Occurrence("In the beginning God created the heavens and the earth", "recreate"));

        
    }

    public static boolean unique(String str)
    {
        HashSet<Character> set = new HashSet<>();

        for(int i = 0; i  < str.length(); i++)
        {
            if(set.contains(str.charAt(i)))
            {
                return false;
            }
            set.add(str.charAt(i));
        }

       return true;
    }

    public static int Occurrence(String str, String word)
    {
        int count = 0;
        String[] theSentence = str.split(" ");

        for(int i = 0; i  < theSentence.length; i++)
        {
            if(theSentence[i].equals(word))
            {
                count++;
            }
        }

        return count;
    }
}
