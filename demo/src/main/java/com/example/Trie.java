package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie {
    public HashMap<String, Trie> children = new HashMap<>();
    public Boolean endOfWord = false;
    public List<String> people = new ArrayList<>();

    public Trie(
        Boolean EOW
    ) {
        this.endOfWord = EOW;
    }
}