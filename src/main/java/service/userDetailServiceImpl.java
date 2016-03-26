package service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.repository.UserRepository;

@Service("userDetailService")
public class userDetailServiceImpl<SimpleGrantedAuthority> implements userDetailService{
	@Autowired
	private UserRepository userRepository;
	@Transactional
	public UserDetails loadUserByUsername(String login)
	throws UsernameNotFoundException{
		com.entity.User user = null;
		user = userRepository.findOneByUserName(login);
		if (user==null){
			user = userRepository.findOneByEMail(login);
			}
		if (user ==null){
			return null;
			
		}
		Collection<SimpleGrantedAuthority> auhorities = new ArrayList<SimpleGrantedAuthority>();
		Collection<SimpleGrantedAuthority> authorities;
		authorities.add(new SimpleGrantedAuthority (user.getRole().toString()));
		return new User (String.valueOf(user.getId()), user.getPass(), user.getPassword(), authorities);
		
		
	}
	
	
	
	
	
	

}
