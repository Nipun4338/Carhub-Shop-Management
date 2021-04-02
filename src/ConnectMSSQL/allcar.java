/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectMSSQL;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nipun
 */
public class allcar extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame1
     */
    int flag=0,Id,carQuantity;
    public allcar() {
        initComponents();
        desc.setEditable(false);
        changeColor(allCar, new Color(55,29,74));
        changeColor(jPanel8, new Color(247,78,105));
        
        
        changeColor(allCar, new Color(55,29,74));
        changeColor(jPanel8, new Color(247,78,105));
        String sql="select * from vehicle";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=carhub;selectMethod=cursor", "sa", "123456");

            System.out.println("DATABASE NAME IS:" + connection.getMetaData().getDatabaseProductName());

            Statement statement = connection.createStatement();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            //pstmt.setString(1,jTextField1.getText());
            //pstmt.setString(2,jTextField2.getText());
            //ResultSet resultSet = statement
            //        .executeQuery(sql);
            ResultSet resultSet = pstmt
                    .executeQuery();
            
            
            while (resultSet.next()) {
                
                /*System.out.println("Dealer NAME:" + 
                        resultSet.getString("dealername"));*/
                String carId=String.valueOf(resultSet.getInt("vehicle_Id"));
                String dealerId=String.valueOf(resultSet.getInt("dealer_Id"));
                String carName=resultSet.getString("vehicle_Name");
                String carModel=resultSet.getString("vehicle_Model");
                String carType=resultSet.getString("vehicle_Type");
                String carDetails=resultSet.getString("vehicle_Description");
                String carCost=String.valueOf(resultSet.getInt("vehicle_Cost"));
                carQuantity=resultSet.getInt("vehicle_Quantity");
                String carShowroom=String.valueOf(resultSet.getInt("showroom_Id"));
                String date=String.valueOf(resultSet.getDate("builddate"));
                String imageid=String.valueOf(resultSet.getInt("imageid"));
                String emi=String.valueOf(resultSet.getInt("emi_available"));
                
                String data[]={carId,carName,carModel,carType,carDetails,carCost,date,emi};
                DefaultTableModel tb1model=(DefaultTableModel) jTable1.getModel();
                
                tb1model.addRow(data);
                
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                if (!event.getValueIsAdjusting() && jTable1.getSelectedRow() != -1) 
                {
                    id.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
                    name.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
                    model.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
                    type.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
                    desc.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
                    cost.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString());
                    build.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString());
                    if(carQuantity>0)
                    {
                         available.setText("Yes!");
                    }
                    else
                    {
                         available.setText("No");
                    }
                    emi.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 7).toString());
                    flag=1;
                }
            }
        });                        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    boolean a=true,b=false;
    
    
    public void changeColor(JPanel hover, Color rand){
        hover.setBackground(rand);
    }
    
    public void clickMenu(JPanel h1, JPanel h2, int numberbool)
    {
        if(numberbool==1)
        {
            h1.setBackground(new Color(25,29,74));
            h2.setBackground(new Color(5,10,46));
        }
        else
        {
            h2.setBackground(new Color(25,29,74));
            h1.setBackground(new Color(5,10,46));
        }
    }
    
    public void hideshow(JPanel menuhide, boolean dashboard)
    {
        if(dashboard==true)
        {
            menuhide.setPreferredSize(new Dimension(50, menuhide.getHeight()));
        }
        else{
            menuhide.setPreferredSize(new Dimension(270, menuhide.getHeight()));
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        close = new javax.swing.JPanel();
        closebutton = new javax.swing.JPanel();
        close1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        menu = new javax.swing.JPanel();
        menuicon = new javax.swing.JPanel();
        menubutton = new javax.swing.JPanel();
        menu1 = new javax.swing.JLabel();
        settingsbutton = new javax.swing.JPanel();
        settings1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        menuhide = new javax.swing.JPanel();
        allCar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        accessories = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        services = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        register = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        register1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        dashboardveiw = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        model = new javax.swing.JLabel();
        type = new javax.swing.JLabel();
        cost = new javax.swing.JLabel();
        build = new javax.swing.JLabel();
        emi = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        desc = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        available = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        header.setBackground(new java.awt.Color(5, 10, 46));
        header.setPreferredSize(new java.awt.Dimension(800, 50));
        header.setLayout(new java.awt.BorderLayout());

        close.setBackground(new java.awt.Color(5, 10, 46));
        close.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        closebutton.setBackground(new java.awt.Color(5, 10, 46));
        closebutton.setName(""); // NOI18N
        closebutton.setLayout(new java.awt.BorderLayout());

        close1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete_32px.png"))); // NOI18N
        close1.setName(""); // NOI18N
        close1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                close1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                close1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                close1MouseExited(evt);
            }
        });
        closebutton.add(close1, java.awt.BorderLayout.CENTER);

        close.add(closebutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 0, 50, 50));

        header.add(close, java.awt.BorderLayout.LINE_END);

        jPanel1.setBackground(new java.awt.Color(5, 10, 52));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(5, 10, 52));

        jLabel1.setBackground(new java.awt.Color(5, 10, 52));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CarHub");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 220, 50));

        header.add(jPanel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        menu.setPreferredSize(new java.awt.Dimension(270, 450));
        menu.setLayout(new java.awt.BorderLayout());

        menuicon.setBackground(new java.awt.Color(5, 10, 52));
        menuicon.setPreferredSize(new java.awt.Dimension(50, 450));
        menuicon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menubutton.setBackground(new java.awt.Color(5, 10, 46));
        menubutton.setLayout(new java.awt.BorderLayout());

        menu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/menu_32px.png"))); // NOI18N
        menu1.setMaximumSize(new java.awt.Dimension(50, 50));
        menu1.setMinimumSize(new java.awt.Dimension(50, 50));
        menu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menu1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menu1MouseExited(evt);
            }
        });
        menubutton.add(menu1, java.awt.BorderLayout.PAGE_START);

        menuicon.add(menubutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 50, 40));

        settingsbutton.setBackground(new java.awt.Color(5, 10, 46));
        settingsbutton.setLayout(new java.awt.BorderLayout());

        settings1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        settings1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/settings_32px.png"))); // NOI18N
        settings1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settings1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settings1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settings1MouseExited(evt);
            }
        });
        settingsbutton.add(settings1, java.awt.BorderLayout.PAGE_START);

        menuicon.add(settingsbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 50, 40));

        jPanel5.setBackground(new java.awt.Color(5, 10, 46));
        jPanel5.setPreferredSize(new java.awt.Dimension(50, 5));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel5MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        menuicon.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 50, -1));

        jPanel6.setBackground(new java.awt.Color(5, 10, 46));
        jPanel6.setPreferredSize(new java.awt.Dimension(50, 5));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel6MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        menuicon.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, -1));

        menu.add(menuicon, java.awt.BorderLayout.LINE_START);

        menuhide.setBackground(new java.awt.Color(25, 29, 74));

        allCar.setBackground(new java.awt.Color(5, 10, 46));
        allCar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                allCarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                allCarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                allCarMouseExited(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(5, 10, 46));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("All Cars");

        javax.swing.GroupLayout allCarLayout = new javax.swing.GroupLayout(allCar);
        allCar.setLayout(allCarLayout);
        allCarLayout.setHorizontalGroup(
            allCarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allCarLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        allCarLayout.setVerticalGroup(
            allCarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allCarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(5, 10, 46));
        jPanel8.setPreferredSize(new java.awt.Dimension(50, 5));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel8MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        accessories.setBackground(new java.awt.Color(5, 10, 46));
        accessories.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accessoriesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                accessoriesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                accessoriesMouseExited(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(5, 10, 46));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Accessories");

        javax.swing.GroupLayout accessoriesLayout = new javax.swing.GroupLayout(accessories);
        accessories.setLayout(accessoriesLayout);
        accessoriesLayout.setHorizontalGroup(
            accessoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accessoriesLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        accessoriesLayout.setVerticalGroup(
            accessoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accessoriesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(5, 10, 46));
        jPanel9.setPreferredSize(new java.awt.Dimension(50, 5));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel9MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jPanel10.setBackground(new java.awt.Color(5, 10, 46));
        jPanel10.setPreferredSize(new java.awt.Dimension(50, 5));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel10MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        services.setBackground(new java.awt.Color(5, 10, 46));
        services.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                servicesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                servicesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                servicesMouseExited(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(5, 10, 46));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Services");

        javax.swing.GroupLayout servicesLayout = new javax.swing.GroupLayout(services);
        services.setLayout(servicesLayout);
        servicesLayout.setHorizontalGroup(
            servicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(servicesLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        servicesLayout.setVerticalGroup(
            servicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(servicesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        register.setBackground(new java.awt.Color(5, 10, 46));
        register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registerMouseExited(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(5, 10, 46));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Register");

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel11.setBackground(new java.awt.Color(5, 10, 46));
        jPanel11.setPreferredSize(new java.awt.Dimension(50, 5));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel11MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        register1.setBackground(new java.awt.Color(5, 10, 46));
        register1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                register1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                register1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                register1MouseExited(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(5, 10, 46));
        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Home");

        javax.swing.GroupLayout register1Layout = new javax.swing.GroupLayout(register1);
        register1.setLayout(register1Layout);
        register1Layout.setHorizontalGroup(
            register1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(register1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        register1Layout.setVerticalGroup(
            register1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(register1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout menuhideLayout = new javax.swing.GroupLayout(menuhide);
        menuhide.setLayout(menuhideLayout);
        menuhideLayout.setHorizontalGroup(
            menuhideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
            .addComponent(allCar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
            .addComponent(accessories, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
            .addComponent(services, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
            .addComponent(register, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(register1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuhideLayout.setVerticalGroup(
            menuhideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuhideLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(allCar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(accessories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(services, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(register1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 128, Short.MAX_VALUE))
        );

        menu.add(menuhide, java.awt.BorderLayout.CENTER);

        getContentPane().add(menu, java.awt.BorderLayout.LINE_START);

        dashboardveiw.setBackground(new java.awt.Color(0, 128, 210));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Car Name", "Car Model", "Type", "Description", "Cost", "Build Date", "EMI"
            }
        ));
        jTable1.setFocusable(false);
        jTable1.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable1.setRowHeight(25);
        jTable1.setSelectionBackground(new java.awt.Color(232, 57, 56));
        jTable1.setShowVerticalLines(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setText("Car ID:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setText("Car Name:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setText("Model:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel9.setText("Type:");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Description:");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel11.setText("Cost:");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel12.setText("Build:");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel13.setText("EMI:");

        id.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        name.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        model.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        type.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        cost.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        build.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        emi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        desc.setColumns(20);
        desc.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        desc.setLineWrap(true);
        desc.setRows(5);
        jScrollPane2.setViewportView(desc);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel14.setText("Available:");

        available.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(available, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                        .addComponent(model, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                        .addComponent(type, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                        .addComponent(cost, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                        .addComponent(build, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                        .addComponent(emi, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                        .addComponent(jScrollPane2)))
                .addGap(44, 44, 44))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(model, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cost, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(build, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emi, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                        .addGap(7, 7, 7)
                        .addComponent(available, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jButton1.setText("Buy Now");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout dashboardveiwLayout = new javax.swing.GroupLayout(dashboardveiw);
        dashboardveiw.setLayout(dashboardveiwLayout);
        dashboardveiwLayout.setHorizontalGroup(
            dashboardveiwLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardveiwLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(121, 121, 121))
            .addComponent(jScrollPane1)
        );
        dashboardveiwLayout.setVerticalGroup(
            dashboardveiwLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardveiwLayout.createSequentialGroup()
                .addGroup(dashboardveiwLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dashboardveiwLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(40, 40, 40)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(dashboardveiw, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1049, 522));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void close1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close1MouseEntered
        // TODO add your handling code here:
        changeColor(closebutton, new Color(55,29,74));
    }//GEN-LAST:event_close1MouseEntered

    private void close1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close1MouseExited
        // TODO add your handling code here:
        changeColor(closebutton, new Color(5,10,46));
    }//GEN-LAST:event_close1MouseExited

    private void close1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close1MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_close1MouseClicked

    private void menu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu1MouseClicked
        // TODO add your handling code here:
        clickMenu(menubutton,settingsbutton,1 );
        if(a==true)
        {
            hideshow(menu,a);
            SwingUtilities.updateComponentTreeUI(this);
            a=false;
        }
        else
        {
            hideshow(menu,a);
            SwingUtilities.updateComponentTreeUI(this);
            a=true;
        }
    }//GEN-LAST:event_menu1MouseClicked

    private void menu1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu1MouseEntered
        // TODO add your handling code here:
        
        changeColor(menubutton, new Color(55,29,74));
        changeColor(jPanel6, new Color(247,78,105));
    }//GEN-LAST:event_menu1MouseEntered

    private void menu1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu1MouseExited
        // TODO add your handling code here:
        changeColor(menubutton, new Color(5,10,46));
        changeColor(jPanel6, new Color(5,10,46));
        
    }//GEN-LAST:event_menu1MouseExited

    private void settings1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settings1MouseEntered
        // TODO add your handling code here:
        changeColor(settingsbutton, new Color(55,29,74));
        changeColor(jPanel5, new Color(8,177,150));
    }//GEN-LAST:event_settings1MouseEntered

    private void settings1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settings1MouseClicked
        // TODO add your handling code here:
        //clickMenu(settingsbutton,menubutton,1);
    }//GEN-LAST:event_settings1MouseClicked

    private void settings1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settings1MouseExited
        // TODO add your handling code here:
        changeColor(settingsbutton, new Color(5,10,46));
        changeColor(jPanel5, new Color(5,10,46));
    }//GEN-LAST:event_settings1MouseExited

    private void allCarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allCarMouseClicked
        // TODO add your handling code here:
        
        changeColor(allCar, new Color(55,29,74));
        changeColor(jPanel8, new Color(247,78,105));
        allcar all=new allcar();
        all.setVisible(true);
        dispose();
    }//GEN-LAST:event_allCarMouseClicked

    private void allCarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allCarMouseEntered
        // TODO add your handling code here:
        changeColor(allCar, new Color(55,29,74));
        changeColor(jPanel8, new Color(247,78,105));
        
    }//GEN-LAST:event_allCarMouseEntered

    private void allCarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allCarMouseExited
        // TODO add your handling code here:
        
    }//GEN-LAST:event_allCarMouseExited
    
    private void jPanel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_jPanel6MouseEntered

    private void jPanel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseEntered
        // TODO add your handling code here:


    }//GEN-LAST:event_jPanel5MouseEntered

    private void jPanel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_jPanel6MouseExited

    private void jPanel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel5MouseExited

    private void jPanel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jPanel8MouseEntered

    private void jPanel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel8MouseExited

    private void jPanel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel9MouseEntered

    private void jPanel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel9MouseExited

    private void accessoriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accessoriesMouseClicked
        // TODO add your handling code here:
        changeColor(accessories, new Color(55,29,74));
        changeColor(jPanel9, new Color(247,78,105));
        accessories acc=new accessories();
        acc.setVisible(true);
        dispose();
    }//GEN-LAST:event_accessoriesMouseClicked

    private void accessoriesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accessoriesMouseEntered
        // TODO add your handling code here:
        changeColor(accessories, new Color(55,29,74));
        changeColor(jPanel9, new Color(247,78,105));
    }//GEN-LAST:event_accessoriesMouseEntered

    private void accessoriesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accessoriesMouseExited
        // TODO add your handling code here:
        changeColor(accessories, new Color(5,10,46));
        changeColor(jPanel9, new Color(5,10,46));
    }//GEN-LAST:event_accessoriesMouseExited

    private void servicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_servicesMouseClicked
        // TODO add your handling code here:
        changeColor(services, new Color(55,29,74));
        changeColor(jPanel10, new Color(247,78,105));
        
        services ser=new services();
        ser.setVisible(true);
        dispose();
    }//GEN-LAST:event_servicesMouseClicked

    private void servicesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_servicesMouseEntered
        // TODO add your handling code here:
        changeColor(services, new Color(55,29,74));
        changeColor(jPanel10, new Color(247,78,105));
    }//GEN-LAST:event_servicesMouseEntered

    private void servicesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_servicesMouseExited
        // TODO add your handling code here:
        changeColor(services, new Color(5,10,46));
        changeColor(jPanel10, new Color(5,10,46));
    }//GEN-LAST:event_servicesMouseExited

    private void jPanel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseEntered

    private void jPanel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseExited

    private void registerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseClicked
        // TODO add your handling code here:
        changeColor(register, new Color(55,29,74));
        changeColor(jPanel11, new Color(247,78,105));
        
        register reg=new register();
        reg.setVisible(true);
        dispose();
    }//GEN-LAST:event_registerMouseClicked

    private void registerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseEntered
        // TODO add your handling code here:
        changeColor(register, new Color(55,29,74));
        changeColor(jPanel11, new Color(247,78,105));
    }//GEN-LAST:event_registerMouseEntered

    private void registerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseExited
        // TODO add your handling code here:
        changeColor(register, new Color(5,10,46));
        changeColor(jPanel11, new Color(5,10,46));
    }//GEN-LAST:event_registerMouseExited

    private void jPanel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel11MouseEntered

    private void jPanel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel11MouseExited

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        /*JTable source = (JTable)evt.getSource();
        int row = source.rowAtPoint( evt.getPoint() );
        int column = source.columnAtPoint( evt.getPoint() );
        String s=source.getModel().getValueAt(row, column)+"";

        JOptionPane.showMessageDialog(null, s);*/
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        if(flag==1 && carQuantity>0)
        {
            
            String what="cars";
            new login(what,Id).setVisible(true);
            dispose();
        }
        else
        {
            
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void register1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_register1MouseClicked
        // TODO add your handling code here:
        
        homaepage1 hm = new homaepage1();
        hm.setVisible(true);
        dispose();
    }//GEN-LAST:event_register1MouseClicked

    private void register1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_register1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_register1MouseEntered

    private void register1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_register1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_register1MouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(allcar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(allcar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(allcar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(allcar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new allcar().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel accessories;
    private javax.swing.JPanel allCar;
    private javax.swing.JLabel available;
    private javax.swing.JLabel build;
    private javax.swing.JPanel close;
    private javax.swing.JLabel close1;
    private javax.swing.JPanel closebutton;
    private javax.swing.JLabel cost;
    private javax.swing.JPanel dashboardveiw;
    private javax.swing.JTextArea desc;
    private javax.swing.JLabel emi;
    private javax.swing.JPanel header;
    private javax.swing.JLabel id;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel menu;
    private javax.swing.JLabel menu1;
    private javax.swing.JPanel menubutton;
    private javax.swing.JPanel menuhide;
    private javax.swing.JPanel menuicon;
    private javax.swing.JLabel model;
    private javax.swing.JLabel name;
    private javax.swing.JPanel register;
    private javax.swing.JPanel register1;
    private javax.swing.JPanel services;
    private javax.swing.JLabel settings1;
    private javax.swing.JPanel settingsbutton;
    private javax.swing.JLabel type;
    // End of variables declaration//GEN-END:variables
}
