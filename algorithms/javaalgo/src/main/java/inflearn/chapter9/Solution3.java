package inflearn.chapter9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Timeline implements Comparable<Timeline> {

  int time;
  char state;

  public Timeline(int time, char state) {
    this.time = time;
    this.state = state;
  }

  @Override
  public int compareTo(Timeline o) {
    if (this.time == o.time) {
      return this.state - o.state;
    }
    return this.time - o.time;
  }
}

// 3. 결혼식
//5
//14 18
//12 15
//15 20
//20 30
//5 14
public class Solution3 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    List<Timeline> lists = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int start = sc.nextInt();
      int end = sc.nextInt();
      lists.add(new Timeline(start, 's'));
      lists.add(new Timeline(end, 'e'));
    }

    System.out.println(solution(lists));
  }

  private static int solution(List<Timeline> lists) {
    int answer = Integer.MIN_VALUE;
    Collections.sort(lists);
    int count = 0;
    for (Timeline t : lists) {
      if (t.state == 's') {
        count++;
      } else {
        count--;
      }
      answer = Math.max(answer, count);
    }

    return answer;
  }
}
