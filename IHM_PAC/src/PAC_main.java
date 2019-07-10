import agentFenetre.AbstractionPalettePrincipale;
import agentFenetre.ControleurPalettePrincipale;
import agentFenetre.PrésentationPalettePrincipale;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class PAC_main extends Application {

    @Override
    public void start(Stage primaryStage) {

        PrésentationPalettePrincipale view =  new PrésentationPalettePrincipale() ;
        AbstractionPalettePrincipale abstraction_PAC = new AbstractionPalettePrincipale(0);
        ControleurPalettePrincipale control_PAC = new ControleurPalettePrincipale(abstraction_PAC, view);
        view.setCtrl(control_PAC);
        
        control_PAC.control();
        view.setInterface();
        Scene scene = new Scene(view.border, 1000,500);

        primaryStage.setTitle("TP_PAC");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
