package JavaProgrammingChapter1;

public class RemoveT {
    public String removeT(String dna) { // ex) dna = "aaaTaaaa";
        int pos = dna.indexOf("T"); // T가 존재하는곳 여기는 변하지않음
        int count = 0;
        int startPos = 0;
        String newDna = "";
        if (pos == -1) {
            return dna;
        }
        while (true) {
            //count += 1;
            newDna = newDna + dna.substring(startPos,pos);// T가 존재하는곳부터 제거 -> aaa
            startPos = pos+1; // 시작지점을 T바로 다음으로 설정
            pos = dna.indexOf("T", startPos);
            if (pos == -1) {
                break;
            }
        }
        newDna = newDna + dna.substring(startPos); // newDna 는 T 이전, dna.substring(startPos)는 T이후 부터 전부 가져옴
        return newDna; // -> "aaa" + "aaaa"
    }

    public String removeA(String dna) { // ex) dna = "aaaTaaaa";
        int pos = dna.indexOf("A"); // T가 존재하는곳 여기는 변하지않음
        int count = 0;
        int startPos = 0;
        String newDna = "";
        if (pos == -1) {
            return dna;
        }
        while (true) {
            //count += 1;
            newDna = newDna + dna.substring(startPos,pos);// T가 존재하는곳부터 제거 -> aaa
            startPos = pos+1; // 시작지점을 T바로 다음으로 설정
            pos = dna.indexOf("A", startPos);
            if (pos == -1) {
                break;
            }
        }
        newDna = newDna + dna.substring(startPos); // newDna 는 T 이전, dna.substring(startPos)는 T이후 부터 전부 가져옴
        return newDna; // -> "aaa" + "aaaa"
    }
}
