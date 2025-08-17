package TCSCodeVita;
import java.io.*;
import java.util.*;

public class BubbleTrouble {

    // Integer point for exact geometry on tax-line intersections
    static class PtI {
        long x, y;
        PtI(long x, long y) { this.x = x; this.y = y; }
    }

    static class Circle {
        long cx, cy;
        double r;
        Circle(long cx, long cy, double r) { this.cx = cx; this.cy = cy; this.r = r; }
    }

    static class Edge {
        int u, v; // 0-based indices of buildings
        Edge(int u, int v) { this.u = u; this.v = v; }
    }

    // --------- Fast input ----------
    static class FastScanner {
        BufferedReader br; StringTokenizer st;
        FastScanner(InputStream is){ br = new BufferedReader(new InputStreamReader(is)); }
        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
    }

    // --------- Geometry helpers ----------
    static double sq(double a) { return a * a; }

    static boolean pointInsideInflated(Circle b, double rv, PtI p) {
        double R = b.r + rv;
        double dx = p.x - b.cx, dy = p.y - b.cy;
        return dx*dx + dy*dy < R * R - 1e-12; // strictly inside → impossible
    }

    static long orient(PtI a, PtI b, PtI c) {
        // Exact integer cross product: (b-a) x (c-a)
        return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
    }

    static boolean onSegmentInclusive(PtI a, PtI b, PtI p) {
        if (orient(a, b, p) != 0) return false;
        return Math.min(a.x, b.x) <= p.x && p.x <= Math.max(a.x, b.x)
                && Math.min(a.y, b.y) <= p.y && p.y <= Math.max(a.y, b.y);
    }

    // Count as a crossing iff the segments intersect in their interiors (not just touching at endpoints)
    static boolean crossesWithCost(PtI a, PtI b, PtI c, PtI d) {
        long o1 = orient(a, b, c);
        long o2 = orient(a, b, d);
        long o3 = orient(c, d, a);
        long o4 = orient(c, d, b);

        // Proper intersection
        if ((o1 > 0 && o2 < 0 || o1 < 0 && o2 > 0) &&
                (o3 > 0 && o4 < 0 || o3 < 0 && o4 > 0)) {
            return true;
        }

        // If colinear → check overlap
        if (o1 == 0 && onSegmentInclusive(a, b, c)) {
            return !(c.x == a.x && c.y == a.y) && !(c.x == b.x && c.y == b.y);
        }
        if (o2 == 0 && onSegmentInclusive(a, b, d)) {
            return !(d.x == a.x && d.y == a.y) && !(d.x == b.x && d.y == b.y);
        }
        if (o3 == 0 && onSegmentInclusive(c, d, a)) {
            return !(a.x == c.x && a.y == c.y) && !(a.x == d.x && a.y == d.y);
        }
        if (o4 == 0 && onSegmentInclusive(c, d, b)) {
            return !(b.x == c.x && b.y == c.y) && !(b.x == d.x && b.y == d.y);
        }

        return false;
    }


    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int S = fs.nextInt(); // square size (not used further)

        long sx = fs.nextInt(), sy = fs.nextInt(); double rv = fs.nextInt();
        long tx = fs.nextInt(), ty = fs.nextInt();

        int N = fs.nextInt();
        Circle[] buildings = new Circle[N];
        for (int i = 0; i < N; i++) {
            long bx = fs.nextInt(), by = fs.nextInt(); int brad = fs.nextInt();
            buildings[i] = new Circle(bx, by, brad);
        }

        int T = fs.nextInt();
        Edge[] edges = new Edge[T];
        for (int i = 0; i < T; i++) {
            int a = fs.nextInt(), b = fs.nextInt();
            edges[i] = new Edge(a - 1, b - 1); // to 0-based
        }

        PtI start = new PtI(sx, sy);
        PtI goal  = new PtI(tx, ty);

        // If start or destination is inside any inflated building → Impossible
        for (Circle c : buildings) {
            if (pointInsideInflated(c, rv, start) || pointInsideInflated(c, rv, goal)) {
                System.out.println("Impossible");
                return;
            }
        }

        int crossings = 0;
        for (Edge e : edges) {
            PtI a = new PtI(buildings[e.u].cx, buildings[e.u].cy);
            PtI b = new PtI(buildings[e.v].cx, buildings[e.v].cy);
            if (crossesWithCost(start, goal, a, b)) crossings++;
        }

        System.out.println(crossings);
    }
}

