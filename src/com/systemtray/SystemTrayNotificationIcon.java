package com.systemtray;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.io.IOException;

/**
 * The Class SystemTrayNotificationIcon.
 * 
 * @author Subash
 * 
 */
public class SystemTrayNotificationIcon {

    /**
     * The main method.
     *
     * @param args the arguments
     * @throws AWTException the AWT exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void main(String[] args) {
        if (SystemTray.isSupported()) {
            SystemTrayNotificationIcon td = new SystemTrayNotificationIcon();
            try {
				td.createSystemTrayWithIcon();
			} catch (AWTException | IOException e) {
				e.printStackTrace();
			}
        } else {
            System.out.println("System tray not supported for this one!");
        }
    }

    /**
     * Display tray.
     *
     * @throws AWTException the AWT exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void createSystemTrayWithIcon() throws AWTException, IOException {
    	
    	// Get the system tray icon instance
        SystemTray tray = SystemTray.getSystemTray();
        
        // Create an image from your resource folder
        Image image = Toolkit.getDefaultToolkit().createImage("icons/sample.png");
        
        // Create a TrayIcon and add the image so it will add in the icons
        TrayIcon trayIcon = new TrayIcon(image, "tray Icon demo");
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("Install this update to get all the features!!");
        tray.add(trayIcon);
        
        // use MessageType.INFO for information type notification
        // use MessageType.ERROR for error type notification
        // use MessageType.WARNING for warning type notification
        trayIcon.displayMessage("An update available!!!", "knock knock.., please open the door!!", MessageType.INFO);
    }
    
    
    
}
