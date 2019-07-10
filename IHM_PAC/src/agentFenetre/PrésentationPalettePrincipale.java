package agentFenetre;


import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class PrésentationPalettePrincipale {
    public StackPane pane;
    public BorderPane border;
    public LineChart  lineChart;
    public  NumberAxis xAxis;
    public NumberAxis yAxis;
    public TableView tableauDonnees = new TableView();
    public StackPane paneTableauDeDonnees;

    private ControleurPalettePrincipale ctrlFenPrin;

    
    public void setCtrl(ControleurPalettePrincipale ctrl)
    {
    	this.ctrlFenPrin = ctrl;
    }

    

    public void setInterface ()
    {
        Button augmenter=this.ctrlFenPrin.getPresentationPalette().getAugmenter();
        Button diminuer=this.ctrlFenPrin.getPresentationPalette().getDiminer();
        Button miseAzero=this.ctrlFenPrin.getPresentationPalette().getMiseAzero();
        Button afficherTableau=this.ctrlFenPrin.getPresentationPalette().getAfficherTableau();

        VBox.setMargin(augmenter, new Insets(10,20,0,0));
        VBox.setMargin(diminuer, new Insets(0,20,0,0));
        VBox.setMargin(miseAzero, new Insets(0,20,0,0));


        TextField champSaisie = this.ctrlFenPrin.getPresentationCh().getChampSaisie();
        Label lab = this.ctrlFenPrin.getPresentationCh().getLabel();


        VBox vbox = new VBox(8);vbox.setMaxSize(200,200);
        vbox.getChildren().addAll(lab,champSaisie);
        HBox.setMargin(champSaisie, new Insets(10,0,20, 190));

        HBox hbox = new HBox(20);
        hbox.getChildren().addAll(augmenter, diminuer, miseAzero,afficherTableau);

        border = new BorderPane();border.setPadding(new Insets(10,10,10,10));
        border.setRight(vbox);
        border.setBottom(hbox);
        //Defining X axis
        xAxis = new NumberAxis(0, 20, 1);
        xAxis.setLabel("Modifications");

        //Defining y axis
        yAxis = new NumberAxis(0, 500, 10);
        yAxis.setLabel("Températures");
        LineChart linechart = new LineChart(xAxis, yAxis);
        linechart.setTitle("TP PAC");


        pane = new StackPane();
        pane.getChildren().add(linechart);
        border.setCenter(pane);


        tableauDonnees.setEditable(true);

    }

}
