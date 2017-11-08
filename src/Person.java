/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Irvan
 */
public class Person {
    private int speed;
    private int id;
    
    public Person(int speed, int id){
        this.speed = speed;
        this.id = id;
    }
    
    public int getSpeed() {
        return speed;
    }

    public int getId() {
        return id;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
