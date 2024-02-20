package exercise.service;

import exercise.dto.*;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.BookMapper;
import exercise.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    // BEGIN
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    public List<BookDTO> getAll() {
        return bookRepository.findAll().stream()
                .map(bookMapper::map)
                .toList();
    }

    public BookDTO create(BookCreateDTO newBook) {
        var book = bookMapper.map(newBook);
        bookRepository.save(book);
        return bookMapper.map(book);
    }

    public BookDTO findById(Long id) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> {
                    throw new ResourceNotFoundException("Book with id " + id + " not found");
                });
        return bookMapper.map(book);
    }

    public BookDTO update(Long id, BookUpdateDTO editedBook) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> {
                    throw new ResourceNotFoundException("Book with id " + id + " not found");
                });
        bookMapper.update(editedBook, book);
        bookRepository.save(book);
        return bookMapper.map(book);
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
    // END
}
