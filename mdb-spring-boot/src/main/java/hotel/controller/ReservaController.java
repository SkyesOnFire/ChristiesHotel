package hotel.controller;

import hotel.model.ReservaItem;
import hotel.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReservaController {
    @Autowired
    private ReservaRepository reservaRepository;

    @RequestMapping(value = "/reserva", method = RequestMethod.GET)
    public List<ReservaItem> Get() {
        return reservaRepository.findAll();
    }

    @RequestMapping(value = "/reserva/{id}", method = RequestMethod.GET)
    public ResponseEntity<ReservaItem> GetById(@PathVariable(value = "id") String id)
    {
        Optional<ReservaItem> reserva = reservaRepository.findById(id);
        if(reserva.isPresent())
            return new ResponseEntity<ReservaItem>(reserva.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/reserva/count/{tipoQuarto}", method = RequestMethod.GET)
    public ResponseEntity<ReservaItem> GetReservasAtivas(@PathVariable(value = "tipoQuarto") String tipoQuarto)
    {
        Optional<ReservaItem> reservaItem = reservaRepository.findReservaItemByQuartoItem_Tipo(tipoQuarto);
        if(reservaItem.isPresent())
            return new ResponseEntity<ReservaItem>(reservaItem.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/reserva", method =  RequestMethod.POST)
    public ReservaItem Post(@Validated @RequestBody ReservaItem reservaItem)
    {
        return reservaRepository.save(reservaItem);
    }

    @RequestMapping(value = "/reserva/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<ReservaItem> Put(@PathVariable(value = "id") String id, @Validated @RequestBody ReservaItem newReserva)
    {
        Optional<ReservaItem> oldReserva = reservaRepository.findById(id);
        if(oldReserva.isPresent()){
            ReservaItem reservaItem = oldReserva.get();
            reservaRepository.delete(reservaItem);
            reservaRepository.save(newReserva);
            return new ResponseEntity<ReservaItem>(newReserva, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/reserva/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") String id)
    {
        Optional<ReservaItem> reservaItem = reservaRepository.findById(id);
        if(reservaItem.isPresent()){
            reservaRepository.delete(reservaItem.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}