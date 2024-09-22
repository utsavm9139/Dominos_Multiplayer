//This sets up the GUI for the dominos on
//both the player side and the boneyard.

package dominoGUI;


import javafx.scene.Group;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;


public class mainGUI {

        public static final int h = 40;
        public static final int w = 40;
        private static final int x = 10;
        private static final int y = 75;

        public static Group domino0() {

            return new Group(new Rectangle(x, y, w, h));
        }
        public static Group domino1() {
            Rectangle rectangle = new Rectangle(x, y, w, h);
            Circle circle1 = new Circle(x + w / 2, y + h / 2, 3);
            circle1.setFill(Color.WHITE);
            return new Group(rectangle, circle1);
        }
        public static Group domino2() {
            Rectangle rectangle = new Rectangle(x, y, w, h);
            Circle circle1 = new Circle(x + 8, y + 8, 3);
            circle1.setFill(Color.WHITE);
            Circle circle2 = new Circle(x + w - 8, y + h - 8, 3);
            circle2.setFill(Color.WHITE);
            return new Group(rectangle, circle1, circle2);
        }
        public static Group domino3() {
            Rectangle rectangle3 = new Rectangle(x, y, w, h);
            Circle circle1 = new Circle(x + 8, y + 8, 3);
            circle1.setFill(Color.WHITE);
            Circle circle2 = new Circle(x + w - 8, y + h - 8, 3);
            circle2.setFill(Color.WHITE);
            Circle circle3 = new Circle(x + w / 2, y + h / 2, 3);
            circle3.setFill(Color.WHITE);
            return new Group(rectangle3, circle1, circle2, circle3);

        }
        public static Group domino4() {
            Rectangle rectangle = new Rectangle(x, y, w, h);
            Circle circle1 = new Circle(x + 8, y + 8, 3);
            circle1.setFill(Color.WHITE);
            Circle circle2 = new Circle(x + w - 8, y + 8, 3);
            circle2.setFill(Color.WHITE);
            Circle circle3 = new Circle(x + w - 8, y + h - 8, 3);
            circle3.setFill(Color.WHITE);
            Circle circle4 = new Circle(x + 8, y + h - 8, 3);
            circle4.setFill(Color.WHITE);
            return new Group(rectangle, circle1, circle2, circle3, circle4);
        }
        public static Group domino5() {
            Rectangle rectangle3 = new Rectangle(x, y, w, h);
            Circle circle1 = new Circle(x + 8, y + 8, 3);
            circle1.setFill(Color.WHITE);
            Circle circle2 = new Circle(x + w - 8, y + 8, 3);
            circle2.setFill(Color.WHITE);
            Circle circle3 = new Circle(x + w - 8, y + h - 8, 3);
            circle3.setFill(Color.WHITE);
            Circle circle4 = new Circle(x + 8, y + h - 8, 3);
            circle4.setFill(Color.WHITE);
            Circle circle5 = new Circle(x + w / 2, y + h / 2, 3);
            circle5.setFill(Color.WHITE);
            return new Group(rectangle3, circle1, circle2, circle3, circle4, circle5);
        }
        public static Group domino6() {
            Rectangle rectangle = new Rectangle(x, y, w, h);
            Circle circle1 = new Circle(x + 8, y + 8, 3);
            circle1.setFill(Color.WHITE);
            Circle circle2 = new Circle(x + w - 8, y + 8, 3);
            circle2.setFill(Color.WHITE);
            Circle circle3 = new Circle(x + w - 8, y + h - 8, 3);
            circle3.setFill(Color.WHITE);
            Circle circle4 = new Circle(x + 8, y + h - 8, 3);
            circle4.setFill(Color.WHITE);
            Circle circle5 = new Circle(x + w / 2, y + 8, 3);
            circle5.setFill(Color.WHITE);
            Circle circle6 = new Circle(x + w / 2, y + h - 8, 3);
            circle6.setFill(Color.WHITE);
            return new Group(rectangle, circle1, circle2, circle3, circle4, circle5, circle6);
        }
        // it consists of 7 group  that is half side of the domino.
        public static ArrayList<Group> arrayList() {
            ArrayList<Group> aList = new ArrayList<Group>();
            aList.add(domino0());
            aList.add(domino1());
            aList.add(domino2());
            aList.add(domino3());
            aList.add(domino4());
            aList.add(domino5());
            aList.add(domino6());
            return aList;
        }

        public static ArrayList<HBox> newList = new ArrayList<>();

        public static VBox gDomino() {
            VBox vBox = new VBox(10);
            String str="";
            int k=0;
            for (int i = 0; i < 7; i++) {
                for (int j = i; j < 7; j++) {
                    HBox hBox1 = new HBox();
                    str=Integer.toString(i)+Integer.toString(j);
                    hBox1.setId(str);
                    newList.add(new HBox(1, arrayList().get(i), arrayList().get(j)));
                    newList.get(k).setId(str);
                    k+=1;
                }
            }

            return vBox;
        }

    }
