package Chapter1;

import java.io.File;

public class FindGeneSimpleAndTest {

    String dna = "AAATGCCCTAACTAGATTAAGAAACC";
    public void findGeneSimple() {
        //개시코돈 : "ATG"
        //종결코돈 : "TAA"
        String result = ""; //null로 초기화
        int startIndex = dna.indexOf("ATG"); //indexOf 에서 자체적으로 에러를 잡는다.
//        if (startIndex == -1) {
//            System.out.println();
//            return;
//        }
        int stopIndex = dna.indexOf("TAA",startIndex+3);
        // ATG이후 부터 검색해야하므로 startIndex+3
        result = dna.substring(startIndex,stopIndex+3);
//        if (stopIndex == -1) {
//            System.out.println();
//            return;
//        }
        System.out.println(result);
    }
}
