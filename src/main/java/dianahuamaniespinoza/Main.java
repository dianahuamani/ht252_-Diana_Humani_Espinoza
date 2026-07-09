package dianahuamaniespinoza;

import dianahuamaniespinoza.view.FrmPrincipal;
import javax.swing.UIManager;

public class Main {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(() -> {
            FrmPrincipal frm = new FrmPrincipal();
            frm.setLocationRelativeTo(null);
            frm.setVisible(true);
        });
    }
}
