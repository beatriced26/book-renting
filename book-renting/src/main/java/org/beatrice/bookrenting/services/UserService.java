package org.beatrice.bookrenting.services;

import org.beatrice.bookrenting.dto.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

   private static final List<User> REGISTERED_USERS = new ArrayList<>();

   static {
       REGISTERED_USERS.add(new User("FGT265","Bogdan"));
       REGISTERED_USERS.add(new User("HTR5783", "Tiberiu"));
       REGISTERED_USERS.add(new User("SRU693", "Razvan"));
       REGISTERED_USERS.add(new User("GHT043", "Andrei"));
   }


   public List<User> getRegisteredUsers() {
       return REGISTERED_USERS;
   }

   public User getUserById (String id) {
       return REGISTERED_USERS.stream()
               .filter(user -> id.equals(user.getId()))
               .findFirst()
               .orElseThrow();
   }

    public void deleteUserById(String id) {
        User user1 = REGISTERED_USERS.stream()
                .filter(u -> id.equals(u.getId()))
                .findFirst()
                .orElseThrow();

        REGISTERED_USERS.remove(user1);

    }
}
