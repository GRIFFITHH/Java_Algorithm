package JavaProgrammingChapter2;

public class CaeserCipher {

    public String encrypted(String input , int key) {

        StringBuilder sb = new StringBuilder(input);

        String alphqbet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String shiftedAlphabet = alphqbet.substring(key) + alphqbet.substring(0,key);


        for (int i = 0; i < sb.length(); i++) {
            char currChar = sb.charAt(i);

            if (currChar == ' ') {
                continue;
            }

            int idx = alphqbet.indexOf(currChar); //아래의 코드와 비교해보자.. for문이 옳은것이 아니다.
            if (idx != -1) {
                char newChar = shiftedAlphabet.charAt(idx);
                sb.setCharAt(i, newChar);

            }
        }


//        for (int k = 0; k < sb.length(); k++) {
//            for(int j=0; j<alphqbet.length();j++) {
//                if (sb.charAt(k) == alphqbet.charAt(j)) {
//                    sb.insert(k, shiftedAlphabet.charAt(j));
//                }
//            }
//        }

        return sb.toString();

    }
}
