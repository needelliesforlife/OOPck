package Tuan1_Chao_hoi;

public class IfElseDemo {
    public static void main(String[] args) {
        int testscore = 76;
        char grade;
        if (testscore >= 90) {
            grade = 'A';
        }
        else if (testscore >= 80) {
            grade = 'B';
        }
        else if (testscore >= 70) {
            grade = 'C';
        }
        else {
            grade = 'F';
        }
        System.out.println("Your grade is " + grade);
    }
}
