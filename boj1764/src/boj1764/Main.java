// package boj1764;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 입력 파일로부터 데이터를 읽어오기 위해 파일 입력 스트림 설정
        // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄에서 N과 M 값을 읽어와 정수로 변환
        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]);  // 듣도 못한 사람의 수
        int M = Integer.parseInt(arr[1]);  // 보도 못한 사람의 수
        
        // 듣도 못한 사람의 이름을 저장할 HashSet 생성
        Set<String> case1 = new HashSet<>();
        
        // N개의 줄에 걸쳐 듣도 못한 사람의 이름을 입력받아 case1에 저장
        for (int i = 0; i < N; i++) {
            case1.add(br.readLine());
        }
        
        // 보도 못한 사람의 이름을 저장할 HashSet 생성
        Set<String> case2 = new HashSet<>();
        
        // M개의 줄에 걸쳐 보도 못한 사람의 이름을 입력받아 case2에 저장
        for (int i = 0; i < M; i++) {
            case2.add(br.readLine());
        }
        
        // case1과 case2의 교집합을 구하여 듣보잡의 명단을 생성
        case1.retainAll(case2);
        
        // 듣보잡의 명단을 정렬하기 위해 String 배열로 변환
        String[] result = case1.toArray(new String[case1.size()]);
        Arrays.sort(result);
        
        // 출력을 위한 BufferedWriter 생성
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 듣보잡의 수를 출력
        bw.write(Integer.toString(result.length) + "\n");
        
        // 듣보잡의 명단을 사전순으로 출력
        for (String v : result) {
            bw.write(v + "\n");
        }

        bw.flush();        
        bw.close();  // 출력 스트림 닫기
    }
}