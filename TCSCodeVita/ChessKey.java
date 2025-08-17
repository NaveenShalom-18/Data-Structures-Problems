package TCSCodeVita;

import java.io.*;
import java.util.*;

public class ChessKey {

    static class Pos {
        int r, c; // 0-based row,col
        Pos(int r, int c) { this.r = r; this.c = c; }
    }

    static class State {
        Map<Character, Pos> pieces;
        State(Map<Character, Pos> pieces) {
            this.pieces = new HashMap<>();
            for (var e : pieces.entrySet()) {
                this.pieces.put(e.getKey(), new Pos(e.getValue().r, e.getValue().c));
            }
        }
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof State)) return false;
            State s = (State) o;
            if (this.pieces.size() != s.pieces.size()) return false;
            for (var e : this.pieces.entrySet()) {
                Pos p = s.pieces.get(e.getKey());
                if (p == null || p.r != e.getValue().r || p.c != e.getValue().c) return false;
            }
            return true;
        }
        @Override
        public int hashCode() {
            return pieces.entrySet().stream()
                    .map(e -> e.getKey() * 31 + e.getValue().r * 8 + e.getValue().c)
                    .reduce(0, Integer::sum);
        }
    }

    static int N = 8;
    static int[][] dirsQ = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
    static int[][] dirsR = {{1,0},{-1,0},{0,1},{0,-1}};
    static int[][] dirsB = {{1,1},{1,-1},{-1,1},{-1,-1}};

    static List<Pos> genMoves(char type, Pos p, State st) {
        List<Pos> res = new ArrayList<>();
        int[][] dirs;
        if (type == 'Q') dirs = dirsQ;
        else if (type == 'R') dirs = dirsR;
        else dirs = dirsB;

        for (int[] d : dirs) {
            int r = p.r + d[0], c = p.c + d[1];
            while (0 <= r && r < N && 0 <= c && c < N) {
                boolean occupied = false;
                for (var e : st.pieces.entrySet()) {
                    if (e.getValue().r == r && e.getValue().c == c) {
                        occupied = true;
                        break;
                    }
                }
                if (occupied) break; // cannot land or pass
                res.add(new Pos(r, c));
                r += d[0];
                c += d[1];
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] pieceInput = br.readLine().trim().split("\\s+");
        int d = Integer.parseInt(br.readLine().trim());

        Map<Character, Pos> initial = new HashMap<>();
        for (String s : pieceInput) {
            char type = s.charAt(0);
            int col = s.charAt(1) - 'A';
            int row = s.charAt(2) - '1';
            initial.put(type, new Pos(row, col));
        }

        State start = new State(initial);
        Set<State> result = new HashSet<>();

        Queue<State> q = new ArrayDeque<>();
        Queue<Integer> depth = new ArrayDeque<>();
        q.add(start);
        depth.add(0);

        while (!q.isEmpty()) {
            State cur = q.poll();
            int dep = depth.poll();

            if (dep == d) {
                result.add(cur);
                continue;
            }

            for (char t : cur.pieces.keySet()) {
                Pos pos = cur.pieces.get(t);
                for (Pos np : genMoves(t, pos, cur)) {
                    Map<Character, Pos> nmap = new HashMap<>(cur.pieces);
                    nmap.put(t, new Pos(np.r, np.c));
                    State ns = new State(nmap);

                    q.add(ns);
                    depth.add(dep + 1);
                }
            }
        }

        System.out.println(result.size());
    }
}
