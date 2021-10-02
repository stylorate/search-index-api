package com.us1.tm3.search.index.service;

import com.us1.tm3.search.index.domain.SearchFilter;
import com.us1.tm3.search.index.exception.NotFoundException;
import com.us1.tm3.search.index.repository.SearchFilterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class SearchFilterService {
    @Autowired
    private SearchFilterRepository searchFilterRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public SearchFilter createOrUpdate(SearchFilter searchFilter) {
        Optional<SearchFilter> existingSearchFilter = searchFilterRepository.findByUserIdAndNameAndBranchIdAndCarrierId("",
                searchFilter.getName(), searchFilter.getBranchId(), searchFilter.getCarrierId());

        searchFilter.setUserId("");

        if (existingSearchFilter.isPresent()) {
            modelMapper.map(searchFilter, existingSearchFilter.get());
            existingSearchFilter.get().getFields().clear();
            existingSearchFilter.get().getFields().addAll(searchFilter.getFields());
            return searchFilterRepository.save(existingSearchFilter.get());
        }

        return searchFilterRepository.save(searchFilter);
    }

    public void delete(UUID id) throws NotFoundException {
        SearchFilter searchFilter = searchFilterRepository.findByIdAndUserId(id, "")
                .orElseThrow(() -> new NotFoundException("Search filter not found"));

        searchFilterRepository.delete(searchFilter);
    }

    public Page<SearchFilter> getForLoggedInUser(Pageable pageable) {
        return searchFilterRepository.findByUserId("sdf", pageable);
    }
}
