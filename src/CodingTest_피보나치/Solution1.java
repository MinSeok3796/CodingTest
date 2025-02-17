package CodingTest_피보나치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution1 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str = bf.readLine();

        int i = Integer.parseInt(str);

        solution1(i);


    }

    // 단순 반복문을 이용한 피보나치 수열 계산

    public static int solution1(int n) {
        int f0 = 0;
        int f1 = 1;
        int f2 = 2;

        for (int i = 1; i < n; i++) {
            f2 = (f0 + f1) % 1234567;
            f0 = f1;
            f1 = f2;
        }
        System.out.println(f2);
        return f2;
    }


}