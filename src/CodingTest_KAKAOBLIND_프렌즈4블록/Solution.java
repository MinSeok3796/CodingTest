package CodingTest_KAKAOBLIND_프렌즈4블록;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 사용자 입력 받기
        System.out.print("m 입력: ");
        int m = sc.nextInt();
        System.out.print("n 입력: ");
        int n = sc.nextInt();
        sc.nextLine(); // 개행 문자 소비

        String[] board = new String[m];
        System.out.println("보드 입력:");
        for (int i = 0; i < m; i++) {
            board[i] = sc.nextLine();
        }

        // Solution 실행
        Solution sol = new Solution();
        int result = sol.solution(m, n, board);

        System.out.println("제거된 블록 수: " + result);

        sc.close();
    }

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        boolean Pass = true;

        // 가로, 세로 m, n의 2차원 배열 정의
        char[][] block = new char[m][n];

        // 보드에 각각의 값 주입
        for (int i = 0; i < board.length; i++) {
            block[i] = board[i].toCharArray();
        }

        // 중복되지 않도록 제거할 블록을 저장하는 HashSet
        HashSet<Pair> delete = new HashSet<>();

        while (Pass) {
            Pass = false;
            delete.clear();

            // 없어질 블록 정의
            for (int x = 0; x < m - 1; x++) {
                for (int y = 0; y < n - 1; y++) {
                    if (block[x][y] == '0') continue;

                    if (block[x][y] == block[x][y + 1] &&
                            block[x][y] == block[x + 1][y] &&
                            block[x][y] == block[x + 1][y + 1]) {

                        delete.add(new Pair(x, y));
                        delete.add(new Pair(x, y + 1));
                        delete.add(new Pair(x + 1, y));
                        delete.add(new Pair(x + 1, y + 1));
                    }
                }
            }

            // 블록 삭제 및 카운트 증가
            for (Pair p : delete) {
                if (block[p.x][p.y] != '0') {
                    block[p.x][p.y] = '0';
                    answer++;
                    Pass = true;
                }
            }

            // 블록 떨어뜨리기 (중력 적용)
            for (int y = 0; y < n; y++) {
                for (int x = m - 1; x > 0; x--) {
                    if (block[x][y] == '0') {
                        for (int k = x - 1; k >= 0; k--) {
                            if (block[k][y] != '0') {
                                block[x][y] = block[k][y];
                                block[k][y] = '0';
                                break;
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }
}

// HashSet에서 중복 처리를 위해 equals() 및 hashCode() 오버라이딩
class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pair pair = (Pair) obj;
        return x == pair.x && y == pair.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
