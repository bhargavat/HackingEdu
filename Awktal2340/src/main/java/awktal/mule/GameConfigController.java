package awktal.mule;

import awktal.mule.GameScene;
import awktal.mule.GameState;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Toggle;
import javafx.scene.Scene;

/**
 * GameConfigController controls the game configuration screen.
*/
public class GameConfigController extends SceneController {

    @FXML
    private Slider numPlayers;

    @FXML
    private ToggleGroup mapType;

    /**
     * Constructor for a GameConfigController.
    */
    public GameConfigController() {
    }

    /**
     * Will be called after the constructor when the fxml is loaded.
    */
    @FXML
    private void initialize() {
    }

    /**
     * Handles when the user selects that they are done configuring the game.
     * This is registered as a handler in the FXML.
    */
    public void selectionFinished() {
        gameState.setMaxPlayers((int) numPlayers.getValue());
        String mapTypeStr = ((ToggleButton)mapType.getSelectedToggle()).getId();
        Map map = MapGenerator.generateMap(MapType.valueOf(mapTypeStr));
        gameState.setMap(map);
        SceneManager.loadScene(GameScene.PLAYER_CONFIG);
    }
}