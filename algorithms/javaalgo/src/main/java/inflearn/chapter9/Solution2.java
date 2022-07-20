package inflearn.chapter9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Meeting implements Comparable<Meeting> {
  int start;
  int end;

  public Meeting(int start, int end) {
    this.start = start;
    this.end = end;
  }

  @Override
  public int compareTo(Meeting o) {
    if (this.end == o.end) {
      return this.start - o.start; // 오름차순(음수가 되어야 한다)
    } else {
      return this.end - o.end;
    }
  }
}

// 2. 회의실 배정
public class Solution2 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    List<Meeting> meetings = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      meetings.add(new Meeting(sc.nextInt(), sc.nextInt()));
    }

    System.out.println(solution(meetings));
  }

  private static int solution(List<Meeting> meetings) {
    int count = 0;
    Collections.sort(meetings);
    int endTime = 0;
    for (Meeting m : meetings) {
      if (m.start >= endTime) {
        count++;
        endTime = m.end;
      }
    }
    return count;
  }
}
