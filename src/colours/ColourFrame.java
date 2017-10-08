/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colours;

/**
 *
 * @author Van Do
 */

import java.awt.Color;
import java.util.*;
import javax.swing.*;

public class ColourFrame extends javax.swing.JFrame 
{
    // Access File class methods
    File file = new File();
    // Set a list as an array list to store ColorRainbow objects
    List<ColorRainbow> list = new ArrayList<>();
    // Access ColorParser class methods
    ColorParser parse = new ColorParser();
    // Access ColorRainbow class methods and use it as an object
    ColorRainbow colours = new ColorRainbow();
    // Set default list model when the serialize string is added to the list box
    DefaultListModel model = new DefaultListModel();
    // Create new frame to display colours
    JFrame frame = new JFrame("Colors");
    // Create new panel for new frame
    JPanel panel = new JPanel();
    /**
     * Creates new form ColourFrame
     */
    public ColourFrame() 
    {
        initComponents();
        // Create tool tips for the control in the main frame
        btnJsonFile.setToolTipText("Read .json file or json formatted file and display colours' details.");
        btnTextFile.setToolTipText("Read .txt file and display colours' details.");
        listColour.setToolTipText("Display JSON string from colours.");
        txtJsonFile.setToolTipText("Enter .json file.");
        txtTextFile.setToolTipText("Enter .txt file.");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTextFile = new javax.swing.JLabel();
        lblJsonFile = new javax.swing.JLabel();
        txtTextFile = new javax.swing.JTextField();
        txtJsonFile = new javax.swing.JTextField();
        btnTextFile = new javax.swing.JButton();
        btnJsonFile = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listColour = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rainbow of Colours");

        lblTextFile.setText("Enter text file");

        lblJsonFile.setText("Enter JSON formatted File");

        btnTextFile.setText("Read Text File and Show Colour Data");
        btnTextFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTextFileActionPerformed(evt);
            }
        });

        btnJsonFile.setText("Read Json File and Show Colour Data");
        btnJsonFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJsonFileActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listColour);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblJsonFile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtJsonFile, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnJsonFile))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTextFile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTextFile, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTextFile)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTextFile)
                    .addComponent(txtTextFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTextFile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJsonFile)
                    .addComponent(txtJsonFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnJsonFile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Click on this button to display colors details from another frame from a text file.
     * @param evt event happened in button
     */
    private void btnTextFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTextFileActionPerformed
        // Click to read a text file and serialize and deserialize data into JSON string and list of colours
        // Set list by reading through a file and stored ColorRainbow objects
        // Read a file from the text box
        list = file.getFromTextFile(txtTextFile.getText()); 
        // Check if list is not empty
        if(!checkListNotEmpty())
        {
            // Set output by the list serializes into JSON string
            String output = parse.serializeColours(list);
            // Set list box's model from default list model
            listColour.setModel(model);
            // Add output as list item to model
            model.addElement(output);
            // Deserialize output back to list of ColorRainbow objects
            List<ColorRainbow> rainbow = parse.deserializeColours(output);
            // Display colours' details
            displayColor(rainbow);
        }
        else 
        {
            // If list is empty, display message
            JOptionPane.showMessageDialog(null, "List of colours is empty.", "No Colours Added", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnTextFileActionPerformed
    /**
     * This method called a JSON-formatted file and display color details from another frame
     */
    private void btnJsonFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJsonFileActionPerformed
        // Read a JSON-formatted file from text box's file name and store into list
        list = file.getFromJsonFile(txtJsonFile.getText()); 
        // Check if list is not empty
        if(!checkListNotEmpty())
        {
            // Set output by serialize the list of colours into JSON string
            String output = parse.serializeColours(list);
            // Set model for this list box
            listColour.setModel(model);
            // Add JSON string from model to display the JSON string
            model.addElement(output);
            // Deserialize the JSON string back to list of colours
            List<ColorRainbow> rainbow = parse.deserializeColours(output);
            // Display colour data from another frame
            displayColor(rainbow);
        }
        else 
        {
            // Display message box if list is empty
            JOptionPane.showMessageDialog(null, "List of colours is empty.", "No Colours Added", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnJsonFileActionPerformed

    private Boolean checkListNotEmpty()
    {
        // If the list is empty, return true , otherwise return false
        if(list.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    private void displayColor(List<ColorRainbow> rainbow)
    {
        try
        {
            // Create an array of label and set size using the list's size
            // It is not using list because it causes duplicated labels
            JLabel[] labelList = new JLabel[rainbow.size()];
            // Set count to 0
            int count = 0;
            // Iterate each colour in a rainbow
            for(ColorRainbow color : rainbow)
            {
                // Create new label, set label's text into visible empty space to see the colour easily
                JLabel label = new JLabel("     ");
                // Build strings when adding tooltip to the label
                StringBuilder build = new StringBuilder();
                // Using html component to design a label to make a readable label
                build.append("<html>" + "<b>Colour name: </b>").append(color.getName()).append("<br/>");
                build.append("<b>Colour hex code: </b>").append(color.getHexCode()).append("<br/>");
                build.append("<b>Colour RGBA: </b>").append(Arrays.toString(color.getRGBA())).append("</html>");
                label.setToolTipText(build.toString());
                // Set label's background for this colour to display the details to the correct colour
                label.setBackground(Color.decode(color.getHexCode()));
                // Set label to opaque to easily see the colour to avoid label to not able to see through
                label.setOpaque(true);
                // Set label to element at this index in array of labels
                labelList[count] = label;
                // Increment count by 1 to add next label
                count++;
            }
            // Iterate each label in a label list
            for(JLabel labels : labelList)
            {
                // Add label to a panel
                panel.add(labels);
            }
            // Add panel to a new frame
            frame.add(panel);
            // Set new frame's title
            frame.setTitle("Display Colors");
            // Set size of new frame by the number of labels lengthwise
            frame.pack();
            // Display this frame
            frame.setVisible(true);
        }
        catch(NumberFormatException error)
        {
            // Catch error when hex code is unable to convert to colour by mistake
            System.out.println("Error message: " + error);
            JOptionPane.showMessageDialog(null, "Please check file correctly.", "Problem With File", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ColourFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ColourFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ColourFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ColourFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new ColourFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJsonFile;
    private javax.swing.JButton btnTextFile;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblJsonFile;
    private javax.swing.JLabel lblTextFile;
    private javax.swing.JList<String> listColour;
    private javax.swing.JTextField txtJsonFile;
    private javax.swing.JTextField txtTextFile;
    // End of variables declaration//GEN-END:variables
}
