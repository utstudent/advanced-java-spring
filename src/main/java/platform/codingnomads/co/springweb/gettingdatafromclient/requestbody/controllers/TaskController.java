package platform.codingnomads.co.springweb.gettingdatafromclient.requestbody.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import platform.codingnomads.co.springweb.gettingdatafromclient.requestbody.models.Task;
import platform.codingnomads.co.springweb.gettingdatafromclient.requestbody.models.User;
import platform.codingnomads.co.springweb.gettingdatafromclient.requestbody.repositories.TaskRepository;
import platform.codingnomads.co.springweb.gettingdatafromclient.requestbody.repositories.UserRepository;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "/api/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> createTask(@RequestBody(required = true) Task task) throws URISyntaxException {
        if (StringUtils.isEmpty(task.getName()) || task.getCompleted() == null) {
            task.setCreatedAt(null);
            return ResponseEntity.badRequest().body(task);
        }
        final Task savedTask = taskRepository
                .save(Task.builder()
                        .completed(task.getCompleted()).name(task.getName()).build());

        return ResponseEntity.created(new URI("/api/tasks/" + savedTask.getId()))
                .body(savedTask);
    }

    @PostMapping(value = "/print")
    public ResponseEntity<?> printMessage(@RequestBody(required = false) String message) {

        if (message == null) {
            message = "You did not pass in a message.";
        }
        System.out.println(message);

        if (message.equalsIgnoreCase("I'm a teapot")) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(message);
        } else {
            return ResponseEntity.ok().body(message);
        }
    }

    @PutMapping(value = "/api/tasks/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> updateTask(@PathVariable(name = "id") long taskId, @RequestBody(required = true) Task task) throws URISyntaxException {
        if (StringUtils.isEmpty(task.getName()) || task.getId() != null) {
            throw new IllegalStateException();
        }

        Optional<Task> updateTask = taskRepository.findById(taskId);

        updateTask.get().setName(task.getName());
        updateTask.get().setCompleted(task.getCompleted());

        taskRepository.save(updateTask.get());

        return ResponseEntity.ok().body(task);
    }

    @PostMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@RequestBody(required = true) User user) throws URISyntaxException {
        if (StringUtils.isEmpty(user.getFirst_name()) || user.getLast_name() == null) {
            return ResponseEntity.badRequest().body(user);
        }
        final User savedUser = userRepository
                .save(User.builder()
                        .first_name(user.getFirst_name()).last_name(user.getLast_name()).age(user.getAge()).build());

        return ResponseEntity.created(new URI("/api/users/" + savedUser.getId()))
                .body(savedUser);
    }
}
