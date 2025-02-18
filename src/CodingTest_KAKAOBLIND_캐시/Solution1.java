package CodingTest_KAKAOBLIND_캐시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution1 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("사용하실 캐시의 크기를 지정해주세요 : ");

        int cacheSize = Integer.parseInt(bf.readLine());

        System.out.println("입력할 지역의 개수 : ");

        int cityCount = Integer.parseInt(bf.readLine());
        String[] cities = new String[cityCount];

        for(int i = 0 ; i < cityCount ; i++) {
            System.out.println("지역 이름 : ");
            cities[i] = bf.readLine();
        }
        int a = solution(cacheSize, cities);
        System.out.println(a);
    }

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> ll = new LinkedList<>();

        if (cacheSize == 0)
            return 5 * cities.length;
        // 도시를 먼저 대문자로 모두 설정
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toUpperCase();
        }

        for (String c : cities) {
            if (!ll.isEmpty()) {
                // 1. ll안에 이 값이 들어있는 경우 hit
                if (ll.contains(c)) {
                    //들어있는 값을 제거하고 다시 등록해줌에 따라 최신화 -> 오래된 것일수록 앞쪽에 위치하도록 설정
                    ll.remove(c);
                    ll.add(c);
                    answer += 1;
                } else { // else인 상황에 ll에는 c값이 들어있지 않아 이미 miss인 상황

                    if (ll.size() < cacheSize) {// 2-1 miss이지만 ll이 꽉 차지 않은 경우
                        ll.add(c);
                        answer += 5;
                    } else {// 2-2 miss 이면서 ll이 꽉 차있는 경우
                        ll.remove(0);
                        ll.add(c);
                        answer += 5;
                    }
                }
            } else { // ll이 비어있으면 무조건 miss이므로 +5
                ll.add(c);
                answer += 5;
            }
        }
        return answer;
    }


}
