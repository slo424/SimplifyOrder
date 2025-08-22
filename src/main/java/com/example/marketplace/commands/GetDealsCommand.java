package com.example.marketplace.commands;

import com.example.marketplace.models.Category;
import com.example.marketplace.views.DealInfoListView;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class GetDealsCommand extends DatedCommands implements Command {
    @Override
    public DealInfoListView execute() {
        Category[] arrCategories = {new Category(0L,"Sales"), new Category(1L, "Popular")};
        List<Category> categories = Arrays.stream(arrCategories).toList();
        setDateCreated();
        setDateUpdated();

        return new DealInfoListView(categories, new ArrayList<>(), Arrays.asList(Command.getDummyDeals()));
    }
    @Override
    public void setDateCreated() {
        dateCreated = new Date();
    }
}
