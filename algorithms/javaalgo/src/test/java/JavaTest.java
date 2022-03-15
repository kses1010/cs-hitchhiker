import org.junit.jupiter.api.Test;

public class JavaTest {

  @Test
  void integerTest() {
    int a = 1;
    Integer b = new Integer(1);
    Integer c = new Integer(1);

    System.out.println(a == b);
    System.out.println(a == c);
    System.out.println(b == c);
  }

  @Test
  void integerTest2() {
    int a = 1;
    Integer b = 1;
    System.out.println(changeInteger(a));
    System.out.println(changeInteger(b));
  }

  private static int changeInteger(int num) {
    return num += 10;
  }

  @Test
  void stringTest() {
    String a, b;
    a = "hi";
    b = "hi";
    System.out.println(a == b);
    System.out.println(a.equals(b));
  }

  @Test
  void stringTest2() {
    String a = new String("hi");
    String b = "hi";
    System.out.println(a == b);
    System.out.println(a.equals(b));
  }
}
