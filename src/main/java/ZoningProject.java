import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ZoningProject extends Application {

//    private final String START_PAGE = "views/StartPage.fxml";
    private final String START_PAGE = "views/MapPage.fxml";
    private final String APP_NAME = "Проектное зонирование";
    private final String APP_ICON = "";
    private static final int APP_WIDTH = 1024;
    private static final int APP_HEIGHT = 600;

    private ZoningProject mainApp;
    private Stage mainAppStage;

    @Override
    public void start(Stage primaryStage) throws Exception{

        mainApp = this;
        mainAppStage = primaryStage;

        Parent root = FXMLLoader.load(getClass().getResource(START_PAGE));
        primaryStage.setTitle(APP_NAME);
        primaryStage.setScene(new Scene(root, APP_WIDTH, APP_HEIGHT));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
