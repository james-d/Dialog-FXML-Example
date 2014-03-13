import java.io.IOException;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DialogTestController {
    
    private final Pattern emailPattern = Pattern.compile("[a-zA-Z][a-zA-Z0-9_]*@[a-zA-Z][a-zA-Z0-9_]*");
    
    @FXML
    private TextField emailField;
    
    @FXML
    public void submit() throws IOException {
        if (emailPattern.matcher(emailField.getText()).matches()) {
            showWindow("Thanks");
        } else {
            showWindow("Not a valid email address");
        }
    }
   
    private void showWindow(String message) throws IOException {
        final FXMLLoader loader = new FXMLLoader(getClass().getResource("Dialog.fxml"));
        loader.setController(new DialogController(message));
        final Parent root = loader.load();
        final Scene scene = new Scene(root, 250, 150);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initOwner(emailField.getScene().getWindow());
        stage.setScene(scene);
        stage.show();
    }
    
}
