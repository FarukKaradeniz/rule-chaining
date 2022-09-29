package com.farukkaradeniz.rulechaining.checker;

import com.farukkaradeniz.rulechaining.Person;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AgeRuleChecker implements RuleChecker {
    @Override
    public RuleChecker nextRule() {
        return new HairTypeChecker();
    }

    @Override
    public void check(Person person) {
        if (person.age() < 20) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "20 yaşından küçükler giremez");
        }
        if (person.age() > 60) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "60 yaşından büyükler giremez");
        }
    }
}
