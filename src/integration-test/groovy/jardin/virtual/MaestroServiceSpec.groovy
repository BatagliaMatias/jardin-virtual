package jardin.virtual

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class MaestroServiceSpec extends Specification {

    MaestroService maestroService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Maestro(...).save(flush: true, failOnError: true)
        //new Maestro(...).save(flush: true, failOnError: true)
        //Maestro maestro = new Maestro(...).save(flush: true, failOnError: true)
        //new Maestro(...).save(flush: true, failOnError: true)
        //new Maestro(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //maestro.id
    }

    void "test get"() {
        setupData()

        expect:
        maestroService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Maestro> maestroList = maestroService.list(max: 2, offset: 2)

        then:
        maestroList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        maestroService.count() == 5
    }

    void "test delete"() {
        Long maestroId = setupData()

        expect:
        maestroService.count() == 5

        when:
        maestroService.delete(maestroId)
        sessionFactory.currentSession.flush()

        then:
        maestroService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Maestro maestro = new Maestro()
        maestroService.save(maestro)

        then:
        maestro.id != null
    }
}
