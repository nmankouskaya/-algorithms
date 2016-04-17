package utils.impl;

import entity.State;
import utils.Turing;

/**
 * Created by Настенька on 4/17/2016.
 */
public class DifferenceTreeOrFive implements Turing {
    /**
     * q2 1 -> q3 * R
     * q3 0 -> q5 * L
     * q3 1 -> q3 1 R
     * q2 0 -> q4 * R
     * q4 1 -> q5 * L
     * q4 0 -> q4 0 R
     * q5 1 -> q5 1 L
     * q5 0 -> q5 0 L
     * q5 * -> q5 * L
     * q5 # -> q2 # R
     * q2 * -> q2 * R
     * q3 * -> q3 * R
     * q4 * -> q4 * R
     * q3 # -> q6 1 N
     * q4 # -> q6 0 N
     *
     * q6 - разница 0
     * q7 - разница 1
     * q8 - разница 2
     * q9 - разница 3
     * q10 - разница 4
     * q11 - разница 5
     *
     * q6 1 -> q7 * L
     * q6 # -> q0 0 N
     * q7 1 -> q8 * L
     * q7 # -> q0 0 N
     * q8 1 -> q9 * L
     * q8 # -> q0 0 N
     * q9 1 -> q10 * L
     * q9 # -> q0 1 N
     * q10 1 -> q11 * L
     * q10 # -> q0 0 N
     * q11 1 -> q12 * N
     * q11 # -> q0 1 N
     * q12 1 -> q12 * L
     * q12 # -> q0 0 N
     * Аналогично для нулей
     */

    private static DifferenceTreeOrFive instance;

    public static DifferenceTreeOrFive getInstance(){
        if( instance == null )
            instance = new DifferenceTreeOrFive();
        return instance;
    }

    public void start(char[] charArray){
        State[] stateArray = initState(charArray);
        //первый проход для "чистки" - оставляем либо 0 , либо 1
        int k=stateArray.length-1;
        for(int i=0; i < stateArray.length;){
            char ch = stateArray[i].value;
            switch (ch){
                case '#':
                    if( stateArray[i].state.equals("q1") ){
                        stateArray[i+1].state = "q2";
                        i++;
                    } else if( stateArray[i].state.equals("q3") ){
                        stateArray[i].state = "q6";
                        stateArray[i].value = '1';
                        i++; //end
                    } else if( stateArray[i].state.equals("q4") ){
                        stateArray[i].state = "q6";
                        stateArray[i].value = '0';
                        i++; //end
                    } else if( stateArray[i].state.equals("q5") ){
                        stateArray[i+1].state = "q2";
                        i++; //end
                    } else if( stateArray[i].state.equals("q2") ){
                        stateArray[i-1].state = "q6";
                        i++; //end
                        k--; // чтобы для второго прохода не учитывать эту решётку
                    }
                    break;
                case '1':
                    if( stateArray[i].state.equals("q2") ){
                        stateArray[i+1].state = "q3";
                        stateArray[i].value = '*';
                        i++;
                    }else if( stateArray[i].state.equals("q4") ){
                        stateArray[i-1].state = "q5";
                        stateArray[i].value = '*';
                        i--;
                    } else if( stateArray[i].state.equals("q3") ) {
                        stateArray[i + 1].state = "q3";
                        i++;
                    } else if( stateArray[i].state.equals("q5") ) {
                        stateArray[i - 1].state = "q5";
                        i--;
                    }
                    break;
                case '0':
                    if( stateArray[i].state.equals("q3") ){
                        stateArray[i-1].state = "q5";
                        stateArray[i].value = '*';
                        i--;
                    }else if( stateArray[i].state.equals("q2") ){
                        stateArray[i+1].state = "q4";
                        stateArray[i].value = '*';
                        i++;
                    }else if( stateArray[i].state.equals("q4") ){
                        stateArray[i+1].state = "q4";
                        i++;
                    }else if( stateArray[i].state.equals("q5") ){
                        stateArray[i-1].state = "q5";
                        i--;
                    }
                    break;
                case '*':
                    if( stateArray[i].state.equals("q2") ){
                        stateArray[i+1].state = "q2";
                        i++;
                    }else if( stateArray[i].state.equals("q4") ){
                        stateArray[i+1].state = "q4";
                        i++;
                    } else if( stateArray[i].state.equals("q3") ) {
                        stateArray[i+1].state = "q3";
                        i++;
                    } else if( stateArray[i].state.equals("q5") ) {
                        stateArray[i-1].state = "q5";
                        i--;
                    }
                    break;
            }
        }

        for(int j=0; j < stateArray.length; j++) {
            System.out.print(stateArray[j].value + "");
        }

        //второй проход для подсчёта разницы
        for(int i=k; i >= 0;){
            char ch = stateArray[i].value;
            switch (ch){
                case '#':
                    if( stateArray[i].state.equals("q6") ){
                        stateArray[i].value = '0';
                        i--;
                    } else if( stateArray[i].state.equals("q7") ){
                        stateArray[i].value = '0';
                        i--;
                    }else if( stateArray[i].state.equals("q8") ){
                        stateArray[i].value = '0';
                        i--;
                    }else if( stateArray[i].state.equals("q9") ){
                        stateArray[i].value = '1';
                        i--;
                    }else if( stateArray[i].state.equals("q10") ){
                        stateArray[i].value = '0';
                        i--;
                    }else if( stateArray[i].state.equals("q11") ){
                        stateArray[i].value = '1';
                        i--;
                    }
                    else if( stateArray[i].state.equals("q12") ){
                        stateArray[i].value = '0';
                        i--;
                    }
                    break;
                case '0':
                case '1':
                    if( stateArray[i].state.equals("q6") ){
                        stateArray[i-1].state = "q7";
                        stateArray[i].value = '*';
                        i--;
                    } else if( stateArray[i].state.equals("q7") ){
                        stateArray[i-1].state = "q8";
                        stateArray[i].value = '*';
                        i--;
                    }else if( stateArray[i].state.equals("q8") ){
                        stateArray[i-1].state = "q9";
                        stateArray[i].value = '*';
                        i--;
                    }else if( stateArray[i].state.equals("q9") ){
                        stateArray[i-1].state = "q10";
                        stateArray[i].value = '*';
                        i--;
                    }else if( stateArray[i].state.equals("q10") ){
                        stateArray[i-1].state = "q11";
                        stateArray[i].value = '*';
                        i--;
                    }else if( stateArray[i].state.equals("q11") ){
                        stateArray[i-1].state = "q12";
                        stateArray[i].value = '*';
                        i--;
                    }else if( stateArray[i].state.equals("q12") ){
                    stateArray[i-1].state = "q12";
                    stateArray[i].value = '*';
                    i--;
                }
                    break;
                case '*':
                    if( stateArray[i].state.equals("q6") ){
                        stateArray[i-1].state = "q6";
                        i--;
                    } else if( stateArray[i].state.equals("q7") ){
                        stateArray[i-1].state = "q7";
                        i--;
                    }else if( stateArray[i].state.equals("q8") ){
                        stateArray[i-1].state = "q8";
                        i--;
                    }else if( stateArray[i].state.equals("q9") ){
                        stateArray[i-1].state = "q9";
                        i--;
                    }else if( stateArray[i].state.equals("q10") ){
                        stateArray[i-1].state = "q10";
                        i--;
                    }else if( stateArray[i].state.equals("q11") ){
                        stateArray[i-1].state = "q11";
                        i--;
                    }else if( stateArray[i].state.equals("q12") ){
                        stateArray[i-1].state = "q12";
                        i--;
                    }
                    break;
            }

        }

        System.out.print("\nResult: ");
        for(int j=0; j < stateArray.length; j++) {
            System.out.print(stateArray[j].value + "");
        }
    }

    private State[] initState(char[] charArray){
        State[] stateArray = new State[charArray.length];
        int i = 0;
        for(char ch : charArray){
            stateArray[i++] = new State(ch);
        }
        stateArray[0].state = "q1";
        return stateArray;
    }
}
