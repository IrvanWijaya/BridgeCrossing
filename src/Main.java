
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Irvan
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int nOrang = sc.nextInt();
        Person arrPerson[] = new Person[nOrang];
        
        for (int i = 0; i < nOrang; i++) {
            arrPerson[i] = new Person(sc.nextInt(), i+1);
        }
        
        Node stateAwal = new Node(arrPerson, new Person[0], 0,0);
        
        //System.out.println("Kanan" + stateAwal.getDiKanan());
        
        AI ai = new AI(stateAwal);
        
        ai.doABintang();
        
        //System.out.println(stateAwal);
        
    }
}
/*
4
1
10
2
5
*/