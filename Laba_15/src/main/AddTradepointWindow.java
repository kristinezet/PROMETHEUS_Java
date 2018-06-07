package main;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class AddTradepointWindow extends Stage {

	private Tradepoint tradepoint;

	private TextField name = new TextField();
	private TextField adress = new TextField();
	private TextArea numbers = new TextArea();
	private TextField spec = new TextField();
	private TextField time = new TextField();

	private Button save = new Button("Save");
	private VBox vbox = new VBox(
			20,
			name,
			adress,
			numbers,
			spec,
			time,
			save
	);

	public AddTradepointWindow(){

		vbox.setStyle("-fx-font-size: 15px");

		name.setPromptText("name");
		name.setTooltip(new Tooltip("name"));

		adress.setPromptText("adress");
		adress.setTooltip(new Tooltip("adress"));

		numbers.setPromptText("numbers");
		numbers.setTooltip(new Tooltip("numbers"));

		spec.setPromptText("specilization");
		spec.setTooltip(new Tooltip("specilization"));

		time.setPromptText("woking time");
		time.setTooltip(new Tooltip("working time"));

		vbox.setAlignment(Pos.CENTER);

		setScene(new Scene(vbox));
		save.setOnAction(s -> {
			if(name.getText().isEmpty() || adress.getText().isEmpty() ||
					numbers.getText().isEmpty() || spec.getText().isEmpty()
					|| time.getText().isEmpty()){
				new Alert(
						Alert.AlertType.WARNING,
						"Some fields are empty",
						ButtonType.OK
				).showAndWait();
				return;
			}
			ArrayList<String> nums = new ArrayList<>();
			String[] phnums = numbers.getText().split("\\s");
			for(String n : phnums)
				nums.add(n);
			tradepoint = new Tradepoint(
					name.getText(),
					adress.getText(),
					nums,
					spec.getText(),
					time.getText()
			);
			close();
		});
	}

	public Tradepoint getTradepoint() {
		return tradepoint;
	}

	public static Tradepoint addTradepoint(){
		AddTradepointWindow w = new AddTradepointWindow();
		w.showAndWait();
		return w.getTradepoint();
	}

}
