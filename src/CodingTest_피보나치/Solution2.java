package CodingTest_피보나치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution2 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str = bf.readLine();

        int i = Integer.parseInt(str);

        solution2(i);

    }

    // ArrayList를 이용한 피보나치 수열 계산

    public static int solution2(int n) {

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(1);

        for(int i = 1; i < n; i++){
            arr.add(arr.get(i)+arr.get(i-1));
        }

        System.out.println(arr.get(n));
        return arr.get(n);

    }

}
