package TCSCodeVita;

import java.util.*;

public class Bands2 {

    static class Cell {
        int x, y;
        Cell(int x, int y) { this.x = x; this.y = y; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Cell)) return false;
            Cell c = (Cell) o;
            return x == c.x && y == c.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static List<Cell> simulatePath(int startX, int startY, String path) {
        List<Cell> cells = new ArrayList<>();
        int x = startX, y = startY;
        cells.add(new Cell(x, y));

        for (char c : path.toCharArray()) {
            if (c == 'u') x--;
            else if (c == 'd') x++;
            else if (c == 'l') y--;
            else if (c == 'r') y++;
            cells.add(new Cell(x, y));
        }
        return cells;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int S = Integer.parseInt(sc.nextLine().trim());

        int startX1 = sc.nextInt();
        int startY1 = sc.nextInt();
        sc.nextLine();
        String path1 = sc.nextLine().trim();

        int startX2 = sc.nextInt();
        int startY2 = sc.nextInt();
        sc.nextLine();
        String path2 = sc.nextLine().trim();

        List<Cell> band1 = simulatePath(startX1, startY1, path1);
        List<Cell> band2 = simulatePath(startX2, startY2, path2);

        Map<Cell, Integer> overlapMap = new HashMap<>();
        int overlapCount = 0;
        int consistentTop = 0;

        int minLen = Math.min(band1.size(), band2.size());
        Map<Cell, Integer> band1Pos = new HashMap<>();
        for (int i = 0; i < band1.size(); i++) {
            band1Pos.put(band1.get(i), i);
        }
        Map<Cell, Integer> band2Pos = new HashMap<>();
        for (int i = 0; i < band2.size(); i++) {
            band2Pos.put(band2.get(i), i);
        }

        for (Cell c : band1) {
            if (band2Pos.containsKey(c)) {
                overlapCount++;
                int pos1 = band1Pos.get(c);
                int pos2 = band2Pos.get(c);

                int top = (pos1 < pos2) ? 2 : 1;

                if (consistentTop == 0) {
                    consistentTop = top;
                } else if (consistentTop != top) {
                    System.out.println("Impossible");
                    return;
                }
            }
        }

        if (overlapCount == 0) {
            System.out.println(0);
        } else {
            System.out.println(overlapCount);
        }
    }
}
