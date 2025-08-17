package TCSCodeVita;
import java.io.*;
import java.util.*;

public class FruitBowl {
    static class Point implements Comparable<Point> {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }
        public int compareTo(Point p) {
            return this.x != p.x ? this.x - p.x : this.y - p.y;
        }
    }

    static long cross(Point O, Point A, Point B) {
        return (long)(A.x - O.x) * (B.y - O.y) - (long)(A.y - O.y) * (B.x - O.x);
    }

    static double dist(Point a, Point b) {
        return Math.hypot(a.x - b.x, a.y - b.y);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        Point[] points = new Point[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x, y);
        }

        Arrays.sort(points);
        ArrayList<Point> lower = new ArrayList<>();

        for (Point p : points) {
            while (lower.size() >= 2 && cross(lower.get(lower.size()-2), lower.get(lower.size()-1), p) <= 0) {
                lower.remove(lower.size()-1);
            }
            lower.add(p);
        }

        double perimeter = 0;
        for (int i = 0; i < lower.size()-1; i++) {
            perimeter += dist(lower.get(i), lower.get(i+1));
        }

        System.out.println(Math.round(perimeter));
    }
}
