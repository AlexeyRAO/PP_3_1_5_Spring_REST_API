//package ru.kata.spring.boot_security.demo.date;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//import ru.kata.spring.boot_security.demo.model.Role;
//import ru.kata.spring.boot_security.demo.model.User;
//import ru.kata.spring.boot_security.demo.repository.RoleRepository;
//import ru.kata.spring.boot_security.demo.repository.UserRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Component
//public class In implements CommandLineRunner {
//    private final UserRepository userRepository;
//    private final RoleRepository roleRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    public In(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//
//    public void run(String... arg) throws Exception {
//        Role roleAdmin = new Role("ROLE_ADMIN");
//        Role roleUser = new Role("ROLE_USER");
//        Set<Role> adminRoles = new HashSet<>();
//        Set<Role> userRoles = new HashSet<>();
//        roleRepository.save(roleAdmin);
//        roleRepository.save(roleUser);
//        adminRoles.add(roleAdmin);
//        adminRoles.add(roleUser);
//        userRoles.add(roleUser);
//
//
//        // пользователи Admin  и User
//        User userAdmin = new User(1L, "Zaur", "Tregulov", "IT", 500L, "admin",
//                passwordEncoder.encode("admin"), adminRoles);
//        User userUser = new User(2L, "Regina", "Orlova", "HR",400L, "user",
//                passwordEncoder.encode("user"), userRoles);
//        System.out.println(userAdmin);
//        userRepository.save(userAdmin);
//        System.out.println(userUser);
//        userRepository.save(userUser);
//    }
//}
