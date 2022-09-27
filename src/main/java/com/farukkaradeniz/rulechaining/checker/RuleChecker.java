package com.farukkaradeniz.rulechaining.checker;

import com.farukkaradeniz.rulechaining.Person;

public interface RuleChecker {
    RuleChecker nextRule();

    void process(Person person);
}
