package wsb.devices;

import wsb.App;
import wsb.annotations.Test;
import wsb.creatures.Human;
import wsb.annotations.*;

import java.util.*;

public class Phone extends Device {

    enum OperatingSystem {
        IOS, ANDROID, WINDOWS_MOBILE
    }

    @Test
    private final OperatingSystem operatingSystem;

    final Double screenSize;
    public List<App> applications;

    public Phone(String producer, String model, Double screenSize) {
        super(producer, model);
        this.screenSize = screenSize;
        applications = new LinkedList<>();
        if (producer.equals("Apple")) {
            this.operatingSystem = OperatingSystem.IOS;
        } else if (producer.equals("nokia") || producer.equals("microsoft")) {
            this.operatingSystem = OperatingSystem.WINDOWS_MOBILE;
        } else {
            this.operatingSystem = OperatingSystem.ANDROID;
        }
    }

    @Override
    public void turnOn() {
        switch (this.operatingSystem){
            case IOS:
                System.out.println("apple sign");
                break;
            case ANDROID:
                System.out.println("little robot");
                break;
            case WINDOWS_MOBILE:
                System.out.println("four blue rectangles");
                break;
        }
        System.out.println("phone is turned on");
    }

    public void sell() {
        System.out.println("already sold");
    }

    public void installAnApp(App app, Human owner) throws Exception {
        if (app.getPrice() > 0) {
            if (owner.cash < app.getPrice()) {
                throw new Exception("not enough money");
            }
            owner.cash -= app.getPrice();
        }
        applications.add(app);
        System.out.println("Application " + app.getName() + " installed");
    }

    public void installAnApp(String name) {
        installAnApp(name, 0.0);
    }


    public void installAnApp(String[] apps) {
        for (String app : apps) {
            installAnApp(app);
        }
    }

    public void installAnApp(String name, Double version) {
        System.out.println("The app " + name + " was installed in version " + version);
    }

    public boolean isInstalled(App app) {
        return applications.contains(app);
    }

    public boolean isInstalled(String appName) {
        for (App application : applications) {
            if (application.getName().equals(appName)) {
                return true;
            }
        }
        return false;
    }

}
