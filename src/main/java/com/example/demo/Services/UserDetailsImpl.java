package com.example.demo.Services;


public class UserDetailsImpl  {
}
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.example.demo.Models.User;
//
//
//public class UserDetailsImpl implements UserDetails {
//
//	private String uname;
//	private String pass;
//	private List<GrantedAuthority> grantedauthorities;
//	public UserDetailsImpl(User userlogin) {
//		uname=userlogin.getEmail();
//		pass=userlogin.getPassword();
//		grantedauthorities=Arrays.stream(userlogin.getRoles().split(","))
//				.map(SimpleGrantedAuthority::new)
//				.collect(Collectors.toList());
//	}
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getPassword() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
