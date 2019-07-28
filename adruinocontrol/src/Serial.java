
import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.swing.JLabel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Taha Emara
 */
public class Serial {
    static Enumeration portList;
    static CommPortIdentifier portId;
    static String messageString = "0";
    static SerialPort serialPort;
    static OutputStream outputStream;
    
  public String ser(byte[] x , String com){
  
  
            portList = CommPortIdentifier.getPortIdentifiers();
        while (portList.hasMoreElements()) {
                      

            portId = (CommPortIdentifier) portList.nextElement();
            if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) 
                           

               if (portId.getName().equals(com)) {
                            

                //if (portId.getName().equals("/dev/term/a")) {
                    try {
                        serialPort = (SerialPort)
                            portId.open("SimpleWriteApp", 2000);
                    } catch (PortInUseException e) { return "Port In Use";   }
                    try {
                        outputStream = serialPort.getOutputStream();
                    } catch (IOException e) {}
                    try {
                        serialPort.setSerialPortParams(9600,
                            SerialPort.DATABITS_8,
                            SerialPort.STOPBITS_1,
                            SerialPort.PARITY_NONE);
                    } catch (UnsupportedCommOperationException e) {}
                    try {
                        outputStream.write(x);
                       
                    } catch (IOException e) {return "Failed to Send Data"; }

  }
            
  }
     return "Data Sent";
       
} // void ser
  
  
  
  public void close(){
  serialPort.close();
  
  }

}

