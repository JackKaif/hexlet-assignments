package exercise.controller;

import java.net.URI;
import java.util.List;

import exercise.dto.BookCreateDTO;
import exercise.dto.BookDTO;
import exercise.dto.BookUpdateDTO;
import exercise.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BookService bookService;

    // BEGIN
    @GetMapping("")
    public ResponseEntity<List<BookDTO>> index() {
        var books = bookService.getAll();
        return ResponseEntity.ok()
                .body(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> show(@PathVariable Long id) {
        var book = bookService.findById(id);
        return ResponseEntity.ok()
                .body(book);
    }

    @PostMapping("")
    public ResponseEntity<BookDTO> create(@RequestBody BookCreateDTO newBook) {
        var book = bookService.create(newBook);
        return ResponseEntity.created(URI.create("/books"))
                .body(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> update(@PathVariable Long id,
                                          @RequestBody BookUpdateDTO editedBook) {
        var book = bookService.update(id, editedBook);
        return ResponseEntity.ok()
                .body(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.ok().build();
    }
    // END
}
