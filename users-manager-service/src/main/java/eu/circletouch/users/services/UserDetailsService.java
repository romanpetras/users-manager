package eu.circletouch.users.services;

import eu.circletouch.users.entities.BUtentiEntity;
import eu.circletouch.users.repositories.BUtentiRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final BUtentiRepository usersRepository;

    public UserDetailsService(BUtentiRepository usersRepository) {
        super();
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<BUtentiEntity> optionalUserEntity = usersRepository.findFirstByCodutente(username);

        if (optionalUserEntity.isPresent()) {
            BUtentiEntity usersEntity = optionalUserEntity.get();

            List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                    .commaSeparatedStringToAuthorityList("PROFILE_");

            return User
                    .withUsername(username)
                    .password(usersEntity.getPassword())
                    .authorities(grantedAuthorities)
                    .disabled(false)
                    .build();
        }

        throw new UsernameNotFoundException("Username: " + username + " not found");
    }
}
