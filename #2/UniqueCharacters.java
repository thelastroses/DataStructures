public class UniqueCharacters {
    public String str;

    public UniqueCharacters(String str) {
        this.str = str;
    }

    public static void main(String[] args) {
        UniqueCharacters obj = new UniqueCharacters("hello");
        System.out.println(unique(obj.str));
    }

    public static boolean unique(String str)
    {
        for(int i = 0; i < str.length(); i++)
        {
            
            if(str.charAt(i) == str.charAt(i + 1))
            {
              return false;  
            }
        }
        return true;
    }

    
}