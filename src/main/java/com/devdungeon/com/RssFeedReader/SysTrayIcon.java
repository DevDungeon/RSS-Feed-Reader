/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devdungeon.RssFeedReader;

import java.awt.AWTException;
import java.awt.CheckboxMenuItem;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author johnd
 */
public class SysTrayIcon {

    // Menu items:
    // Exit, Settings, Refresh all, then, a list of all feed sources. Bold if there are new items
    public static void createAndShowTrayIcon() {

        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
        final SystemTray tray = SystemTray.getSystemTray();
        final TrayIcon trayIcon = new TrayIcon(createImage("/logos/lettermark-64x64.png", "RSS Feed Reader"));
        trayIcon.setImageAutoSize(true);
        
        // Create a popup menu components
        final PopupMenu popup = new PopupMenu();
        MenuItem exitItem = new MenuItem("Exit");
        MenuItem aboutItem = new MenuItem("About");

        Menu feedMenu = new Menu("Feed ABC");
        MenuItem errorItem = new MenuItem("News Item 1");
        MenuItem warningItem = new MenuItem("News Item 2");
        MenuItem infoItem = new MenuItem("News Item 3");
        MenuItem noneItem = new MenuItem("News Item 4");

        //Add components to popup menu in order
        popup.add(aboutItem);
        popup.addSeparator();
        popup.addSeparator();
        popup.add(feedMenu);
        feedMenu.add(errorItem);
        feedMenu.add(warningItem);
        feedMenu.add(infoItem);
        feedMenu.add(noneItem);
        popup.add(exitItem);

        
        trayIcon.setPopupMenu(popup);

                
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
            return;
        }

        trayIcon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "This dialog box is run from System Tray");
            }
        });

        aboutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                JOptionPane.showMessageDialog(null,
                        "This dialog box is run from the About menu item");
            }
        });

   
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuItem item = (MenuItem) e.getSource();
                //TrayIcon.MessageType type = null;
                System.out.println(item.getLabel());
                if ("Error".equals(item.getLabel())) {
                    //type = TrayIcon.MessageType.ERROR;
                    trayIcon.displayMessage("Sun TrayIcon Demo",
                            "This is an error message", TrayIcon.MessageType.ERROR);

                } else if ("Warning".equals(item.getLabel())) {
                    //type = TrayIcon.MessageType.WARNING;
                    trayIcon.displayMessage("Sun TrayIcon Demo",
                            "This is a warning message", TrayIcon.MessageType.WARNING);

                } else if ("Info".equals(item.getLabel())) {
                    //type = TrayIcon.MessageType.INFO;
                    trayIcon.displayMessage("Sun TrayIcon Demo",
                            "This is an info message", TrayIcon.MessageType.INFO);

                } else if ("None".equals(item.getLabel())) {
                    //type = TrayIcon.MessageType.NONE;
                    trayIcon.displayMessage("Sun TrayIcon Demo",
                            "This is an ordinary message", TrayIcon.MessageType.NONE);
                }
            }
        };

        errorItem.addActionListener(listener);
        warningItem.addActionListener(listener);
        infoItem.addActionListener(listener);
        noneItem.addActionListener(listener);

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tray.remove(trayIcon);
                System.exit(0);
            }
        });
        
        System.out.println("Setting image auto size to true.");
        
    }

    //Obtain the image URL
    protected static Image createImage(String path, String description) {
        URL imageURL = SysTrayIcon.class.getResource(path);

        if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }
}
