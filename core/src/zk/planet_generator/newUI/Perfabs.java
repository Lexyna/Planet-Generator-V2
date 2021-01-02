package zk.planet_generator.newUI;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.kotcrab.vis.ui.widget.VisLabel;
import com.kotcrab.vis.ui.widget.VisSlider;
import com.kotcrab.vis.ui.widget.VisTable;
import com.kotcrab.vis.ui.widget.spinner.IntSpinnerModel;
import com.kotcrab.vis.ui.widget.spinner.Spinner;

public class Perfabs {

    public static Table createSpinner(String name, int initial, int min, int max, ChangeListener listener) {

        IntSpinnerModel intModel = new IntSpinnerModel(initial, min, max);
        Spinner intSpinner = new Spinner("", intModel);

        // intSpinner.addListener(listener);

        VisTable spinnerTable = new VisTable(true);
        spinnerTable.add(new VisLabel(name + ": ")).colspan(2);
        spinnerTable.add(intSpinner);

        return spinnerTable;
    }

    public static Table createSlider(String name, int initial, int min, int max, int step, ChangeListener listener) {

        VisSlider slider = new VisSlider(min, max, step, false);

        final VisLabel valueLabel = new VisLabel(Integer.toString(initial));
        final IntSpinnerModel intSpinner = new IntSpinnerModel(initial, min, max);
        final Spinner spinner = new Spinner("", intSpinner);

        slider.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                int value = (int) ((VisSlider) actor).getValue();
                // intSpinner.setValue(value);
                valueLabel.setText(Integer.toString(value));
            }
        });

        VisTable sliderTable = new VisTable();
        sliderTable.add(new VisLabel(name + ": ")).colspan(2);
        sliderTable.add(slider);
        sliderTable.add(valueLabel);

        return sliderTable;
    }

}
