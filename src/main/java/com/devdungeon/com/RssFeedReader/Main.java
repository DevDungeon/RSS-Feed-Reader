package com.devdungeon.com.RssFeedReader;


/**
 *
 * 
 */
public class Main {
    
    public static void main(String[] args) {
        SettingsManager settingsManager = new SettingsManager();
        SettingsWindow settingsWindow = new SettingsWindow();
        settingsWindow.setVisible(true);
        
        // Activate tray
        SysTrayIcon.createAndShowTrayIcon();
    }
    
}

