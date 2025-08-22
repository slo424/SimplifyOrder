package com.example.marketplace.commands;

import java.util.Date;

abstract public class DatedCommands {
    Date dateCreated;

    Date dateUpdated;
    

    abstract public void setDateCreated();

    public void setDateUpdated() {
        dateUpdated = new Date();
    }
}
