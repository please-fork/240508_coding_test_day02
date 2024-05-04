// package boj17219;

import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws Exception {
       // 입력
       // 입력 파일로부터 데이터를 읽어오기 위해 파일 입력 스트림 설정 (주석 처리됨)
       // System.setIn(new FileInputStream("src/input.txt"));
       
       // BufferedReader를 사용하여 입력 데이터 읽기
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       // 첫 번째 줄에서 N과 M 값을 읽어와 정수로 변환
       String[] arr = br.readLine().split(" ");
       int N = Integer.parseInt(arr[0]);  // 저장된 사이트 주소의 수
       int M = Integer.parseInt(arr[1]);  // 비밀번호를 찾으려는 사이트 주소의 수
       
       // 사이트 주소와 비밀번호를 저장할 HashMap 생성
       Map<String, String> map = new HashMap<>();
       
       // N개의 줄에 걸쳐 사이트 주소와 비밀번호를 입력받아 HashMap에 저장
       for (int i = 0; i < N; i++) {
           arr = br.readLine().split(" ");
           map.put(arr[0], arr[1]);
       }
       
       // 출력을 위한 BufferedWriter 생성
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
       // M개의 줄에 걸쳐 비밀번호를 찾으려는 사이트 주소를 입력받아 해당 비밀번호를 출력
       for (int i = 0; i < M; i++) {
           bw.write(map.get(br.readLine())+ "\n");
       }
       
       bw.flush();  // 출력 버퍼 플러시
       bw.close();  // 출력 스트림 닫기
   }
}