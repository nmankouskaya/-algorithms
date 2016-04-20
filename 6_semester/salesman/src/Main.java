import entity.Node;
import logic.Algorithm;
import utils.InitNode;

/**
 * Created by Настенька on 4/18/2016.
 */
public class Main {

    public static void main(String... args) throws CloneNotSupportedException {
        Node node = InitNode.init();
        Algorithm.start(node);
    }
}
