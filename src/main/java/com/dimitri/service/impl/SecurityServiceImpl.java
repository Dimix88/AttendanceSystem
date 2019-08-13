package com.dimitri.service.impl;

import com.dimitri.repository.SecurityIRepository;
import com.dimitri.repository.impl.SecurityIRepositoryImpl;
import com.dimitri.domain.Security;
import com.dimitri.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service("SecurityServiceImpl")
public class SecurityServiceImpl implements SecurityService {
    @Autowired
    @Qualifier("SecurityRepository")
    private SecurityIRepository repository = null;

    @Override
    public Set<Security> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Security create(Security security) {
        return this.repository.create(security);
    }

    @Override
    public Security update(Security security) {
        return this.repository.update(security);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Security read(String s) {
        return this.repository.read(s);
    }
}
