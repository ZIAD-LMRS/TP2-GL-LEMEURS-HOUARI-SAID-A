/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.core.launcher;

import java.beans.PropertyChangeEvent;
import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;


/**
 *
 * @author User
 */
public class Afficheur extends javax.swing.JFrame implements TimerChangeListener  {

    /**
     * Creates new form afficheur
     */
    public Afficheur() {
        initComponents();
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hourLabel = new javax.swing.JLabel();
        minLabel = new javax.swing.JLabel();
        secLabel = new javax.swing.JLabel();
        disSecLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        hourLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        hourLabel.setText("12");
        hourLabel.setName(""); // NOI18N

        minLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        minLabel.setText("12");

        secLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        secLabel.setText("12");

        disSecLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        disSecLabel.setText("12");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(hourLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(minLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(secLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(disSecLabel)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(secLabel)
                    .addComponent(disSecLabel)
                    .addComponent(minLabel)
                    .addComponent(hourLabel))
                .addContainerGap(136, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel disSecLabel;
    private javax.swing.JLabel hourLabel;
    private javax.swing.JLabel minLabel;
    private javax.swing.JLabel secLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void propertyChange(String propertyName, Object oldValue, Object newValue) {
       TimerService ts = Lookup.getInstance().getService(TimerService.class);
        hourLabel.setText(String.valueOf(ts.getHeures()));
        minLabel.setText(String.valueOf(ts.getMinutes()));
        secLabel.setText(String.valueOf(ts.getSecondes()));
        disSecLabel.setText(String.valueOf(ts.getDixiemeDeSeconde()));
        
    }

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        if(pce.getPropertyName()==DIXEME_DE_SECONDE_PROP)
            disSecLabel.setText(String.valueOf((Integer)pce.getNewValue()));
        else if(pce.getPropertyName()==SECONDE_PROP)
            incSecLabel();
        else if(pce.getPropertyName()==MINUTE_PROP)
            incMinLabel();
        else 
            incHourLabel();
        
    }
    
    public void incSecLabel(){
        String secBefore=secLabel.getText();
        int secNow=Integer.parseInt(secBefore)+1;
        secLabel.setText(String.valueOf(secNow%60));
    }
   
    public void incMinLabel(){
        String hourBefore=minLabel.getText();
        int hourNow=Integer.parseInt(hourBefore)+1;
        minLabel.setText(String.valueOf(hourNow%60));
    }
    
    public void incHourLabel(){
        String hourBefore=hourLabel.getText();
        int hourNow=Integer.parseInt(hourBefore)+1;
        hourLabel.setText(String.valueOf(hourNow%24));
    }
    
    public void makeIncHourFontSizeBigger(){
       hourLabel.setFont(new java.awt.Font("Tahoma", 0, 30));
    }
    
    public void makeIncMinFontSizeBigger(){
        minLabel.setFont(new java.awt.Font("Tahoma", 0, 30));
    }
    
    public void makeIncSecFontSizeBigger(){
        secLabel.setFont(new java.awt.Font("Tahoma", 0, 30));
    }
    public void makeIncHourFontSizeSmaller(){
       hourLabel.setFont(new java.awt.Font("Tahoma", 0, 24));
    }
    
    public void makeIncMinFontSizeSmaller(){
        minLabel.setFont(new java.awt.Font("Tahoma", 0, 24));
    }
    
    public void makeIncSecFontSizeSmaller(){
        secLabel.setFont(new java.awt.Font("Tahoma", 0, 24));
    }
    
    public void setHourLabel(String hourLabel) {
        this.hourLabel.setText(hourLabel);
    }

    public void setMinLabel(String minLabel) {
        this.minLabel.setText(minLabel);
    }

    public void setSecLabel(String secLabel) {
        this.secLabel.setText(secLabel);
    }

    public void setDisSecLabel(String disSecLabel) {
        this.disSecLabel.setText(disSecLabel);
    }
    
    
}
