public class BibleProblem {
    public static void main(String[] args) {
        System.out.println("How many years would it take to convert all humans to be disciples of Christ? " + findYears(13));
        System.out.println("If we want to make it happen in 50 years, how many disciples should be trained together at a time? " + amountOfDisciples(50));
    }

    public static int findYears(int amountOfTrueDisciples)
    {
        int count = 0;
        for(long i = amountOfTrueDisciples; i < 7700000000L; i = (i * 2) + i)
        {
            count = count + 3;
        }

        return count;
    }

    public static long amountOfDisciples(int years)
    {
        int count = 0;

        for(int j = 1; j < years; j++)
        {
            long amountOfTrueDisciples = 13;
            count++;
            for(int i = 0 ; i < years; i = i + 3)
            {
                amountOfTrueDisciples = (amountOfTrueDisciples * j) + amountOfTrueDisciples;
            }

            if(amountOfTrueDisciples >= 7700000000L)
            {
                break;
            }
        }
        
        return count;
    }
}
