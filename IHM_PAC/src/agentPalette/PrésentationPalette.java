package agentPalette;

import java.awt.*;

import agentFenetre.ControleurPalettePrincipale.TemperatureAndModification;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class PrésentationPalette {
    private Button diminuer;
    private Button augmenter;
    private  Button miseAzero;
    private Button afficherTableau;
    
    private ControleurPalette ctrl;
    
    public PrésentationPalette(){
        setDiminer(new Button("Diminuer"));
        setAugmenter(new Button("Augmenter"));
        setMiseAzero(new Button("Mise a zero"));
        setAfficherTableau(new Button("Tableau de donnÃ©es"));
        
        
        
        
        this.augmenter.setOnAction(new EventHandler<ActionEvent>() {
          	 @Override
               public void handle(ActionEvent e) {
                 
          		ctrl.notifyPere(1);
          	 }
          });
        
        
        
        this.diminuer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e)
            {
            	ctrl.notifyPere(2);
            }

        });
        
        this.miseAzero.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e)
            {
            	ctrl.notifyPere(3);
            }

        });
        
        
        this.afficherTableau.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e)
            {
                ctrl.notifyPere(4);
            }

        });
    }

    public Button getDiminer() {
        return diminuer;
    }

    public void setDiminer(Button diminer) {
        this.diminuer = diminer;
    }

    public Button getAugmenter() {
        return augmenter;
    }

    public void setAugmenter(Button augmenter) {
        this.augmenter = augmenter;
    }

    public Button getMiseAzero() {
        return miseAzero;
    }

    public void setMiseAzero(Button miseAzero) {
        this.miseAzero = miseAzero;
    }

    public Button getAfficherTableau() {
        return afficherTableau;
    }

    public void setAfficherTableau(Button afficherTableau) {
        this.afficherTableau = afficherTableau;
    }
    
    
    public void setCtrl(ControleurPalette ctrl)
    {
    	this.ctrl = ctrl;
    }
}
