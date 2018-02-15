
package Interfaces;

import Clases.ClsConectar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmHistorialFacturas extends javax.swing.JFrame {

    public static String FechaFact = "";
   
    public FrmHistorialFacturas() {
        initComponents();
        
        PanelPorFecha.setVisible(false);
        panelBuscarPorCedula.setVisible(false);
         
        cmbTipoDeBusqueda.addItem(" VER HISTORIAL DE FACTURAS ORDENADA POR CLIENTE ");
        cmbTipoDeBusqueda.addItem(" VER HISTORIAL DE FACTURAS ORDENADA POR FECHA ");
        cmbTipoDeBusqueda.addItem(" VER HISTORIAL DE FACTURAS ORDENADA POR VALOR ");
        cmbTipoDeBusqueda.addItem(" VER HISTORIAL DE FACTURAS POR CLIENTE ESPECIFICO");
        cmbTipoDeBusqueda.addItem(" VER HISTORIAL DE FACTURAS POR FECHA ESPECIFICA ");
        
       cmbTipoDeBusqueda.setSelectedIndex(-1);
       
        
    }

    @SuppressWarnings("unchecked")
    
    
    
    public void mostrarHistorialFacturas(){
        
        DefaultTableModel modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; //declarar que las filas y columnas no sean editable
            }
            
        };
        
        modelo.addColumn("N° FACTURA");
        modelo.addColumn("CI");
        modelo.addColumn("NOMBRE");   
        modelo.addColumn("APELLIDO");   
        modelo.addColumn("TOTAL");   
        modelo.addColumn("FECHA");   
        tblHistorialFacturas.setModel(modelo);
        
        String [] datosCliente = new String [6];
        
        try{
            String SQL = "SELECT DET_FACT.NUMFACT, CAB_FACT.CEDCLI,NOMCLI,APELCLI,((SUM(TOTAL)*12)/100)+SUM(TOTAL),FECHAVENTA "
                    + "FROM CLIENTE, CAB_FACT, DET_FACT "
                    + "WHERE CLIENTE.CICLI = CAB_FACT.CEDCLI "
                    + "AND DET_FACT.NUMFACT = CAB_FACT.NUMFACT "
                    + "GROUP BY DET_FACT.NUMFACT "
                    + "ORDER BY APELCLI ASC";
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next()){
               
                datosCliente[0] = rs.getString(1);
                datosCliente[1] = rs.getString(2);
                datosCliente[2] = rs.getString(3);
                datosCliente[3] = rs.getString(4);
                datosCliente[4] = rs.getString(5);
                datosCliente[5] = rs.getString(6);
                modelo.addRow(datosCliente);  
            }
            
            tblHistorialFacturas.setModel(modelo);
            
        }catch(SQLException ex){
            
        }
        
    }
    
    public void mostrarHistorialFacturasValor(){
        
        DefaultTableModel modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; //declarar que las filas y columnas no sean editable
            }
            
        };
        
        modelo.addColumn("N° FACTURA");
        modelo.addColumn("CI");
        modelo.addColumn("NOMBRE");   
        modelo.addColumn("APELLIDO");   
        modelo.addColumn("TOTAL");   
        modelo.addColumn("FECHA");   
        tblHistorialFacturas.setModel(modelo);
        
        String [] datosCliente = new String [6];
        
        try{
            String SQL = "SELECT DET_FACT.NUMFACT, CAB_FACT.CEDCLI,NOMCLI,APELCLI,((SUM(TOTAL)*12)/100)+SUM(TOTAL) AS VALOR,FECHAVENTA "
                    + "FROM CLIENTE, CAB_FACT, DET_FACT "
                    + "WHERE CLIENTE.CICLI = CAB_FACT.CEDCLI "
                    + "AND DET_FACT.NUMFACT = CAB_FACT.NUMFACT "
                    + "GROUP BY DET_FACT.NUMFACT "
                    + "ORDER BY VALOR DESC";
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next()){
               
                datosCliente[0] = rs.getString(1);
                datosCliente[1] = rs.getString(2);
                datosCliente[2] = rs.getString(3);
                datosCliente[3] = rs.getString(4);
                datosCliente[4] = rs.getString(5);
                datosCliente[5] = rs.getString(6);
                modelo.addRow(datosCliente);  
            }
            
            tblHistorialFacturas.setModel(modelo);
            
        }catch(SQLException ex){
            
        }
        
    }
    
    
    
    public void mostrarHistorialFacturasFecha(){
        
        DefaultTableModel modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; //declarar que las filas y columnas no sean editable
            }
            
        };
        
        modelo.addColumn("N° FACTURA");
        modelo.addColumn("CI");
        modelo.addColumn("NOMBRE");   
        modelo.addColumn("APELLIDO");   
        modelo.addColumn("TOTAL");   
        modelo.addColumn("FECHA");   
        tblHistorialFacturas.setModel(modelo);
        
        String [] datosCliente = new String [6];
        
        try{
                String SQL = "SELECT DET_FACT.NUMFACT, CAB_FACT.CEDCLI,NOMCLI,APELCLI,((SUM(TOTAL)*12)/100)+SUM(TOTAL),FECHAVENTA "
                        + "FROM CLIENTE, CAB_FACT, DET_FACT "
                        + "WHERE CLIENTE.CICLI = CAB_FACT.CEDCLI "
                        + "AND DET_FACT.NUMFACT = CAB_FACT.NUMFACT "
                        + "GROUP BY DET_FACT.NUMFACT "
                        + "ORDER BY FECHAVENTA DESC";

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(SQL);
                while (rs.next()) {

                    datosCliente[0] = rs.getString(1);
                    datosCliente[1] = rs.getString(2);
                    datosCliente[2] = rs.getString(3);
                    datosCliente[3] = rs.getString(4);
                    datosCliente[4] = rs.getString(5);
                    datosCliente[5] = rs.getString(6);
                    modelo.addRow(datosCliente);
                }

                tblHistorialFacturas.setModel(modelo);
            
            
        } catch (SQLException ex){
            
        }
        
        
    }
    
    public void mostrarHistorialFacturasCliente(){
        DefaultTableModel modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; //declarar que las filas y columnas no sean editable
            }
            
        };
        
        modelo.addColumn("N° FACTURA");
        modelo.addColumn("CI");
        modelo.addColumn("NOMBRE");   
        modelo.addColumn("APELLIDO");   
        modelo.addColumn("TOTAL");   
        modelo.addColumn("FECHA");   
        tblHistorialFacturas.setModel(modelo);
        
        String [] datosCliente = new String [6];
        
        String cedula = txtBuscarCliente.getText();
        
        try{
            
            if (!txtBuscarCliente.getText().equals("")) {
                String SQL = "SELECT DET_FACT.NUMFACT, CAB_FACT.CEDCLI,NOMCLI,APELCLI,((SUM(TOTAL)*12)/100)+SUM(TOTAL),"
                        + "FECHAVENTA FROM CLIENTE, CAB_FACT, DET_FACT WHERE CLIENTE.CICLI = CAB_FACT.CEDCLI"
                        + "AND DET_FACT.NUMFACT = CAB_FACT.NUMFACT "
                        + "AND CAB_FACT.CEDCLI = " + cedula + " "
                        + "GROUP BY DET_FACT.NUMFACT ORDER BY APELCLI ASC";

                System.out.println(SQL);

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(SQL);
                while (rs.next()) {

                    datosCliente[0] = rs.getString(1);
                    datosCliente[1] = rs.getString(2);
                    datosCliente[2] = rs.getString(3);
                    datosCliente[3] = rs.getString(4);
                    datosCliente[4] = rs.getString(5);
                    datosCliente[5] = rs.getString(6);
                    modelo.addRow(datosCliente);
                }
                tblHistorialFacturas.setModel(modelo);
            }else{
                JOptionPane.showMessageDialog(null, "INGRESE UN NUMERO CEDULA PARA BUSCAR");
            }

        } catch (SQLException ex) {

        }
        
        
    }
    
    public void mostrarHistorialFacturasFechaEspecifica(){
        
        DefaultTableModel modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; //declarar que las filas y columnas no sean editable
            }
            
        };
        
        modelo.addColumn("N° FACTURA");
        modelo.addColumn("CI");
        modelo.addColumn("NOMBRE");   
        modelo.addColumn("APELLIDO");   
        modelo.addColumn("TOTAL");   
        modelo.addColumn("FECHA");   
        tblHistorialFacturas.setModel(modelo);
        
        String [] datosCliente = new String [6];
        
        try{
            
            if(!txtFechaBusqueda.getText().equals("")){
                String fecha = txtFechaBusqueda.getText();
                boolean fechaValidar = validarFecha(fecha);
            
                if(fechaValidar == true){
                    
                    System.out.println("FECHA FACT "+FechaFact);
            
                String SQL = "SELECT DET_FACT.NUMFACT, CAB_FACT.CEDCLI,NOMCLI,APELCLI,((SUM(TOTAL)*12)/100)+SUM(TOTAL),FECHAVENTA "
                        + "FROM CLIENTE, CAB_FACT, DET_FACT "
                        + "WHERE CLIENTE.CICLI = CAB_FACT.CEDCLI "
                        + "AND DET_FACT.NUMFACT = CAB_FACT.NUMFACT "
                        + "AND CAB_FACT.FECHAVENTA = {d '" + FechaFact + "'}  "
                        + "GROUP BY DET_FACT.NUMFACT  "
                        + "ORDER BY FECHAVENTA DESC";
                
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(SQL);
                while (rs.next()) {

                    datosCliente[0] = rs.getString(1);
                    datosCliente[1] = rs.getString(2);
                    datosCliente[2] = rs.getString(3);
                    datosCliente[3] = rs.getString(4);
                    datosCliente[4] = rs.getString(5);
                    datosCliente[5] = rs.getString(6);
                    modelo.addRow(datosCliente);
                }

                tblHistorialFacturas.setModel(modelo);
                }else{
                    JOptionPane.showMessageDialog(null, "    FORMATO DE FECHA INCORRECTO dd/mm/yyyy   ");
                    txtFechaBusqueda.setText("");
                }
            }else{
                JOptionPane.showMessageDialog(null, "    INGRESE UNA FECHA PARA BUSCAR   ");
            }
        } catch (SQLException ex){
            
        }
        
        
    }
    
    public void cargarComboBusqueda(){
        
        int seleccionBusqueda = cmbTipoDeBusqueda.getSelectedIndex();
    
        System.out.println("numero " + seleccionBusqueda);
            
        if(seleccionBusqueda == 0){
            panelBuscarPorCedula.setVisible(false);
            PanelPorFecha.setVisible(false);
            
             mostrarHistorialFacturas();
        }
        
        if(seleccionBusqueda == 1){
            panelBuscarPorCedula.setVisible(false);
            PanelPorFecha.setVisible(false);
            mostrarHistorialFacturasFecha(); 
        }
        
        if(seleccionBusqueda == 2){
            panelBuscarPorCedula.setVisible(false);
            PanelPorFecha.setVisible(false);
            mostrarHistorialFacturasValor(); 
        }
        
        
        if(seleccionBusqueda == 3){
            panelBuscarPorCedula.setVisible(true);
            PanelPorFecha.setVisible(false);
            
            mostrarHistorialFacturasCliente();
        }
        
        if(seleccionBusqueda == 4){
            panelBuscarPorCedula.setVisible(false);
            PanelPorFecha.setVisible(true);
            
            mostrarHistorialFacturasFechaEspecifica();
        }
    }
    
    public static boolean validarFecha(String fecha) {
             
            try {
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                formatoFecha.setLenient(false);
                formatoFecha.parse(fecha);
                
                String[] partesFecha = fecha.split("/");
                int año = Integer.parseInt(partesFecha[2]);
               
                if(año >=1990 && año <= 2020  ){
                    FechaFact = partesFecha[2]+"-"+partesFecha[1]+"-"+partesFecha[0];
                    
                   return true; 
                }else{
                    return false;
                }
                
            } catch (ParseException e) {
                return false;
            }
        }
     
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHistorialFacturas = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();
        btnBuscarBusquedaFact = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        panelBuscarPorCedula = new javax.swing.JPanel();
        txtBuscarCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        PanelPorFecha = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtFechaBusqueda = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cmbTipoDeBusqueda = new javax.swing.JComboBox<>();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("HISTORIAL DE FACTURAS");

        jPanel1.setBackground(new java.awt.Color(255, 153, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblHistorialFacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblHistorialFacturas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnRegresar.setFont(new java.awt.Font("AR JULIAN", 2, 18)); // NOI18N
        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnBuscarBusquedaFact.setFont(new java.awt.Font("AR JULIAN", 2, 18)); // NOI18N
        btnBuscarBusquedaFact.setText("BUSCAR");
        btnBuscarBusquedaFact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarBusquedaFactActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 153, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        panelBuscarPorCedula.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("CLIENTE: ");

        javax.swing.GroupLayout panelBuscarPorCedulaLayout = new javax.swing.GroupLayout(panelBuscarPorCedula);
        panelBuscarPorCedula.setLayout(panelBuscarPorCedulaLayout);
        panelBuscarPorCedulaLayout.setHorizontalGroup(
            panelBuscarPorCedulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBuscarPorCedulaLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        panelBuscarPorCedulaLayout.setVerticalGroup(
            panelBuscarPorCedulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBuscarPorCedulaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBuscarPorCedulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBuscarPorCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBuscarPorCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 153, 102));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        PanelPorFecha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("FECHA:     ");

        javax.swing.GroupLayout PanelPorFechaLayout = new javax.swing.GroupLayout(PanelPorFecha);
        PanelPorFecha.setLayout(PanelPorFechaLayout);
        PanelPorFechaLayout.setHorizontalGroup(
            PanelPorFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPorFechaLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txtFechaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        PanelPorFechaLayout.setVerticalGroup(
            PanelPorFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPorFechaLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(PanelPorFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFechaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelPorFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelPorFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 153, 51));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("SELECCIONE TIPO DE BUSQUEDA:  ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addGap(43, 43, 43)
                .addComponent(cmbTipoDeBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbTipoDeBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(72, 72, 72)
                            .addComponent(btnRegresar))
                        .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnBuscarBusquedaFact)
                .addGap(295, 295, 295))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(btnRegresar)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)))
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscarBusquedaFact)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(623, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
    
        FrmMenu venMenu = new FrmMenu();
        venMenu.setSize(425, 450);
        venMenu.setResizable(false);
        venMenu.setDefaultCloseOperation(venMenu.EXIT_ON_CLOSE);
        venMenu.setLocation(500, 100);
        venMenu.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnBuscarBusquedaFactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarBusquedaFactActionPerformed
        
        cargarComboBusqueda();
        
    }//GEN-LAST:event_btnBuscarBusquedaFactActionPerformed

    
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
            java.util.logging.Logger.getLogger(FrmHistorialFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmHistorialFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmHistorialFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmHistorialFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmHistorialFacturas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPorFecha;
    private javax.swing.JButton btnBuscarBusquedaFact;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cmbTipoDeBusqueda;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelBuscarPorCedula;
    private javax.swing.JTable tblHistorialFacturas;
    private javax.swing.JTextField txtBuscarCliente;
    private javax.swing.JTextField txtFechaBusqueda;
    // End of variables declaration//GEN-END:variables

ClsConectar cc = new ClsConectar();
Connection cn = cc.conexion();
}
