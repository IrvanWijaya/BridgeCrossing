/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Irvan
 */

public class Node implements Comparable<Node> {
    private Person[] diKiri;
    private Person[] diKanan;
    private Node nodeParent;
    private int waktu;
    private boolean senterDiKiri;
    private int hnPlusGn;
    
    private int iKiri = 0 ,iKanan = 0;

    public Node(int kiri, int kanan, Node parent, int waktu, boolean senter){
        this.diKiri = new Person[kiri];
        this.diKanan = new Person[kanan];
        this.nodeParent = parent;
        this.waktu = waktu;
        this.senterDiKiri = senter;
    }
    
    
    public void pushKanan(Person p){
        this.diKanan[this.iKanan] = p;
        this.iKanan++;
    }
    
    public void pushKiri(Person p){
        this.diKiri[this.iKiri] = p;
        this.iKiri++;
    }
    
    public Person[] getDiKiri() {
        return diKiri;
    }

    public Person[] getDiKanan() {
        return diKanan;
    }
    
    public int getDiKiriLength() {
        return diKiri.length;
    }

    public int getDiKananLength() {
        return diKanan.length;
    }
    
    public Node getParent(){
        return this.nodeParent;
    }
    
    public void setWaktu(int waktu) {
        this.waktu = waktu;
    }

    public int getWaktu() {
        return waktu;
    }
    
    public boolean getPosisiSenter(){
        return this.senterDiKiri;
    }
    
    public void setHnPlusGnVal(int cost){
        int res = 0;
        /*
        for(int i =0; i < this.getDiKiriLength(); i++){
            res += this.diKiri[i].getSpeed();
        }
        this.hnPlusGn = res + cost;*/
        this.hnPlusGn = cost + this.getDiKiriLength() - this.getDiKananLength();
    }

    @Override
    public int compareTo(Node other) {
        //return this.hnPlusGn - other.hnPlusGn;
        return this.waktu - other.waktu;
    }
}
