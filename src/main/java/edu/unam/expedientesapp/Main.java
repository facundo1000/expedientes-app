package edu.unam.expedientesapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main extends Application {

    public static ConfigurableApplicationContext applicationContext;
    public static void main(String[] args) {
//        SpringApplication.run(Main.class, args);
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        applicationContext = SpringApplication.run(Main.class);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu.unam.expedientesapp/dashboard.fxml"));

        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setTitle("Dashboard");
        stage.show();
    }
}
