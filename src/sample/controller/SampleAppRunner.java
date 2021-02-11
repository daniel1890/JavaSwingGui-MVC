package sample.controller;

/**
 * Runner object voor de MVC sample applicatie.
 * @Author: Daniël Roth.
 * @Date: 10-02-2021
 */
public class SampleAppRunner {

    /**
     * Main starter method of entry point.
     * @param args ongebruikt omdat dit een sample app is.
     */
    public static void main(String[] args) {
        SampleAppController baseApp = new SampleAppController();
        baseApp.start();
    }
}
