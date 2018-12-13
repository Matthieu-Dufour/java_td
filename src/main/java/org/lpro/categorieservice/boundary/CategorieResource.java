package org.lpro.categorieservice.boundary;


import org.lpro.categorieservice.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieResource extends JpaRepository<Categorie, String> {

}