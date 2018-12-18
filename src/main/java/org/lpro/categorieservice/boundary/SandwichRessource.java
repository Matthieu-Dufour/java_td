/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.lpro.categorieservice.boundary;

import java.util.List;
import org.lpro.categorieservice.entity.Sandwich;
import org.lpro.categorieservice.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author dufour76u
 */
public interface SandwichRessource extends JpaRepository<Sandwich, String> {
    
    List<Sandwich> findByCategorieId(String categorieId);
    
}
