package menu;

import constants.Constants;
import engine.Painter;
import gameobject.Player;
import state.GlobalState;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class FileMenu extends JMenu {

    public FileMenu () {
        super(Constants.MENUS.file.name());

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals(Constants.FILE_MENUS.open.name())) {
                    JFileChooser fileChooser = new JFileChooser();
                    int r = fileChooser.showOpenDialog(null);

                    if (r == JFileChooser.APPROVE_OPTION) {
                        try {
                            FileInputStream fis = new FileInputStream(fileChooser.getSelectedFile());
                            ObjectInputStream ois = new ObjectInputStream(fis);
                            Player player = (Player) ois.readObject();

                            GlobalState.globalState.loadPlayer(player);
                            Painter.getInstance().update();

                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        } catch (ClassNotFoundException classNotFoundException) {
                            classNotFoundException.printStackTrace();
                        }
                    }

                } else if (e.getActionCommand().equals(Constants.FILE_MENUS.save.name())) {
                    JFileChooser fileChooser = new JFileChooser();
                    int r = fileChooser.showSaveDialog(null);

                    if (r == JFileChooser.APPROVE_OPTION) {
                        try {
                            FileOutputStream fos = new FileOutputStream(fileChooser.getSelectedFile());
                            ObjectOutputStream oos = new ObjectOutputStream(fos);
                            oos.writeObject(GlobalState.globalState.player);
                            oos.close();
                            fos.close();
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                }
            }
        };

        for (Constants.FILE_MENUS m: Constants.FILE_MENUS.values()) {
            JMenuItem menuItem = new JMenuItem(m.name());
            menuItem.setActionCommand(m.name());
            menuItem.addActionListener(listener);
            this.add(menuItem);
        }
    }
}
