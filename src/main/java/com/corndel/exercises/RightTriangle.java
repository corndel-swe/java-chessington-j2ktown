package com.corndel.exercises;

public class RightTriangle implements Shape {
  private double base;
  private double height;

  RightTriangle(double base, double height) {
    this.base = base;
    this.height = height;
  }
  @Override
  public double getArea(){
    return (this.base * this.height)/2;
  };

  @Override
  public double getPerimeter(){
    double edge = Math.sqrt(base * base + height * height);
    return base + height + edge;

  };

  public double getBase() {
    return this.base;
  }

  public double getHeight() {
    return this.height;
  }

  public double getHypotenuse() {
    return Math.sqrt(base * base + height * height);
  }
}
