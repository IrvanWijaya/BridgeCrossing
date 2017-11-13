
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

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

    public static void main(String[] args) throws IOException {
        String filePath = new File("").getAbsolutePath();

        BufferedReader br = new BufferedReader(new FileReader(filePath + "/input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath + "/output.txt"));

        int nOrang = Integer.parseInt(br.readLine());
        Person arrPerson[] = new Person[nOrang];

        Node stateAwal = new Node(nOrang, 0, null, 0, true);

        int i;
        int fast = Integer.MAX_VALUE,slow = Integer.MIN_VALUE;
        for (i = 0; i < nOrang; i++) {
            arrPerson[i] = new Person(Integer.parseInt(br.readLine()), i + 1);
            stateAwal.pushKiri(arrPerson[i]);
            if(arrPerson[i].getSpeed() < fast){
                fast = arrPerson[i].getSpeed();
            }
            if(arrPerson[i].getSpeed() > slow){
                slow = arrPerson[i].getSpeed();
            }
        }
        AI ai = new AI(stateAwal,fast,slow);

        List<Node> res = ai.doABintang();

        for (i = 0; i < nOrang; i++) {
            bw.write("Orang ke :" + arrPerson[i].getId() + " membutuhkan waktu " + arrPerson[i].getSpeed() + " detik untuk menyebrang.");
            bw.newLine();
        }
        bw.newLine();

        bw.write("'x-x' menandakan jembatan, x(y) y adalah waktu yang dibutuhkan orang x menyebrangi jembatan.\r\nUrutan menyebrang adalah :");
        bw.newLine();

        Person[] temp;
        int j;
        for (i = res.size() - 1; i >= 0; i--){
            bw.newLine();
            bw.write("Waktu = " + res.get(i).getWaktu());
            bw.newLine();
            temp = res.get(i).getDiKiri();
            for (j = 0; j < temp.length; j++) {
                bw.write(temp[j].getId() + "(" + temp[j].getSpeed() + ")");
                if (j != temp.length - 1) {
                    bw.write(",");
                }
            }
            bw.write("  x-x  ");
            temp = res.get(i).getDiKanan();
            for (j = 0; j < temp.length; j++) {
                bw.write(temp[j].getId() + "(" + temp[j].getSpeed() + ")");
                if (j != temp.length - 1) {
                    bw.write(",");
                }
            }
            bw.newLine();
        }

        if (bw != null) {
            bw.close();
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
