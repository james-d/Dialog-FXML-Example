
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class DialogController {
    
    private final String message ;
    
    @FXML
    private Label messageLabel ;
    
    public DialogController(String message) {
        this.message = message ;
    }
    
    public void initialize() {
        messageLabel.setText(message);
    }
    
    public void close() {
        messageLabel.getScene().getWindow().hide();
    }
}
