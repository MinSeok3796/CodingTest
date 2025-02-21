package CodingTest_최소공배수;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 배열 크기 입력 받기
        System.out.println("배열 크기를 입력하세요:");
        int n = Integer.parseInt(br.readLine().trim());

        // 배열 요소 입력 받기
        System.out.println("배열 요소를 입력하세요 (공백으로 구분):");
        int[] arr = Arrays.stream(br.readLine().trim().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 최소공배수 계산 및 출력
        System.out.println("최소공배수: " + solution(arr));
    }

    public static int solution(int[] arr) {
        int lcmValue = arr[0];  // 최소공배수를 저장할 변수

        // 배열 내 모든 숫자에 대해 최소공배수 계산
        for (int i = 1; i < arr.length; i++) {
            lcmValue = lcm(lcmValue, arr[i]);
        }

        return lcmValue;
    }

    // 최대공약수(GCD) 구하기 (유클리드 호제법)
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 최소공배수(LCM) 구하기
    private static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
