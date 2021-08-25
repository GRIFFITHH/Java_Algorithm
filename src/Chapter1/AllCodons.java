package Chapter1;

public class AllCodons {
    public int findStopCodon(String dnaStr, int startIndex, String stopCodon) {
        //findStopCodon 은 종결코돈이 존재하는지 검증하는 메서드이다.
        // TGA TAA TAG 이 세가지 중에
        // 종결코돈의 조건을 만족하는 코돈을 찾아 그 코돈의 길이를 반환한다.
        int currIndex = dnaStr.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1) {
            int diff = currIndex - startIndex;
            if (diff % 3 == 0) {
                return currIndex;
            } else {
                currIndex = dnaStr.indexOf(dnaStr, currIndex + 1);
            }
        }
        return -1;
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
        int temp = Math.min(taaIndex, tagIndex);
        int minIndex = Math.min(temp, tgaIndex);
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
    public void test() {
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
}
