import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Mon Sep 26 14:00:54 CST 2022
 */



/**
 * @author unknown
 */
public class MainFrm extends JFrame {

    public static void main(String[] args) {
        MainFrm mainFrm = new MainFrm();
        mainFrm.setTitle("Grid Location Distance Calculator By: BI1NEI");
        mainFrm.setSize(570, 210);
        mainFrm.setVisible(true);
        mainFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public MainFrm() {
        initComponents();
    }

    private void calBtnMouseClicked(MouseEvent e) {
        try {
            String loc1 = gridLoc1.getText(), loc2 = gridLoc2.getText();
            Grid grid1 = new Grid(loc1), grid2 = new Grid(loc2);
            Coordinate coordinate1 = grid1.getCoordinate(), coordinate2 = grid2.getCoordinate();
            String pos = "Lat: %.06f, Lon: %.06f";
            coodLoc1.setText(String.format(pos, coordinate1.getLat().toDecimal(), coordinate1.getLon().toDecimal()));
            coodLoc2.setText(String.format(pos, coordinate2.getLat().toDecimal(), coordinate2.getLon().toDecimal()));
            double distance = Coordinate.distance(coordinate1, coordinate2);
            distanceLbl.setText(String.format("%.03f km", distance));
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        gridLoc1 = new JTextField();
        gridLoc2 = new JTextField();
        label3 = new JLabel();
        coodLoc1 = new JLabel();
        label5 = new JLabel();
        coodLoc2 = new JLabel();
        label7 = new JLabel();
        distanceLbl = new JLabel();
        calBtn = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Grid Location 1:");

        //---- label2 ----
        label2.setText("Grid Location 2:");

        //---- gridLoc1 ----
        gridLoc1.setText("OM89fv");

        //---- gridLoc2 ----
        gridLoc2.setText("PM97lg");

        //---- label3 ----
        label3.setText("Coordinate 1:");

        //---- label5 ----
        label5.setText("Coordinate 2:");

        //---- label7 ----
        label7.setText("Distance between two location:");

        //---- distanceLbl ----
        distanceLbl.setText("0km");

        //---- calBtn ----
        calBtn.setText("Calculate");
        calBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                calBtnMouseClicked(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label7)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(distanceLbl)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(calBtn))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label1)
                                .addComponent(label2))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(gridLoc2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addComponent(gridLoc1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label3)
                                .addComponent(label5))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(coodLoc1)
                                .addComponent(coodLoc2))))
                    .addGap(24, 24, 24))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(gridLoc1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label3)
                        .addComponent(coodLoc1))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(gridLoc2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label5)
                        .addComponent(coodLoc2))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label7)
                        .addComponent(distanceLbl)
                        .addComponent(calBtn))
                    .addContainerGap(25, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JTextField gridLoc1;
    private JTextField gridLoc2;
    private JLabel label3;
    private JLabel coodLoc1;
    private JLabel label5;
    private JLabel coodLoc2;
    private JLabel label7;
    private JLabel distanceLbl;
    private JButton calBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
