/*
 * Copyright (C) 2018 Andy Bond
 *
 * This file is part of gcConvert
 *
 * gcConvert is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * Version 3.0 as published by the Free Software Foundation
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package co.uk.abondservices.gcconvert;

import java.util.Arrays;
import javafx.scene.paint.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author andy
 */
public class KeyEditor extends javax.swing.JPanel {

    /**
     * Creates new form KeyEditor
     */
    public KeyEditor() {
        initComponents();
        Arrays.sort(labels);
        model = new DefaultComboBoxModel(labels);
        cboAndyMoteKeyName.setModel(model); 
//        txtHexCode.setOpaque(false);
//        cbxSelected.setBorder();.setBackground(java.awt.SystemColor.scrollbar);//control);//color(242, 241, 240));
    }
    
    private int index;
    static String labels[] = { "..Select..", "KEY_POWER","KEY_SUBTITLE","KEY_CLEAR",
        "KEY_TITLE","KEY_HOME","KEY_1","KEY_2","KEY_3","KEY_4","KEY_5","KEY_6",
        "KEY_7","KEY_8","KEY_9","KEY_0","KEY_EJECTCD","KEY_REWIND","KEY_PLAY",
        "KEY_FASTFORWARD","KEY_RECORD","KEY_PREVIOUS","KEY_STOP","KEY_PAUSE",
        "KEY_NEXT","KEY_SHUFFLE","KEY_CHANNELUP","KEY_PLAYPAUSE","KEY_UP","KEY_MUTE",
        "KEY_VOLUMEUP","KEY_CHANNELDOWN","KEY_LEFT","KEY_OK","KEY_RIGHT","KEY_VOLUMEDOWN",
        "KEY_MEDIA_REPEAT","KEY_BACK","KEY_DOWN","KEY_ENTER","KEY_REFRESH","KEY_EPG","KEY_FAVORITES",
        "KEY_CHANNEL","KEY_INFO","KEY_10CHANNELSUP","KEY_TEXT","KEY_OPTION","KEY_MENU","KEY_SETUP",
        "KEY_10CHANNELSDOWN","KEY_TV","KEY_DVD","KEY_AUX","KEY_AUDIO","KEY_TUNER","KEY_CD","KEY_RADIO",
        "KEY_SAT2","KEY_SAT","KEY_VIDEO","KEY_MP3","KEY_TAPE","KEY_TV2","KEY_PVR",
        "KEY_GAMES","KEY_NETWORK","KEY_USB","KEY_ADAPTER","KEY_NEXTINPUT",
        "KEY_PREVINPUT","KEY_SOURCE","KEY_BLURAY","KEY_TOOLS","KEY_DVR",
        "KEY_SLEEP","KEY_AUTO","KEY_ALC","KEY_ADV","KEY_LEFTCTRL","KEY_DISP",
        "KEY_PRESETUP","KEY_TUNEUP","KEY_FAVORITES","KEY_BASSUP","KEY_TREBUP",
        "KEY_PRESETDOWN","KEY_TUNEDOWN","KEY_BAND","KEY_BASSDOWN",
        "KEY_TREBDOWN","KEY_RED","KEY_GREEN","KEY_YELLOW","KEY_BLUE","KEY_X"
 };
    final DefaultComboBoxModel model;// = new DefaultComboBoxModel(labels);
    
    private KeyEditor.OnKeyEditorListener KeyEditorEvent;

    // Define interface
    public interface OnKeyEditorListener {
        public void OnCheckedStateChanged(KeyEditor keyEditor);
        public void OnAndyMoteKeyIndexChanged(KeyEditor keyEditor);
        public void OnUserDefinedNameChanged(KeyEditor keyEditor);
        // etc.. other events can be defined here
    }

    // Assign the listener implementing events interface that will receive the events
    public void setKeyEditorListener(KeyEditor.OnKeyEditorListener KeyEditorEvent) {
        this.KeyEditorEvent = KeyEditorEvent;
    }

    
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public boolean isChecked() {return cbxSelected.isSelected();}
    public String getName() {
        if (cbxSelected!=null){
            return cbxSelected.getText();
        } 
        return "";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        cbxSelected = new javax.swing.JCheckBox();
        txtHexCode = new javax.swing.JLabel();
        cboAndyMoteKeyName = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        txtUserDefinedKeyName = new javax.swing.JTextField();

        setMaximumSize(new java.awt.Dimension(32767, 28));

        cbxSelected.setBackground(new java.awt.Color(222, 216, 32));
        cbxSelected.setText("very very very Long Keyname");
        cbxSelected.setToolTipText("Check to select key for use in LIRC Conf file");
        cbxSelected.setBorder(null);
        cbxSelected.setBorderPainted(true);
        cbxSelected.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cbxSelected.setMaximumSize(new java.awt.Dimension(250, 27));
        cbxSelected.setMinimumSize(new java.awt.Dimension(250, 27));
        cbxSelected.setPreferredSize(new java.awt.Dimension(250, 27));
        cbxSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSelectedActionPerformed(evt);
            }
        });

        txtHexCode.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        txtHexCode.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtHexCode.setText("jLabel1");
        txtHexCode.setBorder(null);
        txtHexCode.setMaximumSize(new java.awt.Dimension(100, 15));

        cboAndyMoteKeyName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        cboAndyMoteKeyName.setToolTipText("AndyMOTE KeyName");
        cboAndyMoteKeyName.setMaximumSize(new java.awt.Dimension(150, 27));
        cboAndyMoteKeyName.setMinimumSize(new java.awt.Dimension(150, 27));
        cboAndyMoteKeyName.setName(""); // NOI18N
        cboAndyMoteKeyName.setPreferredSize(new java.awt.Dimension(150, 27));
        cboAndyMoteKeyName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboAndyMoteKeyNameActionPerformed(evt);
            }
        });

        jPanel1.setMaximumSize(new java.awt.Dimension(200, 27));
        jPanel1.setMinimumSize(new java.awt.Dimension(200, 37));
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 27));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        txtUserDefinedKeyName.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtUserDefinedKeyName.setToolTipText("User Defined KeyName");
        txtUserDefinedKeyName.setMaximumSize(new java.awt.Dimension(50, 27));
        txtUserDefinedKeyName.setMinimumSize(new java.awt.Dimension(50, 27));
        txtUserDefinedKeyName.setPreferredSize(new java.awt.Dimension(200, 27));
        txtUserDefinedKeyName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserDefinedKeyNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cbxSelected, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHexCode, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboAndyMoteKeyName, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUserDefinedKeyName, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(cbxSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtHexCode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(cboAndyMoteKeyName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtUserDefinedKeyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbxSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSelectedActionPerformed

        if (cbxSelected.isSelected()){ 
            if (txtUserDefinedKeyName.getText().length()==0){
                txtUserDefinedKeyName.setText(cbxSelected.getText().replace(" ", "_"));
            }
        }  else {
            txtUserDefinedKeyName.setVisible(true);
            cboAndyMoteKeyName.setSelectedIndex(0);
        }  
        KeyEditorEvent.OnCheckedStateChanged(this);
        KeyEditorEvent.OnAndyMoteKeyIndexChanged(this);
        KeyEditorEvent.OnUserDefinedNameChanged(this);
    }//GEN-LAST:event_cbxSelectedActionPerformed

    private void cboAndyMoteKeyNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboAndyMoteKeyNameActionPerformed

        txtUserDefinedKeyName.setVisible(cboAndyMoteKeyName.getSelectedIndex()==0);
        if (!cbxSelected.isSelected()) { 
            cbxSelected.setSelected(cboAndyMoteKeyName.getSelectedIndex()!=0);
            KeyEditorEvent.OnCheckedStateChanged(this);
        }
        if (cboAndyMoteKeyName.getSelectedIndex()==0) {
            cbxSelectedActionPerformed(evt);
        }
        this.invalidate();
        
    }//GEN-LAST:event_cboAndyMoteKeyNameActionPerformed

    private void txtUserDefinedKeyNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserDefinedKeyNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserDefinedKeyNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboAndyMoteKeyName;
    private javax.swing.JCheckBox cbxSelected;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel txtHexCode;
    private javax.swing.JTextField txtUserDefinedKeyName;
    // End of variables declaration//GEN-END:variables

    public JComboBox<String> getCboAndyMoteKeyName() {
        return cboAndyMoteKeyName;
    }

    public JCheckBox getCbxSelected() {
        return cbxSelected;
    }

    public JLabel getTxtHexCode() {
        return txtHexCode;
    }
    


    public JTextField getTxtUserDefinedKeyName() {
        return txtUserDefinedKeyName;
    }
    public int getAndyMoteIndex(){
        return cboAndyMoteKeyName.getSelectedIndex();
    }


}