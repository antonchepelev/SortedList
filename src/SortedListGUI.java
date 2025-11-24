import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SortedListGUI extends JFrame {
    private SortedList sortedList;
    private JTextArea display;
    private JTextField input;

    public SortedListGUI() {
        sortedList = new SortedList();
        display = new JTextArea(10, 30);
        input = new JTextField(20);

        JButton addButton = new JButton("Add");
        JButton searchButton = new JButton("Search");

        addButton.addActionListener(e -> {
            String text = input.getText();
            if (!text.isEmpty()) {
                sortedList.add(text);
                display.append("Added: " + text + "\n");
                display.append("List: " + sortedList + "\n\n");
                input.setText("");
            }
        });

        searchButton.addActionListener(e -> {
            String text = input.getText();
            if (!text.isEmpty()) {
                int index = sortedList.search(text);
                if (index < sortedList.toString().length() &&
                        sortedList.toString().contains(text)) {
                    display.append("Found: " + text + " at index " + index + "\n\n");
                } else {
                    display.append("Not found. Would be at index " + index + "\n\n");
                }
                input.setText("");
            }
        });

        setLayout(new FlowLayout());
        add(input);
        add(addButton);
        add(searchButton);
        add(new JScrollPane(display));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new SortedListGUI();
    }
}
