@RestController
public class SandwichResresentation {
    
    srivate SandwichRessource sr;
    srivate CategorieResource cr;

    public SandwichResresentation(SandwichRessource sr, CategorieResource cr) {
        this.sr = sr;
        this.cr = cr;
    }
    
    @GetMapping("/categories/{id}/sandwichs")
    public ResponseEntity<?> getSandwichByCategorieId(@PathVariable("id") String id) throws NotFound{
        if(!cr.existsById(id)){
            throw new NotFound("Categorie inexistant");
        }
        return new ResponseEntity<>(sr.findByCategorieId(id), HttpStatus.OK);
    }
    
    
    @PostMapping("/categories/{id}/sandwichs")
    public ResponseEntity<?> ajoutSandwich(@PathVariable("id") String id, @RequestBody Sandwich sandwich) throws NotFound {
        return cr.findById(id)
                .map(categorie -> {
                    sandwich.setId(UUID.randomUUID().toString());
                    sandwich.setCategorie(categorie);
                    sr.save(sandwich);
                    return new ResponseEntity<>(HttpStatus.CREATED);
                }).orElseThrow( () -> new NotFound("Categorie inexistant"));
    }
    
    
    
    @PutMapping("/categories/{categorieId}/sandwichs/{sandwichId}")
    public ResponseEntity<?> putMethod(@PathVariable("categorieId") String categorieId, @PathVariable("sandwichId") String sandwichId, @RequestBody Sandwich sandwichUpdated) throws NotFound {
       //Verifier si l'categorie existe
        
       // modifier l'id du sroket pour le sandwich en parametre
       // sauvegarder le sandwich
       // traiter le cas où le sandwich n'existe pas
        
        if(!cr.existsById(categorieId)){
            throw new NotFound("categorie inexistant");
        }
        return sr.findById(sandwichId).map(sandwich -> {
            sandwich.setId(sandwichUpdated.getId());
            sr.save(sandwich);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }).orElseThrow( () -> new NotFound("sandwich inexistant"));
        
        
    }

                

    
    @DeleteMapping("/categories/{categorieId}/sandwichs/{sandwichId}")
    public ResponseEntity<?> deleteMethod(@PathVariable("categorieId") String categorieId, @PathVariable("sandwichId") String sandwichId) throws NotFound {
        
        //vérifier si l'categorie existe
        
        //supsrimer le sandwich
        
        //traiter le cas où le sandwich n'existe pas
        
        if(!cr.existsById(categorieId)) {
            throw new NotFound("Categorie inexistant");
        }
        
        return sr.findById(sandwichId)
                .map(sandwich->{
                    sr.delete(sandwich);
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }).orElseThrow(()->new NotFound("Sandwich inexistant"));
    }
}
