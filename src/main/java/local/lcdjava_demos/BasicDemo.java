package local.lcdjava_demos;

import org.boncey.lcdjava.LCD;
import org.boncey.lcdjava.LCDException;
import org.boncey.lcdjava.Screen;
import org.boncey.lcdjava.StringWidget;
import org.boncey.lcdjava.TitleWidget;

/**
 * Sample class to demonstrate how to display various widgets.
 */
public class BasicDemo
{
    /**
     * Public constructor.
     * @param host the LCDd host.
     * @param port the LCDd port.
     * @throws LCDException if there was a problem connecting to the server.
     */
    private BasicDemo(String host, int port)
            throws LCDException
    {
        LCD lcd = new LCD(host, port);
        System.out.println("Connected to LCDd: " + lcd);

        // Construct an unactivated Screen
        Screen demoScreen = lcd.constructScreen("demo");

        // Set to foreground priority (still won't be seen until activated)
        demoScreen.setPriority(Screen.PRIORITY_FOREGROUND);

        // Add some Widgets to the screen - nothing will be seen until activated
        TitleWidget titleWidget =
                TitleWidget.construct(demoScreen, "Demo Title");
        StringWidget stringWidget =
                StringWidget.construct(demoScreen, 1, 2, "Demo Text");

        // Must call Screen.activate before activating any of its Widgets
        demoScreen.activate();

        // This will fail (check return value) if Screen not activated
        titleWidget.activate();
        stringWidget.activate();

        // Shut down the LCDproc connection cleanly on JVM termination
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                lcd.shutdown();
            }
        });
    }

    public static void main(String args[])
    {
        if (args.length != 2)
        {
            System.err.println(
                    "Usage: java org.boncey.lcdjava.demo.Demo <LCD host> <LCD port>");
            System.exit(-1);
        }

        String host = args[0];
        int port = Integer.parseInt(args[1]);

        try
        {
            new BasicDemo(host, port);
        }
        catch (LCDException e)
        {
            e.printStackTrace();
        }
    }
}
