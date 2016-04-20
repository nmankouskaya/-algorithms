import entity.Point;
import entity.Surface;

/**
 * Created by Настенька on 4/16/2016.
 */
public class Main {

    public static void main(String... args) throws CloneNotSupportedException, InterruptedException {

        Surface sf = new Surface(50,50);

        //Мигалка, триплет 1
        //Point[] points = new Point[]{new Point(3,2), new Point(3,3), new Point(3,4)};

        //триплет 2 + прогибает с течением времени
        //Point[] points = new Point[]{new Point(7,7), new Point(6,8), new Point(7,9)};

        //триплет 3 + погибает с течением времени
        //Point[] points = new Point[]{new Point(1,7), new Point(1,8), new Point(1,9)};


        //Улей, на 14 шагу + стационарное состояние
        /*Point[] points = new Point[]{new Point(8,5), new Point(8,6), new Point(8,7),
                new Point(8,8), new Point(8,9), new Point(8,10), new Point(8,11)};*/

        //Устойчивай, квадратик
        //Point[] points = new Point[]{new Point(7,6), new Point(7,7), new Point(8,6), new Point(8,7)};

        //Ступенька, устойчивая со второго шага
        //Point[] points = new Point[]{new Point(7,8), new Point(8,8), new Point(8,9), new Point(9,9)};

        //Лежачая буква "Г", с третьего шага устойчивая
        //Point[] points = new Point[]{new Point(7,7), new Point(8,7), new Point(8,8), new Point(8,9)};

        //Навигационные огни, с 9 шага циклическая с периодом 2
        //Point[] points = new Point[]{new Point(7,8), new Point(8,7), new Point(8,8), new Point(8,9)};

        //Погибает с течением времени
        //Point[] points = new Point[]{new Point(9,7), new Point(9,8), new Point(8,8), new Point(7,8), new Point(7,9)};

        //Каравай, устойчивый с 3 шага
        //Point[] points = new Point[]{new Point(7,7), new Point(7,8), new Point(7,9), new Point(8,9), new Point(9,9)};

        //Период 2
        //Point[] points = new Point[]{new Point(7,7), new Point(8,8), new Point(8,9), new Point(9,7), new Point(9,6), new Point(10,8)};

        //Палка, постоянная
        /*Point[] points = new Point[]{new Point(2,2), new Point(2,3), new Point(3,2),
                new Point(3,4), new Point(5,4),
                new Point(5,6), new Point(7,6),
                new Point(7,8), new Point(9,8),
                new Point(9,10), new Point(11,10),
                new Point(12,11), new Point(12,12), new Point(11,12)};*/

        //Часы, период 4
        /*Point[] points = new Point[]{new Point(6,2), new Point(6,3), new Point(7,2), new Point(7,3),
                                        new Point(6,5), new Point(7,5), new Point(8,5), new Point(9,5), new Point(7,6),
                                        new Point(10,6), new Point(10,7), new Point(10,8), new Point(10,9), new Point(9,7), new Point(8,8),
                                        new Point(12,6), new Point(12,7), new Point(13,6), new Point(13,7),
                                        new Point(9,10), new Point(8,10), new Point(7,10), new Point(6,10),
                                        new Point(9,12), new Point(9,13), new Point(8,12), new Point(8,13),
                                        new Point(5,9), new Point(5,8), new Point(5,7), new Point(5,6),
                                        new Point(3,8), new Point(3,9), new Point(2,8), new Point(2,9)};*/

        //П-гептамино, на 32 шаге превращается в пульсар с периоддом 3
        //Чтобы увидеть результат, нужно изменить размерность surface 30 на 30 и время "сна" на 1000
        /*Point[] points = new Point[]{new Point(12,10), new Point(12,11), new Point(12,12), new Point(12,13), new Point(12,14),
                                        new Point(13,10), new Point(13,14)};*/

        //Чеширский кот, улыбка на 6 шагу, с 7 шага постоянная
        /*Point[] points = new Point[]{new Point(4,6), new Point(5,6), new Point(5,7), new Point(5,8), new Point(5,9), new Point(4,9),
                                        new Point(6,5), new Point(7,5), new Point(8,5),
                                        new Point(9,6), new Point(9,7), new Point(9,8), new Point(9,9),
                                        new Point(8,10), new Point(7,10), new Point(6, 10),
                                        new Point(7,7), new Point(7,8)};*/

        //Вирус, если его поставить , касаясь двух граней, то популяция изменится, если 4ёх - выживет
        //Изменить размерность surface 50 на 50
        Point[] points = new Point[]{new Point(14,15), new Point(14,16), new Point(15,15), new Point(15,16),
                new Point(14,18), new Point(14,19), new Point(15, 18), new Point(15,19),
                new Point(14,21), new Point(14, 22), new Point(15,21), new Point(15,22),

                new Point(17,15), new Point(17,16), new Point(18,15), new Point(18,16),
                new Point(17,18), new Point(17,19), new Point(18, 18), new Point(18,19),
                new Point(17,21), new Point(17, 22), new Point(18,21), new Point(18,22),

                new Point(20,15), new Point(20,16), new Point(21,15), new Point(21,16),
                new Point(20,18), new Point(20,19), new Point(21, 18), new Point(21,19),
                new Point(20,21), new Point(20, 22), new Point(21,21), new Point(21,22),

                new Point(16,16)};
                //new Point(16,17)};  /* вирус */

        sf.setConfiguration(points);
        System.out.println(sf);

        new Thread(sf).start();
        Thread.sleep(500);
        sf.stopThread();


    }
}
