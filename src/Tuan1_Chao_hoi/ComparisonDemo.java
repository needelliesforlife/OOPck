package Tuan1_Chao_hoi;

public class ComparisonDemo {
    public static void main(String[] args) {
        int val1 = 1;
        int val2 = 2;
        System.out.println("value 1 == value 2: "+ (val1 == val2));
        System.out.println("value 1 != value 2: "+ (val1 != val2));
        System.out.println("value 1 > value 2: "+ (val1 > val2));
        System.out.println("value 1 < value 2: "+ (val1 < val2));
        System.out.println("value 1 <= value 2: "+ (val1 <= val2));
        System.out.println("(value 1 <= value 2) && (value 1 == value 2): " + ((val1 <= val2) && (val1 == val2)));
        System.out.println("(value 1 <= value 2) || (value 1 == value 2): " + ((val1 <= val2) || (val1 == val2)));
    }
}
