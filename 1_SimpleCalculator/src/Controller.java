import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * @author ZZHow
 * @date 2024/7/12
 */
public class Controller {
    private final Calculate calculate = new Calculate();
    private boolean lastIsNum = true;
    private boolean lastIsEqual = false;
    private boolean lastIsPoint = false;

    @FXML
    private Label expression;

    @FXML
    private Label result;

    @FXML
    public void onClicked(Event event) {
        Button button = (Button) event.getSource();
        String buttonText = button.getText();
        System.out.println(buttonText);

        switch (buttonText) {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                if (lastIsEqual)
                    expression.setText("");
                if (result.getText().length() <= 8) {
                    if (!lastIsNum)
                        result.setText("0");
                    if (lastIsPoint) {
                        String currentNum = result.getText();
                        result.setText(currentNum + buttonText);
                    } else {
                        double currentNum = Double.parseDouble(result.getText());
                        double resultNum = currentNum * 10 + Double.parseDouble(buttonText);
                        result.setText(String.valueOf(resultNum));
                    }
                }
                lastIsNum = true;
                lastIsEqual = false;
                break;
            case ".":
                if(!lastIsPoint) {
                    result.setText(result.getText().substring(0, result.getText().length() - 1));
                    lastIsPoint = true;
                }
                break;
            case "AC":
                result.setText("0.0");
                expression.setText("SimpleCalculator");
                lastIsNum = true;
                lastIsEqual = false;
                lastIsPoint = false;
                break;
            case "+/-":
                result.setText(String.valueOf(Double.parseDouble(result.getText()) * (-1)));
                break;
            case "+":
            case "-":
            case "×":
            case "÷":
            case "%":
                expression.setText(result.getText() + buttonText);
                lastIsNum = false;
                lastIsEqual = false;
                lastIsPoint = false;
                break;
            case "=":
                if (!lastIsEqual) {
                    if ("SimpleCalculator".equals(expression.getText()))
                        expression.setText("");
                    expression.setText(expression.getText() + result.getText() + "=");
                    try {
                        result.setText(String.valueOf(calculate.cal(expression.getText())));
                    } catch (Exception e) {
                        result.setText("Error");
                    }
                    lastIsNum = false;
                    lastIsEqual = true;
                    lastIsPoint = false;
                }
            default:
                break;
        }
    }
}
