/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsack1;

/**
 *
 * @author mazenbadr
 */
public class Item {
    private Integer value;
    private Integer size;

    public Item(Integer value, Integer size) {
        this.value = value;
        this.size = size;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
    
}
