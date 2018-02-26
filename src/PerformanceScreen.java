

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PerformanceScreen
{
    private JTable performanceTab;
    private JPanel panel1;
    private Object[][] tabObj;
    DefaultTableModel model = new DefaultTableModel(new String[]{"Student","Punkty","Ocena","Procenty"},0);
    private Image frameImage = new ImageIcon("indeks.jpg").getImage();

    public PerformanceScreen(List<Student> studentList)
    {
        tabObj = new Object[studentList.size()][4];
        for(int i =0;i<studentList.size();i++)
        {
            tabObj[i][0] = studentList.get(i).getName();
            tabObj[i][1] = studentList.get(i).getPoints();
            tabObj[i][2] = studentList.get(i).getMark();
            tabObj[i][3] = studentList.get(i).getPercent();
            model.addRow(tabObj[i]);
        }

        performanceTab = new JTable();
        performanceTab.setModel(model);
        JFrame frame = new JFrame("Tabela Wyników");
        frame.setIconImage(frameImage);
        panel1.add(performanceTab);
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(400,200);
    }

}
