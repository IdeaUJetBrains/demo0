package example.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookentityController {
    @Autowired
    private BookentityRepository bookentityRepository;

    @GetMapping
    public Iterable findAll() {
        return bookentityRepository.findAll();
    }

    @GetMapping("/title/{bookTitle}")
    public List findByTitle(@PathVariable String bookTitle) {
        return bookentityRepository.findByTitle(bookTitle);
    }

    @GetMapping("/{id}")
    public Bookentity findOne(@PathVariable Long id) {
        Bookentity bookentity = bookentityRepository.findOne(id);
        if (bookentity == null)
            throw new BookentityNotFoundException("Error BookentityNotFoundException");
        return bookentity;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Bookentity
    create(@RequestBody Bookentity bookentity) {
        return bookentityRepository.save(bookentity);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Bookentity bookentity = bookentityRepository.findOne(id);
        if (bookentity == null)
            throw new BookentityNotFoundException("Error BookentityNotFoundException");
        bookentityRepository.delete(id);
    }

    @PutMapping("/{id}")
    public Bookentity updateBookentity(@RequestBody Bookentity bookentity, @PathVariable Long id) {
        if (bookentity.getId() != id) {
            try {
                throw new BookentityIdMismatchException("Error BookentityIdMismatchException" );
            } catch (BookentityIdMismatchException e) {
                e.printStackTrace();
            }
        }
        Bookentity old = bookentityRepository.findOne(id);
        if (old == null) {
            throw new BookentityNotFoundException("Error BookentityNotFoundException");
        }
        return bookentityRepository.save(bookentity);
    }
}