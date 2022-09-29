package com.farukkaradeniz.rulechaining.checker;

import com.farukkaradeniz.rulechaining.Person;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

public class SurnameRuleChecker implements RuleChecker {
    @Override
    public RuleChecker nextRule() {
        return new AgeRuleChecker();
    }

    @Override
    public void check(Person person) {
        if (!StringUtils.hasText(person.surname())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Soyisim boş olamaz");
        }
    }
}
