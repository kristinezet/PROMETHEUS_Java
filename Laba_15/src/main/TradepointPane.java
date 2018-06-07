package main;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TradepointPane extends VBox {

	public TradepointPane(Tradepoint t, Tradepoints tr) {
		setPadding(new Insets(10, 10, 10, 10));
		Button del = new Button("delete");
		del.setOnAction(d -> {
			tr.remove(t);
			((HBox) getParent()).getChildren().remove(this);
		});

		setStyle("-fx-background-color: green");
		setSpacing(10);
		getChildren().addAll(
				new Label("Name : " + t.getName()),
				new Label("Adress : " + t.getAdress()),
				new Label("Phone numbers: ")
		);
		for (String n : t.getPhones())
			getChildren().add(new Label(n));
		getChildren().addAll(
				new Label("Specialization : " + t.getSpecialization()),
				new Label("Time : " + t.getTime()),
				del
		);
	}
}


