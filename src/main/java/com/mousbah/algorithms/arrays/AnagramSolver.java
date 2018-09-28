package com.mousbah.algorithms.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AnagramSolver {

    private String[] word1;
    private String[] word2;
    private Map<String,String> map;

    public AnagramSolver(String[] word1, String[] word2) {
        this.word1 = word1;
        this.word2 = word2;
        map=new HashMap<>();
    }

    public String[] getWord1() {
        return word1;
    }

    public void setWord1(String[] word1) {
        this.word1 = word1;
    }

    public String[] getWord2() {
        return word2;
    }

    public void setWord2(String[] word2) {
        this.word2 = word2;
    }

    public static void main(String[] args) {
        String[] w1 = new String[]{"a", "b", "c", "d"};
        String[] w2 = new String[]{"d", "b", "a", "c"};
        AnagramSolver anagramSolver = new AnagramSolver(w1, w2);
        System.out.println(anagramSolver.isAnagram());
    }

    public boolean isAnagram() {
        Arrays.stream(word2).forEach(w -> map.put(w,w));
//        return Arrays.stream(word1).allMatch(w -> containsCharacter(word2, w));
        return Arrays.stream(word1).allMatch(w -> containsCharacterInMap(word2, w));
    }

    private boolean containsCharacter(String[] word, String string) {
        return Arrays.stream(word).anyMatch(w -> w.equals(string));
    }

    private boolean containsCharacterInMap(String[] word, String string) {
        return map.containsKey(string);
    }
}
