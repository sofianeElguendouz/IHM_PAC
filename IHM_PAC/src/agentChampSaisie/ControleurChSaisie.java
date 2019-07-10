package agentChampSaisie;

import agentFenetre.ControleurPalettePrincipale;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class ControleurChSaisie {
    private  AbstractionChSaisie model;
    private  Pr�sentationChSaisie vue;
    private ControleurPalettePrincipale ctrFenP;
    
    
    public ControleurChSaisie(ControleurPalettePrincipale ctrl){
        this.model=new AbstractionChSaisie(0);
        this.vue=new Pr�sentationChSaisie("0");
        this.ctrFenP = ctrl;
        this.vue.setCtrl(this);
    }

    
    public int getTemperature()
    {
    	return model.getTemperature();
    }
    

    public void setTemperature(int temperature) {
        this.model.setTemperature(temperature);
    }
    
    public AbstractionChSaisie getModel() {
        return model;
    }

    public void setModel(AbstractionChSaisie model) {
        this.model = model;
    }

    public Pr�sentationChSaisie getVue() {
        return vue;
    }

    public void setVue(Pr�sentationChSaisie vue) {
        this.vue = vue;
    }
    public void control(){
       this.model.setTemperature(Integer.parseInt(vue.getChampSaisie().getText()));
    }
    
    
    public void notifierpere()
    {
    	 if(vue.getChampSaisie().isFocused()){
    		 ctrFenP.onChangeSaisie();
         }
    }
}
