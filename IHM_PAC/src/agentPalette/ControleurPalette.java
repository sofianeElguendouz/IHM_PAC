package agentPalette;

import agentFenetre.ControleurPalettePrincipale;
import agentFenetre.ControleurPalettePrincipale.TemperatureAndModification;
import agentPalette.AbstractionPalette;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;



public class ControleurPalette {
    private AbstractionPalette model;
    private PrésentationPalette vue;
    private ControleurPalettePrincipale ctrFenP;
    
    
    public  ControleurPalette(ControleurPalettePrincipale ctrl){
        this.model=new AbstractionPalette(0);
        this.vue=new PrésentationPalette();
        this.ctrFenP = ctrl;
        this.vue.setCtrl(this);
    }
    
    
    public void notifyPere(int a)
    {	
    	switch (a)
    	{
    		case 1 :
    			ctrFenP.augmenter();
    		break;
    		case 2 : 
    			ctrFenP.diminuer();
    		break;
    		case 3 :
    			ctrFenP.remiseZero();
    		break;
    		case 4 :
    			ctrFenP.afficherTable();
    		break;
    	}
    	
    }
    
    
    public void control(int operation){
        switch (operation)
        {
            case 1:augmenter();
            break;
            case 2:diminuer();
                break;
            case 3:remiseAzero();
                break;
        }

    }

    public void remiseAzero() {
        this.model.setTemperature(0);
    }
    private void diminuer() {
        this.model.setTemperature(this.model.getTemperature()-10);
    }
    private void augmenter() {
        this.model.setTemperature(this.model.getTemperature()+10);
    }

    public AbstractionPalette getModel() {
        return model;
    }

    public void setModel(AbstractionPalette model) {
        this.model = model;
    }

    public PrésentationPalette getVue() {
        return vue;
    }

    public void setVue(PrésentationPalette vue) {
        this.vue = vue;
    }
    
    public void setTemperature(int a)
    {
    	this.model.setTemperature(a);
    }
    
    public int getTemperature()
    {
    	return this.model.getTemperature();
    }
}
