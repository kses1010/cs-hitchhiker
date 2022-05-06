package inflearn.chapter9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Lecture implements Comparable<Lecture> {

  int money;
  int time;

  public Lecture(int money, int time) {
    this.money = money;
    this.time = time;
  }

  @Override
  public int compareTo(Lecture o) {
    return o.time - this.time;
  }
}

// 4. 최대수입스케쥴(PriorityQueue)
//6
//50 2
//20 1
//40 2
//60 3
//30 3
//30 1
public class Solution4 {

  static int n = 0;
  static int max = Integer.MIN_VALUE;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    List<Lecture> lists = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int m = sc.nextInt();
      int d = sc.nextInt();
      lists.add(new Lecture(m, d));
      if (d > max) {
        max = d;
      }
    }
    System.out.println(solution(lists));
  }

  private static int solution(List<Lecture> lists) {
    int answer = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 제일 큰 수를 우선순위
    Collections.sort(lists);
    int j = 0;
    for (int i = max; i >= 1; i--) {
      for (; j < n; j++) {
        Lecture lecture = lists.get(j);
        if (lecture.time < i) {
          break;
        } else {
          pq.offer(lecture.money);
        }
      }
      if (!pq.isEmpty()) {
        answer += pq.poll();
      }
    }

    return answer;
  }
}
