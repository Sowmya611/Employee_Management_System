package com.example.demo.Services;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.DTOs.UserRegistrationDto;
import com.example.demo.Models.Role;
import com.example.demo.Models.User;
import com.example.demo.Repos.UserRepo;


@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepo userRepository) {
        super();
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
        
//        return new UserDetailsImpl(user);
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

	@Override
	public User save(UserRegistrationDto reg) {
//		User user = new User(registrationDto.getFirstName(),
//                registrationDto.getLastName(), registrationDto.getEmail(),
//                passwordEncoder.encode(registrationDto.getPassword()), new Role("ROLE_USER"));
		User user=new User(reg.getFirstName(),reg.getLastName(),reg.getEmail(),passwordEncoder.encode(reg.getPassword()),Arrays.asList(new Role("ROLE_USER")));
		System.out.println("data :===========>"+user.getEmail());
        return userRepository.save(user);
	}
}