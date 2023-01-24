package platform.codingnomads.co.springweb.resttemplate.DELETE.models;

import lombok.Data;
import platform.codingnomads.co.springweb.resttemplate.POST.models.Error;

@Data
public class UserResponseObject {
    User data;
    Error error;
    String status;
}
