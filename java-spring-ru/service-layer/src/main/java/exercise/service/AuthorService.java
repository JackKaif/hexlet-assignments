package exercise.service;

import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.AuthorMapper;
import exercise.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class AuthorService {
    // BEGIN
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    public List<AuthorDTO> getAll() {
        return authorRepository.findAll().stream()
                .map(authorMapper::map)
                .toList();
    }

    public AuthorDTO create(AuthorCreateDTO newAuthor) {
        var author = authorMapper.map(newAuthor);
        authorRepository.save(author);
        return authorMapper.map(author);
    }

    public AuthorDTO findById(Long id) {
        var author = authorRepository.findById(id)
                .orElseThrow(() -> {
                    throw new ResourceNotFoundException("Author with id " + id + " not found");
                });
        return authorMapper.map(author);
    }

    public AuthorDTO update(Long id, AuthorUpdateDTO editedAuthor) {
        var author = authorRepository.findById(id)
                .orElseThrow(() -> {
                    throw new ResourceNotFoundException("Author with id " + id + " not found");
                });
        authorMapper.update(editedAuthor, author);
        authorRepository.save(author);
        return authorMapper.map(author);
    }

    public void delete(Long id) {
        authorRepository.deleteById(id);
    }
    // END
}
