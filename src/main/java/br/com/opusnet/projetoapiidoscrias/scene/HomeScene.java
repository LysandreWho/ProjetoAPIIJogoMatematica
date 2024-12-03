package br.com.opusnet.projetoapiidoscrias.scene;

import br.com.opusnet.projetoapiidoscrias.controlls.GameLoop;
import br.com.opusnet.projetoapiidoscrias.controlls.screencontrol.HomeSceneControl;
import br.com.opusnet.projetoapiidoscrias.util.Updatable;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeScene extends Scene implements Updatable {

    private HomeSceneControl homeSceneControl;
    private Button buttonNewGame;
    private GameLoop gameLoop;

    public HomeScene(Parent root, Stage stage){
        super(root);
        homeSceneControl = new HomeSceneControl();
        homeSceneControl.initialize();
        buttonNewGame = homeSceneControl.b_newgame;
        buttonNewGame.setText("Novo Jogo");

        stage.setScene(this);
        stage.setTitle("Valus");
        stage.show();
        gameLoop = new GameLoop(this);  // Passa a si mesma como o Updatable
        new Thread(gameLoop).start();  // Inicia o game loop em uma thread separada
    }

    @Override
    public void update() {

        if (buttonNewGame.isPressed()) {
            System.out.println("Novo Jogo Iniciado!");
        }

    }

    @Override
    public void render() {
        //Aqui é setado as operações visuais
        Platform.runLater(() -> {
            if (buttonNewGame.isPressed()) {
                buttonNewGame.setText("Iniciando Jogo...");
             }

        });
        System.out.println("Renderizando HomeScene");
    }
}
