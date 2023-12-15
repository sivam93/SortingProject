package com.example.demo.factory;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SortingConfig {

   /* @Autowired
    private  DefaultSortService defaultSortService;
  *//*  @Bean
    public DefaultSortService defaultSortService() {
        return new DefaultSortService();
    }*//*

    @Autowired
    private MergeSortService mergeSortService;*/
   /* @Bean
    public MergeSortService mergeSortService() {
        return new MergeSortService();
    }*/

   /* @Bean
    public InsertionSortAdapter insertionSortAdapter() {
        return new InsertionSortAdapter();
    }*/

   /* @Bean
    public Map<String , SortingTechnique> sortingAlgorithms() {
        Map<String, SortingTechnique> map = new HashMap<>();
        map.put(SortingType.bubble.name(), defaultSortService);
        map.put(SortingType.merge.name(), mergeSortService
        );
       // map.put("insertion", insertionSortAdapter());
        return map;
    }*/
}