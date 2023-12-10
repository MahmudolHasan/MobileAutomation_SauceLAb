package Pages;

import utilities.util;

public class HomePage extends util {

    public void scrollBottomTop() throws InterruptedException {



        scrollToBottom ();
        threadSleep (5);
        System.out.println ("Scrolled Bottom");

        scrollToTop ();
        System.out.println ("Scrolled Top");
        threadSleep (3);

    }

    public void scrollToProduct(String ElementText){
        scrollUntilVisible ();
    }

}
