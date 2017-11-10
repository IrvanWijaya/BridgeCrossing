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
    private int indexParent;
    private int waktu;
    
    private int iKiri = 0 ,iKanan = 0;

    public Node(int kiri, int kanan, int index, int waktu){
        this.diKiri = new Person[kiri];
        this.diKanan = new Person[kanan];
        this.indexParent = index;
        this.waktu = waktu;
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

    public void setIndex(int index) {
        this.indexParent = index;
    }

    public int getIndex() {
        return indexParent;
    }
    
    public void setWaktu(int waktu) {
        this.waktu = waktu;
    }

    public int getWaktu() {
        return waktu;
    }

    @Override
    public int compareTo(Node other) {
        return this.waktu - other.waktu;
    }
}
