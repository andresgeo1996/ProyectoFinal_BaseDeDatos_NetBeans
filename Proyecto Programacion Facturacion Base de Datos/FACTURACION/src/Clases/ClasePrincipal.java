
package Clases;

import Interfaces.*;
import Clases.*;

public class ClasePrincipal {
    public static void main(String[] args) {
        FrmLogin venlogin = new FrmLogin();
        venlogin.setSize(500, 550);
        venlogin.setResizable(false); 
        venlogin.setDefaultCloseOperation(venlogin.EXIT_ON_CLOSE);
        venlogin.setLocation(500, 100);
        venlogin.setVisible(true);
    }
    
}
