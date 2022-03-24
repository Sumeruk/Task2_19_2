package com.company;

import ru.vsu.cs.util.ArrayUtils;
import ru.vsu.cs.util.JTableUtils;
import ru.vsu.cs.util.SwingUtils;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class FrameMain extends JFrame {
    private JPanel panelMain;
    private JTable tableInput;
    private JButton buttonLoadFromInputFile;
    private JButton buttonCreateNewList;
    private JButton buttonSaveToOutputFile;
    private JTable tableOutput;
    private JFileChooser fileChooserOpen;
    private JFileChooser fileChooserSave;

    public FrameMain() {
        this.setTitle("Создание замененного листа");
        this.setContentPane(panelMain);
        this.setBounds(125, 50, 300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        JTableUtils.initJTableForArray(tableInput, 50, false, true, false, true);
        JTableUtils.initJTableForArray(tableOutput, 50, false, true, false, true);
        tableInput.setRowHeight(30);
        tableOutput.setRowHeight(30);

        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("C:\\Users\\12\\IdeaProjects\\Task2_19_2\\"));
        fileChooserSave.setCurrentDirectory(new File("C:\\Users\\12\\IdeaProjects\\Task2_19_2\\"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        buttonLoadFromInputFile.addActionListener(actionEvent -> {
            try {
                if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {

                    int[] array = ArrayUtils.readIntArrayFromFile(fileChooserOpen.getSelectedFile().getPath());

                    assert array != null;
                    JTableUtils.writeArrayToJTable(tableInput, array);
                }
            } catch (Exception e) {
                SwingUtils.showInfoMessageBox("Невозможно прочитать данные из файла", "Ошибка");
            }
        });

        buttonSaveToOutputFile.addActionListener(actionEvent -> {
            try {
                if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                    int[] array = JTableUtils.readIntArrayFromJTable(tableOutput);

                    String file = fileChooserSave.getSelectedFile().getPath();
                    if (!file.toLowerCase().endsWith(".txt")) {
                        file += ".txt";
                    }
                    ArrayUtils.writeArrayToFile(file, array);
                }
            } catch (Exception e) {
                SwingUtils.showInfoMessageBox("Не удаётся сохранить в файл", "Ошибка");
            }
        });

        buttonCreateNewList.addActionListener(actionEvent -> {
            try {
                int[] array = JTableUtils.readIntArrayFromJTable(tableInput);
                assert array != null;
                DoublyLinkedList<Integer> list = DoublyLinkedListUtils.intToDoublyLinkedList(array);
                Logic logic = new Logic();
                logic.changeList(list, 0);

                JTableUtils.writeArrayToJTable(tableOutput, DoublyLinkedListUtils.convertToStringArray(list));
            } catch (Exception e) {
                SwingUtils.showInfoMessageBox("Каждая ячейка должна содержать число", "Ошибка");
            }
        });
    }
}