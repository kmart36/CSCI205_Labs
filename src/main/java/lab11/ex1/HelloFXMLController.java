/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2021
 * Instructor: Prof. Brian King
 *
 * Name: Katy Martinson and Phil Morgan
 * Section: 9:30am
 * Date: 11/8/2021
 * Time: 9:42 AM
 *
 * Project: csci205_labs
 * Package: lab11.ex1
 * Class: HelloFXMLController
 *
 * Description:
 * Controller for the HelloFXML class
 * ****************************************
 */
package lab11.ex1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class HelloFXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField textFieldName;

    @FXML
    private Text textName;

    @FXML
    private Label labelBlue;

    @FXML
    private Label labelGreen;

    @FXML
    private Label labelRed;

    @FXML
    private Label labelSize;

    @FXML
    private Slider sliderGreen;

    @FXML
    private Slider sliderRed;

    @FXML
    private Slider sliderBlue;

    @FXML
    private Slider sliderSize;

    @FXML
    private Label lblStatusBar;

    @FXML
    void initialize() {
        assert textFieldName != null : "fx:id=\"textFieldName\" was not injected: check your FXML file 'hellofxml.fxml'.";
        assert textName != null : "fx:id=\"textName\" was not injected: check your FXML file 'hellofxml.fxml'.";
        assert labelBlue != null : "fx:id=\"labelBlue\" was not injected: check your FXML file 'hellofxml.fxml'.";
        assert labelGreen != null : "fx:id=\"labelGreen\" was not injected: check your FXML file 'hellofxml.fxml'.";
        assert labelRed != null : "fx:id=\"labelRed\" was not injected: check your FXML file 'hellofxml.fxml'.";
        assert labelSize != null : "fx:id=\"labelSize\" was not injected: check your FXML file 'hellofxml.fxml'.";
        assert sliderGreen != null : "fx:id=\"sliderGreen\" was not injected: check your FXML file 'hellofxml.fxml'.";
        assert sliderRed != null : "fx:id=\"sliderRed\" was not injected: check your FXML file 'hellofxml.fxml'.";
        assert sliderSize != null : "fx:id=\"sliderSize\" was not injected: check your FXML file 'hellofxml.fxml'.";
        assert sliderBlue != null : "fx:id=\"sliderBlue\" was not injected: check your FXML file 'hellofxml.fxml'.";
        assert lblStatusBar != null : "fx:id=\"lblStatusBar\" was not injected: check your FXML file 'hellofxml.fxml'.";

        // Update the text object based on the textField changes
        textName.textProperty().bind(textFieldName.textProperty());

        // Initialize the slider values with the correct data
        Color c = (Color)textName.getFill();
        sliderRed.setValue(c.getRed());
        sliderGreen.setValue(c.getGreen());
        sliderBlue.setValue(c.getBlue());
        sliderSize.setValue(textName.getFont().getSize());
        initSliderHandlers();
    }

    /**
     * Initialize the event handlers for the sliders
     */
    private void initSliderHandlers() {
        sliderRed.valueProperty().addListener((observable, oldValue, newValue) -> {
            Color c = (Color) textName.getFill();
            textName.setFill(Color.color(newValue.doubleValue(), c.getGreen(), c.getBlue()));
            updateStatusBar();
        });
        sliderGreen.valueProperty().addListener((observable, oldValue, newValue) -> {
            Color c = (Color) textName.getFill();
            textName.setFill(Color.color(c.getRed(), newValue.doubleValue(), c.getBlue()));
            updateStatusBar();
        });
        sliderBlue.valueProperty().addListener((observable, oldValue, newValue) -> {
            Color c = (Color) textName.getFill();
            textName.setFill(Color.color(c.getRed(), c.getGreen(), newValue.doubleValue()));
            updateStatusBar();
        });
        sliderSize.valueProperty().addListener((observable, oldValue, newValue) -> {
            Font f = textName.getFont();
            textName.setFont(Font.font(f.getFamily(), newValue.doubleValue()));
            updateStatusBar();
        });
    }

    /**
     * Update the status bar with the current color and size of the text
     */
    private void updateStatusBar() {
        Color c = (Color) textName.getFill();
        lblStatusBar.setText(String.format("Color: %s    Size: %.1f",
                c.toString(),
                textName.getFont().getSize()));
    }

}
