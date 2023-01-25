package platform.codingnomads.co.springweb.springrestcontrollers.simpledemo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.GET)
    String get() { return "Hello world from api endpoint"; }

    @RequestMapping(path = "/hello", method = RequestMethod.GET/*, produces = MediaType.APPLICATION_JSON_VALUE*/)
    public String hello() {
        return "Hello Spring Developer!";
    }

    @RequestMapping(path = "/hello/{name}", method = RequestMethod.GET/*, produces = MediaType.APPLICATION_JSON_VALUE*/)
    public String greeting(@PathVariable(name = "name") String name) {
        return "Hello " + name + "!";
    }

    @RequestMapping(path = "/sign-in", method = RequestMethod.GET/*, produces = MediaType.APPLICATION_JSON_VALUE*/)
    public String signIn() {
        return "Sign-in now!";
    }

}




