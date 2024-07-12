import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * @author ZZHow
 * @date 2024/7/11
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("SimpleCalculator 1.0.0");
        stage.setResizable(false);
        Pane load = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SimpleCalculator.fxml")));
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.show();
    }
}
