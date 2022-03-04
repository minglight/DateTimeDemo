import org.springframework.beans.factory.annotation.Autowire
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification


@SpringBootTest(classes= Application)
class MainTest extends Specification {

    @Autowired
    private DefaultMapper defaultMapper

    def testSavePerson(){
        given:
            def person = getPerson()
        when:
            def copy = defaultMapper.dedicatedMapperFor(Person.class, Person.class).map(person)
            print "copy="+copy
        then:
            copy.equals(person)
    }

    def getPerson(){
        def inner = new Person2()
        inner.setP5("5")
        inner.setP6(6)
        inner.setP7(Map.of("key", "value"))

        def person = new Person()
        person.setP1("1")
        person.setP2(2)
        person.setP3(List.of("1", 3, 5))
        person.setP4(inner)
    }

}