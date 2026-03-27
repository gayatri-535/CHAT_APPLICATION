
package project11.src;
import javax.swing.*;

public class mywindow extends JFrame {
    public mywindow() {
        super.setTitle("my_clock");
        super.setSize(400, 400);
        super.setLocation(300, 50);
        super.setVisible(true);
    }

    public static void main(String[] args) {
        new mywindow();
    }
}