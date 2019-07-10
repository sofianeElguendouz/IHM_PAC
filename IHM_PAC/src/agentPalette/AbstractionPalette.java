package agentPalette;

public class AbstractionPalette {
    private int temperature;
    public AbstractionPalette(int t){
        this.temperature=t;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }
}
