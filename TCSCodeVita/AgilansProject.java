package TCSCodeVita;

import java.io.*;
import java.util.*;

public class AgilansProject {

    static class Step {
        String turn;
        int dist;
        Step(String t, int d) { turn = t; dist = d; }
    }

    static int dirIndex(String turn, int dir) {
        switch (turn) {
            case "left": return (dir + 1) % 4;
            case "right": return (dir + 3) % 4;
            case "straight": return dir;
            case "back": return (dir + 2) % 4;
        }
        return dir; // default (should never happen)
    }

    static int[] dx = {0, 1, 0, -1}; // N,E,S,W
    static int[] dy = {1, 0, -1, 0};

    static int[] simulate(List<Step> steps, int sx, int sy) {
        int dir = 0; // north
        int x = sx, y = sy;
        for (Step st : steps) {
            dir = dirIndex(st.turn, dir);
            x += dx[dir] * st.dist;
            y += dy[dir] * st.dist;
        }
        return new int[]{x, y};
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        List<Step> steps = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            String turn = st.nextToken();
            int dist = Integer.parseInt(st.nextToken());
            steps.add(new Step(turn, dist));
        }

        StringTokenizer st1 = new StringTokenizer(br.readLine().trim());
        int ax = Integer.parseInt(st1.nextToken());
        int ay = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine().trim());
        int rx = Integer.parseInt(st2.nextToken());
        int ry = Integer.parseInt(st2.nextToken());

        // First try original path
        int[] end = simulate(steps, ax, ay);
        if (end[0] == rx && end[1] == ry) {
            System.out.println("No");
            return;
        }

        // Try changing each instruction
        String[] options = {"left", "right", "straight", "back"};
        for (int i = 0; i < N; i++) {
            for (String opt : options) {
                if (opt.equals(steps.get(i).turn)) continue; // skip same

                String wrongTurn = steps.get(i).turn;
                int dist = steps.get(i).dist;

                // make a copy
                List<Step> modified = new ArrayList<>();
                for (int j = 0; j < N; j++) {
                    if (j == i) modified.add(new Step(opt, steps.get(j).dist));
                    else modified.add(new Step(steps.get(j).turn, steps.get(j).dist));
                }

                int[] res = simulate(modified, ax, ay);
                if (res[0] == rx && res[1] == ry) {
                    System.out.println("Yes");
                    System.out.println(wrongTurn + " " + String.valueOf(dist));
                    System.out.println(opt + " " + String.valueOf(dist));
                    return;
                }
            }
        }

        System.out.println("No");
    }
}

