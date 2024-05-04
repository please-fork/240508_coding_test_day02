// package boj7785;

import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws Exception {
       // 입력 파일로부터 데이터를 읽어오기 위해 파일 입력 스트림 설정
       // System.setIn(new FileInputStream("src/input.txt"));
       
       // BufferedReader를 사용하여 입력 데이터 읽기
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       // 첫 번째 줄에서 출입 기록의 수 n 읽어오기
       int n = Integer.parseInt(br.readLine());
       
       // 현재 회사에 있는 사람들의 이름을 저장할 HashSet 생성
       Set<String> set = new HashSet<>();
       
       // n개의 줄에 걸쳐 출입 기록 읽어오기
       for (int i = 0; i < n; i++) {
           // 각 줄의 출입 기록을 공백으로 분리하여 배열에 저장
           String[] s = br.readLine().split(" ");
           
           // 두 번째 단어가 "enter"인 경우 HashSet에 이름 추가
           if (s[1].equals("enter")) {
               set.add(s[0]);
           } 
           // 두 번째 단어가 "leave"인 경우 HashSet에서 이름 제거
           else {
               set.remove(s[0]);
           }
       }
       
       // HashSet의 이름들을 배열로 변환
       String[] result = set.toArray(new String[set.size()]);
       
       // 배열을 내림차순으로 정렬
       Arrays.sort(result, Comparator.reverseOrder());
       
       // 출력을 위한 BufferedWriter 생성
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
       // 현재 회사에 있는 사람들의 이름을 사전의 역순으로 한 줄에 한 명씩 출력
       for (String v : result) {
           bw.write(v + "\n");
       }
       
       bw.flush();  // 출력 버퍼 플러시
       bw.close();  // 출력 스트림 닫기
   }
}