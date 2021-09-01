package JavaProgrammingChapter1;

public class FindWord {

    public void findWord(String input) {
        String word = "Turkeys,Ducks and Quails";
        int index = input.indexOf(word);
        while (true) {
        if (index == -1 || index >= input.length() - 3) {
            System.out.println("index after updating " + index);
            break;
        }
            String found = input.substring(index, index+24);
            System.out.println(found);
            index = input.indexOf(word, index+24);

        }
    }
}


