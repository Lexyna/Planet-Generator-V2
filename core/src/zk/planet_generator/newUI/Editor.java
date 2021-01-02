package zk.planet_generator.newUI;

import javax.swing.text.DefaultStyledDocument.ElementSpec;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Tree;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.kotcrab.vis.ui.VisUI;
import com.kotcrab.vis.ui.util.TableUtils;
import com.kotcrab.vis.ui.widget.VisLabel;
import com.kotcrab.vis.ui.widget.VisScrollPane;
import com.kotcrab.vis.ui.widget.VisTable;
import com.kotcrab.vis.ui.widget.VisTextButton;
import com.kotcrab.vis.ui.widget.VisTree;
import com.kotcrab.vis.ui.widget.VisWindow;

import zk.planet_generator.PlanetGeneratorGame;
import zk.planet_generator.newUI.elements.CloudEditor;
import zk.planet_generator.newUI.elements.ObjectEditor;

public class Editor {

    PlanetGeneratorGame generatorGame;
    Stage stage;

    private Table editorTable;

    public Editor(PlanetGeneratorGame generatorGame) {
        this.generatorGame = generatorGame;
        this.stage = new Stage();

        editorTable = new Table();
        stage.addActor(editorTable);

        initGui();

    }

    private void initGui() {

        VisScrollPane objectEditor = new VisScrollPane(editorTable);
        objectEditor.setScrollingDisabled(true, false);

        VisWindow editorWindow = new VisWindow("Editor", true);
        editorWindow.setSize(450, stage.getHeight());
        editorWindow.setPosition(stage.getWidth() - editorWindow.getWidth(), 0);
        editorWindow.add(objectEditor).fill().expand();
        editorWindow.setMovable(true);

        Skin skin = VisUI.getSkin();
        VisTree tree = new VisTree();

        TreeNode ringEditor = new TreeNode(new Label("Ring Editor", skin));
        final TreeNode cloudEditor = new TreeNode(new Label("Cloud Editor", skin));

        ringEditor.add(new TreeNode(new Label("test im text", skin)));
        createNewEditorNode(cloudEditor, new CloudEditor("Cloud", null));

        tree.add(ringEditor);
        tree.add(cloudEditor);

        editorTable.add(tree).expand().fill();
        stage.addActor(editorWindow);

    }

    public void render() {
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    private void createNewEditorNode(TreeNode root, ObjectEditor editor) {
        TreeNode node = new TreeNode(editor);
        node.getEditor().setParent(node);
        root.add(node);
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

    public void delete(TreeNode node) {

    }

    public static class TreeNode extends Tree.Node {

        private ObjectEditor editor;

        public TreeNode() {
            super(new VisLabel("null"));
        }

        public TreeNode(Actor actor) {
            super(actor);
            if (actor instanceof ObjectEditor)
                this.editor = (ObjectEditor) actor;
            else
                this.editor = null;
        }

        public ObjectEditor getEditor() {
            if (editor != null)
                return editor;
            else
                return null;
        }

    }

}
