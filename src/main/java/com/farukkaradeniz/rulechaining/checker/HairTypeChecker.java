package com.farukkaradeniz.rulechaining.checker;

import com.farukkaradeniz.rulechaining.Person;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class HairTypeChecker implements RuleChecker {
    @Override
    public RuleChecker nextRule() {
        return null;
    }

    @Override
    public void check(Person person) {
        if (person.bold()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Keller giremez");
        }
    }
}
