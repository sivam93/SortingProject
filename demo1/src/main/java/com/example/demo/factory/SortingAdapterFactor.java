package com.example.demo.factory;

import com.example.demo.service.DefaultSortService;
import com.example.demo.service.SortingTechnique;
import com.example.demo.view.SortingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

@Component
public class SortingAdapterFactor {
    private final Map<String, SortingTechnique> adapters;

    @Autowired
    public SortingAdapterFactor(Map<String, SortingTechnique> adapters) {
        this.adapters = adapters;
    }

    public SortingTechnique getAdapter(String sortType) {
        return adapters.get(sortType);
    }
}
