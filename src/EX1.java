import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EX1 {
    private JFrame frame;
    private JPanel panel;
    private JButton addButton;
    private JButton resetButton;
    private List<JButton> buttons;

    private int buttonCounter;

    public EX1() {
        frame = new JFrame("Ajouter et Supprimer des Boutons");
        panel = new JPanel();
        addButton = new JButton("Add");
        resetButton = new JButton("Reset");
        buttons = new ArrayList<>();
        buttonCounter = 1;

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addButton("Bouton " + buttonCounter);
                buttonCounter++;
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAllButtons();
            }
        });

        panel.add(addButton);
        panel.add(resetButton);
        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    private void addButton(String buttonText) {
        JButton button = new JButton(buttonText);
        buttons.add(button);
        panel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttons.remove(button);
                panel.remove(button);
                frame.revalidate();
                frame.repaint();
            }
        });

        frame.revalidate();
        frame.repaint();
    }

    private void removeAllButtons() {
        for (JButton button : buttons) {
            panel.remove(button);
        }
        buttons.clear();
        frame.revalidate();
        frame.repaint();
    }

}

