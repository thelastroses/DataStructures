import java.util.ArrayList;

public class SecondBibleProblem {
    int age;
    boolean disciple;
    int amountOfYears;
    public static void main(String[] args) {
        System.out.println("How many years it takes 13 disciples to make every human in the world to be disciples of Jesus? " + bible(13));
    }

    public SecondBibleProblem(int age, boolean disciple)
    {
        this.age = age;
        this.disciple = disciple;
        this.amountOfYears = 0;
    }

    public static int bible(int amountOfTrueDisciples)
    {
        int years = 0;
        
        ArrayList<SecondBibleProblem> people = new ArrayList<SecondBibleProblem>();

        while(amountOfTrueDisciples > 0)
        {
            people.add(new SecondBibleProblem(18, true));
            amountOfTrueDisciples--;
        }

        while(people.size() < 15050000) //had to do a smaller part of the population to prevent my laptop from crashing :/
        {
            for(int i = people.size()-1; i >= 0; i--) //had some help here bcs apparently if it does not loop backwards it skips elements, interesting
            {
                people.get(i).age++;
                people.get(i).amountOfYears++;
            
                if(people.get(i).age == 18)
                {
                    people.get(i).disciple = true;
                }

                if(people.get(i).age == 30)
                {
                    people.add(new SecondBibleProblem(0, false));
                }

                if(people.get(i).age >= 72)
                {
                    people.remove(i);
                }

                if(people.get(i).age >= 18 && people.get(i).amountOfYears >= 3)
                {
                    people.add(new SecondBibleProblem(18, true));
                    people.add(new SecondBibleProblem(18, true));
                    people.get(i).amountOfYears = 0; 
                }
            }
            years++;
        }        

        return years;
    }
}
