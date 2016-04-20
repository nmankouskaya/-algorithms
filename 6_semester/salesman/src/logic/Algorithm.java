package logic;

import entity.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Настенька on 4/18/2016.
 */
public class Algorithm {

    public static void start(Node node) throws CloneNotSupportedException {

        List<Node> hangingVertexList = new LinkedList<>();

        while( node != null ){
            System.out.println("==== ==== ==== ==== ==== ==== ==== ==== ==== ==== ==== ====");
            Matrix matrix = node.getMatrix();
            Matrix matrixAfterReduction = matrix.clone();
            System.out.println("Matrix: \n" + matrix);

            //приведение матрицы и вычисление константы
            int constant = MatrixReduction.lead(matrixAfterReduction);
            node.setMatrixAfterReduction(matrixAfterReduction);
            node.setRecord(constant);
            System.out.println("Matrix after reduction: \n" + matrixAfterReduction + "\nConstant: " + constant);

            //вычисление штрафов
            List<Fine> fineList = CalculateFines.calculate(matrixAfterReduction);
            System.out.println("Fines: ");
            for(Fine f : fineList){
                System.out.println(f + " ");
            }

            //выбираем максимальный штраф
            Fine maxFine = findMax(fineList);
            System.out.println("Max fine: " + maxFine);

            //создаём матрицу для левой ветки: заменяем элемент на позиции i,j на бесконечность
            Matrix leftMatrix = matrix.clone();
            leftMatrix.setElement(maxFine.originalI , maxFine.originalJ, -1);
            System.out.println("Matrix for left side: \n" + leftMatrix);

            //создаём элемент дерева, собираем всё в кучу
            Node leftNode = new Node();
            leftNode.setMatrix(leftMatrix);
            leftNode.setPrevious(node);

            //вычисляем рекорд для левой матрицы
            int leftRecord = leftNode.getPrevious().getRecord() + maxFine.value;
            System.out.println("Record = " + leftRecord);

            leftNode.setRecord(leftRecord);

            //добавляем созданный элемент в дерево
            node.setLeft(leftNode);

            //удаляем строку и столбец
            matrixAfterReduction.setLink(maxFine.i, maxFine.j);
            System.out.println("Remove " + maxFine.i + " line and " + maxFine.j + " column");
            matrixAfterReduction.removeLine(maxFine.originalI);
            matrixAfterReduction.removeLineNumber(maxFine.originalI);
            matrixAfterReduction.removeColumn(maxFine.originalJ);
            matrixAfterReduction.removeColumnNumber(maxFine.originalJ);
            System.out.println("Right Matrix After Reduction Line and Column:\n" + matrixAfterReduction);

            //проверить на бесконечность в каждой строке и столбце
            checkInfinity(matrixAfterReduction);
            System.out.println("Right Matrix After Check Infinity:\n" + matrixAfterReduction);

            //создаём правую ветку
            Node rightNode = new Node();
            rightNode.setMatrix(matrixAfterReduction);
            rightNode.setPrevious(node);

            Matrix matrixAfterReduction2 = matrixAfterReduction.clone();
            rightNode.setMatrixAfterReduction(matrixAfterReduction2);

            int constant2 = MatrixReduction.lead(matrixAfterReduction2);
            System.out.println("Constant: " + constant2);

            int rightRecord = rightNode.getPrevious().getRecord() + constant2;
            System.out.println("Record = " + rightRecord);

            rightNode.setRecord(rightRecord);

            node.setRight(rightNode);

            //выбираем минимальный рекорд
            int minRecord = rightRecord;
            node = rightNode;
            if( leftRecord < minRecord ){
                node = leftNode;
                hangingVertexList.add(rightNode);
            } else {
                hangingVertexList.add(leftNode);
            }

            if ( node.getMatrix().getDim() == 2 ){
                hangingVertexList.add(node);
                //найти минимальный рекорд, если их несколько, выбрать любой
                Node minRecordNode = findMinRecord(hangingVertexList);

                if(node.equals(minRecordNode)){
                    //построить цикл для текущей
                    buildWay(node);
                    break;
                } else {
                    //продолжить для следующей минимальной
                    node = minRecordNode;
                    hangingVertexList = new LinkedList<>();
                }

            }
        }


    }

    //находим максимальный штраф
    private static Fine findMax(List<Fine> list){
        Fine maxFine = list.get(0);
        int maxValue = maxFine.value;
        for(Fine f : list){
            if(f.value > maxValue){
                maxValue = f.value;
                maxFine = f;
            }
        }
        return maxFine;
    }

    //проверяем есть ли в каждой строке и столбце бесконечность
    private static void checkInfinity(Matrix matrix){
        int[][] matrixArray = matrix.getMatrix();
        boolean status = false; //означает, что не нашли бесконечность
        for(int i=0; i < matrixArray.length; i++){
            for(int j=0; j < matrixArray[0].length && status == false; j++){
                if( matrixArray[i][j] < 0 ){
                    status = true;
                    break;
                }
            }
            if( status == false ){
                int columnNumber = checkColumn(matrix);
                matrixArray[i][columnNumber] = -1;
            }
            status = false;
        }
        matrix.setMatrix(matrixArray);
    }

    //используется в предыдущей функции для нахождения бесконечности в столбце
    private static int checkColumn(Matrix matrix){
        int[][] matrixArray = matrix.getMatrix();
        boolean status = false;
        int columnNumber = -1;
        for(int j=0; j < matrixArray[0].length; j++){
            for(int i=0; i < matrixArray.length && status == false; i++){
                if( matrixArray[i][j] < 0 ){
                    status = true;
                    break;
                }
            }
            if( status == false ){
                columnNumber = j;
                break;
            }
            status = false;
        }
        return columnNumber;
    }

    //находим минимальный рекорд из всех висячих вершин
    private static Node findMinRecord(List<Node> nodeList){
        Node minNode = nodeList.get(0);
        int minRecord = minNode.getRecord();
        for(Node node : nodeList){
            if(node.getRecord() < minRecord){
                minRecord = node.getRecord();
                minNode = node;
            }
        }
        return minNode;
    }

    //строим цикл
    private static void buildWay(Node node){
        List<Link> linkList = new ArrayList<>();
        Link link;
        while( node != null ){
            link = node.getMatrix().getLink();
            if( checkSimpleLink(link) ){
                linkList.add(link);
            }
            node = node.getPrevious();
        }
        System.out.println("\nWay:");
        for(Link l : linkList){
            System.out.println(l);
        }
    }

    //используется в предыдущей функции для отбрасывания таких линков: 0 -> 0 , которые принадлежат не висячим вершинам
    private static boolean checkSimpleLink(Link link){
        if (link.from == 0 && link.to == 0)
            return false;
        return true;
    }

}
