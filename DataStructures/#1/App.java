public class App {
    public int num;
    public String name;

    public App(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public static App[] TopFive(App[] list) {
        App[] numbers = new App[5];

        for (int i = 0; i < list.length; i++) {
            for(int j = i + 1; j < list.length; j++)
            {
                if(list[i].num < list[j].num)
                {
                    App temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }

        for(int k = 0; k < 5; k++)
        {
            numbers[k] = list[k];
        }

        return numbers;
    }
}