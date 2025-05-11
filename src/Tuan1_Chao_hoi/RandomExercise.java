package Tuan1_Chao_hoi;

import java.util.Random;
public class RandomExercise {
    public static void main(String[] args) {
        Random rd = new Random();
        int min = 65;
        int max = 80;
        int rdnum = rd.nextInt(max - min +1) + min;
        System.out.println("number: " + rdnum);
    }

}
