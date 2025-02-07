package fr.afpa.pompey.cda.api;

import fr.afpa.pompey.cda.api.model.Person;
import fr.afpa.pompey.cda.api.repository.PersonRepository;
import fr.afpa.pompey.cda.api.security.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceMockTest {
    /*
     * Dans ce test Mockito, nous utilisons @Mock pour créer un mock de PersonService
     * et @InjectMocks pour injecter ce mock dans PersonController.
     * Ensuite, nous configurons le comportement du mock pour la méthode getPerson afin qu'elle renvoie
     * une Optional contenant une personne fictive lorsque l'ID spécifié est 1.
     * Ensuite, nous appelons la méthode getPerson de PersonController avec l'ID 1
     * et vérifions que la réponse est correcte.
     */

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    public void GetPersonByIdTest() throws Exception {
        Person person = new Person();
        person.setId(1);
        person.setFirstName("John");
        person.setLastName("Doe");

//        Configuration du compoetement du mock pour la methode findById
        when(personRepository.findById(1)).thenReturn(Optional.of(person));

//        Appel de la methode a tester
        Optional<Person> result = personService.getPerson(1);

//        Verfication du resultat
        verify(personRepository, times(1)).findById(1);
        assertThat(result.isPresent()).isTrue();
        assertThat(result.get().getId()).isEqualTo(1);
        assertThat(result.get().getFirstName()).isEqualTo("John");
        assertThat(result.get().getLastName()).isEqualTo("Doe");

    }

}
