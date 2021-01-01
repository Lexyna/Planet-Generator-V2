package zk.planet_generator.newUI.elements;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.kotcrab.vis.ui.VisUI;
import com.kotcrab.vis.ui.util.TableUtils;
import com.kotcrab.vis.ui.widget.VisLabel;
import com.kotcrab.vis.ui.widget.VisScrollPane;
import com.kotcrab.vis.ui.widget.VisTable;
import com.kotcrab.vis.ui.widget.VisTextArea;
import com.kotcrab.vis.ui.widget.VisTextButton;
import com.kotcrab.vis.ui.widget.VisWindow;

import zk.planet_generator.scene_objects.Cloud;

public class CloudEditor extends VisWindow {

    private Cloud cloud;
    private Table editor;

    public CloudEditor(Cloud cloud) {
        super("Cloud", false);
        setMovable(false);

        TableUtils.setSpacingDefaults(this);
        columnDefaults(0).left();

        this.editor = new Table();
        this.cloud = cloud;
        initializeUI();
        pack();
    }

    private void initializeUI() {
        VisTextButton deleteBtn = new VisTextButton("Delete");
        VisTextButton btn = new VisTextButton("BTN");
        deleteBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent e, float x, float y) {
                System.out.println("print");
            }
        });
        // this.add(deleteBtn);
        // this.add(btn);

        VisTable btnTable = new VisTable(true);
        VisTable labeTable = new VisTable(true);
        VisTable areaTable = new VisTable(true);

        btnTable.add(deleteBtn);
        btnTable.add(btn);

        Label l = new Label("test", VisUI.getSkin());
        TextArea are = new TextArea("text", VisUI.getSkin());

        labeTable.add(l);
        areaTable.add(are);

        add(btnTable).row();
        add(labeTable).row();
        add(areaTable).row();
        // this.add(new Label("test", VisUI.getSkin())).fill().expand();
        // this.add(new VisTextArea("text")).fill().expand();
    }
}
