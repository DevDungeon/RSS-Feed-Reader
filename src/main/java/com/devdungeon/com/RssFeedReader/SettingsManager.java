/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devdungeon.com.RssFeedReader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author johnd
 */
public class SettingsManager {

    private static final Path configDir = Paths.get(
            System.getProperty("user.home"), ".config", "rss-feed-reader"
    );
    private static final String feedListFilename = "feed-list.txt";

    public SettingsManager() {
        ensureConfigDirectoryExists();
        // Open feed list file for reading/writing. Create if doesn't exist.
//        File feedListFile = openFeedListFile()
    }

    private void ensureConfigDirectoryExists() {
        try {
            Files.createDirectories(configDir);
        } catch (IOException ex) {
            Logger.getLogger(SettingsManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // loadSettingsFromFile(~/.config/rss-feed-reader/feed-list.txt
    // String homeDir = System.getProperty("user.home");
    /*
    File directory = new File(directoryName);
    if (! directory.exists()){
        directory.mkdir();
        // If you require it to make the entire directory path including parents,
        // use directory.mkdirs(); here instead.
    }
    // Check if file exists
     */
    // saveSettingsToFile(feedURLs) {
    // 
    // updateSettings

//    private boolean feedListFileExists() {
//        Path settingsFilePath = Paths.get(configDir.toString(), feedListFilename);
//        File feedListFile = new File(settingsFilePath.toString());
//        return (feedListFile.exists() && feedListFile.isFile());
//    }
}
