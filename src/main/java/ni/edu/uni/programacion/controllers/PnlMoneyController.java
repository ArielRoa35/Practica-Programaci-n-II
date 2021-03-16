package ni.edu.uni.programacion.controllers;

import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import ni.edu.uni.programacion.views.panels.PnlConversionMoney;

public class PnlMoneyController {
    
    private PnlConversionMoney pnlConversionMoney;
    private DefaultComboBoxModel<String> fromCmbModel;
    private DefaultComboBoxModel<String> toCmbModel;
    private final String MONEY[] = new String[]{"Cordoba", "Dolar"};

    public PnlMoneyController(PnlConversionMoney pnlConvertMoney) {
        this.pnlConversionMoney = pnlConvertMoney;
        initComponent();
    }
    
    private void initComponent(){
        
        fromCmbModel = new DefaultComboBoxModel<>(MONEY);
        toCmbModel = new DefaultComboBoxModel<>(MONEY);
        pnlConversionMoney.getCmbFrom().setModel(fromCmbModel);
        pnlConversionMoney.getCmbTo().setModel(toCmbModel);
        
        pnlConversionMoney.getBtnConv().addActionListener((ActionEvent e) ->{
            
            btnConvActionPerformed(e);
        });
        
        pnlConversionMoney.getBtnNew().addActionListener((ActionEvent e) ->{
            
            btnNewActionPerformed(e);
        });
    }
    
    private void btnConvActionPerformed(ActionEvent e){
            
        try{
            int indexFrom = pnlConversionMoney.getCmbFrom().getSelectedIndex();
            int indexTo = pnlConversionMoney.getCmbTo().getSelectedIndex();
            double value = Double.parseDouble(pnlConversionMoney.getTxtValue().getText());
            double result = convertirDinero(value, indexFrom, indexTo);
            pnlConversionMoney.getTxtResult().setText(String.valueOf(result));
        }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Ingrese los valores correspondientes.", "Error", 2);
        }
    }
    
    private void btnNewActionPerformed(ActionEvent e){
        
        pnlConversionMoney.getTxtValue().setText("");
        pnlConversionMoney.getTxtResult().setText("");
    }
    
    private double convertirDinero(double value, int from, int to){
        
        switch(from){
            case 0:
                switch(to){
                    case 0:
                        return value;
                    case 1:
                        return cordobaToDolar(value);
                }
            case 1:
                switch(to){
                    case 0:
                        return dolarToCordoba(value);
                    case 1:         
                        return value;
                }
        }
        return value;
    }
    
    private double cordobaToDolar(double value){
        
        return((double)value/34.8);
    }
    
    private double dolarToCordoba(double value){
        
        return(value*34.8);
    }
}
