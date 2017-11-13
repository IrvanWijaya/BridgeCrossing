
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
    private Person[] tempPersonKiri;
    private Person[] tempPersonKanan;
    private int fastestPerson,slowestPerson;

    private int hn = 0;
    //private int idxParent = 0;
    private int jatahKiri = 0, jatahKanan = 0;

    private int nodeExpanded;
    public AI(Node stateAwal, int fast, int slow) {
        this.parent = new ArrayList<Node>();
        //this.parent.add(stateAwal);
        pqNode = new PriorityQueue<Node>();
        pqNode.add(stateAwal);
        this.fastestPerson = fast;
        this.slowestPerson = slow;
    }

    public List<Node> doABintang() {
        int i = 0;
        //Initialize
        this.temp = this.pqNode.poll();
        this.process(i);
       
        /*
        while (!pqNode.isEmpty()) {
            temp = pqNode.poll();
            System.out.println(temp.getWaktu());
        }*/
        while (!pqNode.isEmpty()) {
            this.temp = this.pqNode.poll();
            if(this.temp.getDiKiriLength() == 0 && this.temp.getWaktu() <= this.pqNode.peek().getWaktu()){
                break;
            }
            //System.out.println(this.temp.getWaktu());
            this.process(i);
        }
        
        
        while(temp.getParent() != null){
            parent.add(temp);
            temp = temp.getParent();
        }
        parent.add(temp);
        
        System.out.println("Node expanded = " + nodeExpanded + "\nWaktu minimal = " + parent.get(0).getWaktu());

        return this.parent;
    }

    private void process(int i) {
        if (!temp.getPosisiSenter()) {
            this.tempPersonKanan = this.temp.getDiKanan();
            this.tempPersonKiri = this.temp.getDiKiri();
            this.jatahKiri = this.temp.getDiKiriLength() + 1;
            this.jatahKanan = this.temp.getDiKananLength() - 1;
            int j;
            int waktu = 0;
            Node newNode;
            for(i = 0; i < this.tempPersonKanan.length; i++){
                newNode = new Node(this.jatahKiri, this.jatahKanan, this.temp, 0, true);
                
                for(j =0; j < this.tempPersonKiri.length; j++){
                    newNode.pushKiri(this.tempPersonKiri[j]);
                }
                
                for(j =0; j < this.tempPersonKanan.length; j++){
                    if(j  == i){
                        newNode.pushKiri(this.tempPersonKanan[j]);
                        waktu = this.temp.getWaktu() + this.tempPersonKanan[j].getSpeed();
                        newNode.setWaktu(waktu);
                    }else{
                        newNode.pushKanan(this.tempPersonKanan[j]);
                    }
                }
                
                newNode.setHnPlusGnVal(waktu,this.fastestPerson, true);
                this.pqNode.add(newNode);
                nodeExpanded++;
            }
            //this.idxParent++;
        } else {
            this.tempPersonKiri = this.temp.getDiKiri();
            this.tempPersonKanan = this.temp.getDiKanan();
            this.combTemp = new int[temp.getDiKiriLength()];
            for (i = 0; i < this.combTemp.length; i++) {
                this.combTemp[i] = i;
            }
            this.jatahKiri = this.temp.getDiKiriLength() - 2;
            this.jatahKanan = this.temp.getDiKananLength() + 2;
            combinations(this.combTemp, 2, 0, new int[2], 1);
            //System.out.println("--------------");
            //this.idxParent++;
        }
    }

    private void combinations(int[] arr, int len, int startPosition, int[] result, int banyakPindah) {
        if (len == 0) {
            //System.out.println(Arrays.toString(result));
            Node newNode = new Node(this.jatahKiri, this.jatahKanan, this.temp, 0, false);
            int iRes = 0;
            int waktu = 0;
            int i;
            for(i =0; i < tempPersonKanan.length; i++){
                newNode.pushKanan(tempPersonKanan[i]);
            }
            for (i = 0; i < arr.length; i++) {
                if (i == result[iRes]) {
                    newNode.pushKanan(tempPersonKiri[i]);
                    if (tempPersonKiri[i].getSpeed() > waktu) {
                        waktu = tempPersonKiri[i].getSpeed();
                    }
                    if (iRes < banyakPindah) {
                        iRes++;
                    }
                } else {
                    newNode.pushKiri(tempPersonKiri[i]);
                }
            }
            waktu += temp.getWaktu();
            newNode.setHnPlusGnVal(waktu,this.fastestPerson,false);
            newNode.setWaktu(waktu);
            nodeExpanded++;
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
