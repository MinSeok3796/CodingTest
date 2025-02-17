package CodingTest_피보나치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str = bf.readLine();

        int i = Integer.parseInt(str);

        int i1 = solution3(i);

        System.out.println(i1);
    }
    // 재귀 함수를 통한 피보나치 수열 계산
    public static int solution3(int n) {

        if(n < 2){
            return n;
        }


        return solution3(n-1) + solution3(n-2);

    }
}
