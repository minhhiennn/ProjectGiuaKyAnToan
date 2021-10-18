package com.example.projectantoanthongtin;

import javafx.animation.*;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.util.Duration;

public class StageHideAnimator {
    // key used for storing animators in the properties map of a Stage
    private static final Object PROPERTY_KEY = new Object();

    private double sceneHeight;
    private double decorationHeight;
    private final Stage stage;
    private Timeline animation;

    // fraction of height relative to full height
    private final DoubleProperty height = new SimpleDoubleProperty();

    // getter for the animator
    public static StageHideAnimator getStageHideAnimator(Stage stage) {
        return (StageHideAnimator) stage.getProperties().get(PROPERTY_KEY);
    }

    // get animator of window containing the node
    public static StageHideAnimator getStageHideAnimator(Node node) {
        return getStageHideAnimator((Stage) node.getScene().getWindow());
    }

    private StageHideAnimator(Stage stage) {
        this.stage = stage;
        stage.iconifiedProperty().addListener((o, oldValue, newValue) -> {
            // do reverse hide animation when stage is shown
            if (!newValue) {
                animation.setRate(-1);

                if (animation.getStatus() == Animation.Status.STOPPED) {
                    animation.playFrom("end");
                } else {
                    animation.play();
                }
            }
        });
        height.addListener((o, oldValue, newValue) -> {
            // resize stage and put it at the bottom of the primary screen
            stage.setHeight(sceneHeight * newValue.doubleValue() + decorationHeight);
            WindowUtils.placeAtPrimaryScreenBottom(stage);
        });
    }

    public static StageHideAnimator create(Stage stage) {
        if (stage.getProperties().containsKey(PROPERTY_KEY)) {
            // don't allow 2 animators
            throw new IllegalArgumentException("animator already exists");
        }

        StageHideAnimator animator = new StageHideAnimator(stage);
        stage.getProperties().put(PROPERTY_KEY, animator);
        return animator;
    }

    private void initHeight() {
        sceneHeight = stage.getScene().getHeight();
        decorationHeight = stage.getHeight() - sceneHeight;
    }

    public void iconify() {
        if (stage.isIconified()) {
            return;
        }

        if (animation == null) {
            initHeight(); // save initial height of stage

            animation = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(height, 1d, Interpolator.EASE_BOTH)),
                    new KeyFrame(Duration.seconds(1), new KeyValue(height, 0d, Interpolator.EASE_BOTH)));

            animation.setOnFinished(evt -> {
                if (animation.getRate() == 1) {
                    // iconify at end of hiding animation
                    animation.setRate(-1);
                    stage.setIconified(true);
                }
            });

            animation.play();
        } else {
            animation.setRate(1);
            if (animation.getStatus() == Animation.Status.STOPPED) {
                initHeight(); // save initial height of stage
                animation.playFromStart();
            } else {
                animation.play();
            }
        }
    }
}
