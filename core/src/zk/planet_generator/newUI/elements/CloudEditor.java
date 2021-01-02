package zk.planet_generator.newUI.elements;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.kotcrab.vis.ui.VisUI;
import com.kotcrab.vis.ui.widget.VisTable;
import com.kotcrab.vis.ui.widget.VisTextButton;
import com.kotcrab.vis.ui.widget.VisWindow;
import com.kotcrab.vis.ui.widget.spinner.FloatSpinnerModel;
import com.kotcrab.vis.ui.widget.spinner.IntSpinnerModel;

import zk.planet_generator.newUI.Perfabs;
import zk.planet_generator.newUI.Editor.TreeNode;
import zk.planet_generator.scene_objects.Cloud;

public class CloudEditor extends ObjectEditor implements Comparable {

    private Cloud cloud;
    private IntSpinnerModel count;
    private FloatSpinnerModel velocity;

    public CloudEditor(String name, Cloud cloud) {
        super(name);

        this.cloud = cloud;
        initializeUI();
    }

    private void initializeUI() {
        add(Perfabs.createSpinner("velocity", 0, -30, 30, null)).row();
        add(Perfabs.createSlider("count", 0, 0, 100, 1, null)).row();
    }

    @Override
    public void delete() {
        this.parent.remove();
    }

    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }
}
