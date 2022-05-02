package inflearn.chapter9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Player implements Comparable<Player> {

  int height;
  int weight;

  public Player(int height, int weight) {
    this.height = height;
    this.weight = weight;
  }

  @Override
  public int compareTo(Player o) {
    return o.height - this.height;
  }
}

// 1. 씨름 선수 N(5 <= N <= 30,000)
//5
//172 67
//183 65
//180 70
//170 72
//181 60
public class Solution1 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    List<Player> players = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      players.add(new Player(sc.nextInt(), sc.nextInt()));
    }

    System.out.println(solution(players, n));
  }

  private static int solution(List<Player> players, int n) {
    int answer = 0;
    Collections.sort(players);
    int max = Integer.MIN_VALUE;
    for (Player p : players) {
      if (p.weight > max) {
        answer++;
        max = p.weight;
      }
    }

    return answer;
  }
}
