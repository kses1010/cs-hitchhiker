package inflearn.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Coordinate {

  int x;
  int y;

  public Coordinate(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}

class Point implements Comparable<Point> {

  int x;
  int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int compareTo(Point o) {
    if (this.x == o.x) {
      return this.y - o.y;
    } else {
      return this.x - o.x;
    }
  }
}


// 7. 좌표 정렬
public class Solution7 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    List<Coordinate> coordinates = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      String[] s = br.readLine().split(" ");
      int x = Integer.parseInt(s[0]);
      int y = Integer.parseInt(s[1]);
      coordinates.add(new Coordinate(x, y));
    }

    List<Coordinate> solution = solution(coordinates);
    for (Coordinate coordinate : solution) {
      System.out.println(coordinate.x + " " + coordinate.y);
    }
  }

  private static List<Coordinate> solution(List<Coordinate> coordinates) {
    coordinates.sort(Comparator.comparing(Coordinate::getX).thenComparing(Coordinate::getY));
    return coordinates;
  }
}
