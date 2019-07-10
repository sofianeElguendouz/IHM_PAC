package agentFenetre;

import javafx.scene.chart.XYChart;

public class AbstractionPalettePrincipale {
    private int temperature;

    public AbstractionPalettePrincipale(int t){
        this.setTemperature(t);
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }


}