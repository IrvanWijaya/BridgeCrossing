
import java.util.ArrayList;
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
    PriorityQueue<Node> pqNode; 
    private int hn = 0;
    
    public AI(Node stateAwal){
        this.parent = new ArrayList<Node>();
        this.parent.add(stateAwal);
        pqNode = new PriorityQueue<Node>();
        pqNode.add(stateAwal);
    }
    
    public int doABintang(){
        int i = 0;
        Node temp = pqNode.poll();
        System.out.println("aa");
        /*
        while(temp.getDiKiriLength() != 0){
            if(temp.getWaktu() < pqNode.peek().getWaktu()){
                
            }
            
        }*/
        
        return 0;
    }
}
