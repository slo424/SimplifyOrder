package com.example.marketplace.commands;

import lombok.Setter;

public class UpdateDataCommand implements Command{

    @Setter
    private String name;

    @Setter
    private int age;

    @Override
    public String execute() {
        System.out.println(name + " " + age);
        return "";
    }
}
