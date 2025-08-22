package com.example.marketplace.commands;

import com.example.marketplace.models.SimpleDeal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class GetSimpleDealsCommand implements Command{
    @Override
    public List<SimpleDeal> execute() {

        int[] arr = new int[] {1, 2, 3};
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

        Map<Integer, SimpleDeal> map = Command.getSimpleDeals().stream()
                                        .collect(Collectors.toMap(deal -> Math.toIntExact(deal.getId()), deal -> deal));
        List<SimpleDeal> list2 = map.values().stream().toList();

        return Command.getSimpleDeals().stream().filter(simpleDeal -> simpleDeal.getPriceInLong()!=200L).collect(Collectors.toList());
    }
}
