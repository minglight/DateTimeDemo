import ma.glasnost.orika.MapperFactory

import org.springframework.beans.factory.annotation.Autowire
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification


@SpringBootTest(classes= Application)
class MapperFactoryOnlyTest extends Specification {

    @Autowired
    private MapperFactory mapperFactory

    //failed, cannot find the MapperFactory instance
    def testSavePerson(){
        given:
            def inner = new Person2()
            inner.setP5("5")
            inner.setP6(6)
            inner.setP7(Map.of("key", "value"))
        and:
            def person = new Person()
            person.setP1("1")
            person.setP2(2)
            person.setP3(List.of("1", 3, 5))
            person.setP4(inner)
        when:
            def copy = mapperFactory.getMapperFacade(Person, Person)
        .map(person, Person.class)
            print "copy="+copy
        then:
            copy.equals(person)


    }

}