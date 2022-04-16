import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        SwingUtilities.invokeLater(() -> {

                FlatLightLaf.setup();



            JFrame frame = new JFrame("JClosableTabPane Demo");

            JClosableTabPane jClosableTabPane = new JClosableTabPane();
            frame.setContentPane(jClosableTabPane);

            jClosableTabPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);


            for(int i = 0; i < 15; i++){
                TextPanel textPanel = new TextPanel("" + i);
                jClosableTabPane.addTab(new Tab("Main.java", textPanel));
            }



            frame.setSize(640, 480);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
