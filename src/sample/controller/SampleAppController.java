package sample.controller;

import sample.model.MVCFactory;
import sample.view.SampleFrame;

public class SampleAppController {

    private SampleFrame appFrame;
    private MVCFactory appFactory;

    public MVCFactory getAppFactory() {
	return appFactory;
	}
    
    public SampleFrame getAppFrame() {
    	return appFrame;
    }
    
    public SampleAppController() {
    	appFactory = new MVCFactory();
    }

	public void start() {
        appFrame = new SampleFrame(this);
    }
}
