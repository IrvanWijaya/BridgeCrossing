
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Irvan
 */
public class AI {

    private List<Node> parent;
    private PriorityQueue<Node> pqNode;
    private Node temp;
    private int[] combTemp;
    private Person[] tempPerson;

    private int hn = 0;
    private int idxParent = 0;
    private int jatahKiri = 0, jatahKanan = 0;

    public AI(Node stateAwal) {
        this.parent = new ArrayList<Node>();
        this.parent.add(stateAwal);
        pqNode = new PriorityQueue<Node>();
        pqNode.add(stateAwal);
    }

    public int doABintang() {
        int i = 0;
        boolean lvlGenap = false;
        //Initialize
        this.process(i, lvlGenap);
        lvlGenap = !lvlGenap;
        /*
        while (!pqNode.isEmpty()) {
            temp = pqNode.poll();
            System.out.println(temp.getWaktu());
        }*/
        while (!pqNode.isEmpty()) {
            temp = pqNode.poll();
            if(temp.getDiKiriLength() == 0 && temp.getWaktu() < pqNode.peek().getWaktu()){
                break;
            }
            this.process(i, lvlGenap);
            lvlGenap = !lvlGenap;
            //System.out.println(temp.getWaktu());
        }
        
        System.out.println(temp.getWaktu());

        /*
        while(temp.getDiKiriLength() != 0){
            if(temp.getWaktu() < pqNode.peek().getWaktu()){
                
            }
            
        }*/
        return 0;
    }

    private void process(int i, boolean lvlGenap) {

        if (lvlGenap) {
            this.temp = pqNode.poll();
            this.tempPerson = this.temp.getDiKanan();
            this.combTemp = new int[temp.getDiKananLength()];
            for (i = 0; i < this.combTemp.length; i++) {
                this.combTemp[i] = i;
            }
            this.jatahKiri = this.combTemp.length - 2;
            this.jatahKanan += 2;
            combinations(this.combTemp, 2, 0, new int[2], 1);
            this.idxParent++;
        } else {
            this.temp = pqNode.poll();
            this.tempPerson = this.temp.getDiKiri();
            this.combTemp = new int[temp.getDiKiriLength()];
            for (i = 0; i < this.combTemp.length; i++) {
                this.combTemp[i] = i;
            }
            this.jatahKiri = this.combTemp.length - 2;
            this.jatahKanan += 2;
            combinations(this.combTemp, 2, 0, new int[2], 1);
            this.idxParent++;
        }
    }

    private void combinations(int[] arr, int len, int startPosition, int[] result, int banyakPindah) {
        if (len == 0) {
            System.out.println(Arrays.toString(result));
            Node newNode = new Node(this.jatahKiri, this.jatahKanan, this.idxParent, 0);
            int iRes = 0;
            int waktu = 0;
            for (int i = 0; i < arr.length; i++) {
                if (i == result[iRes]) {
                    newNode.pushKanan(tempPerson[i]);
                    if (tempPerson[i].getSpeed() + this.hn > waktu + this.hn) {
                        waktu = tempPerson[i].getSpeed() + this.hn;
                    }
                    if (iRes < banyakPindah) {
                        iRes++;
                    }
                } else {
                    newNode.pushKiri(tempPerson[i]);
                }
            }
            newNode.setWaktu(waktu);
            this.pqNode.add(newNode);
        } else {
            for (int i = startPosition; i <= arr.length - len; i++) {
                result[result.length - len] = arr[i];
                combinations(arr, len - 1, i + 1, result, banyakPindah);
            }
        }

    }

}

/*
4
1
10
2
5

 */
