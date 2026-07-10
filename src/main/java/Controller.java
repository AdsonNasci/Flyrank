import com.Flyrank.project.Unsettled;
import com.Flyrank.project.UnsettledRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/controller")
public class Controller{
    @Autowired
    private UnsettledRepository repository;
    @GetMapping("/listar")
    public void listar(){
        System.out.println("Listando");
    }

    List<Unsettled> unsettledList = repository.findAll();
}