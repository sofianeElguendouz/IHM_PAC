package agentChampSaisie;

public class AbstractionChSaisie {
    private int temperature;
    public AbstractionChSaisie(int t){
        this.temperature=t;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }
}
