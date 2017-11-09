package com.runets.trainingproject.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Triangle {
    private static Logger Logger = LogManager.getLogger(Triangle.class);
    private int id;
    private Point a;
    private Point b;
    private Point c;

    public Triangle(int id, Point a, Point b, Point c) {
        this.id = id;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Triangle(double xA, double yA, double xB, double yB, double xC, double yC) {
        a = new Point(xA, yA);
        b = new Point(xB, yB);
        c = new Point(xC, yC);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Point getA() {
        return a;
    }
    public void setA(Point a) {
        this.a = a;
    }
    public Point getB() {
        return b;
    }
    public void setB(Point b) {
        this.b = b;
    }
    public Point getC() {
        return c;
    }
    public void setC(Point c) {
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (id != triangle.id) return false;
        if (a != null ? !a.equals(triangle.a) : triangle.a != null) return false;
        if (b != null ? !b.equals(triangle.b) : triangle.b != null) return false;
        return c != null ? c.equals(triangle.c) : triangle.c == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (a != null ? a.hashCode() : 0);
        result = 31 * result + (b != null ? b.hashCode() : 0);
        result = 31 * result + (c != null ? c.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "id=" + id +
                ", a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
