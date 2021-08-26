package queryrunner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author mckeem
 */

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class QueryFrame extends JFrame {
    private Image img;
    private String imgName = "cover.png";

    /**
     * This is the constructer for QueryFrame. It will initialize the Combobox with
     * the various queries that are part of the QueryData that has been passed to it.
     * It will also set the default state of the Command Buttons and combo boxes.
     * @param queryrunnerObj
     */

    public QueryFrame(QueryRunner queryrunnerObj) {

        //  this.setSize(1200,700);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(lightPurple);
        this.setVisible(true);



        initComponents();
        m_parmlabels = new JLabel[]{jLabel1, jLabel2, jLabel3, jLabel4, jLabel9, jLabel10, jLabel11, jLabel12};
        m_textvals = new JTextField[] { jTextField5, jTextField6,jTextField7,jTextField8,jTextField9,jTextField10,jTextField11,jTextField12};
        m_queryrunner = queryrunnerObj;
        // Find out how many queries there are and set up combox box
        // If it is a grid query, then enable jtable
        int nAmt = m_queryrunner.GetTotalQueries();

        for (int i=0; i < nAmt; i++)
        {
            this.jComboBoxQuery.addItem("Query " + (i+1));
        }
        jComboBoxQuery.setEnabled(false);
        jBtnRunQuery.setEnabled(false);

        jLabel14.setText(m_queryrunner.GetProjectTeamApplication());
    }




    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldDatabase = new JTextField();
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jScrollPane2 = new JScrollPane();
        jTextArea2 = new JTextArea();
        jTextHostname = new JTextField();
        jTextFieldUser = new JTextField();
        jPanel1 = new JPanel();
        jTextField5 = new JTextField();
        jTextField6 = new JTextField();
        jTextField7 = new JTextField();
        jTextField8 = new JTextField();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        jLabel11 = new JLabel();
        jLabel12 = new JLabel();
        jTextField9 = new JTextField();
        jTextField10 = new JTextField();
        jTextField11 = new JTextField();
        jTextField12 = new JTextField();
        jPanel2 = new JPanel();
        jComboBoxQuery = new JComboBox<>();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jConnectButton = new JButton();
        jBtnRunQuery = new JButton();
        jPasswordField1 = new JPasswordField();
        jLabel13 = new JLabel();
        jLabel14 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new AbsoluteLayout());

        jTextFieldDatabase.setNextFocusableComponent(jConnectButton);
        getContentPane().add(jTextFieldDatabase, new AbsoluteConstraints(130, 140, 120, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);


        getContentPane().add(jScrollPane1, new AbsoluteConstraints(280, 40, 310, 140));

        jTextArea2.setColumns(20);
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        getContentPane().add(jScrollPane2, new AbsoluteConstraints(610, 40, 310, 140));

        jTextHostname.setNextFocusableComponent(jTextFieldUser);
        getContentPane().add(jTextHostname, new AbsoluteConstraints(130, 50, 120, -1));

        jTextFieldUser.setNextFocusableComponent(jPasswordField1);
        getContentPane().add(jTextFieldUser, new AbsoluteConstraints(130, 80, 120, -1));



        jPanel1.setLayout(new AbsoluteLayout());

        jPanel1.add(jTextField5, new AbsoluteConstraints(160, 26, 149, -1));
        jPanel1.add(jTextField6, new AbsoluteConstraints(457, 26, 190, -1));
        jPanel1.add(jTextField7, new AbsoluteConstraints(771, 26, 160, -1));
        jPanel1.add(jTextField8, new AbsoluteConstraints(160, 64, 150, -1));

        jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel1.setText("avx");
        jLabel1.setToolTipText("");
        jPanel1.add(jLabel1, new AbsoluteConstraints(18, 29, 132, -1));

        jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel2.setText("aaa");
        jLabel2.setToolTipText("");
        jPanel1.add(jLabel2, new AbsoluteConstraints(333, 29, 120, -1));

        jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel3.setText("aaa");
        jLabel3.setToolTipText("");
        jPanel1.add(jLabel3, new AbsoluteConstraints(652, 29, 115, -1));

        jLabel4.setBackground(new Color(220, 186, 196));
        jLabel4.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel4.setText("aaa");
        jLabel4.setToolTipText("");
        jPanel1.add(jLabel4, new AbsoluteConstraints(18, 65, 132, 18));

        jLabel9.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel9.setText("yyy");
        jLabel9.setToolTipText("");
        jPanel1.add(jLabel9, new AbsoluteConstraints(343, 67, 110, -1));

        jLabel10.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel10.setText("rrr");
        jLabel10.setToolTipText("");
        jPanel1.add(jLabel10, new AbsoluteConstraints(651, 67, 116, -1));

        jLabel11.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel11.setText("iii");
        jLabel11.setToolTipText("");
        jPanel1.add(jLabel11, new AbsoluteConstraints(27, 102, 123, -1));

        jLabel12.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel12.setText("ooo");
        jLabel12.setToolTipText("");
        jPanel1.add(jLabel12, new AbsoluteConstraints(353, 102, 100, -1));
        jPanel1.add(jTextField9, new AbsoluteConstraints(459, 64, 188, -1));
        jPanel1.add(jTextField10, new AbsoluteConstraints(771, 64, 160, -1));
        jPanel1.add(jTextField11, new AbsoluteConstraints(160, 99, 150, -1));
        jPanel1.add(jTextField12, new AbsoluteConstraints(457, 99, 190, -1));

        // parameter box
        getContentPane().add(jPanel1, new AbsoluteConstraints(55, 220, 980, 70));
        //getContentPane().add(jPanel1, new AbsoluteConstraints(277, 200, 315, 60));

        jPanel2.setLayout(new BorderLayout());
        getContentPane().add(jPanel2, new AbsoluteConstraints(40, 350, 950, 240));

        jComboBoxQuery.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        getContentPane().add(jComboBoxQuery, new AbsoluteConstraints(280, 190, 120, -1));

        jLabel5.setText("Database");
        getContentPane().add(jLabel5, new AbsoluteConstraints(20, 140, 90, 10));

        jLabel6.setText("Hostname");
        getContentPane().add(jLabel6, new AbsoluteConstraints(20, 50, 90, -1));

        jLabel7.setText("User");
        getContentPane().add(jLabel7, new AbsoluteConstraints(20, 80, 100, -1));

        jLabel8.setText("Password");
        getContentPane().add(jLabel8, new AbsoluteConstraints(20, 110, 80, -1));

        jConnectButton.setText("Connect");
        jConnectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jConnectButton, new AbsoluteConstraints(130, 190, -1, -1));

        jBtnRunQuery.setText("Run Query");
        jBtnRunQuery.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnRunQuery, new AbsoluteConstraints(496, 190, -1, -1));


        jPasswordField1.setText("jPasswordField1");
        jPasswordField1.setNextFocusableComponent(jTextFieldDatabase);
        getContentPane().add(jPasswordField1, new AbsoluteConstraints(130, 110, 120, -1));

        jLabel13.setText("Output");
        getContentPane().add(jLabel13, new AbsoluteConstraints(760, 190, -1, -1));

        jLabel14.setFont(new Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel14.setText("VVV");
        getContentPane().add(jLabel14, new AbsoluteConstraints(370, 10, 180, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents



    /**
     * This button will use the data from the textboxes, and attempt to connect to the MYSQL Server. If it is not connected, it will
     * call the CONNECT function, otherwise it will call the DISCONNECT Function.
     * @param evt
     */
    private void jButton1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        boolean  bOK=true;
        jTextArea2.setText("");

        if (jConnectButton.getText() == "Connect")
        {
            bOK = m_queryrunner.Connect(this.jTextHostname.getText(), this.jTextFieldUser.getText(), String.valueOf(this.jPasswordField1.getPassword()), this.jTextFieldDatabase.getText());
            if (bOK == true)
            {
                jConnectButton.setText("Disconnect");
                jComboBoxQuery.setEnabled(true);
                jBtnRunQuery.setEnabled(true);
            }
        }
        else
        {
            bOK = m_queryrunner.Disconnect();
            if (bOK == true)
            {
                jConnectButton.setText("Connect");
                jComboBoxQuery.setEnabled(false);
                jBtnRunQuery.setEnabled(false);
            }
        }

        if (bOK == false)
        {
            this.jTextArea2.setText(m_queryrunner.GetError());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * This event handler recognizes when something has changed regarding the
     * drop down box. It will recognize which one is selected and get the correct
     * Query Data that it will then use to populate the TextArea that display's the
     * query. It will also recognize if it is a "parameter" query. If it is, it will
     * make the PANEL Control which holds the parameter data to be visible, and will
     * put the appropriate parameter labels along with their textboxes.
     *
     * @param evt
     */
    private void jComboBox1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

        jTextArea2.setText("");
        String szChoice = (String)jComboBoxQuery.getSelectedItem();
        String szStripChoice = szChoice.substring(6);
        m_queryChoice = Integer.parseInt(szStripChoice)-1;
        String szQuery = m_queryrunner.GetQueryText(m_queryChoice);
        this.jTextArea1.setText(szQuery);
        System.out.println("choice is " + szChoice);
        this.jPanel2.setVisible(false);

        if (this.m_queryrunner.isParameterQuery(m_queryChoice))
        {
            this.jPanel1.setVisible(true);
            int nAmt = this.m_queryrunner.GetParameterAmtForQuery(m_queryChoice);
            for (int i=0; i< nAmt; i++)
            {
                m_parmlabels[i].setVisible(true);
                m_parmlabels[i].setText(m_queryrunner.GetParamText(m_queryChoice, i));
                m_textvals[i].setVisible(true);
                m_textvals[i].setText("");
            }

            for (int i = nAmt; i < 8; i++)
            {
                m_parmlabels[i].setVisible(false);
                m_textvals[i].setVisible(false);
            }
        }
        else
        {
            this.jPanel1.setVisible(false);
        }

    }//GEN-LAST:event_jComboBox1ActionPerformed


    /**
     * This is the Action handler for the "RUN QUERY" button. It tries to identify
     * If it is an action query first. If it is, it will take the parameter data from
     * the various textboxes and create a parameter array that it will eventually pass
     * to the ExecuteQuery function.
     *
     * If it is a query that returns a resultset, it will create a JTABLE which is a
     * GUI Control that enables the resultset data to transferred to it.
     * @param evt Java Event Handler
     */
    private void jButton2ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        jTextArea2.setText("");
        if (this.m_queryrunner.isActionQuery(m_queryChoice) == false)
            jPanel2.setVisible(true);

        int nAmt = this.m_queryrunner.GetParameterAmtForQuery(m_queryChoice);
        String [] parmstring={};
        String [] headers;
        String [][] allData;


        boolean  bOK = true;

        if (this.m_queryrunner.isParameterQuery(m_queryChoice))
        {
            parmstring = new String [nAmt];
            for (int i=0; i< nAmt; i++)
            {
                parmstring[i] = this.m_textvals[i].getText();
            }
        }

        if (this.m_queryrunner.isActionQuery(m_queryChoice))
        {
            bOK = m_queryrunner.ExecuteUpdate(m_queryChoice, parmstring);
            if (bOK == true)
            {
                this.jTextArea2.setText(("Rows affected = " + m_queryrunner.GetUpdateAmount()));
            }
            else
            {
                this.jTextArea2.setText(m_queryrunner.GetError());
            }
        }
        else
        {
            bOK = m_queryrunner.ExecuteQuery(m_queryChoice, parmstring);
            if (bOK ==true)
            {
                headers = m_queryrunner.GetQueryHeaders();
                allData = m_queryrunner.GetQueryData();
                if (m_scrollPane != null)
                {
                    m_scrollPane.remove(m_jTable);
                    jPanel2.remove(m_scrollPane);
                }
                m_jTable = new JTable(allData, headers);

                m_jTable.setBounds(100, 100, 100, 80);
                Color ivory=new Color(255, 230, 217);
                m_jTable.setOpaque(false);
                m_jTable.setBackground(ivory);

                m_scrollPane = new JScrollPane(m_jTable);
                jPanel2.add(m_scrollPane);// add table in panel using add() method
                this.setVisible(true);
            }
            else
            {
                this.jTextArea2.setText(m_queryrunner.GetError());
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton jConnectButton;
    private JButton jBtnRunQuery;
    private JComboBox<String> jComboBoxQuery;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPasswordField jPasswordField1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTextArea jTextArea1;
    private JTextArea jTextArea2;
    private JTextField jTextFieldDatabase;
    private JTextField jTextField10;
    private JTextField jTextField11;
    private JTextField jTextField12;
    private JTextField jTextHostname;
    private JTextField jTextFieldUser;
    private JTextField jTextField5;
    private JTextField jTextField6;
    private JTextField jTextField7;
    private JTextField jTextField8;
    private JTextField jTextField9;
    // End of variables declaration//GEN-END:variables

    final private Color lightPurple = new Color(232, 233, 251);

    private final JLabel[] m_parmlabels;
    private JTextField [] m_textvals;
    private QueryRunner m_queryrunner;
    private JTable m_jTable;
    JScrollPane m_scrollPane;
    private int m_queryChoice = 0 ; // This is the default query that was selected 

}