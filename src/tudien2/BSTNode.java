/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tudien2;

import java.util.LinkedList;

/**
 *
 * @author PRO
 */
public class BSTNode implements Comparable<BSTNode> {

    public String word;
    BSTNode left, right;
    LinkedList<String> means;

    public BSTNode(String word, BSTNode left, BSTNode right, LinkedList<String> means) {
        this.word = word;
        this.left = left;
        this.right = right;
        this.means = means;
    }

    public BSTNode(String word, LinkedList<String> means) {

        this.word = word;
        this.means = means;
        this.left = null;
        this.right = null;
    }

    @Override
    public int compareTo(BSTNode o) {
        return this.word.compareTo(o.word);
    }

    @Override
    public String toString() {
        return word + ":" + getMeans(means);
    }

    public String getMeans(LinkedList means) {
        String result = "";
        for (int i = 0; i < means.size(); i++) {
            result = result + means.get(i);
            if (i < (means.size() - 1)) {
                result = result + ",";
            }
        }
        return result;
    }

}

class BST {

    BSTNode root;

    public BST() {
        root = null;
    }

    public void visit(BSTNode p) {
        if (p != null) {
            System.out.print(p.word + ": " + getMeans(p.means));
            System.out.println("");
        }
    }

    public String getMeans(LinkedList means) {
        String result = "";
        for (int i = 0; i < means.size(); i++) {
            result = result + means.get(i);
            if (i < (means.size() - 1)) {
                result = result + ".";
            }
        }
        return result;
    }

    public void Insert(BSTNode el) {
        BSTNode p = root;
        BSTNode parent = null;
        while (p != null) {
            parent = p;
            if (el.word.compareTo(p.word) < 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (root == null) {
            root = new BSTNode(el.word, el.means);
        } else {
            if (el.word.compareTo(parent.word) < 0) {
                parent.left = new BSTNode(el.word, el.means);
            } else {
                parent.right = new BSTNode(el.word, el.means);
            }
        }
    }

    public BSTNode Search(String wordfind) {
        BSTNode p = root;
        while (p != null) {
            if (wordfind.equals(p.word)) {
                return  p;
            } else if(wordfind.compareTo(p.word)<0){
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return  null;
    }
    public void AddWord(String word, String mean){
        BSTNode a = Search(word);
        int check = 0;
        if(a==null){
            LinkedList ll = new LinkedList();
            ll.add(mean);
            BSTNode  b = new BSTNode(word, ll);
            Insert(b);
        } else{
            for(int i =0; i < a.means.size(); i++){
                if(mean.equals(a.means.get(i).trim())){
                    check++;
                }
            }
            if(check !=0){
                System.out.println("da ton tai");
            } else {
                a.means.add(mean);
            }
        }
    }
}
