package platform.codingnomads.co.ioc.examples.dependencylookup;

public class TurkishGreetingProvider implements GreetingProvider{

    @Override
    public String getGreeting() {return "Merhaba!";
    }
}
