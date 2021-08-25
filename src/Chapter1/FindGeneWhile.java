package Chapter1;

public class FindGeneWhile {

    public String findGene(String dna) {

        int startIndex = dna.indexOf("ATG");
        int currIndex = dna.indexOf("TAA", startIndex + 3);
        //유전자의 조건1

        while (currIndex != -1) {
            if ((currIndex - startIndex) % 3 == 0) { // 유전자의 조건2
                return dna.substring(startIndex, currIndex + 3);
            } else {
                currIndex = dna.indexOf("TAA", currIndex + 1);
            }
        }
        return "";
    }

    public void test() {
        FindGeneWhile findGeneWhile = new FindGeneWhile();
        //given
        String dna = "ACCCTTTATAATGAACCCTTTTTAACATTTAACCCCCCC";
        String result = findGeneWhile.findGene(dna);
        System.out.println(result);
    }
}

