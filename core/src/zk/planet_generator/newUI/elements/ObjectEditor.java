package zk.planet_generator.newUI.elements;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.kotcrab.vis.ui.widget.VisLabel;
import com.kotcrab.vis.ui.widget.VisTextButton;

import zk.planet_generator.newUI.Editor.TreeNode;

public abstract class ObjectEditor extends Table {

    protected TreeNode parent;

    public ObjectEditor(String name) {
        this.parent = null;
        padTop(10);
        columnDefaults(0).left();
        add(new VisLabel(name + ":")).row();
        initBaseButtons();
    }

    private void initBaseButtons() {
        VisTextButton deleteBtn = new VisTextButton("Delete");

        deleteBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                delete();
            }
        });

        VisTextButton colorBtn = new VisTextButton("Color");

        Table btnTable = new Table();
        btnTable.add(deleteBtn);
        btnTable.add(colorBtn);
        add(btnTable).row();
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public abstract void delete();

}
