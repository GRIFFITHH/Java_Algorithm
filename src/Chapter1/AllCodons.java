package Chapter1;

public class AllCodons { // 모든 유전자를 찾는 클래스.
    public int findStopCodon(String dnaStr,
                             int startIndex,
                             String stopCodon) {
        // findStopCodon 은 종결코돈이 존재하는지 검증하는 메서드이다.
        // TGA TAA TAG 이 세가지 중에
        // 종결코돈의 조건을 만족하는 코돈을 찾아 그 코돈의 길이를 반환한다.
        int currIndex = dnaStr.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1) {
            int diff = currIndex - startIndex;
            if (diff % 3 == 0) {
                return currIndex;
            } else {
                currIndex = dnaStr.indexOf(stopCodon , currIndex + 1);
            }
        }
        return dnaStr.length();
    }

    public String findGene(String dna) {
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) {
            return "";
        }
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        //세가지 코돈에 대하여 종결코돈이 존재하는지 구함
        int minIndex = 0;
        //그중 최소길이의 코돈의 유전자 길이를 구함
        if (taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)) {
            // 1.위의 조건에서 양쪽중 하나라도 참이면 TGA가 종결 코돈일 확률이 높다.
            minIndex = tgaIndex;
        } else {
            // 1-2. 만약 양쪽 다 거짓이라면 TAA가 종결 코돈일 확률이 높다.
            minIndex = taaIndex;
        }
        if (minIndex == -1 || (tgaIndex != -1 && tagIndex < minIndex)) {
            //2. 1에서 TGA와 TAA중 종결코돈의 조건을 만족한 것 중 다시 조건을 가려본다.
            // 양쪽중 한쪽이라도 만족한다면 TAG가 종결코돈이다.
            minIndex = tagIndex;
        }
        if (minIndex == -1) {
            // 3. 마지막으로 TAG가 종결코돈인지 판별 만약에 TAG가 종결코돈이 아니라면
            // 종결 코돈이 존재하지 않는 유전자이다.
            return "";
        }
        return dna.substring(startIndex, minIndex + 3);// 그렇지 않다면 dna를 구해서 반환환
    }
    //Overload
    public String findGene(String dna , int where) { // 매개변수 where를 추가하여 중간에 존재하는 출발코돈을 찾는다.
        int startIndex = dna.indexOf("ATG" , where);

        if (startIndex == -1) {
            return "";
        }
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        //세가지 코돈에 대하여 종결코돈이 존재하는지 구함
//        int temp = Math.min(taaIndex, tagIndex);
//        int minIndex = Math.min(temp, tgaIndex);
        int minIndex = 0;
        //그중 최소길이의 코돈의 유전자 길이를 구함
        if (taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)) {
            // 1.위의 조건에서 양쪽중 하나라도 참이면 TGA가 종결 코돈일 확률이 높다.
            minIndex = tgaIndex;
        } else {
            // 1-2. 만약 양쪽 다 거짓이라면 TAA가 종결 코돈일 확률이 높다.
            minIndex = taaIndex;
        }
        if (minIndex == -1 || (tgaIndex != -1 && tagIndex < minIndex)) {
            //2. 1에서 TGA와 TAA중 종결코돈의 조건을 만족한 것 중 다시 조건을 가려본다.
            // 양쪽중 한쪽이라도 만족한다면 TAG가 종결코돈이다.
            minIndex = tagIndex;
        }
        if (minIndex == -1) {
            // 3. 마지막으로 TAG가 종결코돈인지 판별 만약에 TAG가 종결코돈이 아니라면
            // 종결 코돈이 존재하지 않는 유전자이다.
            return "";
        }
        return dna.substring(startIndex, minIndex + 3);// 그렇지 않다면 dna를 구해서 반환환    }
    }

    public void printAllGene(String dna) {
        // 0으로 설정 , 시작위치를 알려준다
        int startIndex = 0;
        int count = 0;
        //아래의 과정을 반복
        while (true) {
            String currGene = findGene(dna, startIndex);

            //유전자가 없을때
            if(currGene.isEmpty()){
                break;
            }
            //System.out.println(currGene);
            if (currGene.length() > 60) {
                count++;
            }
            startIndex = dna.indexOf(currGene, startIndex) +
                         currGene.length();
        }
        System.out.println(count);
    }


    public void findCgratioGreaterThan0dot35(String dna) {
        // 0으로 설정 , 시작위치를 알려준다
        int startIndex = 0;
        int count = 0;
        //아래의 과정을 반복
        while (true) {
            String currGene = findGene(dna, startIndex);

            //유전자가 없을때
            if(currGene.isEmpty()){
                break;
            }
            //System.out.println(currGene);

            if (findCgRatio(currGene) > 0.35) {
                ++count;
            }
            startIndex = dna.indexOf(currGene, startIndex) +
                    currGene.length();
        }
        System.out.println(count);
    }

    public void findLongestGene(String dna) {
        // 0으로 설정 , 시작위치를 알려준다
        int startIndex = 0;
        String longestGene = "";
        //아래의 과정을 반복
        while (true) {
            String currGene = findGene(dna, startIndex);

            //유전자가 없을때
            if(currGene.isEmpty()){
                break;
            }
            //System.out.println(currGene);

            if (currGene.length() >= longestGene.length()) {
                longestGene = currGene;
            }
            startIndex = dna.indexOf(currGene, startIndex) +
                    currGene.length();
        }
        System.out.println(longestGene.length());
    }

    public float findCgRatio(String gene) {
        //시작위치
        RemoveT rm = new RemoveT();
        String result1 = rm.removeA(gene);
        System.out.println(result1);
        String result2 = rm.removeT(result1);
        System.out.println(result2);

        float calc = result2.length() / (float)(gene.length());

        return calc;
    }

    public void testOn(String dna) {
        System.out.println("Testing printAllGenes on " + dna);
        printAllGene(dna);
    }
    public void test2(){
        testOn("ATGZZZZZZZZZTGAZZZZATGZZZTAA");
        testOn("");
        testOn("ATGATGCGGTCGTACGTACTAGCTAGCTAGCTAGCGATCGGTCAG");
    }

    public void test1() {
        String dna = "xxxyyyzzzTAAxxxzzzyyyTAAzz";
        int dex = findStopCodon(dna, 0, "TAA");
        // 시작인덱스:0 , TAA 를 찾아야함 findStopCodon 은 시작인덱스와 종료인덱스의 차이를 반환 따라서 (9-0)을 반환
        if(dex!=9) System.out.println("error on 9"); // dex의 인덱스는 9가 나와야함 9가 나오지 않으면 에러메세지를 뜨도록 코드를 설계
        dex = findStopCodon(dna, 9, "TAA"); // 마찬가지로 잘 작동한다면 아래의 에러메세지가 나오지 않아야 함
        if(dex!=21) System.out.println("error on 21");
        dex = findStopCodon(dna, 1, "TAA");
        if (dex != -1) System.out.println("error on 26");
        dex = findStopCodon(dna, 0, "TAG");
        if(dex != -1) System.out.println("error on 26"); else
        System.out.println("tests finished"); // 테스트가 잘 마무리 됨
    }

    public void findStopCodonTest() {

        int startIndex = 0;
        String dna = "AAAAAAAAATGA";

        int result = findStopCodon(dna, startIndex, "TGA");
        System.out.println(result);
    }

    public void findGeneTest() {

//        String result = findGene("AAAATGAAAAAAAAATGAAAS", 0);
//        System.out.println(result);
        findGene("AAAATGAAAAAAAAATGAAAS");
    }


}
