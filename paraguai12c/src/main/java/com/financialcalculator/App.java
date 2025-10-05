package com.financialcalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App - Ponto de entrada da aplicação.
 * Este arquivo foi corrigido para carregar o FXML corretamente.
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        // CORREÇÃO AQUI: Removemos o caminho completo do pacote 
        // porque o arquivo FXML está no mesmo pacote da classe App no classpath.
        scene = new Scene(loadFXML("FXMLDocument_Melhorado"), 730, 530);
        
        stage.setScene(scene);
        stage.setTitle("Financial Calculator"); // Adicionei um título
        stage.show();
    }

    /**
     * Define a nova raiz da Scene (para navegação entre telas).
     * @param fxml o nome do arquivo FXML (sem a extensão).
     * @throws IOException se o arquivo não puder ser carregado.
     */
    static void setRoot(String fxml) throws IOException {
        if (scene != null) {
            scene.setRoot(loadFXML(fxml));
        } else {
            System.err.println("Scene não inicializada.");
        }
    }

    /**
     * Carrega o arquivo FXML.
     * @param fxml o nome do arquivo FXML (sem a extensão).
     * @return O objeto Parent carregado.
     * @throws IOException se o arquivo FXML não for encontrado ou houver erro de carregamento.
     */
    private static Parent loadFXML(String fxml) throws IOException {
        // App.class.getResource() busca o recurso relativo ao caminho do pacote da classe App.
        // Se FXMLDocument_Melhorado.fxml estiver em src/main/resources/com/financialcalculator/, 
        // a busca por "FXMLDocument_Melhorado.fxml" funciona corretamente.
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}
