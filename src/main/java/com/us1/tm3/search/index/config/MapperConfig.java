package com.us1.tm3.search.index.config;

import com.us1.tm3.search.index.controller.dto.SearchFilterDTO;
import com.us1.tm3.search.index.domain.SearchFilter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.createTypeMap(SearchFilterDTO.class, SearchFilter.class);
        modelMapper.addMappings(new PropertyMap<SearchFilter, SearchFilter>() {
            @Override
            protected void configure() {
                skip(destination.getBranchId());
                skip(destination.getBranchName());
                skip(destination.getCarrierId());
                skip(destination.getCarrierName());
                skip(destination.getId());
                skip(destination.getFields());
            }
        });
        modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
}
