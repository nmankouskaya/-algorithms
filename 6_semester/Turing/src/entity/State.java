package entity;

/**
 * Created by Настенька on 4/17/2016.
 */
public class State {

    public String state;
    public char value;

    public State(String state, char value) {
        this.state = state;
        this.value = value;
    }

    public State(char value) {
        this.state = "";
        this.value = value;
    }
}
