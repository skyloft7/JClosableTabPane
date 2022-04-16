import javax.swing.*;
import java.awt.*;


public class JClosableTabPane extends JTabbedPane {
    int currentIndex = 0;

    public void addTab(Tab tab) {
        tab.index = currentIndex++;
        addTab(tab.title, tab.jPanel);

        setTabComponentAt(tab.index, new TabComponent(tab, new TabClosingListener() {
            @Override
            public void tabClosing(int index) {
                removeTabAt(index);
                reindex();
            }
        }));


    }

    public void reindex() {
        for(currentIndex = 0; currentIndex < getTabCount(); currentIndex++){
            ((TabComponent) getTabComponentAt(currentIndex)).parentTab.index = currentIndex;
        }
    }


    class TabComponent extends JPanel {

        private Tab parentTab;
        public TabComponent(Tab parentTab, TabClosingListener tabClosingListener) {
            this.parentTab = parentTab;

            setOpaque(false);

            FlowLayout flowLayout = new FlowLayout();
            flowLayout.setVgap(0);
            flowLayout.setHgap(0);
            setLayout(flowLayout);

            this.add(new JLabel(parentTab.title));

            JButton close = new JButton(new ImageIcon("assets/x.png"));

            close.addActionListener(e -> tabClosingListener.tabClosing(this.parentTab.index));

            close.setBorderPainted(false);
            close.setContentAreaFilled(false);
            close.setFocusPainted(false);
            close.setOpaque(false);

            this.add(close);
        }
    }

    abstract class TabClosingListener {
        public abstract void tabClosing(int index);
    }
}
