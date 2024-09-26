package com.corndel.exercises;

public class Circle implements Shape {
  private double radius;

  Circle(double radius) {
    this.radius = radius;
  }

  @Override
  public double getArea() {

    // pi * radius2
    return(Math.PI *  Math.pow(this.radius,2));
  };

  @Override
  public double getPerimeter() {
    // 2 * pi * radius
    return (2 * Math.PI * this.radius);
  };

  public double getRadius() {
    return radius;
  }
}
