// package boj1620;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Exception {
        // 입력 파일로부터 데이터를 읽어오기 위해 파일 입력 스트림 설정
        // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄에서 N과 M 값을 읽어와 정수 배열로 변환
        int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = arr[0];  // 포켓몬 도감에 수록된 포켓몬의 개수
        int M = arr[1];  // 맞춰야 하는 문제의 개수
        
        // 포켓몬 이름을 키로, 포켓몬 번호를 값으로 가지는 HashMap 생성
        Map<String, String> strToInt = new HashMap<>();
        
        // 포켓몬 번호를 키로, 포켓몬 이름을 값으로 가지는 HashMap 생성
        Map<String, String> intToStr = new HashMap<>();
        
        // N개의 줄에 걸쳐 포켓몬 이름을 입력받아 두 HashMap에 저장
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            strToInt.put(name, Integer.toString(i));
            intToStr.put(Integer.toString(i), name);
        }
        
        // 출력을 위한 BufferedWriter 생성
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // M개의 줄에 걸쳐 문제를 입력받아 정답을 출력
        for (int i = 0; i < M; i++) {
            String key = br.readLine();
            
            // 입력이 포켓몬 이름인 경우
            if (strToInt.containsKey(key)) {
                bw.write(strToInt.get(key) + "\n");
            } 
            // 입력이 포켓몬 번호인 경우
            else {
                bw.write(intToStr.get(key) + "\n");
            }
            
            bw.flush();  // 출력 버퍼 플러시
        }
        
        bw.close();  // 출력 스트림 닫기
    }
}