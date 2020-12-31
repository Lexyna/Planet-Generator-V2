package zk.planet_generator.ui.objects;

import com.kotcrab.vis.ui.widget.VisTextArea;
import com.kotcrab.vis.ui.widget.file.FileChooser;

import zk.planet_generator.Scene;

public class SaveEditor extends ObjectEditor {

    VisTextArea path;
    FileChooser FileChooser;

    public SaveEditor(Scene scene, String objectName) {
        super(scene, objectName);

    }

    @Override
    public void deleteObjects() {
        // TODO Auto-generated method stub

    }

    @Override
    public void hideInfo() {
        // TODO Auto-generated method stub

    }

}
