public class Test {
    public static void main(String[] args) {
        App[] list = new App[20];
        list[0] = new App(2, "A");
        list[1] = new App(1, "B");
        list[2] = new App(8, "C");
        list[3] = new App(4, "D");
        list[4] = new App(8, "E");
        list[5] = new App(7, "F");
        list[6] = new App(11, "G");
        list[7] = new App(5, "H");
        list[8] = new App(9, "I");
        list[9] = new App(0, "J");
        list[10] = new App(20, "K");
        list[11] = new App(13, "L");
        list[12] = new App(14, "M");
        list[13] = new App(3, "N");
        list[14] = new App(5, "O");
        list[15] = new App(6, "P");
        list[16] = new App(16, "Q");
        list[17] = new App(12, "R");
        list[18] = new App(10, "S");
        list[19] = new App(19, "T");

        App[] topFiveList = App.TopFive(list);

		System.out.println();
        System.out.println("Top Five List:");

        for (int i = 0; i < topFiveList.length; i++) {
            System.out.println(topFiveList[i].name + ": " + topFiveList[i].num);
        }
    }
}
