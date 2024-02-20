package exercise.controller;

import exercise.dto.AuthorDTO;
import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController {

    @Autowired
    private AuthorService authorService;

    // BEGIN
    @GetMapping("")
    public List<AuthorDTO> index() {
        return authorService.getAll();
        
    }

    @GetMapping("/{id}")
    public AuthorDTO show(@PathVariable Long id) {
        return authorService.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorDTO create(@RequestBody AuthorCreateDTO newAuthor) {
        return authorService.create(newAuthor);
    }

    @PutMapping("/{id}")
    public AuthorDTO update(@PathVariable Long id,
                                            @RequestBody AuthorUpdateDTO editedAuthor) {
        return authorService.update(id, editedAuthor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        authorService.delete(id);
    }
    // END
}
