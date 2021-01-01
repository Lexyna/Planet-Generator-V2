package zk.planet_generator.newUI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Tree;
import com.kotcrab.vis.ui.VisUI;
import com.kotcrab.vis.ui.widget.VisScrollPane;
import com.kotcrab.vis.ui.widget.VisWindow;

import zk.planet_generator.PlanetGeneratorGame;
import zk.planet_generator.newUI.elements.CloudEditor;

public class Editor {

    PlanetGeneratorGame generatorGame;
    Stage stage;

    private Table editorTable;

    public Editor(PlanetGeneratorGame generatorGame) {
        this.generatorGame = generatorGame;
        this.stage = new Stage();

        editorTable = new Table();
        editorTable.setFillParent(true);
        stage.addActor(editorTable);

        initGui();

    }

    private void initGui() {

        VisScrollPane objectEditor = new VisScrollPane(editorTable);
        objectEditor.setScrollingDisabled(true, false);

        VisWindow editorWindow = new VisWindow("Editor", true);
        editorWindow.setSize(400, stage.getHeight());
        editorWindow.setPosition(stage.getWidth() - editorWindow.getWidth(), 0);
        editorWindow.add(objectEditor).fill().expand();
        editorWindow.setMovable(true);

        Skin skin = VisUI.getSkin();
        Tree tree = new Tree(skin);

        TreeNode ringEditor = new TreeNode(new Label("Ring Editor", skin));
        TreeNode cloudEditor = new TreeNode(new Label("Cloud Editor", skin));

        ringEditor.add(new TreeNode(new Label("test im text", skin)));
        for (int i = 0; i < 5; i++)
            cloudEditor.add(new TreeNode(new CloudEditor(null)));

        tree.add(ringEditor);
        tree.add(cloudEditor);

        editorTable.add(tree).fill().expand();
        // editorWindow.add(tree).expand().fill();
        // objectEditor.addActor(tree);
        stage.addActor(editorWindow);

    }

    public void render() {
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    public void dispose() {
        stage.dispose();
    }

    public Stage getStage() {
        return stage;
    }

    public static class TreeNode extends Tree.Node {

        public TreeNode(Actor actor) {
            super(actor);
        }

    }

}
