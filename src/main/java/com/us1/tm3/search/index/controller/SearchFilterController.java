package com.us1.tm3.search.index.controller;

import com.us1.tm3.search.index.controller.dto.SearchFilterDTO;
import com.us1.tm3.search.index.domain.SearchFilter;
import com.us1.tm3.search.index.exception.NotFoundException;
import com.us1.tm3.search.index.service.SearchFilterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("search-filters")
public class SearchFilterController {
    @Autowired
    private SearchFilterService searchFilterService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<Page<SearchFilterDTO>> getByUser(@RequestParam("page") int page, @RequestParam("size") int size) {
        return ResponseEntity.ok(searchFilterService.getForLoggedInUser(PageRequest.of(page, size))
                .map(e -> modelMapper.map(e, SearchFilterDTO.class)));
    }

    @PostMapping
    public ResponseEntity<SearchFilterDTO> createOrUpdate(@Valid @RequestBody SearchFilterDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED.value())
                .body(modelMapper.map(searchFilterService.createOrUpdate(modelMapper.map(request, SearchFilter.class)), SearchFilterDTO.class));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable UUID id) throws NotFoundException {
        searchFilterService.delete(id);
        return ResponseEntity.ok().build();
    }
}
