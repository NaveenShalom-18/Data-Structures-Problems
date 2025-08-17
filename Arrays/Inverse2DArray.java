package Arrays;


import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> mainlst = new ArrayList<>();
        while(sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            String[] tokens = line.split(" ");
            List<Integer> list = new ArrayList<>();
            for(String token : tokens) {
                if(!token.isEmpty()) {
                    list.add(Integer.parseInt(token));
                }
            }
            mainlst.add(list);
        }
        int m = mainlst.size();
        int n = mainlst.get(0).size();
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < n; i++){
            List<Integer> res = new ArrayList<>();
            for(int j = m-1; j >=0 ; j--){
                res.add(mainlst.get(j).get(i));
            }
            result.add(res);
        }
        System.out.println(result);
    }
}
