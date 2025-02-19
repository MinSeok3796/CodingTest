package CodingTest_피로도;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static boolean[] visited; //방문 여부를 저장할 배열
    static int maxDungeonCount = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("던전 입장시 제공되는 피로도를 입력해주세요 :");
        int k = Integer.parseInt(bf.readLine());

        System.out.println("탐험할 던전의 수를 입력해주세요 :");
        int count = Integer.parseInt(bf.readLine());

        int[][] dungeons = new int[count][2];

        for(int i = 0; i < count; i++) {
            System.out.println("던전의 최소 필요 피로도를 입력하세요 :");
            int mini = Integer.parseInt(bf.readLine());
            System.out.println("던전의 소모 피로도를 입력하세요 :");
            int waste = Integer.parseInt(bf.readLine());
            dungeons[i][0] = mini;
            dungeons[i][1] = waste;
        }

        solution(k, dungeons);

        System.out.println(maxDungeonCount);
    }

    public static int solution(int k, int[][] dungeons){
        visited = new boolean[dungeons.length];  // 던전 개수 만큼의 방문 배열을 생성
        dfs(k, dungeons, 0); // DFS 탐색 시작  ->  k는 보유 피로도, dungeons는 던전, 0은 탐험수를 나타냄
        return maxDungeonCount;
    }

    public static void dfs(int k, int[][] dungeons, int count){
        // 현재까지 탐험한 던전의 수를 갱신
        maxDungeonCount = Math.max(maxDungeonCount, count);

        for(int i =0 ; i < dungeons.length ; i++){
            if(!visited[i] && k >= dungeons[i][0]){ // 방문하지 않고, 최소 필요 피로도 이상일때
                visited[i] = true;
                dfs(k-dungeons[i][1], dungeons, count+1); //피로도 소모 후 DFS 다시 호출
                visited[i] = false; // 백트래킹 (원상복구)
            }
        }
    }
}
