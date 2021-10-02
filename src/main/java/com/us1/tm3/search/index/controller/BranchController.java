package com.us1.tm3.search.index.controller;

import com.us1.tm3.search.index.controller.dto.BranchDTO;
import com.us1.tm3.search.index.controller.dto.SearchFilterDTO;
import com.us1.tm3.search.index.domain.Branch;
import com.us1.tm3.search.index.exception.NotFoundException;
import com.us1.tm3.search.index.service.BranchService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("branch")
public class BranchController {

    @Autowired
    private BranchService branchService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<ArrayList<BranchDTO>> getList(@Valid @RequestBody BranchDTO request) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.CREATED.value())
        .body(branchService.getList());
    }
    @PostMapping
    public ResponseEntity<BranchDTO> create(@Valid @RequestBody BranchDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED.value())
                .body(modelMapper.map(branchService.create(modelMapper.map(request, Branch.class)), BranchDTO.class));
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam UUID id) throws NotFoundException {
        BranchDTO bb = branchService.delete(id);
        return ResponseEntity.status(HttpStatus.OK.value()).body(bb);
//                ResponseEntity.ok().build();
    }
}
