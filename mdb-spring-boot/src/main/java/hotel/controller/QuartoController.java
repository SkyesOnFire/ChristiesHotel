package hotel.controller;

import hotel.model.QuartoItem;
import hotel.repository.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class QuartoController {
    @Autowired
    private QuartoRepository quartoRepository;

    @RequestMapping(value = "/quarto", method = RequestMethod.GET)
    public List<QuartoItem> Get() {
        return quartoRepository.findAll();
    }

    @RequestMapping(value = "/quarto/{id}", method = RequestMethod.GET)
    public ResponseEntity<QuartoItem> GetById(@PathVariable(value = "id") String id)
    {
        Optional<QuartoItem> quarto = quartoRepository.findById(id);
        if(quarto.isPresent())
            return new ResponseEntity<QuartoItem>(quarto.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/quarto", method =  RequestMethod.POST)
    public QuartoItem Post(@Validated @RequestBody QuartoItem quartoItem)
    {
        return quartoRepository.save(quartoItem);
    }

    @RequestMapping(value = "/quarto/trocarNumero/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<QuartoItem> Put(@PathVariable(value = "id") String id, @Validated @RequestBody QuartoItem newQuarto)
    {
        Optional<QuartoItem> oldQuarto = quartoRepository.findById(id);
        if(oldQuarto.isPresent()){
            QuartoItem quartoItem = oldQuarto.get();
            quartoItem.setNumero(newQuarto.getNumero());
            quartoRepository.save(quartoItem);
            return new ResponseEntity<QuartoItem>(quartoItem, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/quarto/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") String id)
    {
        Optional<QuartoItem> quartoItem = quartoRepository.findById(id);
        if(quartoItem.isPresent()){
            quartoRepository.delete(quartoItem.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}