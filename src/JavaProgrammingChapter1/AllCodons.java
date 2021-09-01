package JavaProgrammingChapter1;

public class AllCodons { // 모든 유전자를 찾는 클래스.

    //유전자의 조건 1. 종결코돈을 가져야 함
    //유전자의 조건 2. 개시코돈과 종결코돈 사이는 유전자길이가 3의 배수여야함
    //유전자의 조건 3. 위의 조건을 만족할때 개시코돈과 종결코돈의 사이가 가장 가까운것이 유전자
    // 아래는 종결코돈의 자격을 갖고있는지 검증하는 코드
    public int findStopCodon(String dnaStr,
                             int startIndex,
                             String stopCodon) {
        // dnaStr 유전자안에 해당 종결코돈 stopCodon(TAA,TGA,TAG)가 존재하는지 확인해야함
        //개시코돈의 유무는 여기선 확인안해도 됨
        // findStopCodon 은 종결코돈이 존재하는지 검증하는 메서드이다.
        // TGA TAA TAG 이 세가지 중에
        // 종결코돈의 조건을 만족하는 코돈을 찾아 그 코돈의 길이를 반환한다.
        int currIndex = dnaStr.indexOf(stopCodon, startIndex + 3);
        //개시코돈 이후로 종결코돈의 시작인덱스를 찾는다.
        while (currIndex != -1) { // 종결코돈의 후보군을 찾으면 while문 실행
            int diff = currIndex - startIndex; // 유전자 조건2를 만족하는지 확인
            if (diff % 3 == 0) {
                return currIndex; // 종결코돈의 조건을 만족하면 해당 종결코돈의 인덱스를 반환
            } else {
                currIndex = dnaStr.indexOf(stopCodon , currIndex + 1);
            }
        }
        return dnaStr.length();
    }

    //유전자 찾는 메서드 1
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
    //유전자를 찾는 메서드2
    //위에서 만든 '유전자를 찾는 메서드1' 은 첫번째 개시코돈만을 찾을수 있다. 중간에 등장하는 개시코돈은 찾을수 없다.
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

    //이후는 findGenes를 응용한 메서드들

    public void findAllGene(String dna) {//유전자길이가 60을 넘는것의 개수를 세어줌
        // 0으로 설정 , 시작위치를 알려준다
        int startIndex = 0;
        int count = 0;
        //아래의 과정을 반복
        while (true) {
            String currGene = findGene(dna, startIndex); // where를 추가해준 findGene메서드

            //유전자가 없을때
            if(currGene.isEmpty()){
                break;
            }
            //System.out.println(currGene);
            if (currGene.length() > 60) {
                count++;
            }
            startIndex = dna.indexOf(currGene, startIndex) +
                         currGene.length(); //startIndex를 첫 개시코돈을 찾고 종결코돈 바로 다음인덱스로 초기화
        }
        System.out.println(count);
    }


    public void findCgratioGreaterThan0dot35(String dna) {
        //하나의 긴 스트랜드 유전자에서
        //cgRatio가 0.35가 넘는 유전자가 몇개인지 개수를 세어줌
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
        //cgRatio를 구하는 메서드드
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
        findAllGene(dna);
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
