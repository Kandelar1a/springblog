package com.digitalersjava.springblog.services;

import com.digitalersjava.springblog.models.Account;
import com.digitalersjava.springblog.models.Authority;
import com.digitalersjava.springblog.repositories.AccountRepository;
import com.digitalersjava.springblog.repositories.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AccountService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    public Account save(Account account) {

        if (account.getId() == null) {
            if (account.getAuthorities().isEmpty()) {
                Set<Authority> authorities = new HashSet<>();
                authorityRepository.findById("ROLE_USER").ifPresent(authorities::add);
                account.setAuthorities(authorities);
            }
        }

        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountRepository.save(account);
    }

    public Optional<Account> findOneByEmail(String email) {
        return accountRepository.findOneByEmailIgnoreCase(email);
    }
}
