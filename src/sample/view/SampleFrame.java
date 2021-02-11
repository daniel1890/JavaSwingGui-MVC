package sample.view;

import sample.controller.SampleAppController;

import javax.swing.*;

/**
 * Sample Frame object die JFrame extend voor gebruik van het maken van een GUI met MVC design pattern.
 * @author: Daniël Roth
 * @Date: 10-02-2021
 */
public class SampleFrame extends JFrame {

    private SamplePanel basePanel;

    /**
     * Creeërt een sample frame object die een reference passed naar de AppController voor gebruik bij het SampleFrame object.
     * @param baseController de referentie naar het AppController object voor MVC design pattern.
     */
    public SampleFrame(SampleAppController baseController) {
        basePanel = new SamplePanel(baseController);
        setupFrame();
    }

    /**
     * Creeërt de content pane, size en maakt de frame zichtbaar.
     */
    private void setupFrame() {
        this.setContentPane(basePanel);
        this.setSize(500, 500);
        this.setVisible(true);
    }
}
