package pl.java.travelapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import pl.java.travelapp.model.TravelAttraction;
import pl.java.travelapp.services.TravelAttractionService;
import pl.java.travelapp.util.ErrorMessage;
import pl.java.travelapp.util.FieldErrorMessage;

import javax.validation.Valid;
import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/attractions")
public class TravelAttractionApi {

    private TravelAttractionService service;

    @Autowired
    public TravelAttractionApi(TravelAttractionService service) {
         this.service = service;
    }

    @GetMapping
    public List<TravelAttraction> getAll() {
        return service.readAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<TravelAttraction> getById(@PathVariable Long id) {
        if (service.readById(id).isPresent()) {
            return new ResponseEntity(service.readById(id), HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public TravelAttraction addTravelAttraction(@Valid @RequestBody TravelAttraction travelAttraction) throws ValidationException {
        return service.createTravelAttraction(travelAttraction);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    List<FieldErrorMessage> exceptionHandler(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        List<FieldErrorMessage> fieldErrorMessages = fieldErrors.stream().map(filedError ->
                new FieldErrorMessage(filedError.getField(), filedError.getDefaultMessage())).collect(Collectors.toList());
        return fieldErrorMessages;
    }

    @PutMapping
    public TravelAttraction updateTravelAttraction(@RequestBody TravelAttraction travelAttraction) throws ValidationException {
        if (travelAttraction.getId() == null) {
            throw new ValidationException("Id hasn't been provided");
        }

        if (service.readById(travelAttraction.getId()).isPresent()) {
            return service.createTravelAttraction(travelAttraction);
        }else {
            throw new ValidationException("There is no travel attraction with id:" + travelAttraction.getId());
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public ErrorMessage exceptionHandler(ValidationException ex) {
        return new ErrorMessage("400", ex.getMessage());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteTravelAttraction(@PathVariable Long id) {
        if (service.readById(id).isPresent()) {
            service.deleteTravelAttraction(id);
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
