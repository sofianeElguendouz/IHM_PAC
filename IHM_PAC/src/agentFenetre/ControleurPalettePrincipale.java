package agentFenetre;

import agentChampSaisie.AbstractionChSaisie;
import agentChampSaisie.ControleurChSaisie;
import agentChampSaisie.PrésentationChSaisie;
import agentPalette.PrésentationPalette;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;

public class ControleurPalettePrincipale {
    private AbstractionPalettePrincipale model;
    private PrésentationPalettePrincipale vue;

    private ControleurChSaisie control_ChampSaisie;
    private agentPalette.ControleurPalette control_PaletteOutils;



    private XYChart.Series series;
    private ObservableList<TemperatureAndModification> data =
            FXCollections.observableArrayList(new TemperatureAndModification("0","0") );

    /* Le constructeur */
    public ControleurPalettePrincipale(AbstractionPalettePrincipale m, PrésentationPalettePrincipale v ){
        this.model=m;
        this.vue=v;
        this.series=new XYChart.Series();
        this.series.setName("température après modification");

    }
    
    public PrésentationChSaisie getPresentationCh()
    {
    	return control_ChampSaisie.getVue();
    }
    
    public PrésentationPalette getPresentationPalette()
    {
    	return control_PaletteOutils.getVue();
    }
    
    public void control(){
        /*____________________________________________________________*/
        control_ChampSaisie=new ControleurChSaisie(this);
        control_PaletteOutils=new agentPalette.ControleurPalette(this);

        control_PaletteOutils.control(3);
        
        
        this.getPresentationCh().getChampSaisie().setDisable(false);
        this.getPresentationCh().getChampSaisie().textProperty().addListener(new ChangeListener<String>() {
        
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(control_ChampSaisie.getVue().getChampSaisie().isFocused()){


                }

            }
        });

    }
    public static class TemperatureAndModification{
        private final SimpleStringProperty temperature;
        private final SimpleStringProperty modification;
        private TemperatureAndModification(String T, String M) {
            this.temperature = new SimpleStringProperty(T);
            this.modification = new SimpleStringProperty(M);
        }


        public String getTemperature() {
            return temperature.get();
        }

        public String getModification() {
            return modification.get();
        }
    }
    
    public void augmenter()
    {
    	control_PaletteOutils.control(1);//L'opÃ©ration 1:Augmenter la tempÃ©rature
        model.setTemperature(control_PaletteOutils.getTemperature());//lors du changement on notifie l'agent pere qui est ici le model
        control_ChampSaisie.setTemperature(model.getTemperature());//et le model notifie les autre agents
        this.getPresentationCh().setChampSaisie(String.valueOf(model.getTemperature()));//On met Ã  jour notre vue Ã  partir de son model associÃ©


        System.out.println(series.getData());
        series.getData().add(new XYChart.Data(series.getData().size(), model.getTemperature()));
        System.out.println(series.getData());
        vue.lineChart=new LineChart(vue.xAxis,vue.yAxis);
        vue.lineChart.getData().add(series);

        vue.lineChart.setTitle("TP PAC");


        vue.pane = new StackPane();
        vue.pane.getChildren().add(vue.lineChart);
        vue.border.setCenter(vue.pane);
        data.add(new TemperatureAndModification(String.valueOf(model.getTemperature()),String.valueOf(series.getData().size())));
    }
    
    public void diminuer()
    {
        control_PaletteOutils.control(2);//L'opÃ©ration 2:Diminuer la tempÃ©rature
        model.setTemperature(control_PaletteOutils.getTemperature());//lors du changement on notifie l'agent pere qui est ici le model
        control_ChampSaisie.setTemperature(model.getTemperature());//et le model notifie les autre agents
        this.getPresentationCh().setChampSaisie(String.valueOf(model.getTemperature()));//On met Ã  jour notre vue Ã  partir de son model associÃ©

        vue.lineChart=new LineChart(vue.xAxis,vue.yAxis);
        System.out.println(series.getData());
        series.getData().add(new XYChart.Data(series.getData().size(), model.getTemperature()));
        vue.lineChart.getData().add(series);
        System.out.println(series.getData());
        vue.lineChart.setTitle("TP PAC");


        vue.pane = new StackPane();
        vue.pane.getChildren().add(vue.lineChart);
        vue.border.setCenter(vue.pane);

        data.add(new TemperatureAndModification(String.valueOf(model.getTemperature()),String.valueOf(series.getData().size())));

    }
    
    
    public void remiseZero()
    {
        control_PaletteOutils.control(3);//remise à 0 de la température
        model.setTemperature(control_PaletteOutils.getTemperature());//lors du changement on notifie l'agent pere qui est ici le model
        control_ChampSaisie.setTemperature(model.getTemperature());//et le model notifie les autre agents
        this.getPresentationCh().setChampSaisie(String.valueOf(model.getTemperature()));//On met Ã  jour notre vue Ã  partir de son model associÃ©
        System.out.println(series.getData());
        vue.lineChart = new LineChart(vue.xAxis,vue.yAxis);
        series.getData().add(new XYChart.Data(series.getData().size(), model.getTemperature()));
        vue.lineChart.getData().add(series);
        System.out.println(series.getData());
        vue.lineChart.setTitle("IHM_PAC");


        vue.pane = new StackPane();
        vue.pane.getChildren().add(vue.lineChart);
        vue.border.setCenter(vue.pane);

        data.add(new TemperatureAndModification(String.valueOf(model.getTemperature()),String.valueOf(series.getData().size())));
    }
    
    public void afficherTable()
    {
        vue.tableauDonnees=new TableView<>();
        TableColumn modif=new TableColumn("Modification");
        modif.setCellValueFactory(new PropertyValueFactory<>("modification"));
        TableColumn temperature=new TableColumn("TempÃ©rature");
        temperature.setCellValueFactory(new PropertyValueFactory<>("temperature"));
        vue.tableauDonnees.setItems(data);System.out.println(data);
        vue.tableauDonnees.getColumns().addAll(modif,temperature);
        vue.tableauDonnees.setMaxWidth(170);

        vue.paneTableauDeDonnees = new StackPane();
        vue.paneTableauDeDonnees.getChildren().add(vue.tableauDonnees);
        vue.border.setLeft(vue.paneTableauDeDonnees);
    }

    
    
    public void onChangeSaisie()
    {
        control_ChampSaisie.control();//On prend la valeur de la Temperature depuis la vue et on la met dans le model
        model.setTemperature(control_ChampSaisie.getTemperature());//On notifie le pÃ¨re de l'agent (le model de la fenÃªtre principale)
        control_PaletteOutils.setTemperature(model.getTemperature());//et le model Ã son tour notifie les autres agents

        vue.lineChart=new LineChart(vue.xAxis,vue.yAxis);
        System.out.println(series.getData());
        series.getData().add(new XYChart.Data(series.getData().size(), model.getTemperature()));
        System.out.println(series.getData());
        vue.lineChart.getData().add(series);
        vue.lineChart.setTitle("IHM_PAC");
        vue.pane = new StackPane();
        vue.pane.getChildren().add(vue.lineChart);
        vue.border.setCenter(vue.pane);
        data.add(new TemperatureAndModification(String.valueOf(model.getTemperature()),String.valueOf(series.getData().size())));

    }
}
