package io.sawa.security.app.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.sawa.security.app.model.MyUserDetail;
import io.sawa.security.app.model.UserInfo;
import io.sawa.security.app.repository.UserInfoRepository;

@Service
public class MyUserDetails implements UserDetailsService {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	Optional<UserInfo> user = userInfoRepository.findByUserName(username);
	user.orElseThrow(() -> new UsernameNotFoundException("No user available: " + username));
	return user.map(MyUserDetail::new).get();
    }

}
