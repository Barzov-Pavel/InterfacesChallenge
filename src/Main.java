import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Player Name = new Player("Name", 100, 80);
        System.out.println(Name);
        saveObject(Name);

        Name.setHitPoint(80);
        System.out.println(Name);
        Name.setWeapon("Machine gun");
        saveObject(Name);
        loadObject(Name);
        System.out.println(Name);

        Monster Pikachy = new Monster("Pikachy", 100, 100);
        System.out.println(Pikachy);
        saveObject(Pikachy);
    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    public static void saveObject(Saveable objectToSave) {
        for (int i = 0; i < objectToSave.write().size(); i++) {
            System.out.println("Saving " + objectToSave.write().get(i) + " storage device");
        }
    }

    public static void loadObject(Saveable objectToLoad) {
        List<String> values = readValues();
        objectToLoad.read(values);
    }
}
