package JavaProgrammingChapter2;

import java.util.Random;

/**
 * 2개의 주사위를 굴렸을때 나온 값을 합하여 어느값이 많이 나오는지 확률을 계산하는 코드
 */
public class DiceRolling {

    public void simulate(int rolls) {
        Random random = new Random();
        int[] counts = new int[13]; //index의 범위는 0~12

        for (int k = 0; k < rolls; k++) {
            int d1 = random.nextInt(6) + 1;
            int d2 = random.nextInt(6) + 1;
//            int d1 = (int) (Math.random()*6 + 1);
//            int d2 = (int) (Math.random()*6 + 1);
            System.out.println("roll is "+d1+"+"+d2+"="+(d1+d2));
            counts[d1 + d2] ++;
        }

        for (int k = 2; k <= 12; k++) {
            System.out.println(k + "'s=\t" + counts[k]+"\t"+100.0 * counts[k]/rolls);
        }
    }
}
