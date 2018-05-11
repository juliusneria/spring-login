package com.sample.login.controllers;

import com.sample.login.Branch;
import com.sample.login.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by juliusneria on 19/10/2017.
 */
@Controller    // This means that this class is a Controller
@RequestMapping(path="/store") // This means URL's start with /demo (after Application path)
public class BranchController {

    @Autowired
    private BranchRepository branchRepository;

    @PostMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody
    Object addNewStore (@RequestBody Branch store) {
        return branchRepository.save(store);
    }

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<Branch> getAllUsers() {
        return branchRepository.findAll();
    }

    @PutMapping("/update")
    public @ResponseBody
    Object updateStore(@RequestBody Branch store) {

//        Store oldStore = storeRepository.findOne(store.getStore_id());
        /*store.setBooks(store.getBooks());
        store.setManager(store.getManager());*/
        branchRepository.save(store);

        return store;
    }

    /*@DeleteMapping("/delete/{store_id}")
    //@CrossOrigin
    public @ResponseBody
    Object delete(@PathVariable Long store_id) {
        // PUT processing
        Branch store = branchRepository.findByStore_id(store_id);
        branchRepository.deleteByStore_id(store_id);
        return store;
    }*/


}