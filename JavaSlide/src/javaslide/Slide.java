package javaslide;


/**
 *
 * @author hesenovpervin105@gmail.com
 */
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Slide extends JFrame {

    JLabel pic;
    Timer tm;
    int x = 0;
    String[] list = {
        "C:\\Users\\Windows\\Desktop\\Photos\\1.jpg",
        "C:\\Users\\Windows\\Desktop\\Photos\\2.jpg",
        "C:\\Users\\Windows\\Desktop\\Photos\\3.jpg",
        "C:\\Users\\Windows\\Desktop\\Photos\\4.jpg",
        "C:\\Users\\Windows\\Desktop\\Photos\\5.png",
        "C:\\Users\\Windows\\Desktop\\Photos\\6.png",
        "C:\\Users\\Windows\\Desktop\\Photos\\7.png",};

    public Slide() {
        super("Java SlideShow");
        pic = new JLabel();
        pic.setBounds(40, 30, 700, 300);

        //SetImageSize funksiyasını çağırırıq
        SetImageSize(6);
        //taymer qururuq
        tm = new Timer(500, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SetImageSize(x);
                x += 1;
                if (x >= list.length) {
                    x = 0;
                }
            }
        });
        add(pic);
        tm.start();
        setLayout(null);
        setSize(800, 400);
        getContentPane().setBackground(Color.decode("#bdb67b"));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    //görüntünün ölçüsünü dəyişmək üçün bir funksiya yaradırıq
    public void SetImageSize(int i) {
        ImageIcon icon = new ImageIcon(list[i]);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        pic.setIcon(newImc);
    }

    public static void main(String[] args) {

        new Slide();
    }
}
