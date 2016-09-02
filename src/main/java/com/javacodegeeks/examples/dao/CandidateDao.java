package com.javacodegeeks.examples.dao;

import com.javacodegeeks.examples.object.Candidate;
import com.javacodegeeks.examples.object.Specialiste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by YongYanOspiea on 31/08/2016.
 */


@Repository
public class CandidateDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<Candidate> findAllCandidates(){
        String query="SELECT * FROM Candidate";

        List<Candidate> candidates = new ArrayList<Candidate>();

        List<Map<String,Object>> rows = jdbcTemplate.queryForList(query);
        for(Map row:rows){
            Candidate candidate = new Candidate();
            candidate.setId(Integer.parseInt(String.valueOf(row.get("id"))));
            candidate.setNom((String)row.get("nom"));
            candidate.setPrenom((String)row.get("prenom"));
            candidate.setPhone((String)row.get("phone"));
            candidate.setSpecialiste((String)row.get("specialiste"));
            candidate.setRdv((String)row.get("pris_rdv"));

            candidates.add(candidate);
        }
        return candidates;
    }

    public List<Specialiste> findAllSpecialiste(){
        String query="SELECT * FROM Specialiste";

        List<Specialiste> specialistes = new ArrayList<Specialiste>();

        List<Map<String,Object>> rows = jdbcTemplate.queryForList(query);
        for(Map row:rows){
            Specialiste specialiste = new Specialiste();
            specialiste.setId(Integer.parseInt(String.valueOf(row.get("id"))));
            specialiste.setSpecialiste((String)row.get("specialiste"));

            specialistes.add(specialiste);
        }
        return specialistes;
    }


    public int saveCandidate( Candidate e){
        String query="insert into Candidate(nom,prenom,phone,specialiste) values('"+e.getNom()+"','"+e.getPrenom()+"','"+e.getPhone()+"','"+e.getSpecialiste()+"')";
        return jdbcTemplate.update(query);
    }
    public int updateCandidate(Candidate e){
        String query="update Candidate set nom='"+e.getNom()+"',prenom='"+e.getPrenom()+"',phone='"+e.getPhone()+"',specialiste='"+e.getSpecialiste()+"',pris_rdv='"+e.getRdv()+"' where id='"+e.getId()+"' ";
        return jdbcTemplate.update(query);
    }
    public int deleteCandidate(Candidate e){
        String query="delete from Candidate where id='"+e.getId()+"' ";
        return jdbcTemplate.update(query);
    }

}
