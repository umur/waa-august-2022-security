package edu.miu.springsecurity1.controller;

import edu.miu.springsecurity1.utils.ProfanityFilter;

public class Testing {

    public static void main(String[] args) {
        ProfanityFilter.loadConfigs();
        String value = ProfanityFilter.filterText("fuck You, pussy, cunt");
        System.out.println("Value "+ value);
    }
}
