package inflearn.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Person {
  int id;
  int priority;

  public Person(int id, int priority) {
    this.id = id;
    this.priority = priority;
  }
}

// 8. 응급실
//5 2
//60 50 70 80 90
public class Solution8 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] splits = br.readLine().split(" ");
    int n = Integer.parseInt(splits[0]);
    int m = Integer.parseInt(splits[1]);
    int[] patients = new int[n];

    String[] strs = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      patients[i] = Integer.parseInt(strs[i]);
    }

    System.out.println(solution(n, m, patients));
  }

  private static int solution(int n, int m, int[] patients) {
    int answer = 0;
    Queue<Person> q = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      q.offer(new Person(i, patients[i]));
    }

    while (!q.isEmpty()) {
      Person tmp = q.poll();
      for (Person x : q) {
        if (x.priority > tmp.priority) {
          q.offer(tmp);
          tmp = null;
          break;
        }
      }
      if (tmp != null) {
        answer++;
        if (tmp.id == m) {
          return answer;
        }
      }
    }

    return answer;
  }
}
