package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {

    hello("World");
    hello("User");
    hello("Alexei");
    Square s = new Square(5);

    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());
    Rectangle r = new Rectangle(4, 6);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());
    // Тестовые точки

    Point a = new Point(0, 0);
    Point b = new Point(3, 4);
    Point c = new Point(2, 2);
    System.out.println("Расстояние от A(0,0) до B(3,4): " + a.distance(b));
    System.out.println("Расстояние от B(3,4) до C(2,2): " + b.distance(c));
    System.out.println("Расстояние от A(0,0) до C(2,2): " + a.distance(c));


  }

  public static void hello(String somebody) {

    System.out.println("Hello, " + somebody + "!");
  }


}





