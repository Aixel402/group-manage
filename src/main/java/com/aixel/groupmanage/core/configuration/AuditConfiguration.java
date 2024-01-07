package com.aixel.groupmanage.core.configuration;

import com.aixel.groupmanage.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditConfiguration implements AuditorAware<String> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<String> getCurrentAuditor() {
        User user = em.find(User.class, 1L);
        String principal = user == null? "Unkown" : user.getName();
        return Optional.of(principal);
    }
}
