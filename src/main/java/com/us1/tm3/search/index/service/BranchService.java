package com.us1.tm3.search.index.service;

import com.us1.tm3.search.index.controller.dto.BranchDTO;
import com.us1.tm3.search.index.domain.Branch;
import com.us1.tm3.search.index.domain.SearchFilter;
import com.us1.tm3.search.index.exception.NotFoundException;
import com.us1.tm3.search.index.repository.BranchRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BranchService {
    @Autowired
    private BranchRepository branchRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public Branch create(Branch branch) {
        return branchRepository.save(branch);
    }

    public BranchDTO delete(UUID id) throws NotFoundException {
        Branch branch = branchRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Search filter not found"));
        branchRepository.delete(branch);
        BranchDTO bb = new BranchDTO().setData(branch);
        return bb;
    }

    public void update(Branch branch) throws NotFoundException {
        Branch tempBranch = branchRepository.findById(branch.getId())
                .orElseThrow(() -> new NotFoundException("Search filter not found"));
        tempBranch.setData(branch);
        branchRepository.save(tempBranch);
    }

    @Transactional
    public ArrayList<BranchDTO> getList() throws NotFoundException {
        ArrayList<Branch> temp = (ArrayList<Branch>) branchRepository.findAll();
        ArrayList<BranchDTO> list = new ArrayList<>();
        if (!temp.isEmpty()) {
            for (Branch bb : temp) {
                BranchDTO branch = new BranchDTO();
                list.add(branch.setData(bb));
            }
        }
        return list;
    }
//    public Page<SearchFilter> getForLoggedInUser(Pageable pageable) {
//        return branchRepository.findByUserId("sdf", pageable);
//    }
}
