package JavaProgrammingChapter1;

public class FindAbc {
    public void findAbc(String input) {
        int index = input.indexOf("abc");
        while (true) {
            if (index == -1 || index >= input.length() - 3) {
                System.out.println("index after updating " + index);
                break;

            }
            System.out.println("index " + index);
//            if (index > input.length() - 4) {
//                //The case when index = input.length() - 4 would not cause this error. Try this by constructing a test String where the final value of index is input.length() - 4.
//                break;
//            }

            String found = input.substring(index+1, index+4);
            System.out.println(found);
            index = input.indexOf("abc", index+3);
        }
    }
    public void test() {
        //no code yet
        findAbc("abcdk" +
                      "fjsks" +
                      "ioehg" +
                      "jfhsd" +
                      "jfhks" +
                      "dfhuw" +
                      "abcab" +
                      "cajfieowj");
    }
}
