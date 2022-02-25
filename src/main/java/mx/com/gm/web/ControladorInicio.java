package mx.com.gm.web;

import lombok.extern.slf4j.Slf4j;
import lombok.var;
import mx.com.gm.domain.Persona;
import mx.com.gm.servicio.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private PersonaService personaServise;

    @GetMapping("/")
    public String inicio(Model model) {
        var personas = personaServise.listarPersonas();
        log.info("ejecutando el controlador Spring MVC");
        model.addAttribute("personas", personas);
        return "index";
    }

    //accedemos ala paguina de agregar ala persona 
    @GetMapping("/agregar")
    public String agregar(Persona persona) {
        return "modificar";
    }

    //aca recuperamos "los datos" que nos manda la paguina de agregar
    //para guardarlos ala base
    @PostMapping("/guardar")
    public String guardar(Persona persona) {
        //atraves de la persona servise guardamos los datos que nos manda la paguina
        personaServise.guardar(persona);
        return "redirect:/";
    }

}
