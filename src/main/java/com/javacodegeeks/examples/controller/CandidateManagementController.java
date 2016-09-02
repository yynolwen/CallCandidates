package com.javacodegeeks.examples.controller;

import com.javacodegeeks.examples.dao.CandidateDao;
import com.javacodegeeks.examples.object.Candidate;
import com.javacodegeeks.examples.object.Specialiste;
import com.javacodegeeks.examples.service.TwilioCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by YongYanOspiea on 02/09/2016.
 */
@RestController
public class CandidateManagementController {

    @Autowired
    private CandidateDao candidateDao;

    @Autowired
    private TwilioCallService twilioCallService;

    @RequestMapping(value = "/candidates", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Candidate>> allCandidates(){

        List<Candidate> candidates = candidateDao.findAllCandidates();

        return new ResponseEntity<List<Candidate>>(candidates, HttpStatus.OK);
    }

    @RequestMapping(value = "/specialistes", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Specialiste>> allSpecialistes(){

        List<Specialiste> specialistes = candidateDao.findAllSpecialiste();

        return new ResponseEntity<List<Specialiste>>(specialistes, HttpStatus.OK);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void insertCandidate(@RequestBody Candidate candidate){

        candidateDao.saveCandidate(candidate);
    }

    @RequestMapping(value = "/delect", method = RequestMethod.POST)
    public void delectCandidate(@RequestBody Candidate candidate){

        candidateDao.deleteCandidate(candidate);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void changeRdv(@RequestBody Candidate candidate){

        candidateDao.updateCandidate(candidate);
    }

    @RequestMapping(value = "/callCandidate", method = RequestMethod.POST)
    public void makeACall(@RequestBody Candidate candidate){

        twilioCallService.call(candidate);
    }
}
