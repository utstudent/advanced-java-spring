package platform.codingnomads.co.springweb.gettingdatafromclient.requestbody.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import platform.codingnomads.co.springweb.gettingdatafromclient.requestbody.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}