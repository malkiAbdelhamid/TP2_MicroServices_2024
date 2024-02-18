package com.example.msscolarite.API;

import com.example.msscolarite.Proxy.FormationProxy;
import com.example.msscolarite.entities.Etudiant;
import com.example.msscolarite.repositories.EtablissementRepository;
import com.example.msscolarite.repositories.EtudiantRepository;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class APIController {

    @Resource
    EtudiantRepository etudiantRepository;
    @Resource
    FormationProxy formationProxy;

    @GetMapping("/etudiants/{ide}")
    public Etudiant getEtudiantWithFormation(@PathVariable("ide") Long ide)
    {
        Etudiant etudiant=etudiantRepository.findById(ide).get();
        Long idformation=etudiant.getIdFormation();
        etudiant.setFormation(formationProxy.getFormationById(idformation));
        return etudiant;
    }

}
