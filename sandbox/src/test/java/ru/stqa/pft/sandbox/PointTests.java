package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {


  @Test
  public void testDistancePositiveScenario() {
    Point a = new Point(0, 0);
    Point b = new Point(3, 4);
    Assert.assertEquals(a.distance(b), 5.0, 0.0001);
  }

  @Test
  public void testDistanceSamePoint() {
    Point a = new Point(2.5, -1.3);
    Assert.assertEquals(a.distance(a), 0.0, 0.0001);
  }

  @Test
  public void testDistanceNegativeCoordinates() {
    Point a = new Point(-1, -1);
    Point b = new Point(-4, -5);
    Assert.assertEquals(a.distance(b), 5.0, 0.0001);
  }

  @Test
  public void testDistanceZeroCoordinates() {
    Point a = new Point(0, 0);
    Point b = new Point(0, 7);
    Assert.assertEquals(a.distance(b), 7.0, 0.0001);
  }

  @Test
  public void testDistanceFractionalCoordinates() {
    Point a = new Point(1.1, 2.2);
    Point b = new Point(4.1, 6.2);
    Assert.assertEquals(a.distance(b), 5.0, 0.0001);
  }

  @Test(expectedExceptions = NullPointerException.class)
  public void testDistanceWithNull() {
    Point a = new Point(1, 1);
    a.distance(null);
  }

  @Test
  public void testDistanceWithNaN() {
    Point a = new Point(Double.NaN, 0);
    Point b = new Point(0, 0);
    Assert.assertTrue(Double.isNaN(a.distance(b)));
  }

  @Test
  public void testDistanceWithInfinity() {
    Point a = new Point(Double.POSITIVE_INFINITY, 0);
    Point b = new Point(0, 0);
    Assert.assertEquals(a.distance(b), Double.POSITIVE_INFINITY);
  }

  @Test
  public void testDistanceSmallValues() {
    Point a = new Point(0.0001, 0.0001);
    Point b = new Point(0.0002, 0.0002);
    double expected = Math.sqrt(2) * 0.0001;
    Assert.assertEquals(a.distance(b), expected, 1e-10);
  }

  @Test
  public void testPointUnchangedAfterDistance() {
    Point a = new Point(1, 2);
    double originalX = a.x;
    double originalY = a.y;
    a.distance(new Point(3, 4));
    Assert.assertEquals(a.x, originalX);
    Assert.assertEquals(a.y, originalY);
  }

  @Test
  public void testDistanceNegativeDifference() {
    Point a = new Point(5, 5);
    Point b = new Point(2, 1);
    Assert.assertEquals(a.distance(b), 5.0, 0.0001);


  }
}
