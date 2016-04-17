import utils.impl.DifferenceTreeOrFive;

/**
 * Created by Настенька on 4/17/2016.
 */
public class Main {

    public static void main(String... args){

        DifferenceTreeOrFive turing = DifferenceTreeOrFive.getInstance();

        System.out.println( "Input " + args[0] );

        turing.start(args[0].toCharArray());

    }
}
