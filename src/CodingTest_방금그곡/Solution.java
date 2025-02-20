package CodingTest_방금그곡;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("기억한 멜로디를 입력하세요:");
        String m = scanner.nextLine();

        System.out.println("곡 정보의 개수를 입력하세요:");
        int n = Integer.parseInt(scanner.nextLine());
        String[] musicinfos = new String[n];

        System.out.println("곡 정보를 입력하세요 (시작시간, 종료시간, 제목, 악보):");
        for (int i = 0; i < n; i++) {
            musicinfos[i] = scanner.nextLine();
        }

        System.out.println("결과: " + solution(m, musicinfos));
    }

    public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxPlayTime = 0;

        // 기억한 멜로디 변환 (C# -> H 등)
        m = convertSharpNotes(m);

        for (String info : musicinfos) {
            String[] parts = info.split(",");
            String start = parts[0];
            String end = parts[1];
            String title = parts[2];
            String melody = convertSharpNotes(parts[3]);

            // 재생된 시간 계산
            int playTime = getPlayTime(start, end);
            String playedMelody = getPlayedMelody(melody, playTime);

            // 기억한 멜로디 포함 여부 체크
            if (playedMelody.contains(m) && playTime > maxPlayTime) {
                maxPlayTime = playTime;
                answer = title;
            }
        }
        return answer;
    }

    // "#"이 붙은 음을 단일 문자로 변환
    private static String convertSharpNotes(String melody) {
        return melody.replace("C#", "H")
                .replace("D#", "I")
                .replace("F#", "J")
                .replace("G#", "K")
                .replace("A#", "L")
                .replace("B#", "M");
    }

    // 재생된 시간을 분 단위로 계산
    private static int getPlayTime(String start, String end) {
        String[] startParts = start.split(":");
        String[] endParts = end.split(":");
        int startMinutes = Integer.parseInt(startParts[0]) * 60 + Integer.parseInt(startParts[1]);
        int endMinutes = Integer.parseInt(endParts[0]) * 60 + Integer.parseInt(endParts[1]);
        return endMinutes - startMinutes;
    }

    // 주어진 플레이 시간만큼 멜로디 반복 생성
    private static String getPlayedMelody(String melody, int playTime) {
        StringBuilder sb = new StringBuilder();
        int melodyLen = melody.length();

        for (int i = 0; i < playTime; i++) {
            sb.append(melody.charAt(i % melodyLen)); // 멜로디 반복
        }
        return sb.toString();
    }
}
