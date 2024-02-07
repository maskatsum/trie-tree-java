package com.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] people = new String[]{"勝又 雅史", "勝俣 邦夫","勝間田 太郎", "勝又 二郎"};
    
        Trie root = new Trie(false);

        
        // トライ木の作成
        for (int i = 0; i < people.length; i++) {
            
            // 例：性と名を分けて、性だけでグルーピングする
            String[] nameComponents = people[i].split(" ");
            String familyName = nameComponents[0];

            addWord(root, familyName, people[i]);

        }

        // 検索
        List<String> katsumata = findPerson(root, "勝又");
        katsumata.forEach(name -> {
            System.out.println(String.format("katsumata1 -> %s", name));
        });
        List<String> tamura = findPerson(root, "田村");
        tamura.forEach(name -> {
            System.out.println(String.format("tamura -> %s", name));
        });
    }
    static List<String> findPerson(Trie root, String name) {
        Trie parent = root;
        String[] key = name.split("");
        for (int i = 0; i < key.length; i++) {
            if (!parent.children.containsKey(key[i])) {
                break;
            }
            parent = parent.children.get(key[i]);
        }
        return parent.people;
    }

    static void addWord(Trie root, String name, String fullName) {
        String[] key = name.split("");

        Trie parent = root;
        for (int i = 0; i < key.length; i++) {
            String str = key[i];
            if (!parent.children.containsKey(str)) {
                parent.children.put(str, new Trie(false));
            }

            parent = parent.children.get(str);
        }
        parent.endOfWord = true;
        parent.people.add(fullName);
    }
}