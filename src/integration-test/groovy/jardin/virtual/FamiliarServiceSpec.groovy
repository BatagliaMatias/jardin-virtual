package jardin.virtual

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class FamiliarServiceSpec extends Specification {

    FamiliarService familiarService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Familiar(...).save(flush: true, failOnError: true)
        //new Familiar(...).save(flush: true, failOnError: true)
        //Familiar familiar = new Familiar(...).save(flush: true, failOnError: true)
        //new Familiar(...).save(flush: true, failOnError: true)
        //new Familiar(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //familiar.id
    }

    void "test get"() {
        setupData()

        expect:
        familiarService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Familiar> familiarList = familiarService.list(max: 2, offset: 2)

        then:
        familiarList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        familiarService.count() == 5
    }

    void "test delete"() {
        Long familiarId = setupData()

        expect:
        familiarService.count() == 5

        when:
        familiarService.delete(familiarId)
        sessionFactory.currentSession.flush()

        then:
        familiarService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Familiar familiar = new Familiar()
        familiarService.save(familiar)

        then:
        familiar.id != null
    }
}
