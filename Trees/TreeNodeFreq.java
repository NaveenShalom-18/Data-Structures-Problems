package Trees;

class TreeNodeFreq {
    String name;
    int freq;
    TreeNodeFreq left, right;

    TreeNodeFreq(String name) {
        this.name = name;
        this.freq = 1;
        left = right = null;
    }
}
