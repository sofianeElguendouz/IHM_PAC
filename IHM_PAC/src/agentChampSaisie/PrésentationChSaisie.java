package agentChampSaisie;

import java.awt.*;
import javafx.scene.control.TextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;

public class PrésentationChSaisie {
    private TextField champSaisie;
    private Label label=new Label("Température (Celsius)");
    private ControleurChSaisie ctrl;
    
    public PrésentationChSaisie(String t){
    	
       this.champSaisie=new TextField(t);
       this.champSaisie.textProperty().addListener(new ChangeListener<String>() {
           
           @Override
           public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        	   ctrl.notifierpere();
           }
       });
    }

    public TextField getChampSaisie() {
        return champSaisie;
    }

    public void setChampSaisie(String s) {
        this.champSaisie.setText(s);
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }
    
    public void setCtrl(ControleurChSaisie c)
    {
    	this.ctrl = c;
    }
    
    public ControleurChSaisie getCtrl()
    {
    	return this.ctrl;
    }
}
