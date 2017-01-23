package utils;

import javax.swing.JLabel;

public class UpdateUtils {
    
    public static void updateLabelCardRemaining(final JLabel lblCardRemaining, final int size) {
        lblCardRemaining.setText(String.valueOf(size));
    }
}
