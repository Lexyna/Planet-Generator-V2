package zk.planet_generator.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Array;
import com.kotcrab.vis.ui.widget.VisSlider;
import zk.planet_generator.Scene;
import zk.planet_generator.scene_objects.Star;

public class StarEditor extends ObjectEditor {
    private Array<Star> stars;
    private VisSlider slider;

    public StarEditor(final Scene scene, String objectName) {
        super(scene, objectName);

        slider = createSlider("", 0, 200, null, 0, new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                int count = (int) ((VisSlider) actor).getValue();

                if (count > stars.size) {
                    int size = count - stars.size;
                    Array<Star> generatedStars = scene.getObjectGenerator().createStars(size);
                    stars.addAll(generatedStars);
                } else {
                    int size = stars.size - count;
                    for (int i = 0; i < size; i++) {
                        Star removed = stars.pop();
                        scene.removeStar(removed);
                    }
                }
            }
        });
    }

    public void setStars(Array<Star> stars) {
        this.stars = new Array<>(stars);
        slider.setValue(this.stars.size);
    }

    @Override
    public void deleteObjects() {
        int size = stars.size;
        for (int i = 0; i < size; i++) {
            scene.removeStar(stars.pop());
        }
        stars.clear();
    }

    @Override
    public void hideInfo() {

    }
}
